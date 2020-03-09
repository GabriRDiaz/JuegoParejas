package org.liceolapaz.des.grd;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import org.liceolapaz.des.grd.Tablero;

public class Boton extends JButton {
	private Tablero tablero;
	private int fila;
	private int columna;
	private int valor;

	public Boton(Tablero tablero, int fila, int columna, int valor) {
		super();
		this.tablero = tablero;
		this.fila = fila;
		this.columna = columna;
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				
			}
		});
}
}
