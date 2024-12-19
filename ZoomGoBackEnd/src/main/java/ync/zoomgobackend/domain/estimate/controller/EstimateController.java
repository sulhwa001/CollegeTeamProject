package ync.zoomgobackend.domain.estimate.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ync.zoomgobackend.domain.estimate.dto.ExportEstimateDTO;
import ync.zoomgobackend.domain.estimate.service.ExportEstimateService;

@RequestMapping("/export")
@Controller
@RequiredArgsConstructor
public class EstimateController {

    private final ExportEstimateService exportEstimateService;

    @PostMapping("")
    public ResponseEntity<Long> getEstimate(@RequestBody ExportEstimateDTO exportEstimateDTO) {
        return null;
    }



}
