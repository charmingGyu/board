package com.goorm.articleservice.repository;

import com.goorm.articleservice.repository.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment save(Comment comment);

    Comment findCommentByIdAndActivated(Long id, boolean activated);
    void deleteCommentById(Long id);
}
