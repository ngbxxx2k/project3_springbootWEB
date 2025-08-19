package com.javaweb.service;

import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingAddOrUpdateRequest;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.request.BuildingUpdateAssignmetRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;

import java.util.List;
import java.util.Map;

public interface IBuildingService {
    List<BuildingSearchResponse> FindBuilding(BuildingSearchRequest buildingSearchRequest);
    void addOrUpdateBuilding(BuildingAddOrUpdateRequest buildingAddOrUpdateRequest);
    BuildingAddOrUpdateRequest findBuildingById(Long id);
    void deleteBuildingById(List<Long> ids);
    List<BuildingSearchResponse> GetAllBuildings();
    List<StaffResponseDTO> GetListStaffAssignment(Long id);
    void UpdateStaffAssignmentBuilding(BuildingUpdateAssignmetRequest buildingUpdateAssignmetRequest);
}
