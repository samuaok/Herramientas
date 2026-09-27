package mx.unam.fes.dinamico;

/**
 * Clase genérica para los nodos de enlace simple
 * Almacena un dato y la referencia al siguiente elemento
 */
public class Nodo<E> {
    E dato;
    Nodo<E> siguiente;

    /**
     * Constructor básico que recibe el dato. Por defecto, la referencia al siguiente es nula
     */
    public Nodo(E dato) {
        this.dato = dato;
        this.siguiente = null;
    }
    
    /**
     * Constructor sobrecargado para definir directamente a qué nodo apuntará
     */
    public Nodo(E dato, Nodo<E> siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }
}