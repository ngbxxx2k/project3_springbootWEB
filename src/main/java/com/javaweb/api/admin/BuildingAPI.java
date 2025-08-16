package com.javaweb.api.admin;

import com.javaweb.model.dto.BuildingDTO1;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/building")
public class BuildingAPI {

    @PostMapping
    public BuildingDTO1 addOrUpdateBuilding(@RequestBody BuildingDTO1 buildingDTO1) {
        //xuong db lấy dữ liệu
        //xuống service kiễm tra nếu có id là sửa không có id là thêm mới , cùng 1 hàm service
        return buildingDTO1;
    }

    @DeleteMapping("/{ids}")
    public void deleteBuilding(@PathVariable List<Long> ids) {
        //xuống repo để xoá toà nhà theo danh sách id
        System.out.println(ids);
    }
}
