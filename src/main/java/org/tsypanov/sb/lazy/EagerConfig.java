package org.tsypanov.sb.lazy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class EagerConfig {

    @Bean
    Proxy proxyWithLazyObjectProvider(ObjectProvider objectProvider) {
        return new Proxy(objectProvider);
    }

    @Bean
    ObjectProvider objectProvider() {
        return new ObjectProvider();
    }
}
