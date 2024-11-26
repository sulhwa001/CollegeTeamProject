package ync.zoomgobackend.domain.member.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ync.zoomgobackend.domain.member.entity.MemberEntity;
import ync.zoomgobackend.domain.member.entity.enums.MemberRole;

import java.util.Date;
import java.util.Random;
//유저 더미 데이터
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void createMultipleMembersTest() {
        for (int i = 1; i <= 100; i++) {
            // 임의의 전화번호와 이메일 생성
            String email = "testuser" + i + "@example.com";
            String phone = "010-" + String.format("%04d", new Random().nextInt(10000)) + "-" + String.format("%04d", new Random().nextInt(10000));

            // 테스트 데이터 생성
            MemberEntity member = MemberEntity.builder()
                    .email(email)
                    .nickName("testNick" + i)
                    .name("Test User " + i)
                    .phone(phone)
                    .password("password" + i)
                    .address("123 Test Street #" + i)
                    .manner(4.0 + (i % 5) * 0.1) // 4.0 ~ 4.4 사이의 임의의 점수
                    .gender(i % 2 == 0 ? "M" : "F") // 성별을 번갈아가며 할당
                    .birthDate(new Date(1990 - 1900, (i % 12), (i % 28) + 1)) // 다양한 생일
                    .profileImage("profile" + i + ".jpg")
                    .admin(MemberRole.USER)
                    .build();

            // 데이터 저장
            memberRepository.save(member);

            // 저장 확인 출력
            System.out.println("Saved member: " + member);
        }
    }
}
