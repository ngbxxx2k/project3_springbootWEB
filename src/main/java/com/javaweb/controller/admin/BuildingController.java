package com.javaweb.controller.admin;



import com.javaweb.enums.buildingType;
import com.javaweb.enums.districtCode;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.dto.BuildingDTO1;
import com.javaweb.model.request.BuildingAddOrUpdateRequest;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.service.IBuildingService;
import com.javaweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller(value="buildingControllerOfAdmin")
public class BuildingController {



    @Autowired
    private IUserService userService;
    @Autowired
    private IBuildingService buildingService;

    @RequestMapping(value = "/admin/building-list",method = RequestMethod.GET)
    public ModelAndView buildingList(@ModelAttribute BuildingSearchRequest buildingSearchRequest, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("admin/building/list");
        mav.addObject("modelSearchBuilding",buildingSearchRequest);
//        List<BuildingSearchResponse> responseList = buildingService.FindBuilding(buildingSearchRequest);
//        mav.addObject("buildingEntity",responseList);
        mav.addObject("districtCode", districtCode.type());
        mav.addObject("type", buildingType.type());
        mav.addObject("listStaff",userService.getStaffs());
        return mav;
    }

    @RequestMapping(value = "/admin/building-edit",method = RequestMethod.GET)
    public ModelAndView buildingEdit(@ModelAttribute("BuildingEdit") BuildingAddOrUpdateRequest buildingAddOrUpdateRequest, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("admin/building/edit");


        mav.addObject("districtCode", districtCode.type());
        mav.addObject("typeCode", buildingType.type());


        return mav;
    }



    @RequestMapping(value = "/admin/building-edit-{id}",method = RequestMethod.GET)
    public ModelAndView buildingEdit(@PathVariable("id") Long id, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("admin/building/edit");
        //xuống db lấy dữ liệu theo id
        BuildingAddOrUpdateRequest buildingAddOrUpdateRequest = buildingService.findBuildingById(id);

        mav.addObject("BuildingEdit",buildingAddOrUpdateRequest);
        mav.addObject("districtCode", districtCode.type());
        mav.addObject("typeCode", buildingType.type());


        return mav;
    }

}
