package ync.zoomgobackend.domain.gosu.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import ync.zoomgobackend.domain.category.entity.CategoryEntity;
import ync.zoomgobackend.domain.gosu.dto.GosuChangeDTO;
import ync.zoomgobackend.domain.gosu.dto.GosuDTO;
import ync.zoomgobackend.domain.gosu.dto.GosuUpdateDTO;
import ync.zoomgobackend.domain.gosu.entity.GosuEntity;
import ync.zoomgobackend.domain.gosu.entity.GosuQuestionEntity;
import ync.zoomgobackend.domain.member.entity.MemberEntity;

@Service
public interface GosuService {

    Long insertGosu(GosuDTO gosuDTO);
    Long updateUserName(Long gosuId, GosuChangeDTO gosuChangeDTO);
    Optional<GosuEntity> getProfileByGosuId(Long id);

    Long updateGosu(GosuUpdateDTO gosuUpdateDTO);

    default GosuEntity pictureToEntity(GosuChangeDTO gosuChangeDTO) {
        return GosuEntity.builder()
                .build();
    }

    default GosuEntity insertDtoToEntity(GosuDTO gosuDTO) {
        MemberEntity user = MemberEntity.builder().userNo(gosuDTO.getUserNo()).build();
        CategoryEntity categoryEntity = CategoryEntity.builder().categoryId(gosuDTO.getCategoryId()).build();
        return GosuEntity.builder()
                .categoryId(categoryEntity)
                .gosuId(gosuDTO.getGosuId())
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

    default GosuDTO GosuEntityToDTO(Optional<GosuEntity> optionalGosuEntity) {
        // Optional이 비어있을 경우 예외를 던지거나 기본값을 반환하도록 처리
        GosuEntity gosuEntity = optionalGosuEntity
                .orElseThrow(() -> new EntityNotFoundException("GosuEntity not found"));

        return GosuDTO.builder()
                .categoryId(gosuEntity.getCategoryId().getCategoryId())
                .gosuId(gosuEntity.getGosuId())
                .graduation(gosuEntity.getGraduation())
                .possibleTime(gosuEntity.getPossibleTime())
                .price(gosuEntity.getPrice())
                .profilePicture(gosuEntity.getProfilePicture())
                .userNo(gosuEntity.getUser().getUserNo())
                .name(gosuEntity.getName())
                .career(gosuEntity.getCareer())
                .serviceDetail(gosuEntity.getServiceDetail())
                .area(gosuEntity.getArea())
                .build();
    }

    default GosuEntity GosuDTOToEntity(GosuDTO gosuDTO) {
        MemberEntity user = MemberEntity.builder().userNo(gosuDTO.getUserNo()).build();
        CategoryEntity categoryEntity = CategoryEntity.builder().categoryId(gosuDTO.getCategoryId()).build();
        // Optional이 비어있을 경우 예외를 던지거나 기본값을 반환하도록 처리
        return GosuEntity.builder()
                .user(user)
                .categoryId(categoryEntity)
                .price(gosuDTO.getPrice())
                .graduation(gosuDTO.getGraduation())
                .possibleTime(gosuDTO.getPossibleTime())
                .profilePicture(gosuDTO.getProfilePicture())
                .name(gosuDTO.getName())
                .career(gosuDTO.getCareer())
                .serviceDetail(gosuDTO.getServiceDetail())
                .area(gosuDTO.getArea())
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
