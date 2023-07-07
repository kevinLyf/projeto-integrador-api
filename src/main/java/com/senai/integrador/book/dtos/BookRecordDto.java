package com.senai.integrador.book.dtos;

import com.senai.integrador.book.enums.Genre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BookRecordDto(@NotBlank String image, @NotBlank String title, @NotNull double price,
        @NotBlank String synopsis, @NotBlank String language, @NotNull int pageCount, @NotNull Genre genre,
        @NotBlank String author, @NotBlank String publisher, @NotBlank String stockDate, @NotNull double rating) {
}
