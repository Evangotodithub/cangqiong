package com.sky.service;

import com.sky.vo.BusinessDataVO;

import java.time.LocalDateTime;

public interface WorkSpaceService {
    BusinessDataVO businessDate(LocalDateTime begin, LocalDateTime end);
}
