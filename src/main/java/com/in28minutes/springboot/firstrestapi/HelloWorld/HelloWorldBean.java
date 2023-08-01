package com.in28minutes.springboot.firstrestapi.HelloWorld;

public class HelloWorldBean {
    public HelloWorldBean(String message) {
        super();
        this.message = message;
    }
    private String message;
    public String getMessage(){
        return message;
    }

    public String toString(){
        return "HelloWorldBean [message=" +message + "]";
    }


}
