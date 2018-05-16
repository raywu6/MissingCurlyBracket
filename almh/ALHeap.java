//MissingCurlyBracket -- Raymond Wu, Woosuk Lee, Eric Wong
//APCS pd8
//HW48 -- Sink||Swim
//2018-05-15

/*****************************************************
 * class ALHeap
 * Implements a min heap using an ArrayList as underlying container
 *****************************************************/

import java.util.*;

public class ALHeap
{

    //instance vars
    private ArrayList<Integer> _heap;

    /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
    public ALHeap()
    {
	_heap = new ArrayList<Integer>();
    }

    /*****************************************************
     * toString()  ---  overrides inherited method
     * Returns either
     * a) a level-order traversal of the tree (simple version)
     * b) ASCII representation of the tree (more complicated, more fun)
     *****************************************************/
    public String toString()
    {
	String retStr = "[";
	for( int i : _heap) {
	    retStr += i + ",";
	}
	return retStr + "\b" + "]";
    }//O(n)


    /*****************************************************
     * boolean isEmpty()
     * Returns true if no meaningful elements in heap, false otherwise
     *****************************************************/
    public boolean isEmpty()
    {
	return _heap.size() == 0;
    }//O(1)


    /*****************************************************
     * Integer peekMin()
     * Returns min value in heap
     * Postcondition: Heap remains unchanged.
     *****************************************************/
    public Integer peekMin()
    {
	return _heap.get(0);
    }//O(1)


    /*****************************************************
     * add(Integer)
     * Inserts an element in the heap
     * Postcondition: Tree exhibits heap property.
     *
     * Algo:
     * 0. Add addVal to end of heap ArrayList
     * 1. 
     *****************************************************/
    public void add( Integer addVal )
    {
	_heap.add(addVal);
	int index = _heap.size() - 1;
	int parent = (index-1)/2;

	while (parent > 1 && _heap.get(index) < _heap.get(parent)) {
	    swap(index, parent);
	    index = parent;
	    parent = (index-1)/2;
	}
    }//O(logn)


    /*****************************************************
     * removeMin()  ---  means of removing an element from heap
     * Removes and returns least element in heap.
     * Postcondition: Tree maintains heap property.
     *****************************************************/
    public Integer removeMin()
    {
	if (isEmpty()) {
	    throw new NoSuchElementException("no more elements!!!");
	}
	swap(0, _heap.size()-1);
	int ans = _heap.remove(_heap.size()-1);
	int index = 0;
	int child = minChildPos(index);
	while (child > -1) {
	    swap(index, child);
	    index = child;
	    child = minChildPos(index);
	}
	return ans;

    }//O(?)


    /*****************************************************
     * minChildPos(int)  ---  helper fxn for removeMin()
     * Returns index of least child, or
     * -1 if no children, or if input pos is not in ArrayList
     * Postcondition: Tree unchanged
     *****************************************************/
    private int minChildPos( int pos )
    {
	try{
	    if(_heap.get(pos * 2 + 2) == null) return pos * 2 + 1;
	    else if(_heap.get(pos * 2 + 1) == null) return pos * 2 + 2;
	    else if(_heap.get(pos * 2 + 2) < _heap.get(pos * 2 + 1)) return pos * 2 + 2;
	    else return pos * 2 + 1;
	}
	catch(Exception e){
	    return -1;
	}
    }//O(1)


    //************ aux helper fxns ***************
    private Integer minOf( Integer a, Integer b )
    {
	if ( a.compareTo(b) < 0 )
	    return a;
	else
	    return b;
    }

    //swap for an ArrayList
    private void swap( int pos1, int pos2 )
    {
	_heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );
    }



    //main method for testing
    public static void main( String[] args )
    {

	ALHeap pile = new ALHeap();

	pile.add(2);
	System.out.println(pile);
	pile.add(4);
	System.out.println(pile);
	pile.add(6);
	System.out.println(pile);
	pile.add(8);
	System.out.println(pile);
	pile.add(10);
	System.out.println(pile);
	pile.add(1);
	System.out.println(pile);
	pile.add(3);
	System.out.println(pile);
	pile.add(5);
	System.out.println(pile);
	pile.add(7);
	System.out.println(pile);
	pile.add(9);
	System.out.println(pile);

	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);

    }//end main()

}//end class ALHeap
