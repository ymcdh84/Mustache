package com.ymcdh.ymcdh.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
@Data
public class Posts {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

}
