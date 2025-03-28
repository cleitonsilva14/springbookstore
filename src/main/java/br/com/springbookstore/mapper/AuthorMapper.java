package br.com.springbookstore.mapper;


import br.com.springbookstore.dto.AuthorDto;
import br.com.springbookstore.model.Author;
import org.modelmapper.ModelMapper;

public class AuthorMapper {

    public static Author toAuthor(AuthorDto authorDto){
        return new ModelMapper().map(authorDto, Author.class);
    }

}
