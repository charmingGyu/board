package com.goorm.articleservice.service;

import static com.goorm.articleservice.model.constant.ArticleConstant.*;

import com.goorm.articleservice.model.dto.ContentDto;
import com.goorm.articleservice.model.result.CommentResult;
import com.goorm.articleservice.repository.ArticleRepository;
import com.goorm.articleservice.repository.CommentRepository;
import com.goorm.articleservice.repository.entity.Article;
import com.goorm.articleservice.repository.entity.Comment;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    public CommentService(ArticleRepository articleRepository, CommentRepository commentRepository) {
        this.articleRepository = articleRepository;
        this.commentRepository = commentRepository;
    }
    public long modifyComment(long articleId, long commentId, ContentDto content) {
        Article article = articleRepository.findArticleByIdAndActivated(articleId, ACTIVATED);
        Comment comment = commentRepository.findCommentByIdAndActivated(commentId, ACTIVATED);
        comment.modify(content.getContent());
        comment = commentRepository.save(comment);

        return comment.getId();
    }
    public void addComment(long articleId, String content) {
        Article article = articleRepository.findArticleByIdAndActivated(articleId, ACTIVATED);
        Comment comment = commentRepository.save(Comment.of(content));
        article.addComment(comment);
        articleRepository.save(article);
    }

    @Transactional
    public void deleteComment(long articleId, long commentId) {
        commentRepository.deleteCommentById(commentId);
    }
}
