package com.zj.sms4.web;

import com.zj.sms4.annotation.UsingDataSource;
import com.zj.sms4.enums.SupportDatasourceEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaojin
 */
@Slf4j
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final JdbcTemplate jdbcTemplate;

    @GetMapping(value = "/testDev")
    @UsingDataSource(type = SupportDatasourceEnum.DEV_DB)
    public void testDev() {
        showData();
    }

    @GetMapping(value = "/testTest")
    @UsingDataSource(type = SupportDatasourceEnum.TEST_DB)
    public void testTest() {
        showData();
    }

    @GetMapping(value = "/testProd")
    @UsingDataSource(type = SupportDatasourceEnum.PROD_DB)
    public void testProd() {
        showData();
    }

    private void showData() {
        jdbcTemplate.queryForList("select * from t_user").forEach(row -> log.info(row.toString()));
    }
}
