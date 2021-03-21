package ru.itis.spingbootdemo.services;


import ru.itis.spingbootdemo.dto.ArticleDto;
import ru.itis.spingbootdemo.dto.ArticleForm;

import java.util.List;

public interface ArticleService {
    ArticleDto addArticle(Long userId, ArticleForm article);

    List<ArticleDto> getByUserId(Long userId);

    ArticleDto like(Long userId, Long articleId);
}
