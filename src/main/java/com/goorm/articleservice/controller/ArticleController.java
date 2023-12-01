package com.goorm.articleservice.controller;

import com.goorm.articleservice.model.dto.ArticleDto;
import com.goorm.articleservice.model.result.ArticleResult;
import com.goorm.articleservice.model.result.ListResult;
import com.goorm.articleservice.service.ArticleService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArticleController {
    private ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    // 게시물 등록
    @PostMapping("/article")
    public long postArticle(@RequestBody ArticleDto articleDto) {
        return articleService.postArticle(articleDto);
    }

    // 게시글 삭제
    @DeleteMapping("/article/{articleId}")
    public void deleteArticle(@PathVariable(name = "articleId") Long articleId) {
        articleService.deactivateArticle(articleId);
    }
    // 게시글 수정
    @PatchMapping("/article/{articleId}")
    public long modifyArticle(@PathVariable(name = "articleId") Long articleId, @RequestBody ArticleDto articleDto) {
        return articleService.modifyArticle(articleId, articleDto);
    }
    // 게시글 조회
    @GetMapping("/articles")
    public ListResult<ArticleResult> getArticleList(@RequestParam(name = "offset", required = false, defaultValue = "0") int offset) {
        return articleService.getArticles(offset);
    }

    @GetMapping("/article/{articleId}")
    public ArticleResult getArticle(@PathVariable(name = "articleId") Long articleId) {
        return articleService.getArticle(articleId);
    }
}
