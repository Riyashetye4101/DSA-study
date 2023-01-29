
class LRUCache {
public:
public:
            class node{
            public:
            int key,value;
            node *prev,*next;
            node(int key,int value){
                this->key=key;
                this->value=value;
                prev=NULL;
                next=NULL;
            }
        };
    node *head;
    node *tail;
      
      

      void addnode(node *n){
        
          node *nt=head->next;
          head->next=n;
          n->prev=head;
          nt->prev=n;
          n->next=nt;
      }
    
      void delnode(node *n){
          node *p=n->prev;
          node *nt=n->next;
          p->next=nt;
          nt->prev=p;
      }
    int size=0;
    map<int,node*> mp;
    
    LRUCache(int capacity) {
        size=capacity;
        
          head=new node(-1,-1);
          tail=new node(-1,-1);
          head->next=tail;
          tail->prev=head;
    }
    
    int get(int key) {
        auto val=mp.find(key);
        if(val!=mp.end()){
            node *n=mp[key];
            int x=n->value;
            delnode(n);
            addnode(n);
            mp[key]=n;
            return x;
        }else{
            return -1;
        }
    }
    
    void put(int key, int value) {
        auto temp=mp.find(key);
        if(temp==mp.end()){
            if(mp.size()>=size){

                  node *deln=tail;
                  deln=deln->prev;
                  int val=deln->key;
                  auto t=mp.find(val);
                  mp.erase(t);
                  delnode(deln);
                  
            }
            node *n=new node(key,value);
            addnode(n);
            mp[key]=n;
        }else{
            node *presentnode=mp[key];
            presentnode->value=value;
            mp[key]=presentnode;
        delnode(presentnode);
            addnode(presentnode);
        }
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */
