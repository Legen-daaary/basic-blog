package com.example.basicblog.service;

import com.example.basicblog.domain.Entry;

import java.util.List;

public interface EntryService {
    List<Entry> getEntries();
}
