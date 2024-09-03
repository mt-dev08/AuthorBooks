package com.hibernatee.hibernatePrac.controllers.onetomany;

import com.hibernatee.hibernatePrac.dto.onetomany.books.AddBooksRequestDto;
import com.hibernatee.hibernatePrac.dto.onetomany.books.GetAllBooksResponseDto;
import com.hibernatee.hibernatePrac.dto.onetomany.books.GetBooksResponseDto;
import com.hibernatee.hibernatePrac.service.onetomany.BooksService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/books")
public class BooksController {

    private BooksService booksService;

    @PostMapping("/create")
    public ResponseEntity<AddBooksRequestDto> createBooks(@Valid @RequestBody AddBooksRequestDto addBooksRequestDto){
        AddBooksRequestDto saveAddBooksRequestDto1 =booksService.createBook(addBooksRequestDto);
        return new ResponseEntity<>(saveAddBooksRequestDto1, HttpStatus.CREATED);
    }


    @GetMapping("{id}")
    public ResponseEntity<GetBooksResponseDto> getById(@PathVariable("id") Long id){
        GetBooksResponseDto getBooksResponseDto = booksService.getBookById(id);
        return new ResponseEntity<>(getBooksResponseDto,HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<GetAllBooksResponseDto>> getAll(){
        return new ResponseEntity<>(booksService.getAllBooks(),HttpStatus.OK);
    }
}
