package org.mps.deque;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.mps.deque.DequeNode;

public class DequeNodeTest {
    DequeNode vacio, medio, primero, ultimo;

    @BeforeEach
    void setup(){
        vacio = new DequeNode(null, null, null);
        primero = new DequeNode(1, null, medio);
        medio = new DequeNode(2,primero, ultimo);
        ultimo = new DequeNode(93, medio, null);
    }
    @AfterEach
    void teardown(){
        vacio=null;
        primero=null;
        medio=null;
        ultimo=null;
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

    @Test
    void nodoEsPrimero(){
        assertTrue(primero.isFirstNode());
    }

}
