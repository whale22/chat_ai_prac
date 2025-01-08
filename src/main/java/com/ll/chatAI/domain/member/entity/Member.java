package com.ll.chatAI.domain.member.entity;

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
public class Member extends BaseEntity {
    private String name; //회원 이름
    private String password; //회원 비밀번호
}
