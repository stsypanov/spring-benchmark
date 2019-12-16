package org.tsypanov.sb.autowire;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.tsypanov.sb.autowire.component.DependingComponent;
import org.tsypanov.sb.prototype.components.Component;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class AutowireBenchmark {

  private AnnotationConfigApplicationContext context;

  @Setup
  public void setUp() {
    context = new AnnotationConfigApplicationContext(AutowireConfig.class);
  }

  @Benchmark
  public DependingComponent createBean() {
    return context.getBean(DependingComponent.class);
  }

  @TearDown
  public void closeContext() {
    context.close();
  }


}
