

import java.util.EmptyStackException;
import java.util.stream.IntStream;

public class StackDS<T>{

    private int size;
    private T[] elements;

    public StackDS(){
        this.size = 0;
        this.elements = (T[]) new Object[10];
    }

    public StackDS(int size, T[] elements) {
        this.size = size;
        this.elements = elements;
    }



    public void push(T pushedElement){

        if(size + 1 > elements.length){
            T[] arr = (T[]) new Object[elements.length + 5];       // se zgolemuva za 5 novi elementi
            for(int i = 0; i < elements.length; i++){              // copy the old array
                arr[i] = elements[i];
            }
            arr[size++] = pushedElement;
            this.elements = arr;
            return;
        }
        elements[size++] = pushedElement;
    }

    public boolean isEmpty(){
        return (size > 0)? false: true;
    }

    public T peek() throws EmptyStackException {
        if(size == 0)
            throw new EmptyStackException();
        return elements[0];
    }

    public T pop() throws EmptyStackException{
        if(size == 0)
            throw new EmptyStackException();

        T element = elements[--size];
        elements[size] = null;
        return element;
    }

    @Override
    public String toString(){
        String output = "";
        for(int i = 0; i < size; i++){
            output += elements[i] + " ";
        }

        return output;
    }

}
