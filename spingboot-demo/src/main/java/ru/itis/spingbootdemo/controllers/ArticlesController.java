package ru.itis.spingbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.spingbootdemo.dto.ArticleDto;
import ru.itis.spingbootdemo.dto.ArticleForm;
import ru.itis.spingbootdemo.services.ArticleService;
import ru.itis.spingbootdemo.services.UsersService;

@Controller
public class ArticlesController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private UsersService usersService;

    @PostMapping("/users/{user-id}/articles")
    @ResponseBody
    public ResponseEntity<ArticleDto> addArticle(@PathVariable("user-id") Long userId, @RequestBody ArticleForm article) {
        return ResponseEntity.ok(articleService.addArticle(userId, article));
    }

    @GetMapping("/users/{user-id}/articles")
    public String getArticlesOfUser(@PathVariable("user-id") Long userId, Model model) {
        model.addAttribute("articles", articleService.getByUserId(userId));
        return "articles_page";
    }

    @PostMapping("/users/{user-id}/articles/{article-id}/like")
    @ResponseBody
    public ArticleDto like(@PathVariable("user-id") Long userId, @PathVariable("article-id") Long articleId) {
        return articleService.like(userId, articleId);
    }

}
