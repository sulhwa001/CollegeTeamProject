package kr.ac.ync.zoomgobackend.domain.gosu.service;

import com.querydsl.core.types.dsl.NumberPath;
import jakarta.transaction.Transactional;
import kr.ac.ync.zoomgobackend.domain.gosu.dto.GosuChangeDTO;
import kr.ac.ync.zoomgobackend.domain.gosu.dto.GosuDTO;
import kr.ac.ync.zoomgobackend.domain.gosu.entity.GosuEntity;
import kr.ac.ync.zoomgobackend.domain.gosu.repository.GosuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class GosuServiceImpl implements GosuService {

    private final GosuRepository gosuRepository;

    @Override
    public Long insertGosu(GosuDTO gosuDTO) {
        GosuEntity gosuEntity = updateDtoToEntity(gosuDTO);
        return gosuRepository.save(gosuEntity).getGosuId();
    }

    @Override
    public String updateUserName(GosuChangeDTO gosuChangeDTO) {
        GosuEntity gosuEntity = gosuRepository.findById(gosuChangeDTO.getGosuId()).orElse(null);
        gosuChangeDTO.setName(gosuEntity.getName());
        return gosuRepository.save(gosuEntity).getName();
    }

    @Override
    public Optional<GosuEntity> getGosuByGosuId(Long id) {
        return gosuRepository.getGosuByGosuId(id);
    }


    @Override
    public Long updateUserImage(GosuChangeDTO gosuChangeDTO) {
        GosuEntity userImage = pictureToEntity(gosuChangeDTO);
        gosuRepository.save(userImage);
        return gosuChangeDTO.getGosuId();
    }
}
