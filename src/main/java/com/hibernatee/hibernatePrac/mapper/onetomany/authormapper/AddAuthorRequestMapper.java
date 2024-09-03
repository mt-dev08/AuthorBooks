package com.hibernatee.hibernatePrac.mapper.onetomany.authormapper;

import com.hibernatee.hibernatePrac.dto.onetomany.author.AddAuthorRequestDto;
import com.hibernatee.hibernatePrac.entity.onetomany.Author;
import org.modelmapper.ModelMapper;

public class AddAuthorRequestMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static AddAuthorRequestDto mapToAuthorDto(Author author) {
        return modelMapper.map(author, AddAuthorRequestDto.class);
    }

    public static Author mapToAuthor(AddAuthorRequestDto addAuthorRequestDto) {
        Author author = modelMapper.map(addAuthorRequestDto, Author.class);
        return author;
    }


}
