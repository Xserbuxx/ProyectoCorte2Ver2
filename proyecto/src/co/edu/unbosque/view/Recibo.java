package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class Recibo extends JPanel {

	private JPanel panelProductos;
	private JScrollPane scroll;
	private JButton volver;

	public Recibo() {

		this.setBounds(0, 0, 1280, 720);
		this.setLayout(null);
		this.setBackground(new Color(211, 211, 211, 200));

		JPanel arriba = new JPanel();
		arriba.setBounds(470, 50, 400, 50);
		arriba.setBackground(new Color(255, 230, 0));

		JPanel arriba2 = new JPanel();
		arriba2.setBounds(470, 100, 400, 50);
		arriba2.setBackground(Color.WHITE);

		JPanel abajo = new JPanel();
		abajo.setBounds(470, 490, 400, 50);
		abajo.setBackground(Color.WHITE);

		volver = new JButton(new ImageIcon(
				new ImageIcon("volver.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
		volver.setBounds(395, 50, 50, 50);
		volver.setBorder(new LineBorder(Color.GRAY, 1, true));
		volver.setBackground(Color.WHITE);
		volver.setFocusPainted(false);
		volver.setBorderPainted(false);

		panelProductos = new JPanel();
		panelProductos.setLayout(new BoxLayout(panelProductos, BoxLayout.Y_AXIS));
		panelProductos.setBackground(Color.WHITE);

		scroll = new JScrollPane(panelProductos, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(470, 150, 400, 340);
		scroll.setBorder(null);

		this.add(arriba2);
		this.add(arriba);
		this.add(abajo);
		this.add(scroll);
		this.add(volver);
	}
	
	public void iniciarLabels(String recivocompra, String producto, String precio) {
		crearLabel(recivocompra, 490, 60, 300, 30, Color.BLACK, 20);
		crearLabel(producto, 480, 110, 200, 30, Color.BLACK, 16);
		crearLabel(precio, 720, 110, 200, 30, Color.BLACK, 16);
	}

	public void mostrarTotal(double total, String totalLabel) {

		crearLabel(totalLabel+ total, 480, 490, 300, 50, new Color(51, 51, 51), 20);

		this.revalidate();
		this.repaint();
	}
	
	public void eliminarTotal() {
		if(((JLabel) this.getComponents()[0]).getText().contains("Precio total: $")) {
			this.remove(0);
			
		}
		this.revalidate();
		this.repaint();
	}

	public void eliminarProductos() {
		panelProductos.removeAll();
		scroll.revalidate();
		scroll.repaint();
	}

	public void agregarProducto(String nombre, double precio) {
		JPanel productoPanel = new JPanel();
		productoPanel.setLayout(null);
		productoPanel.setPreferredSize(new Dimension(350,50));
		productoPanel.setBackground(Color.WHITE);
		productoPanel.setBorder(null);

		JLabel nombreLabel = new JLabel(nombre);
		nombreLabel.setBounds(10, 10, 200, 30);
		nombreLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		productoPanel.add(nombreLabel);

		JLabel precioLabel = new JLabel(precio + "");
		precioLabel.setBounds(250, 10, 100, 30);
		precioLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		productoPanel.add(precioLabel);

		panelProductos.add(productoPanel);
		scroll.revalidate();
		scroll.repaint();
	}

	private void crearLabel(String texto, int x, int y, int ancho, int alto, Color color, int tamañoTexto) {
		JLabel label = new JLabel(texto);
		label.setBounds(x, y, ancho, alto);
		label.setForeground(color);
		label.setFont(new Font("Arial", Font.BOLD, tamañoTexto));
		this.add(label);
		this.setComponentZOrder(label, 0);
	}

	public JPanel getPanelProductos() {
		return panelProductos;
	}

	public void setPanelProductos(JPanel panelProductos) {
		this.panelProductos = panelProductos;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

	public JButton getVolver() {
		return volver;
	}

	public void setVolver(JButton volver) {
		this.volver = volver;
	}
	
}
