package kr.ac.ync.zoomgobackend.domain.gosu.service;

import jakarta.transaction.Transactional;
import kr.ac.ync.zoomgobackend.domain.gosu.dto.GosuChangeDTO;
import kr.ac.ync.zoomgobackend.domain.gosu.dto.GosuDTO;
import kr.ac.ync.zoomgobackend.domain.gosu.dto.GosuUpdateDTO;
import kr.ac.ync.zoomgobackend.domain.gosu.entity.GosuEntity;
import kr.ac.ync.zoomgobackend.domain.gosu.entity.GosuQuestionEntity;
import kr.ac.ync.zoomgobackend.domain.gosu.repository.GosuQuestionRepository;
import kr.ac.ync.zoomgobackend.domain.gosu.repository.GosuRepository;
import kr.ac.ync.zoomgobackend.domain.gosu.repository.querydsl.GosuQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public Long updateGosu(Long gosuId, GosuUpdateDTO gosuUpdateDTO) {
        GosuEntity gosuEntity = gosuRepository.findById(gosuId).orElse(null);
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
