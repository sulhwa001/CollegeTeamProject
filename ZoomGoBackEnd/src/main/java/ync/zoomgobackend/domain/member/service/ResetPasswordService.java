package ync.zoomgobackend.domain.member.service;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ync.zoomgobackend.domain.member.entity.MemberEntity;
import ync.zoomgobackend.domain.member.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class ResetPasswordService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * 사용자 비밀번호 변경
     *
     * @param email       사용자 이메일
     * @param newPassword 새 비밀번호
     * @throws IllegalArgumentException 사용자 이메일이 없을 경우 예외 발생
     */
    public void resetPassword(String email, String newPassword) {
        // 이메일로 사용자 검색
        MemberEntity member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found with email: " + email));

        // 새 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(newPassword);

        // 사용자 비밀번호 업데이트
        member.setPassword(encodedPassword);

        // 저장
        memberRepository.save(member);
    }
}
