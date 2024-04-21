package arbolBusqueda;

public class ArbolBinarioBusqueda {

	private NodoArbol raiz;

	public ArbolBinarioBusqueda() {
		raiz = null;
	}

	// Muestra los elementos del arbol binario en orden central ---------------
	public void mostrar() {
		this.mostrar(raiz, "  ");
	}

	private void mostrar(NodoArbol nodo, String espacios) {
		if (nodo != null) {
			this.mostrar(nodo.getIzquierdo(), espacios + "    ");
			System.out.print(espacios);
			nodo.getDato().mostrar();
			this.mostrar(nodo.getDerecho(), espacios + "    ");
		}
	}

	// Inserta un elemento con una cierta clave -------------------------------
	public void insertar(Alumno dato) {
		raiz = this.insertarRec(raiz, dato);
	}

	private NodoArbol insertarRec(NodoArbol nodo, Alumno dato) {
		if (nodo == null) {     // Crear nuevo nodo
			nodo = new NodoArbol(dato);
		} else if (dato.getMatricula() < nodo.getDato().getMatricula()) {    // Subárbol izquierdo
			NodoArbol nuevoIzq = this.insertarRec(nodo.getIzquierdo(), dato);
			nodo.setIzquierdo(nuevoIzq);
		} else if (dato.getMatricula() > nodo.getDato().getMatricula()) {    // Subárbol derecho
			NodoArbol nuevoDer = this.insertarRec(nodo.getDerecho(), dato);
			nodo.setDerecho(nuevoDer);
		} else {      // Clave repetida
			System.out.println("Error. El alumno con matrícula " + dato.getMatricula() + " ya existe");
		}
		return nodo;    // Devolver la nueva raíz del subárbol
	}


	// ------------------------------------------------------------------------
	// TODO 3.2: Devuelve el numero de nodos del arbol de forma RECURSIVA
	public int getNumElementos() {
		return getNumElementosRec(raiz);
	}

	private int getNumElementosRec(NodoArbol nodo) {
		int resultado;
		if (nodo == null) {
			resultado = 0;
		} else {
			resultado = 1;
			resultado += getNumElementosRec(nodo.getIzquierdo()) + getNumElementosRec(nodo.getDerecho());
		}
		return resultado;
	}


	// ------------------------------------------------------------------------
	// TODO 3.3: Devuelve el numero de nodos del arbol con clave
	// menor a una clave dada de forma RECURSIVA
	public int getNumMenores(int clave) {
		return getNumMenoresRec(clave, raiz);
	}

	private int getNumMenoresRec(int clave, NodoArbol nodo) {
		int resultado = 0;
		if (nodo == null) {
			resultado = 0;
		} else if (nodo.getDato().getMatricula() < clave) {
			resultado = 1;
			resultado += getNumMenoresRec(clave, nodo.getDerecho()) + getNumMenoresRec(clave, nodo.getIzquierdo());
		} else {
			resultado += getNumMenoresRec(clave, nodo.getDerecho()) + getNumMenoresRec(clave, nodo.getIzquierdo());
		}
		return resultado;
	}


	// ------------------------------------------------------------------------
	// TODO 3.4: Devuelve el elemento con la menor clave de forma RECURSIVA
	public Alumno getMenorElemento() {
		return getMenorElementoRec(raiz);
	}

	private Alumno getMenorElementoRec(NodoArbol nodo) {
		Alumno menor = nodo.getDato();
		if (nodo != null) {
			if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
				menor = nodo.getDato();
			} else {
				menor = getMenorElementoRec(nodo.getIzquierdo());
			}
		}
		return menor;
	}


	// ------------------------------------------------------------------------
	// TODO 3.5: Devuelve el número de nodos del árbol con clave mayor que
	// claveMinimo y menor que claveMaximo
	public int getNumIntermedios(int claveMinimo, int claveMaximo) {
		return getNumIntermediosRec(raiz, claveMinimo, claveMaximo);
	}

	private int getNumIntermediosRec(NodoArbol nodo, int claveMinimo, int claveMaximo) {
		int resultado = 0;
		if (nodo != null) {
			if (nodo.getDato().getMatricula() > claveMinimo) {
				resultado += getNumIntermediosRec(nodo.getIzquierdo(), claveMinimo, claveMaximo);
			}
			if (nodo.getDato().getMatricula() > claveMinimo && nodo.getDato().getMatricula() < claveMaximo) {
				resultado += 1;
			}
			if (nodo.getDato().getMatricula() < claveMaximo) {
				resultado += getNumIntermediosRec(nodo.getDerecho(), claveMinimo, claveMaximo);
			}
		}
		return resultado;
	}
}