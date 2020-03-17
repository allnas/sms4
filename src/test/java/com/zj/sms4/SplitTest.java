package com.zj.sms4;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Objects;

/**
 * @className: Fun
 * @description: TODO 类描述
 * @author: allnas
 * @date: 2020/3/16
 **/
@Slf4j
public class SplitTest {
    public static void main(String[] args) {
        String str = "20200305|01|6230780501000540518|1101339558|宋小|重庆分行营业部|66.76%|正常|0.00|0|02|116782.46|109343.74|36346.54|-72997.20|0.00|0.00|0.00|0.00|0.00|0.00|0.00|-49559.40|0.00|0.00|03|0.00|0.00|0.00|0.00|-7480.00|-80.38|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|0.00|121.66|0.00|0.00|-7438.72|05|Au(T+D)|多仓|2|1|0|0|0|3|267.23|270.36|05|Au(T+D)|空仓|0|0|0|0|0|0|0|0|06|Au(T+D)|270.36|-7480.00|06|合计||-7480.00|07|20200305|2003050200000366|02000638|Au(T+D)|延期开多仓|267.9|1|267900|80.38|07||合计| |Au(T+D)| |267.9|1|267900|80.38|08||合计|||||0|";

        int cnt01 = StringUtils.countMatches(str, "|01|");
        int cnt02 = StringUtils.countMatches(str, "|02|");
        int cnt03 = StringUtils.countMatches(str, "|03|");
        int cnt04 = StringUtils.countMatches(str, "|04|");
        int cnt05 = StringUtils.countMatches(str, "|05|");
        int cnt06 = StringUtils.countMatches(str, "|06|");
        int cnt07 = StringUtils.countMatches(str, "|07|");
        int cnt08 = StringUtils.countMatches(str, "|08|");
        log.debug("cnt01:[{}], cnt02:[{}], cnt03:[{}], cnt04:[{}], cnt05:[{}], cnt06:[{}], cnt07:[{}], cnt08:[{}]", cnt01, cnt02, cnt03, cnt04, cnt05, cnt06, cnt07, cnt08);

        int idx02 = StringUtils.ordinalIndexOf(str, "|02|", 1);
        int idx03 = StringUtils.ordinalIndexOf(str, "|03|", 1);
        int idx04 = StringUtils.ordinalIndexOf(str, "|04|", 1);
        int idx05 = StringUtils.ordinalIndexOf(str, "|05|", 1);
        int idx06 = StringUtils.ordinalIndexOf(str, "|06|", 1);
        int idx07 = StringUtils.ordinalIndexOf(str, "|07|", 1);
        int idx08 = StringUtils.ordinalIndexOf(str, "|08|", 1);
        log.debug("idx02:[{}], idx03:[{}], idx04:[{}], idx05:[{}], idx06:[{}], idx07:[{}], idx08:[{}]", idx02, idx03, idx04, idx05, idx06, idx07, idx08);

        String str01 = StringUtils.substring(str, 0, Arrays.asList(idx02, idx03, idx04, idx05, idx06, idx07, idx08).stream().filter(idx -> idx > 0).findFirst().get());
        log.info("01:[{}]", cnt01 > 1 ? split("|01|", str01, cnt01) : str01);

        String str02 = StringUtils.substring(str, idx02, Arrays.asList(idx03, idx04, idx05, idx06, idx07, idx08).stream().filter(idx -> idx > 0).findFirst().get());
        log.info("02:[{}]", cnt02 > 1 ? split("|02|", str02, cnt02) : str02);

        String str03 = StringUtils.substring(str, idx03, Arrays.asList(idx04, idx05, idx06, idx07, idx08).stream().filter(idx -> idx > 0).findFirst().get());
        log.info("03:[{}]", cnt03 > 1 ? split("|03|", str03, cnt03) : str03);

        String str04 = StringUtils.substring(str, idx04, Arrays.asList(idx05, idx06, idx07, idx08).stream().filter(idx -> idx > 0).findFirst().get());
        log.info("04:[{}]", cnt04 > 1 ? split("|04|", str04, cnt04) : str04);

        String str05 = StringUtils.substring(str, idx05, Arrays.asList(idx06, idx07, idx08).stream().filter(idx -> idx > 0).findFirst().get());
        log.info("05:[{}]", cnt05 > 1 ? split("|05|", str05, cnt05) : str05);

        String str06 = StringUtils.substring(str, idx06, Arrays.asList(idx07, idx08).stream().filter(idx -> idx > 0).findFirst().get());
        log.info("06:[{}]", cnt06 > 1 ? split("|06|", str06, cnt06) : str06);

        String str07 = StringUtils.substring(str, idx07, idx08);
        log.info("07:[{}]", cnt07 > 1 ? split("|07|", str07, cnt07) : str07);

        String str08 = StringUtils.substring(str, idx08);
        log.info("08:[{}]", cnt08 > 1 ? split("|08|", str08, cnt08) : str08);
    }

    private static String split(String search, String str, int cnt) {
        String split = "Ω";
        int idx = 0, curIdx = 0;
        StringBuilder stringBuilder = new StringBuilder(16);

        for (int i = 2; i <= cnt + 1; i++) {
            curIdx = StringUtils.ordinalIndexOf(str, search, i);
            if (Objects.equals(curIdx, -1)) {
                stringBuilder.append(split + StringUtils.substring(str, idx));
            } else {
                stringBuilder.append(split + StringUtils.substring(str, idx, StringUtils.ordinalIndexOf(str, search, i)));
            }
            idx = StringUtils.ordinalIndexOf(str, search, i);
        }
        return stringBuilder.substring(1);
    }
}
