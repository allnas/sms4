package com.zj.sms4;

import com.zj.sms4.annotation.AppDataSource;
import com.zj.sms4.enums.SupportDatasourceEnum;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhaojin
 */
@SpringBootApplication
@AppDataSource(datasourceType = {SupportDatasourceEnum.DEV_DB, SupportDatasourceEnum.TEST_DB, SupportDatasourceEnum.PROD_DB})
public class Sms4Application {

    public static void main(String[] args) {
        SpringApplication.run(Sms4Application.class, args);
    }

}
