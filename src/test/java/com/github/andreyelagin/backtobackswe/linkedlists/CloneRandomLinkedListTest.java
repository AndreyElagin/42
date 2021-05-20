package com.github.andreyelagin.backtobackswe.linkedlists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CloneRandomLinkedListTest {

  CloneRandomLinkedList clone = new CloneRandomLinkedList();
  
  @Test
  void copyRandomList() {
    var first = new RandomListNode(1);
    var second = new RandomListNode(2);
    var third = new RandomListNode(3);
    first.next = second;
    second.next = third;
    second.random = third;
    third.random = first;

    clone.copyRandomList(first);
  }
}