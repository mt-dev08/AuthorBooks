package com.hibernatee.hibernatePrac.service.onetomany;

import com.hibernatee.hibernatePrac.dto.onetomany.books.AddBooksRequestDto;
import com.hibernatee.hibernatePrac.dto.onetomany.books.GetAllBooksResponseDto;
import com.hibernatee.hibernatePrac.dto.onetomany.books.GetBooksResponseDto;
import com.hibernatee.hibernatePrac.entity.onetomany.Author;
import com.hibernatee.hibernatePrac.entity.onetomany.Books;

import java.util.List;

public interface BooksService {

    public List<GetAllBooksResponseDto> getAllBooks();

    public GetBooksResponseDto getBookById(Long id);

    public AddBooksRequestDto createBook(AddBooksRequestDto addBooksRequestDto);

//    public void addBooks(Author author, List<Books> books);
}