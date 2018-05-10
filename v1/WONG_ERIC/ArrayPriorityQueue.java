//Eric Wong
//APCS pd8
//HW46 - Arrr, There Be Priorities Here Matey
//2018-05-10
import java.util.*;
public class ArrayPriorityQueue {
  ArrayList<String>data;
  int size;

  public ArrayPriorityQueue() {
    data = new ArrayList();
    size = 0;
  }

  //adds element to its sorted position - O(n)
  public void add(String s) {
    int counter = 0;
    if (size == 0) {
      data.add(s);
      size++;
    }
    else {
      for (int i = 0; i < size; i++) {
      if (data.get(i).compareTo(s) > 0) {
        data.add(i, s);
        size++;
        return;
      }
      }
      data.add(s);
      size ++;
    }
  }
  //check if there are elements in queue O(1)
  public boolean isEmpty() {
    return size == 0;
  }
  //return 'smallest' element O(1)
  public String peekMin() {
    return data.get(0);
  }
  //remove 'smallest' element O(1)
  public String removeMin() {
    return data.remove(0);
  }
  public String toString() {
    String retStr = "[";
    for (String s: data) {
      retStr += s + ",";
    }
    return retStr + "]";
  }
  public static void main(String[] args) {
    ArrayPriorityQueue test = new ArrayPriorityQueue();
    test.add("foo");
    test.add("moo");
    test.add("zoo");
    test.add("juul");
    System.out.println(test.peekMin());
    test.removeMin();
    test.add("boo");
    System.out.println(test);
  }

}
