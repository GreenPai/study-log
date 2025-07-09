package com.greenpai.honco.controller;

import com.greenpai.honco.dto.ArticleForm;
import com.greenpai.honco.entity.Article;
import com.greenpai.honco.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticle(){
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
        System.out.println(form.toString());
        
        // 1. DTO를 엔티티로 변환
        Article article= form.toEntity();
        System.out.println("엔티티: " + article.toString());

        // 2. 리파지터리로 엔티티를 DB에 저장
        Article savedArticle =  articleRepository.save(article);
        System.out.println(savedArticle.toString());


        return "articles/new";
    }
}
