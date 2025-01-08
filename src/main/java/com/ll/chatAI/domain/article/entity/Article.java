package com.ll.chatAI.domain.article.entity;

import com.ll.chatAI.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@ToString(callSuper = true)
public class Article extends BaseEntity {
    private long number; // 글 번호
    private String title; // 게시글 제목
    private String content; // 게시글 내용
}
