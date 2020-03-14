package org.liceolapaz.des.grd;

import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class Dialogo extends JDialog {
		
	public Dialogo(Frame parent) {
		super(parent, "Nivel de dificultad");
		setVisible(true);
		setSize(100,100);
		setLocationRelativeTo(null);
	}
		
}
