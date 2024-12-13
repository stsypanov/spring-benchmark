package org.tsypanov.sb.lazy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
class LazyConfig {

    @Bean
    Proxy proxyWithLazyObjectProvider(@Lazy ObjectProvider objectProvider) {
        return new Proxy(objectProvider);
    }

    @Bean
    ObjectProvider objectProvider() {
        return new ObjectProvider();
    }
}
