package ync.zoomgobackend.domain.member.service;

import ync.zoomgobackend.domain.member.dto.MemberDTO;
import ync.zoomgobackend.domain.member.entity.MemberEntity;
import ync.zoomgobackend.domain.member.entity.enums.MemberRole;
import ync.zoomgobackend.domain.member.repository.MemberRepository;
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

    public MemberDTO getMemberByUserNo(String email) {
        MemberEntity memberEntity = memberRepository.findByEmail(email).orElseThrow();
        MemberDTO memberDTO = EntitytoDTO(memberEntity);
        System.out.println(memberDTO.getUserNo());
        return memberDTO;
    }

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
    public MemberEntity dtoToEntity(MemberDTO memberDTO) {
        return MemberEntity.builder()
                .userNo(memberDTO.getUserNo())
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
    public MemberDTO EntitytoDTO(MemberEntity member) {
        return MemberDTO.builder()
                .userNo(member.getUserNo())
<<<<<<< HEAD
                .email(member.getEmail())
                .nickName(member.getNickName())
                .name(member.getName())
                .phone(member.getPhone())
                .password(member.getPassword())
                .address(member.getAddress())
                .manner(member.getManner())
                .gender(member.getGender())
                .birthDate(member.getBirthDate())
                .profileImage(member.getProfileImage())
                .build();
=======
               .email(member.getEmail())
               .nickName(member.getNickName())
               .name(member.getName())
               .phone(member.getPhone())
               .password(member.getPassword())
               .address(member.getAddress())
               .manner(member.getManner())
               .gender(member.getGender())
               .birthDate(member.getBirthDate())
               .profileImage(member.getProfileImage())
               .build();
>>>>>>> 8fa1800e2d8abbf905e90485a6cddb1552ec7294
    }


}
