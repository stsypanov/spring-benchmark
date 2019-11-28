package org.tsypanov.sb;

import org.openjdk.jmh.profile.GCProfiler;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;
import org.tsypanov.sb.prototype.benchmark.ContextLoadBenchmark;
import org.tsypanov.sb.prototype.benchmark.PrototypeBenchmark;

public class BenchmarkRunner {

  public static void main(String[] args) throws Exception {
    Options opt = new OptionsBuilder()
            .include(ContextLoadBenchmark.class.getSimpleName())
            .warmupIterations(10)
            .warmupTime(TimeValue.seconds(1))
            .measurementIterations(1)
            .measurementTime(TimeValue.days(1))
            .forks(10) //0 makes debugging possible
            .shouldFailOnError(true)
//				.shouldDoGC(false)
            .jvmArgsAppend(
//						"-Xint"
//						,
//						"-XX:+UnlockDiagnosticVMOptions",
//						"-XX:+PrintCompilation",
//						"-XX:+PrintInlining",
//						"-XX:+LogCompilation"
            )
            .addProfiler(GCProfiler.class)// memory and GC profiler
//            .verbosity(VerboseMode.SILENT)
            .build();

    new Runner(opt).run();
  }
}