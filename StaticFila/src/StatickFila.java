public class StatickFila<T> {
    private int top;
    private int base;
    private T[] data;

    public StatickFila(int size){
        this.top = -1;
        this.base = 0;
        this.data = (T[]) new Object[size];
    }


    public void add(T data){
        if (isFull()){
            throw new IllegalStateException("A fila está cheia!");
        }
        top = moveTop(top);
        this.data[top] = data;
    }


    public int moveTop(int posicao){
        return posicao + 1 == data.length? 0 : posicao + 1;
    }


    public boolean isFull(){
        for (T i:data) {
            if (i == null) {
                return false;
            }
        }
        return true;
    }


    public T remove(){
        if (isEmpty()){
            throw new IllegalStateException("A fila já está vazia!");
        }
        T itemRemovido = this.data[base];
        this.data[base] = null;
        base = moveTop(base);
        return itemRemovido;
    }


    public boolean isEmpty(){
        for (T i:data) {
            if (i != null) {
                return false;
            }
        }
        return true;
    }

    public T[] imprimir(){
        return data;
    }


    public void clear(){
        for (T i:data){
            remove();
        }
    }
}