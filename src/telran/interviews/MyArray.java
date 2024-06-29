package telran.interviews;

public class MyArray<T> {
    private final Object[] values;
    private final int[] counts;
    private int countForSetAll;
    private T valueForSetAll;

    public MyArray(int size) {
        values = new Object[size];
        counts = new int[size];
        countForSetAll = -1;
        valueForSetAll = null;
    }

    public void setAll(T value) {//if all elements equals - no sense adds them to array, so no sense in iteration/
    	countForSetAll++;	// so this is complexity O(1)
    	valueForSetAll = value; // The only problem will be in get method
    }

    public void set(int index, T value) {
        if (index < 0 || index >= values.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        values[index] = value;
        counts[index] = countForSetAll;//count will be more then another elements
    }

    public T get(int index) {
        if (index < 0 || index >= values.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (counts[index] < countForSetAll) {// this means that nothing was changed from last setAll and we can return valueForSetAll
            return valueForSetAll;
        } else { //else we return actual value of element. This is complexity O(1)
            return (T) values[index];
        }
    }
}
