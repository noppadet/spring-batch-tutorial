package com.lab.demo.config;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class BatchConfig {

    @Autowired
    private JobBuilderFactory jos;
    @Autowired
    private StepBuilderFactory steps;


    public Step step1(){
        return steps.get("step1")
                .tasklet(helloworldTasklet())
                .build();
    }

    //    private Tasklet helloworldTasklet() {
//        return new Tasklet() {
//            @Override
//            public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
//                return null;
//            }
//        }
//    }
    private Tasklet helloworldTasklet() {
        return (stepContribution, chunkContext) -> {
            System.out.println("hello world");
            return RepeatStatus.FINISHED;
        };
    }
    @Bean
    public Job helloworldJob(){
        return jos.get("helloworldJossss").start(step1()).build();
    }
}
