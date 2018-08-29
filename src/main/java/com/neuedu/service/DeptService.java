package com.neuedu.service;

import com.neuedu.entity.Dept;

import java.util.List;

public interface DeptService {

    int deleteByPrimaryKey(Integer deptno);


    int insert(Dept dept);


    Dept selectByPrimaryKey(Integer deptno);


    List<Dept> selectAll();

    int updateByPrimaryKey(Dept dept);
}
