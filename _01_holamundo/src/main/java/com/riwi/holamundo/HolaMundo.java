package com.riwi.holamundo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*Indica que esta clase será un controlador*/
@Controller

/*RequestMapping crea la ruta base del controlador*/
@RequestMapping("/controller")
public class HolaMundo { 
    /*GetMapping crea una ruta especifica para el metodo */
    @GetMapping("/holamundo")
/* */
    @ResponseBody

    public String mostrarMensaje(){
        return "Hola Mundo";
    };

    @GetMapping("/sumar")
    @ResponseBody

        public Integer sumar(){
            return 5+2;
    }
}
