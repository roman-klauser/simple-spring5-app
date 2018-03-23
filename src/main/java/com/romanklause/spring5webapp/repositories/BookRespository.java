package com.romanklause.spring5webapp.repositories;

import com.romanklause.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRespository extends CrudRepository<Book, Long> {
}
