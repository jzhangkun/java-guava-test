package com.kun.guava.io;

import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.collect.*;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.Files;
import com.google.common.io.MoreFiles;
import com.google.common.io.Resources;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GuavaTester {
    public static void main(String... args) {
        GuavaTester t = new GuavaTester();
        try {
            //t.testReadWrite();
            t.testTraversal();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    void testReadWrite() throws IOException {
        // Get resource URL and convert URL -> File
        URL url = GuavaTester.class.getClassLoader().getResource("testfile");
        File file = new File(url.getFile());
        System.out.println("Found sample file: " + file);

        // Read the lines of a UTF-8 text file
        ImmutableList<String> lines = Files.asCharSource(file, Charsets.UTF_8)
                .readLines();
        System.out.println("Read from file: " + lines);

        // Count distinct word occurrences in a file
        Multiset<String> wordOccurrences = HashMultiset.create(
                Splitter.on(CharMatcher.whitespace())
                        .trimResults()
                        .omitEmptyStrings()
                        .split(Files.asCharSource(file, Charsets.UTF_8).read()));
        System.out.println("Statistic list");
        wordOccurrences.forEachEntry((e, c) -> System.out.println("element " + e + " has count " + c));

        // SHA-1 a file
        HashCode hash = Files.asByteSource(file).hash(Hashing.sha1());
        System.out.println("Produced has code: " + hash);

        // Copy the data from a URL to a file
        File tmpfile = File.createTempFile("guava-", ".tmp");
        // Convert File to URL
        URL from = file.toURI().toURL();
        System.out.println("Copied from " + from + " to " + tmpfile);
        Resources.asByteSource(url).copyTo(Files.asByteSink(tmpfile));
    }
    void testTraversal() throws IOException {
        ImmutableList<Path> files = MoreFiles.listFiles(Paths.get("."));
        System.out.println(files);
    }
}
