package com.sky.service.impl;

import com.sky.dto.OrdersPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Override
    public PageResult conditionQuery(OrdersPageQueryDTO ordersPageQueryDTO) {
        return null;
    }
}
