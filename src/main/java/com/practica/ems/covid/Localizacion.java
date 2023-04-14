package com.practica.ems.covid;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.practica.excecption.EmsDuplicateLocationException;
import com.practica.excecption.EmsLocalizationNotFoundException;
import com.practica.excecption.EmsPersonNotFoundException;
import com.practica.genericas.FechaHora;
import com.practica.genericas.PosicionPersona;

public class Localizacion {
	LinkedList<PosicionPersona> lista;

	public Localizacion() {
		super();
		this.lista = new LinkedList<PosicionPersona>();
	};
	
	public LinkedList<PosicionPersona> getLista() {
		return lista;
	}

	public void setLista(LinkedList<PosicionPersona> lista) {
		this.lista = lista;
	}

	public void addLocalizacion (PosicionPersona p) throws EmsDuplicateLocationException {
		try {
			findLocalizacion(p.getDocumento(), p.getFechaPosicion().getFecha().toString(),p.getFechaPosicion().getHora().toString() );
			throw new EmsDuplicateLocationException();
		}catch(EmsLocalizationNotFoundException e) {
			lista.add(p);
		}
	}
	
	public int findLocalizacion (String documento, String fecha, String hora) throws EmsLocalizationNotFoundException {
	    int cont = 0;
	    Iterator<PosicionPersona> it = lista.iterator();
	    while(it.hasNext()) {
	    	cont++;
	    	PosicionPersona pp = it.next();
	    	FechaHora fechaHora = FechaHora.parseFecha(fecha, hora);
	    	if(pp.getDocumento().equals(documento) && 
	    	   pp.getFechaPosicion().equals(fechaHora)) {
	    		return cont;
	    	}
	    } 
	    throw new EmsLocalizationNotFoundException();
	}

	public List<PosicionPersona> localizacionPersona(String documento) throws EmsPersonNotFoundException {
		int cont = 0;
		List<PosicionPersona> lista = new ArrayList<PosicionPersona>();
		Iterator<PosicionPersona> it = lista.iterator();
		while (it.hasNext()) {
			PosicionPersona pp = it.next();
			if (pp.getDocumento().equals(documento)) {
				cont++;
				lista.add(pp);
			}
		}
		
		if (cont == 0) {
			throw new EmsPersonNotFoundException();
		}
		
		return lista;
	}

	public void delLocalizacion(String documento, String fecha, String hora) throws EmsLocalizationNotFoundException {
	    int pos=-1;
	    /**
	     *  Busca la localización, sino existe lanza una excepción
	     */
	    try {
			pos = findLocalizacion(documento, fecha, hora);
		} catch (EmsLocalizationNotFoundException e) {
			throw new EmsLocalizationNotFoundException();
		}
	    this.lista.remove(pos);
	    
	}
	
	void printLocalizacion() {  
		System.out.printf(toString()); 
	}

	@Override
	public String toString() {
		String cadena = "";
		for (PosicionPersona pp: lista) {
			cadena += pp.toString();
			cadena += "\n";
		}
		//remove last \n
		cadena = cadena.substring(0, cadena.length()-1);
		return cadena;
	}
	
}
