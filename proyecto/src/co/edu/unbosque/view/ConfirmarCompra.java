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

	public ConfirmarCompra() {
		this.setBounds(0, 0, 1280, 720);
		this.setLayout(null);
		this.setBackground(new Color(211, 211, 211, 200));

		JPanel arriba = new JPanel();
		arriba.setBounds(400, 225, 500, 200);
		arriba.setBackground(Color.WHITE);

		volver = new JButton(new ImageIcon(
		        new ImageIcon("volver.png")
		                .getImage()
		                .getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)
		));
		volver.setBounds(340, 170, 50, 50);
		volver.setBorder(new LineBorder(Color.GRAY, 1, true));
		volver.setBackground(Color.WHITE);
		volver.setFocusPainted(false);
		volver.setBorderPainted(false);

		comprar = new JButton("Comprar Carrito");
		comprar.setBounds(420, 350, 460, 50);
		comprar.setFont(new Font("Arial", Font.BOLD, 20));
		comprar.setBackground(new Color(255, 230, 0));
		comprar.setFocusPainted(false);

		this.add(comprar);
		this.add(volver);
		this.add(arriba);
	}

	public void mostrarTitulo(float precio) {
		if(precioLabel != null) {
			this.remove(precioLabel);
			
		}
		
		crearLabel("Estas a punto de realizar una compra por:", 435, 260, 460, 50, Color.black, 22);

		precioLabel = new JLabel("$" + precio);
		precioLabel.setBounds(610, 290, 200, 50);
		precioLabel.setForeground(Color.black);
		precioLabel.setFont(new Font("Arial", Font.BOLD, 22));

		this.add(precioLabel);
		this.setComponentZOrder(precioLabel, 0);
	}
	
	private void crearLabel(String texto, int x, int y, int ancho, int alto, Color color, int tamañoTexto) {
		JLabel label = new JLabel(texto);
		label.setBounds(x, y, ancho, alto);
		label.setForeground(color);
		label.setFont(new Font("Arial", Font.BOLD, tamañoTexto));
		this.add(label);
	}

	public void setVolver(JButton volver) {
		this.volver = volver;
	}

	public void setComprar(JButton comprar) {
		this.comprar = comprar;
	}

	public JButton getVolver() {
		return volver;
	}

	public JButton getComprar() {
		return comprar;
	}
	
}
