package com.zj.sms4.aop;

import com.zj.sms4.annotation.UsingDataSource;
import com.zj.sms4.core.DataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhaojin
 */
@Slf4j
@Aspect
@Configuration
public class DataSourceAspect {

    public DataSourceAspect() {
        log.info("#######  init DataSource Aspect #######");
    }

    @Pointcut("@within(com.zj.sms4.annotation.UsingDataSource) || " +
            "@annotation(com.zj.sms4.annotation.UsingDataSource)")
    public void pointCut() {

    }

    @Before("pointCut() && @annotation(usingDataSource)")
    public void doBefore(UsingDataSource usingDataSource) {
        log.debug("select dataSource---" + usingDataSource.type());
        DataSourceContextHolder.setDatabaseHolder(usingDataSource.type());
    }

    @After("pointCut()")
    public void doAfter() {
        DataSourceContextHolder.clear();
    }

}
