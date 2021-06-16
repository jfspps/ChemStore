package com.chemstore.exception;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.HashMap;
import java.util.Map;

// inform JAX-RS that this is should be available at runtime
@Provider
public class ExceptionMapperConstraintViolation
        implements ExceptionMapper<ConstraintViolationException> {

    // add all violations to a Map and return
    @Override
    public Response toResponse(ConstraintViolationException exc) {

        final Map<String, String> constraintViolations = new HashMap<>();

        for (ConstraintViolation violation : exc.getConstraintViolations()){
            String path = violation.getPropertyPath().toString();
            constraintViolations.put(path, violation.getMessage());
        }

        return Response.status(Response.Status.PRECONDITION_FAILED)
                .entity(constraintViolations).build();
    }
}
