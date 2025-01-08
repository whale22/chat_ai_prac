package com.ll.chatAI.domain.member.service;

import com.ll.chatAI.global.rsData.RsData;
import com.ll.chatAI.domain.member.entity.Member;
import com.ll.chatAI.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public RsData<Member> join(String name, String password) {
        Member member = Member.builder()
                .name(name)
                .password(password)
                .build();

        memberRepository.save(member);

        return RsData.of("200", "%s님 환영합니다. 회원가입에 성공했습니다.".formatted(name), member);
    }
}
