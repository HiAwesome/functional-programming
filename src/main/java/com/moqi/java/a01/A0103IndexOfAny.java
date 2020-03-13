package com.moqi.java.a01;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * 取自 Apache Commons 工具类 StringUtils 的 indexOfAny() 方法
 * @see org.apache.commons.lang3.StringUtils#indexOfAny(CharSequence, char...)
 *
 * @author moqi
 * On 3/13/20 21:48
 */
@Slf4j
public class A0103IndexOfAny {

    /**
     * indexOfAny() 的用法示例
     */
    public static void main(String[] args) {
        int i = StringUtils.indexOfAny("zzabyycdxx", 'z', 'a');
        log.info("i:{}", i);
        int j = StringUtils.indexOfAny("zzabyycdxx", 'b', 'y');
        log.info("j:{}", j);
        int m = StringUtils.indexOfAny("aba", 'z');
        log.info("m:{}", m);
    }
}
