package splprime.ast_generated;

import java.util.HashMap;
import java.util.Map;

public class Environment {
    // The actual "Hash Table" part
    private final Map<String, Object> values = new HashMap<>();

    // The link to the outer scope
    private final Environment enclosing;

    public Environment(Environment enclosing) {
        this.enclosing = enclosing;
    }

    public void define(String name, Object value) {
        values.put(name, value);
    }

    public void assign(String name, Object value) {
        if (values.containsKey(name)) {
            values.put(name, value);
            return;
        }

        // If not in local scope, try the parent
        if (enclosing != null) {
            enclosing.assign(name, value);
            return;
        }

        throw new RuntimeException("Undefined variable '" + name + "'.");
    }

    public Object get(String name) {
        if (values.containsKey(name)) {
            return values.get(name);
        }

        // Walk up the chain
        if (enclosing != null) return enclosing.get(name);

        throw new RuntimeException("Undefined variable '" + name + "'.");
    }
}