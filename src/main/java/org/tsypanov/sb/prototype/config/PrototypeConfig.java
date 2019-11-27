package org.tsypanov.sb.prototype.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.tsypanov.sb.prototype.components.Component;
import org.tsypanov.sb.prototype.components.ComponentImpl;

@Configuration
public class PrototypeConfig {

  @Bean
  @Scope(BeanDefinition.SCOPE_PROTOTYPE)
  Component component() {
    return new ComponentImpl();
  }

}