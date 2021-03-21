package ru.itis.spingbootdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.spingbootdemo.models.Article;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleDto {
    private Long id;
    private String text;
    private String authorFirstName;
    private String authorLastName;
    private Integer likeCounts;

    public static ArticleDto from(Article newArticle) {
        return ArticleDto.builder()
                .id(newArticle.getId())
                .authorFirstName(newArticle.getAuthor().getFirstName())
                .authorLastName(newArticle.getAuthor().getLastName())
                .text(newArticle.getText())
                .likeCounts(newArticle.getLikes().size())
                .build();
    }

    public static List<ArticleDto> from(List<Article> articleList) {
        return articleList.stream().map(ArticleDto::from).collect(Collectors.toList());
    }
}
