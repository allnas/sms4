package com.zj.sms4.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhaojin
 */

@Getter
@AllArgsConstructor
public enum SupportDatasourceEnum {

    DEV_DB("jdbc:mysql://localhost:3306/ssm?useUnicode=true&characterEncoding=utf8", "root", "123456", "ssm"),

    TEST_DB("jdbc:mysql://localhost:3306/ssm2?useUnicode=true&characterEncoding=utf8", "root", "123456", "ssm2"),

    PROD_DB("jdbc:mysql://localhost:3306/ssm3?useUnicode=true&characterEncoding=utf8", "root", "123456", "ssm3");

    String url;

    String username;

    String password;

    String databaseName;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
