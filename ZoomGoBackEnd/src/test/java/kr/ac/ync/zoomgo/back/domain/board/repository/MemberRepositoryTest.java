package kr.ac.ync.zoomgo.back.domain.board.repository;

import kr.ac.ync.zoomgo.back.domain.board.entity.MemberEntity;
import kr.ac.ync.zoomgo.back.domain.board.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void insertMembers(){
        IntStream.rangeClosed(1,100).forEach(i-> {
            MemberEntity memberEntity = MemberEntity.builder()
                    .email("user"+i+"@aaa.com")
                    .password("1111")
                    .name("USER"+ i)
                    .build();
            memberRepository.save(memberEntity);
        });
    }

}