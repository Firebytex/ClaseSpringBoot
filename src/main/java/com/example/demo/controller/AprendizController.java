package com.example.demo.controller;

import com.example.demo.dao.AprendizDAO;
import com.example.demo.entity.Aprendiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/aprendices")
public class AprendizController {

    @Autowired
    private AprendizDAO aprendizDAO;

    // Listar todos los aprendices
    @GetMapping
    public String listarAprendices(Model model) {
        model.addAttribute("aprendices", aprendizDAO.findAll());
        return "aprendiz/listar";
    }


    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("aprendiz", new Aprendiz());
        return "aprendiz/formulario";
    }


    @PostMapping("/guardar")
    public String guardarAprendiz(@ModelAttribute Aprendiz aprendiz) {
        aprendizDAO.save(aprendiz);
        return "redirect:/aprendices";
    }


    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Aprendiz aprendiz = aprendizDAO.findById(id);
        model.addAttribute("aprendiz", aprendiz);
        return "aprendiz/formulario";
    }


    @GetMapping("/eliminar/{id}")
    public String eliminarAprendiz(@PathVariable Long id) {
        aprendizDAO.delete(id);
        return "redirect:/aprendices";
    }

    // PARA LA API
    @GetMapping("/api-view")
    public String apiView() {
        return "aprendiz/api-consumer";
    }
}