package com.intexsoft.javacourse.tsymmerman;

import com.intexsoft.javacourse.tsymmerman.services.HalloWorldBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by kenasan on 26.05.2019.
 */
@Configuration
public class HalloWorldConfig {
    @Bean
    public HalloWorldBean halloWorldBean(){
        return new HalloWorldBean();
    }
}
