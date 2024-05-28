package com.example.miniproject;

import junit.framework.TestCase;

public class ticketTest extends TestCase {
ticket tk;
    public void setUp() throws Exception {
        super.setUp();
        tk=new ticket();
    }

    public void tearDown() throws Exception {
    }

    public void testGetDiscount() {
        double pr=30, nt=9;
        double act= tk.getDiscount(pr,nt);
        double exp=135;
        assertEquals("The total price is expected to be",act,exp);
    }
}