package org.tsypanov.sb.lazy;

import org.openjdk.jmh.annotations.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class MixedBenchmark {

    private AnnotationConfigApplicationContext mixedContext;
    private Proxy lazyProxy;
    private Proxy eagerProxy;

    @Setup
    public void setUp() {
        mixedContext = new AnnotationConfigApplicationContext(MixedConfig.class);
        lazyProxy = mixedContext.getBean("lazy", Proxy.class);
        eagerProxy = mixedContext.getBean("eager", Proxy.class);
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
        mixedContext.close();
    }

}
