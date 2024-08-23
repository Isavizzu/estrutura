import org.w3c.dom.Node;

public class LinkedList<T> {
    private Node<T> base;
    private Node<T> top;
    int size;

    public LinkedList(int size){
        this.size = size;
        base = null;
        top = null;
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
        if (this.data[indice] == null) {
            throw new IllegalStateException("Tem ao menos um índice antes do "+ pos + " livre!");
        }
        for (int i=indice;i>=0;i--){
            if (pos == indice){
                this.data[indice] = data;
                break;
            }
            this.data[indice+1] = this.data[indice];
        }
        indice++;
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


    public T remove(int pos){
        if (isEmpty()){
            throw new IllegalStateException("A lista já está vazia!");
        }
        T valorRemovido = this.data[pos];
        for (int i=pos;i<=indice;i++){
            this.data[indice] = this.data[indice++];
        }
        indice--;
        return valorRemovido;
    }


    public boolean isEmpty(){
        return data[0] == null;
    }


    public void clear(){
        data = (T[]) new Object[size];
    }
}