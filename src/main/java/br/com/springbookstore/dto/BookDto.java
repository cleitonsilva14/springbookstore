package br.com.springbookstore.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class BookDto {

    @NotBlank(message = "necessário informar título do livro")
    private String title;

    private String imageCover;

    @NotBlank(message = "necessário informar descrição do livro")
    private String description;

    @NotNull(message = "necessário informar o ano de lançamento do livro")
    private Integer year;

}
