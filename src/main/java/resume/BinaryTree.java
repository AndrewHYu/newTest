package resume;

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
    }
    public static Node rebuild(int[] font,int[] middle,int start,int end){
        Node root = new Node(font[n]);
        if (start == end){
            return root;
        }

        for (int i = start;i < end;i++){
            if (font[n] == middle[i]){
                n++;
                root.pLeft = rebuild(font,middle,start,i);
                n++;
                root.pRight = rebuild(font,middle,i + 1,end);
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
/*    public static Node buildTree(char[] preOrder, int start,
                                 char[] inOrder, int end, int length) {
        //参数验证
        if (preOrder == null || preOrder.length == 0 || inOrder == null
                || inOrder.length == 0 || length <= 0) {
            return null;
        }

        //建立子树根节点
        char value = preOrder[start];
        Node root = new Node();
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
        root.left = buildTree(preOrder, start + 1, inOrder, end - i - 1, length - 1 - i);
        //建立子树的右子树
        root.right = buildTree(preOrder, start + length - i, inOrder, end, i );

        return root;
    }*/
}
