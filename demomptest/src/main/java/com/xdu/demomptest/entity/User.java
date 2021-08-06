package com.xdu.demomptest.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data//自动生成geter、seter
public class User {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @TableField(fill = FieldFill.INSERT)//在执行insert时填充该值
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)//添加和更改都填充
    private Date updateTime;
    @Version//乐观锁中使用的版本号
    @TableField(fill = FieldFill.INSERT)
    private Integer version;
    @TableLogic
    @TableField(fill = FieldFill.INSERT)//在执行insert时填充该值
    private Integer deleted;

}
