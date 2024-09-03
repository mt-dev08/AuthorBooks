package com.hibernatee.hibernatePrac.service.onetomany;

import com.hibernatee.hibernatePrac.dto.onetomany.books.AddBooksRequestDto;

import com.hibernatee.hibernatePrac.dto.onetomany.books.GetAllBooksResponseDto;
import com.hibernatee.hibernatePrac.dto.onetomany.books.GetBooksResponseDto;
import com.hibernatee.hibernatePrac.entity.onetomany.Author;
import com.hibernatee.hibernatePrac.entity.onetomany.Books;
import com.hibernatee.hibernatePrac.exception.ResourceNotFound;

import com.hibernatee.hibernatePrac.mapper.onetomany.booksmapper.AddBooksRequestMapper;
import com.hibernatee.hibernatePrac.mapper.onetomany.booksmapper.GetAllBooksResponseMapper;
import com.hibernatee.hibernatePrac.mapper.onetomany.booksmapper.GetBooksResponseMapper;
import com.hibernatee.hibernatePrac.repository.onetomany.BooksRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BooksServiceImpl implements BooksService{

    private BooksRepo booksRepo;

    @Override
    public List<GetAllBooksResponseDto> getAllBooks() {
        List<Books> books=booksRepo.findAll();
        return books.stream()
                .map(GetAllBooksResponseMapper::mapToBooksDto)// this is method refrence but we can also use lambda expression here
                .collect(Collectors.toList());
    }

    @Override
    public GetBooksResponseDto getBookById(Long id) {
        Books books = booksRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFound("Book does not exit" + id));
        return GetBooksResponseMapper.mapToBooksDto(books);
    }

    @Override
    @Transactional
    public AddBooksRequestDto createBook(AddBooksRequestDto addBooksRequestDto) {
        Books books=AddBooksRequestMapper.mapToBooks(addBooksRequestDto);
        Books savedBooks=booksRepo.save(books);
        return AddBooksRequestMapper.mapToBooksDto(savedBooks);
    }

}
