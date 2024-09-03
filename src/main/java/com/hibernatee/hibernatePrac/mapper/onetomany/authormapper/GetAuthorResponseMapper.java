package com.hibernatee.hibernatePrac.mapper.onetomany.authormapper;

import com.hibernatee.hibernatePrac.dto.onetomany.author.AddAuthorRequestDto;
import com.hibernatee.hibernatePrac.dto.onetomany.author.GetAuthorResponseDto;
import com.hibernatee.hibernatePrac.entity.onetomany.Author;
import org.modelmapper.ModelMapper;

public class GetAuthorResponseMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static GetAuthorResponseDto mapToAuthorDto(Author author) {
        return modelMapper.map(author, GetAuthorResponseDto.class);
    }

    public static Author mapToAuthor(GetAuthorResponseDto getAuthorResponseDto) {
        Author author = modelMapper.map(getAuthorResponseDto, Author.class);
        return author;
    }
}
