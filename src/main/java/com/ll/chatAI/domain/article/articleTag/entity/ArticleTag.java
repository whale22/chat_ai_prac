package com.ll.chatAI.domain.article.articleTag.entity;

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
public class ArticleTag extends BaseEntity {
    private String tagName; // 태그 이름

    @ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    private Article article; // 댓글이 작성된 게시글

    @ManyToOne
    private Member author; // 댓글 작성자

}
