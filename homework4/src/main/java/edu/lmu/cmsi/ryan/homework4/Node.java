package edu.lmu.cmsi.ryan.homework4;

public class Node<A> {
    private A value = null;
    private Node<A> next = null;

    public Node(A value) {
        this.value = value;
    }

    public A getValue() {
        return this.value;
    }

    public Node<A> getNext() {
        return this.next;
    }

    public void setNext(Node<A> next) {
        this.next = next;
    }
}