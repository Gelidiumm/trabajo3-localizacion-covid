package com.practica.ems.covid;


import java.util.Iterator;
import java.util.LinkedList;

import com.practica.excecption.EmsDuplicatePersonException;
import com.practica.excecption.EmsPersonNotFoundException;
import com.practica.genericas.FechaHora;
import com.practica.genericas.Persona;

public class Poblacion {
	LinkedList<Persona> lista ;

	public Poblacion() {
		super();
		this.lista = new LinkedList<Persona>();
	}
	
	public LinkedList<Persona> getLista() {
		return lista;
	}

	public void setLista(LinkedList<Persona> lista) {
		this.lista = lista;
	}

	public void addPersona (Persona persona) throws EmsDuplicatePersonException {
		if (lista.contains(persona)) {
			throw new EmsDuplicatePersonException();
		}
		lista.add(persona);
	}
	
	public void delPersona(String documento) throws EmsPersonNotFoundException {		
		Persona p = new Persona(documento);
		if(!lista.remove(p)) {
			throw new EmsPersonNotFoundException();
		}
	}
	
	public int findPersona (String documento) throws EmsPersonNotFoundException {
		Persona p = new Persona(documento);
		int pos = lista.indexOf(p);
		
		if (pos == -1) {
			throw new EmsPersonNotFoundException();
		}

		return pos + 1;
	}
	
	public void printPoblacion() {   
	    System.out.printf(toString());
	}

	@Override
	public String toString() {
		String cadena = "";
		
		for(Persona p: lista) {
			cadena += p.toString();
			cadena += "\n";
		}

		//remove last \n
		cadena = cadena.substring(0, cadena.length() - 1);

		return cadena;
	}
	
	
	
}
