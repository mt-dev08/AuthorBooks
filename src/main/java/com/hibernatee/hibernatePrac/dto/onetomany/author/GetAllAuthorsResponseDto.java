package com.hibernatee.hibernatePrac.dto.onetomany.author;

import com.hibernatee.hibernatePrac.entity.onetomany.Books;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllAuthorsResponseDto {
//    private Long id;
    private String name;
    private List<Books> booksList=new ArrayList<>();

}
