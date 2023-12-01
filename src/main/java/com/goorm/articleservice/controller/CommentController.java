package com.goorm.articleservice.controller;

import com.goorm.articleservice.model.dto.ContentDto;
import com.goorm.articleservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    // 댓글 등록
    @PostMapping("/article/{articleId}/comment")
    public void comment(@PathVariable(value = "articleId") Long articleId, @RequestBody ContentDto content) {
        commentService.addComment(articleId, content.getContent());
    }

    // 댓글 수정
    @PatchMapping("/article/{articleId}/comment/{commentId}")
    public long modifyComment(@PathVariable(value = "commentId") Long commentId, @RequestBody ContentDto content) {
        return commentService.modifyComment(commentId, commentId, content);
    }


    // 댓글 삭제
    @DeleteMapping("/article/{articleId}/comment/{commentId}")
    public void deleteComment(@PathVariable(value = "articleId") Long articleId, @PathVariable(value = "commentId") Long commentId) {
        commentService.deleteComment(articleId,commentId);
    }
}
