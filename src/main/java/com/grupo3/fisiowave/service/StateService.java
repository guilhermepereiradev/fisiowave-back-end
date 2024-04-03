package com.grupo3.fisiowave.service;

import com.grupo3.fisiowave.model.State;
import com.grupo3.fisiowave.repository.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StateService {

    private final StateRepository repository;

    public List<State> findAllStates() {
        return repository.findAll();
    }
}
