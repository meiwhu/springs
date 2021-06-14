package com.example.caching_data_with_spring;

public interface BookRepository {
    Book getByIsbn(String isbn);
}
