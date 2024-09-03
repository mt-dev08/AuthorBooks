package com.hibernatee.hibernatePrac.controllers.onetomany;

import com.hibernatee.hibernatePrac.dto.onetomany.author.AddAuthorRequestDto;
import com.hibernatee.hibernatePrac.dto.onetomany.author.GetAllAuthorsResponseDto;
import com.hibernatee.hibernatePrac.dto.onetomany.author.GetAuthorResponseDto;
import com.hibernatee.hibernatePrac.service.onetomany.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/author")
public class AuthorController {
    private AuthorService authorService;

    @PostMapping("/create")
    public ResponseEntity<AddAuthorRequestDto> createAuthor(@Valid @RequestBody AddAuthorRequestDto addAuthorRequestDto){
        AddAuthorRequestDto saveAddAuthorRequestDto=authorService.createAuthor(addAuthorRequestDto);
        return new ResponseEntity<>(saveAddAuthorRequestDto, HttpStatus.CREATED);
    }


    @GetMapping("{id}")
    public ResponseEntity<GetAuthorResponseDto> getById(@PathVariable("id") Long id){
        GetAuthorResponseDto getAuthorDto = authorService.getAuthorById(id);
        return new ResponseEntity<>(getAuthorDto,HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<GetAllAuthorsResponseDto>> getAll(){
        return new ResponseEntity<>(authorService.getAllAuthors(),HttpStatus.OK);
    }
}
