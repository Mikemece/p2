package org.mps.deque;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


public class DoublyLinkedListDequeTest {

    DoublyLinkedListDeque<Object> list;
    @BeforeEach
    void setup(){
        list = new DoublyLinkedListDeque<>();
    }
    @AfterEach
    void finish(){
        list = null;
    }
    @Nested
    @DisplayName("An empty list")
    class EmptyListTests {      //PRUEBAS PARA LISTAS VACIAS
        @Test
        @DisplayName("Will be empty")
        void newlyCreatedListIsEmpty() {        //Comprobamos que la lista sea vacía al crearla
            int obtainedValue = list.size();
            int expectedValue = 0;
            assertEquals(expectedValue, obtainedValue);
        }

        @Test
        @DisplayName("The first node will be null")
        void firstItemOfEmptyListIsNull() {         //Comprobamos que el primer objeto de la lista sea nulo
            Object obtainedValue = list.first();
            Object expectedValue = null;
            assertEquals(expectedValue, obtainedValue);
        }

        @Test
        @DisplayName("The last node will be null")
        void lastItemOfEmptyListIsNull() {          //Comprobamos que el último objeto de la lista sea nulo
            Object obtainedValue = list.last();
            Object expectedValue = null;
            assertEquals(expectedValue, obtainedValue);
        }

        @Test
        @DisplayName("Deleting the first item of an empty list throws exception")
        void deletingFirstItemOfEmptyListIsError() {        //Comprobamos que se lanza una excepción al intentar borrar el primer elemento
            assertThrows(DoubleEndedQueueException.class, () -> list.deleteFirst());
        }

        @Test
        @DisplayName("Deleting the last item of an empty list throws exception")
        void deletingLastItemOfEmptyListIsError() {         //Comprobamos que se lanza una excepción al intentar borrar el último elemento
            assertThrows(DoubleEndedQueueException.class, () -> list.deleteLast());
        }
    }

    @Nested
    @DisplayName("A list with one node")
    class ListsWithOneItemTests {           //PRUEBAS PARA LISTAS DE UN ELEMENTO

        @Test
        @DisplayName("Will have size one")
        void listOfOneItemHasLengthOne() {      //Comprobamos que la lista tenga tamaño uno
            list.append(1);
            int obtainedValue = list.size();
            int expectedValue = 1;
            assertEquals(expectedValue, obtainedValue);
        }

        @Test
        @DisplayName("The first element will also be the last element")
        void listOfOneItemHasFirstEqualToLast() {       //Comprobamos que el primer y último elemento sea el mismo
            list.append(1);
            assertSame(list.first(), list.last());
        }

        @Test
        @DisplayName("Will be empty when deleting the first node")
        void emptyListWhenDeletingFirstTheOnlyItem() {      //Comprobamos que al borrar el primer nodo, la lista estará vacía
            list.append(1);
            list.deleteFirst();
            assertNull(list.first());
            assertNull(list.last());
            assertEquals(0, list.size());
        }
        @Test
        @DisplayName("Will be empty when deleting the last node")
        void emptyListWhenDeletingLastTheOnlyItem() {       //Comprobamos que al borrar el último nodo, la lista estará vacía
            list.append(1);
            list.deleteLast();
            assertNull(list.first());
            assertNull(list.last());
            assertEquals(0, list.size());
        }
    }

    @Nested
    @DisplayName("A list with various nodes")
    class ListWithMoreThanOneItemTests {            //PRUEBAS PARA LISTAS CON MÁS ELEMENTOS
        @Nested
        @DisplayName("When Adding a node")              //PRUEBAS PARA CUANDO SE AÑADAN UN ELEMENTO A DICHAS LISTAS
        class AddingANodeToAList{
            @Test
            @DisplayName("Appending will make that node be the last one")
            void newlyAppendedNodeIsLast() {        //Comprobamos que al añadir un nodo al final, este será el último
                list.append(1);
                list.append(2);
                Object obtainedValue = list.last();
                Object expectedValue = 2;
                assertEquals(expectedValue, obtainedValue);
            }

            @Test
            @DisplayName("Prepending will make that node be the first one")
            void newlyPrependedNodeIsFirst() {          //Comprobamos que al añadir un nodo al principio, este será el primero
                list.prepend(1);
                list.prepend(2);
                Object obtainedValue = list.first();
                Object expectedValue = 2;
                assertEquals(expectedValue, obtainedValue);
            }
        }
        @Nested
        @DisplayName("When Deleting a node")
        class DeletingANodeOfAList{         //PRUEBAS PARA CUANDO SE BORREN NODOS DE DICHAS LISTAS
            @Test
            @DisplayName("Deleting the first will decrease the size and the new first node will be the previous second node")
            void deleteFirst() {            //Al borrar el primero, el tamaña decrementa y el primer nodo será lo que antes era el segundo nodo
                list.append(1);
                list.append(2);
                list.deleteFirst();
                Object obtainedValue = list.first();
                Object expectedValue = 2;
                assertEquals(expectedValue, obtainedValue);
                assertEquals(1, list.size());
            }

            @Test
            @DisplayName("Deleting the last will decrease the size and the new last node will be the previous before last node")
            void deleteLast() {             //Al borrar el último nodo, el tamaño decrementa y el último nodo será lo que antes era el penúltimo nodo
                list.append(1);
                list.append(2);
                list.deleteLast();
                Object obtainedValue = list.last();
                Object expectedValue = 1;
                assertEquals(expectedValue, obtainedValue);
                assertEquals(1, list.size());
            }
        }
    }
}
