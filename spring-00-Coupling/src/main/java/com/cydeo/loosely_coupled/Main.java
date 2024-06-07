package com.cydeo.loosely_coupled;

import com.cydeo.loosely_coupled.casefactory.Case;
import com.cydeo.loosely_coupled.casefactory.DellCase;
import com.cydeo.loosely_coupled.monitorfactory.AcerMonitor;
import com.cydeo.loosely_coupled.monitorfactory.Monitor;
import com.cydeo.loosely_coupled.motherboardfactory.AsusMotherboard;
import com.cydeo.loosely_coupled.motherboardfactory.Motherboard;



public class Main {
    public static void main(String[] args) {

        Monitor theMonitor = new AcerMonitor("27inch Beast", "Acer", 27);
        Case theCase = new DellCase("220B", "Dell", "240");
        Motherboard theMotherboard = new AsusMotherboard("BJ-200", "Asus", 4, 6, "v2.44");

        PC myPc = new PC(theCase,theMonitor,theMotherboard);
       // without touching my PC class, with the help of abstraction,
        // I can create the different PC object for example with different monitor,
        // basically abstraction make it loosely coupled
        myPc.powerUp();

// if there are too much integrated, it is hard to change, then it is hardly coupled.
        //if it is flexible without changing the PC class in this example, we can different objects with different inputs,
        // then it is loosely couple.
    }
}
