package edu.neu.khoury.cs5004.assignment5.problem3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class PostOrderIteratorTest {

  private PostOrderIterator iter;

  @Before
  public void setUp() throws Exception {
    Node node1 = new Node(3);
    Node node2 = new Node(30);
    Node node3 = new Node(20);
    Node node4 = new Node(100);
    Node node5 = new Node(8);
    Node node6 = new Node(5);
    Node node7 = new Node(1);
    Node node8 = new Node(50);
    Node node9 = new Node(4);

    node1.setLeft(node2);
    node1.setRight(node3);
    node2.setLeft(node4);
    node2.setRight(node5);
    node5.setLeft(node6);
    node5.setRight(node7);
    node3.setLeft(node8);
    node3.setRight(node9);

    IntegerBinaryTree tree = new LinkedIntegerBinaryTree(node1);
    iter = tree.postOrderIter();
  }

  @Test
  public void emptyConstructorTest() {
    iter = new PostOrderIterator(null);
    assertFalse(iter.hasNext());
  }

  @Test
  public void next() {
    Integer[] expectedOrder = new Integer[]{100, 5, 1, 8, 30, 50, 4, 20, 3};
    assertEquals(expectedOrder[0], iter.next());
    assertEquals(expectedOrder[1], iter.next());
    assertEquals(expectedOrder[2], iter.next());
    assertEquals(expectedOrder[3], iter.next());
    assertEquals(expectedOrder[4], iter.next());
    assertEquals(expectedOrder[5], iter.next());
    assertEquals(expectedOrder[6], iter.next());
    assertEquals(expectedOrder[7], iter.next());
    assertEquals(expectedOrder[8], iter.next());
    assertFalse(iter.hasNext());
  }

  @Test
  public void nextOne() {
    Node node1 = new Node(3);
    IntegerBinaryTree tree = new LinkedIntegerBinaryTree(node1);
    iter = tree.postOrderIter();

    Integer[] expectedOrder = new Integer[]{3};
    assertEquals(expectedOrder[0], iter.next());
    assertFalse(iter.hasNext());
  }

  @Test
  public void nextOneLeft() {
    Node node1 = new Node(3);
    Node node2 = new Node(30);
    node1.setLeft(node2);
    IntegerBinaryTree tree = new LinkedIntegerBinaryTree(node1);
    iter = tree.postOrderIter();

    Integer[] expectedOrder = new Integer[]{30, 3};
    assertEquals(expectedOrder[0], iter.next());
    assertEquals(expectedOrder[1], iter.next());
    assertFalse(iter.hasNext());
  }

  @Test
  public void nextOneRight() {
    Node node1 = new Node(3);
    Node node2 = new Node(30);
    node1.setRight(node2);
    IntegerBinaryTree tree = new LinkedIntegerBinaryTree(node1);
    iter = tree.postOrderIter();

    Integer[] expectedOrder = new Integer[]{30, 3};
    assertEquals(expectedOrder[0], iter.next());
    assertEquals(expectedOrder[1], iter.next());
    assertFalse(iter.hasNext());
  }

  @Test
  public void nextZigZag() {
    Node node1 = new Node(3);
    Node node2 = new Node(30);
    Node node5 = new Node(8);
    Node node6 = new Node(5);

    node1.setLeft(node2);
    node2.setRight(node5);
    node5.setLeft(node6);

    IntegerBinaryTree tree = new LinkedIntegerBinaryTree(node1);
    iter = tree.postOrderIter();

    Integer[] expectedOrder = new Integer[]{5, 8, 30, 3};
    assertEquals(expectedOrder[0], iter.next());
    assertEquals(expectedOrder[1], iter.next());
    assertEquals(expectedOrder[2], iter.next());
    assertEquals(expectedOrder[3], iter.next());
    assertFalse(iter.hasNext());
  }
}