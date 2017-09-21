package resume;

import org.junit.Test;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedTransferQueue;

/**
 * @author huangyu
 * @date 2017/9/1
 */
public class StackQueue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public Integer pop(){
        if (stack2.isEmpty() && !stack1.isEmpty()){
            int size = stack1.size();
            for (int i = 0;i < size;i++){
                int v = stack1.pop();
                stack2.add(v);
            }
        }
        if (stack2.isEmpty())
            return null;
        return stack2.pop();
    }

    public boolean add(Integer value){
        return stack1.add(value);
    }

    public static void main(String[] args) {
        StackQueue stackQueue = new StackQueue();
        stackQueue.add(3);
        stackQueue.add(4);
        System.out.println(stackQueue.pop());
        stackQueue.add(5);
        System.out.println(stackQueue.pop());
        System.out.println(stackQueue.pop());

        QueueStack queueStack = new QueueStack();
        queueStack.add(1);
        queueStack.add(2);
        queueStack.add(3);

        System.out.println(queueStack.poll());
        System.out.println(queueStack.poll());
        System.out.println(queueStack.poll());
        System.out.println(queueStack.poll());

    }
    static class QueueStack{
        private Queue<Integer> queue1 = new LinkedTransferQueue<>();
        private Queue<Integer> queue2 = new LinkedTransferQueue<>();

        public Integer poll(){
            Queue<Integer> q1 = null;
            Queue<Integer> q2 = null;

            if (queue1.size() > 0){
                q1 = queue1;
                q2 = queue2;
            }
            else if (queue2.size() > 0){
                q1 = queue2;
                q2 = queue1;
            } else
                return null;
            int size = q1.size();
            for (int i = 1;i <size;i++){
                int v = q1.poll();
                q2.offer(v);
            }
            return q1.poll();
        }

        public boolean add(Integer value){
            if (queue1.size() != 0)
                return queue1.add(value);
            else
                return queue2.add(value);
        }

    }

    @Test
    public void test(){
        StackWithMin<Integer> minInt = new StackWithMin<>();
        minInt.push(5);
        minInt.push(4);
        minInt.push(2);
        minInt.push(3);

        System.out.println(minInt.min());
        minInt.pop();
        System.out.println(minInt.min());
        minInt.pop();
        System.out.println(minInt.min());
        minInt.pop();
        System.out.println(minInt.min());
    }
    class StackWithMin<T extends Comparable<? super T>>{
        Stack<T> data = new Stack<>();
        Stack<T> min = new Stack<>();
        T m = null;

        public boolean push(T value){
            data.add(value);
//            T m = min.peek();
            if (m == null)
                m = value;
            if (m.compareTo(value) > 0)
                m = value;
            return min.add(m);
        }
        public T pop(){
            min.pop();
            return data.pop();
        }
        public T min(){
            return min.peek();
        }
    }

    @Test
    public void testIsPopOrder(){
        int[] a = {1,2,3,4,5};
//        int[] b = {4,3,5,1,2};
//        int[] b = {1,2,3,4,5};
        int[] b = {4,3,2,1,5};
        isPopOrder(a,b);
    }
    public boolean isPopOrder(int[]src ,int[]dest){
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0;i < src.length;i++){
            stack.add(src[i]);
            for (;!stack.isEmpty()&&stack.peek().equals(dest[j]);j++)
                stack.pop();
        }
        for (;j < dest.length;j++){
            if (!stack.pop().equals(dest[j]))
                return false;
        }
        return true;
    }

}
