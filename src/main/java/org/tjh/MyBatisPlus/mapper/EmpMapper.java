package org.tjh.MyBatisPlus.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.tjh.MyBatisPlus.entity.Emp;

import java.util.List;

public interface EmpMapper extends BaseMapper<Emp> {
    List<Emp> findByInfo(Wrapper wrapper);
}
