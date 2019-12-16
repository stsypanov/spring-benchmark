package org.tsypanov.sb.autowire.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class DependingComponent {
  private final Dependency dependency;

  @Autowired
  public DependingComponent(Dependency dependency) {
    this.dependency = dependency;
  }
}
