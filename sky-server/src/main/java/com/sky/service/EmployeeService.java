package com.sky.service;

import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.result.PageResult;

public interface EmployeeService {

    /**
     * 员工登录
     *
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

    /**
     * 新增员工
     *
     * @param employeeDTO
     */
    void save(EmployeeDTO employeeDTO);

    /*
     * 查询列表
     * */
    PageResult pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    void status(Integer status, long id);
/*
* 修改时获取数据
* */
    Employee getIdrow(long id);

    /*
    * 修改操作
    * */
    void editRow(EmployeeDTO employeeDTO);
}
