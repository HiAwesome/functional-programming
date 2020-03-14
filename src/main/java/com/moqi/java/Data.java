package com.moqi.java;

import java.util.*;

/**
 * @author moqi
 * On 3/13/20 22:36
 */

public class Data {

    public static final List<String> NAME_LIST = Collections.unmodifiableList(Arrays.asList(
            "neal", "s", "stu", "j", "rich", "bob", "aiden", "j", "ethan", "liam",
            "mason", "noah", "lucas", "jacob", "jayden", "jack")
    );

    public static final Set<String> NON_WORDS = new HashSet<String>() {{
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

}
