// Raymond Wu
// APCS2 pd8
// HW46 -- Arrr, There Be Priorities Here Matey . . .
// 2018-05-10

/**
 * This file will also work if we do ...
 *   import java.util.*;
 * ... and implement the proper PriorityQueue interface ...
 * ... and allow generic typing for ArrayPriorityQueue  ...
 *   public class ArrayPriorityQueue<T> implements PriorityQueue<T>
 */

import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue
{
    // inst var
    ArrayList<String> _data;

    //constructor
    public ArrayPriorityQueue()
    { _data = new ArrayList<String>(); }

    //methods ... implementing PriorityQueue interface

    /**
     * void add(String)
     * Adds an item to this priority queue
     * Worst & average case O(1)
     *    Add to end of ArrayList
     */
    public void add(String s)
    { _data.add(s); }

    
    /**
     * boolean isEmpty()
     * Returns true if this stack is empty, o/w returns false
     * Worst & average case O(1)
     *    Use ArrayList size()
     */
    public boolean isEmpty()
    { return _data.size() == 0; }

    
    /**
     * boolean peekMin()
     * Returns smallest item stored in PriorityQueue w/o removing it
     * Worst & average case O(n)
     *    Iterate through APQ, return String w/ least val
     */
    public String peekMin()
    {
	if ( isEmpty() )
	    { throw new RuntimeException("PriorityQueue is empty"); }

	else {
	    String least = _data.get(0);
	    
	    for (String s : _data) {
		if ( s.compareTo(least) < 0 )
		    least = s;
	    }

	    return least;

	} // end else
    }


    /**
     * boolean removeMin()
     * Removes and returns smallest item stored in priority queue
     * Worst & average case O(n)
     *    Iterate through APQ, return & remove String w/ least val
     */

    public String removeMin()
    {
	if ( isEmpty() )
	    { throw new RuntimeException("PriorityQueue is empty"); }


	else {
	    String least = _data.get(0);
	    int index = 0;
	    
	    for (int i = 0; i < _data.size(); i++) {
		if ( _data.get(i).compareTo(least) < 0 )
		    {
			least = _data.get(i);
			index = i;
		    }
	    }

	    _data.remove(index);
	    return least;
	    
	} // end else

    } // end class peekMin()


    // for testing purposes...
    public String toString() {
	String retStr = "[";
	
	for (String s : _data)
	    retStr += s + " ";
	
	return retStr + "]";
    }


    public static void main (String[] args)
    {
	System.out.println("APQ instantiated...");
	ArrayPriorityQueue myAPQ = new ArrayPriorityQueue();

	System.out.print("is my APQ empty?: ");
	System.out.println( myAPQ.isEmpty() );     // true

	System.out.println("adding foo...");
	myAPQ.add("foo");

	System.out.print("is my APQ empty?: ");
	System.out.println( myAPQ.isEmpty() );     // false

	System.out.print("APQ now: ");
	System.out.println( myAPQ );               // [foo ]

	System.out.println("adding moo...");
	myAPQ.add("moo");

	System.out.print("is my APQ empty?: ");
	System.out.println( myAPQ.isEmpty() );     // false

	System.out.print("APQ now: ");
	System.out.println( myAPQ );               // [foo moo ]

	System.out.print("min String now: ");
	System.out.println( myAPQ.peekMin() );     // foo

	System.out.print("removing min: ");
	System.out.println( myAPQ.removeMin() );   // foo

	System.out.print("APQ now: ");
	System.out.println( myAPQ );               // [moo ]

	System.out.print("min String now: ");
	System.out.println( myAPQ.peekMin() );     // moo

	System.out.println("adding goo, hoo, doo...");
        myAPQ.add("goo");
	myAPQ.add("hoo");
	myAPQ.add("doo");

	System.out.print("APQ now: ");
	System.out.println( myAPQ );               // [moo goo hoo doo ]

	System.out.print("min String now: ");
	System.out.println( myAPQ.peekMin() );     // doo

	System.out.print("removing min: ");
	System.out.println( myAPQ.removeMin() ); // doo

	System.out.print("APQ now: ");
	System.out.println( myAPQ );               // [moo goo hoo ]

    } // end main method
    
} // end ArrayPriorityQueue class
