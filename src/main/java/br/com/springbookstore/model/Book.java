package br.com.springbookstore.model;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tb_book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(name = "title", nullable = false, unique = true, length = 80)
    private String title;

    @Column(name = "image_cover", nullable = true)
    private String imageCover;

    @Column(name="description", columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "year_release", nullable = false)
    private Integer year;

}
