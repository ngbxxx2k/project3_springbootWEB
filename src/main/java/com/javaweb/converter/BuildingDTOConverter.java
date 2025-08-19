package com.javaweb.converter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.enums.districtCode;
import com.javaweb.model.request.BuildingAddOrUpdateRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.javaweb.repository.custom.RentareaRepositoryCustom;




@Component
public class BuildingDTOConverter {

    @Autowired
    private RentareaRepositoryCustom rentarearepository;
    @Autowired
    private ModelMapper modelmapper;
    // đây mà modelmapper khi dùng cho 1 đối tượng có dữ liêu và 1 đối tượng không có dl
    public BuildingSearchResponse toBuildingDTO(BuildingEntity item) {
        // đoạn map dữ liệu
        BuildingSearchResponse building = modelmapper.map(item, BuildingSearchResponse.class);
        // đoạn kết hợp dữ liệu


        String districtName = "";
        Map<String, String> districtMap = districtCode.type();
        // Kiểm tra xem mã quận có tồn tại trong Map không
        if (districtMap.containsKey(item.getDistrict())) {
            // Nếu có, lấy tên quận tương ứng
            districtName = districtMap.get(item.getDistrict());
        } else {
            // Nếu không, có thể gán giá trị mặc định hoặc xử lý lỗi
            districtName = item.getDistrict();
        }
        
        building.setAddress(item.getStreet() + "," + item.getWard()+","+ districtName);
        
        
        List<RentAreaEntity> rentareas = rentarearepository.findnamebybuildingid(item.getId());
        String rentarea = rentareas.stream().map(it ->it.getValue().toString()).collect(Collectors.joining(","));
        building.setRentArea(rentarea);
        return building;
    }
// dùng trong trường hợp cả hai có dữ liệu
    public void toBuildingEntity(BuildingAddOrUpdateRequest dto,BuildingEntity entity) {
        // Lấy danh sách type codes từ DTO
        List<String> typeCodes = dto.getTypeCode();

        // Xử lý chuyển đổi từ List<String> sang String
        // Kiểm tra null để tránh lỗi NullPointerException
        if (typeCodes != null && !typeCodes.isEmpty()) {
            // Chuyển đổi List thành một chuỗi, phân cách bằng dấu phẩy
            String typeCodeAsString = String.join(",", typeCodes);

            // Tạm thời gán chuỗi vào một đối tượng proxy DTO để ModelMapper có thể ánh xạ
            // Cách làm này không hiệu quả lắm, tôi sẽ trình bày cách tốt hơn sau
            // dto.setTypeCode(typeCodeAsString); // <-- Lỗi biên dịch

            // Thay vì gán lại, bạn có thể ánh xạ các trường khác trước,
            // sau đó cập nhật riêng trường type
            modelmapper.map(dto, entity);

            // Cập nhật riêng trường typeCode
            entity.setType(typeCodeAsString);
        } else {
            // Nếu list rỗng hoặc null, đặt giá trị null hoặc chuỗi rỗng
            entity.setType(null);
        }

    }


    public BuildingAddOrUpdateRequest toBuildingAddOrUpdateRequest(BuildingEntity item) {

        BuildingAddOrUpdateRequest building = modelmapper.map(item, BuildingAddOrUpdateRequest.class);
        List<String> typeCode = Arrays.asList(item.getType().split(","));
        building.setTypeCode(typeCode);
        List<RentAreaEntity> rentareas = rentarearepository.findnamebybuildingid(item.getId());
        String rentarea = rentareas.stream().map(it ->it.getValue().toString()).collect(Collectors.joining(","));
        building.setRentArea(rentarea);
        return building;
    }
}