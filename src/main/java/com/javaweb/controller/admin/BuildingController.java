package com.javaweb.controller.admin;



import com.javaweb.enums.buildingType;
import com.javaweb.enums.districtCode;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.dto.BuildingDTO1;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller(value="buildingControllerOfAdmin")
public class BuildingController {



    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/admin/building-list",method = RequestMethod.GET)
    public ModelAndView buildingList(@ModelAttribute BuildingSearchRequest buildingSearchRequest, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("admin/building/list");
        mav.addObject("modelSearchBuilding",buildingSearchRequest);
        //giả dữ liệu building entitybi5 sai so với csdl
        List<BuildingDTO> listBuilding = new ArrayList<BuildingDTO>();
        BuildingDTO buildingEntity = new BuildingDTO();
        buildingEntity.setId(1L);
        buildingEntity.setName("ACM building");
        buildingEntity.setAddress("111 Lý Chính Thắng,Phường 7");
        buildingEntity.setManagerName("Nguyen gia bao");
        buildingEntity.setManagerPhone("0384017984");
        buildingEntity.setNumberOfBasement(3L);
        buildingEntity.setFloorArea(400L);
        listBuilding.add(buildingEntity);
        BuildingDTO buildingEntity1 = new BuildingDTO();
        buildingEntity1.setId(2L);
        buildingEntity1.setName("ABC building");
        buildingEntity1.setAddress("111 Lý thái tổ,Phường 6");
        buildingEntity1.setManagerName("trần thị hoài linh");
        buildingEntity1.setManagerPhone("0384017984");
        buildingEntity1.setNumberOfBasement(4L);
        buildingEntity1.setFloorArea(600L);
        listBuilding.add(buildingEntity1);


        mav.addObject("buildingEntity",listBuilding);
        mav.addObject("districtCode", districtCode.type());
        mav.addObject("typeCode", buildingType.type());
        mav.addObject("listStaff",userService.getStaffs());
        return mav;
    }

    @RequestMapping(value = "/admin/building-edit",method = RequestMethod.GET)
    public ModelAndView buildingEdit(@ModelAttribute("BuildingEdit") BuildingDTO1 buildingDTO1, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("admin/building/edit");


        mav.addObject("districtCode", districtCode.type());
        mav.addObject("typeCode", buildingType.type());


        return mav;
    }



    @RequestMapping(value = "/admin/building-edit-{id}",method = RequestMethod.GET)
    public ModelAndView buildingEdit(@PathVariable("id") Long id, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("admin/building/edit");
        //xuống db lấy dữ liệu theo id
        // giả dữ liệu
        BuildingDTO1 buildingDTO1 = new BuildingDTO1();
        buildingDTO1.setId(id);
        buildingDTO1.setName("ACM building");
        buildingDTO1.setTypeCode(Collections.singletonList("NGUYEN_CAN"));
        mav.addObject("BuildingEdit",buildingDTO1);
        mav.addObject("districtCode", districtCode.type());
        mav.addObject("typeCode", buildingType.type());


        return mav;
    }

}
