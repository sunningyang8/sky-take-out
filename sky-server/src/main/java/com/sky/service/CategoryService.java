package com.sky.service;

import com.github.pagehelper.Page;
import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;

public interface CategoryService {
    /*
     *查询页面
     * */
    PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);
    /*
     * 启用禁用
     * */
    void status(Integer status,long id);

    void addGory(CategoryDTO categoryDTO);


    void editGory(CategoryDTO categoryDTO);

    void dele(long id);
}
