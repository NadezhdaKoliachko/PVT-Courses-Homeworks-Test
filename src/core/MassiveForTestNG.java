package core;

import java.util.Arrays;
import java.util.List;

public class MassiveForTestNG {
    int size;
    String name;

    public MassiveForTestNG(int size, String name) {
        this.size = size;
        this.name = name;
    }

    public Object[] createArray(Object... o) {
        Object[] array;
        array = Arrays.stream(o, 0, size).toArray();
        return array;

    }

    public Object[] reverseArray(Object[] array) {
        Object[] reversedArray = new Object[size];
        int counter = 1;
        for (int i = 0; i < size; i++) {
            reversedArray[i] = array[size - counter];
            counter++;
        }
        return reversedArray;
    }

    public Object returnOutOfBoundException(Object[] array) throws ArrayIndexOutOfBoundsException {
        return array[1000];
    }

    public Object returnFirstElement(Object[] array) {
        return array[0];
    }

    public Object returnLastElement(Object[] array) {
        return array[size - 1];
    }

    public int returnMassiveSize(Object[] array) {
        return array.length;
    }

    public Object[] sortArray(Object[] array) {
        Arrays.sort(array);
        return array;
    }

    public String arrayToString(Object[] array) {
        return Arrays.toString(array);
    }

    public List<Object> arrayAsList(Object[] array) {
        return Arrays.asList(array);
    }


}
