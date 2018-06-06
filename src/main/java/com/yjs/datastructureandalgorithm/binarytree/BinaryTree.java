package com.yjs.datastructureandalgorithm.binarytree;


import org.omg.CORBA.NO_IMPLEMENT;

/**
 * 二叉查找树(无重复key)
 * create by jiangsongy on 2018/6/6
 */
public class BinaryTree {

    private Node root;

    public BinaryTree(){
        this.root = null;
    }

    public Node findKey(int key){
        if (this.isEmptyTree()){
            return null;
        }
        Node current = this.root;
        while (current.isNotEmptyData() && current.data.iData != key){
            if (key < current.data.iData){
                current = current.leftNode;
            }else {
                current = current.rightNode;
            }
            if (current == null){
                return null;
            }
        }
        return current;
    }

    public void insert(int iData,double dData){

        Data data = new Data(iData,dData);
        Node insertNode = new Node();
        insertNode.data = data;

        if (this.root == null){
            this.root = insertNode;
            return;
        }

        Node current = this.root;
        Node parent;
        while (true){
            parent = current;
            if (iData < current.data.iData){
                current = current.leftNode;
                if (current == null){
                    parent.leftNode = insertNode;
                    return;
                }
            }
            if (iData > current.data.iData){
                current = current.rightNode;
                if (current == null){
                    parent.rightNode = insertNode;
                    return;
                }
            }
        }

    }

    public boolean deleteKey(int key){

        Node parent = this.root;
        Node current = this.root;
        boolean isLeftNode = true;

        //找到要删除的节点
        while (current.data.iData != key){
            parent = current;
            if (key < current.data.iData){
                isLeftNode = true;
                current = current.leftNode;
            }
            if (key > current.data.iData){
                isLeftNode = false;
                current = current.rightNode;
            }
            if (current == null){
                return false;
            }
        }

        //删除节点无后代
        if (current.leftNode == null && current.rightNode == null){
            if (current == this.root){
                this.root = null;
                return true;
            }
            if (isLeftNode){
                parent.leftNode = null;
                return true;
            }
            parent.rightNode = null;
            return true;
        }

        //删除节点只有左子树
        if (current.rightNode == null){
            if (current == this.root){
                this.root = current.leftNode;
                return true;
            }
            if (isLeftNode){
                parent.leftNode = current.leftNode;
                return true;
            }
            parent.rightNode = current.leftNode;
            return true;
        }

        //删除节点只有右子树
        if (current.leftNode == null){
            if (current == this.root){
                this.root = current.rightNode;
                return true;
            }
            if (isLeftNode){
                parent.leftNode = current.rightNode;
                return true;
            }
            parent.rightNode = current.rightNode;
            return true;
        }

        //删除节点有左右子树
        Node successor = this.getSuccessor(current);    //后继节点

        if (current == this.root){
            root = successor;
            return true;
        }
        if (isLeftNode){
            parent.leftNode = successor;
            return true;
        }
        parent.rightNode = successor;
        return true;
    }

    private Node getSuccessor(Node delNode) {

        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightNode;

        while (current != null){    //查找比删除节点大的最小值
            successorParent = successor;
            successor = current;
            current = current.leftNode;
        }

        if (successor != delNode.rightNode){    //后继节点无右子树,处理引用关系
            successorParent.leftNode = successor.rightNode;
            successor.rightNode = delNode.rightNode;
        }

        return successor;
    }

    public void preOrderTraverse(Node startNode){
        if (startNode != null){
            System.out.println(startNode.data.iData);
            this.preOrderTraverse(startNode.leftNode);
            this.preOrderTraverse(startNode.rightNode);

        }
    }

    public void inOrderTraverse(Node startNode){
        if (startNode != null){
            this.inOrderTraverse(startNode.leftNode);
            System.out.println(startNode.data.iData);
            this.inOrderTraverse(startNode.rightNode);

        }
    }

    public void postOrderTraverse(Node startNode){
        if (startNode != null){
            this.postOrderTraverse(startNode.leftNode);
            this.postOrderTraverse(startNode.rightNode);
            System.out.println(startNode.data.iData);
        }
    }

    private boolean isEmptyTree(){
        if (this.root == null){
            return true;
        }
        return false;
    }


    private class Data{

        //keyValue
        public int iData;

        public double dData;

        public Data(){}

        public Data(int iData,double dData){
            this.iData = iData;
            this.dData = dData;
        }

    }

    class Node{

        public Data data;

        public Node leftNode;

        public Node rightNode;

        public Node(){}

        public boolean isNotEmptyData(){
            if (this.data != null){
                return true;
            }
            return false;
        }

        public void printNode(){
            System.out.println("iData->" + this.data.iData + ",dData->" + this.data.dData);
        }

    }

}
