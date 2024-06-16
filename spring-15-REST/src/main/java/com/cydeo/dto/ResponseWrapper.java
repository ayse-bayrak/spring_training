package com.cydeo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class ResponseWrapper { // These responseWrapper object what we are gonna see in the API Json
// this is final way
    private boolean success;
    private String message;
    private Integer code;
    private Object data;

    public ResponseWrapper(String message,Object data){
        this.message = message;
        this.data=data;
        this.code= HttpStatus.OK.value();
        this.success=true;
    }

    public ResponseWrapper(String message){
        this.message=message;
        this.code=HttpStatus.OK.value();
        this.success=true;
    }// we need to this constructor when I use deleteMapping for example, I don't need to return any data

}
