package com.darllen.bookstoremanager.mapper;

import com.darllen.bookstoremanager.dto.BookDTO;
import com.darllen.bookstoremanager.entity.Book;
import org.mapstruct.Mapper;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mapper.getMapper(BookMapper.class);

    Book toMoldel(BookDTO bookDTO);
    BookDTO toDTO(Book book);


}
