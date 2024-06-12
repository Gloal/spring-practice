package com.gigi.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private static Logger logger = LogManager.getLogger(ResponseEntityExceptionHandler.class);

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorMessage> departmentNotFoundException(DepartmentNotFoundException ex,
                                                                            WebRequest request) {

        //Map<String, String[]> requestParamMap = request.getParameterMap();
        // Log all parameters
        // requestParamMap.forEach(
        //         (key, value) -> logger.info("###RARAMETER Name: " + key + ", Value: " + String.join(", ", value)));

        // String requestParam = null;
        // if (requestParamMap.containsKey("id") && requestParamMap.get("id") != null
        //         && requestParamMap.get("id").length > 0) {
        //     requestParam = requestParamMap.get("id")[0];
        // } else if (requestParamMap.containsKey("stringName") && requestParamMap.get("stringName") != null
        //         && requestParamMap.get("stringName").length > 0) {
        //     requestParam = requestParamMap.get("stringName")[0];
        // }

        ErrorMessage message = new ErrorMessage(HttpStatusCode.valueOf(404) , ex.getMessage());


        return new ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(message);
    }

}
