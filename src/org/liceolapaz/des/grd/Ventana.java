package org.liceolapaz.des.grd;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Ventana extends JFrame {
	JLabel Buscar = new JLabel("Buscar Parejas");
	JLabel Pulse = new JLabel("Pulse en la img para jugar");
	JLabel Nombre = new JLabel("Autor: Gabriel R.Díaz");
	JButton imgInicio = new JButton();
	public Ventana() {
		super("Buscar parejas - Gabriel Rodríguez Díaz");
		setSize(1024, 768);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		botonInicio();
		labels();
	}

	private Tablero juegoSimple() {
		
		Tablero tableroSimple = new Tablero(this,4,3);
		return tableroSimple;
	}

	public void botonInicio() {
		imgInicio.setIcon(new ImageIcon(getClass().getResource("/FTP.jpg")));
		imgInicio.setBorderPainted(false);
		imgInicio.setFocusPainted(false);
		imgInicio.setContentAreaFilled(false);
		imgInicio.setBounds(250, 100, 500, 420);
		imgInicio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Funciona");
				remove(Buscar);
				remove(Pulse);
				remove(Nombre);
				remove(imgInicio);
				setLayout(new BorderLayout());
				add(juegoSimple(), BorderLayout.CENTER);
				revalidate();
			}
		});
	    add(imgInicio);
	}
	
	public void labels() {
//		Buscar
		Buscar.setFont(new Font("Default", 1, 20));
		Buscar.setBounds(410, 50, 300, 50);
		add(Buscar);
//		Pulse
		Pulse.setFont(new Font("Default", 4, 20));
		Pulse.setBounds(370, 520, 300, 50);
		add(Pulse);
//		Nombre
		Nombre.setFont(new Font("Default", 1, 15));
		Nombre.setBounds(410, 590, 300, 50);
		add(Nombre);
	}
}
