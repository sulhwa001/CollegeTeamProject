package ync.zoomgobackend.domain.review.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ync.zoomgobackend.domain.review.dto.GosuReviewDTO;
import ync.zoomgobackend.domain.review.dto.UserReviewDTO;
import ync.zoomgobackend.domain.review.service.GosuReviewService;
import ync.zoomgobackend.domain.review.service.UserReviewService;

@RestController
@RequestMapping("/zoomgo/review")
@RequiredArgsConstructor
public class ReviewController {

    private final GosuReviewService gosuReviewService;
    private final UserReviewService userReviewService;

    @PostMapping("/gosu")
    public void gosuReviewRegister(@RequestBody GosuReviewDTO gosuReviewDTO){
        gosuReviewService.register(gosuReviewDTO);
    }

    @PostMapping("/user")
    public void userReviewRegister(@RequestBody UserReviewDTO userReviewDTO){
        userReviewService.register(userReviewDTO);
    }

}
