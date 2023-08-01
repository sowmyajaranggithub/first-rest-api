package com.in28minutes.springboot.firstrestapi.HelloWorld;

import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class HelloWorldResource {
    @RequestMapping("/hello-world")
    public String helloworld(){
        return "Hello World";
    }


    @RequestMapping("/hello-world-path-param/{name}")
    public HelloWorldBean helloWorldpathparam(@PathVariable String name){
        return new HelloWorldBean("Hello World," + name);
    }
    @RequestMapping("/hello-world-path-param/{name}/message/{message}")
    public HelloWorldBean helloWorldMultiplepathparam(@PathVariable String name,
               @PathVariable String message){
        return new HelloWorldBean("Hello World" + name+"," + message);
    }
}

