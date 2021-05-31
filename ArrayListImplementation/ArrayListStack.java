package ArrayListImplementation;

public class ArrayListStack <T>{

    private int size;
    private ArrayList<T> stack;

    public ArrayListStack(){
            stack = new ArrayList<>();
    }


    public void push(T pushedElement){
        stack.addElement(pushedElement);
        size++;
    }

    public T pop(){
        size--;
        return stack.deleteLastElement();
    }

    public T peek(){
        return stack.getLastElement().getData();
    }

    public boolean isEmpty(){
        return this.size > 0? false: true;
    }


    @Override
    public String toString(){
        return stack.printInReverseOrderStacked();
    }



}
