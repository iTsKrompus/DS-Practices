package listaordinal;

public class PruebasLista {
    public static void main(String[] args) {
        // Introducir aquí las pruebas pedidas en la práctica
        System.out.println("-----------------PRODUCTOS EN LA LISTA-----------------");
        Producto producto1 = new Producto("Mesa escritorio", 185.0F, 2);
        Producto producto2 = new Producto("Silla oficina", 95.9F, 3);
        Producto producto3 = new Producto("Mesa cocina", 125.0F, 1);
        Producto producto4 = new Producto("Sillon reclinable", 230.0F, 2);
        ListaOrdinal prodcs = new ListaOrdinal();
        prodcs.insertar(producto1);
        prodcs.insertar(producto2);
        prodcs.insertar(producto3);
        prodcs.insertar(producto4);
        prodcs.mostrar();
        System.out.println("Despues de borrar las sillas de oficina");
        prodcs.borrar(producto2);
        prodcs.mostrar(); // Hasta aquí la primera prueba que nos piden (Sustituir int por producto)


        Factura factura = new Factura("12345678B", "17/03/2021"); //Aquí empieza la implementación del 3.1 y 3.2
        factura.añadirProducto(producto1);
        factura.añadirProducto(producto2);
        factura.añadirProducto(producto3);
        factura.añadirProducto(producto4);
        Producto silla = new Producto("Silla oficina", 95.9F, 1);
        factura.añadirProducto(silla);
        factura.mostrar(); //Aquí acaba la implementación del 3.1 y 3.2


        Producto silla2 = new Producto("Silla oficina", 95.9F, 2); //Empieza la implementación del 3.4
        Producto sillon2 = new Producto("Sillon reclinable", 230.0F, 3);
        int eliminados = factura.eliminarProducto(silla2);
        eliminados += factura.eliminarProducto(sillon2);
        System.out.println("Se han eliminado " + eliminados);
        factura.mostrar(); //Aqui acaba la implementacion del 3.3 y 3.4


        float precio = 100.0F; //Aquí empieza la implementación del 3.5
        ListaOrdinal mayoresprecios = new ListaOrdinal() ;
        mayoresprecios = factura.mayoresPrecios(precio);
        Iterador iterador = mayoresprecios.getIterador();
        int nProducts = 0;
        if(mayoresprecios.vacia()){
            System.out.println("Lista vacia");
        } else {
            while (iterador.hasNext()){
                Producto actual = iterador.next();
                nProducts+= actual.getUnidades();
            }
        }
        System.out.println("Se han obtenido "+ nProducts + " con un precio mayor a "+ precio + " E la unidad");
        mayoresprecios.mostrar(); //Aquí finaliza la implementación del 3.5
    }
}

