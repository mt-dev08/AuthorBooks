package com.hibernatee.hibernatePrac.dto.onetomany.author;

import com.hibernatee.hibernatePrac.dto.onetomany.books.AddBooksRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddAuthorRequestDto {
//    private Long id;

    @NotNull(message = "Name cannot be null")
    private String name;
    private List<AddBooksRequestDto> booksList;
}