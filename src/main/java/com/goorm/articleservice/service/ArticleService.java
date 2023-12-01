package com.goorm.articleservice.service;

import static com.goorm.articleservice.model.constant.ArticleConstant.*;
import com.goorm.articleservice.model.result.ArticleResult;
import com.goorm.articleservice.model.result.ListResult;
import com.goorm.articleservice.repository.ArticleRepository;
import com.goorm.articleservice.repository.entity.Article;
import com.goorm.articleservice.model.dto.ArticleDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {


    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
          this.articleRepository = articleRepository;
    }

    public Long postArticle(ArticleDto articleDto) {
        Article article = articleRepository.save(articleDto.toEntity());

        return article.getId();
    }

    public void deactivateArticle(long articleId) {
        Article article = articleRepository.findArticleByIdAndActivated(articleId, ACTIVATED);
        article.delete();
        articleRepository.save(article);
    }

    public long modifyArticle(long articleId, ArticleDto articleDto) {
        Article article = articleRepository.findArticleByIdAndActivated(articleId, ACTIVATED);
        article.modify(articleDto.getTitle(), articleDto.getContent());
        article = articleRepository.save(article);

        return article.getId();
    }

    public ListResult<ArticleResult> getArticles(int offset) {
        PageRequest pageRequest = PageRequest.of(offset, PAGE_SIZE, Sort.by(ORDER_PROPERTY).descending());
        Page<Article> articlePage = articleRepository.findAllByActivated(ACTIVATED, pageRequest);

        int totalPage = articlePage.getTotalPages();
//        List<ArticleResult> list = articlePage.getContent().stream().map(
//                ArticleResult::of
//        ).toList();

        List<ArticleResult> list = new ArrayList<>();
        for(Article article : articlePage.getContent()) {
            list.add(ArticleResult.from(article.getId(), article.getTitle()));
        }

        return new ListResult<>(offset, totalPage, list);
    }

    public ArticleResult getArticle(long articleId) {
        Article article = articleRepository.findArticleByIdAndActivated(articleId, ACTIVATED);

        return ArticleResult.from(article);
    }

}
