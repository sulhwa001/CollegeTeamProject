package kr.ac.ync.zoomgobackend.domain.gosu.mapper;

import kr.ac.ync.zoomgobackend.domain.gosu.dto.GosuChangeDTO;
import kr.ac.ync.zoomgobackend.domain.gosu.entity.GosuEntity;
import kr.ac.ync.zoomgobackend.domain.member.entity.MemberEntity;

import static kr.ac.ync.zoomgobackend.domain.gosu.entity.QGosuEntity.gosuEntity;

public class GosuMapper {
    public static GosuChangeDTO createGosuDTO(GosuEntity gosuEntity) {
        MemberEntity user = MemberEntity.builder().userNo(gosuEntity.getUser().getUserNo()).build();

        return GosuChangeDTO.builder()
                .name(gosuEntity.getName())
                .userNo(user.getUserNo())
                .build();
    }
    public static GosuEntity createGosuEntity(GosuChangeDTO gosuDTO) {
        MemberEntity user = MemberEntity.builder().userNo(gosuDTO.getUserNo()).build();
        return GosuEntity.builder()
                .user(user)
                .name(gosuDTO.getName())
                .build();
    }
}
