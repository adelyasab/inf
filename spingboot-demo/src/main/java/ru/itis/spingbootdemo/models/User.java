package ru.itis.spingbootdemo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="account")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String confirmCode;

    @Enumerated(value = EnumType.STRING)
    private State state;

    @OneToMany(mappedBy = "author")
    private List<Article> createdArticles;

    @ManyToMany(mappedBy = "likes")
    private List<Article> likedArticles;

    //указывает, какое поле в объекте владельце соответствует владеемому объекту
    @OneToMany(mappedBy = "user")
    private List<Photosession> photosessions;

    @OneToMany(mappedBy = "customer")
    private List<Application> inputApplications;

    @OneToMany(mappedBy = "owner")
    private List<Application> outputApplications;

    private Role role;
}
