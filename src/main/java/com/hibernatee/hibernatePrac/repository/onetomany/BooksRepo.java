package com.hibernatee.hibernatePrac.repository.onetomany;

import com.hibernatee.hibernatePrac.entity.onetomany.Books;
import org.springframework.data.jpa.repository.JpaRepository;



public interface BooksRepo extends JpaRepository<Books,Long> {
}
