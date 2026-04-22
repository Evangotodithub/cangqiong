package com.sky.service;

import com.sky.dto.OrdersPageQueryDTO;
import com.sky.result.PageResult;

public interface OrderService {
    PageResult conditionQuery(OrdersPageQueryDTO ordersPageQueryDTO);
}
