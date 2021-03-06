package com.zj.sms4.annotation;

import com.zj.sms4.config.DataSourceConfigRegister;
import com.zj.sms4.enums.SupportDatasourceEnum;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhaojin
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(DataSourceConfigRegister.class)
public @interface AppDataSource {

    SupportDatasourceEnum[] datasourceType();
}
