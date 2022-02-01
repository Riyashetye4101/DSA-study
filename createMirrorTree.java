import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

// Binary tree
class NewNode{
    int data;
    NewNode left;
    NewNode right;
    NewNode(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }

}
public class createMirrorTree{
    NewNode root;
    
    static NewNode  createmirrorTree(NewNode node){
        if(node==null) return null;
        NewNode root=new NewNode(node.data);
        root.left=createmirrorTree(node.right);
        root.right=createmirrorTree(node.left);
        return root;
    }

    void createTree(Scanner sc){
     Queue<NewNode> q=new LinkedList<>();
     System.out.println("Enter the root node data: ");
     int data=sc.nextInt();
     this.root=new NewNode(data);
     q.offer(this.root);
     while(!q.isEmpty()){
        NewNode t=q.poll();
         System.out.println("Enter the left child of "+t.data+" or type -1: ");
         data=sc.nextInt();
         if(data!=-1){
             t.left=new NewNode(data);
             q.offer(t.left);
         }
         System.out.println("Enter the right child of "+t.data+" or type -1: ");
         data=sc.nextInt();
         if(data!=-1){
             t.right=new NewNode(data);
             q.offer(t.right);
         }
     }
    }

    void inorder(NewNode node){
        if(node!=null){
            inorder(node.left);
            System.out.println(node.data);
            inorder(node.right);
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        createMirrorTree t=new createMirrorTree();
        t.createTree(sc);
        System.out.println("the inorder traversal of tree is:");
        t.inorder(t.root);

        NewNode root=createmirrorTree(t.root);
        System.out.println("Inorder traversal of mirror tree is: ");
        t.inorder(root);
    }
}