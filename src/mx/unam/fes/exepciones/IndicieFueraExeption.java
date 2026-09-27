package mx.unam.fes.exepciones;

/**
 * Excepción que se lanza cuando intentamos usar una posición que no existe dentro del arreglo
 */
public class IndicieFueraExeption extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * Constructor que recibe el texto del error que vamos a mostrar
     */
    public IndicieFueraExeption(String msg) {
        super(msg);
    }
}