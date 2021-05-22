package com.github.andreyelagin.backtobackswe.stacksandqueues;

import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Objects;

public class CircularQueue {
  private int[] state = new int[10];

  private int head;
  private int tail;
  private int size;

  public CircularQueue() {
  }

  public void enqueue(int x) {
    if (size == state.length) {
      resize();
    }
    state[tail] = x;

    tail = (tail + 1) % state.length;
    size++;
  }

  public int dequeue() {
    if (size == 0) {
      throw new NoSuchElementException("Queue is empty.");
    }
    
    var item = state[head];
    head = (head + 1) % state.length;
    size--;
    
    return item;
  }
  
  public int size() {
    return size;
  }
  
  private void resize() {
    Collections.rotate(Arrays.asList(state), -head);
    head = 0;
    tail = size;
    
    state = Arrays.copyOf(state, size * 3 / 2);;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CircularQueue that = (CircularQueue) o;
    return size == that.size && Arrays.equals(state, that.state);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(size);
    result = 31 * result + Arrays.hashCode(state);
    return result;
  }
}
