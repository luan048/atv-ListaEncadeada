// Lista duplamente ligada, que pode fazer todas operações indo e voltando entre a lista

class Node {
    int data;

    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

class DoublyLinkedList {
    private Node head;

    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        // Quando ele encontra um valor nao null ele para, current fica sendo igual ao
        // último valor nao null da lista
        while (current.next != null) {
            current = current.next;
        }

        // O valor seguinte ao current, que é um null
        current.next = newNode;
        // O valor anterior toma o valor do current, que representa o último nao null da
        // lista
        newNode.prev = current;
    }

    public void removeLast() {
        if (head == null) {
            System.out.println("Lista está vazia");
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        // Torna o prev o último elemento da lista e atribui null ao next desvinculando ele
        current.prev.next = null;
    }

    public void displayForward() {
        Node current = head;
        System.out.println("Lista (Direta): ");

        while (current != null) {
            System.out.println(current.data + " ");
            current = current.next;
        }

        System.out.println(); // Apenas uma lista vazia
    }

    public void displayBackward() {
        if (head == null) {
            System.out.println("Lista está vazia");
            return;
        }

        Node current = head;
        // Vai levar o current para o último valor nao null da lista
        while (current.next != null) {
            current = current.next;
        }

        System.out.println("Lista (Inversa): ");
        // Quando current parar no último elemento com valor na lista, ele vai imprimir e voltar para o valor anterior que está em prev
        while (current != null) {
            System.out.println(current.data + " ");
            current = current.prev;
        }

        System.out.println();
    }
}

public class DoublyLinkedListExample {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        list.displayForward(); // Imprime de forma crescente
        list.displayBackward(); // Imprime de forma decrescente

        list.removeLast(); // Vai remover o último elemento
        list.displayForward(); // Imprime de forma crescente 
    }
}