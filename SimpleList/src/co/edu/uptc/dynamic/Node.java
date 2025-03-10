package co.edu.uptc.dynamic;

public class Node<T> {
    private T info;
    private Node<T> next;

    public Node() {
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
    public Node(T t){
        this.info=t;
    }
}