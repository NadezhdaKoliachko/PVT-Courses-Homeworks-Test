package core;

import org.omg.CORBA.OBJ_ADAPTER;

public class Massive {
    int size;
    String name;

    public Massive(int size, String name) {
        this.size = size;
        this.name = name;
    }

    public Object[] createArray(Object... o)  {
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) array[i] = o[i];
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

   public Object returnOutOfBoundException(Object[] array) {
        try {
            return array[1000];
        }catch (ArrayIndexOutOfBoundsException e) {
            return "You are out of bound";
        }
    }

    public Object returnFirstElement(Object[] array) {
        return array[0];
    }

    public Object returnLastElement(Object[] array) {
        return array[size - 1];
    }



}



