package org.tjh.MyBatisPlus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tjh.MyBatisPlus.entity.Emp;
import org.tjh.MyBatisPlus.mapper.EmpMapper;
import org.tjh.MyBatisPlus.service.EmpService;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-spring-mybatis.xml")
public class EmpServiceImplTest {
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpService empService;

    @Test
    public void save(){
        Emp emp = Emp.builder().empno(9999).ename("张三").job("程序员").sal(5000).build();
        boolean flg = empService.save(emp);
        System.out.println(flg);
    }

    @Test
    public void findById(){
        Emp emp = empService.getById(9999);
        System.out.println(emp);
    }

    @Test
    public void edit(){
        Emp emp = Emp.builder().empno(9999).ename("张三2").job("程序员2").sal(9000).build();
        boolean flg = empService.updateById(emp);
        System.out.println(flg);
    }

    @Test
    public void remove(){
        boolean flg = empService.removeById(9999);
        System.out.println(flg);
    }


    @Test
    public void list(){
        List<Emp> list = empService.list();
        list.forEach(System.out::println);
    }

    @Test
    public void page(){
        Page<Emp> page = empService.page(new Page<>(1, 5));
        System.out.println("总条数："+page.getTotal());
        page.getRecords().forEach(System.out::println);
    }

    @Test
    public void findByInfo(){

        QueryWrapper<Emp> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("ename","S")
                .like("job","S");

        List<Emp> list = empService.findByInfo(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void findByWrapper(){
        String name = "S";
        List<Emp> list = empService.lambdaQuery()
                .like(StringUtils.isNotBlank(name),Emp::getEname, name)
                .like(Emp::getJob, "S")
                //.eq(Emp::getSal,500)
                .list();
        list.forEach(System.out::println);
    }


    @Test
    // sal ==5000  or  ename 张   sal = 10000  job=程序员
    //update tbl_emp set sal = 10000 ,job = 程序员 where sal = 5000 or ename like '张%';
    public void editByWrapper(){

        boolean flg = empService.lambdaUpdate()
                .eq(Emp::getSal, 5000)
                .or() //默认是and 连接
                .likeRight(Emp::getEname, "张")
                .set(Emp::getSal, 10000)
                .set(Emp::getJob, "程序员")
                .update();
        System.out.println(flg);

    }




    @Test
    public void test1(){
        Emp emp=empService.query()
                .eq("deptno",10)
                .ne("ename","张三")
                .lt("sal",1000)
                .gt("sal",500)
                .one();
    }

    @Test
    public void test2(){
        List<Emp> empList = empService.lambdaQuery()
                .lt(Emp::getSal, 1000)
                .ge(Emp::getSal, 500)
                .like(Emp::getEname, "S")
                .notLike(Emp::getEname, "A")
                .likeRight(Emp::getEname, "S")
                .likeLeft(Emp::getEname, "L")
                .list();
    }

    @Test
    public void test3() {
        List<Emp> List = empService.lambdaQuery()
                .isNull(Emp::getComm)
                .isNotNull(Emp::getSal)
                .between(Emp::getSal, 500, 3000)
                .or()
                .notBetween(Emp::getSal, 600, 1000)
                .orderByDesc(Emp::getDeptno, Emp::getEname)
                .list();
    }

    @Test
    public void test4() {
       Emp emp=empService.lambdaQuery()
               .eq(Emp::getEmpno,7788)
               .one();
    }

    @Test
    public void test5() {
        Emp emp=empService.lambdaQuery()
                .eq(Emp::getEmpno,7788)
                .select(Emp::getEmpno,Emp::getEname,Emp::getSal)
                .one();
    }


    @Test
    public void test6() {
        boolean fig = empService.lambdaUpdate()
                .set(Emp::getEname, "张三")
                .set(Emp::getSal, 1000)
                .eq(Emp::getEmpno, 7788)
                .likeRight(Emp::getEname, "王")
                .update();
    }

    @Test
    public void test7() {
//        Emp emp = empService.lambdaQuery()
//                .eq(false, Emp::getEname, "S")
//                .eq(true, Emp::getSal, 2000)
//                .one();

        String ename=null;
        Emp emp = empService.lambdaQuery()
                .eq(StringUtils.isNotBlank(ename), Emp::getEname, ename)
                .eq(true, Emp::getSal, 2000)
                .one();
    }



}