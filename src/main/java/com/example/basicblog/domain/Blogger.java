package com.example.basicblog.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Entity
public class Blogger {
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Id
    private @Getter @Setter Long id;
    private @Getter @Setter String name;
    private @Getter @Setter LocalDate birthDate;
    @OneToMany(mappedBy = "blogger")
    private @Getter @Setter List<Entry> entries;
}
