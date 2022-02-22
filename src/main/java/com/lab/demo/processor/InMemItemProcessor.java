package com.lab.demo.processor;


import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class InMemItemProcessor implements ItemProcessor<Integer, Integer> {

    @Override
    public Integer process(Integer integer) throws Exception {
        return Integer.sum(10, integer);
    }
}
