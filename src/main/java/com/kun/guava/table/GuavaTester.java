package com.kun.guava.table;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: jzhangkun
 * @since: 1.0
 */
public class GuavaTester {
    public static void main(String... args) {
        Table<String, String, Integer> tables = HashBasedTable.create();
        tables.put("a", "javase", 80);
        tables.put("b", "javaee", 90);
        tables.put("c", "javame", 100);
        tables.put("d", "guava", 70);

        tables.cellSet().forEach(
            cell -> System.out.println(cell.getRowKey() + " " + cell.getColumnKey() + " " + cell.getValue())
        );
    }
}
