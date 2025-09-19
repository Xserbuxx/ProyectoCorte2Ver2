package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class VentanaCompra extends JPanel {

	private JComboBox<String> categorias;
	private JScrollPane scroll;
	private JPanel panelProductos;
	private JButton cambiarModo;
	private JButton cerrarSesion;
	private JButton carritos;
	private JPanel mercadoLibre;

	public VentanaCompra() {
		iniciarComponente();
	}

	private void iniciarComponente() {
		this.setBounds(0, 0, 1280, 720);
		this.setLayout(null);

		mercadoLibre = new JPanel();
		mercadoLibre.setBounds(0, 0, 1280, 80);
		mercadoLibre.setBackground(new Color(255, 230, 0));
		mercadoLibre.setLayout(null);

		JLabel logo = new JLabel(new ImageIcon(
				new ImageIcon("logoMercadoLibre.png").getImage().getScaledInstance(130, 60, Image.SCALE_SMOOTH)));
		logo.setBounds(20, 10, 130, 60);
		mercadoLibre.add(logo);

		categorias = new JComboBox<>();
		categorias.setBounds(320, 25, 200, 30);
		categorias.setBackground(Color.WHITE);
		categorias.setFont(new Font("Arial", Font.PLAIN, 14));
		mercadoLibre.add(categorias);

		cambiarModo = new JButton();
		cambiarModo.setBounds(960, 25, 120, 35);
		cambiarModo.setFont(new Font("Arial", Font.BOLD, 14));
		cambiarModo.setBackground(new Color(52, 131, 250));
		cambiarModo.setForeground(Color.WHITE);
		cambiarModo.setFocusPainted(false);
		cambiarModo.setBorderPainted(false);
		mercadoLibre.add(cambiarModo);

		carritos = new JButton(new ImageIcon(
				new ImageIcon("carrito-de-compras.png").getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH)));
		carritos.setBounds(1120, 22, 36, 36);
		carritos.setBackground(new Color(255, 230, 0));
		carritos.setBorderPainted(false);
		carritos.setFocusPainted(false);
		mercadoLibre.add(carritos);

		cerrarSesion = new JButton(new ImageIcon(
				new ImageIcon("cerrar-sesion.png").getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH)));
		cerrarSesion.setBounds(1180, 22, 36, 36);
		cerrarSesion.setBackground(new Color(255, 230, 0));
		cerrarSesion.setBorderPainted(false);
		cerrarSesion.setFocusPainted(false);
		mercadoLibre.add(cerrarSesion);

		panelProductos = new JPanel();
		panelProductos.setLayout(new GridLayout(0, 4, 10, 10));

		scroll = new JScrollPane(panelProductos, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		scroll.setBounds(0, 90, 1265, 600);

		this.add(scroll);
		this.add(mercadoLibre);
	}

	public void mostrarProductos(String nombre, double precio, String ruta, int id, ActionListener e) {
		panelProductos.add(new CompraProducto(nombre, precio, ruta, id, e));
	}

	public void limpiarProductos() {
		panelProductos.removeAll();
	}

	public void mostrarLabels(String categoria, String todo, String belleza, String deportes, String hogar,
			String juguetes, String libros, String mascotas, String musica, String ropa, String tecnologia,
			String vehiculos, String vendedor) {
		crearLabel(categoria, 180, 20, 300, 40, Color.BLACK, 20);
		categorias.removeAll();
		categorias.addItem(todo);
		categorias.addItem(belleza);
		categorias.addItem(deportes);
		categorias.addItem(hogar);
		categorias.addItem(juguetes);
		categorias.addItem(libros);
		categorias.addItem(mascotas);
		categorias.addItem(musica);
		categorias.addItem(ropa);
		categorias.addItem(tecnologia);
		categorias.addItem(vehiculos);

		cambiarModo.setText(vendedor);

		categorias.revalidate();
		categorias.repaint();

	}

	private void crearLabel(String texto, int x, int y, int ancho, int alto, Color color, int tamañoTexto) {
		JLabel label = new JLabel(texto);
		label.setBounds(x, y, ancho, alto);
		label.setForeground(color);
		label.setFont(new Font("Arial", Font.BOLD, tamañoTexto));
		mercadoLibre.add(label);
	}

	public JComboBox<String> getCategorias() {
		return categorias;
	}

	public void setCategorias(JComboBox<String> categorias) {
		this.categorias = categorias;
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

	public JButton getCambiarModo() {
		return cambiarModo;
	}

	public void setCambiarModo(JButton cambiarModo) {
		this.cambiarModo = cambiarModo;
	}

	public JButton getCerrarSesion() {
		return cerrarSesion;
	}

	public void setCerrarSesion(JButton cerrarSesion) {
		this.cerrarSesion = cerrarSesion;
	}

	public JButton getCarritos() {
		return carritos;
	}

	public void setCarritos(JButton carritos) {
		this.carritos = carritos;
	}

}
