package com.zulu.Mintic_Ciclo3_Textilera.controllers;

import com.zulu.Mintic_Ciclo3_Textilera.entities.Empleado;
import com.zulu.Mintic_Ciclo3_Textilera.entities.MovimientoDinero;
import com.zulu.Mintic_Ciclo3_Textilera.entities.User;
import com.zulu.Mintic_Ciclo3_Textilera.services.EmpleadoServicio;
import com.zulu.Mintic_Ciclo3_Textilera.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

/**
 * Controller for the home page.
 */
@Controller
public class ControladorHome {

    UserService userService;
    @Autowired
    EmpleadoServicio empleadoService;

    public ControladorHome(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {

        if (principal != null) {
            User user = this.userService.getOrCreateUser(principal.getClaims());
            model.addAttribute("user", user);
        }
        return "index";
    }

    @GetMapping("/inicio")
    public String showTaskList() {
        return "index";
    }

    @GetMapping("/verempleados")
    public String viewEmpleados(Model model, @ModelAttribute("mensaje") String mensaje) {
        List<Empleado> listaEmpleados = empleadoService.getAllEmpleados();
        model.addAttribute("emplelist", listaEmpleados);
        model.addAttribute("mensaje", mensaje);
        return "users"; //Llamamos al HTML
    }
}
/*    @GetMapping("inicio/qtran")
    public String showTaskList2(){
        return "querytransaction";  }
    @GetMapping("inicio/qtran/tran")
    public String creartran(Model model) {
        model.addAttribute("movimientoDinero", new MovimientoDinero());
        return "createtransaction";  }
    @GetMapping("inicio/qtran/tran")
    public String showTaskList3(){
        return "createtransaction";  }*/
