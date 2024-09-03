package com.hibernatee.hibernatePrac.dto.onetomany.books;

import com.hibernatee.hibernatePrac.entity.onetomany.Books;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddBooksRequestDto {
//    private Long id;

    @NotNull(message = "Title cannot be null")
    private String title;
    private Long authorId;

}