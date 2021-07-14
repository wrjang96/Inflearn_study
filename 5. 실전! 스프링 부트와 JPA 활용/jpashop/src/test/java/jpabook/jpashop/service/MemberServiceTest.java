package jpabook.jpashop.service;
import jpabook.jpashop.Service.MemberService;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    //@Autowired
    //EntityManager em;

    @Test
    @Rollback(false)
    public void 회원가입() throws Exception{
        //Given
        Member member = new Member();
        member.setName("Jang");
        //When
        Long savedId = memberService.join(member);
        //Then
        assertEquals(member, memberRepository.findOne(savedId));
    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception{
        //Given
        Member member1 = new Member();
        member1.setName("kim");
        Member member2 = new Member();
        member2.setName("kim");
        //When
        memberService.join(member1);
        //try {
        memberService.join(member2); //예외가 발생해야 한다.
        //}
        //catch(IllegalStateException e){
        //    return;
        //}
        //Then
        fail("예외가 발생해야 한다.");
    }
}
