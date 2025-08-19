package com.javaweb.service.impl;

import com.javaweb.converter.BuildingDTOConverter;
import com.javaweb.entity.AssignmentBuildingEntity;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.enums.buildingType;
import com.javaweb.enums.districtCode;
import com.javaweb.model.request.BuildingAddOrUpdateRequest;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.request.BuildingUpdateAssignmetRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;
import com.javaweb.repository.AssignmentBuildingRepository;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.repository.custom.BuildingRepositoryCustom;
import com.javaweb.repository.custom.RentareaRepositoryCustom;
import com.javaweb.service.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class BuildingServiceImpl implements IBuildingService {

    @Autowired
    private BuildingRepositoryCustom buildingRepo;
    @Autowired
    private BuildingDTOConverter buildingDTOConverter;
    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private RentareaRepositoryCustom rentareaRepositoryCustom;
    @Autowired
    private RentAreaRepository rentAreaRepository;
    @Autowired
    private AssignmentBuildingRepository assignmentBuildingRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<BuildingSearchResponse> FindBuilding(BuildingSearchRequest buildingSearchRequest) {
        List<BuildingEntity> buildingEntities = buildingRepo.searchBuilding(buildingSearchRequest);
        List<BuildingSearchResponse> responses = new ArrayList<>();
        for (BuildingEntity buildingEntity : buildingEntities) {
            BuildingSearchResponse buildingSearchResponse = buildingDTOConverter.toBuildingDTO(buildingEntity);
            responses.add(buildingSearchResponse);
        }
        return responses;
    }

    @Override
    @Transactional
    public void addOrUpdateBuilding(BuildingAddOrUpdateRequest request) {
        // Kiểm tra nếu có ID là cập nhật
        if (request.getId() != null) {
            // Update
            BuildingEntity buildingEntity = buildingRepository.findById(request.getId())
                    .orElseThrow(() -> new RuntimeException("Building not found with ID: " + request.getId()));
            validateBuildingRequest(request);
            buildingDTOConverter.toBuildingEntity(request, buildingEntity);
            BuildingEntity savedEntity = buildingRepository.save(buildingEntity);
            rentAreaRepository.deleteAllByBuildingEntityId(buildingEntity.getId());

            // lấy ra danh sách rentarea của building đó

            String[] rentAreaValues = request.getRentArea().split(",");

            for (String rentarea : rentAreaValues) {
                Integer rentareaValue = Integer.parseInt(rentarea.trim());
                RentAreaEntity rentArea = new RentAreaEntity();
                rentArea.setValue(rentareaValue);
                rentArea.setBuildingEntity(savedEntity);
                RentAreaEntity savedRentAreaEntity = rentAreaRepository.save(rentArea);
            }



        } else {
            // Add
            // Valid dữ liệu đầu vào
            validateBuildingRequest(request);
            // Tạo một đối tượng Entity mới
            BuildingEntity buildingEntity = new BuildingEntity();
            buildingDTOConverter.toBuildingEntity(request, buildingEntity);
            BuildingEntity savedEntity = buildingRepository.save(buildingEntity);
            //tạo  mới danh sách rentarea
            String rentAreaRequest = request.getRentArea();
            if (rentAreaRequest != null && !rentAreaRequest.trim().isEmpty()) {
                String[] rentAreaValues = rentAreaRequest.split(",");
                for (String rentarea : rentAreaValues) {
                    try {
                        // Trim() để loại bỏ khoảng trắng, và kiểm tra chuỗi rỗng sau khi trim
                        if (!rentarea.trim().isEmpty()) {
                            Integer rentareaValue = Integer.parseInt(rentarea.trim());
                            RentAreaEntity rentArea = new RentAreaEntity();
                            rentArea.setValue(rentareaValue);
                            rentArea.setBuildingEntity(savedEntity);
                            rentAreaRepository.save(rentArea);
                        }
                    } catch (NumberFormatException e) {
                        // Xử lý khi có dữ liệu không phải là số (ví dụ: "100,abc,200")
                        // Có thể log lỗi hoặc bỏ qua giá trị không hợp lệ
                        System.err.println("Giá trị không hợp lệ: " + rentarea);
                    }
                }
            }



        }



    }

    @Override
    public BuildingAddOrUpdateRequest findBuildingById(Long id) {
        BuildingEntity buildingEntitie = buildingRepository.findById(id).orElseThrow(() -> new RuntimeException("Building not found with ID: " + id));
        BuildingAddOrUpdateRequest result = buildingDTOConverter.toBuildingAddOrUpdateRequest(buildingEntitie);
        return result;
    }

    @Override
    @Transactional
    public void deleteBuildingById(List<Long> ids) {


            if (!ids.isEmpty()) {
                //xoá phần arentarea
                rentAreaRepository.deleteAllByBuildingEntityIdIn(ids);
                // xoá phần assdignmenbuilding
                assignmentBuildingRepository.deleteAllByBuildingIdIn(ids);
                // muốn toi uu hon thi tự tu tao ham query
                for(Long id : ids) {
                    buildingRepository.deleteById(id);
                }
            }




    }

    @Override
    public List<BuildingSearchResponse> GetAllBuildings() {
        List<BuildingEntity> buildingEntities = buildingRepository.findAll();
        List<BuildingSearchResponse> responses = new ArrayList<>();
        for (BuildingEntity buildingEntity : buildingEntities) {
            BuildingSearchResponse buildingSearchResponse = buildingDTOConverter.toBuildingDTO(buildingEntity);
            responses.add(buildingSearchResponse);
        }
        return responses;
    }

    @Override
    public List<StaffResponseDTO> GetListStaffAssignment(Long id) {
        List<UserEntity> listStaff = userRepository.findByStatusAndRoles_Code(1,"STAFF");
        List<AssignmentBuildingEntity> listStaffAssignment = assignmentBuildingRepository.findByBuildingIdIn(id);
        ResponseDTO responseDTO = new ResponseDTO();
        // dùng hashset nhanh hơn array
        Set<Long> staffIdAssignment = new HashSet<>();
        List<StaffResponseDTO> staffResponseDTO = new ArrayList<>();
        for(AssignmentBuildingEntity  item : listStaffAssignment) {
            Long idStaff = item.getUser().getId();
            staffIdAssignment.add(idStaff);
        }
        for(UserEntity item : listStaff) {
            StaffResponseDTO staffResponseDTOS = new StaffResponseDTO();
            if(staffIdAssignment.contains(item.getId())) {
                staffResponseDTOS.setStaffId(item.getId());
                staffResponseDTOS.setFullName(item.getFullName());
                staffResponseDTOS.setChecked("checked");
            }else{
                staffResponseDTOS.setStaffId(item.getId());
                staffResponseDTOS.setFullName(item.getFullName());
                staffResponseDTOS.setChecked("");
            }
            staffResponseDTO.add(staffResponseDTOS);
        }

        return staffResponseDTO;
    }

    @Override
    @Transactional
    public void UpdateStaffAssignmentBuilding(BuildingUpdateAssignmetRequest buildingUpdateAssignmetRequest) {
        if(buildingUpdateAssignmetRequest.getBuildingId() != null) {
            // xoá hết tất cả bảng ghi cũ
            assignmentBuildingRepository.deleteAllByBuildingIdIn(buildingUpdateAssignmetRequest.getBuildingId());
            // lấy ra List staff cần thêm
            List<UserEntity> staff = userRepository.findByIdIn(buildingUpdateAssignmetRequest.getStaffIds());
            // lấy ra building
            BuildingEntity buildingEntity = buildingRepository.findById(buildingUpdateAssignmetRequest.getBuildingId()).orElse(null);
            //cập nhật từng staffId
            List<AssignmentBuildingEntity> assignmentBuildingEntity = new ArrayList<>();
            for(UserEntity item : staff) {
                AssignmentBuildingEntity assignmentBuilding = new AssignmentBuildingEntity();
                assignmentBuilding.setUser(item);
                assignmentBuilding.setBuilding(buildingEntity);
                assignmentBuildingEntity.add(assignmentBuilding);
            }
            assignmentBuildingRepository.saveAll(assignmentBuildingEntity);
        }

    }

    private void validateBuildingRequest(BuildingAddOrUpdateRequest request) {
        // Kiểm tra mã quận
        String district = request.getDistrict();
        Map<String, String> validDistricts = districtCode.type();
        if (!validDistricts.containsKey(district)) {
            throw new RuntimeException("Invalid district code provided: " + district);
        }

        // Kiểm tra loại tòa nhà

        List<String> types = request.getTypeCode();
        Map<String, String> validTypes = buildingType.type();
        if (types == null || types.isEmpty()) {
            throw new RuntimeException("Building type cannot be empty.");
        }
        for(String type : types ){
            if (!validTypes.containsKey(type)) {
                throw new RuntimeException("Invalid type code provided: " + type);
            }
        }


    }



}
