package com.zulu.Mintic_Ciclo3_Textilera;

import com.zulu.Mintic_Ciclo3_Textilera.entities.*;
import com.zulu.Mintic_Ciclo3_Textilera.repositories.EmpleadoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@SpringBootApplication
@RestController
public class MinticCiclo3TextileraApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinticCiclo3TextileraApplication.class, args);


	}






}
