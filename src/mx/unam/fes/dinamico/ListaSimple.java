package mx.unam.fes.dinamico;

/**
 * Lista simple que crece de tamaño según se necesite 
 * Sus nodos solo se pueden recorrer hacia adelante
 */
public class ListaSimple<E> {
    private Nodo<E> cabeza;
    private Nodo<E> cola;
    private int longitud = 0; 

    public ListaSimple() {
        cabeza = cola = null;
    }

    /**
     * Revisa si la lista no tiene ningún elemento
     */
    public boolean esVacia() {
        return cabeza == null;
    }

    /**
     * Crea un nuevo nodo y lo coloca al principio de la lista
     */
    public void agregarCabeza(E dato) {
        Nodo<E> nuevo = new Nodo<>(dato, cabeza);
        if (cola == null) { 
            cola = nuevo;
        }
        cabeza = nuevo;
        longitud++; 
    }

    /**
     * Crea un nuevo nodo y lo conecta al final de la lista
     */
    public void agregarCola(E dato) {
        Nodo<E> nuevo = new Nodo<>(dato);
        if (esVacia()) {
            cabeza = cola = nuevo;
        } else {
            cola.siguiente = nuevo; 
            cola = nuevo; 
        }
        longitud++;
    }

    /**
     * Borra el primer nodo de la lista, mueve la cabeza al siguiente nodo y regresa el dato borrado
     */
    public E eliminarDeCabeza() {
        if (esVacia()) return null;
        
        E dato = cabeza.dato;
        if (cabeza == cola) { 
            cabeza = cola = null;
        } else {
            cabeza = cabeza.siguiente; 
        }
        longitud--; 
        return dato;
    }

    /**
     * Borra el último nodo de la lista
     * Tiene que recorrer todos los nodos para encontrar el penúltimo
     */
    public E eliminarDeCola() {
        if (esVacia()) return null;
        
        E dato = cola.dato;
        if (cabeza == cola) {
            cabeza = cola = null;
        } else {
            Nodo<E> tmp = cabeza;
            while (tmp.siguiente != cola) {
                tmp = tmp.siguiente;
            }
            cola = tmp; 
            cola.siguiente = null; 
        }
        longitud--;
        return dato;
    }

    /**
     * Busca el dato que le pasamos y borra el nodo que lo contiene, uniendo la lista para no romperla
     */
    public void borrar(E dato) {
        if (!esVacia()) {
            if (cabeza == cola && dato.equals(cabeza.dato)) {
                cabeza = cola = null;
                longitud--;
            } else if (dato.equals(cabeza.dato)) {
                cabeza = cabeza.siguiente;
                longitud--;
            } else {
                Nodo<E> predesor = cabeza;
                Nodo<E> tmp = cabeza.siguiente;
                
                while (tmp != null && !tmp.dato.equals(dato)) {
                    predesor = predesor.siguiente;
                    tmp = tmp.siguiente;
                }
                
                if (tmp != null) { 
                    predesor.siguiente = tmp.siguiente; 
                    if (tmp == cola) {
                        cola = predesor; 
                    }
                    longitud--;
                }
            }
        }
    }

    /**
     * Borra el nodo que está en el número de posición que le pasamos por parámetro
     */
    public void borrarEnIndice(int indice) {
        if (!esVacia()) {
            if (cabeza == cola && indice == 0) {
                cabeza = cola = null;
                longitud--;
            } else if (indice == 0) {
                cabeza = cabeza.siguiente;
                longitud--;
            } else {
                Nodo<E> predesor = cabeza;
                Nodo<E> tmp = cabeza.siguiente;
                int contador = 1;
                
                while (contador < indice && tmp != null) {
                    predesor = predesor.siguiente;
                    tmp = tmp.siguiente;
                    contador++;
                }
                
                if (tmp != null) {
                    predesor.siguiente = tmp.siguiente;
                    if (tmp == cola) {
                        cola = predesor;
                    }
                    longitud--;
                }
            }
        }
    }

    /**
     * Regresa el número total de nodos que tiene la lista
     */
    public int getLongitud() {
        return longitud;
    }

    /**
     * Imprime en la pantalla todos los datos desde el primero hasta el último
     */
    public void imprimirTodo() {
        Nodo<E> tmp = cabeza;
        while (tmp != null) {
            System.out.println(tmp.dato);
            tmp = tmp.siguiente;
        }
    }
}