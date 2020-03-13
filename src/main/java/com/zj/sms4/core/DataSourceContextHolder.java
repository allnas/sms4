package com.zj.sms4.core;

import com.zj.sms4.enums.SupportDatasourceEnum;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhaojin
 */
public class DataSourceContextHolder {

    private DataSourceContextHolder(){}

    private static final HashSet<SupportDatasourceEnum> DATA_SOURCE_SET = new HashSet<>();

    private static final ThreadLocal<String> DATABASE_HOLDER = new ThreadLocal<>();

    public static void setDatabaseHolder(SupportDatasourceEnum supportDatasourceEnum) {
        DATABASE_HOLDER.set(supportDatasourceEnum.toString());
    }

    /**
     * 取得当前数据源
     *
     * @return
     */
    public static String getDatabaseHolder() {
        return DATABASE_HOLDER.get();
    }

    /**
     * 添加数据源
     *
     * @param supportDatasourceEnum
     */
    public static void addDatasource(SupportDatasourceEnum supportDatasourceEnum) {
        DATA_SOURCE_SET.add(supportDatasourceEnum);
    }

    /**
     * 获取当期应用所支持的所有数据源
     *
     * @return
     */
    public static HashSet<SupportDatasourceEnum> getDataSourceSet() {
        return DATA_SOURCE_SET;
    }

    /**
     * 清除上下文数据
     */
    public static void clear() {
        DATABASE_HOLDER.remove();
    }
}
