package com.companyname.springbootcrudrest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IndexController implements ErrorController {

    @RequestMapping("/error")
    @ResponseBody
    public ResponseEntity<List<String>> errorMessage() {
        List<String> errorMessage = new ArrayList<>();
        errorMessage.add("This is an error: " + HttpStatus.NOT_FOUND.toString());
        errorMessage.add("Please try http://localhost:8080/api/v1/users");
        return new ResponseEntity(errorMessage, HttpStatus.NOT_FOUND);
    }
    @Override
    public String getErrorPath() {
        return "/error";
    }
}