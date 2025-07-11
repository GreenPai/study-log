package com.greenpai.honco.repository;

import com.greenpai.honco.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ArticleRepository extends CrudRepository<Article,Integer> {
    @Override
    ArrayList<Article> findAll(); // Iterable -> ArrayList 수정
}
