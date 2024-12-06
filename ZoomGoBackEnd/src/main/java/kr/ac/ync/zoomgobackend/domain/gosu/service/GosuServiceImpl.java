package kr.ac.ync.zoomgobackend.domain.gosu.service;

import com.querydsl.core.types.dsl.NumberPath;
import jakarta.transaction.Transactional;
import kr.ac.ync.zoomgobackend.domain.gosu.dto.GosuChangeDTO;
import kr.ac.ync.zoomgobackend.domain.gosu.dto.GosuDTO;
import kr.ac.ync.zoomgobackend.domain.gosu.entity.GosuEntity;
import kr.ac.ync.zoomgobackend.domain.gosu.entity.GosuQuestionEntity;
import kr.ac.ync.zoomgobackend.domain.gosu.mapper.GosuMapper;
import kr.ac.ync.zoomgobackend.domain.gosu.repository.GosuQuestionRepository;
import kr.ac.ync.zoomgobackend.domain.gosu.repository.GosuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class GosuServiceImpl implements GosuService {

    private final GosuRepository gosuRepository;
    private final GosuQuestionRepository gosuQuestionRepository;

    @Override
    public Long insertGosu(GosuDTO gosuDTO) {
        GosuEntity gosuEntity = updateDtoToEntity(gosuDTO);
        GosuEntity saveGosuEntity = gosuRepository.save(gosuEntity);
        GosuQuestionEntity gosuQuestionEntity = questionDtoToEntity(gosuDTO);
        if(gosuQuestionEntity != null) {
            gosuQuestionEntity.setGosuId(gosuEntity);
            gosuQuestionRepository.save(gosuQuestionEntity);
        }
        else {
            return null;
        }
        return saveGosuEntity.getGosuId();
    }

    @Override
    public String updateUserName(GosuChangeDTO gosuChangeDTO) {
        Optional<GosuEntity> results = gosuRepository.getGosuByGosuId(gosuChangeDTO.getUserNo());
        GosuEntity gosuEntity = results.get();
        gosuEntity.setName(gosuChangeDTO.getName());
        GosuEntity gosu = GosuMapper.createGosuEntity(gosuChangeDTO);
        gosuRepository.save(gosu);
        return gosuEntity.getName();

    }

    @Override
    public Optional<GosuEntity> getGosuByGosuId(Long id) {
        return gosuRepository.getGosuByGosuId(id);
    }

}
