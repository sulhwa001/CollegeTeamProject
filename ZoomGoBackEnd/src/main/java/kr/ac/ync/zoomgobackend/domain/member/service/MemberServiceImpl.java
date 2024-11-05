package kr.ac.ync.zoomgobackend.domain.member.service;

import kr.ac.ync.zoomgobackend.domain.member.dto.MemberDTO;
import kr.ac.ync.zoomgobackend.domain.member.entity.MemberEntity;
import kr.ac.ync.zoomgobackend.domain.member.entity.enums.MemberRole;
import kr.ac.ync.zoomgobackend.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // 추가
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder passwordEncoder; // PasswordEncoder 추가

    @Override
    public void register(MemberDTO memberDTO) {
        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(memberDTO.getPassword());
        memberDTO.setPassword(encodedPassword); // 암호화된 비밀번호를 DTO에 설정

        // DTO를 Entity로 변환
        MemberEntity memberEntity = dtoToEntity(memberDTO);
        memberRepository.save(memberEntity); // DB에 저장
    }

    // DTO를 Entity로 변환하는 메서드
    private MemberEntity dtoToEntity(MemberDTO memberDTO) {
        return MemberEntity.builder()
                .email(memberDTO.getEmail())
                .nickName(memberDTO.getNickName())
                .name(memberDTO.getName())
                .phone(memberDTO.getPhone())
                .password(memberDTO.getPassword()) // 암호화된 비밀번호 사용
                .address(memberDTO.getAddress())
                .manner(memberDTO.getManner()) // DTO에서 manner 값을 가져오도록 수정
                .gender(memberDTO.getGender())
                .birthDate(memberDTO.getBirthDate())
                .profileImage(memberDTO.getProfileImage())
                .admin(MemberRole.USER) // 기본 역할 설정
                .build();
    }
}
