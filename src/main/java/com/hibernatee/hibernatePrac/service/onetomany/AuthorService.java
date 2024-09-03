package com.hibernatee.hibernatePrac.service.onetomany;

import com.hibernatee.hibernatePrac.dto.onetomany.author.AddAuthorRequestDto;
import com.hibernatee.hibernatePrac.dto.onetomany.author.GetAllAuthorsResponseDto;
import com.hibernatee.hibernatePrac.dto.onetomany.author.GetAuthorResponseDto;

import java.util.List;

public interface AuthorService {

    public List<GetAllAuthorsResponseDto> getAllAuthors();
    public GetAuthorResponseDto getAuthorById(Long id);
    public AddAuthorRequestDto createAuthor(AddAuthorRequestDto addAuthorRequestDto);
}
