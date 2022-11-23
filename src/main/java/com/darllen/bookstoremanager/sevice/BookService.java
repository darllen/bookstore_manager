package com.darllen.bookstoremanager.sevice;

import com.darllen.bookstoremanager.dto.MessageResponseDTO;
import com.darllen.bookstoremanager.entity.Book;
import com.darllen.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service //sinalizar que vai ser genrenciada pelo spring
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public MessageResponseDTO create(Book book){
        Book savedBook =  bookRepository.save(book);
        return MessageResponseDTO.builder()
                .massage("Book created with ID " + savedBook.getId())
                .build();
    }
}
