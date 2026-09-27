package mx.unam.fes.dinamico;

/**
 * Estructura tipo Cola FIFO 
 * El primer elemento que se guarda es el primero que se saca
 */
public class Cola<E> {
    private Nodo<E> cabeza;
    private Nodo<E> cola;
    private int tamanio = 0;

    public Cola() {
        cabeza = cola = null;
    }

    public boolean esVacia() {
        return cabeza == null;
    }

    /**
     * Agrega un nuevo nodo al final de la estructura
     */
    public void encolar(E dato) {
        Nodo<E> nuevo = new Nodo<>(dato);
        if (esVacia()) {
            cabeza = cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            cola = nuevo;
        }
        tamanio++;
    }

    /**
     * Saca y regresa el nodo que está al principio de la estructura
     */
    public E desencolar() {
        if (esVacia()) return null;
        
        E dato = cabeza.dato;
        if (cabeza == cola) {
            cabeza = cola = null;
        } else {
            cabeza = cabeza.siguiente;
        }
        tamanio--;
        return dato;
    }

    public int getTamanio() {
        return tamanio;
    }

    /**
     * Imprime todos los datos en el orden en que entraron
     */
    public void imprimir() {
        Nodo<E> tmp = cabeza;
        while (tmp != null) {
            System.out.println(tmp.dato);
            tmp = tmp.siguiente;
        }
    }
}