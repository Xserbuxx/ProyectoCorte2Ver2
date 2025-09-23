package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Clase de la capa view que gestiona la interfaz para agregar productos al carrito.
 */
public class AgregarACarrito extends JPanel {
	
	private JButton volver;	
	private JPanel panelProductos;
	private JScrollPane scroll;

	public AgregarACarrito() {
		iniciarComponentes();
	}
	
	/**
	 * Inicializa componentes del panel.
	 */
	private void iniciarComponentes() {
		
		this.setBounds(0, 0, 1280, 720);
		this.setLayout(null);
		this.setBackground(new Color(211,211,211,200));
		
		JPanel arriba = new JPanel();
		arriba.setBounds(420,20,500,50);
		arriba.setBackground(new Color(255, 230, 0)); 
		arriba.setLayout(null);
		
		panelProductos = new JPanel();
		panelProductos.setLayout(new BoxLayout(panelProductos, BoxLayout.Y_AXIS));
		
		volver = new JButton();
		volver.setBounds(50, 25, 250, 50);
		volver.setFont(new Font("Arial", Font.BOLD, 20));
		volver.setBackground(new Color(238,238,238));
		volver.setFocusPainted(false);
		
		scroll = new JScrollPane(panelProductos, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		scroll.setBounds(420, 70, 500, 550);
		scroll.setBorder(null);
		
		this.add(volver);
		this.add(scroll);
		this.add(arriba);
	}
	
	/**
	 * Establece textos de los labels iniciales.
	 */
	public void iniciarLabels(String volver, String seleccionarCarrito) {
		crearLabel(seleccionarCarrito, 450, 30, 300, 30, Color.BLACK, 20);
		this.volver.setText(volver);
	}
	
	/**
	 * Crea y añade un JLabel con los parámetros indicados.
	 */
	private void crearLabel(String texto, int x, int y, int ancho, int alto, Color color, int tamañoTexto) {
		JLabel label = new JLabel(texto);
		label.setBounds(x, y, ancho, alto);
		label.setForeground(color);
		label.setFont(new Font("Arial", Font.BOLD, tamañoTexto));
		this.add(label);
	}
	
	/**
	 * Añade un producto al listado visual.
	 */
	public void mostrarProductos(String nombre, ActionListener e) {
		panelProductos.add(new CarritoPanelAgregarACarrito(nombre, e));
	}
	
	/**
	 * Limpia la lista de productos mostrados.
	 */
	public void limpiarProductos() {
		panelProductos.removeAll();
	}
	
	/**
	 * Devuelve el panel que contiene los productos.
	 */
	public JPanel getPanelProductos() {
		return panelProductos;
	}
	
	/**
	 * Configura el panel de productos.
	 */
	public void setPanelProductos(JPanel panelProductos) {
		this.panelProductos = panelProductos;
	}
	
	/**
	 * Devuelve el JScrollPane que envuelve los productos.
	 */
	public JScrollPane getScroll() {
		return scroll;
	}
	
	/**
	 * Configura el JScrollPane de productos.
	 */
	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}
	
	/**
	 * Devuelve el botón volver.
	 */
	public JButton getVolver() {
		return volver;
	}
	
	/**
	 * Configura el botón volver.
	 */
	public void setVolver(JButton volver) {
		this.volver = volver;
	}
	
}