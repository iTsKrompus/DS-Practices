package listaordinal;

public class Factura {
    private String dni;
    private String fecha;
    private ListaOrdinal listaProductos;
    private boolean cobrada;

    public Factura(String dni, String fecha) {
        this.dni = dni;
        this.fecha = fecha;
        listaProductos = new ListaOrdinal();
        cobrada = false;
    }

    public String getDNI() {
        return dni;
    }

    public String getFecha() {
        return fecha;
    }

    public boolean estaCobrada() {
        return cobrada;
    }

    public void cobrada() {
        cobrada = true;
    }

    public void añadirProducto(Producto producto) {
        // Completar
         Iterador interador = listaProductos.getIterador();
         boolean encontrado = false;
         while (interador.hasNext()){
             Producto actual=interador.next();
             if(actual.equals(producto)){
                 int unidades = actual.getUnidades();
                 actual.setUnidades(++unidades);
                 encontrado = true;
             }
         }
         if(!encontrado){
             listaProductos.insertar(producto);
         }
    }

    public void mostrar() {
        // Completar
        if(listaProductos.vacia()){
            System.out.println("Lista vacia");
        } else {
            System.out.println("FACTURA DE: "+ getDNI() + " "+  getFecha());
            Iterador iterador = listaProductos.getIterador();
            while(iterador.hasNext()){
                Producto actual = iterador.next();
                actual.mostrar();
            }
        }
        System.out.println("IMPORTE TOTAL: "+ importeTotal());
    }

    public float importeTotal() {
        // Completar
        Iterador iterador = listaProductos.getIterador();
        float total = 0.0f;
        if(listaProductos.vacia()){
            System.out.println("Lista vacia");
        } else {
            while(iterador.hasNext()){
                Producto actual = iterador.next();
                total+= actual.getUnidades()* actual.getPrecio();
            }
        }
        return total;
    }

    public int eliminarProducto(Producto producto) {
        // Completar
        Iterador iterador = listaProductos.getIterador();
        int eliminados = 0;
        if(listaProductos.vacia()){
            System.out.println("Lista vacia");
        }else {
            while (iterador.hasNext()){
                Producto actual = iterador.next();
                if(actual.equals(producto)){
                    if(producto.getUnidades()<actual.getUnidades()){
                        actual.setUnidades(actual.getUnidades() - producto.getUnidades());
                        eliminados = producto.getUnidades();
                    } else {
                        listaProductos.borrar(actual);
                        eliminados = actual.getUnidades();
                    }
                }
            }
        }
        return eliminados; // Línea puesta para evitar error. Eliminarla al codificar el método
    }

    public ListaOrdinal mayoresPrecios(float precio) {
        // Completar
        ListaOrdinal lista = new ListaOrdinal();
        Iterador iterador= listaProductos.getIterador();
        if (listaProductos.vacia()){
            System.out.println("Lista vacia");
        } else {
            while(iterador.hasNext()){
                Producto actual = iterador.next();
                if(precio< actual.getPrecio()){
                    lista.insertar(actual);
                }
            }
        }
        return lista; // Línea puesta para evitar error. Eliminarla al codificar el método
    }
}
