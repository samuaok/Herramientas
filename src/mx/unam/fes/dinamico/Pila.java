package mx.unam.fes.dinamico;

/**
 * Estructura tipo Pila LIFO 
 * El último elemento que se guarda es el primero que se saca
 */
public class Pila<E> {
    private Nodo<E> cima; 
    private int tamanio = 0;

    public Pila() {
        cima = null;
    }

    public boolean esVacia() {
        return cima == null;
    }

    /**
     * Agrega un nuevo nodo en la parte de arriba de la estructura
     */
    public void apilar(E dato) {
        Nodo<E> nuevo = new Nodo<>(dato, cima);
        cima = nuevo;
        tamanio++;
    }

    /**
     * Saca y regresa el nodo que está en la parte superior de la estructura
     */
    public E desapilar() {
        if (esVacia()) return null;
        
        E dato = cima.dato;
        cima = cima.siguiente; 
        tamanio--;
        return dato;
    }

    public int getTamanio() {
        return tamanio;
    }

    /**
     * Imprime todos los datos empezando por el último que entró
     */
    public void imprimir() {
        Nodo<E> tmp = cima;
        while (tmp != null) {
            System.out.println(tmp.dato);
            tmp = tmp.siguiente;
        }
    }
}