package com.goorm.articleservice.repository.entity;

import com.goorm.articleservice.repository.CommentRepository;
import com.goorm.articleservice.repository.entity.base.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String content;
    private boolean activated = true;

    private Comment(String content) {
        this.content = content;
    }

    public void modify(String content) {
        this.content = content;
    }
    public void delete() {
        this.activated = false;
    }

    public static Comment of(String content) {
        return new Comment(content);
    }
}
