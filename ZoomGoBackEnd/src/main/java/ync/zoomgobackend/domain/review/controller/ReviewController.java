package ync.zoomgobackend.domain.review.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ync.zoomgobackend.domain.review.dto.GosuReviewDTO;
import ync.zoomgobackend.domain.review.dto.UserReviewDTO;
import ync.zoomgobackend.domain.review.service.GosuReviewService;
import ync.zoomgobackend.domain.review.service.UserReviewService;

import java.util.List;

@RestController
@RequestMapping("/zoomgo/review")
@RequiredArgsConstructor
public class ReviewController {

    private final GosuReviewService gosuReviewService;
    private final UserReviewService userReviewService;

    //고수 리뷰 작성
    @PostMapping("/gosu")
    public void gosuReviewRegister(@RequestBody GosuReviewDTO gosuReviewDTO){
        gosuReviewService.register(gosuReviewDTO);
    }

    //유저 리뷰 작성
    @PostMapping("/user")
    public void userReviewRegister(@RequestBody UserReviewDTO userReviewDTO){
        userReviewService.register(userReviewDTO);
    }

    //고수 리뷰 가져오기
    @GetMapping("/gosu")
    public ResponseEntity findGosuReviewByGosuId(@RequestParam("gosuId")Long gosuId){
        List<GosuReviewDTO> gosuReviewDTOS = gosuReviewService.getAll(gosuId);
        return ResponseEntity.ok(gosuReviewDTOS);
    }

    //유저 리뷰 가져오기 2차 가공 필요
    @GetMapping("/user")
    public ResponseEntity findUserReviewByUserNo(@RequestParam("userNo")Long userNo){
        List<UserReviewDTO> userReviewDTOS = userReviewService.getAll(userNo);
        return ResponseEntity.ok(userReviewDTOS);
    }

}
