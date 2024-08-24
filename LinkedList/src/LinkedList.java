import org.w3c.dom.Node;


public class LinkedList<T> {
    private No<T> base;
    private No<T> top;
    private int size;
    private int indiceTop;

    public LinkedList(int size){
        this.size = size;
        this.indiceTop = -1;
        base = null;
        top = null;
    }


    public void add(T data){
        if (isFull()){
            throw new IllegalStateException("A lista está cheia!");
        }
        if (base == null){
            base = new No<>(null, null, data);
            return;
        }
        No<T> noAnterior = getNo(indiceTop++).getAnterior();
        top = new No<>(noAnterior, null, data);
        noAnterior.setProximo(top);
    }


    public void add(T data, int pos){
        if (isFull()){
            throw new IllegalStateException("A lista está cheia!");
        }
        indiceTop++;
        if (pos == 0){
            No<T> noNovo = new No<>(null, base, data);
            base.setAnterior(noNovo);
            base = noNovo;
            return;
        }
        No<T> noProximo = getNo(pos);
        No<T> noAnterior = getNo(pos).getAnterior();
        No<T> noNovo = new No<>(noAnterior, noProximo, data);
        noProximo.setAnterior(noNovo);
        noAnterior.setProximo(noNovo);
    }


    public No<T> getNo(int pos) {
        No<T> node = base;
        int posAtual = 0;
        while (true) {
            if (posAtual == pos) {
                return node;
            }
            node = node.getProximo();
            posAtual++;
        }
    }


    public int getSize() {
        return size;
    }


    public T get (int pos) {
        return getNo(pos).getValor();
    }


    public boolean isFull(){
        return indiceTop+1 == size;
    }


    public T remove(int pos){
        if (isEmpty()){
            throw new IllegalStateException("A lista encadeada já está vazia!");
        }
        indiceTop--;
        if (pos == 0) {
            No<T> noRemovido = base;
            base = base.getProximo();
            base.setAnterior(null);
            return noRemovido.getValor();
        }
        No<T> noRemovido = getNo(pos);
        No<T> noAnterior = noRemovido.getAnterior();
        No<T> noProximo = noRemovido.getProximo();
        noAnterior.setProximo(noProximo);
        noProximo.setAnterior(noAnterior);
        return noRemovido.getValor();
    }


    public T remove(No<T> no) {
        if (isEmpty()){
            throw new IllegalStateException("A lista encadeada já está vazia!");
        }
        if (no.getAnterior() == null) {
            base = base.getProximo();
            base.setAnterior(null);
            return no.getValor();
        }
        No<T> noAnterior = no.getAnterior();
        No<T> noProximo = no.getProximo();
        noAnterior.setProximo(noProximo);
        noProximo.setAnterior(noAnterior);
        return no.getValor();
    }


    public boolean isEmpty(){
        return base == null;
    }


    public void clear(){
        this.indiceTop = -1;
        base = null;
        top = null;
    }


    public void set(int pos, T valor) {
        getNo(pos).setValor(valor);
    }
}


class No<T>{
    private No<T> proximo;
    private No<T> anterior;
    private T valor;


    public No (No<T> anterior, No<T> proximo, T valor) {
        this.anterior = anterior;
        this.valor = valor;
        this.proximo = proximo;
    }


    public void setValor (T valor) {
        this.valor = valor;
    }


    public No<T> getAnterior() {
        return anterior;
    }


    public No<T> getProximo() {
        return proximo;
    }


    public void setAnterior (No<T> anterior) {
        this.anterior = anterior;
    }


    public void setProximo (No<T> proximo) {
        this.proximo = proximo;
    }


    public T getValor () {
        return valor;
    }
}