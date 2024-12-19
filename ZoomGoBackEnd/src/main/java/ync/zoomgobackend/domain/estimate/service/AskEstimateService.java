package ync.zoomgobackend.domain.estimate.service;

import org.springframework.stereotype.Service;
import ync.zoomgobackend.domain.estimate.dto.AskEstimateDTO;
import ync.zoomgobackend.domain.estimate.entity.AskEstimateEntity;
import ync.zoomgobackend.domain.gosu.entity.GosuEntity;
import ync.zoomgobackend.domain.member.entity.MemberEntity;

import java.util.Optional;

@Service
public interface AskEstimateService {
    public Long insertEstimate(AskEstimateDTO askEstimateDTO);
    public Optional<AskEstimateEntity> getAskEstimateByUserNoAndGosuId(Long userNo, Long gosuId);
    default AskEstimateEntity EstimateDtoTOEntity(AskEstimateDTO askEstimateDTO) {
        MemberEntity user = MemberEntity.builder().userNo(askEstimateDTO.getUserNo()).build();
        GosuEntity gosu = GosuEntity.builder().gosuId(askEstimateDTO.getGosuId()).build();
        return AskEstimateEntity.builder()
                .gosuId(gosu)
                .userNo(user)
                .address(askEstimateDTO.getAddress())
                .date(askEstimateDTO.getDate())
                .question(askEstimateDTO.getQuestion())
                .build();
    }

}
