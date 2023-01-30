class Node{
    public:
    int value,key;
    Node *prev,*next;
    int ctn;
    Node(int key_,int val){
        key=key_;
        value=val;
        ctn=1;
        prev=NULL;
        next=NULL;
    }
};
class List{
    public:
    int size;
    Node *head;
    Node *tail;
    List(){
        size=0;
        head=new Node(0,0);
        tail=new Node(0,0);
        tail->prev=head;
        head->next=tail;
    }

    void addnode(Node *node){
      Node* temp = head->next;
        node->next = temp;
        node->prev = head;
        head->next = node;
        temp->prev = node;
        size++;
    }

    void remove(Node *node){
         Node *p=node->prev;
         Node *n=node->next;
         p->next=n;
         n->prev=p;
         size--;
    }
};
class LFUCache {
public:
    map<int,List*> mpf;
    map<int,Node*> mpn;
    int minsize;
    int minfreq;
    int size;
    LFUCache(int capacity) {
        minsize=capacity;
        minfreq=0;
        size=0;
    }
    void updatefrequency(Node *node){
         mpn.erase(node->key);
         List *currlist=mpf[node->ctn];
         currlist->remove(node);
         List *newhighlist=new List();
         if(node->ctn==minfreq && mpf[node->ctn]->size==0){
             minfreq++;
         }
         if(mpf.find(node->ctn+1)!=mpf.end()){
             newhighlist=mpf[node->ctn+1];
         }
         node->ctn+=1;
         newhighlist->addnode(node);
         mpf[node->ctn]=newhighlist;
         mpn[node->key]=node;
    }
    int get(int key) {
        if(mpn.find(key)!=mpn.end()){
            Node *node=mpn[key];
            int val=node->value;
            updatefrequency(node);
            return val;
        }
        return -1;
    }
    
    void put(int key, int value) {
        if(minsize==0) return;
        if(mpn.find(key)!=mpn.end()){
            Node *node=mpn[key];
            node->value=value;
            updatefrequency(node);
        }else{
            if(size>=minsize){
                List *currlist=mpf[minfreq];
                Node *delnode=currlist->tail->prev;
                currlist->remove(delnode);
                mpn.erase(delnode->key);
                size--;
            }
            Node *node=new Node(key,value);
            minfreq=1;
            List *list=new List();
            if(mpf.find(minfreq)!=mpf.end()){
                list=mpf[minfreq];
            }
            list->addnode(node);
            mpf[minfreq]=list;
            mpn[key]=node;
            size++;
        }
    }
};

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache* obj = new LFUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */
