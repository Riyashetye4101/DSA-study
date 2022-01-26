import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int data;
    public Node lchild;
    public Node rchild;

    Node(int data) {
        this.data = data;
        this.lchild = null;
        this.rchild = null;
    }
}

class Tree {
    Node root;

    void createTree(Scanner sc) {
        Queue<Node> queue = new LinkedList<>();
        System.out.println("Enter the data for root node:");
        int data = sc.nextInt();
        this.root = new Node(data);
        queue.offer(this.root);
        while (!queue.isEmpty()) {
            Node t = queue.poll();
            System.out.println("Enter the data for left child of " + t.data + " or type -1: ");
            data = sc.nextInt();
            if (data != -1) {
                t.lchild = new Node(data);
                queue.offer(t.lchild);
            }
            System.out.println("Enter the data for right child of " + t.data + " or type -1: ");
            data = sc.nextInt();
            if (data != -1) {
                t.rchild = new Node(data);
                queue.offer(t.rchild);
            }
        }
        queue.clear();
    }

    void traversal() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(this.root);
        while (!queue.isEmpty()) {
            Node t = queue.poll();
            System.out.println(t.data);
            if (t.lchild != null)
                queue.offer(t.lchild);
            if (t.rchild != null)
                queue.offer(t.rchild);
        }
    }

    void preorder() {
        Stack<Node> stack = new Stack<>();
        Node t = this.root;
        while (!stack.isEmpty() || t != null) {
            if (t != null) {
                System.out.println(t.data);
                stack.push(t);
                t = t.lchild;
            } else {
                t = stack.pop();
                t = t.rchild;
            }
        }
        stack.clear();
    }

    void inorder() {
        Stack<Node> stack = new Stack<>();
        Node t = this.root;
        while (!stack.isEmpty() || t != null) {
            if (t != null) {
                stack.push(t);
                t = t.lchild;
            } else {
                t = stack.pop();
                System.out.println(t.data);
                t = t.rchild;
            }
        }

    }
   
    void postorder() {
        Stack<Node> stack = new Stack<>();
        Node t = this.root;
        while (!stack.isEmpty() || t != null) {
           if(t!=null){
               stack.push(t);
               t=t.lchild;
           }
           else{
               Node temp=stack.peek().rchild;
               if(temp==null){
                  temp=stack.pop();
                  System.out.println(temp.data);
                  while(!stack.isEmpty() && temp==stack.peek().rchild){
                      temp=stack.pop();
                      System.out.println(temp.data);
                  }
               }
               else{
                   t=temp;
               }
           }
        }
    }
    
    int countnode(Node node){
        if(node!=null){
            int x=countnode(node.lchild);
            int y=countnode(node.rchild);
            return x+y+1;
        }
        return 0;
    }

    int count2degree(Node node){
        if(node!=null){
            int x=count2degree(node.lchild);
            int y=count2degree(node.rchild);
            if(node.lchild!=null && node.rchild!=null){
                return x+y+1;
            }
            else{
                return x+y;
            }
        }
        return 0;
    }
    int count1degree(Node node){
        if(node!=null){
            int x=count1degree(node.lchild);
            int y=count1degree(node.rchild);
            if(node.lchild!=null ^ node.rchild!=null){
                return x+y+1;
            }
            else{
                return x+y;
            }
        }
        return 0;
    }
    int countinternalnode(Node node){
        if(node!=null){
            int x=countinternalnode(node.lchild);
            int y=countinternalnode(node.rchild);
            if(node.lchild!=null || node.rchild!=null){
                return x+y+1;
            }
            else{
                return x+y;
            }
        }
        return 0;
    }
    int countleaf(Node node){
        if(node!=null){
            int x=countleaf(node.lchild);
            int y=countleaf(node.rchild);
            if(node.lchild==null && node.rchild==null){
                return x+y+1;
            }
            else{
                return x+y;
            }
        }
        return 0;
    }

    int sum(Node node){
        if(node!=null){
            int x=sum(node.lchild);
            int y=sum(node.rchild);
            return x+y+node.data;
        }
        return 0;
    }
    int search(int[] arr,int x){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==x) return i;
        }
        return -1;
    }
    int pre=0;
    Node BuildTreeFromPreorder(int []inorder,int[]preorder,int start,int end){
        if(start>end) return null;
        Node root=new Node(preorder[pre]);
        pre++;

        if(start==end) return root;
        int index=search(inorder,root.data);
        root.lchild=BuildTreeFromPreorder(inorder, preorder, start, index-1);
        root.rchild=BuildTreeFromPreorder(inorder, preorder, index+1, end);
        return root;
    }
    int post;
    Node buildTreeFromPostorder(int[] inorder,int[] postorder,int start,int end){
        if(start>end) return null;
        Node root=new Node(postorder[post]);
        post--;
        
        if(start==end) return root;
        int index=search(inorder,root.data);
        root.rchild=buildTreeFromPostorder(inorder, postorder, index+1, end);
        root.lchild=buildTreeFromPostorder(inorder, postorder, start, index-1);
        return root;
    }
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Create the tree:");
        Tree t = new Tree();
        int []inorder={7,6,9,3,4,5,8,2,1};
        // int []preorder={4,7,9,6,3,2,5,8,1};
        int []postorder={6,3,9,7,8,5,1,2,4};
        // t.root=t.BuildTreeFromPreorder(inorder, preorder, 0, preorder.length-1);
        t.post=postorder.length-1;
        t.root=t.buildTreeFromPostorder(inorder, postorder, 0, t.post);
        t.traversal();
        sc.close();
    }
}
