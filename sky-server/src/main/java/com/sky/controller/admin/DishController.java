package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Set;

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
    @GetMapping("/page")
    public Result<PageResult> page(DishPageQueryDTO dishPageQueryDTO){
        log.info("分页查询菜品:{}",dishPageQueryDTO);
        PageResult pageResult = dishService.pageQuery(dishPageQueryDTO);
        return Result.success(pageResult);
    }

    @DeleteMapping
    public Result delete(@RequestParam List<Long> ids){
        log.info("批量删除菜品：{}",ids);
        dishService.deleteInBatch(ids);

        Set keys = redisTemplate.keys("dish_*");
        redisTemplate.delete(keys);

        return Result.success();

    }
    @GetMapping("{id}")
    public Result<DishVO> getByIdWithFlavor(@PathVariable Long id){
        log.info("genjuidchacaipin:{}",id);
        DishVO dishVO =dishService.getByIdWithFlavor(id);
        return Result.success(dishVO);
    }

    @PutMapping()
    public Result update(@RequestBody DishDTO dishDTO){
        log.info("xiugaicaipin:{}",dishDTO);
        dishService.updateWithFlavor(dishDTO);
        Set keys = redisTemplate.keys("dish_*");
        redisTemplate.delete(keys);
        return Result.success();

    }
    @PostMapping("/status/{status}")
    public Result setStatus(@PathVariable Integer status,@RequestParam() Long id){
        log.info("shezhizhuangtai:{}",id);
        dishService.setStatus(status,id);
        Set keys = redisTemplate.keys("dish_*");
        redisTemplate.delete(keys);
        return Result.success();


    }
    @GetMapping("/list")
    public Result<List<Dish>> list(Long categoryId){
        log.info("genjucategoryidchacaipin:{}",categoryId);
        List<Dish> list = dishService.list(categoryId);
        return Result.success(list);

    }

}
