package com.senai.integrador.entities;

import com.senai.integrador.enums.Genre;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Entity
@Table(name = "books")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;
    private double price;
    private String synopsis;
    private String author;
    private String publisher;
    private String language;
    private int pageCount;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    private Genre genre;


    private int raking;
    private String createAt = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDateTime.now());
    private String stockDate;
}

