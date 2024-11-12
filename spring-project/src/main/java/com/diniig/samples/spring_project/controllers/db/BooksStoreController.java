package com.diniig.samples.spring_project.controllers.db;

import com.diniig.samples.spring_project.entities.Author;
import com.diniig.samples.spring_project.entities.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(path = "/api/v1")
public class BooksStoreController {
        @Autowired
    private EntityManagerFactory entityManagerFactory;

    @RequestMapping(method = RequestMethod.POST, path = "/authors")
    public ResponseEntity<String> getAuthors() {
        Optional<Author> author = Optional.empty();

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            author = Optional.ofNullable(entityManager.find(Author.class, 1));
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }

        author.ifPresent(t -> {
            List<Book> books = t.getBooks(); //LazyInitializationException
            log.info("books {}", books);
        });
        

        return ResponseEntity.ok("Hello world");
    }
}
