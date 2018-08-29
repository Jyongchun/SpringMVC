package com.neuedu.service;

import com.neuedu.entity.Emp;

import java.util.List;

public interface EmpService {


    int deleteByPrimaryKey(Integer empno);


    int insert(Emp emp);


    Emp selectByPrimaryKey(Integer empno);


    //查看员工信息
    List<Emp> selectAll();


    int update(Emp emp);
}
