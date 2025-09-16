package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FacturaProducto extends JPanel{
	public FacturaProducto(String nombre, float precio, String ruta) {
		this.setPreferredSize(new Dimension(500, 100));
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		this.setLayout(null);
		
		crearLabel("$" + precio,70, 50, 220, 50, Color.BLACK, 25);		
		crearLabel(nombre, 70, 10, 220, 50, Color.BLACK, 35);

		ImageIcon icon = new ImageIcon(ruta);
		Image iconEscalado = icon.getImage().getScaledInstance(50, 80, Image.SCALE_SMOOTH);
		JLabel icono = new JLabel(new ImageIcon(iconEscalado));
		icono.setBounds(10, 10, 50, 80);

		this.add(icono);
	}
	
	private void crearLabel(String texto, int x, int y, int ancho, int alto, Color color, int tamañoTexto) {
		JLabel label = new JLabel(texto);
		label.setBounds(x, y, ancho, alto);
		label.setForeground(color);
		label.setFont(new Font("Arial", Font.BOLD, tamañoTexto));
		this.add(label);
	}
}
