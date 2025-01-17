package com.sesac.hello_spring.service;

import com.sesac.hello_spring.domain.Member;
import com.sesac.hello_spring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {

        // given - when - then 테스트 패턴 ...?
        // 테스트 하는 방식을 구조화 하여 테스트코드의 가독성을 높이는 방법
        //given
         Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }
    @Test
    public void 중복_회원_예외 (){

        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join( member1 );
        IllegalStateException e = assertThrows( IllegalStateException.class, () -> memberService.join( member1 ));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다. 어쩌고...");

    }
//
//    @Test
//    void findMembers() {
//
//    }
//
//    @Test
//    void findOne() {
//
//    }
}