package com.hibernatee.hibernatePrac.mapper.onetomany.authormapper;

import com.hibernatee.hibernatePrac.dto.onetomany.author.GetAllAuthorsResponseDto;
import com.hibernatee.hibernatePrac.dto.onetomany.author.GetAuthorResponseDto;
import com.hibernatee.hibernatePrac.entity.onetomany.Author;
import org.modelmapper.ModelMapper;

public class GetAllAuthorResponseMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static GetAllAuthorsResponseDto mapToAuthorDto(Author author) {
        return modelMapper.map(author, GetAllAuthorsResponseDto.class);
    }

    public static Author mapToAuthor(GetAllAuthorsResponseDto getAuthorResponseDto) {
        Author author = modelMapper.map(getAuthorResponseDto, Author.class);
        return author;
    }
}
