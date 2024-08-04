package com.sesac.hello_spring;

import com.sesac.hello_spring.aop.TimeTraceAOP;
import com.sesac.hello_spring.repository.JdbcMemberRepository;
import com.sesac.hello_spring.repository.JpaMemberRepository;
import com.sesac.hello_spring.repository.MemberRepository;
import com.sesac.hello_spring.repository.MemoryMemberRepository;
import com.sesac.hello_spring.service.MemberService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

  private final MemberRepository memberRepository;

  @Autowired
  public SpringConfig(MemberRepository memberRepository){
    this.memberRepository = memberRepository;
  }


//  private EntityManager em;
//
//  @Autowired
//  public SpringConfig(EntityManager em){
//    this.em = em;
//  }

  @Bean
  public MemberService memberService(){
    return new MemberService(memberRepository);
  }

//  @Bean
//  public TimeTraceAOP timeTraceAOP(){
//    return new TimeTraceAOP();
//  }

}
