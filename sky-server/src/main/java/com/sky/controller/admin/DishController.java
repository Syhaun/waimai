package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.Dishservice;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
菜品管理
 */
@Slf4j
@Api(tags = "菜品相关接口")
@RequestMapping("/admin/dish")
@RestController
public class DishController {
    /**
     * 新增菜品
     * @param dishDTO
     * @return
     */
     @Autowired
    private Dishservice dishservice;
    @ApiOperation("新增菜品")
    @PostMapping
    public Result save(@RequestBody DishDTO dishDTO) {
        log.info("新增菜品:{}",dishDTO);
        dishservice.saveWithFlavor(dishDTO);
        return Result.success();
    }
    @ApiOperation("菜品分页查询")
    @GetMapping("/page")
    public  Result<PageResult> page(DishPageQueryDTO dishPageQueryDTO) {
        log.info("菜品分页查询:{}",dishPageQueryDTO);
        PageResult pageResult = dishservice.pageQuery(dishPageQueryDTO);
        return Result.success(pageResult);
    }
}
