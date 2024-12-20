package ync.zoomgobackend.domain.gosu.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import ync.zoomgobackend.domain.gosu.dto.GosuChangeDTO;
import ync.zoomgobackend.domain.gosu.dto.GosuDTO;
import ync.zoomgobackend.domain.gosu.dto.GosuUpdateDTO;
import ync.zoomgobackend.domain.gosu.entity.GosuEntity;
import ync.zoomgobackend.domain.gosu.entity.GosuQuestionEntity;
import ync.zoomgobackend.domain.gosu.repository.GosuQuestionRepository;
import ync.zoomgobackend.domain.gosu.repository.GosuRepository;
import ync.zoomgobackend.domain.gosu.repository.querydsl.GosuQueryRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class GosuServiceImpl implements GosuService {

    private final GosuRepository gosuRepository;
    private final GosuQuestionRepository gosuQuestionRepository;
    private final GosuQueryRepository gosuQueryRepository;

    @Override
    public Long insertGosu(GosuDTO gosuDTO) {
        GosuEntity gosuEntity = insertDtoToEntity(gosuDTO);
        GosuEntity saveGosuEntity = gosuRepository.save(gosuEntity);
        GosuQuestionEntity gosuQuestionEntity = questionDtoToEntity(gosuDTO);
        if (gosuQuestionEntity != null) {
            gosuQuestionEntity.setGosuId(gosuEntity);
            gosuQuestionRepository.save(gosuQuestionEntity);
        } else {
            return null;
        }
        return saveGosuEntity.getGosuId();
    }


    @Override
    public Long updateUserName(Long gosuId, GosuChangeDTO gosuChangeDTO) {
        GosuEntity gosuEntity = gosuRepository.findById(gosuId).orElse(null);
        gosuEntity.setName(gosuChangeDTO.getName());
        return gosuRepository.save(gosuEntity).getGosuId();
    }

    @Override
    public Optional<GosuEntity> getProfileByGosuId(Long id) {
        return gosuRepository.findByGosuId(id);
    }

    @Override
    public Long updateGosu(GosuUpdateDTO gosuUpdateDTO) {
        GosuEntity gosuEntity = gosuRepository.findById(gosuUpdateDTO.getGosuId()).orElse(null);
        gosuEntity.updateName(gosuUpdateDTO.getName());
        gosuEntity.updateArea(gosuUpdateDTO.getArea());
        gosuEntity.updateServiceDetail(gosuUpdateDTO.getServiceDetail());
        gosuEntity.updateGraduation(gosuUpdateDTO.getGraduation());
        gosuEntity.updatePrice(gosuUpdateDTO.getPrice());
        gosuEntity.updatePossibleTime(gosuUpdateDTO.getPossibleTime());
        gosuEntity.updateCareer(gosuUpdateDTO.getCareer());
        return gosuRepository.save(gosuEntity).getGosuId();
    }

}
