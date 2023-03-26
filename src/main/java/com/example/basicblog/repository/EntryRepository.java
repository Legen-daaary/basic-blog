package com.example.basicblog.repository;

import com.example.basicblog.domain.Entry;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EntryRepository extends CrudRepository<Entry, Long> {
    List<Entry> findAll();
    Optional<Entry> findFirstByOrderByPostedDesc();
    Optional<Entry> findByTitle(String title);
}
