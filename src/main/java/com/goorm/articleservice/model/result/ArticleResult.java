package com.goorm.articleservice.model.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.goorm.articleservice.repository.entity.Article;
import com.goorm.articleservice.repository.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleResult {
    private long id;
    private String title;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String content;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime createDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<CommentResult> comments;

    public static ArticleResult from(Article article) {
        return ArticleResult.builder()
                .id(article.getId())
                .title(article.getTitle())
                .content(article.getContent())
                .createDate(article.getCreateDate())
                .comments((article.getComments().stream().map(CommentResult::from).toList()))
                .build();
    }

    public static ArticleResult from(Long id, String title) {
        return ArticleResult.builder()
                .id(id)
                .title(title)
                .build();
    }
}
