import java.util.*;

public class DequeExample {

    public DequeExample () {

    }

    public static void main(String[] args) {

        Deque<String> deque= new LinkedList<String>();

//        deque.push("a");
        deque.addFirst("a");
//        deque.push("b");
        deque.addFirst("b");
//        deque.push("c");
        deque.addFirst("c");

        System.out.println(deque);

//        String str = deque.peek();
        String str = deque.peekFirst();

        System.out.println(str);
        System.out.println(deque);

        while (deque.size() > 0 ) {
//            System.out.println(deque.pop());
            System.out.println(deque.removeFirst());
        }
        System.out.println(deque);

    }

}