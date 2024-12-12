package ync.zoomgobackend.domain.review.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ync.zoomgobackend.domain.review.dto.GosuReviewDTO;
import ync.zoomgobackend.domain.review.service.GosuReviewService;
import ync.zoomgobackend.domain.review.service.UserReviewService;

@RestController
@RequestMapping("/zoomgo/review")
@RequiredArgsConstructor
public class ReviewController {

    private final GosuReviewService gosuReviewService;
    private final UserReviewService userReviewService;

//    @GetMapping("/gosu")
//    public ResponseEntity findReviewById(@RequestParam("estimateId")Long estimateId){
//        GosuReviewDTO gosuReviewDTO = gosuReviewService.get(estimateId);
//        return ResponseEntity.ok(gosuReviewDTO);
//    }
}
