package com.sky.controller.admin;

import com.sky.result.Result;
import com.sky.service.WorkSpaceService;
import com.sky.vo.BusinessDataVO;
import com.sky.vo.DishOverViewVO;
import com.sky.vo.OrderOverViewVO;
import com.sky.vo.SetmealOverViewVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/admin/workspace")
@Slf4j

public class WorkSpaceController {
    @Autowired
    private WorkSpaceService workSpaceService;
    @GetMapping("/businessDate")

    public Result<BusinessDataVO> businessDate(){
        LocalDateTime begin = LocalDateTime.now().with(LocalDateTime.MIN);
        LocalDateTime end = LocalDateTime.now().with(LocalDateTime.MAX);
        BusinessDataVO businessDateVO = workSpaceService.businessDate(begin,end);
        return Result.success(businessDateVO);
    }
    @GetMapping("/orderOverView")
    public Result<OrderOverViewVO> orderOverView(){
        OrderOverViewVO orderOverViewVO = workSpaceService.getOrderOverView();
        return Result.success(orderOverViewVO);
    }
    @GetMapping("/dishOverView")
    public Result<DishOverViewVO> dishOverView(){
        DishOverViewVO dishOverViewVO = workSpaceService.getDishOverView();
        return Result.success(dishOverViewVO);
    }

    public Result<SetmealOverViewVO> setmealOverView(){
        SetmealOverViewVO setmealOverViewVO = workSpaceService.geSetmealOverView();
        return Result.success(setmealOverViewVO);
    }
}
