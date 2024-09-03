package com.hibernatee.hibernatePrac.entity.onetomany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Books> booksList=new ArrayList<>();


    public void setBooksList(List<Books> booksList) {
        this.booksList = booksList;
        if (booksList != null) {
            booksList.forEach(book -> book.setAuthor(this));
        }
    }



}
