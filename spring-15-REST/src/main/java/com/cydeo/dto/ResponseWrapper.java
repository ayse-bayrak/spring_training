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
    //if we want to show anything customized, we need to create our own customized class, what class? we want to be converted by Jackson to show as a Json in the API output.
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
    }// when I use deleteMapping for example, we need to this constructor
    // I don't need to return any data

}
