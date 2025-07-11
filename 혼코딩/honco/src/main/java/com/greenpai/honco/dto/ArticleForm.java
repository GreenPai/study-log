package com.greenpai.honco.dto;

import com.greenpai.honco.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {
    private String title; // 제목
    private String content; // 내용

    public Article toEntity() {
        return new Article(null, title, content);
    }

    /***
     * @AllArgsConstructor
     */
    /*
    public ArticleForm(String title, String content) {
        this.title = title;
        this.content = content;
    }


     */

    /***
     * @ToString
     */
    /*
    @Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
    */

}
