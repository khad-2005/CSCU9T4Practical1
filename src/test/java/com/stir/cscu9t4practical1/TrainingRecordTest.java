/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stir.cscu9t4practical1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author saemundur
 */
public class TrainingRecordTest {
    public TrainingRecordTest() {
    }

    @BeforeAll
    public void setUpClass() {
    }

    @AfterAll
    public void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addEntry method, of class TrainingRecord.
     * You might want to extend this test when you implement the other
     * Entry types
     */
    @Test
public void testAddEntry() {
    System.out.println("addEntry");
    TrainingRecord instance = new TrainingRecord();
    instance.addEntry(new Run("Alice", 1, 2, 2003, 0, 16, 7, 3, 10, 30));
    assertEquals(instance.getNumberOfEntries(), 1);
}

    /**
     * Test of addEntry with a repeat
     * Adding another entry for the same person on the same day should fail
     */
    @Test
    public void testAddEntryUnique() {
        System.out.println("addEntry -- fail");
        TrainingRecord instance = new TrainingRecord();
        instance.addEntry(new Run("Alice", 1, 2, 2003, 0, 16, 7, 3,10,20));
        instance.addEntry(new Run("Alice", 1, 2, 2003, 0, 16, 7, 3,20,30));
    }

    /**
     * Test of lookupEntry method, of class TrainingRecord.
     */
    @Test
public void testLookupEntry() {
    System.out.println("lookupEntry");
    TrainingRecord instance = new TrainingRecord();
    instance.addEntry(new Run("Alice", 1, 2, 2003, 0, 16, 7, 3, 10, 30));
    instance.addEntry(new Run("Bob", 1, 2, 2003, 0, 14, 15, 3, 10, 30));
    int d = 1;
    int m = 2;
    int y = 2003;
    String result = instance.lookupEntry(d, m, y);
    assertNotEquals("No entries found", result, "expecting to find the entry");
    result = instance.lookupEntry(1, 2, 1999);
    assertEquals("No entries found", result, "expecting to not find the entry");
}

    /**
     * Test of getNumberOfEntries, of class TrainingRecord
     */
    @Test
    public void testGetNumberOfEntries() {
        System.out.println("GetNumberOfEntries");
        TrainingRecord instance = new TrainingRecord();
        instance.addEntry(new Run("Alice", 1, 2, 2003, 0, 16, 7, 3,10,20));
        instance.addEntry(new Run("Bob", 1, 2, 2003,0, 14, 15, 3,10,30));
        instance.addEntry(new Run("Claire", 7, 3, 2010, 0, 26, 20, 7,30,20));
        instance.addEntry(new Run("Claire", 11, 3, 2010, 0, 24, 55, 7,20,10));
        assertEquals(instance.getNumberOfEntries(), 4);
    }

    /**
     * Test of lookupEntries method, of class TrainingRecord
     */
    @Test
    public void testLookupEntries() {
        TrainingRecord instance = new TrainingRecord();
        instance.addEntry(new Run("Alice", 1, 2, 2003, 0, 16, 7, 3, 10, 30));
        instance.addEntry(new Run("Bob", 1, 2, 2003, 0, 14, 15, 3, 10, 30));
        String expectResults = "Alice ran 3.0 km in 0:16:7 on 1/2/2003 with Repetitions of 10 and with a Recovery of 30\n" + 
                                "Bob ran 3.0 km in 0:14:15 on 1/2/2003 with Repetitions of 10 and with a Recovery of 30\n";
        String result = instance.lookupEntries(1, 2, 2003);
        assertEquals(expectResults, result);
        String expectResultsNone = "Sorry couldn't find anything for this date";
        result = instance.lookupEntries(1, 2, 1999);
        assertEquals(expectResultsNone, result);
    }
}
