package com.rookies3.MySpringbootLab;  // ✅ 대문자 맞춤

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class MyPropsRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyPropsRunner.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info("This is an info message.");
        logger.debug("This is a debug message.");
    }
}
