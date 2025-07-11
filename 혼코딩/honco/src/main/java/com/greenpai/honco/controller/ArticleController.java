package com.greenpai.honco.controller;

import com.greenpai.honco.dto.ArticleForm;
import com.greenpai.honco.entity.Article;
import com.greenpai.honco.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
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

        // 1. DTO를 엔티티로 변환
        Article article= form.toEntity();
        log.info(article.toString());
        // System.out.println("엔티티: " + article.toString());

        // 2. 리파지터리로 엔티티를 DB에 저장
        Article savedArticle =  articleRepository.save(article);
        log.info(savedArticle.toString());
        // System.out.println(savedArticle.toString());


        return "articles/new";
    }

    @GetMapping("/articles/{id}")
    public String articles(@PathVariable Integer id, Model model){

        Article articleEntity = articleRepository.findById(id).orElse(null);
        List<Article> articleList = articleRepository.findAll();
        log.info("id =  " + id);

        model.addAttribute("article", articleEntity);

        return "articles/show";
    }
}
