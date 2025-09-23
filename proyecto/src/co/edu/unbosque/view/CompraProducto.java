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
 * Componente visual que representa un producto para la pantalla de compra.
 */
public class CompraProducto extends JPanel {

	private JButton info;

	/**
	 * Crea el componente visual con la información del producto.
	 */
	public CompraProducto(String nombre, double precio, String rutaFoto, int id, ActionListener e) {

		this.setPreferredSize(new Dimension(250, 370));
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
		this.setLayout(null);

		ImageIcon icon = new ImageIcon(rutaFoto);
		Image iconEscalado = icon.getImage().getScaledInstance(260, 220, Image.SCALE_SMOOTH);
		JLabel icono = new JLabel(new ImageIcon(iconEscalado));
		icono.setBounds(20, 10, 250, 230);

		crearLabel(nombre, 10, 250, 230, 40, Color.BLACK, 18);
		crearLabel("$" + precio, 10, 300, 230, 40, Color.BLACK, 22);

		info = new JButton();
		info.setActionCommand("Producto_" + id);
		info.addActionListener(e);
		info.setBounds(0, 0, 250, 350);
		info.setContentAreaFilled(false);
		info.setBorderPainted(false);
		info.setFocusPainted(false);

		this.add(icono);
		this.add(info);
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

	/**
	 * Devuelve el botón de información del producto.
	 */
	public JButton getInfo() {
		return info;
	}

	/**
	 * Configura el botón de información del producto.
	 */
	public void setInfo(JButton info) {
		this.info = info;
	}
}