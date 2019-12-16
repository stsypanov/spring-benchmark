package org.tsypanov.sb.autowire;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.tsypanov.sb.autowire.component.Dependency;
import org.tsypanov.sb.autowire.component.DependingComponent;

@Configuration
@ComponentScan(basePackageClasses = DependingComponent.class)
class AutowireConfig {

  @Bean
  public Dependency dependency() {
    return new Dependency();
  }

}