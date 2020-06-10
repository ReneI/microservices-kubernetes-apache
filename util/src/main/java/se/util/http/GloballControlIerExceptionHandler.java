package se.util.http;


import org.springframework.http.HttpStatus;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import se.util.exception.NotFoundException;

import java.sql.Date;

import static org.springframework.http.HttpStatus.*;
@RestControllerAdvice
public class GloballControlIerExceptionHandler {


    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public @ResponseBody HttpErrorInfo exceptionHandle(ServerHttpRequest serverHttpRequest, Exception ex){
        return  createHttpInfo(NOT_FOUND,serverHttpRequest,ex);

    }

    public @ResponseBody HttpErrorInfo createHttpInfo( HttpStatus httpStatus, ServerHttpRequest serverHttpRequest,Exception ex){
        final  String path= serverHttpRequest.getURI().getPath();
        final  String msg= ex.getMessage();


        return new HttpErrorInfo(path, httpStatus,msg);
    }

}
