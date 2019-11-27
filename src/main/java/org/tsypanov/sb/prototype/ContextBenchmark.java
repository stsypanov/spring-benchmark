package org.tsypanov.sb.prototype;


import org.openjdk.jmh.annotations.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.tsypanov.sb.prototype.components.Component;
import org.tsypanov.sb.prototype.config.PrototypeConfig;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Fork(jvmArgsAppend = {"-Xms2g", "-Xmx2g"})
public class ContextBenchmark {

  private AnnotationConfigApplicationContext context;

  @Setup
  public void setup() {
    context = new AnnotationConfigApplicationContext(PrototypeConfig.class);
  }

  @Benchmark
  public Object initContext() {
    return context.getBean(Component.class);
  }

  @TearDown
  public void closeContext() {
    context.close();
  }
}
