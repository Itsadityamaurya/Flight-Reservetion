package com.SBC.exception;

import com.SBC.dto.ErrorDto;
import org.springframework.boot.web.server.WebServer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.net.PortUnreachableException;
import java.util.Date;

@RestControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ErrorDto> handeExcpection (ResourceNotFound r , WebRequest request){

        ErrorDto errorDto = new ErrorDto(r.getMessage() , new Date() , request.getDescription(true));
    return ResponseEntity.ok(errorDto);
    }
}
