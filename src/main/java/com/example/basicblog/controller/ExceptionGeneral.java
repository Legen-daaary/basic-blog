package com.example.basicblog.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionGeneral {
    public String exception(Exception exception, Model model) {
        model.addAttribute("exception", exception);
        return null;
    }
}
