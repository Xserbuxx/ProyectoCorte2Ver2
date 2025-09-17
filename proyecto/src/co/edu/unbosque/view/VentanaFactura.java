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

public class VentanaFactura extends JPanel {
	private JButton volver;
	private JPanel panelProductos;
	private JScrollPane scroll;
	private JButton comprar;
	private JPanel derecha;

	public VentanaFactura() {
		iniciarComponentes();
	}

	private void iniciarComponentes() {

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
		scroll.getVerticalScrollBar().setUnitIncrement(16);

		derecha = new JPanel();
		derecha.setBounds(830, 50, 400, 600);
		derecha.setBackground(Color.WHITE);
		derecha.setLayout(null);

		comprar = new JButton("Comprar");
		comprar.setBounds(70, 120, 260, 50);
		comprar.setFont(new Font("Arial", Font.BOLD, 20));
		comprar.setBackground(new Color(255, 230, 0));
		comprar.setFocusPainted(false);
		comprar.setBorderPainted(false);

		volver = new JButton("Volver");
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
	}

	public void mostrarTotal(String total) {
		
		crearLabel("Precio total: $" + total, 50, 40, 300, 40, new Color(51, 51, 51), 20);
		
		this.revalidate();
		this.repaint();
	}

	public void limpiarBotones() {
		for (Component comp : panelProductos.getComponents()) {
			for (Component com : ((JPanel) comp).getComponents()) {
				if (com instanceof JButton) {
					com.setEnabled(false);
				}
			}
		}
		scroll.revalidate();
		scroll.repaint();
	}
	
	public void limpiarLabels() {
		for (Component comp : derecha.getComponents()) {
			if (comp instanceof JLabel) {
				derecha.remove(comp);
			}
		}
	}

	public void mostrarProductos(String nombre, double precio, String ruta, int id, ActionListener e) {
		panelProductos.add(new FacturaProducto(nombre, precio, ruta, id, e));
	}

	public void limpiarProductos() {
		panelProductos.removeAll();
	}
	
	private void crearLabel(String texto, int x, int y, int ancho, int alto, Color color, int tamañoTexto) {
		JLabel label = new JLabel(texto);
		label.setBounds(x, y, ancho, alto);
		label.setForeground(color);
		label.setFont(new Font("Arial", Font.BOLD, tamañoTexto));
		derecha.add(label);
	}

	// Getters y setters
	public JButton getVolver() {
		return volver;
	}

	public JPanel getPanelProductos() {
		return panelProductos;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public JButton getComprar() {
		return comprar;
	}
}
