package com.example.demo.services;

import com.example.demo.DTO.ContratoDTO;
import com.example.demo.models.Contrato;
import com.example.demo.repository.ContratoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ContratoDTO> getAll() {
        return contratoRepository.findAll().stream()
                .map(contrato -> modelMapper.map(contrato, ContratoDTO.class))
                .collect(Collectors.toList());
    }

    public ContratoDTO getById(Long id) {
        Optional<Contrato> contrato = contratoRepository.findById(id);
        return contrato.map(value -> modelMapper.map(value, ContratoDTO.class)).orElse(null);
    }

    public ContratoDTO create(ContratoDTO contratoDTO) {
        Contrato contrato = modelMapper.map(contratoDTO, Contrato.class);
        contrato = contratoRepository.save(contrato);
        return modelMapper.map(contrato, ContratoDTO.class);
    }

    public ContratoDTO update(Long id, ContratoDTO contratoDTO) {
        Optional<Contrato> contratoOpt = contratoRepository.findById(id);
        if (contratoOpt.isPresent()) {
            Contrato contrato = contratoOpt.get();
            modelMapper.map(contratoDTO, contrato);
            contrato = contratoRepository.save(contrato);
            return modelMapper.map(contrato, ContratoDTO.class);
        }
        throw new RuntimeException("Contrato no encontrado");
    }

    public void delete(Long id) {
        contratoRepository.deleteById(id);
    }
}
