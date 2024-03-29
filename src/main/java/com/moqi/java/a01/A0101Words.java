package com.moqi.java.a01;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.moqi.java.Data.NON_WORDS;

/**
 * 词频统计的 Java 实现
 *
 * @author moqi
 * On 3/13/20 21:40
 */
@Slf4j
public class A0101Words {

    public static void main(String[] args) {
        Map<String, Integer> map = wordFreq("hello hello world world world");
        log.info("map:{}", map);
    }

    private static Map<String, Integer> wordFreq(@SuppressWarnings("SameParameterValue") String words) {
        TreeMap<String, Integer> wordMap = new TreeMap<>();
        Matcher m = Pattern.compile("\\w+").matcher(words);

        while (m.find()) {
            String word = m.group().toLowerCase();
            if (!NON_WORDS.contains(word)) {
                //noinspection Java8MapApi
                if (wordMap.get(word) == null) {
                    wordMap.put(word, 1);
                } else {
                    wordMap.put(word, wordMap.get(word) + 1);
                }
            }
        }

        return wordMap;
    }

}
