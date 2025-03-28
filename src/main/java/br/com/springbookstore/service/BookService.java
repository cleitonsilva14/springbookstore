package br.com.springbookstore.service;

import br.com.springbookstore.model.Book;
import br.com.springbookstore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;


    @Transactional(readOnly = true)
    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public Optional<Book> findBookByUuid(UUID uuid){
        return bookRepository.findById(uuid);
    }

    @Transactional
    public void deleteBook(Book book){
        bookRepository.delete(book);
    }




}
