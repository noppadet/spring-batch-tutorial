package com.lab.demo.reader;

import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.support.AbstractItemStreamItemReader;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InMemReader extends AbstractItemStreamItemReader<Integer> {
    List<Integer> myList = IntStream.rangeClosed(1,10).boxed().collect(Collectors.toList());

    int index = 0;


    @Override
    public Integer read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if ( index < myList.size()) {
            return myList.get(index++);
        }else {
            index = 0;
            return null;
        }
    }
}
