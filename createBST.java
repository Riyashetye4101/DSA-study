import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;
class Node{
    int data;
    Node lchild;
    Node rchild;
    Node(int data){
        this.data=data;
    }
}
public class createBST {
    
    Node root;

    void BuildBSTFromPreorder(int pre[]){
        Stack<Node> stack=new Stack<>();
        stack.push(null);
        Node p=null;
        int i=0;
        int n=pre.length;
        while(i<n){
            if(this.root==null){
               this.root=new Node(pre[i]);
               i++;
               p=this.root;
            }
            else{
            
                if(p.data>pre[i]){
                      p.lchild=new Node(pre[i]);
                      stack.push(p);
                      p=p.lchild;
                      i++;
                }
                else{
                if(stack.peek()!=null){

                    if(pre[i]<stack.peek().data){
                        p.rchild=new Node(pre[i]);
                        p=p.rchild;
                        i++;
                     }
                  else{
                      p=stack.pop();
                  }
                }
                else{
                    p.rchild=new Node(pre[i]);
                    p=p.rchild;
                    i++;
                }
                }
            }
        }
    }

    void traversal(Node node){
        Queue<Node> q=new LinkedList<>();
        q.offer(this.root);
        while(!q.isEmpty()){
            Node t=q.poll();
            System.out.println(t.data);
            if(t.lchild!=null){
                q.offer(t.lchild);
            }
            if(t.rchild!=null){
                q.offer(t.rchild);
            }
        }
    }
    public static void main(String args[]){
        int preorder[]={30,20,10,15,25,40,50,45};
        createBST t=new createBST();

        t.BuildBSTFromPreorder(preorder);
        System.out.println("Printing all the elements of BSt:");
        t.traversal(t.root);
    }
}
