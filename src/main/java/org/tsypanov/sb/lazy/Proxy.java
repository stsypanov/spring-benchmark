package org.tsypanov.sb.lazy;

public class Proxy {
    private final ObjectProvider objectProvider;

    public Proxy(ObjectProvider objectProvider) {
        this.objectProvider = objectProvider;
    }

    public Object getObject() {
        return objectProvider.getObject();
    }
}
