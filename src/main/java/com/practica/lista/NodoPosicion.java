package com.practica.lista;

import com.practica.genericas.Coordenada;
import com.practica.genericas.PosicionPersona;

/**
 * Nodo para la lista de coordenadas. En el guardamos cuántas personas  están
 * en una coordenada  en un momento temporal. 
 * También guardaremos la lista de personas que están en esa coordenada en un 
 * momento en concreto
 */
public class NodoPosicion {

	private Coordenada coordenada;	
	private int numPersonas;

	public static NodoPosicion fromCoordenada(Coordenada coordenada) {
		return new NodoPosicion(coordenada, 1);
	}
	
	public NodoPosicion() {
		super();
	}
	
	public NodoPosicion(Coordenada coordenada,  int numPersonas) {
		super();
		this.coordenada = coordenada;		
		this.numPersonas = numPersonas;
	}

	public void combine(NodoPosicion other) {
		this.numPersonas += other.numPersonas;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (getClass() != obj.getClass()) {
			return false;
		}
		
		NodoPosicion other = (NodoPosicion) obj;
		return this.coordenada.equals(other.coordenada);
	}

	@Override
	public int hashCode() {
		return this.coordenada.hashCode();
	}
	
}
