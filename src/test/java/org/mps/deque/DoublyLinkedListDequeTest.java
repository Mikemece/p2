package org.mps.deque;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class DoublyLinkedListDequeTest {

    @Nested
    @DisplayName("Tests for empty list")
    class EmptyListTests {
        @Test
        void newlyCreatedListIsEmpty() {
            DoublyLinkedListDeque<Object> list = new DoublyLinkedListDeque<>();
            int obtainedValue = list.size();
            int expectedValue = 0;
            assertEquals(expectedValue, obtainedValue);
        }

        @Test
        void firstItemOfEmptyListIsNull() {
            DoublyLinkedListDeque<Object> list = new DoublyLinkedListDeque<>();
            Object obtainedValue = list.first();
            Object expectedValue = null;
            assertEquals(expectedValue, obtainedValue);
        }

        @Test
        void lastItemOfEmptyListIsNull() {
            DoublyLinkedListDeque<Object> list = new DoublyLinkedListDeque<>();
            Object obtainedValue = list.last();
            Object expectedValue = null;
            assertEquals(expectedValue, obtainedValue);
        }
    }

    @Nested
    class ListsWithOneItemTests {

        @Test
        void listOfOneItemHasLengthOne() {
            var list = new DoublyLinkedListDeque<>();
            list.append(1);
            int obtainedValue = list.size();
            int expectedValue = 1;
            assertEquals(expectedValue, obtainedValue);
        }

        @Test
        void listOfOneItemHasFirstEqualToLast() {
            var list = new DoublyLinkedListDeque<>();
            list.append(1);
            assertSame(list.first(), list.last());
        }
    }

    @Nested
    class ListWithMoreThanOneItemTests {

        @Test
        void newlyAppendedNodeIsLast() {
            var list = new DoublyLinkedListDeque<>();
            list.append(1);
            list.append(2);
            Object obtainedValue = list.last();
            Object expectedValue = 2;
            assertEquals(expectedValue, obtainedValue);
        }

        @Test
        void newlyPrependedNodeIsFirst() {
            var list = new DoublyLinkedListDeque<>();
            list.prepend(1);
            list.prepend(2);
            Object obtainedValue = list.first();
            Object expectedValue = 2;
            assertEquals(expectedValue, obtainedValue);
        }

        @Test
        void deleteFirst() {
            var list = new DoublyLinkedListDeque<>();
            list.append(1);
            list.append(2);
            list.deleteFirst();
            Object obtainedValue = list.first();
            Object expectedValue = 2;
            assertEquals(expectedValue, obtainedValue);
            assertEquals(1, list.size());
        }

        @Test
        void deleteLast() {
            var list = new DoublyLinkedListDeque<>();
            list.append(1);
            list.append(2);
            list.deleteLast();
            Object obtainedValue = list.last();
            Object expectedValue = 1;
            assertEquals(expectedValue, obtainedValue);
            assertEquals(1, list.size());
        }

        @Test
        void deletingFirstItemOfEmptyListIsError() {
            var list = new DoublyLinkedListDeque<>();
            assertThrows(DoubleEndedQueueException.class, () -> list.deleteFirst());
        }

        @Test
        void deletingLastItemOfEmptyListIsError() {
            var list = new DoublyLinkedListDeque<>();
            assertThrows(DoubleEndedQueueException.class, () -> list.deleteLast());
        }

        @Test
        void emptyListWhenDeletingFirstTheOnlyItem() {
            var list = new DoublyLinkedListDeque<>();
            list.append(1);
            list.deleteFirst();
            assertNull(list.first());
            assertNull(list.last());
            assertEquals(0, list.size());
        }

        @Test
        void emptyListWhenDeletingLastTheOnlyItem() {
            var list = new DoublyLinkedListDeque<>();
            list.append(1);
            list.deleteLast();
            assertNull(list.first());
            assertNull(list.last());
            assertEquals(0, list.size());
        }
    }



    // al hacer append, el tamaño incrementa en 1
    // al hacer prepend, el tamaño incrementa en 1


}
