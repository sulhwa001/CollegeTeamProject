package ync.zoomgobackend.domain.review.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ync.zoomgobackend.domain.gosu.entity.GosuEntity;
import ync.zoomgobackend.domain.member.entity.MemberEntity;
import ync.zoomgobackend.domain.review.dto.GosuReviewDTO;
import ync.zoomgobackend.domain.review.entity.GosuReviewEntity;
import ync.zoomgobackend.domain.review.repository.GosuReviewRepository;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class GosuReviewServiceImpl implements GosuReviewService{

    private final GosuReviewRepository gosuReviewRepository;

    @Override
    public void register(GosuReviewDTO dto) {
        GosuReviewEntity gosuReviewEntity = dtoToEntity(dto);
        gosuReviewRepository.save(gosuReviewEntity);
    }

    @Override
    public GosuReviewDTO get(Long estimateId) {
        Object result = gosuReviewRepository.getGosuReviewByEstimateId(estimateId);
        Object[] arr = (Object[]) result;
        return entityToDTO((GosuReviewEntity) arr[0],(MemberEntity) arr[1],(GosuEntity) arr[2]);
    }
}
