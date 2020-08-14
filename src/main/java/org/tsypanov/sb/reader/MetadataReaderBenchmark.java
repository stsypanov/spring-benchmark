package org.tsypanov.sb.reader;

import org.openjdk.jmh.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@State(org.openjdk.jmh.annotations.Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Fork(jvmArgsAppend = {"-Xms2g", "-Xmx2g", "-XX:+UseParallelGC"})
public class MetadataReaderBenchmark {
  private final MetadataReaderFactory metadataReaderFactory = new SimpleMetadataReaderFactory();

  @Benchmark
  public Object read() throws IOException {
    return metadataReaderFactory.getMetadataReader(AnnotatedComponent.class.getName()).getAnnotationMetadata();
  }

  @Component("myName")
  @Scope(BeanDefinition.SCOPE_PROTOTYPE)
  private static class AnnotatedComponent implements Serializable {
    private final Dependency dep;

    @Autowired
    public AnnotatedComponent(@Qualifier("myColor") Dependency dep) {
      this.dep = dep;
    }

    private static class Dependency {
    }
  }
}
