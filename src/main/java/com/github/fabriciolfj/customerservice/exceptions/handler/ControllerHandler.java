package com.github.fabriciolfj.customerservice.exceptions.handler;

import com.github.fabriciolfj.customerservice.exceptions.InfrastructureException;
import com.github.fabriciolfj.customerservice.exceptions.model.Error;
import com.github.fabriciolfj.customerservice.exceptions.model.ErrorDetails;
import com.github.fabriciolfj.customerservice.exceptions.model.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@RequiredArgsConstructor
public class ControllerHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(InfrastructureException.class)
    public ResponseEntity<ErrorResponse> infrastructureExceptionHandler(final InfrastructureException exception) {
        return ResponseEntity.badRequest()
                .body(new ErrorResponse(exception.getMessage(), HttpStatus.BAD_REQUEST.value()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Error.builder()
                        .code(HttpStatus.BAD_REQUEST.toString())
                        .message("validação dos campos da requisição")
                        .details(mappingError(e))
                        .build());
    }

    private List<ErrorDetails> mappingError(final MethodArgumentNotValidException e) {
        return e.getBindingResult().getAllErrors()
                .stream().map(obj -> {
                    final String message = messageSource.getMessage(obj, LocaleContextHolder.getLocale());
                    final String name;

                    if (obj instanceof FieldError) {
                        name = ((FieldError) obj).getField();
                    } else {
                        name = obj.getObjectName();
                    }

                    return ErrorDetails
                            .builder()
                            .field(name)
                            .message(message)
                            .build();
                }).collect(Collectors.toList());
    }
}
