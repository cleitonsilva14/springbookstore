package br.com.springbookstore.exception;

public class BookTitleUniqueViolationException extends RuntimeException {
    public BookTitleUniqueViolationException(String message) {
        super(message);
    }
}
