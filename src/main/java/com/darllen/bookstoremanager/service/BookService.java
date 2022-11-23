package com.darllen.bookstoremanager.service;

import com.darllen.bookstoremanager.dto.BookDTO;
import com.darllen.bookstoremanager.dto.MessageResponseDTO;
import com.darllen.bookstoremanager.entity.Book;
import com.darllen.bookstoremanager.mapper.BookMapper;
import com.darllen.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //sinalizar que vai ser genrenciada pelo spring
public class BookService {

    private BookRepository bookRepository;

    private final BookMapper bookMapper = BookMapper.INSTANCE;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public MessageResponseDTO create(BookDTO bookDTO){
        Book bookToSave = BookMapper.toModel(bookDTO);

        Book savedBook =  bookRepository.save(bookDTO);
        return MessageResponseDTO.builder()
                .massage("Book created with ID " + savedBook.getId())
                .build();
    }
}
