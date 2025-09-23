package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Panel que muestra la factura y los productos a comprar.
 */
public class VentanaFactura extends JPanel {	private JButton volver;	private JPanel panelProductos;	private JScrollPane scroll;	private JButton comprar;	private JPanel derecha;	/**	 * Crea la vista de factura y sus componentes.	 */	public VentanaFactura() {		iniciarComponentes();	}	/**	 * Inicializa y posiciona los componentes del panel de factura.	 */	private void iniciarComponentes() {

		this.setBounds(0, 0, 1280, 720);
		this.setLayout(null);
		this.setBackground(new Color(211, 211, 211, 200));

		panelProductos = new JPanel();
		panelProductos.setLayout(new BoxLayout(panelProductos, BoxLayout.Y_AXIS));
		panelProductos.setBackground(new Color(238, 238, 238));

		scroll = new JScrollPane(panelProductos, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(50, 50, 750, 600);
		scroll.setBorder(null);

		derecha = new JPanel();
		derecha.setBounds(830, 50, 400, 600);
		derecha.setBackground(Color.WHITE);
		derecha.setLayout(null);

		comprar = new JButton();
		comprar.setBounds(70, 120, 260, 50);
		comprar.setFont(new Font("Arial", Font.BOLD, 20));
		comprar.setBackground(new Color(255, 230, 0));
		comprar.setFocusPainted(false);
		comprar.setBorderPainted(false);

		volver = new JButton();
		volver.setBounds(70, 200, 260, 50);
		volver.setFont(new Font("Arial", Font.BOLD, 20));
		volver.setBackground(new Color(52, 131, 250)); 
		volver.setForeground(Color.WHITE);
		volver.setFocusPainted(false);
		volver.setBorderPainted(false);

		derecha.add(comprar);
		derecha.add(volver);
		
		this.add(scroll);
		this.add(derecha);
	}	/**	 * Inicializa los textos de los botones principales.	 */	public void iniciarLabels(String comprarLabel, String volverLabel) {		comprar.setText(comprarLabel);		volver.setText(volverLabel);	}	/**	 * Muestra el total de la factura en la columna derecha.	 */	public void mostrarTotal(String total, String preciototal) {		crearLabel(preciototal + total, 50, 40, 300, 40, new Color(51, 51, 51), 20);		this.revalidate();		this.repaint();	}	/**	 * Desactiva los botones de los productos listados.	 */	public void limpiarBotones() {		for (Component comp : panelProductos.getComponents()) {			for (Component com : ((JPanel) comp).getComponents()) {				if (com instanceof JButton) {					com.setEnabled(false);				}			}		}		scroll.revalidate();		scroll.repaint();	}	/**	 * Elimina las etiquetas dinámicas en la columna derecha.	 */	public void limpiarLabels() {		for (Component comp : derecha.getComponents()) {			if (comp instanceof JLabel) {				derecha.remove(comp);			}		}	}	/**	 * Añade un producto a la factura (visual).	 */	public void mostrarProductos(String nombre, double precio, String ruta, int id, ActionListener e) {		panelProductos.add(new FacturaProducto(nombre, precio, ruta, id, e));	}	/**	 * Elimina todos los productos de la factura.	 */	public void limpiarProductos() {		panelProductos.removeAll();	}	/**	 * Crea y añade una etiqueta en la columna derecha.	 */	private void crearLabel(String texto, int x, int y, int ancho, int alto, Color color, int tamañoTexto) {		JLabel label = new JLabel(texto);		label.setBounds(x, y, ancho, alto);		label.setForeground(color);		label.setFont(new Font("Arial", Font.BOLD, tamañoTexto));		derecha.add(label);	}	/** Devuelve el botón volver. */	public JButton getVolver() { return volver; }	/** Devuelve el panel de productos. */	public JPanel getPanelProductos() { return panelProductos; }	/** Devuelve el scroll. */	public JScrollPane getScroll() { return scroll; }	/** Devuelve el botón comprar. */	public JButton getComprar() { return comprar; }}