package com.sky.controller.admin;

import com.sky.result.Result;
import com.sky.service.WorkSpaceService;
import com.sky.vo.BusinessDataVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/admin/workspace")
@Slf4j

public class WorkSpaceController {
    @Autowired
    private WorkSpaceService workSpaceService;

    public Result<BusinessDataVO> businessDate(){
        LocalDateTime begin = LocalDateTime.now().with(LocalDateTime.MIN);
        LocalDateTime end = LocalDateTime.now().with(LocalDateTime.MAX);
        BusinessDataVO businessDateVO = workSpaceService.businessDate(begin,end);
        return Result.success(businessDateVO);
    }
}
