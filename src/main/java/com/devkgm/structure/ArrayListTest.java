package com.devkgm.structure;


import java.util.Iterator;

// 기능
// add
// remove
// get
// contains
// size
// set
class ArrayList<T> implements Iterable<T> {
    private int size;
    private T[] array;
    private int index;

    public ArrayList() {
        this.size = 1;
        this.array = (T[]) new Object[this.size];
        this.index = 0;
    }

    public void doubling() {
        this.size = this.size * 2;
        T[] newArray = (T[]) new Object[this.size];
        for (int i = 0; i <= this.index; i++) {
            newArray[i] = this.array[i];
        }
        this.array = newArray;
    }

    public void add(T data) {
        if (this.size-1 == this.index) {
            doubling();
        }
        this.array[index++] = data;
    }
    public T get(int index) throws Exception {
        if (!(this.index >= index && index >= 0))
            throw new Exception("범위를 벗어남");
        return this.array[index];
    }

    public void remove(int index) throws Exception {
        if (!(this.index >= index && index >= 0))
           throw new Exception("범위를 벗어남");
        for(int i = index; i < this.array.length - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        this.index--;
    }

    public int size() {
        return this.index;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }


    private class ArrayListIterator implements Iterator<T> {
        private int currentIndex = 0;
        @Override
        public boolean hasNext() {
            return currentIndex < index;
        }

        @Override
        public T next() {
            return array[currentIndex++];
        }
    }
}

public class ArrayListTest {
    public static void main(String[] args) throws Exception{
        ArrayList<String> arr = new ArrayList<>();
        arr.add("Hello");
        arr.add("World");
        for(int i = 0; i < arr.size(); i++){
            System.out.println("arr.get(i) = " + arr.get(i));
        }
        for(String s : arr){
            System.out.println("s = " + s);
        }
    }
}