package com.ykb.spring;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandlerClass {

    @ExceptionHandler(Exception.class)
    // @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorObj> handleExp(final Exception exception) {
        if (exception instanceof IllegalArgumentException) {
            return ResponseEntity.status(800)
                                 .body(new ErrorObj("MyFirst",
                                                    exception.getMessage(),
                                                    10003));
        } else if (exception instanceof MethodArgumentNotValidException) {
            ErrorObj errorObjLoc = new ErrorObj("MyFirst",
                                                "validation error",
                                                10004);
            MethodArgumentNotValidException me = (MethodArgumentNotValidException) exception;
            BindingResult bindingResultLoc = me.getBindingResult();
            List<ObjectError> allErrorsLoc = bindingResultLoc.getAllErrors();
            for (ObjectError objectErrorLoc : allErrorsLoc) {
                errorObjLoc.addError(new ErrorObj("MyFirst",
                                                  objectErrorLoc.getDefaultMessage(),
                                                  10004));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body(errorObjLoc);
        } else if (exception instanceof NullPointerException) {
            ErrorObj errorObjLoc = new ErrorObj("MyFirst",
                                                "Şu anda problem var",
                                                10008);
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                                 .body(errorObjLoc);
        }
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                             .body(new ErrorObj("MyFirst",
                                                exception.getMessage(),
                                                20000));
    }


}
