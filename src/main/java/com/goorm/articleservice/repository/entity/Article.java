package com.goorm.articleservice.repository.entity;

import com.goorm.articleservice.repository.entity.base.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class Article extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String content;
    private boolean activated = true;

    @OneToMany
    @JoinColumn(name = "article_id")
    private List<Comment> comments;

    private List<Comment> getCommentsInternal() {
        if (this.comments == null) {
            this.comments = new ArrayList<>();
        }
        return this.comments;
    }

    public void addComment(Comment comment) {
        getCommentsInternal().add(comment);
    }

    public void delete() {
        this.activated = false;
    }

    private Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public static Article of(String title, String content) {
        return new Article(title, content);
    }

    public void modify(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
