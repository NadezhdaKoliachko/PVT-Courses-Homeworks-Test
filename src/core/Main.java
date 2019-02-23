package core;

import java.util.Arrays;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        Massive massive = new Massive(4, "masOfNumbers");
        Object[] mas = massive.createArray(5, 6, 7, 8, 9);
        System.out.println(Arrays.toString(massive.reverseArray(mas)));
        System.out.println(massive.returnFirstElement(mas));
        System.out.println(massive.returnLastElement(mas));
        //System.out.println(massive.returnOutOfBoundException(mas));
        Object[] mastest = mas;
        System.out.println(mastest == mas);
    }
}
