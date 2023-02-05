package Queue;

import java.util.Stack;

public class Test {

    public static void reverseQueue(QueueObj q) {
        Stack<Object> stk = new Stack<>();
        while (!q.isEmpty()) {
            stk.push(q.dequeue());
        }
        while (!stk.isEmpty()) {
            q.enqueue(stk.pop());
        }
    }

    public static QueueObj mirror(QueueObj q) {
        QueueObj result = new QueueObj(q.size() * 2);
        for (int i = 0; i < q.size(); i++) {
            for (int j = 0; j < q.size() - 1; j++) {
                q.enqueue(q.dequeue());
            }
            result.enqueue(q.peek());
        }
        while (!q.isEmpty())
            result.enqueue(q.dequeue());
        return result;
    }

    ////////////////////////////////////////////////////////
    public static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    public static int calculate(String operator, String operand1, String operand2) {
        int op1 = Integer.parseInt(operand1);
        int op2 = Integer.parseInt(operand2);
        if (operator.equals("+"))
            return op1 + op2;
        if (operator.equals("-"))
            return op1 - op2;
        if (operator.equals("*"))
            return op1 * op2;
        else // operator.equals("/")
            return op1 / op2;
    }

    public static int evaluate(String exp) {
        String[] array = exp.split(" ");
        QueueObj items = new QueueObj(array.length);
        // filling the queue with the strings
        for (int i = 0; i < array.length; i++)
            items.enqueue(array[i]);
        while (items.size() > 1) {
            String first = (String) items.dequeue();
            if (isOperator(first)) {
                String second = (String) items.peek();
                if (!isOperator(second)) {
                    items.dequeue(); // removing second from queue
                    String third = (String) items.peek();
                    if (!isOperator(third)) // operator is followed by TWO operands
                    {
                        items.dequeue(); // removing third from queue
                        int result = calculate(first, second, third);
                        items.enqueue("" + result);// added as a String not Integer
                    } else // operator is followed by only ONE operand
                    {
                        items.enqueue(first);
                        items.enqueue(second);
                    }

                } else // first is operator NOT followed by any operands
                    items.enqueue(first);
            } else // first is an operand
                items.enqueue(first);
        }
        return Integer.parseInt((String) items.dequeue());
    }
    ////////////////////////////////////////////////////////

    public static void shiftZeroes(QueueObj q) {
        QueueObj zeros = new QueueObj(q.size());
        for (int i = 0; i < q.size(); i++) {
            {
                int value = ((Integer) q.peek()).intValue();
                if (value == 0) {
                    zeros.enqueue(q.dequeue());
                } else {
                    q.enqueue(q.dequeue());
                }
            }
        }
        while (!zeros.isEmpty()) {
            q.enqueue(zeros.dequeue());
        }
    }

    public static QueueObj thirdElem(QueueObj q) {
        Stack<Object> rev = new Stack<>();
        QueueObj ans = new QueueObj(q.size() / 3 + 1);
        while (!q.isEmpty()) {
            rev.push(q.dequeue());
        }
        int counter = 0;
        while (!rev.isEmpty()) {
            if (counter % 3 == 0) {
                ans.enqueue(rev.pop());
            } else {
                rev.pop();
            }
            counter++;
        }
        return ans;
    }

    public static void main(String[] args) {
    }
}
