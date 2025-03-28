package br.com.springbookstore.handler;

import br.com.springbookstore.errors.ApiError;
import br.com.springbookstore.exception.BookNotFoundException;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ApiError> bookNotFoundException(RuntimeException ex){
        ApiError error = ApiError.builder()
                .code(NOT_FOUND.value())
                .status(NOT_FOUND.name())
                .timestamp(LocalDateTime.now())
                .messages(List.of(ex.getMessage()))
                .build();

        return ResponseEntity.status(NOT_FOUND).body(error);
    }


}
