package com.king.springcloud.service;

import com.king.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {

        return new DeptClientService() {
            @Override
            public Dept get(long id) {
                return new Dept().setDeptNo(id).setDeptName("该Id："+id+"没有对应的信息，null --@HystricCommand").setDbSource("no this data in database");
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public boolean add(Dept dept) {
                return false;
            }
        };
    }
}
