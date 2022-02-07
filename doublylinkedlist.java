import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.Map;
import java.util.HashMap;
class Node{
    int data;
    Node prev;
    Node next;
    Node(int data){
        this.data=data;
        this.prev=null;
        this.next=null;
    }
}
class doublylinkedlist{
    Node head;
    
    void findpairs(int x){
        ArrayList<Map<Integer,Integer>> arr=new ArrayList<>();
        
        Node start=this.head;
        Node end=start;
        while(end.data<=x){
            end=end.next;
        }
        end=end.prev;
        while(start.data<end.data){
             int sum=start.data+end.data;
             if(sum==x){
                 Map<Integer,Integer> m=new HashMap<>();
                 m.put(start.data,end.data);
                 arr.add(m);
                 start=start.next;
                 end=end.prev;
             }
             else if(sum>x){
                 end=end.prev;
             }
             else{
                start=start.next;
             }
        }

        for(int i=0;i<arr.size();i++){
            for(Entry<Integer, Integer> e:arr.get(i).entrySet()){
                System.out.println("("+e.getKey()+","+e.getValue()+")");
            }
        }
    }
    void createdoublylinkedlist(Scanner sc){
          System.out.println("Enter the head node data: ");
          int data=sc.nextInt();
          this.head=new Node(data);
          Node t=this.head;
          while(true){
              System.out.println("Enter the data or type -1: ");
              data=sc.nextInt();
              if(data==-1) break;
              else{
                  Node newnode=new Node(data);
                  t.next=newnode;
                  newnode.prev=t;
                  t=newnode;
              }
          }
    }
    void display(){
        Node t=this.head;
        while(t!=null){
            System.out.println(t.data);
            t=t.next;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        doublylinkedlist d=new doublylinkedlist();
        System.out.println("create the doubly linked list: ");
        d.createdoublylinkedlist(sc);
        
        System.out.println("display the elements: ");
        d.display();

        d.findpairs(7);
    }
}