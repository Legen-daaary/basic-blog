package com.example.basicblog.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
public class Entry {
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Id
    private  @Getter @Setter Long id;
    private @Getter @Setter @Accessors(chain = true) String title;
    private @Getter @Setter @Accessors(chain = true) String content;
    private @Getter @Setter @Accessors(chain = true) LocalDateTime posted;
    @ManyToOne
    private @Getter @Setter @Accessors(chain = true) Blogger blogger;

    @Override
    public String toString() {
        return "Person{" +
                "title='" + title + '\'' +
                '}';
    }
}
