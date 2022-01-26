from queue import Queue
class Node:
    def __init__(self,data):
        self.data=data
        self.lchild=None
        self.rchild=None
        
class Tree:
    def __init__(self):
        self.root=None
        
    def BuildTree(self):
        node=input("Enter the root node data:")
        if node:
            self.root=Node(int(node))
        q=Queue()
        q.put(self.root)
        while not q.empty():
            t=q.get()
            lchild=input(f'Enter the left child of {t.data} or press on enter key: ')
            if lchild:
                t.lchild=Node(int(lchild))
                q.put(t.lchild)
            rchild=input(f"Enter the right child of {t.data} or press enter key: ")
            if rchild:
                t.rchild=Node(int(rchild))
                q.put(t.rchild)
            

def countnode(node):
    if node:
        x=countnode(node.lchild)
        y=countnode(node.rchild)
        return x+y+1
    return 0

def count2degree(node):
    if node:
        x=count2degree(node.lchild)
        y=count2degree(node.rchild)
        if node.lchild and node.rchild:
            return x+y+1
        else:
            return x+y
    return 0

def countleaf(node):
    if node:
        x=countleaf(node.lchild)
        y=countleaf(node.rchild)
        if not node.lchild and not node.rchild:
            return x+y+1
        else:
            return x+y
    return 0
    
def count1degree(node):
    if node:
        x=count1degree(node.lchild)
        y=count1degree(node.rchild)
        if (not node.lchild and node.rchild) or (node.lchild and not node.rchild):
            return x+y+1
        else:
            return x+y
    return 0
    
def countparentnode(node):
    if node:
        x=countparentnode(node.lchild)
        y=countparentnode(node.rchild)
        if node.lchild or node.rchild:
            return x+y+1
        else:
            return x+y
    return 0
    
tree=Tree()
tree.BuildTree()
print("no of nodes: ",countnode(tree.root))       
print("no of nodes with degree 2: ",count2degree(tree.root))
print("no of nodes with degree 1: ",count1degree(tree.root))
print("no of leaf nodes: ",countleaf(tree.root))
print("no of internal nodes: ",countparentnode(tree.root))
