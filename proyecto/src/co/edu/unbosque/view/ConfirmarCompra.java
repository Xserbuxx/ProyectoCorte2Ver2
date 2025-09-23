package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ConfirmarCompra extends JPanel {

	private JButton volver;
	private JButton comprar;
	private JLabel precioLabel;

	/**
	 * Crea el panel de confirmación de compra.
	 */
	public ConfirmarCompra() {
		this.setBounds(0, 0, 1280, 720);
		this.setLayout(null);
		this.setBackground(new Color(211, 211, 211, 200));

		JPanel arriba = new JPanel();
		arriba.setBounds(400, 225, 500, 200);
		arriba.setBackground(Color.WHITE);

		volver = new JButton(new ImageIcon(
				new ImageIcon("volver.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
		volver.setBounds(325, 225, 50, 50);
		volver.setBorder(new LineBorder(Color.GRAY, 1, true));
		volver.setBackground(Color.WHITE);
		volver.setFocusPainted(false);
		volver.setBorderPainted(false);

		comprar = new JButton();
		comprar.setBounds(420, 350, 460, 50);
		comprar.setFont(new Font("Arial", Font.BOLD, 20));
		comprar.setBackground(new Color(255, 230, 0));
		comprar.setFocusPainted(false);

		this.add(comprar);
		this.add(volver);
		this.add(arriba);
	}

	/**
	 * Inicializa el texto del botón comprar.
	 */
	public void iniciarLabels(String comprarCarrito) {
		this.comprar.setText(comprarCarrito);
	}

	/**
	 * Muestra el título y el precio a pagar.
	 */
	public void mostrarTitulo(double precio ,String  mensaje) {
		if (precioLabel != null) {
			this.remove(precioLabel);

		}

		crearLabel(mensaje, 435, 260, 460, 50, Color.black, 22);

		precioLabel = new JLabel("$" + precio);
		precioLabel.setBounds(610, 290, 200, 50);
		precioLabel.setForeground(Color.black);
		precioLabel.setFont(new Font("Arial", Font.BOLD, 22));

		this.add(precioLabel);
		this.setComponentZOrder(precioLabel, 0);
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
		this.setComponentZOrder(label, 0);
	}

	/**
	 * Establece el botón volver.
	 */
	public void setVolver(JButton volver) {
		this.volver = volver;
	}

	/**
	 * Establece el botón comprar.
	 */
	public void setComprar(JButton comprar) {
		this.comprar = comprar;
	}

	/**
	 * Devuelve el botón volver.
	 */
	public JButton getVolver() {
		return volver;
	}

	/**
	 * Devuelve el botón comprar.
	 */
	public JButton getComprar() {
		return comprar;
	}

}