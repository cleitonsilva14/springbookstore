package br.com.springbookstore.errors;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record ApiError(

        @JsonFormat(pattern = "dd-MM-YYYY HH:mm:ss")
        LocalDateTime timestamp,
        Integer code,
        String status,
        List<String> messages

) {
}
