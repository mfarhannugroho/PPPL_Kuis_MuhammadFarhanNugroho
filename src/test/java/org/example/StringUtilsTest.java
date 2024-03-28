package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @AfterEach
    void tearDown() {
        stringUtils = null;
    }

    @Test
    void reverseString() {
        assertEquals("olleh", stringUtils.reverseString("hello"));
        assertEquals("54321", stringUtils.reverseString("12345"));
        assertEquals("", stringUtils.reverseString(""));
        assertNull(stringUtils.reverseString(null));
    }

    @Test
    void isPalindrome() {
        assertTrue(stringUtils.isPalindrome("racecar"));
        assertTrue(stringUtils.isPalindrome("A man, a plan, a canal, Panama!"));
        assertFalse(stringUtils.isPalindrome("hello"));
        assertFalse(stringUtils.isPalindrome("123456"));
        assertFalse(stringUtils.isPalindrome(null));
    }

    @Test
    void countVowels() {
        assertEquals(2, stringUtils.countVowels("hello"));
        assertEquals(3, stringUtils.countVowels("programming"));
        assertEquals(0, stringUtils.countVowels("nth"));
        assertEquals(0, stringUtils.countVowels(""));
        assertEquals(0, stringUtils.countVowels(null));
    }
}
