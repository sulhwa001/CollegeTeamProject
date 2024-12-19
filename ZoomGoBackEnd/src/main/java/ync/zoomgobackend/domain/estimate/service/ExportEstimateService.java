package ync.zoomgobackend.domain.estimate.service;

import org.springframework.stereotype.Service;
import ync.zoomgobackend.domain.estimate.dto.ExportEstimateDTO;

@Service
public interface ExportEstimateService {
    public Long insertExportEstimate(ExportEstimateDTO exportEstimateDTO);
}
