package ync.zoomgobackend.domain.estimate.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ync.zoomgobackend.domain.estimate.dto.AskEstimateDTO;
import ync.zoomgobackend.domain.estimate.entity.AskEstimateEntity;
import ync.zoomgobackend.domain.estimate.repository.AskEstimateRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AskEstimateServiceImpl implements AskEstimateService{
    private final AskEstimateRepository askEstimateRepository;

    @Override
    public Long insertEstimate(AskEstimateDTO askEstimateDTO) {
        AskEstimateEntity askEstimateEntity = EstimateDtoTOEntity(askEstimateDTO);
        askEstimateRepository.save(askEstimateEntity);
        return askEstimateEntity.getAskEstimateId();
    }

    @Override
    public Optional<AskEstimateEntity> getAskEstimateByUserNoAndGosuId(Long userNo, Long gosuId) {
        return askEstimateRepository.findByUserNoAndGosuId(userNo, gosuId);
    }
}
