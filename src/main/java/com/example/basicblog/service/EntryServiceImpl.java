package com.example.basicblog.service;

import com.example.basicblog.repository.EntryRepository;
import com.example.basicblog.domain.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
class EntryServiceImpl implements EntryService {
    private EntryRepository entryRepository;

    @Autowired
    public void setEntryRepository(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    @Override
    public List<Entry> getEntries() {
        return this.entryRepository.findAll();
    }
}
