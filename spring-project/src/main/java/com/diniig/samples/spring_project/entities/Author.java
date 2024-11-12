package com.diniig.samples.spring_project.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "authors")
@NoArgsConstructor
@Data
public class Author {
    @Id
    int id;
    String name;
    @OneToMany(/*fetch = FetchType.EAGER*/)
    @JoinColumn(name = "author_id")
    List<Book> books;
}
