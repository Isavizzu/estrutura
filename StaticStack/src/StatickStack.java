public class StatickStack<T> {
    private int top;
    private T[] data;

    public StatickStack(int size){
        this.top = -1;
        this.data = (T[]) new Object[size];
    }


    public void push(T data){
        if (isFull()){
            throw new IllegalStateException("A pilha está cheia!");
        }
        this.data[top+1] = data;
        top++;
    }


    public boolean isFull(){
        return top + 1 == data.length ? true : false;
    }


    public T pop(){
        if (isEmpty()){
            throw new IllegalStateException("A pilha já está vazia!");
        }
        T itemRemovido = this.data[top];
        this.data[top] = null;
        top--;
        return itemRemovido;
    }


    public boolean isEmpty(){
        return top == -1 ? true : false;
    }


    public void clear(){
        for (T i:data){
            pop();
        }
    }
}