package com.hibernatee.hibernatePrac.dto.onetomany.books;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBooksResponseDto {
//    private Long id;
    private String title;
    private Long authorId;
}
