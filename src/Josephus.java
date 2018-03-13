/**
* @Author Joseph Lashine, Austin Chiu, and Ryan Steup
* Josephus Game Version 1.0
*/
import java.util.*;
import java.io.*;
public class Josephus {
    public int Data;              // data item (key)
    public Josephus link;              // link Josephus in list
    /**
     * Constructor to create a Josephus
     * @param an integer that will be stored in the Josephus
     */
    public Josephus(int d)            // constructor
    { Data = d; }

    /**
     * Public method to print out the data being held in the Josephus
     */
    public void display1()      // display the current roster of players
    { System.out.print(Data + " "); }

        
    private Josephus current;          // reference to current Josephus
    private int numberp;             // number  of elements on list

    /**
     * Private method to create a default Josephus with 0 players and no nodes
     */
    public Josephus()              // constructor
    {
        numberp = 0;                  // no items on list yet
        current = null;
    }
    
    /**
     * Public method that lets you know if the Josephus is empty
     * @return true if the Josephus is empty, false if not
     */
    public boolean isEmpty()
    { return numberp==0; }

    /**
     * Public method to let you know the size of the Josephus
     * @return the number of values within the Josephus
     */
    public int getSize()
    { return numberp; }

    
    /**
     * Public method to add values to the Josephus
     * @param integer value to add to the Josephus
     */
    public void add(int id)     // insert after current Josephus
    {                           
        Josephus newJosephus = new Josephus(id); // make new Josephus
        if(numberp == 0)              // if first one
        {
            current = newJosephus;       // current points to the new Josephus
            current.link = current;  //The first link is used
        }
        else
        {
            newJosephus.link = current.link; 
            current.link = newJosephus;      
        }
        numberp++;                    // one more Josephus
    }

    /**
     * Public method to remove an element from the Josephus
     * @return the removed element
     */
    public Josephus remove()        // Delete  the Josephus following the current Josephus
    {
        Josephus temp1; // Create a temp
        switch(numberp)
        {
            case 0:               // Current element (temp) is already null
            temp1 = current;
            break;
            case 1:               // delete the current element
            temp1 = current;
            current = null;   
            numberp--;  // Delete one from the number of people in the Josephus
            break;
            default:              // delete the link one
            temp1 = current.link;
            current.link = temp1.link;
            numberp--;
            break;
        }
        return temp1;
    }

    /**
     * Public method to print out all the values within the Josephus
     */
    public void display()      // display the list
    {
        for(int j=0; j<numberp; j++)
        {
            current.link.display1();
            current = current.link;
        }
        System.out.println("");
    }

    /**
     * Public method to set the current Josephus 
     */
    public void step()
    {
        if(numberp != 0)
            current = current.link;  // go to link Josephus
    }

    /**
     * Public method the shows the current Josephus
     * @return the current Josephus 
     */
    public Josephus peek()
    { return current.link; }

}  // end class CurcList



