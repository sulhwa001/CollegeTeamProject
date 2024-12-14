package ync.zoomgobackend.domain.member.mapper;

import ync.zoomgobackend.domain.member.dto.MemberDTO;
import ync.zoomgobackend.domain.member.entity.MemberEntity;

public class MemberMapper {
    public static MemberEntity createEntity(MemberDTO memberDTO){
        return   MemberEntity.builder()
                .email(memberDTO.getEmail())
                .password(memberDTO.getPassword())
                .name(memberDTO.getName())
                .admin(memberDTO.getAdmin())
                .address(memberDTO.getAddress())
                .phone(memberDTO.getPhone())
                .birthDate(memberDTO.getBirthDate())
                .gender(memberDTO.getGender())
                .nickName(memberDTO.getNickName())
                .manner(memberDTO.getManner())
                .profileImage(memberDTO.getProfileImage())
                .build();
    }


    public static MemberDTO createDTO(MemberEntity memberEntity){
        return   MemberDTO.builder()
                .email(memberEntity.getEmail())
                .password(memberEntity.getPassword())
                .name(memberEntity.getName())
                .admin(memberEntity.getAdmin())
                .address(memberEntity.getAddress())
                .phone(memberEntity.getPhone())
                .birthDate(memberEntity.getBirthDate())
                .gender(memberEntity.getGender())
                .nickName(memberEntity.getNickName())
                .manner(memberEntity.getManner())
                .profileImage(memberEntity.getProfileImage())
                .build();
    }
}
