import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;// when we create Test class  this class is imported

class CalculatorTest { // I can run all of them by using the run botton in the class level

    @BeforeAll // BeforeAll method must be static
    static void setUpAll() {
        System.out.println("BeforeAll is executed"); // we will see for all the test before test
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("AfterAll is executed"); // we will see for all the test before test
    }

    @BeforeEach
    void setUpEach() {
        System.out.println("BeforeEach is executed"); // we will see for all the test before test
    }

    @AfterEach
    void tearDownEach() {
        System.out.println("AfterEach is executed"); // we will see for all the test after test
    }




    @Test
    void add() {
        System.out.println("Add method");
        int actual = Calculator.add(2, 3);
        assertEquals(5, actual, "Test failed"); // in JUnit5 expected first, actual second, for the others is different
    }
/* behind the scene
    new CalculatorTest().add();
    new CalculatorTest().add2(); // static is only one assigned so it is like the similar logic
    it is working like this
    */

    @Test
    void add2() {
        System.out.println("Add2 method");

       // assertThrows(IllegalArgumentException.class, ()-> Calculator.add2(3,2));// it is passed // in JUnit5 expected first, actual second, for the others is different
      //  assertThrows(IllegalArgumentException.class, ()-> Calculator.add2(3,2));
        assertThrows(IllegalArgumentException.class, () -> Calculator.add2(2, 3));//failed
    }
    //failed Expected java.lang.IllegalArgumentException to be thrown, but nothing was thrown.

    @Test
    void testCase1(){
        //System.out.println("Test Case 1");
        fail("Not yet implemented");
    }
    @Test
    void testCase2(){
        System.out.println("Test Case 2");
        assertEquals("add", Calculator.operator);
        assertTrue(Calculator.operator.equals("add"));

    }
    @Test
    void testCase3(){
        System.out.println("Test Case 3");
        assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3}, "Arrays are not same");
        //test passed
        //assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 3, 2}, "Arrays are not same");
        //we see the message only when test is false
    }
    @Test
    void testCase4(){
        System.out.println("Test Case 4");
        String nullString = null;
        String notNullString = "Cydeo";

        assertNull(nullString);
        assertNotNull(notNullString);

      //  assertNull(notNullString);// when it is failed, put underline this line amd it's gonna execute anything else, stop at this point
      //  assertNotNull(nullString);
    }

    @Test
    void testCase5(){
        System.out.println("Test Case 5");

        Calculator c1 = new Calculator();
        Calculator c2 = c1;// I am not creating new object and only referencing same object so it c1 and c2 same
        Calculator c3 = new Calculator();

        assertSame(c1,c2);
        assertNotSame(c1,c3);
    }
}