package com.king.springcloud.service;

import com.king.springcloud.entities.Dept;

import java.util.List;

public interface DeptService {

    public boolean addDept(Dept dept);

    public Dept findById(Long id);

    public List<Dept> findAll();
}
