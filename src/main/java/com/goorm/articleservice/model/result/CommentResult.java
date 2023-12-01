package com.goorm.articleservice.model.result;

import com.goorm.articleservice.repository.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class CommentResult {
    private Long id;
    private String content;

    public static CommentResult from(Comment comment) {
        return new CommentResult(comment.getId(), comment.getContent());
    }
}
