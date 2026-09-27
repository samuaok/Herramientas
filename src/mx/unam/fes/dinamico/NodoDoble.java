package mx.unam.fes.dinamico;

/**
 * Clase genérica para los nodos de enlace doble
 * Almacena un dato y las referencias tanto al elemento siguiente como al anterior
 */
public class NodoDoble<E> {
    E dato;
    NodoDoble<E> siguiente;
    NodoDoble<E> anterior;

    /**
     * Constructor inicial. Asigna el dato y establece ambas referencias en nulo
     */
    public NodoDoble(E dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
}