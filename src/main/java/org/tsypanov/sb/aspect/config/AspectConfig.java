package org.tsypanov.sb.aspect.config;


import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.tsypanov.sb.aspect.ServiceAspect;
import org.tsypanov.sb.aspect.service.AspectedService;
import org.tsypanov.sb.aspect.service.AspectedServiceImpl;

@Configuration
public class AspectConfig {

  @Bean
  ServiceAspect serviceAspect() {
    return new ServiceAspect();
  }

  @Bean
  @Scope(BeanDefinition.SCOPE_PROTOTYPE)
  AspectedService aspectedService() {
    return new AspectedServiceImpl();
  }

  @Bean
  AbstractAutoProxyCreator proxyCreator() {
    AbstractAutoProxyCreator factory = new AnnotationAwareAspectJAutoProxyCreator();
    factory.setProxyTargetClass(true);
    // this is to check the influence of commit commit e44d3dab
    // use Method in fixedInterceptorMap instead of String returned from Method::toString
    factory.setFrozen(true);
    return factory;
  }
}
