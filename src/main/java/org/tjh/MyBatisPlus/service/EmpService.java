package org.tjh.MyBatisPlus.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import org.tjh.MyBatisPlus.entity.Emp;

import java.util.List;

public interface EmpService extends IService<Emp> {
    List<Emp> findByInfo(Wrapper wrapper);
}
