package com.example.basicblog.service;

import com.example.basicblog.domain.Entry;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

public interface EntryService {
    List<Entry> getEntries();
    Optional<Entry> getLatest();
    Optional<Entry> getByTitle(@NotBlank String title);
}
