import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyLL list = new MyLL();
        list.addHead(2);
        list.addHead(4);
        list.addHead(6);
        list.printList();
        System.out.println();

        list.addTail(8);
        list.printList();
        System.out.println();

        list.addToIndex(-1,0);
        list.printList();
        System.out.println();

        list.addToIndex(0,2);
        list.printList();
        System.out.println();

        list.deleteToIndex(5);
        list.printList();
        System.out.println();

        list.addTail(8);
        list.printList();
        System.out.println();

        list.delGivValue(2);
        list.printList();
        System.out.println();

        list.bubleSort();
        list.printList();
        System.out.println();

        list.addHead(3);
        list.printList();
        System.out.println();

        list.bubleSort();
        list.printList();
        System.out.println();

        //list.clear();
        //list.printList();

        list.sequentialInsertion(2);
        list.printList();
        System.out.println();

        list.clear();

        int random;
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            random = r.nextInt(100);
            System.out.println(random + "is added to the list");
            list.stackPush(random);
            if ( random % 2 != 0){
                System.out.println(list.stackPop() + " is out the list");
            }
        }
        System.out.print("Even Numbers : ");
        list.printList();


    }
}