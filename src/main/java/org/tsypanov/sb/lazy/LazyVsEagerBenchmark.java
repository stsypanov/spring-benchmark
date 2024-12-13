package org.tsypanov.sb.lazy;

import org.openjdk.jmh.annotations.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class LazyVsEagerBenchmark {

    private AnnotationConfigApplicationContext lazyContext;
    private AnnotationConfigApplicationContext eagerContext;
    private Proxy lazyProxy;
    private Proxy eagerProxy;

    @Setup
    public void setUp() {
        lazyContext = new AnnotationConfigApplicationContext(LazyConfig.class);
        lazyProxy = lazyContext.getBean(Proxy.class);

        eagerContext = new AnnotationConfigApplicationContext(EagerConfig.class);
        eagerProxy = eagerContext.getBean(Proxy.class);
    }

    @Benchmark
    public Object getObjectFromLazyBean() {
        return lazyProxy.getObject();
    }

    @Benchmark
    public Object getObjectFromEagerBean() {
        return eagerProxy.getObject();
    }

    @TearDown
    public void closeContext() {
        lazyContext.close();
        eagerContext.close();
    }

}
