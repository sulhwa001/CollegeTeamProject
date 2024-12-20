package ync.zoomgobackend.domain.review.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ync.zoomgobackend.domain.gosu.entity.GosuEntity;
import ync.zoomgobackend.domain.gosuportfolio.entity.GosuPortfolioEntity;
import ync.zoomgobackend.domain.member.entity.MemberEntity;
import ync.zoomgobackend.domain.review.dto.GosuReviewDTO;
import ync.zoomgobackend.domain.review.entity.GosuReviewEntity;
import ync.zoomgobackend.domain.review.repository.GosuReviewRepository;

import java.util.ArrayList;
import java.util.List;

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
    public List<GosuReviewDTO> getAll(Long gosuId) {
        List<Object[]> result = gosuReviewRepository.getByGosuId(gosuId);
        List<GosuReviewDTO> gosuReviewDTOList = new ArrayList<>();
        for(Object[] dto : result){
            gosuReviewDTOList.add(entityToDTO((GosuReviewEntity) dto[0], (MemberEntity) dto[2], (GosuEntity) dto[1], (GosuPortfolioEntity) dto[3]));
        }
        return gosuReviewDTOList;
    }


}
