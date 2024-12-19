package ync.zoomgobackend.domain.estimate.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ync.zoomgobackend.domain.estimate.dto.AskEstimateDTO;
import ync.zoomgobackend.domain.estimate.entity.AskEstimateEntity;
import ync.zoomgobackend.domain.estimate.service.AskEstimateService;

@Controller
@RequestMapping("/estimate")
@RequiredArgsConstructor
public class AskEstimateController {

    private final AskEstimateService askEstimateService;

    @PostMapping("")
    public ResponseEntity<Long> postEstimate(@RequestBody AskEstimateDTO askEstimateDTO) {
        Long id = askEstimateService.insertEstimate(askEstimateDTO);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/selectEstimate")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AskEstimateEntity> selectEstimate(
            @RequestParam("userNo") Long userNo,
            @RequestParam("gosuId") Long gosuId
    ) {
        return askEstimateService.
                getAskEstimateByUserNoAndGosuId(userNo, gosuId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
