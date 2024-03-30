package com.cydeo.tightly_coupled;

//tightly couples means not flexible, hard to make change
//since Classes are related to each other, when we say tightly coupled
//we can say it is hard to make changes, it is not flexible. They are very tightly integrated each other
public class Main {

    public static void main(String[] args) {

        AcerMonitor theMonitor = new AcerMonitor("27inch Beast", "Acer", 27);
        DellCase theCase = new DellCase("220B", "Dell", "240");
        AsusMotherboard theMotherboard = new AsusMotherboard("BJ-200", "Asus", 4, 6, "v2.44");

        PC thePC = new PC(theCase, theMonitor, theMotherboard);
        // PC class is expecting specific class from me, we can not apply directly Sony monitor for example
        thePC.powerUp();





    }


}
