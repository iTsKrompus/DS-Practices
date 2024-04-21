
public class Prueba {
    public static void main (String [] args) {
        int numeroContactos = 4;  // TODO Poner el número de contactos de la red
        Persona[] contactos = new Persona[numeroContactos];

        contactos[0] = new Persona("Juan", "111111", "C/ Uno");
        contactos[1] = new Persona("José", "222222", "C/ Dos");
        contactos[2] = new Persona("Eva", "333333", "C/ Tres");
        contactos[3] = new Persona("Alicia", "777777", "C/ Cuatro");
        // TODO Añadir resto de contactos

        AmigosETSISI g = new AmigosETSISI(numeroContactos, contactos);
        g.insertaRelacion(0, 1);
        g.insertaRelacion(0, 3);
        // TODO Añadir resto de relaciones

        g.mostrarRed();
        System.out.println("APARTADO 2.2.1. PRUEBAS DE mostrarGrupos");
        // TODO Realizar prueba de método mostrarGrupos
        System.out.println("----------------------------------------------------");

        System.out.println("\nAPARTADO 2.2.2. PRUEBAS DE amigosIndirectos.");
        // TODO Realizar al menos un par de pruebas del método amigosIndirectos
        System.out.println("----------------------------------------------------");

        System.out.println("\nAPARTADO 2.2.3. PRUEBAS DE noSonAmigos.");
        // TODO Realizar al menos un par de pruebas del método noSonAmigos
        System.out.println("----------------------------------------------------");

        System.out.println("\nAPARTADO 2.2.4. PRUEBAS DE mostrarMiembrosSiAmigos.");
        // TODO Realizar al menos un par de pruebas del método mostrarMiembrosSiAmigos
        System.out.println("----------------------------------------------------");

    }

}
