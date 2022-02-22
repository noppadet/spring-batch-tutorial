package com.lab.demo.writer;

import org.springframework.batch.item.support.AbstractItemStreamItemWriter;

import java.util.List;

public class ConsoleItemWriter extends AbstractItemStreamItemWriter<Integer> {
    @Override
    public void write(List<? extends Integer> list) throws Exception {
        list.forEach(System.out::println);
        System.out.println(" ******** writing each chunk ******");
    }
}
