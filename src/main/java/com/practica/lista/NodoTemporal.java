package com.practica.lista;

import java.util.LinkedList;

import com.practica.genericas.FechaHora;


/**
 * Nodo para guardar un instante de tiempo. Además guardamos una lista con las coordeandas
 * y las personas (solo número) que en ese instante están en una coordeanda en concreto  
 *
 */
public class NodoTemporal implements Comparable<NodoTemporal> {
	
	private LinkedList<NodoPosicion> listaCoordenadas;
	private FechaHora fecha;

	public static NodoTemporal fromFecha(FechaHora fecha) {
		return new NodoTemporal(fecha);
	}
	
	public NodoTemporal() {
		super();
		listaCoordenadas = new LinkedList<NodoPosicion>();	
	}

	public NodoTemporal(FechaHora fecha) {
		super();
		listaCoordenadas = new LinkedList<NodoPosicion>();
		this.fecha = fecha;	
	}
	
	public void addCoordenada(Coordenada coordenada) {
		NodePosicion np = NodePosicion.fromCoordenada(coordenada);
	}

	@Override
	public int compareTo(NodoTemporal arg0) {
		return this.getFecha().compareTo(arg0.getFecha());
	}
	
	
}
