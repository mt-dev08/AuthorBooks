package com.hibernatee.hibernatePrac.mapper.onetomany.booksmapper;

import com.hibernatee.hibernatePrac.dto.onetomany.author.AddAuthorRequestDto;
import com.hibernatee.hibernatePrac.dto.onetomany.books.AddBooksRequestDto;
import com.hibernatee.hibernatePrac.entity.onetomany.Author;
import com.hibernatee.hibernatePrac.entity.onetomany.Books;
import com.hibernatee.hibernatePrac.exception.ResourceNotFound;
import org.modelmapper.ModelMapper;

public class AddBooksRequestMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static AddBooksRequestDto mapToBooksDto(Books books) {
        return modelMapper.map(books, AddBooksRequestDto.class);
    }

    public static Books mapToBooks(AddBooksRequestDto addBooksRequestDto) {
        Books books = modelMapper.map(addBooksRequestDto, Books.class);
        return books;
    }
}
