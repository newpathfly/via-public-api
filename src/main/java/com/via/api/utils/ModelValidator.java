package com.via.api.utils;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import com.via.api.model.Search;
import com.via.api.model.SearchAirlineList;

public class ModelValidator {

    private final Validator _validator;

    public ModelValidator() {
        _validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    public void validate(SearchAirlineList.Request request) {
        validateInternal(request);
    }

    public void validate(SearchAirlineList.Response response) {
        validateInternal(response);
    }

    public void validate(Search.Request request) {
        validateInternal(request);
    }

    public void validate(Search.Response response) {
        validateInternal(response);
    }

    private <T> void validateInternal(T request) {
        Set<ConstraintViolation<T>> violations = _validator.validate(request);
        for (ConstraintViolation<T> violation : violations) {
            if (null != violation)
                throw new IllegalArgumentException(String.format("%s: %s::%s", violation.getMessage(),
                        violation.getLeafBean().getClass().getSimpleName(), violation.getPropertyPath().toString()));
        }
    }
}
