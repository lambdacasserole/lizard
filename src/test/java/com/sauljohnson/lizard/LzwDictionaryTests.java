package com.sauljohnson.lizard;

import junit.framework.TestCase;

/**
 * Unit tests for the {@link LzwDictionary} class.
 *
 * @version 1.0 25 May 2016
 * @author  Saul Johnson
 */
public class LzwDictionaryTests extends TestCase {

    public void testHasData() {
        // Initialize dictionary with one entry.
        LzwDictionary subject = new LzwDictionary();
        subject.addData("ff");

        // Dictionary should have data for "ff".
        assertTrue(subject.hasData("ff"));
    }

    public void testGetCode() {
        // Initialize dictionary with one entry.
        LzwDictionary subject = new LzwDictionary();
        subject.addData("ff");

        // Dictionary should contain code 0 against "ff".
        assertEquals(0, (int) subject.getCode("ff"));
    }

    public void testGetData() {
        // Initialize dictionary with one entry.
        LzwDictionary subject = new LzwDictionary();
        subject.addData("ff");

        // Dictionary should return correct data for code 0.
        assertEquals("ff", subject.getData((short) 0));
    }

    public void testGetSize() {
        // Initialize dictionary with one entry.
        LzwDictionary subject = new LzwDictionary();
        subject.addData("ff");

        // Dictionary should be of size 1.
        assertEquals(1, subject.getSize());
    }

    public void testIsFull() {
        // Initialize dictionary with one entry.
        LzwDictionary subject = new LzwDictionary();
        subject.addData("ff");

        // Dictionary should not be full at this stage.
        assertFalse(subject.isFull());

        // Fill the rest of the dictionary.
        for (int i = 0; i < Short.MAX_VALUE - 1; i++) {
            subject.addData(String.valueOf(i));
        }

        // Dictionary should now be full.
        assertTrue(subject.isFull());
    }
}
