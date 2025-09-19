package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CarritoPanelVentanaCarritos extends JPanel {

    private JButton selec;
    private JButton eliminar;

    public CarritoPanelVentanaCarritos(String nombre, ActionListener e) {
        this.setPreferredSize(new Dimension(1180, 100));
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        this.setLayout(null);

        selec = new JButton();
        selec.setActionCommand("CarritoCar-" + nombre);
        selec.addActionListener(e);
        selec.setBounds(0, 0, 1180, 100);
        selec.setContentAreaFilled(false);
        selec.setBorderPainted(false);
        selec.setFocusPainted(false);

        eliminar = new JButton("❌");
        eliminar.setActionCommand("EliminarCarrito-" + nombre);
        eliminar.addActionListener(e);
        eliminar.setBounds(1000, 25, 60, 40); 
        eliminar.setBackground(Color.RED);
        eliminar.setForeground(Color.WHITE);
        eliminar.setFocusPainted(false);

        crearLabel(nombre.split("_")[0], 30, 20, 1000, 60, Color.black, 28);

        this.setName(nombre);

        this.add(eliminar);
        this.add(selec);
    }

    private void crearLabel(String texto, int x, int y, int ancho, int alto, Color color, int tamañoTexto) {
        JLabel label = new JLabel(texto);
        label.setBounds(x, y, ancho, alto);
        label.setForeground(color);
        label.setFont(new Font("Arial", Font.BOLD, tamañoTexto));
        this.add(label);
    }

	public JButton getSelec() {
		return selec;
	}

	public void setSelec(JButton selec) {
		this.selec = selec;
	}

	public JButton getEliminar() {
		return eliminar;
	}

	public void setEliminar(JButton eliminar) {
		this.eliminar = eliminar;
	}
    
}
