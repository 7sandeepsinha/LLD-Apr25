package designPatterns.Prototype;

import java.util.HashMap;

public class Registry<T> {
    private HashMap<String, Prototype<T>> registry;

    public Registry() {
        registry = new HashMap<>();
    }

    public void add(String name, Prototype<T> prototype) {
        registry.put(name, prototype);
    }

    public Prototype<T> get(String name) {
        return registry.get(name);
    }
}
