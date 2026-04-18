package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.result.Result;
import com.sky.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static sun.security.ssl.SSLLogger.info;

@RestController
@RequestMapping("/admin/dish")
@Slf4j
public class DishController {
    @Autowired
    private DishService dishService;
    @Autowired
    private RedisTemplate redisTemplate;
    @PostMapping
    public Result saveDish(@RequestBody DishDTO dishDTO){
        log.info("saveDish:{}",dishDTO);
        dishService.setWithFlavor(dishDTO);

        String key = "dish_"+dishDTO.getCategoryId();
        redisTemplate.delete(key);
        return Result.success();

    }
}
