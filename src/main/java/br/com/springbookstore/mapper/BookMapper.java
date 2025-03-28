package br.com.springbookstore.mapper;

import br.com.springbookstore.dto.BookDto;
import br.com.springbookstore.model.Book;
import org.modelmapper.ModelMapper;

public class BookMapper {

    public static Book toBook(BookDto dto){
        return new ModelMapper()
                .map(dto, Book.class);
    }

}
