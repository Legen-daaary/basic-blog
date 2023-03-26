package com.example.basicblog.controller;
import com.example.basicblog.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private EntryService entryService;
    @Autowired
    public void setEntryService(EntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping("/")
    public String entries(Model model) {
        model.addAttribute("pageTitle", "Blog");
        model.addAttribute("entries", this.entryService.getEntries());
        return "entries";
    }
}
