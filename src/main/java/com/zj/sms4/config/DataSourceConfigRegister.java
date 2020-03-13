package com.zj.sms4.config;

import com.zj.sms4.annotation.AppDataSource;
import com.zj.sms4.core.DataSourceContextHolder;
import com.zj.sms4.enums.SupportDatasourceEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

/**
 * @author zhaojin
 */
@Slf4j
@Component
public class DataSourceConfigRegister implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        AnnotationAttributes attributes = AnnotationAttributes.fromMap(annotationMetadata.getAnnotationAttributes(AppDataSource.class.getName()));
        log.info("#######  datasource import #######");
        if (null != attributes) {
            Object object = attributes.get("datasourceType");
            SupportDatasourceEnum[] supportDatasourceEnums = (SupportDatasourceEnum[]) object;
            for (SupportDatasourceEnum supportDatasourceEnum : supportDatasourceEnums) {
                DataSourceContextHolder.addDatasource(supportDatasourceEnum);
            }
        }
        return new String[0];
    }
}
