package com.ll.chatAI.domain.article.entity;

import com.ll.chatAI.domain.article.articleComment.entity.ArticleComment;
import com.ll.chatAI.domain.article.articleTag.entity.ArticleTag;
import com.ll.chatAI.domain.member.entity.Member;
import com.ll.chatAI.global.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@ToString(callSuper = true)
@NoArgsConstructor
public class Article extends BaseEntity {
    private String title; // 게시글 제목
    private String content; // 게시글 내용

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", referencedColumnName = "id", nullable = false)
    private Member author; // 게시글 작성자

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    @ToString.Exclude // 무한순환방지
    private List<ArticleComment> articleComments = new ArrayList<>(); // 게시글 댓글들

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    @ToString.Exclude // 무한순환방지
    private List<ArticleTag> articleTags = new ArrayList<>(); // 게시글 태그들

    public void addComment(Member memberAuthor, String comment){
        //댓글 추가
        ArticleComment articleComment = ArticleComment.builder()
                .article(this)
                .author(memberAuthor)
                .body(comment)
                .build();

        articleComments.add(articleComment);

    }

    public List<ArticleComment> getComments() {
        return articleComments;
    }

    public void removeComment(ArticleComment lastComment) {
        articleComments.remove(lastComment);
    }

    public String getTagsStr() {
        return articleTags.stream()
                .map(x-> "#"+x.getTagName())
                .reduce((a, b) -> a + " " + b)
                .orElse("");
    }

    public void addTags(String... tagNames) {
        //태그 추가
        for(String tagName : tagNames){
            addTag(tagName);
        }
    }

    public void addTag(String tagName) {
        ArticleTag articleTag = ArticleTag.builder()
                .article(this)
                .author(this.getAuthor())
                .tagName(tagName)
                .build();

        articleTags.add(articleTag);
    }
}
