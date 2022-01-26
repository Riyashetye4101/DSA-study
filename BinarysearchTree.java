import java.util.Scanner;

class Node{
    int data;
    Node lchild;
    Node rchild;
    Node(int data){
        this.data=data;
        this.lchild=null;
        this.rchild=null;
    }
}

public class BinarysearchTree {
    Node root;
    Node Rinsert(Node node,int data){
        Node newnode=null;
        if(node==null){
            newnode=new Node(data);
            return newnode;
        }
        if(node.data>data){
            node.lchild=Rinsert(node.lchild, data);
        }
        if(node.data<data){
            node.rchild=Rinsert(node.rchild, data);
        }
        return newnode;
    }
    void insertnode(int data){
      Node newnode=new Node(data);
      if(this.root==null){
         this.root=newnode;
         return;
      }
      Node p=this.root;
      Node q=null;
      while(p!=null){
          if(p.data==data) return;
          q=p;
          if(p.data<data){
                p=p.rchild;
          }
          else{
              p=p.lchild;
          }
      }
      if(q.data>data){
          q.lchild=newnode;
      }
      else{
          q.rchild=newnode;
      }
    }
    Node search(int data){
         if(this.root!=null){
             Node t=this.root;
             while(t!=null){
                 if(t.data==data) return t;
                 if(t.data>data){
                     t=t.lchild;
                 }
                 else{
                     t=t.rchild;
                 }
             }
         }
         return null;
    }
    Node Research(Node node,int data){
        if(node!=null){
            if(node.data==data) return node;
            else if(node.data>data){
                return Research(node.lchild, data);
            }
            else return Research(node.rchild, data);
        }
        return null;
    }
    void inorder(Node node){
        if(node!=null){
            inorder(node.lchild);
            System.out.println(node.data);
            inorder(node.rchild);
        }
    }
   int height(Node node){
       if(node!=null){
           int x=height(node.lchild);
           int y=height(node.rchild);
           return x+y+1;
       }
       return 0;
   }
   Node preccesor(Node node){
       while(node!=null && node.rchild!=null){
           node=node.rchild;
       }
       return node;
   }
   Node successor(Node node){
       while(node!=null && node.lchild!=null){
           node=node.lchild;
       }
       return node;
   }
   Node delete(Node node,int data){
       // this code is when the node is null 
       if(node==null) return null;
       // deleting the leaf node
       if(node.lchild==null && node.rchild==null){
           if(node==this.root){
               this.root=null;
               
           }
           return null;
       }
       // this code for searching the deleting node
       if(node.data>data){
          node.lchild=delete(node.lchild, data);
       }
       else if(node.data<data){
           node.lchild=delete(node.rchild, data);
       } // below code is when node found
       else{
           // checking if right substree or left tree is bigger then swaping the data until the modification is completed
          if(height(node.lchild)>height(node.rchild)){
               Node q=preccesor(node.lchild);
               node.data=q.data;       // first swaping the nodes data
               node.lchild=delete(node.lchild,q.data); // then making the modification for rest of the nodes 
          }
          else{
             Node p=successor(node.rchild);
             node.data=p.data;
             node.rchild=delete(node.rchild, p.data);
          }
       }
       return node;
   }
    public static void main(String []args){
        BinarysearchTree t=new BinarysearchTree();
        Scanner sc=new Scanner(System.in);
        System.out.println("Create the BST");
        int data=0;
        while(true){
            System.out.println("Enter the data or type -1: ");
            data=sc.nextInt();
            if(data==-1) break;
            else t.insertnode(data);
        }
        System.out.println("the inorde traversal:");
        t.inorder(t.root);
        System.out.println("Enter the delete node:");
        int n=sc.nextInt();
        System.out.println("the node is this:"+t.delete(t.root, n).data);
        t.inorder(t.root);
        sc.close();
    }
}
