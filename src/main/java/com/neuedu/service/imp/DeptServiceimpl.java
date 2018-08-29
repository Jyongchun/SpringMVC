package com.neuedu.service.imp;

import com.neuedu.dao.DeptMapper;
import com.neuedu.entity.Dept;
import com.neuedu.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeptServiceimpl implements DeptService{
    @Autowired
    DeptMapper deptMapper;

    @Override
    public int deleteByPrimaryKey(Integer deptno) {
        return 0;
    }

    @Override
    public int insert(Dept dept) {
        return 0;
    }

    @Override
    public Dept selectByPrimaryKey(Integer deptno) {
        return null;
    }

    @Override
    public List<Dept> selectAll() {

        return deptMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Dept dept) {
        return 0;
    }
}
