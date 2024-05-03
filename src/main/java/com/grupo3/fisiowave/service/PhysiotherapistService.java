package com.grupo3.fisiowave.service;

import com.grupo3.fisiowave.model.Physiotherapist;
import com.grupo3.fisiowave.repository.PhysiotherapistRepository;
import com.grupo3.fisiowave.service.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PhysiotherapistService {

    private final PhysiotherapistRepository repository;

    private List<Physiotherapist> findAll() {
        return repository.findAll();
    }

    private Physiotherapist findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(String.format("Fisioterapeuta não encontrado para id: %s", id))
                );
    }
}
