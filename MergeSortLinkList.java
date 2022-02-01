import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}


public class MergeSortLinkList {

    Node head;
    MergeSortLinkList(){
        this.head=null;
    }
    Node mid(Node head){
        Node s=head,f=head;
        while(f.next!=null && f.next.next!=null){
            f=f.next.next;
            s=s.next;
        }
        return s;
    }
    Node mergeSort(Node head){
        if(head==null || head.next==null) return head;
        Node mid=mid(head);
        Node nhead=mid.next;
        mid.next=null;

        Node l1=mergeSort(head);
        Node l2=mergeSort(nhead);
        return merge(l1, l2);
    }
    Node merge(Node l1,Node l2){
        if(l1==null || l2==null) return l1!=null?l1:l2;
        Node head=(l1.data<l2.data)?l1:l2;
        Node curr=head;
        if(head==l1) l1=l1.next;
        else l2=l2.next;
        while(l1!=null && l2!=null){
            if(l1.data>l2.data){
                curr.next=l2;
                curr=l2;
                l2=l2.next;
            }
            else{
                curr.next=l1;
                curr=l1;
                l1=l1.next;
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
    void createLinkList(Scanner sc){
        System.out.println("Enter the head node data: ");
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
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        MergeSortLinkList l=new MergeSortLinkList();
        System.out.println("Enter the elements of first linkedlist: ");
        l.createLinkList(sc);
        System.out.println("the list elements are:");
        l.display();
        System.out.println("Sorted list: ");
        l.head=l.mergeSort(l.head);
        l.display();
    }
}
