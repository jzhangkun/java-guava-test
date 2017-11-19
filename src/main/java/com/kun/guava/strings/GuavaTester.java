package com.kun.guava.strings;

import com.google.common.base.*;
import com.google.common.collect.Lists;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class GuavaTester {
    public static void main(String... args) {
        GuavaTester t = new GuavaTester();
        t.testJoiner();
        t.testSplitter();
        t.testCaseFormat();
        t.testCharMatcher();
    }

    void testJoiner() {
        System.out.println("Test Joiner");
        Joiner joiner = Joiner.on("; ").skipNulls();
        String string = joiner.join("Harry", null, "Ron", "Hermione");
        System.out.println(string);

        Joiner joiner1 = Joiner.on(": ").useForNull("*");
        string = joiner1.join("Harry", null, "Ron", "Hermione");
        System.out.println(string);
    }

    void testSplitter() {
        System.out.println("Test Splitter");
        String s = null;
        s = Splitter.on(',').omitEmptyStrings().split("a,,c,d").toString();
        System.out.println(s);
        s = Splitter.on(',').trimResults().split("a, b, c, d").toString();
        System.out.println(s);
        s = Splitter.on(',').trimResults(CharMatcher.is('_')).split("_a ,_b_ ,c__").toString();
        System.out.println(s);
        s = Splitter.on(',').limit(3).split("a,b,c,d").toString();
        System.out.println(s);

        // get a list from returned result
        ArrayList<String> list = Lists.newArrayList(Splitter.on(',').limit(3).split("a,b,c,d"));
        System.out.println(list);
    }

    void testCharMatcher() {
        System.out.println("Test CharMatcher");
        String string = "xyz 123 and   321";
        System.out.println("Original: [" + string + "]");
        String noControl = CharMatcher.javaIsoControl().removeFrom(string); // remove control characters
        String theDigits = CharMatcher.digit().retainFrom(string); // only the digits
        System.out.println("the Digits: [" + theDigits + "]");

        String spaced = CharMatcher.whitespace().trimAndCollapseFrom(string, ' ');
        // trim whitespace at ends, and replace/collapse whitespace into single spaces
        System.out.println("the spaced: [" + spaced + "]");

        String noDigits = CharMatcher.javaDigit().replaceFrom(string, "*"); // star out all digits
        String lowerAndDigit = CharMatcher.javaDigit().or(CharMatcher.javaLowerCase()).retainFrom(string);
        // eliminate all characters that aren't digits or lowercase

        if (CharMatcher.whitespace().indexIn("abc") == -1) {
            System.out.println("whitespace not found");
        } else {
            System.out.println("whitespace found");
        }

        if (CharMatcher.is('x').matchesAnyOf("abcx")) {
            System.out.println("char x found");
        }

        System.out.println(Charsets.UTF_8);
        System.out.println(StandardCharsets.UTF_8);
        byte[] bytes = string.getBytes(Charsets.UTF_8);
    }

    void testCaseFormat() {
        System.out.println("Test CaseFormat");
        String s = null;
        s = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "CONSTANT_NAME");
        System.out.println(s);
    }
}
