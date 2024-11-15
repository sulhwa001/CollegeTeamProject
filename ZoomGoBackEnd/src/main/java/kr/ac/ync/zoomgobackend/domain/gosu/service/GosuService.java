package kr.ac.ync.zoomgobackend.domain.gosu.service;

import kr.ac.ync.zoomgobackend.domain.category.entity.CategoryEntity;
import kr.ac.ync.zoomgobackend.domain.gosu.dto.GosuChangeDTO;
import kr.ac.ync.zoomgobackend.domain.gosu.dto.GosuDTO;
import kr.ac.ync.zoomgobackend.domain.gosu.entity.GosuEntity;
import kr.ac.ync.zoomgobackend.domain.member.entity.MemberEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface GosuService {
    Long insertGosu(GosuDTO gosuDTO);
    String updateUserName(GosuChangeDTO gosuChangeDTO);
    Optional<GosuEntity> getGosuByGosuId(Long id);
    Long updateUserImage(GosuChangeDTO gosuChangeDTO);
    default GosuEntity nameToEntity(GosuChangeDTO gosuChangeDTO) {
        return GosuEntity.builder()
                .name(gosuChangeDTO.getName())
                .build();
    }
    default GosuEntity pictureToEntity(GosuChangeDTO gosuChangeDTO) {
        return GosuEntity.builder()
                .gosuId(gosuChangeDTO.getGosuId())
                .build();
    }

    default GosuEntity updateDtoToEntity(GosuDTO gosuDTO) {
        MemberEntity user = MemberEntity.builder().userNo(gosuDTO.getUserNo()).build();
        return GosuEntity.builder()
                .price(gosuDTO.getPrice())
                .area(gosuDTO.getArea())
                .serviceDetail(gosuDTO.getServiceDetail())
                .career(gosuDTO.getCareer())
                .user(user)
                .name(gosuDTO.getName())
                .possibleTime(gosuDTO.getPossibleTime())
                .graduation(gosuDTO.getGraduation())
                .build();
    }

}
