package com.moqi.java.a02;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static com.moqi.java.Data.NAME_LIST;

/**
 * 典型的公司业务处理例子（Java 实现）
 *
 * @author moqi
 * On 3/13/20 22:30
 */
@Slf4j
public class A0201TheCompanyProcess {


    public static void main(String[] args) {
        String names = new A0201TheCompanyProcess().cleanNames(NAME_LIST);
        log.info("names:{}", names);
    }

    public String cleanNames(List<String> listOfNames) {
        StringBuilder result = new StringBuilder();

        for (String listOfName : listOfNames) {
            if (listOfName.length() > 1) {
                result.append(capitalizeString(listOfName)).append(",");
            }
        }

        return result.substring(0, result.length() - 1);
    }

    public String capitalizeString(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

}
