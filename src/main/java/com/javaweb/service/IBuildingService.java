package com.javaweb.service;

import com.javaweb.model.dto.BuildingDTO;

import java.util.List;
import java.util.Map;

public interface IBuildingService {
    List<BuildingDTO> FindBuilding(Map<String, Object> params, List<String> typeCode);
}
