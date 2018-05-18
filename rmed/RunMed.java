// Team MissingCurlyBracket -- Raymond Wu, Woosuk Lee, Eric Wong
// APCS2 pd8
// HW50 -- Run Run Run, take a breath or two
// 2018-05-17

import java.util.*;

public class RunMed {
    
    // inst vars
    ALHeapMin lilVals;
    ALHeapMax bigVals;

    // constructor
    public RunMed() {
	lilVals = new ALHeapMin();
	bigVals = new ALHeapMax();
    }

    // methods

    // thanks to JC for suggesting that the median be a double...
    public double getMedian() {
	return (double) ( lilVals.peekMin() + bigVals.peekMax() ) / 2;
    }


    // helper method for add(Integer)
    // if one heap > other heap by >1,
    // move root from bigger heap to smaller heap
    public void ensureBalance() {
	
	if ( bigVals.getSize() - lilVals.getSize() > 1 ) {
	    lilVals.add( bigVals.removeMax() );
	}

	else if ( lilVals.getSize() - bigVals.getSize() > 1 ) {
	    bigVals.add( lilVals.removeMin() );
	}

	System.out.println(bigVals);
	System.out.println(lilVals);
    }

    
    public void add(Integer newVal) {
	// first elem --> bigVals
	if (bigVals.getSize() == 0 && lilVals.getSize() == 0)
	    bigVals.add(newVal);

	else if ( newVal > bigVals.peekMax() )
	    lilVals.add(newVal);

	else if ( newVal < lilVals.peekMin() )
	    bigVals.add(newVal);

	ensureBalance();
    }

	
} // end class RunMed
