package com.sky.controller.admin;


import com.github.pagehelper.Page;
import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/category")
@Slf4j
@Api(tags = "分类管理")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /*
    *查询页面
    * */
    @ApiOperation("查询页面")
    @GetMapping("/page")
    public Result<PageResult> pageQuery(CategoryPageQueryDTO  categoryPageQueryDTO) {
        PageResult pageResult = categoryService.pageQuery(categoryPageQueryDTO);
        return Result.success(pageResult);
    }
    /*
    * 启用禁用
    * */
    @PostMapping("/status/{status}")
    @ApiOperation("启用禁用")
    public Result status(@PathVariable Integer status,long id) {
        categoryService.status(status,id);
        return Result.success();
    }
    /*
    * 新增菜品/套餐
    * */
    @PostMapping
    @ApiOperation("新增")
    public Result addCategory(@RequestBody CategoryDTO categoryDTO){
        categoryService.addGory(categoryDTO);
        return Result.success();
    }

    /*
     * 修改菜品/套餐
     * */
    @PutMapping
    @ApiOperation("修改")
    public Result editCategory(@RequestBody CategoryDTO categoryDTO){
        categoryService.editGory(categoryDTO);
        return Result.success();
    }

    /*
    * 删除菜品
    * */
    @DeleteMapping
    @ApiOperation("删除")
    public Result deleteCategory(long id){
        log.info("id:{}",id);
        categoryService.dele(id);
        return Result.success();
    }
}
