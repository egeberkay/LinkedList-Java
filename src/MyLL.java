public class MyLL {
    Node head;
    Node tail;
    public MyLL() {
        head = null;
        tail = null;
    }
    public void addHead(int number){
        Node newNode = new Node(number);
        if (isFull()){
            newNode.next = head;
            head = newNode;
        }else {
            head = newNode;
            tail = newNode;
        }
    }
    public void addTail(int number){
        Node newNode = new Node(number);
        if (isFull()){
            tail.next = newNode;
            tail = newNode;
            newNode.next = null;
        }else {
            head = newNode;
            tail = newNode;
        }
    }
    public void addToIndex(int number, int index) {
        Node newNode = new Node(number);
        if (isFull() && index >= 0) {
            if (index == 0) {//Add to the beginning of the list
                newNode.next = head;
                head = newNode;
            } else {
                Node pointer2 = head;
                Node pointer1 = null;
                int currentIndex = 0;
                while (pointer2 != null && currentIndex < index) {
                    pointer1 = pointer2;
                    pointer2 = pointer2.next;
                    currentIndex++;
                }
                if (pointer2 == null) { //End of the list
                    tail.next = newNode;
                    tail = newNode;
                    newNode.next = null;
                } else { // ADD IN THE SOMEWHERE IN MIDDLE OF THE LIST
                    newNode.next = pointer2;
                    pointer1.next = newNode;
                }
            }
        } else {
            head = newNode;
            tail = newNode;
        }
    }
        public void deleteToIndex(int index){
            if (isFull() && index >= 0){
                if (index == 0){//Delete to the beginning of the list
                    head = head.next;
                    if (head == tail){
                        tail = null;
                        head = null;
                    }
                }else {
                    Node pointer2 = head;
                    Node pointer1 = null;
                    int currentIndex = 0;
                    while (pointer2 != null &&  currentIndex < index){
                        pointer1 = pointer2;
                        pointer2 = pointer2.next;
                        currentIndex++;
                    }
                    if (pointer2 == null){//if there is an overflow
                        pointer1.next = null;
                    }else { // DELETE IN THE SOMEWHERE IN MIDDLE OF THE LIST or END.
                        pointer1.next = pointer2.next;
                        if (pointer2 == tail){
                            tail = pointer1;
                        }
                        pointer2.next = null;
                    }
                }
            }
        }
    public void delGivValue(int number) {
        if (head == null) {
            return;
        }
        if (head.number == number) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return;
        }
        Node pointer2 = head;
        Node pointer1 = null;

        while (pointer2 != null && pointer2.number != number) {
            pointer1 = pointer2;
            pointer2 = pointer2.next;
        }
        if (pointer2 == null) {
            System.out.println("There is no such number in the list");
            return;
        }
        pointer1.next = pointer2.next;

        if (pointer2.next == null) {
            tail = pointer1;
        }
    }

    public void printList(){
        Node pointer = head;
        int numberOfElements = 0;
        while (pointer != null){
            System.out.print(pointer.number + " ");
            pointer = pointer.next;
            numberOfElements++;
        }
        System.out.println();
        System.out.print("Number of Elements: " + numberOfElements);
    }
    public void bubleSort(){
        if (!isFull()){
            System.out.println("The list is empty");
        }else if (head == tail){//there is one element.
            System.out.println("The list has only one element");
        }else { // start sorting.
            boolean isSorted = true;
            Node previous =null;
            Node first;
            Node second;
            while (isSorted){
                isSorted =false;
                first = head;
                second = first.next;
                if (toCompare(first,second)){
                    swap(previous,first,second);
                    isSorted = true;
                }
                previous = first;
                first = second;
                second = second.next;
                while (second != null){
                    if (toCompare(first,second)){
                        swap(previous,first,second);
                        isSorted = true;
                    }
                    previous = first;
                    first = second;
                    second = second.next;
                }
            }

        }
        System.out.print("The sorted list is: ");
    }
    public boolean toCompare(Node node1, Node node2){
        if(node1.number > node2.number){
            return true;
        }else {
            return false;
        }
    }
    public void swap(Node previous,Node first, Node second){
        if (first == head){//if the first node is the head.
            if (second == tail){
                second.next = first;
                first.next = null;
                head = second;
                tail = first;
            }else {
                first.next =second.next;
                second.next = first;
                head = second;
            }
        }else  if(second == tail){//if the second node is the tail.
                second.next =first;
                first.next = null;
                previous.next = second;
                tail = first;
            }else {
            first.next = second.next;
            second.next =first;
            previous.next = second;
        }
    }

    public void sequentialInsertion(int number){
        if (!isFull()){
            addHead(number);
        }else {
            if (number < head.number){
                addHead(number);
                return;
            }
            boolean isFound = false;
            Node first = head;
            Node second = first.next;
            if (second == null){
                addTail(number);
                isFound = true;
            }else {
                while(second != null){
                    if (number >= first.number && number <= second.number ){
                        Node newNode = new Node(number);
                        first.next = newNode;
                        newNode.next = second;
                        isFound = true;
                        break;
                    }
                    first = second;
                    second = second.next;
                }if (!isFound){
                    addTail(number);
                }
            }
        }
    }
    public void queuePush(int number){
        addTail(number);
    }
    public int queuePop(){
        int number = head.number;
        deleteToIndex(0);
        return number;
    }

    public void stackPush(int number){
        addHead(number);
    }
    public int stackPop(){
        int number = head.number;
        deleteToIndex(0);
        return number;
    }

    public boolean isFull(){
        if (head != null){
            return true;
        }else {
            return false;
        }
    }
    public void clear(){
        head = null;
        tail = null;
    }
}