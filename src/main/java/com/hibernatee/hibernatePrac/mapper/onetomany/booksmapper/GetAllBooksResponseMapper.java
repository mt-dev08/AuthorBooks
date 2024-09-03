package com.hibernatee.hibernatePrac.mapper.onetomany.booksmapper;

import com.hibernatee.hibernatePrac.dto.onetomany.author.GetAllAuthorsResponseDto;
import com.hibernatee.hibernatePrac.dto.onetomany.books.AddBooksRequestDto;
import com.hibernatee.hibernatePrac.dto.onetomany.books.GetAllBooksResponseDto;
import com.hibernatee.hibernatePrac.entity.onetomany.Author;
import com.hibernatee.hibernatePrac.entity.onetomany.Books;
import org.modelmapper.ModelMapper;

public class GetAllBooksResponseMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static GetAllBooksResponseDto mapToBooksDto(Books books) {
        return modelMapper.map(books, GetAllBooksResponseDto.class);
    }

    public static Books mapToBooks(GetAllBooksResponseDto getAllBooksResponseDto) {
        Books books = modelMapper.map(getAllBooksResponseDto, Books.class);
        return books;
    }
}
