package br.com.springbookstore.controller;


import br.com.springbookstore.dto.BookDto;
import br.com.springbookstore.mapper.BookMapper;
import br.com.springbookstore.model.Book;
import br.com.springbookstore.service.BookService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.HttpStatus.*;

@Tag(name = "Books", description = "Operações relacionadas aos livros")
@RestController
@RequestMapping("/book") // http://localhost:9000/books
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;


    @GetMapping
    public ResponseEntity<List<Book>> findAll(){
        return ResponseEntity.status(OK).body(bookService.findAllBooks());
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Book> getBookByUUID(@PathVariable(value = "uuid") UUID uuid){
        Optional<Book> bookOptional = bookService.findBookByUuid(uuid);
        if(!bookOptional.isPresent()){
            return ResponseEntity.status(NOT_FOUND).body(new Book());
        }
        return ResponseEntity.status(OK).body(bookOptional.get());
    }

    @PostMapping
    public ResponseEntity<Book> save(@RequestBody BookDto bookDto){
        return ResponseEntity.status(CREATED).body(bookService.saveBook(BookMapper.toBook(bookDto)));
    }



    @PutMapping("/{uuid}")
    public ResponseEntity<Book> updateBook(@PathVariable(value = "uuid") UUID uuid, @RequestBody BookDto dto){

        var bookObj = bookService.findBookByUuid(uuid);

        if(!bookObj.isPresent()){
            return ResponseEntity.notFound().build();
        }

        var book = new Book();

        book = bookObj.get();

        book.setTitle(dto.getTitle());
        book.setDescription(dto.getDescription());
        book.setImageCover(dto.getImageCover());
        book.setYear(dto.getYear());

        return ResponseEntity.status(OK).body(bookService.saveBook(book));
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<String> deleteBook(@PathVariable(value = "uuid") UUID uuid){

        var bookObj = bookService.findBookByUuid(uuid);

        if(!bookObj.isPresent()){
            return ResponseEntity.notFound().build();
        }

        bookService.deleteBook(bookObj.get());
        return ResponseEntity.status(OK).body("Book deletado!");
    }

}
