package com.example.basicblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class ErrorPageController implements ErrorController {
    private ErrorAttributes errorAttributes;
    @Autowired
    public void setErrorAttributes(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping("/error")
    public String handleError(HttpServletRequest httpServletRequest) {
        WebRequest webRequest = new ServletWebRequest(httpServletRequest);
        ErrorAttributeOptions errorAttributeOptions = ErrorAttributeOptions.defaults();
        Map<String, Object> errorDetails = this.errorAttributes.getErrorAttributes(webRequest, errorAttributeOptions);

        int status = (int) errorDetails.get("status");


        switch (status) {
            case 404:
                return "404";
            default:
                return "unknownError";
        }
    }
}
