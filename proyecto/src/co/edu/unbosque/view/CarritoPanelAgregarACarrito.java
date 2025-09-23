package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel utilizado en la vista para mostrar un producto y permitir agregarlo al carrito.
 */
public class CarritoPanelAgregarACarrito extends JPanel {

	private JButton selec;

	/**
	 * Constructor que crea el panel con el nombre del producto y el listener.
	 */
	public CarritoPanelAgregarACarrito(String nombre, ActionListener e) {
		this.setPreferredSize(new Dimension(483, 100));
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		this.setLayout(null);

		selec = new JButton();
		selec.setActionCommand("CarritoACA-" + nombre);
		selec.addActionListener(e);
		selec.setBounds(0, 0, 483, 100);
		selec.setContentAreaFilled(false);
		selec.setBorderPainted(false);
		selec.setFocusPainted(false);

		crearLabel(nombre.split("_")[0], 50, 0, 453, 100, Color.black, 24);

		this.setName(nombre);

		this.add(selec);
	}

	/**
	 * Crea y añade una etiqueta al panel.
	 */
	private void crearLabel(String texto, int x, int y, int ancho, int alto, Color color, int tamañoTexto) {
		JLabel label = new JLabel(texto);
		label.setBounds(x, y, ancho, alto);
		label.setForeground(color);
		label.setFont(new Font("Arial", Font.BOLD, tamañoTexto));
		this.add(label);
	}

}