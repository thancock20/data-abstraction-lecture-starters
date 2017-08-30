package test;

import model.IntegerSet;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class IntegerSetTest {
    IntegerSet testSet;

    @Before
    public void setup() {
        testSet = new IntegerSet();
    }

    @Test
    public void testInsertNotThere() {
        checkEmptyDoesntContain(3);
        testSet.insert(3);
        checkSetContainsOnce(3);
    }

    @Test
    public void testInsertAlreadyThere() {
        checkEmptyDoesntContain(3);
        testSet.insert(3);
        checkSetContainsOnce(3);
        testSet.insert(3);
        checkSetContainsOnce(3);
    }

    @Test
    public void testRemoveNotThere() {
        checkEmptyDoesntContain(3);
        testSet.remove(3);
        checkEmptyDoesntContain(3);
    }

    @Test
    public void testRemoveIsThere() {
        checkEmptyDoesntContain(3);
        testSet.insert(3);
        checkSetContainsOnce(3);
        testSet.remove(3);
        checkEmptyDoesntContain(3);
    }

    @Test
    public void testRemoveMultipleItems() {
        checkEmptyDoesntContain(3);
        checkEmptyDoesntContain(4);
        testSet.insert(3);
        testSet.insert(4);
        testSet.remove(3);
        testSet.remove(4);
        checkEmptyDoesntContain(3);
        checkEmptyDoesntContain(4);
    }

    private void checkEmptyDoesntContain(int num) {
        assertEquals(testSet.size(), 0);
        assertFalse(testSet.contains(num));
    }

    private void checkSetContainsOnce(int num) {
        assertEquals(testSet.size(), 1);
        assertTrue(testSet.contains(num));
    }
}
