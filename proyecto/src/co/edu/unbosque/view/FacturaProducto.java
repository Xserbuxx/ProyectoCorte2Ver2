package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Componente visual que representa un producto dentro de la factura.
 */
public class FacturaProducto extends JPanel {
	/**
	 * Crea el componente de producto para la factura.
	 */
	public FacturaProducto(String nombre, double precio, String ruta, int id, ActionListener e) {
		this.setPreferredSize(new Dimension(500, 100));
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		this.setLayout(null);

		crearLabel("$" + precio, 70, 50, 220, 50, Color.BLACK, 25);
		crearLabel(nombre, 70, 10, 220, 50, Color.BLACK, 35);

		JButton eliminar = new JButton("X");
		eliminar.addActionListener(e);
		eliminar.setActionCommand("EliminarProductoFac-" + id);
		eliminar.setBounds(650, 35, 50, 40);
		eliminar.setFont(new Font("Arial", Font.BOLD, 15));
		eliminar.setBackground(new Color(255, 0, 0));
		eliminar.setForeground(Color.WHITE);
		eliminar.setFocusPainted(false);
		eliminar.setBorderPainted(false);

		ImageIcon icon = new ImageIcon(ruta);
		Image iconEscalado = icon.getImage().getScaledInstance(50, 80, Image.SCALE_SMOOTH);
		JLabel icono = new JLabel(new ImageIcon(iconEscalado));
		icono.setBounds(10, 10, 50, 80);

		this.add(eliminar);
		this.add(icono);
	}

	/**
	 * Crea y añade una etiqueta al componente.
	 */
	private void crearLabel(String texto, int x, int y, int ancho, int alto, Color color, int tamañoTexto) {
		JLabel label = new JLabel(texto);
		label.setBounds(x, y, ancho, alto);
		label.setForeground(color);
		label.setFont(new Font("Arial", Font.BOLD, tamañoTexto));
		this.add(label);
	}
}