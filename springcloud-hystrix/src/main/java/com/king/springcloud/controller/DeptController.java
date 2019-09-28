package com.king.springcloud.controller;

import com.king.springcloud.entities.Dept;
import com.king.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;


    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept){
        return deptService.addDept(dept);
    }

    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    @RequestMapping(value = "/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        Dept dept=deptService.findById(id);
        if(null==dept){
            throw new RuntimeException("该ID"+id +"不存在没有对用的信息");
        }
        return dept;
    }

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> list(){
        return deptService.findAll();
    }

    public Dept processHystrix_Get(@PathVariable("id") Long id){
        return new Dept().setDeptNo(id).setDeptName("该Id："+id+"没有对应的信息，null --@HystricCommand").setDbSource("no this data in mysql");
    }
}
