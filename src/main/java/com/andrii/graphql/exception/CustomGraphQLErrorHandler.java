package com.andrii.graphql.exception;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.kickstart.execution.error.GraphQLErrorHandler;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
class CustomGraphQLErrorHandler implements GraphQLErrorHandler {
    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> errors) {
        return errors.stream().map(error -> {
            Map<String, Object> extensions = new HashMap<>();
            extensions.put("my-custom-code", "some-custom-error");
            return GraphqlErrorBuilder.newError()
                    .message("Custom message = " + error.getMessage())
                    .extensions(extensions)
                    .errorType(error.getErrorType())
                    .locations(error.getLocations())
                    .path(error.getPath())
                    .build();
        }).toList();
    }
}
