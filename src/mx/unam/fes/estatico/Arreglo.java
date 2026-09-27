package mx.unam.fes.estatico;

import mx.unam.fes.exepciones.IndicieFueraExeption;

/**
 * Estructura de datos estática 
 * Mantiene un tamaño fijo definido desde que se crea
 */
public class Arreglo<E> {
    private int indice;
    private final Object[] arreglo;

    /**
     * Constructor que define la capacidad máxima de elementos
     */
    public Arreglo(int longitud) {
        arreglo = new Object[longitud];
        indice = 0; 
    }

    /**
     * Inserta un nuevo elemento en la siguiente posición disponible
     * Lanza una excepción si se supera el tamaño máximo del arreglo
     */
    public void insertar(E elemento) throws IndicieFueraExeption {
        if (indice < arreglo.length) {
            arreglo[indice] = elemento;
            indice++;
        } else {
            throw new IndicieFueraExeption("Indice fuera del arreglo");
        }
    }

    /**
     * Verifica si se ha alcanzado la capacidad máxima del arreglo
     * Devuelve true si está lleno o false si aún hay espacio
     */
    public boolean vacio() {
        if (indice < arreglo.length) {
            return false;
        }
        return true;
    }

    /**
     * Imprime todos los elementos almacenados separados por comas
     */
    public void imprimir() {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + ",");
        }
        System.out.println();
    }
}