package org.tsypanov.sb.lazy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
class MixedConfig {

    @Bean
    Proxy lazy(@Lazy ObjectProvider objectProvider) {
        return new Proxy(objectProvider);
    }

    @Bean
    Proxy eager(ObjectProvider objectProvider) {
        return new Proxy(objectProvider);
    }

    @Bean
    ObjectProvider objectProvider() {
        return new ObjectProvider();
    }

}
