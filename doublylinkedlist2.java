import java.util.*;

import java.io.*;
class Node{
    int data;
    Node prev,next;
    Node(int data){
        this.data=data;
        this.prev=null;
        this.next=null;
    }
}
public class doublylinkedlist2 {
    
    Node head;
    void createLinkedList(int []l){
          this.head=new Node(l[0]);
          Node t=this.head;
          for(int i=1;i<l.length;i++){
              Node newnode=new Node(l[i]);
              t.next=newnode;
              newnode.prev=t;
              t=newnode;
          }
    }
    void findtriplets(int x){
        if(this.head.data>=x) return;
        Node curr=this.head;
        Node tail=curr;
        while(tail.next!=null){
            tail=tail.next;
        }
        while(curr.next.next!=null){
            Node start=curr.next;
            Node end=tail;
            int val=x-curr.data;
            while(start.data<end.data){
                int sum=start.data+end.data;
                if(sum==val){
                    System.out.println("("+curr.data+","+start.data+","+end.data+")");
                    start=start.next;
                    end=end.prev;
                } 
                else if(sum>val){
                    end=end.prev;
                }
                else{
                    start=start.next;
                }
            }
            curr=curr.next;
        }
    }
    void display(){
        Node t=this.head;
        while(t!=null){
            System.out.println(t.data);
            t=t.next;
        }
    }
    public static void main(String[] args) throws java.lang.Exception {
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);
        doublylinkedlist2 d=new doublylinkedlist2();
        int []input=Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        d.createLinkedList(input);
        d.display();
        d.findtriplets(17);
    }
}
