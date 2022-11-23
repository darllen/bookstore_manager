package com.darllen.bookstoremanager.controller;

import com.darllen.bookstoremanager.dto.BookDTO;
import com.darllen.bookstoremanager.dto.MessageResponseDTO;
import com.darllen.bookstoremanager.entity.Book;
import com.darllen.bookstoremanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //essa classe para o spring vai representar um controller, onde vai ser uma API Rest
@RequestMapping("/api/v1/books") //é preciso indicar o endpoint que vai fazer acesso a este controller
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //preciso fazer a injeção de dependência atravez de anotações do spring
    @Autowired // para fazer a injeção de dependencia de um atributo da classe repository para uso dentro dessa classe aqui



    @PostMapping // junto com oq vai ser passado na requisição, vão ser responsáveis por
    public MessageResponseDTO create(@RequestBody @Validated BookDTO bookDTO){
        return bookService.create(bookDTO);
    }

}
