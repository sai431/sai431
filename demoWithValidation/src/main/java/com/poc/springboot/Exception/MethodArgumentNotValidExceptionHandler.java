/*
 * package com.poc.springboot.Exception;
 * 
 * import java.util.List;
 * 
 * import org.springframework.core.Ordered; import
 * org.springframework.core.annotation.Order; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.validation.BindingResult; import
 * org.springframework.web.bind.MethodArgumentNotValidException; import
 * org.springframework.web.bind.annotation.ControllerAdvice; import
 * org.springframework.web.bind.annotation.ExceptionHandler; import
 * org.springframework.web.bind.annotation.ResponseBody; import
 * org.springframework.web.bind.annotation.ResponseStatus;
 * 
 * @Order(Ordered.HIGHEST_PRECEDENCE)
 * 
 * @ControllerAdvice public class MethodArgumentNotValidExceptionHandler {
 * 
 * @ResponseStatus(value = HttpStatus.BAD_REQUEST)
 * 
 * @ResponseBody
 * 
 * @ExceptionHandler(MethodArgumentNotValidException.class) public Error
 * methodArgumentNotValidException(MethodArgumentNotValidException ex) {
 * BindingResult result = ex.getBindingResult();
 * List<org.springframework.validation.FieldError> fieldErrors =
 * result.getFieldErrors(); return processFieldErrors(fieldErrors); }
 * 
 * private Error
 * processFieldErrors(List<org.springframework.validation.FieldError>
 * fieldErrors) { Error error = new Error("bad Request", "validation error");
 * for (org.springframework.validation.FieldError fieldError: fieldErrors) {
 * error.addFieldError(fieldError.getField(), fieldError.getDefaultMessage()); }
 * return error; }
 * 
 * 
 * 
 * static class Error { private final int status; private final String message;
 * private List<FieldError> fieldErrors = new ArrayList<>();
 * 
 * Error(int status, String message) { this.status = status; this.message =
 * message; }
 * 
 * public int getStatus() { return status; }
 * 
 * public String getMessage() { return message; }
 * 
 * public void addFieldError(String path, String message) { FieldError error =
 * new FieldError(path, message); fieldErrors.add(error); }
 * 
 * public List<FieldError> getFieldErrors() { return fieldErrors; } }
 * 
 * 
 * }
 */