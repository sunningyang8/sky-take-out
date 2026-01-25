package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.constant.StatusConstant;
import com.sky.context.BaseContext;
import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.mapper.CategoryMapper;
import com.sky.result.PageResult;
import com.sky.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryServicelmpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    /*
     *查询页面
     * */
    public PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO) {
        PageHelper.startPage(categoryPageQueryDTO.getPage(), categoryPageQueryDTO.getPageSize());
        Page<Category> categories = categoryMapper.pageQuery(categoryPageQueryDTO);
        long total = categories.getTotal();
        List<Category> records = categories.getResult();
        return new PageResult(total, records);
    }

    /*
     * 启用禁用
     * */
    public void status(Integer status, long id) {
        Category category = Category.builder().id(id).status(status).build();
        categoryMapper.updateRow(category);
    }

    /*
     * 新增菜品/套餐
     * */
    public void addGory(CategoryDTO categoryDTO) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO, category);
        category.setStatus(StatusConstant.ENABLE);
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        category.setCreateUser(BaseContext.getCurrentId());
        category.setUpdateUser(BaseContext.getCurrentId());
        categoryMapper.inSrtAdd(category);
    }

    /*
     * 修改菜品/套餐
     * */
    public void editGory(CategoryDTO categoryDTO) {
        Category category = Category.builder()
                .name(categoryDTO.getName())
                .sort(categoryDTO.getSort())
                .updateUser(BaseContext.getCurrentId())
                .updateTime(LocalDateTime.now())
                .id(categoryDTO.getId())
                .build();
        categoryMapper.updateRow(category);
    }
    /*
     * 删除菜品
     * */
    public void dele(long id) {
        categoryMapper.dele(id);
    }
}
