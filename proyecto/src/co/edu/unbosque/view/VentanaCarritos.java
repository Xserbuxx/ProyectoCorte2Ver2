package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class VentanaCarritos extends JPanel {

	private JButton volver;
	private JButton crearCarrito;
	private JScrollPane scroll;
	private JPanel panelProductos;
	private JTextField filtro;
	private JButton filtrar;
	private JPanel mercadoLibre;

	public VentanaCarritos() {
		iniciarComponente();
	}

	private void iniciarComponente() {
		this.setBounds(0, 0, 1280, 720);
		this.setLayout(null);
		this.setBackground(new Color(245, 245, 245));

		mercadoLibre = new JPanel();
		mercadoLibre.setBounds(0, 0, 1280, 80);
		mercadoLibre.setBackground(new Color(255, 230, 0));
		mercadoLibre.setLayout(null);

		JLabel logo = new JLabel(new ImageIcon(
				new ImageIcon("logoMercadoLibre.png").getImage().getScaledInstance(130, 60, Image.SCALE_SMOOTH)));
		logo.setBounds(20, 10, 130, 60);
		mercadoLibre.add(logo);

		filtro = new JTextField();
		filtro.setBounds(650, 18, 380, 40);
		filtro.setFont(new Font("Arial", Font.BOLD, 22));
		mercadoLibre.add(filtro);

		filtrar = new JButton();
		filtrar.setBounds(1050, 18, 100, 40);
		filtrar.setFont(new Font("Arial", Font.BOLD, 14));
		filtrar.setBackground(new Color(52, 131, 250));
		filtrar.setForeground(Color.WHITE);
		filtrar.setFocusPainted(false);
		mercadoLibre.add(filtrar);

		panelProductos = new JPanel();
		panelProductos.setLayout(new BoxLayout(panelProductos, BoxLayout.Y_AXIS));
		panelProductos.setBackground(Color.WHITE);

		scroll = new JScrollPane(panelProductos, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(50, 100, 1180, 460);

		JPanel abajo = new JPanel();
		abajo.setBounds(0, 600, 1280, 100);
		abajo.setBackground(new Color(245, 245, 245));
		abajo.setLayout(null);

		volver = new JButton();
		volver.setBounds(410, 0, 200, 50);
		volver.setFont(new Font("Arial", Font.BOLD, 18));
		volver.setBackground(Color.WHITE);
		volver.setFocusPainted(false);
		abajo.add(volver);

		crearCarrito = new JButton("",new ImageIcon(
				new ImageIcon("carrito-de-compras.png").getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH)));
		crearCarrito.setBounds(650, 0, 250, 50);
		crearCarrito.setFont(new Font("Arial", Font.BOLD, 18));
		crearCarrito.setBackground(new Color(255, 230, 0));
		crearCarrito.setFocusPainted(false);
		abajo.add(crearCarrito);

		this.add(mercadoLibre);
		this.add(scroll);
		this.add(abajo);
	}

	public void mostrarProductos(String nombre, ActionListener e) {
		panelProductos.add(new CarritoPanelVentanaCarritos(nombre, e));
	}

	public void eliminarCarritos() {
		panelProductos.removeAll();
		scroll.revalidate();
		scroll.repaint();
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

	public void iniciarLabels(String carritos, String volverLabel, String crearCarritoLabel, String filtrarLabel) {
		crearLabel(carritos, 180, 20, 300, 40, Color.BLACK, 28);
		
		volver.setText(volverLabel);
		crearCarrito.setText(crearCarritoLabel);
		filtrar.setText(filtrarLabel);
	}

	private void crearLabel(String texto, int x, int y, int ancho, int alto, Color color, int tamañoTexto) {
		JLabel label = new JLabel(texto);
		label.setBounds(x, y, ancho, alto);
		label.setForeground(color);
		label.setFont(new Font("Arial", Font.BOLD, tamañoTexto));
		mercadoLibre.add(label);
	}

	public JButton getVolver() {
		return volver;
	}

	public void setVolver(JButton volver) {
		this.volver = volver;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

	public JPanel getPanelProductos() {
		return panelProductos;
	}

	public void setPanelProductos(JPanel panelProductos) {
		this.panelProductos = panelProductos;
	}

	public JButton getCrearCarrito() {
		return crearCarrito;
	}

	public void setCrearCarrito(JButton crearCarrito) {
		this.crearCarrito = crearCarrito;
	}

	public JTextField getFiltro() {
		return filtro;
	}

	public void setFiltro(JTextField filtro) {
		this.filtro = filtro;
	}

	public JButton getFiltrar() {
		return filtrar;
	}

	public void setFiltrar(JButton filtrar) {
		this.filtrar = filtrar;
	}
}
