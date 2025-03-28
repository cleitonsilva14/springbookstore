package br.com.springbookstore.controller;

import br.com.springbookstore.model.Author;
import br.com.springbookstore.service.AuthorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Author", description = "Operações relacionadas aos autores")
@RestController
@RequestMapping("/author") // http://localhost:9000/authors
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    public List<Author> findAll(){
        return authorService.findAll();
    }

    @PostMapping
    public Author save(@RequestBody Author author){
        return authorService.save(author);
    }


}
