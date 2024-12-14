package ync.zoomgobackend.domain.review.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ync.zoomgobackend.domain.review.dto.UserReviewDTO;
import ync.zoomgobackend.domain.review.entity.UserReviewEntity;
import ync.zoomgobackend.domain.review.repository.UserReviewRepository;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class UserReviewServiceImpl implements UserReviewService{

    private final UserReviewRepository userReviewRepository;

    @Override
    public void register(UserReviewDTO userReviewDTO) {
        UserReviewEntity userReviewEntity = dtoToEntity(userReviewDTO);
        userReviewRepository.save(userReviewEntity);
    }

}
