package com.goorm.articleservice.model.dto;

import com.goorm.articleservice.repository.entity.Article;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDto {
    private String title;
    private String content;

    public Article toEntity() {
        return Article.of(this.title, this.content);
    }
}
