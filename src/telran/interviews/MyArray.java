package telran.interviews;

import java.util.HashMap;
import java.util.Map;

public class MyArray<T> {
    private final Map<Integer, T> values;
    private int size;
    private int countForSetAll;
    private T valueForSetAll;

    public MyArray(int size) {
        this.size = size;
        values = new HashMap<>();
        countForSetAll = -1;
        valueForSetAll = null;
    }

    public void setAll(T value) {
        countForSetAll++;
        valueForSetAll = value;
        values.clear();
    }

    public void set(int index, T value) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        values.put(index, value);
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return values.getOrDefault(index, valueForSetAll);
    }
}
