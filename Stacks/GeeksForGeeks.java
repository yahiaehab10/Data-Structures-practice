package Stacks;

import java.util.Stack;

import Queue.QueueObj;

public class GeeksForGeeks {

    // inverse of string
    public static String inverseString(String s) {
        String res = "";
        int x = s.length() - 1;
        Stack<Character> stk = new Stack<>();
        while (x != -1) {
            stk.push(s.charAt(x));
            x--;
        }
        while (!stk.isEmpty()) {
            res = stk.pop() + "" + res;
        }
        return res;
    }

    // rev queue
    public static void revQueue(QueueObj q) {
        Stack<Object> s = new Stack<>();
        while (!q.isEmpty()) {
            s.push(q.dequeue());
        }
        while (!s.isEmpty()) {
            q.enqueue(s.pop());
        }
    }

    // reverse word itself
    public static String revWords(String s) {
        String res = "";
        Stack<Character> tmp = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                tmp.push(s.charAt(i));
            } else {
                while (!tmp.isEmpty()) {
                    res += tmp.pop();
                }
                res += " ";
                i++;
            }
        }

        return res;
    }

    // delete middle element in stack
    public static int deleteMiddle(Stack<Integer> s) {
        Stack<Integer> tmp = new Stack<>();
        int res, x = s.size() / 2;
        for (int i = 0; i < x - 1; i++) {
            tmp.push(s.pop());
        }
        res = s.pop();
        while (!tmp.isEmpty()) {
            s.push(tmp.pop());
        }
        return res;
    }

    // sort Stack
    public static void sortStack(Stack<Integer> s) {
        Stack<Integer> tmp = new Stack<Integer>();
        while (!s.isEmpty()) {
            int x = s.pop();
            while (!tmp.isEmpty() && tmp.peek() > x) {
                s.push(tmp.pop());
            }
            tmp.push(x);
        }
        while (tmp.isEmpty() == false) {
            s.push(tmp.pop());
        }
    }

    // reverse every k elemnets in queue
    public static void revQueue(QueueObj q,int k) {
    }

    // rev stack using rec
    public static void revStackRec(Stack<Integer> s) {
    }

    // Reversing the first K elements of a Queue

    public static void main(String[] args) {
        // Stack<Integer> s = new Stack<>();
        // s.add(1);
        // s.add(2);
        // s.add(3);
        // s.add(4);
        // s.add(5);
        // s.add(6);

        QueueObj q = new QueueObj(6);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(7);

        revQueue(q, 2);
        q.printQueue();
    }
}
