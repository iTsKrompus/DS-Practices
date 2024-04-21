package arbolNario;

import arbolBusqueda.NodoArbol;

public class ArbolNario {

	private NodoArbolNario raiz;

	public ArbolNario(int dato) {
		raiz = new NodoArbolNario(dato);
	}

	public void insertar(ArbolNario arbol) {
		raiz.getHijos().insertar(arbol.raiz);
	}

	// ------------------------------------------------------------------------
	// TODO 2.2: Mostrar el arbol recorriendo en profundidad de forma RECURSIVA
	public void mostrarProfundidadRecursivo() {
		System.out.print("Profundidad Recursivo: ");
		mostrarProfundidadRecursivoRec(raiz);
		System.out.println();
	}

	private void mostrarProfundidadRecursivoRec(NodoArbolNario nodo) {
		if (nodo != null) {
			System.out.print(nodo.getDato() + " ");
			ListaNodosArbolNario hijos = nodo.getHijos();
			IteradorAdelanteListaNodosArbolNario iterador = hijos.getIteradorAdelante();
			while (iterador.hasNext()) {
				mostrarProfundidadRecursivoRec(iterador.next());
			}
		}
	}

	// ------------------------------------------------------------------------
	// TODO 2.3: Mostrar el arbol recorriendo en profundidad de forma ITERATIVA
	public void mostrarProfundidadIterativo() {
		System.out.print("Profundidad Iterativo: ");
		mostrarProfundidadIterativoIt(raiz);
		System.out.println();
	}

	private void mostrarProfundidadIterativoIt(NodoArbolNario nodo) {
		PilaNodosArbolNario pila = new PilaNodosArbolNario();
		pila.apilar(nodo);
		while (!pila.vacia()) {
			nodo = pila.desapilar();
			System.out.print(nodo.getDato() + " ");
			ListaNodosArbolNario hijos = nodo.getHijos();
			IteradorAtrasListaNodosArbolNario iterador = hijos.getIteradorAtras();
			while (iterador.hasPrevious()) {
				pila.apilar(iterador.previous());
			}
		}
	}

	// ------------------------------------------------------------------------
	// TODO 2.4: Mostrar el arbol recorriendo en amplitud de forma ITERATIVA
	public void mostrarAmplitud() {
		System.out.print("Amplitud: ");
		mostrarAmplitudIt(raiz);
		System.out.println();
	}

	private void mostrarAmplitudIt(NodoArbolNario nodo) {
		ColaNodosArbolNario cola = new ColaNodosArbolNario();
		cola.encolar(nodo);
		while (!cola.vacia()) {
			nodo = cola.desencolar();
			System.out.print(nodo.getDato() + " ");
			ListaNodosArbolNario hijos = nodo.getHijos();
			IteradorAdelanteListaNodosArbolNario iterador = hijos.getIteradorAdelante();
			while (iterador.hasNext()) {
				cola.encolar(iterador.next());
			}
		}
	}
}