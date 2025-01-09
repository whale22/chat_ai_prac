package com.ll.chatAI.domain.article.service;

import com.ll.chatAI.domain.article.articleComment.entity.ArticleComment;
import com.ll.chatAI.domain.article.articleComment.repository.ArticleCommentRepository;
import com.ll.chatAI.domain.article.entity.Article;
import com.ll.chatAI.domain.article.repository.ArticleRepository;
import com.ll.chatAI.domain.member.service.MemberService;
import com.ll.chatAI.global.rsData.RsData;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;
    private final MemberService memberService;

    @Transactional
    public RsData<Article> write(long memberId, String title, String content) {
        Article article = Article.builder()
                .title(title)
                .content(content)
                .author(memberService.getMember(memberId))
                .build();

        articleRepository.save(article);

        return RsData.of("200", "글 작성에 성공했습니다.", article);
    }

    public Optional<Article> findById(long id) {
        return articleRepository.findById(id);
    }

    public List<Article> findByAuthorId(long id) {
        return articleRepository.findByAuthor_id(id);
    }

    @Transactional
    public RsData<Article> modify(Article article, String modi_title, String modi_content) {
        article.setTitle(modi_title);
        article.setContent(modi_content);

//        articleRepository.save(article);

        return RsData.of("200", "게시글이 수정되었습니다.",article);
    }

    @Transactional
    public void modifyComment(ArticleComment comment, String body) {
        comment.setBody(body);
//        articleCommentRepository.save(comment);
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }
}
