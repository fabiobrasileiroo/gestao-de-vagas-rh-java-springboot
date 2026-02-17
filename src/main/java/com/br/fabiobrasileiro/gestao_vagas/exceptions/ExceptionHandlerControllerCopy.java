// package com.br.fabiobrasileiro.gestao_vagas.exceptions;

// import java.util.ArrayList;
// import java.util.List;

// import org.springframework.context.MessageSource;
// import org.springframework.context.i18n.LocaleContextHolder;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.http.converter.HttpMessageNotReadableException;
// import org.springframework.web.bind.MethodArgumentNotValidException;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.RestControllerAdvice;

// @RestControllerAdvice
// public class ExceptionHandlerControllerCopy {

// private final MessageSource messageSource;

// public ExceptionHandlerController(MessageSource message) {
// this.messageSource = message;
// }

// @ExceptionHandler(MethodArgumentNotValidException.class)
// public ResponseEntity<List<ErrorMessageDTO>>
// handlerMethodArgumentNotValidException(
// MethodArgumentNotValidException e) {
// List<ErrorMessageDTO> dto = new ArrayList<>();

// e.getBindingResult().getFieldErrors().forEach(err -> {
// String message = messageSource.getMessage(err,
// LocaleContextHolder.getLocale());
// ErrorMessageDTO error = new ErrorMessageDTO(message, err.getField());
// dto.add(error);
// });

// return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
// }

// @ExceptionHandler(HttpMessageNotReadableException.class)
// public ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(
// HttpMessageNotReadableException e) {
// var error = new ErrorResponse("JSON inválido no corpo da requisição",
// HttpStatus.BAD_REQUEST.value());
// return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
// }

// @ExceptionHandler(Exception.class)
// public ResponseEntity<ErrorResponse> handleGenericException(Exception e) {
// var error = new ErrorResponse(e.getMessage(),
// HttpStatus.INTERNAL_SERVER_ERROR.value());
// return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
// }
// }
