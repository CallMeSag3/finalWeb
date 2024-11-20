package com.example.demo.controllers;

import com.example.demo.DTO.ContratoDTO;
import com.example.demo.services.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contratos")
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @GetMapping
    public List<ContratoDTO> getAll() {
        return contratoService.getAll();
    }

    @GetMapping("/{id}")
    public ContratoDTO getById(@PathVariable Long id) {
        return contratoService.getById(id);
    }

    @PostMapping
    public ContratoDTO create(@RequestBody ContratoDTO contratoDTO) {
        return contratoService.create(contratoDTO);
    }

    @PutMapping("/{id}")
    public ContratoDTO update(@PathVariable Long id, @RequestBody ContratoDTO contratoDTO) {
        return contratoService.update(id, contratoDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        contratoService.delete(id);
    }
}
