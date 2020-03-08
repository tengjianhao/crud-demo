package org.tjh.MyBatisPlus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("tbl_emp")
public class Emp {

    @TableId(value = "empno",type = IdType.AUTO)
    private Integer empno;

    private String ename;

    private String job;

    private Integer mgr;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date hiredate;

    private Integer sal;

    private Integer comm;

    @TableField("deptno")
    private Integer deptno;
}

