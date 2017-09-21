package resume;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author huangyu
 * @date 2017/8/31
 */
public class BinaryTree {
    static int n = 0;
    public static void main(String[] args) {
        int[] font = {1,2,4,7,3,5,6,8};
        int[] middle = {4,7,2,1,5,3,8,6};
        Node root = rebuild(font,middle,0,font.length - 1);
        printLay(root);
        System.out.println("+++++++++++++++++++++++++++");
        printDeep(root);
        convert(root);
//        Node root = buildTree(font,0,middle,7,8);
    }

    /**
     * 根据前序遍历和中序遍历重建二叉树
     * @param font
     * @param middle
     * @param start
     * @param end
     * @return
     */
    public static Node rebuild(int[] font,int[] middle,int start,int end){
        Node root = new Node(font[n]);
        if (start == end){
            return root;
        }

        for (int i = start;i <= end;i++){
            if (font[n] == middle[i]){
                if (i - start > 0){
                    n++;
                    root.pLeft = rebuild(font,middle,start,i - 1);
                }

                if (end - i  > 0){
                    n++;
                    root.pRight = rebuild(font,middle,i + 1,end);
                }

                break;
            }
        }
        return root;
    }
    static class Node{
        public Node(int value) {
            this.value = value;
        }

        int value;
        Node pLeft;
        Node pRight;
    }

    /**
     * 根据前序遍历和中序遍历重建二叉树
     * @param preOrder
     * @param start
     * @param inOrder
     * @param end
     * @param length
     * @return
     */
    public static Node buildTree(int[] preOrder, int start,
                                 int[] inOrder, int end, int length) {
        //参数验证
        if (preOrder == null || preOrder.length == 0 || inOrder == null
                || inOrder.length == 0 || length <= 0) {
            return null;
        }

        //建立子树根节点
        int value = preOrder[start];
        Node root = new Node(value);
        root.value = value;

        //递归终止条件：子树只有一个节点
        if (length == 1)
            return root;

        //分拆子树的左子树和右子树
        int i = 0;
        while (i < length) {
            if (value == inOrder[end - i]) {
                break;
            }
            i++;
        }

        //建立子树的左子树
        root.pLeft = buildTree(preOrder, start + 1, inOrder, end - i - 1, length - 1 - i);
        //建立子树的右子树
        root.pRight = buildTree(preOrder, start + length - i, inOrder, end, i );

        return root;
    }
    boolean doesTreeHasTree2(Node pRoot1,Node pRoot2){
        if (pRoot2 == null)
            return true;
        if (pRoot1 ==null)
            return false;
        if (pRoot1.value != pRoot2.value)
            return false;
        return doesTreeHasTree2(pRoot1.pLeft,pRoot2.pLeft) && doesTreeHasTree2(pRoot1.pRight,pRoot2.pRight);
    }

    /**
     * 判断一棵树是否是另一棵树的子树
     * @param root1
     * @param root2
     * @return
     */
    boolean hasSubtree(Node root1,Node root2){
        boolean result = false;
        if (root1 != null && root2 != null){
            if (root1.value == root1.value)
                doesTreeHasTree2(root1,root2);
            if (!result)
                hasSubtree(root1.pLeft,root2);
            if (!result)
                hasSubtree(root1.pRight,root2);
        }
        return result;
    }

    /**
     * 二叉树层序遍历
     * @param root
     */
    public static void printLay(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while ( queue.peek() != null){
            root = queue.poll();
            System.out.println(root.value);
            if (root.pLeft != null)
                queue.add(root.pLeft);
            if (root.pRight != null)
                queue.add(root.pRight);
        }
    }

    /**
     * 二叉树深度优先遍历
     * @param root
     */
    public static void printDeep(Node root){
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            root = stack.pop();
            System.out.println(root.value);
            if (root.pRight != null)
                stack.add(root.pRight);
            if (root.pLeft != null)
                stack.add(root.pLeft);
        }
    }

    public static Node convert(Node root){
        Node lastNode = null;
        convertNode(root,lastNode);
        Node head = lastNode;
        while (head != null && head.pLeft != null)
            head = head.pLeft;
        return head;
    }
    public static void convertNode(Node node,Node lastNode){
        if (node == null)
            return;
        if (node.pLeft != null)
            convertNode(node.pLeft,lastNode);
        node.pLeft = lastNode;

        if (lastNode != null)
            lastNode.pRight = node;
        lastNode = node;

        if (node.pRight != null)
            convertNode(node.pRight,lastNode);
    }

    /**
     * 计算一棵二叉树的深度
     * @param root
     * @return
     */
    public int treeDeep(Node root){
        if (root == null)
            return 0;
        int nLeft = treeDeep(root.pLeft);
        int nRight = treeDeep(root.pRight);

        return nLeft > nRight ? nLeft + 1 : nRight + 1;
    }

    /**
     * 判断一棵树是否是平衡二叉树,因为代码是基本照抄c++实现
     * deep应该是指针，没实现
     * @param root
     * @param deep
     * @return
     */
    public boolean isBalanced(Node root,int deep){
        if (root == null){
            deep = 0;
            return true;
        }
        int left = 0,right = 0;
        if (isBalanced(root.pLeft,left) && isBalanced(root.pRight,right)){
            int diff = left - right;
            if (diff <= 1 && diff >= -1){
                deep = 1 + (left > right ? left : right);
                return true;
            }
        }
        return false;
    }
}
