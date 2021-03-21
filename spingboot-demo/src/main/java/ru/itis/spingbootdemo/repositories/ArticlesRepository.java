package ru.itis.spingbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.spingbootdemo.models.Article;
import ru.itis.spingbootdemo.models.User;

@Repository
public interface ArticlesRepository extends JpaRepository<Article, Long> {
    boolean existsByIdAndLikesContaining(Long id, User user);
}
