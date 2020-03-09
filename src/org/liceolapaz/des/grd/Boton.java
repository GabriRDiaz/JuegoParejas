package org.liceolapaz.des.grd;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.liceolapaz.des.grd.Tablero;

import com.liceolapaz.des.jprf.Boton;

public class Boton extends JButton {
	private Tablero tablero;
	private int fila;
	private int columna;
	private int valor;
	private boolean pulsado;
	public Boton(Tablero tablero, int fila, int columna, int valor) {
		super();
		this.tablero = tablero;
		this.fila = fila;
		this.columna = columna;
		this.valor = valor;
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				pulsar();
			}	
		});	
}
	private void pulsar() {
		this.pulsado = true;
		setBackground(Color.CYAN);
		setText(""+getValor());
		this.Tablero.pulsarComprobar(this);
	}
	public int getValor() {
		return this.valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
}
