package com.ll.chatAI.domain.article.articleComment.entity;

import com.ll.chatAI.domain.article.entity.Article;
import com.ll.chatAI.domain.member.entity.Member;
import com.ll.chatAI.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ArticleComment extends BaseEntity {
    private String body; // 내용

    @ManyToOne
    private Article article; // 댓글이 작성된 게시글

    @ManyToOne
    private Member author; // 댓글 작성자

}
