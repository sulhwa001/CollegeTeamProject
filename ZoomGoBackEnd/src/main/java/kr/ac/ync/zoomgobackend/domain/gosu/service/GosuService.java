package kr.ac.ync.zoomgobackend.domain.gosu.service;

import kr.ac.ync.zoomgobackend.domain.category.entity.CategoryEntity;
import kr.ac.ync.zoomgobackend.domain.gosu.dto.GosuChangeDTO;
import kr.ac.ync.zoomgobackend.domain.gosu.dto.GosuDTO;
import kr.ac.ync.zoomgobackend.domain.gosu.entity.GosuEntity;
import kr.ac.ync.zoomgobackend.domain.gosu.entity.GosuQuestionEntity;
import kr.ac.ync.zoomgobackend.domain.member.entity.MemberEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface GosuService {

    Long insertGosu(GosuDTO gosuDTO);
    String updateUserName(GosuChangeDTO gosuChangeDTO);
    Optional<GosuEntity> getGosuByGosuId(Long id);

    default GosuEntity pictureToEntity(GosuChangeDTO gosuChangeDTO) {
        MemberEntity user = MemberEntity.builder().userNo(gosuChangeDTO.getUserNo()).build();
        return GosuEntity.builder()
                .user(user)
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

    default GosuQuestionEntity questionDtoToEntity(GosuDTO gosuDTO) {
        return GosuQuestionEntity.builder()
                .gosuId(gosuDTO.getGosuQuestion().getGosuId())
                .question1(gosuDTO.getGosuQuestion().getQuestion1())
                .question2(gosuDTO.getGosuQuestion().getQuestion2())
                .question3(gosuDTO.getGosuQuestion().getQuestion3())
                .question4(gosuDTO.getGosuQuestion().getQuestion4())
                .question5(gosuDTO.getGosuQuestion().getQuestion5())
                .build();
    }
}
