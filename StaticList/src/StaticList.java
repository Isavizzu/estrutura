public class StaticList<T> {
    private int size;
    private T[] data;
    private int indice;

    public StaticList(int size){
        this.size = size;
        indice = 0;
        this.data = (T[]) new Object[size];
    }


    public void add(T data){
        if (isFull()){
            throw new IllegalStateException("A lista está cheia!");
        }
        this.data[indice++] = data;
    }


    public void add(T data, int pos){
        if (isFull()){
            throw new IllegalStateException("A lista está cheia!");
        }
        
    }


    public void setData(T data, int pos) {
        if (this.data[pos] == null){
            throw new  IllegalStateException("Esse indíce tem o valor nulo!");
        }
        this.data[pos] = data;
    }


    public T getData(int pos) {
        return this.data[pos];
    }


    public int getSize() {
        return size;
    }


    public int find(T data) {
        int i = 0;
        for (T t:this.data) {
            i++;
            if (t == data) {
                return i;
            }
        }
        throw new  IllegalStateException("Não existe um índice com o valor: " + data);
    }


    public boolean isFull(){
        return data[size - 1] != null;
    }


    public T remove(){
        if (isEmpty()){
            throw new IllegalStateException("A lista já está vazia!");
        }
        T itemRemovido = this.data[base];
        this.data[base] = null;
        base = moveTop(base);
        return itemRemovido;
    }


    public boolean isEmpty(){
        return data[0] == null;
    }


    public void clear(){
        data = (T[]) new Object[size];
    }
}