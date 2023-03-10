package org.mps.deque;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class DequeNodeTest {
    DequeNode<Object> vacio, medio, primero, ultimo;

    @BeforeEach
    void setup() {
        vacio = new DequeNode(null, null, null);
        ultimo = new DequeNode(93.12, null, null);
        medio = new DequeNode("prueba", null, null);
        primero = new DequeNode(1, null, null);
        ultimo.setPrevious(medio);
        medio.setNext(ultimo);
        medio.setPrevious(primero);
        primero.setNext(medio);

    }

    @AfterEach
    void teardown() {
        vacio = null;
        primero = null;
        medio = null;
        ultimo = null;
    }

    /**
     * 1. Un elemento sin previo es el primero
     * 2. Un elemento sin siguiente es el último
     * 3. Un node con item devuelve su item (null o no null)
     * 4. Hacer getNext() de un nodo da su siguiente (null o no)
     * 5. Hacer getPrevious() de un nodo da su previo (null o no)
     * 6. setItem() de un nodo cambia su item por el dado
     * 7. setPrevious() de un nodo cambia su previo por el dado
     * 8. setNext() de un nodo cambia su siguiente por el dado
     * 9. Un nodo con previo y siguiente no es terminal
     * 10. Un nodo sin previo o sin siguiente es terminal
     */

    @Nested
    @DisplayName("The node will be in ")
    class testsOfPosition {
        @Test
        @DisplayName("first position")
        void nodoEsPrimero() {
            assertTrue(primero.isFirstNode());
        }

        @Test
        @DisplayName("last position")
        void nodoEsUltimo() {
            assertTrue(ultimo.isLastNode());
        }

        @Test
        @DisplayName("a non terminal position")
        void nodoConPrevioYSiguienteNoTerminal() {
            assertTrue(medio.isNotATerminalNode());
        }

        @Test
        @DisplayName("a terminal position because it is first")
        void nodoSinPrevioTerminal() {
            assertFalse(primero.isNotATerminalNode());
        }

        @Test
        @DisplayName("a terminal position because it is last")
        void nodoSinSiguienteTerminall() {
            assertFalse(ultimo.isNotATerminalNode());
        }
    }

    @Nested
    @DisplayName("The node will return ")
    class testGets {
        @Test
        @DisplayName("next node null")
        void devuelveSiguienteNull() {
            DequeNode expectedValue = null;
            DequeNode obtainedValue = ultimo.getNext();
            assertEquals(expectedValue, obtainedValue);
        }
        @Test
        @DisplayName("next node")
        void devuelveSiguiente() {
            DequeNode expectedValue = medio;
            DequeNode obtainedValue = primero.getNext();
            assertEquals(expectedValue, obtainedValue);
        }

        @Test
        @DisplayName("previous node null")
        void devuelvePrevioNull() {
            DequeNode expectedValue = null;
            DequeNode obtainedValue = primero.getPrevious();
            assertEquals(expectedValue, obtainedValue);
        }

        @Test
        @DisplayName("previous node")
        void devuelvePrevio() {
            DequeNode expectedValue = medio;
            DequeNode obtainedValue = ultimo.getPrevious();
            assertEquals(expectedValue, obtainedValue);
        }

        @Nested
        @DisplayName("the right item of type ")
        class testItems {
            @Test
            @DisplayName("null")
            void devuelveItemNull() {
                Object expectedValue = null;
                Object obtainedValue = vacio.getItem();
                assertEquals(expectedValue, obtainedValue);
            }

            @Test
            @DisplayName("int")
            void devuelveItemInt() {
                Object expectedValue = 1;
                Object obtainedValue = primero.getItem();
                assertEquals(expectedValue, obtainedValue);
            }

            @Test
            @DisplayName("String")
            void devuelveItemString() {
                Object expectedValue = "prueba";
                Object obtainedValue = medio.getItem();
                assertEquals(expectedValue, obtainedValue);
            }

            @Test
            @DisplayName("Double")
            void devuelveItemDouble() {
                Object expectedValue = 93.12;
                Object obtainedValue = ultimo.getItem();
                assertEquals(expectedValue, obtainedValue);
            }
        }
    }

    @Nested
    @DisplayName("In a node will be changed ")
    class testSet {
        @Test
        @DisplayName("the item")
        void cambiaItem() {
            vacio.setItem(12);

            Object expectedValue = 12;
            Object obtainedValue = vacio.getItem();
            assertEquals(expectedValue, obtainedValue);
        }

        @Test
        @DisplayName("the previous node")
        void cambiaPrevio() {
            vacio.setPrevious(ultimo);

            DequeNode expectedValue = ultimo;
            DequeNode obtainedValue = vacio.getPrevious();
            assertEquals(expectedValue, obtainedValue);
        }

        @Test
        @DisplayName("the next node")
        void cambiaSiguiente() {
            vacio.setNext(primero);

            DequeNode expectedValue = primero;
            DequeNode obtainedValue = vacio.getNext();
            assertEquals(expectedValue, obtainedValue);
        }

    }
}
