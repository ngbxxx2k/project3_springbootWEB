package com.javaweb.api.admin;

import com.javaweb.model.dto.BuildingDTO1;
import com.javaweb.model.request.BuildingAddOrUpdateRequest;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.request.BuildingUpdateAssignmetRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;
import com.javaweb.service.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/building")
public class BuildingAPI {

    @Autowired
    IBuildingService buildingService;

    @GetMapping("/Search")
    public ResponseEntity<ResponseDTO> searchBuilding(@Valid BuildingSearchRequest buildingSearchRequest) {
        List<BuildingSearchResponse> responseList = buildingService.FindBuilding(buildingSearchRequest);
        ResponseDTO response = new ResponseDTO();
        response.setMessage("success");
        response.setData(responseList);
        response.setDetail("tìm kiếm toà nhà thành công");
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity addOrUpdateBuilding(@Valid @RequestBody BuildingAddOrUpdateRequest buildingAddOrUpdateRequest) {
        //xuống service kiễm tra nếu có id là sửa không có id là thêm mới , cùng 1 hàm service
        buildingService.addOrUpdateBuilding(buildingAddOrUpdateRequest);
        ResponseDTO response = new ResponseDTO();
        response.setMessage("success");
        response.setDetail("thêm hoặc cập nhật thành công");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<ResponseDTO> deleteBuilding(@RequestBody List<Long> ids) {
        System.out.println("IDs nhận được: " + ids);
        if (ids == null || ids.isEmpty()) {
            ResponseDTO response = new ResponseDTO();
            response.setMessage("Danh sách ID trống");
            return ResponseEntity.badRequest().body(response);
        }
        buildingService.deleteBuildingById(ids);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<ResponseDTO> getAllBuildings() {
        List<BuildingSearchResponse> buildingSearchResponse = buildingService.GetAllBuildings();
        ResponseDTO response = new ResponseDTO();
        response.setMessage("lấy danh sách tòa nhà thành công.");
        response.setData(buildingSearchResponse);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/staff")
    public ResponseEntity<ResponseDTO> getListStaffAssigment(@PathVariable Long id) {
        List<StaffResponseDTO> staffResponseList  = buildingService.GetListStaffAssignment(id);
        ResponseDTO response = new ResponseDTO();
        response.setData(staffResponseList);
        response.setMessage("success");
        response.setDetail("tìm kiếm thành công");
        return ResponseEntity.ok(response);
    }
    @PostMapping("/assignment")
    public ResponseEntity<ResponseDTO> updateAssignmentBuilding(@Valid @RequestBody BuildingUpdateAssignmetRequest buildingUpdateAssignmetRequest) {
        buildingService.UpdateStaffAssignmentBuilding(buildingUpdateAssignmetRequest);
        ResponseDTO response = new ResponseDTO();
        response.setMessage("success");
        response.setDetail("Cập nhật thành công");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
