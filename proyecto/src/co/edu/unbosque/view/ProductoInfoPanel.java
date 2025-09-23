package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel que muestra la información detallada de un producto y permite agregarlo al carrito.
 */
public class ProductoInfoPanel extends JPanel {

	private JButton volver;
	private JButton agregarCarrito;
	private JPanel cajaFondoProducto;

	/**
	 * Crea el panel y configura los componentes iniciales.
	 */
	public ProductoInfoPanel() {
		iniciarComponente();
	}

	/**
	 * Inicializa los componentes visuales del panel.
	 */
	private void iniciarComponente() {
		this.setBounds(0, 0, 1280, 720);
		this.setLayout(null);
		this.setBackground(new Color(245, 245, 245));

		JPanel mercadoLibre = new JPanel();
		mercadoLibre.setBounds(0, 0, 1280, 80);
		mercadoLibre.setBackground(new Color(255, 230, 0));
		mercadoLibre.setLayout(null);

		JLabel logo = new JLabel(new ImageIcon(
				new ImageIcon("logoMercadoLibre.png").getImage().getScaledInstance(140, 70, Image.SCALE_SMOOTH)));
		logo.setBounds(20, 10, 140, 70);
		mercadoLibre.add(logo);

		cajaFondoProducto = new JPanel();
		cajaFondoProducto.setBounds(75, 100, 1130, 500);
		cajaFondoProducto.setBackground(Color.WHITE);
		cajaFondoProducto.setLayout(null);
		cajaFondoProducto.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));

		volver = new JButton();
		volver.setBounds(600, 400, 150, 40);
		volver.setFont(new Font("Arial", Font.BOLD, 18));
		volver.setBackground(new Color(238, 238, 238));
		volver.setFocusPainted(false);

		agregarCarrito = new JButton();
		agregarCarrito.setBounds(790, 400, 250, 40);
		agregarCarrito.setFont(new Font("Arial", Font.BOLD, 18));
		agregarCarrito.setBackground(new Color(255, 230, 0));
		agregarCarrito.setFocusPainted(false);

		cajaFondoProducto.add(volver);
		cajaFondoProducto.add(agregarCarrito);

		this.add(cajaFondoProducto);
		this.add(mercadoLibre);
	}

	/**
	 * Muestra los detalles del producto en el panel.
	 */
	public void mostrarProductoInfo(double precio, String nombre, String descripcion, int unidades, String url,
			String atributo1, String atributo2, String informacion, String unidadesLabel) {
		cajaFondoProducto.removeAll();

		ImageIcon icon = new ImageIcon(url);
		Image iconEscalado = icon.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		JLabel icono = new JLabel(new ImageIcon(iconEscalado));
		icono.setBounds(30, 50, 400, 400);
		cajaFondoProducto.add(icono);

		crearLabel(informacion, 460, 50, 400, 30, Color.BLACK, 22);
		crearLabel(nombre, 460, 100, 600, 40, Color.BLACK, 26);
		crearLabel(descripcion, 460, 150, 600, 40, Color.BLACK, 16);
		crearLabel("$" + precio, 460, 200, 600, 40, Color.BLACK, 22);
		crearLabel(unidadesLabel + unidades, 460, 250, 600, 30, Color.BLACK, 16);
		crearLabel(atributo1, 460, 290, 600, 30, Color.BLACK, 16);
		crearLabel(atributo2, 460, 330, 600, 30, Color.BLACK, 16);

		cajaFondoProducto.add(volver);
		cajaFondoProducto.add(agregarCarrito);

		cajaFondoProducto.revalidate();
		cajaFondoProducto.repaint();
	}

	/**
	 * Establece los textos de los botones.
	 */
	public void iniciarLabels(String volver, String agregarCarrito) {
		this.volver.setText(volver);
		this.agregarCarrito.setText(agregarCarrito);

	}

	/**
	 * Crea y añade una etiqueta al contenedor del producto.
	 */
	private void crearLabel(String texto, int x, int y, int ancho, int alto, Color color, int tamañoTexto) {
		JLabel label = new JLabel(texto);
		label.setBounds(x, y, ancho, alto);
		label.setForeground(color);
		label.setFont(new Font("Arial", Font.BOLD, tamañoTexto));
		cajaFondoProducto.add(label);
	}

	/**
	 * Limpia las etiquetas del panel de producto.
	 */
	public void limpiarLabels() {
		cajaFondoProducto.removeAll();
		cajaFondoProducto.revalidate();
		cajaFondoProducto.repaint();
	}

	/** Devuelve el botón volver. */
	public JButton getVolver() {
		return volver;
	}

	/** Devuelve el botón agregarCarrito. */
	public JButton getAgregarCarrito() {
		return agregarCarrito;
	}
}