package com.grupo3.fisiowave.dto;

import com.grupo3.fisiowave.model.State;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class StateResponse {

    private UUID id;
    private String name;
    private String acronym;

    public static StateResponse of(State state) {
        return new StateResponse(state.getId(), state.getName(), state.getAcronym());
    }

    public static List<StateResponse> of(List<State> states) {
        return states.stream().map(StateResponse::of).toList();
    }
}
