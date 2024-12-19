package ync.zoomgobackend.domain.estimate.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ync.zoomgobackend.domain.estimate.dto.ExportEstimateDTO;
import ync.zoomgobackend.domain.estimate.repository.ExportEstimateRepository;

@Service
@RequiredArgsConstructor
public class ExportEstimateServiceImpl implements ExportEstimateService{
    private final ExportEstimateRepository exportEstimateRepository;


    @Override
    public Long insertExportEstimate(ExportEstimateDTO exportEstimateDTO) {
        return null;
    }
}
