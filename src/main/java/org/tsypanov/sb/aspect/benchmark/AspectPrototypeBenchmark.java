package org.tsypanov.sb.aspect.benchmark;


import org.openjdk.jmh.annotations.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.tsypanov.sb.aspect.config.AspectConfig;
import org.tsypanov.sb.aspect.service.AspectedService;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Fork(jvmArgsAppend = {"-Xms2g", "-Xmx2g"})
public class AspectPrototypeBenchmark {
  private AnnotationConfigApplicationContext context;

  @Setup
  public void setUp() {
    context = new AnnotationConfigApplicationContext(AspectConfig.class);
  }

  @Benchmark
  public AspectedService getAdvisedBean() {
    return context.getBean(AspectedService.class);
  }

  @TearDown
  public void closeContext() {
    context.close();
  }
}
