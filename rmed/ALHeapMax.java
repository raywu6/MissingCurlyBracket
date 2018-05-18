// Team MissingCurlyBracket -- Raymond Wu, Woosuk Lee, Eric Wong
// APCS2 pd8
// HW50 -- Run Run Run, take a breath or two
// 2018-05-17

/*****************************************************
 * class ALHeapMax
 * Implements a max heap using an ArrayList as underlying container
 *****************************************************/

import java.util.*;

public class ALHeapMax
{

    //instance vars
    private ArrayList<Integer> _heap;

    /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
    public ALHeapMax()
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
     * Integer peekMax()
     * Returns max value in heap
     * Postcondition: Heap remains unchanged.
     *****************************************************/
    public Integer peekMax()
    {
	return _heap.get(0);
    }//O(1)


    /*****************************************************
     * add(Integer)
     * Inserts an element in the heap
     * Postcondition: Tree exhibits heap property.
     *
     * Algo:
     *  0. Add addVal to left-most child of lowest depth.
     * 1a. While addVal is greater than parent,
     *       swap addVal and parent.
     * 1b.   Update parent.
     *****************************************************/
    public void add( Integer addVal )
    {
	_heap.add(addVal);
	int index = _heap.size() - 1;
	int parent = (index-1)/2;
	
	while (parent >= 0 && _heap.get(index) > _heap.get(parent)) {
	    swap(index, parent);
	    index = parent;
	    parent = (index-1)/2;
	}
    }//O(logn)

    
    /*****************************************************
     * removeMax()  ---  means of removing an element from heap
     * Removes and returns maximum element in heap.
     * Postcondition: Tree maintains heap property.
     *
     * Algo:
     *  0. If heap is empty, throw exception.
     *  1. Swap root with bottom-most, right-most leaf.
     *  2. Remove bottom-most, right-most leaf (old root).
     *  3. Rearrange tree from top-down until tree exhibits maxheap property.
     *****************************************************/
    public Integer removeMax()
    {
	if (isEmpty()) {
	    throw new NoSuchElementException("no more elements!!!");
	}
	swap(0, _heap.size()-1);
	int ans = _heap.remove(_heap.size()-1);
	
	int index = 0;
	int child = maxChildPos(index);
	while (child > -1) {
	    swap(index, child);
	    index = child;
	    child = maxChildPos(index);
	}
	return ans;

    }//O(n)


     /*****************************************************
      * maxChildPos(int)  ---  helper fxn for removeMax()
      * Returns index of maximum child, or
      * -1 if no children, or if input pos is not in ArrayList
      * Postcondition: Tree unchanged
      *****************************************************/
    private int maxChildPos( int pos )
    {
	try{
	    if(_heap.get(pos * 2 + 2) == null) return pos * 2 + 1;
	    else if(_heap.get(pos * 2 + 1) == null) return pos * 2 + 2;
	    else if(_heap.get(pos * 2 + 2) > _heap.get(pos * 2 + 1)) return pos * 2 + 2;
	    else return pos * 2 + 1;
	}
	catch(Exception e){
	    return -1;
	}
    }//O(1)

    
    /*****************************************************
     * getSize() 
     * Returns size of current heap
     *****************************************************/
    public int getSize() {
	return _heap.size();
    }

    
    //************ aux helper fxns ***************
    private Integer maxOf( Integer a, Integer b )
    {
	if ( a.compareTo(b) > 0 )
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

	ALHeapMax pile = new ALHeapMax();

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

	System.out.println("removing " + pile.removeMax() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMax() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMax() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMax() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMax() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMax() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMax() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMax() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMax() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMax() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMax() + "...");
	System.out.println(pile);

    }//end main()

}//end class ALHeapMax
