package com.hibernatee.hibernatePrac.mapper.onetomany.booksmapper;

import com.hibernatee.hibernatePrac.dto.onetomany.author.GetAuthorResponseDto;
import com.hibernatee.hibernatePrac.dto.onetomany.books.GetAllBooksResponseDto;
import com.hibernatee.hibernatePrac.dto.onetomany.books.GetBooksResponseDto;
import com.hibernatee.hibernatePrac.entity.onetomany.Author;
import com.hibernatee.hibernatePrac.entity.onetomany.Books;
import com.hibernatee.hibernatePrac.exception.ResourceNotFound;
import com.hibernatee.hibernatePrac.repository.onetomany.AuthorRepo;
import org.modelmapper.ModelMapper;

public class GetBooksResponseMapper {
    private static AuthorRepo authorRepo;
    private static final ModelMapper modelMapper = new ModelMapper();

    public static GetBooksResponseDto mapToBooksDto(Books books) {
        return modelMapper.map(books, GetBooksResponseDto.class);
    }

    public static Books mapToBooks(GetBooksResponseDto getBooksResponseDto) {
        Books books = modelMapper.map(getBooksResponseDto, Books.class);
        if (getBooksResponseDto.getAuthorId() != null) {
            Author author = authorRepo.findById(getBooksResponseDto.getAuthorId())
                    .orElseThrow(() -> new ResourceNotFound("Author not found with ID: " + getBooksResponseDto.getAuthorId()));
            books.setAuthor(author);
        }
        return books;
    }
}
