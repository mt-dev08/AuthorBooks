package com.hibernatee.hibernatePrac.repository.onetomany;

import com.hibernatee.hibernatePrac.entity.onetomany.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author,Long> {
}
