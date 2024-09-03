package com.hibernatee.hibernatePrac.service.onetomany;

import com.hibernatee.hibernatePrac.dto.onetomany.author.AddAuthorRequestDto;
import com.hibernatee.hibernatePrac.dto.onetomany.author.GetAllAuthorsResponseDto;
import com.hibernatee.hibernatePrac.dto.onetomany.author.GetAuthorResponseDto;
import com.hibernatee.hibernatePrac.dto.onetomany.books.AddBooksRequestDto;
import com.hibernatee.hibernatePrac.entity.onetomany.Author;
import com.hibernatee.hibernatePrac.entity.onetomany.Books;
import com.hibernatee.hibernatePrac.exception.ResourceNotFound;
import com.hibernatee.hibernatePrac.mapper.onetomany.authormapper.AddAuthorRequestMapper;
import com.hibernatee.hibernatePrac.mapper.onetomany.authormapper.GetAllAuthorResponseMapper;
import com.hibernatee.hibernatePrac.mapper.onetomany.authormapper.GetAuthorResponseMapper;
import com.hibernatee.hibernatePrac.repository.onetomany.AuthorRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService{

    private AuthorRepo authorRepo;

    @Override
    public List<GetAllAuthorsResponseDto> getAllAuthors() {
        List<Author> authors=authorRepo.findAll();
        return authors.stream()
                .map(GetAllAuthorResponseMapper::mapToAuthorDto) // this is method refrence but we can also use lambda expression here
                .collect(Collectors.toList());
    }

    @Override
    public GetAuthorResponseDto getAuthorById(Long id) {
        Author author = authorRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFound("Author does not exit" + id));
        return GetAuthorResponseMapper.mapToAuthorDto(author);
    }

    @Override
    @Transactional
    public AddAuthorRequestDto createAuthor(AddAuthorRequestDto addAuthorRequestDto) {

        Author author = new Author();
        author.setName(addAuthorRequestDto.getName());
        // Loop through each book DTO and map it to the Books entity
        for (AddBooksRequestDto bookDto : addAuthorRequestDto.getBooksList()) {
            Books book = new Books();
            book.setTitle(bookDto.getTitle());
            book.setAuthor(author);  // Set the author in the Books entity
            author.getBooksList().add(book);  // Add the book to the author's collection
        }
        // Save the author (this will cascade and save the books as well)
        Author savedAuthor = authorRepo.save(author);
        return AddAuthorRequestMapper.mapToAuthorDto(savedAuthor);
    }

}
