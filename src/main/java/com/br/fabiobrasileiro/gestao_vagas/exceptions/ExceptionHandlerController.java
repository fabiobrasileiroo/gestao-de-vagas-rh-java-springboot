package com.br.fabiobrasileiro.gestao_vagas.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

  private final MessageSource messageSource;

  public ExceptionHandlerController(MessageSource message) {
    this.messageSource = message;
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<List<ErrorMessageDTO>> handlerMethodArgumentNotValidException(
      MethodArgumentNotValidException e) {
    List<ErrorMessageDTO> dto = new ArrayList<>();

    e.getBindingResult().getFieldErrors().forEach(err -> {
      String message = messageSource.getMessage(err, LocaleContextHolder.getLocale());
      ErrorMessageDTO error = new ErrorMessageDTO(message, err.getField());
      dto.add(error);
    });

    return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<List<ErrorMessageDTO>> handleHttpMessageNotReadableException(
      HttpMessageNotReadableException e) {
    List<ErrorMessageDTO> dto = new ArrayList<>();
    dto.add(new ErrorMessageDTO("JSON inválido no corpo da requisição", "requestBody"));
    return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
  }
}
