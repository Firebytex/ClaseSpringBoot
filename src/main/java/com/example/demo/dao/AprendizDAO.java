package com.example.demo.dao;

import com.example.demo.entity.Aprendiz;
import com.example.demo.repository.AprendizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AprendizDAO {

    @Autowired
    private AprendizRepository aprendizRepository;

    // Guardar o actualizar aprendiz
    public Aprendiz save(Aprendiz aprendiz) {
        return aprendizRepository.save(aprendiz);
    }

    // Obtener todos los aprendices
    public List<Aprendiz> findAll() {
        return aprendizRepository.findAll();
    }

    // Obtener un aprendiz por ID
    public Aprendiz findById(Long id) {
        return aprendizRepository.findById(id).orElse(null);
    }

    // Eliminar un aprendiz
    public void delete(Long id) {
        aprendizRepository.deleteById(id);
    }
}