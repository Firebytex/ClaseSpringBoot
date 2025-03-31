package com.example.demo.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // Lógica para manejar diferentes tipos de errores
        return "error/404"; // Plantilla personalizada para errores
    }

    public String getErrorPath() {
        return "/error";
    }
}