package com.ll.chatAI.domain.member.service;

import com.ll.chatAI.domain.member.entity.Member;
import com.ll.chatAI.domain.member.repository.MemberRepository;
import com.ll.chatAI.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public RsData<Member> join(String name, String password) {
        Member member = Member.builder()
                .author(name)
                .password(password)
                .build();

        memberRepository.save(member);

        return RsData.of("200", "%s님 환영합니다. 회원가입에 성공했습니다.".formatted(name), member);
    }

    public Member getMember(Long memberId) {
        return memberRepository.findById(memberId).orElse(null);
    }

    public Optional<Member> findById(long id) {
        return memberRepository.findById(id);
    }
}
