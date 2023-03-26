package com.example.basicblog.controller;
import com.example.basicblog.domain.Entry;
import com.example.basicblog.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.NoSuchElementException;

@Controller
@RequestMapping("/entry")
public class EntryController {
    private EntryService entryService;
    @Autowired
    public void setEntryService(EntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping("")
    public String entries(Model model) {
        model.addAttribute("pageTitle", "Blog");
        model.addAttribute("entries", this.entryService.getEntries());
        return "entries";
    }

    @GetMapping("/latest")
    public String latest(Model model) {
        model.addAttribute("pageTitle", "Blog");
        try {
            Entry latest = this.entryService.getLatest().get();
            model.addAttribute("entry", latest);
            return "entry";
        } catch (NoSuchElementException noSuchElementException) {
            return "404";
        }
    }

    @GetMapping("/title/{title}")
    public String title(@PathVariable(value = "title") String title, Model model) {
        model.addAttribute("pageTitle", "Blog");
        try {
            Entry latest = this.entryService.getByTitle(title).get();
            model.addAttribute("entry", latest);
            return "entry";
        } catch (NoSuchElementException noSuchElementException) {
            return "404";
        }
    }
}
