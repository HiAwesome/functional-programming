package com.moqi.java.a01;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author moqi
 * On 3/13/20 21:48
 */
@Slf4j
public class A0102WordsJava8 {

    private static final Set<String> NON_WORDS = new HashSet<String>() {{
        add("the");
        add("and");
        add("of");
        add("to");
        add("a");
        add("i");
        add("it");
        add("in");
        add("or");
        add("is");
        add("d");
        add("s");
        add("as");
        add("so");
        add("but");
        add("be");
    }};

    public static void main(String[] args) {
        Map<String, Integer> map = wordFreq("hello hello world nike nike nike nike world world");
        log.info("map:{}", map);
    }

    private static List<String> regexToList(String words) {
        List<String> wordList = new ArrayList<>();
        Matcher m = Pattern.compile("\\w+").matcher(words);

        while (m.find()) {
            wordList.add(m.group());
        }

        return wordList;
    }

    private static Map<String, Integer> wordFreq(@SuppressWarnings("SameParameterValue") String words) {
        TreeMap<String, Integer> wordMap = new TreeMap<>();
        regexToList(words).stream()
                .map(String::toLowerCase)
                .filter(w -> !NON_WORDS.contains(w))
                .forEach(w -> wordMap.put(w, wordMap.getOrDefault(w, 0) + 1));

        return wordMap;
    }

}
