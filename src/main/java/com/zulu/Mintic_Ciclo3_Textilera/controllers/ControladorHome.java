package com.zulu.Mintic_Ciclo3_Textilera.controllers;

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

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
        return "index";
    }
}