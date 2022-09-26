package com.zulu.Mintic_Ciclo3_Textilera.controllers;


import com.zulu.Mintic_Ciclo3_Textilera.entities.Empleado;
import com.zulu.Mintic_Ciclo3_Textilera.entities.Empresa;
import com.zulu.Mintic_Ciclo3_Textilera.entities.MovimientoDinero;
import com.zulu.Mintic_Ciclo3_Textilera.entities.User;
import com.zulu.Mintic_Ciclo3_Textilera.repositories.MovimientoRepository;
import com.zulu.Mintic_Ciclo3_Textilera.services.EmpleadoService;
import com.zulu.Mintic_Ciclo3_Textilera.services.EmpresaServicio;
import com.zulu.Mintic_Ciclo3_Textilera.services.MovimientoServicio;
import com.zulu.Mintic_Ciclo3_Textilera.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;
import java.util.Optional;



@Controller
public class ControllerFull {
    @Autowired
    EmpresaServicio empresaService;
    @Autowired
    EmpleadoService empleadoService;
    @Autowired
    MovimientoServicio movimientoService;

    UserService userService;

    public ControllerFull(EmpresaServicio empresaService, EmpleadoService empleadoService, MovimientoServicio movimientoService, UserService userService) {
        this.empresaService = empresaService;
        this.empleadoService = empleadoService;
        this.movimientoService = movimientoService;
        this.userService = userService;
    }


    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {

        if (principal != null) {
            User user = this.userService.getOrCreateUser(principal.getClaims());
            model.addAttribute("user", user);
        }
        return "indexlp";
    }

    @GetMapping("/inicio")
    public String showTaskList() {
        return "index";
    }

    //EMPLEADOS
    @GetMapping ("/VerEmpleados")
    public String viewEmpleados(Model model, @ModelAttribute("mensaje") String mensaje){
        List<Empleado> listaEmpleados=empleadoService.getAllEmpleado();
        model.addAttribute("emplist",listaEmpleados);
        model.addAttribute("mensaje",mensaje);
        return "users"; //Llamamos al HTML
    }

    @GetMapping("/AgregarEmpleado")
    public String nuevoEmpleado(Model model, @ModelAttribute("mensaje") String mensaje){
        Empleado empl= new Empleado();
        model.addAttribute("empl",empl);
        model.addAttribute("mensaje",mensaje);
        List<Empresa> listaEmpresas= empresaService.getAllEmpresa();
        model.addAttribute("emprelist",listaEmpresas);
        return "addusers"; //Llamar HTML
    }

    @PostMapping("/GuardarEmpleado")
    public String guardarEmpleado(Empleado empl, RedirectAttributes redirectAttributes){
        String passEncriptada=passwordEncoder().encode(empl.getPassword());
        empl.setPassword(passEncriptada);
        if(empleadoService.saveOrUpdateEmpleado(empl)==true){
            redirectAttributes.addFlashAttribute("mensaje","saveOK");
            return "redirect:/VerEmpleados";
        }
        redirectAttributes.addFlashAttribute("mensaje","saveError");
        return "redirect:/AgregarEmpleado";
    }

    @GetMapping("/EditarEmpleado/{id}")
    public String editarEmpleado(Model model, @PathVariable Integer id, @ModelAttribute("mensaje") String mensaje){
        Empleado empl=empleadoService.getEmpleadoById(id);
        //Creamos un atributo para el modelo, que se llame igualmente empl y es el que ira al html para llenar o alimentar campos
        model.addAttribute("empl",empl);
        model.addAttribute("mensaje", mensaje);
        List<Empresa> listaEmpresas= empresaService.getAllEmpresa();
        model.addAttribute("emprelist",listaEmpresas);
        return "modusers";
    }

    @PostMapping("/ActualizarEmpleado")
    public String updateEmpleado(@ModelAttribute("empl") Empleado empl, RedirectAttributes redirectAttributes){
        Integer id=empl.getId(); //Sacamos el id del objeto empl
        String Oldpass=empleadoService.getEmpleadoById(id).getPassword(); //Con ese id consultamos la contraseña que ya esta en la base
        if(!empl.getPassword().equals(Oldpass)){
            String passEncriptada= passwordEncoder().encode(empl.getPassword());
            empl.setPassword(passEncriptada);
        }
        if(empleadoService.saveOrUpdateEmpleado(empl)){
            redirectAttributes.addFlashAttribute("mensaje","updateOK");
            return "redirect:/VerEmpleados";
        }
        redirectAttributes.addFlashAttribute("mensaje","updateError");
        return "redirect:/EditarEmpleado/"+empl.getId();

    }

    @GetMapping("/EliminarEmpleado/{id}")
    public String eliminarEmpleado(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        if (empleadoService.deleteEmpleado(id)){
            redirectAttributes.addFlashAttribute("mensaje","deleteOK");
            return "redirect:/VerEmpleados";
        }
        redirectAttributes.addFlashAttribute("mensaje", "deleteError");
        return "redirect:/VerEmpleados";
    }

    @GetMapping("/Empresa/{id}/Empleados") //Filtrar los empleados por empresa
    public String verEmpleadosPorEmpresa(@PathVariable("id") Integer id, Model model){
        List<Empleado> listaEmpleados = empleadoService.obtenerPorEmpresa(id);
        model.addAttribute("emplist",listaEmpleados);
        return "users"; //Llamamos al html con el emplelist de los empleados filtrados
    }



    //EMPRESAS
    @GetMapping ("/VerEmpresas")
    public String viewEmpresas(Model model, @ModelAttribute("mensaje") String mensaje){
        List<Empresa> listaEmpresas=empresaService.getAllEmpresa();
        model.addAttribute("emprelist",listaEmpresas);
        model.addAttribute("mensaje",mensaje);
        return "enterprises"; //Llamamos al HTML
        }

    @GetMapping("/AgregarEmpresa")
    public String nuevoEmpresas(Model model, @ModelAttribute("mensaje") String mensaje){
        Empresa empr= new Empresa();
        model.addAttribute("empr",empr);
        model.addAttribute("mensaje",mensaje);
/*        List<Empresa> listaEmpresas= empresaService.getAllEmpresa();
        model.addAttribute("emprelist",listaEmpresas);*/
        return "addenterprises"; //Llamar HTML
        }

    @PostMapping("/GuardarEmpresa")
    public String guardarEmpresa(Empresa empr, RedirectAttributes redirectAttributes){

        if(empresaService.saveOrUpdateEmpresa(empr)==true){
        redirectAttributes.addFlashAttribute("mensaje","saveOK");
        return "redirect:/VerEmpresas";
        }
        redirectAttributes.addFlashAttribute("mensaje","saveError");
        return "redirect:/AgregarEmpresa";
        }

    @GetMapping("/EditarEmpresa/{id}")
    public String editarEmpresa(Model model, @PathVariable Integer id, @ModelAttribute("mensaje") String mensaje){
        Empresa empr=empresaService.getEmpresaById(id);
        //Creamos un atributo para el modelo, que se llame igualmente empl y es el que ira al html para llenar o alimentar campos
        model.addAttribute("empr",empr);
        model.addAttribute("mensaje", mensaje);
        /*List<Empresa> listaEmpresas= empresaService.getAllEmpresa();
        model.addAttribute("emprelist",listaEmpresas);*/
        return "modenterprises";
    }

    @PostMapping("/ActualizarEmpresa")
    public String updateEmpresa(@ModelAttribute("empl") Empresa empr, RedirectAttributes redirectAttributes){
        Integer id=empr.getId(); //Sacamos el id del objeto empl
        String Oldpass=empleadoService.getEmpleadoById(id).getPassword(); //Con ese id consultamos la contraseña que ya esta en la base
        /*if(!empr.getPassword().equals(Oldpass)){
            String passEncriptada= passwordEncoder();.encode(empr.getPassword());
            empr.setPassword(passEncriptada);*/

        if(empresaService.saveOrUpdateEmpresa(empr)){
            redirectAttributes.addFlashAttribute("mensaje","updateOK");
            return "redirect:/VerEmpresas";
        }
        redirectAttributes.addFlashAttribute("mensaje","updateError");
        return "redirect:/EditarEmpresa/"+empr.getId();

    }

    @GetMapping("/EliminarEmpresa/{id}")
    public String eliminarEmpresa(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        if (empresaService.deleteEmpresa(id)){
        redirectAttributes.addFlashAttribute("mensaje","deleteOK");
        return "redirect:/VerEmpresas";
        }
        redirectAttributes.addFlashAttribute("mensaje", "deleteError");
        return "redirect:/VerEmpresas";
        }
    //MOVIMIENTOS
    @GetMapping ("/VerMovimientos")
    public String viewMovimientos(Model model, @ModelAttribute("mensaje") String mensaje){
        List<MovimientoDinero> listaMovimientos=movimientoService.getAllMovimiento();
        model.addAttribute("movilist",listaMovimientos);
        model.addAttribute("mensaje",mensaje);
        return "movements"; //Llamamos al HTML
    }

    @GetMapping("/AgregarMovimiento")
    public String nuevoMovimiento(Model model, @ModelAttribute("mensaje") String mensaje){
        MovimientoDinero movi= new MovimientoDinero();
        model.addAttribute("movi",movi);
        model.addAttribute("mensaje",mensaje);
        List<Empleado> listaEmpleado= empleadoService.getAllEmpleado();
        model.addAttribute("emplist",listaEmpleado);
        return "addmovements"; //Llamar HTML
    }

    @PostMapping("/GuardarMovimiento")
    public String guardarMovimiento(MovimientoDinero movi, RedirectAttributes redirectAttributes){
        /*String passEncriptada=passwordEncoder().encode(movi.getPassword());
        movi.setPassword(passEncriptada);*/
        if(movimientoService.saveOrUpdateMovimiento(movi)==true){
            redirectAttributes.addFlashAttribute("mensaje","saveOK");
            return "redirect:/VerMovimientos";
        }
        redirectAttributes.addFlashAttribute("mensaje","saveError");
        return "redirect:/AgregarMovimiento";
    }

    @GetMapping("/EditarMovimiento/{id}")
    public String editarMovimiento(Model model, @PathVariable Integer id, @ModelAttribute("mensaje") String mensaje){
        MovimientoDinero movi=movimientoService.getMovimientoById(id);
        //Creamos un atributo para el modelo, que se llame igualmente empl y es el que ira al html para llenar o alimentar campos
        model.addAttribute("movi",movi);
        model.addAttribute("mensaje", mensaje);
        List<Empleado> listaEmpleado= empleadoService.getAllEmpleado();
        model.addAttribute("emplist",listaEmpleado);
        return "modmovements";
    }

    @PostMapping("/ActualizarMovimiento")
    public String updateMovimiento(@ModelAttribute("movi") MovimientoDinero movi, RedirectAttributes redirectAttributes){
        Integer id=movi.getTransactionID(); //Sacamos el id del objeto empl
        /*String Oldpass=movimientoService.getMovimientoById(id).getPassword(); //Con ese id consultamos la contraseña que ya esta en la base
        if(!movi.getPassword().equals(Oldpass)){
            String passEncriptada= passwordEncoder().encode(movi.getPassword());
            movi.setPassword(passEncriptada);
        }*/
        if(movimientoService.saveOrUpdateMovimiento(movi)){
            redirectAttributes.addFlashAttribute("mensaje","updateOK");
            return "redirect:/VerMovimientos";
        }
        redirectAttributes.addFlashAttribute("mensaje","updateError");
        return "redirect:/EditarMovimientos/"+movi.getTransactionID();

    }

    @GetMapping("/EliminarMovimiento/{id}")
    public String eliminarMovimiento(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        if (movimientoService.deleteMovimiento(id)){
            redirectAttributes.addFlashAttribute("mensaje","deleteOK");
            return "redirect:/VerMovimientos";
        }
        redirectAttributes.addFlashAttribute("mensaje", "deleteError");
        return "redirect:/VerMovimientos";
    }

    @GetMapping("/Empleado/{id}/Movimientos") //Filtrar los movimientos por empleado
    public String verMovimientosPorEmpleado(@PathVariable("id") Integer id, Model model){
        List<MovimientoDinero> listaMovimientos = movimientoService.obtenerPorEmpleado(id);
        model.addAttribute("movilist",listaMovimientos);
        return "movements"; //Llamamos al html con el movilist de los movimientos filtrados
    }




    //Controlador que me lleva al template de No autorizado
    @RequestMapping(value="/Denegado")
    public String accesoDenegado(){
        return "accessDenied";
    }


    //Metodo para encriptar contraseñas
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
