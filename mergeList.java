import java.util.Scanner;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class mergeList {
    
    Node head;
    mergeList(){
        this.head=null;
    }
    void createLinkList(Scanner sc){
        System.out.println("Enter the root node data: ");
        int data=sc.nextInt();
        this.head=new Node(data);
        Node temp=this.head;
        while(true){
            System.out.println("Enter the data or type -1: ");
            data=sc.nextInt();
            if(data!=-1){
                temp.next=new Node(data);
                temp=temp.next;
            }
            else{
                break;
            }
        }
    }
    // here curr always pointing to the tail of the linked list and head is pointint
    // to the head of the link list
    static Node MergeTwoList(Node l1,Node l2){
        Node head, curr;
        head=(l1.data>l2.data)?l2:l1;
        curr=head;
        if(head==l1){
            l1=l1.next;
        }
        else{
            l2=l2.next;
        }
        while(l1!=null && l2!=null){
            if(l1.data<l2.data){
                  curr.next=l1;
                  curr=l1;
                  l1=l1.next;
            }
            else{
                   curr.next=l2;
                   curr=l2;
                   l2=l2.next;
            }
        }
        if(l1!=null){
            curr.next=l1;
        }
        if(l2!=null){
            curr.next=l2;
        }
        return head;
    }
    void display(){
        Node temp=this.head;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
    public static void main(String args[]){
         Scanner sc=new Scanner(System.in);
         mergeList l1=new mergeList();
         mergeList l2=new mergeList();
         System.out.println("Enter the elements of first linkedlist: ");
         l1.createLinkList(sc);
         System.out.println("Enter the elements of second linkedlist: ");
         l2.createLinkList(sc);
         System.out.println("The first linklist");
         l1.display();
         System.out.println("The second linklist");
         l2.display();
         mergeList l3=new mergeList();
         l3.head=MergeTwoList(l1.head, l2.head);
         l3.display();
    }
}
