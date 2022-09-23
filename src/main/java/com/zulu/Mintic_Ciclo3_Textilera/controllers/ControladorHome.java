package com.zulu.Mintic_Ciclo3_Textilera.controllers;

import com.zulu.Mintic_Ciclo3_Textilera.entities.MovimientoDinero;
import com.zulu.Mintic_Ciclo3_Textilera.entities.User;
import com.zulu.Mintic_Ciclo3_Textilera.services.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for the home page.
 */
@Controller
public class ControladorHome {

    UserService userService;

    public ControladorHome(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {

        if(principal != null){
            User user = this.userService.getOrCreateUser(principal.getClaims());
            model.addAttribute("user",user);
        }
        return "indexlp";
    }
    @GetMapping("/inicio")
    public String showTaskList(){
        return "indexgt";  }
    @GetMapping("inicio/qtran")
    public String showTaskList2(){
        return "querytransaction";  }
    @GetMapping("inicio/qtran/tran")
    public String creartran(Model model) {
        model.addAttribute("movimientoDinero", new MovimientoDinero());
        return "createtransaction";  }
/*    @GetMapping("inicio/qtran/tran")
    public String showTaskList3(){
        return "createtransaction";  }*/
}