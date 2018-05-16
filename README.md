# MissingCurlyBracket -- Raymond Wu, Woosuk Lee, Eric Wong

<b> ArrayPriorityQueue </b>

## Methods
Per the APCS subset PriorityQueue interface...
* `add(String)` -- Adds an item to this priority queue
* `isEmpty()` -- Returns true if this stack is empty, otherwise returns false
* `peekMin()` -- Returns the smallest item stored in this priority queue without removing it
* `removeMin()` -- Removes and returns the smallest item stored in this priority queue

## Time complexities & Decisions 
We noticed that the Duke API ofered the time complexities for the operations `add(Object)`, `peekMin()`, and `removeMin()`, and we realized that this gave us a big hint about how one should implement said methods. 

The worst and average case for the `add(String)` method is **O(1)**. This is because the `add(String)` method should only add the given String at the end of the queue. As a priority queue is a queue maintaining the invaiant that an element of higher priority is *dequeued* before an element of lower priority, one does not have to rearrange the queue to reflect priority. 
 
The worst and average case for the `peekMin()` method is **O(n)**. As the queue is not sorted based on priority, the elements of the priority queue must be iterated through to find the String with the minimum value. 

The worst and average case for the `removeMin()` method is **O(n)**. As the queue is not sorted based on priority, the elements of the priority queue must be iterated through to find the String with the minimum value, and remove said String.

## Heap todo
0. Implement `toString()` as we need it to track changes and debug the other methods
1. Implement constructor `ALHeap()` as we need an instance of the class to call its methods
2. Implement aux helper fxn `minOf(Integer, Integer)`
3. Implement aux helper fxn `swap(int, int)`
4. Implement helper fxn `minChildPos(int)` for `removeMin()`
5. Implement `removeMin()`
6. Implement `add(Integer)`
7. Implement `isEmpty()`
8. Implement `peekMin()`
