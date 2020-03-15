package org.liceolapaz.des.grd;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import org.liceolapaz.des.grd.*;

public class Dialogo extends JDialog {
		public int filas;
		public int columnas;
		private JTextField jTxtFilas = new JTextField();
		private JTextField jTxtCol = new JTextField();
		public Tablero custom;
	public Dialogo(Frame parent) {
		super(parent, "Nivel de dificultad");
		setVisible(true);
		setSize(400,250);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		this.add(rButtons(), BorderLayout.NORTH);
		this.add(textArea(), BorderLayout.CENTER);
		this.add(okButtons(), BorderLayout.PAGE_END);
		ImageIcon img = new ImageIcon(getClass().getResource("/iconCelta.png"));
		this.setIconImage(img.getImage());
	}

	private JPanel okButtons() {
		JPanel botones = new JPanel();
			botones.setLayout(new FlowLayout());
			JButton okBut = new JButton("Aceptar");
			botones.add(okBut);
			JButton cancelBut = new JButton("Cancelar");
			botones.add(cancelBut);
			cancelBut.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					    Dialogo.this.dispose();
				}
			});
			okBut.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						convertirInt();
					}
					catch (NumberFormatException nfe){ 
						JOptionPane.showMessageDialog(null, "Tienes que meter números, payaso",
							"Error",JOptionPane.ERROR_MESSAGE);
						return;
					}
						if(filas*columnas %2 == 0) {
							Dialogo.this.dispose();
							Principal.ventana.juegoCustom(filas,columnas);
					   } else {
						   JOptionPane.showMessageDialog(null, "Las casillas no son pares, gañán",
							"Error",JOptionPane.ERROR_MESSAGE);
					   }
				}

				private void convertirInt() {
					filas = Integer.parseInt(jTxtFilas.getText());
					columnas = Integer.parseInt(jTxtCol.getText());
				}
			});
		return botones;
	}

	private JPanel textArea() {
		JPanel txtAreas = new JPanel();
		txtAreas.setLayout(null);
		JLabel lbFilas = new JLabel("Filas");
		lbFilas.setBounds(5, 20, 200, 40);
		txtAreas.add(lbFilas);
		jTxtFilas.setBounds(220, 27, 160, 30);
		txtAreas.add(jTxtFilas);
		JLabel lbCol = new JLabel("Columnas");
		lbCol.setBounds(5, 70, 200, 40);
		txtAreas.add(lbCol);
		jTxtCol.setBounds(220, 77, 160, 30);
		txtAreas.add(jTxtCol);
		return txtAreas;
	}


	private JPanel rButtons() {
		JPanel botones = new JPanel();
		botones.setLayout(new FlowLayout());
		JRadioButton easyMode = new JRadioButton("Fácil");
		JRadioButton mediumMode = new JRadioButton("Medio");
		JRadioButton hardMode = new JRadioButton("Difícil");
		JRadioButton customMode = new JRadioButton("Personalizado");
		botones.add(easyMode);
		botones.add(mediumMode);
		botones.add(hardMode);
		botones.add(customMode);
		customMode.setSelected(true);
		easyMode.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				filas = 3;
				columnas = 4;
				jTxtFilas.setEditable(false);
				jTxtFilas.setText(""+filas);
				jTxtCol.setEditable(false);
				jTxtCol.setText(""+columnas);
			}
		});
		
		mediumMode.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				filas = 4;
				columnas = 5;
				jTxtFilas.setEditable(false);
				jTxtFilas.setText(""+filas);
				jTxtCol.setEditable(false);
				jTxtCol.setText(""+columnas);
			}
		});
		hardMode.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				filas = 6;
				columnas = 6;
				jTxtFilas.setEditable(false);
				jTxtFilas.setText(""+filas);
				jTxtCol.setEditable(false);
				jTxtCol.setText(""+columnas);
			}
		});
		customMode.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jTxtFilas.setEditable(true);
				jTxtFilas.setText("");
				jTxtCol.setEditable(true);
				jTxtCol.setText("");
			}
		});
		ButtonGroup bgModes = new ButtonGroup();
		bgModes.add(easyMode);
		bgModes.add(mediumMode);
		bgModes.add(hardMode);
		bgModes.add(customMode);
		return botones;
	}
}
