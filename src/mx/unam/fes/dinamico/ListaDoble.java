package mx.unam.fes.dinamico;

/**
 * Lista doble dinámica y genérica
 * Permite recorrer y modificar los datos hacia adelante y hacia atrás
 */
public class ListaDoble<E> {
    private NodoDoble<E> cabeza;
    private NodoDoble<E> cola;
    private int longitud = 0;

    public ListaDoble() {
        cabeza = cola = null;
    }

    public boolean esVacia() {
        return cabeza == null;
    }

    /**
     * Inserta un nuevo dato al inicio de la lista y ajusta los enlaces del nuevo nodo y de la cabeza anterior 
     *
     */
    public void agregarCabeza(E dato) {
        NodoDoble<E> nuevo = new NodoDoble<>(dato);
        if (esVacia()) {
            cabeza = cola = nuevo;
        } else {
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo; 
            cabeza = nuevo;
        }
        longitud++;
    }

    /**
     * Inserta un nuevo dato al final de la lista, uniendo el nuevo nodo con la cola actual
     */
    public void agregarCola(E dato) {
        NodoDoble<E> nuevo = new NodoDoble<>(dato);
        if (esVacia()) {
            cabeza = cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola; 
            cola = nuevo;
        }
        longitud++;
    }

    /**
     * Borra el primer nodo de la lista y hace que el segundo pase a ser la nueva cabeza
     */
    public E eliminarDeCabeza() {
        if (esVacia()) return null;
        
        E dato = cabeza.dato;
        if (cabeza == cola) {
            cabeza = cola = null;
        } else {
            cabeza = cabeza.siguiente;
            cabeza.anterior = null; 
        }
        longitud--;
        return dato;
    }

    /**
     * Borra el último nodo de la lista usando el enlace anterior para no tener que recorrer toda la estructura
     * 
     */
    public E eliminarDeCola() {
        if (esVacia()) return null;
        
        E dato = cola.dato;
        if (cabeza == cola) {
            cabeza = cola = null;
        } else {
            cola = cola.anterior; 
            cola.siguiente = null; 
        }
        longitud--;
        return dato;
    }

    /**
     * Busca el dato que le pasamos y lo borra uniendo el nodo anterior con el siguiente
     */
    public void borrar(E dato) {
        if (!esVacia()) {
            if (cabeza == cola && dato.equals(cabeza.dato)) {
                cabeza = cola = null;
                longitud--;
            } else if (dato.equals(cabeza.dato)) {
                eliminarDeCabeza(); 
            } else if (dato.equals(cola.dato)) {
                eliminarDeCola(); 
            } else {
                NodoDoble<E> tmp = cabeza.siguiente;
                while (tmp != null && !tmp.dato.equals(dato)) {
                    tmp = tmp.siguiente;
                }
                if (tmp != null) {
                    tmp.anterior.siguiente = tmp.siguiente;
                    tmp.siguiente.anterior = tmp.anterior;
                    longitud--;
                }
            }
        }
    }

    public int getLongitud() {
        return longitud;
    }

    /**
     * Imprime en la consola todos los datos empezando por la cabeza hasta terminar con la cola
     */
    public void imprimirTodo() {
        NodoDoble<E> tmp = cabeza;
        while (tmp != null) {
            System.out.println(tmp.dato);
            tmp = tmp.siguiente;
        }
    }
}