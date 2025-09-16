package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ConfirmarEliminar extends JPanel{
	
	private JButton volver;
	private JButton eliminar;
	
	public ConfirmarEliminar() {
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		this.setBounds(0, 0, 1280, 720);
		this.setLayout(null);
		this.setBackground(new Color(211,211,211,200));
		
		JPanel arriba = new JPanel();
		arriba.setBounds(400,225,500,200);
		arriba.setBackground(Color.WHITE);
		
		crearLabel("¿Está seguro de eliminar el carrito?", 425, 260, 460, 50, Color.black, 26);
		
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
		
		eliminar = new JButton("Eliminar Carrito");
		eliminar.setBounds(420, 350, 460, 50);
		eliminar.setFont(new Font("Arial", Font.BOLD, 20));
		eliminar.setBackground(new Color(255, 230, 0));
		eliminar.setFocusPainted(false);
		
		this.add(eliminar);
		this.add(volver);
		this.add(arriba);
	}
	
	private void crearLabel(String texto, int x, int y, int ancho, int alto, Color color, int tamañoTexto) {
		JLabel label = new JLabel(texto);
		label.setBounds(x, y, ancho, alto);
		label.setForeground(color);
		label.setFont(new Font("Arial", Font.BOLD, tamañoTexto));
		this.add(label);
	}

	public JButton getVolver() {
		return volver;
	}

	public void setVolver(JButton volver) {
		this.volver = volver;
	}

	public JButton getEliminar() {
		return eliminar;
	}

	public void setEliminar(JButton eliminar) {
		this.eliminar = eliminar;
	}
	
}
