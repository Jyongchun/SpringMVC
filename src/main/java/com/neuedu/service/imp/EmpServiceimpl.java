package com.neuedu.service.imp;

import com.neuedu.dao.EmpMapper;
import com.neuedu.entity.Dept;
import com.neuedu.entity.Emp;
import com.neuedu.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmpServiceimpl implements EmpService{
    @Autowired
    EmpMapper empMapper;


    @Override
    public int deleteByPrimaryKey(Integer empno) {
        return empMapper.deleteByPrimaryKey(empno);
    }

    //添加
    @Override
    public int insert(Emp emp){
        return empMapper.insert(emp);
    }

    @Override
    public Emp selectByPrimaryKey(Integer empno) {
        return empMapper.selectByPrimaryKey(empno);
    }

    @Override
    public List<Emp> selectAll() {
        return empMapper.selectAll();
    }

    @Override
    public int update(Emp emp) {
        return empMapper.updateByPrimaryKey(emp);
    }


}
