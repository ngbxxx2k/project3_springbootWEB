//package com.javaweb.service.impl;
//
//import com.javaweb.model.dto.BuildingDTO;
//
//import java.util.List;
//import java.util.Map;
//
//public class BuildingService {
//    @Autowired
//    private BuildingRepository buildingRepository;
//    @Autowired
//    private BuildingDTOConverter buildingDTOConverter;
//    @Autowired
//    private BuildingSearchBuilderConverter buildingSearchBuilderConverter;
//
//    @Override
//    public List<BuildingDTO> FindBuilding(Map<String, Object> params, List<String> typeCode) {
//        BuildingSearchBuilder buildingSearchBuilder = buildingSearchBuilderConverter.tobuldingsearchbuilder(params,
//                typeCode);
//        List<BuildingEntity> buildingEntities = buildingRepository.findAll();
//        List<BuildingDTO> result = new ArrayList<BuildingDTO>();
//        for (BuildingEntity item : buildingEntities) {
//            BuildingDTO building = buildingDTOConverter.toBuildingDTO(item);
//
//            result.add(building);
//        }
//
//        return result;
//    }
//}
