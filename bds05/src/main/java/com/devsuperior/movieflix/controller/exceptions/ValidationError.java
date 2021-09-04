package com.devsuperior.movieflix.controller.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandarError{
    private List<FieldMessage> erros = new ArrayList<>();

    public List<FieldMessage> getErros() {
        return erros;
    }

    public void addError(String fieldName, String message){
        erros.add(new FieldMessage(fieldName, message));
    }
}
