package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {
    Page<Category> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    void updateRow(Category category);
    /**
     *
     *
     * @param category
     */
    void inSrtAdd(Category category);

    void dele(long id);
}
