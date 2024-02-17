/*
 * package com.khata.onsite.configs;
 * 
 * import java.util.HashMap; import java.util.Map;
 * 
 * import org.springframework.http.HttpHeaders; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.transaction.UnexpectedRollbackException; import
 * org.springframework.web.bind.annotation.ControllerAdvice; import
 * org.springframework.web.bind.annotation.ExceptionHandler; import
 * org.springframework.web.context.request.WebRequest; import
 * org.springframework.web.servlet.mvc.method.annotation.
 * ResponseEntityExceptionHandler;
 * 
 * @ControllerAdvice public class RestResponseEntityExceptionHandler extends
 * ResponseEntityExceptionHandler {
 * 
 * @ExceptionHandler(value = { IllegalArgumentException.class,
 * IllegalStateException.class,UnexpectedRollbackException.class }) protected
 * ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest
 * request) { Map<String, String> myMap = new HashMap<String, String>();
 * myMap.put("code", "409"); myMap.put("message", ""); myMap.put("message",
 * ex.getMessage()); return handleExceptionInternal(ex, myMap, new
 * HttpHeaders(), HttpStatus.CONFLICT, request); } }
 */