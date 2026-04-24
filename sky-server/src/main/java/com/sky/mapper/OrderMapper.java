package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.OrdersPageQueryDTO;
import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper

public interface OrderMapper {
    Page<Orders> pageQuery(OrdersPageQueryDTO ordersPageQueryDTO);

    @Select("select count(id) from orders where id =#{id}")
    Integer countStatus(Integer toBeConfirmed);

    @Select("select * from orders where id = #{id}")
    Orders getByiId(Long id);

    void update(Orders orders);
}
