package edu.lmu.cmsi.tree;

import edu.lmu.cmsi.tree.node.BinaryTreeNode;
import edu.lmu.cmsi.tree.exception.*;
import java.util.*;

public class IntegerBinarySearchTree {

  protected BinaryTreeNode root;

  public IntegerBinarySearchTree() {
    this.root = null;
  }

  /**
   * Insert into the tree.
   *
   * @param x the item to insert.
   * @throws edu.lmu.cmsi.tree.exception.DuplicateItemException if x exists.
   */
  public void insert(int x) {
   root = insert(this.root, x); //call recursive insert method below
  }

  private BinaryTreeNode insert(BinaryTreeNode newNode, int x) {
    if(newNode == null) { //if no node, create a new node with value
      newNode = new BinaryTreeNode(x);
    } else {
      if(newNode.getValue() == x) { //if the value is already in tree, throw exceptoin
          throw new DuplicateItemException(x);
      } else if(x < newNode.getValue()) { //if value is less than newNode (root), go left
          newNode.setLeft(insert(newNode.getLeft(), x));
      } else { //otherwise go right
          newNode.setRight(insert(newNode.getRight(), x));
      }
    }
    return newNode; //return the created node for the original insert method
  }

  /**
   * Find the smallest item in the tree.
   *
   * @return smallest item or throws an exception if the tree is empty.
   * @throws edu.lmu.cmsi.tree.exception.ItemNotFoundException
   *
   */
  public int findSmallestValue() {
    if(this.root == null) { //if there is no tree, throw exception
      throw new ItemNotFoundException("There is no tree");
    } else { //otherwise call recursive minimum method below
      return getMinValue(this.root); 
    }
  }

  private int getMinValue(BinaryTreeNode n) {
    if(n.getLeft() == null) { //if the next node is null, return the current node
      return n.getValue();
    } else { //otherwise keep going left through recursion
      return getMinValue(n.getLeft());
    }
  }

  /**
   * Find the largest item in the tree.
   *
   * @return the largest item or throws an exception if the tree is empty.
   * @throws edu.lmu.cmsi.tree.exception.ItemNotFoundException
   *
   */
  public int findLargestValue() {
    if(this.root == null) { //if there is no tree, throw exception
      throw new ItemNotFoundException("There is no tree");
    } else { //otherwise call recursive minimum method below
      return getMaxValue(this.root);
    }
  }

  private int getMaxValue(BinaryTreeNode n) {
    if(n.getRight() == null) { //if the next node is null, return the current node
      return n.getValue();
    } else { //otherwise keep going right through recursion
      return getMaxValue(n.getRight());
    }
  }

  /**
   * Returns whether or not the value exists in the tree
   *
   * @return true if the value exists, false otherwise
   */
  public boolean contains(int value) {
    return containsValue(this.root, value); //call recursive contains below
  }

  private boolean containsValue(BinaryTreeNode curr, int val) {
    if(curr == null) { //if root is null, there is no true so does not contain
      return false;
    }
    if(val < curr.getValue()) { //if desired value is less than current, go left through recursive call
      return containsValue(curr.getLeft(), val);
    } else if(val > curr.getValue()) { //if desired value is greater than current, go right through recursive call
      return containsValue(curr.getRight(), val);
    } else { //otherwise return true as it is the root
      return true;
    }
  }

  /**
   * Returns an preorder-traversed array
   *
   * @return an array of Integers, or empty if the tree is empty.
   */
  public Integer[] toPreOrder() {
    ArrayList<Integer> preOrder = new ArrayList<Integer>();

    if(this.root == null) { //if root equals null, make an empty array
      Integer[] answ = new Integer[0];
      return preOrder.toArray(answ);
    } else { //otherwise create array based upon size of arraylist and transfer values to array from arraylist
      preOrderTraverse(this.root, preOrder);
      Integer[] answ = new Integer[preOrder.size()];
      return preOrder.toArray(answ);
    }
  }

  private void preOrderTraverse(BinaryTreeNode n, ArrayList<Integer> preOrder) {
    if(n != null) { //as long as node does not equal null, keep adding values to arraylist in preorder order
      preOrder.add(n.getValue());
      preOrderTraverse(n.getLeft(), preOrder);
      preOrderTraverse(n.getRight(), preOrder);
    }
  }

  /**
   * Returns an inorder-traversed array
   *
   * @return an array of Integers, or empty if the tree is empty.
   */
  public Integer[] toInOrder() {
    ArrayList<Integer> inOrder = new ArrayList<Integer>();

    if(this.root == null) { //if root equals null, make an empty array
      Integer[] answ = new Integer[0];
      return inOrder.toArray(answ);
    } else { //otherwise create array based upon size of arraylist and transfer values to array from arraylist
      inOrderTraverse(this.root, inOrder);
      Integer[] answ = new Integer[inOrder.size()];
      return inOrder.toArray(answ);
    }
  }

  private void inOrderTraverse(BinaryTreeNode n, ArrayList<Integer> inOrder) {
    if(n != null) { //as long as node does not equal null, keep adding values to arraylist in order
      inOrderTraverse(n.getLeft(), inOrder);
      inOrder.add(n.getValue());
      inOrderTraverse(n.getRight(), inOrder);
    }
  }

  /**
   * Returns an postorder-traversed array
   *
   * @return an array of Integers, or empty if the tree is empty.
   */
  public Integer[] toPostOrder() {
    ArrayList<Integer> postOrder = new ArrayList<Integer>();

    if(this.root == null) { //if root equals null, make an empty array
      Integer[] answ = new Integer[0];
      return postOrder.toArray(answ);
    } else { //otherwise create array based upon size of arraylist and transfer values to array from arraylist
      postOrderTraverse(this.root, postOrder);
      Integer[] answ = new Integer[postOrder.size()];
      return postOrder.toArray(answ);
    }
  }

  private void postOrderTraverse(BinaryTreeNode n, ArrayList<Integer> postOrder) {
    if(n != null) { //as long as node does not equal null, keep adding values to arraylist in postorder order
      postOrderTraverse(n.getLeft(), postOrder);
      postOrderTraverse(n.getRight(), postOrder);
      postOrder.add(n.getValue());
    }
  }

  /**
   * Returns an Breadth First-traversed array
   *
   * @return an array of Integers, or empty if the tree is empty.
   */
  public Integer[] toBreadthFirstOrder() {
    ArrayList<Integer> breadthOrder = new ArrayList<Integer>();

    if(this.root == null) { //if root equals null, make an empty array
      Integer[] answ = new Integer[0];
      return breadthOrder.toArray(answ);
    } else { //otherwise create array based upon size of arraylist and transfer values to array from arraylist
      breadthOrderTraverse(breadthOrder);
      Integer[] answ = new Integer[breadthOrder.size()];
      return breadthOrder.toArray(answ);
    }
  }

  private void breadthOrderTraverse(ArrayList<Integer> breadthOrder) {
    Queue<BinaryTreeNode> breadthQue = new LinkedList<BinaryTreeNode>();
    breadthQue.clear(); //clear queue

    breadthQue.offer(this.root); //initialize head
    while(!breadthQue.isEmpty()) { //as long as the queue is not empty
      BinaryTreeNode node = breadthQue.poll(); //removes head 
      breadthOrder.add(node.getValue()); //add head to arraylist
      if(node.getLeft() != null) { //if left node does not equal null, add it to the que
        breadthQue.add(node.getLeft());
      }
      if(node.getRight() != null) { //if right node does not equal null, add it to the que
        breadthQue.add(node.getRight());
      }
    }
  }
}