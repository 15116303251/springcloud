package com.king.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Dept {

    private long deptNo;

    private String deptName;

    private String dbSource;

    public Dept(String deptName) {
        this.deptName = deptName;
    }
}
