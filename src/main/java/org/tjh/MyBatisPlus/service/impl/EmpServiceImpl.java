package org.tjh.MyBatisPlus.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.tjh.MyBatisPlus.entity.Emp;
import org.tjh.MyBatisPlus.mapper.EmpMapper;
import org.tjh.MyBatisPlus.service.EmpService;

import java.util.List;

@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper,Emp> implements EmpService{
    @Override
    public List<Emp> findByInfo(Wrapper wrapper) {
        return baseMapper.findByInfo(wrapper);
    }
}
