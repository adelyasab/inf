package ru.itis.spingbootdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.spingbootdemo.dto.ArticleDto;
import ru.itis.spingbootdemo.dto.ArticleForm;
import ru.itis.spingbootdemo.models.Article;
import ru.itis.spingbootdemo.models.User;
import ru.itis.spingbootdemo.repositories.ArticlesRepository;
import ru.itis.spingbootdemo.repositories.UsersRepository;

import java.util.List;

@Component
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ArticlesRepository articlesRepository;

    @Override
    public ArticleDto addArticle(Long userId, ArticleForm article) {
        User user = usersRepository.getOne(userId);

        Article newArticle = Article.builder()
                .author(user)
                .text(article.getText())
                .build();
        articlesRepository.save(newArticle);
        return ArticleDto.from(newArticle);
    }

    @Override
    public List<ArticleDto> getByUserId(Long userId) {
        User user = usersRepository.getOne(userId);
        List<Article> articleList = user.getCreatedArticles();
        return ArticleDto.from(articleList);
    }

    @Override
    public ArticleDto like(Long userId, Long articleId) {
        User user = usersRepository.getOne(userId);
        Article article = articlesRepository.getOne(articleId);

        if (articlesRepository.existsByIdAndLikesContaining(articleId, user)) {
            article.getLikes().remove(user);
        } else {
            article.getLikes().add(user);
        }
        articlesRepository.save(article);
        return ArticleDto.from(article);
    }
}
