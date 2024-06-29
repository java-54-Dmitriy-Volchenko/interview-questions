package telran.interviews.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.interviews.MyArray;

class MyArrayTest {
    private MyArray<Integer> myArray;

    @BeforeEach
    void setUp() {
        myArray = new MyArray<>(1000000);
        
        
    }

    @Test
    void testSetAll() {
        long startTime = System.nanoTime();
        myArray.setAll(100);
        long duration = System.nanoTime() - startTime;
        System.out.println("setAll duration: " + duration);
       
    }
    @Test
    void testSetAllOn() {
        Integer[] array = new Integer[1000000];
        long startTime = System.nanoTime();
        for (Integer elem:array) {
            elem = 100;
        }
        long duration = System.nanoTime() - startTime;
        System.out.println("setAll (O(n)) duration: " + duration);
       
    }
    @Test
    void testSet() {
        myArray.setAll(0);
        long startTime = System.nanoTime();
        myArray.set(100000, 100);
        long duration = System.nanoTime() - startTime;
        System.out.println("set duration: " + duration);
        assertEquals(100, myArray.get(100000));
    }

    @Test
    void testGet() {
        myArray.setAll(0); 
        myArray.set(100000, 100);
        long startTime = System.nanoTime();
        int value = myArray.get(100000);
        long duration = System.nanoTime() - startTime;
        System.out.println("get duration: " + duration);
        assertEquals(100, value);
    }

  

    @Test
    void testArrayIndexOutOfBounds() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> myArray.set(-1, 100));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> myArray.set(10000000, 100));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> myArray.get(-1));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> myArray.get(10000000));
    }
}

