package com.mytechexp.linkedlist;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        LinkedList list=new LinkedList();
        list.add(1);
        list.add(2);
        list.showList();
        list.insertFront(3);
        list.showList();
        list.insertAt(2, 5);
        list.showList();
        list.reverseList(2);
        list.showList();
        list.specialOrder();
        list.showList();


        //palindrom
        
    }
}
