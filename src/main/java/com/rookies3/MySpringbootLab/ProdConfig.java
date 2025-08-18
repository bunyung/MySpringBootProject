package com.rookies3.MySpringbootLab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")   // 운영환경 프로파일일 때만 활성화
public class ProdConfig {

    @Bean
    public MyEnvironment myEnvironment() {
        return new MyEnvironment("운영환경");
    }
}
