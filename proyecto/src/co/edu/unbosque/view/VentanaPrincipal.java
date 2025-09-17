package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VentanaPrincipal extends JFrame{
	
	private ManejarPanel mp;
	
	public VentanaPrincipal() {
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		
		mp = new ManejarPanel();
		this.add(mp);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1280, 720);
		this.setResizable(false);
		this.setTitle("Mercado Libre - Copia");
		
		this.setVisible(true);
		
	}
	
	public void actualizar() {
		this.revalidate();
		this.repaint();
	}
	
	public void mostrarError(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "", JOptionPane.INFORMATION_MESSAGE);
	}

	public ManejarPanel getMp() {
		return mp;
	}

	public void setMp(ManejarPanel mp) {
		this.mp = mp;
	}
	
}
