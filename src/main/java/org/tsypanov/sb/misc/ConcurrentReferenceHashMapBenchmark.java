package org.tsypanov.sb.misc;

import org.openjdk.jmh.annotations.*;
import org.springframework.util.ConcurrentReferenceHashMap;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@BenchmarkMode(value = Mode.AverageTime)
@Fork(jvmArgsAppend = {"-Xms2g", "-Xmx2g"})
public class ConcurrentReferenceHashMapBenchmark {
  @Benchmark
  public Object findAllByName() {
    return new ConcurrentReferenceHashMap<>();
  }
}
