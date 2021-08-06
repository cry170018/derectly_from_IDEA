package com.xdu.demomptest.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component//将类的创建交给spring来管理
public class MyMetaObjectHandler implements MetaObjectHandler {
    //mp执行添加操作时，这个方法执行
    @Override
    public void insertFill(MetaObject metaObject) {
        //执行时会把执行时间set到createTime中去
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
        //把初始版本号1加入version中
        this.setFieldValByName("version",1,metaObject);
        this.setFieldValByName("deleted",0,metaObject);

    }

    //mp执行更改操作时，这个方法执行
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", new Date(), metaObject);

    }
}
