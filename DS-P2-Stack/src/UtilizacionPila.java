/**
 * Clase UtilizacionPila, para desarrollar los ejercicios propuestos en el
 * apartado 2
 *
 * @author
 * @version
 */
public class UtilizacionPila {

    /**
     * TO-Do 1: Método que recibe un texto y una lista de etiquetas. Comprueba
     * si todas las etiquetas del texto están balanceadas (cada etiqueta de
     * apertura se corresponde con una de cierre)
     *
     * @param lista contiene las etiquetas que queremos analizar.
     * @param texto que contiene el contenido de una página html
     * @return verdadero si las etiquetas están balanceadas, falso en caso contrario
     */
    public boolean comprobarTexto (ListaEtiquetas lista, String texto) {
        boolean pareja = true;
        Pila pila = new Pila();
        String[] etiqueta = texto.split(" ");
        for(int i = 0;i< etiqueta.length && pareja;i++){
            if(lista.esApertura(etiqueta[i])){
                pila.apilar(etiqueta[i]);
            }else if(lista.esCierre(etiqueta[i])){
                if(pila.vacia()){
                    System.out.println("Error, las etiquetas no están balanceadas");
                    pareja = false;
                } else {
                    String aux = pila.desapilar();
                    if(!lista.emparejados(etiqueta[i], aux)){
                        System.out.println("Error, las etiquetas no están balanceadas");
                        pareja = false;
                    }
                }
            }
        }
        if(!pila.vacia()){
            System.out.println("Error, las etiquetas no están balanceadas");
            mostrarInverso(pila);
        }
        return pareja;
    }

    /**
     * Método que muestra el contenido de la pila invertido (el fondo arriba y la cima abajo)
     * @param pila la pila que deseamos mostrar
     */
    public void mostrarInverso(Pila pila) {
        if(pila.vacia()){
        }else{
            String elemento = pila.desapilar();
            mostrarInverso(pila);
            System.out.println(elemento);
            pila.apilar(elemento);

        }
     }
}

