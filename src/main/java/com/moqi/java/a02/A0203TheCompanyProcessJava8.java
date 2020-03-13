package com.moqi.java.a02;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

import static com.moqi.java.Data.NAME_LIST;

/**
 * 　 Java 8 实现的 Process 过程
 *
 * @author moqi
 * On 3/13/20 22:30
 */
@Slf4j
public class A0203TheCompanyProcessJava8 {


    public static void main(String[] args) {
        String names = new A0203TheCompanyProcessJava8().cleanNames(NAME_LIST);
        log.info("names:{}", names);
    }


    /**
     * java8_process
     */
    public String cleanNames(List<String> names) {
        if (names == null) return "";
        //noinspection Convert2MethodRef
        return names
                .stream()
                .filter(name -> name.length() > 1)
                .map(name -> capitalize(name))
                .collect(Collectors.joining(","));
    }

    private String capitalize(String e) {
        return e.substring(0, 1).toUpperCase() + e.substring(1);
    }


    /**
     * java8_process_parallel
     */
    public String cleanNamesP(List<String> names) {
        if (names == null) return "";
        //noinspection Convert2MethodRef
        return names
                .parallelStream()
                .filter(n -> n.length() > 1)
                .map(e -> capitalize(e))
                .collect(Collectors.joining(","));
    }
}
