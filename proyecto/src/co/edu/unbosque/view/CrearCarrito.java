package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class CrearCarrito extends JPanel{
	
	private JButton volver;
	private JButton crearCarrito;
	private JTextField nombreC;
	
	public CrearCarrito() {
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		this.setBounds(0, 0, 1280, 720);
		this.setLayout(null);
		this.setBackground(new Color(211,211,211,200));
		
		JPanel arriba = new JPanel();
		arriba.setBounds(400,175,500,250);
		arriba.setBackground(Color.WHITE);
		
		volver = new JButton(new ImageIcon(
		        new ImageIcon("volver.png")
		                .getImage()
		                .getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)
		));
		volver.setBounds(325, 175, 50, 50);
		volver.setBorder(new LineBorder(Color.GRAY, 1, true));
		volver.setBackground(Color.WHITE);
		volver.setFocusPainted(false);
		volver.setBorderPainted(false);

		
		crearCarrito = new JButton();
		crearCarrito.setBounds(420, 350, 460, 50);
		crearCarrito.setFont(new Font("Arial", Font.BOLD, 20));
		crearCarrito.setBackground(new Color(255, 230, 0));
		crearCarrito.setFocusPainted(false);
		
		nombreC = new JTextField();
		nombreC.setBounds(420, 270, 460, 50);
		nombreC.setFont(new Font("Arial", Font.BOLD, 22));
		
		this.add(crearCarrito);
		this.add(nombreC);
		this.add(volver);
		this.add(arriba);
	}
	
	public void iniciarLabels(String crearCarrito, String nombre) {
		crearLabel(nombre, 420, 200, 460, 50, Color.black, 20);
		this.crearCarrito.setText(crearCarrito);
	}
	
	private void crearLabel(String texto, int x, int y, int ancho, int alto, Color color, int tamañoTexto) {
		JLabel label = new JLabel(texto);
		label.setBounds(x, y, ancho, alto);
		label.setForeground(color);
		label.setFont(new Font("Arial", Font.BOLD, tamañoTexto));
		this.add(label);
		this.setComponentZOrder(label, 0);
	}

	public JButton getVolver() {
		return volver;
	}

	public void setVolver(JButton volver) {
		this.volver = volver;
	}

	public JButton getCrearCarrito() {
		return crearCarrito;
	}

	public void setCrearCarrito(JButton crearCarrito) {
		this.crearCarrito = crearCarrito;
	}

	public JTextField getNombreC() {
		return nombreC;
	}

	public void setNombreC(JTextField nombreC) {
		this.nombreC = nombreC;
	}
	
}
