package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class VentanaVenta extends JPanel {

	private JComboBox<String> categorias;

	private JButton cambiarModo;
	private JButton cerrarSesion;
	private JTextField precio;
	private JTextField nombre;
	private JTextField descripcion;
	private JTextField unidades;
	private JTextField rutaFoto;
	private JButton btnExaminar;
	private JTextField id;
	private JButton registrarProducto;
	private JPanel mercadoLibre;

	// belleza
	private JTextField tipoProductoBe;
	private JTextField fechaExpiracion;
	// deportes
	private JTextField tipoDeporte;
	private JTextField marcaDe;
	// hogar
	private JTextField materialHo;
	private JTextField tipoProductoHo;
	// juguetes
	private JTextField edadRecomendada;
	private JTextField materialJu;
	// libros
	private JTextField autor;
	private JTextField isbn;
	// mascotas
	private JTextField tipoAnimal;
	private JTextField tamano;
	// musica
	private JTextField formato;
	private JTextField artista;
	// Ropa
	private JTextField talla;
	private JTextField color;
	// tecnologia
	private JTextField marcaTec;
	private JTextField modeloTec;
	// vehiculo
	private JTextField ano;
	private JTextField modeloVE;

	public VentanaVenta() {
		iniciarComponente();
	}

	/**
	 * Inicializa los componentes de la ventana de venta.
	 */
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

		cambiarModo = new JButton();
		cambiarModo.setBounds(1030, 25, 120, 35);
		cambiarModo.setFont(new Font("Arial", Font.BOLD, 14));
		cambiarModo.setBackground(new Color(52, 131, 250));
		cambiarModo.setForeground(Color.WHITE);
		cambiarModo.setFocusPainted(false);
		cambiarModo.setBorderPainted(false);
		mercadoLibre.add(cambiarModo);

		cerrarSesion = new JButton(new ImageIcon(
				new ImageIcon("cerrar-sesion.png").getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH)));
		cerrarSesion.setBounds(1180, 22, 36, 36);
		cerrarSesion.setBackground(new Color(255, 230, 0));
		cerrarSesion.setBorderPainted(false);
		cerrarSesion.setFocusPainted(false);
		mercadoLibre.add(cerrarSesion);

		registrarProducto = new JButton();
		registrarProducto.setBounds(480, 550, 290, 40);
		registrarProducto.setFont(new Font("Arial", Font.BOLD, 16));
		registrarProducto.setBackground(new Color(255, 230, 0));
		registrarProducto.setFocusPainted(false);

		mostrarCampos();

		this.add(registrarProducto);
		this.add(cerrarSesion);
		this.add(cambiarModo);
		this.add(categorias);
		this.add(mercadoLibre);
	}

	/**
	 * Crea y muestra los campos básicos del formulario de venta.
	 */
	public void mostrarCampos() {
		precio = new JTextField();
		precio.setBounds(120, 150, 430, 50);
		precio.setFont(new Font("Arial", Font.BOLD, 22));

		nombre = new JTextField();
		nombre.setBounds(120, 250, 430, 50);
		nombre.setFont(new Font("Arial", Font.BOLD, 22));

		descripcion = new JTextField();
		descripcion.setBounds(120, 350, 430, 50);
		descripcion.setFont(new Font("Arial", Font.BOLD, 22));

		unidades = new JTextField();
		unidades.setBounds(120, 450, 430, 50);
		unidades.setFont(new Font("Arial", Font.BOLD, 22));

		rutaFoto = new JTextField();
		rutaFoto.setBounds(700, 150, 330, 50);
		rutaFoto.setFont(new Font("Arial", Font.BOLD, 22));
		rutaFoto.setEditable(false);

		btnExaminar = new JButton();
		btnExaminar.setBounds(1040, 150, 90, 50);
		

		id = new JTextField();
		id.setBounds(700, 250, 430, 50);
		id.setFont(new Font("Arial", Font.BOLD, 22));

		this.add(precio);
		this.add(nombre);
		this.add(descripcion);
		this.add(unidades);
		this.add(rutaFoto);
		this.add(id);

	}

	/**
	 * Muestra los campos específicos para la categoría Belleza.
	 */
	public void mostrarBelleza(String tipoProducto, String fecha) {

		mostrarCampos();
		tipoProductoBe = new JTextField();
		fechaExpiracion = new JTextField();

		tipoProductoBe.setBounds(700, 350, 430, 50);
		tipoProductoBe.setFont(new Font("Arial", Font.BOLD, 22));

		fechaExpiracion.setBounds(700, 450, 430, 50);
		fechaExpiracion.setFont(new Font("Arial", Font.BOLD, 22));

		crearLabel(tipoProducto, 700, 275, 430, 100, Color.BLACK, 20);
		crearLabel(fecha, 700, 375, 430, 100, Color.BLACK, 20);

		this.add(tipoProductoBe);
		this.add(fechaExpiracion);

		categorias.revalidate();
		categorias.repaint();

	}

	/**
	 * Muestra los campos específicos para la categoría Deportes.
	 */
	public void mostrarDeportes(String tipodeporte, String marca) {

		mostrarCampos();
		tipoDeporte = new JTextField();
		marcaDe = new JTextField();

		tipoDeporte.setBounds(700, 350, 430, 50);
		tipoDeporte.setFont(new Font("Arial", Font.BOLD, 22));

		marcaDe.setBounds(700, 450, 430, 50);
		marcaDe.setFont(new Font("Arial", Font.BOLD, 22));

		crearLabel(tipodeporte, 700, 275, 430, 100, Color.BLACK, 20);
		crearLabel(marca, 700, 375, 430, 100, Color.BLACK, 20);

		this.add(tipoDeporte);
		this.add(marcaDe);

		categorias.revalidate();
		categorias.repaint();
	}

	/**
	 * Muestra los campos específicos para la categoría Hogar.
	 */
	public void mostrarHogar(String tipomaterial, String tipoproducto) {

		mostrarCampos();
		materialHo = new JTextField();
		tipoProductoHo = new JTextField();

		materialHo.setBounds(700, 350, 430, 50);
		materialHo.setFont(new Font("Arial", Font.BOLD, 22));

		tipoProductoHo.setBounds(700, 450, 430, 50);
		tipoProductoHo.setFont(new Font("Arial", Font.BOLD, 22));

		crearLabel(tipomaterial, 700, 275, 430, 100, Color.BLACK, 20);
		crearLabel(tipoproducto, 700, 375, 430, 100, Color.BLACK, 20);

		this.add(materialHo);
		this.add(tipoProductoHo);

		categorias.revalidate();
		categorias.repaint();
	}

	/**
	 * Muestra los campos específicos para la categoría Juguetes.
	 */
	public void mostrarJuguetes(String edadrecomendada, String material) {

		mostrarCampos();
		edadRecomendada = new JTextField();
		materialJu = new JTextField();

		edadRecomendada.setBounds(700, 350, 430, 50);
		edadRecomendada.setFont(new Font("Arial", Font.BOLD, 22));

		materialJu.setBounds(700, 450, 430, 50);
		materialJu.setFont(new Font("Arial", Font.BOLD, 22));

		crearLabel(edadrecomendada, 700, 275, 430, 100, Color.BLACK, 20);
		crearLabel(material, 700, 375, 430, 100, Color.BLACK, 20);

		this.add(edadRecomendada);
		this.add(materialJu);

		categorias.revalidate();
		categorias.repaint();
	}

	/**
	 * Muestra los campos específicos para la categoría Libros.
	 */
	public void mostrarLibros(String autorLabel, String isbnLabel) {

		mostrarCampos();
		autor = new JTextField();
		isbn = new JTextField();

		autor.setBounds(700, 350, 430, 50);
		autor.setFont(new Font("Arial", Font.BOLD, 22));

		isbn.setBounds(700, 450, 430, 50);
		isbn.setFont(new Font("Arial", Font.BOLD, 22));

		crearLabel(autorLabel, 700, 275, 430, 100, Color.BLACK, 20);
		crearLabel(isbnLabel, 700, 375, 430, 100, Color.BLACK, 20);

		this.add(autor);
		this.add(isbn);

		categorias.revalidate();
		categorias.repaint();
	}

	/**
	 * Muestra los campos específicos para la categoría Mascotas.
	 */
	public void mostrarMascotas(String tipoanimal, String tamanoLabel) {

		mostrarCampos();
		tipoAnimal = new JTextField();
		tamano = new JTextField();

		tipoAnimal.setBounds(700, 350, 430, 50);
		tipoAnimal.setFont(new Font("Arial", Font.BOLD, 22));

		tamano.setBounds(700, 450, 430, 50);
		tamano.setFont(new Font("Arial", Font.BOLD, 22));

		crearLabel(tipoanimal, 700, 275, 430, 100, Color.BLACK, 20);
		crearLabel(tamanoLabel, 700, 375, 430, 100, Color.BLACK, 20);

		this.add(tipoAnimal);
		this.add(tamano);

		categorias.revalidate();
		categorias.repaint();
	}

	/**
	 * Muestra los campos específicos para la categoría Música.
	 */
	public void mostrarMusica(String artistaLabel, String formatoLabel) {
		mostrarCampos();
		formato = new JTextField();
		artista = new JTextField();

		formato.setBounds(700, 350, 430, 50);
		formato.setFont(new Font("Arial", Font.BOLD, 22));

		artista.setBounds(700, 450, 430, 50);
		artista.setFont(new Font("Arial", Font.BOLD, 22));

		crearLabel(artistaLabel, 700, 275, 430, 100, Color.BLACK, 20);
		crearLabel(formatoLabel, 700, 375, 430, 100, Color.BLACK, 20);

		this.add(formato);
		this.add(artista);

		categorias.revalidate();
		categorias.repaint();
	}

	/**
	 * Muestra los campos específicos para la categoría Ropa.
	 */
	public void mostrarRopa(String tallaLabel, String colorLabel) {
		mostrarCampos();
		talla = new JTextField();
		color = new JTextField();

		talla.setBounds(700, 350, 430, 50);
		talla.setFont(new Font("Arial", Font.BOLD, 22));

		color.setBounds(700, 450, 430, 50);
		color.setFont(new Font("Arial", Font.BOLD, 22));

		crearLabel(tallaLabel, 700, 275, 430, 100, Color.BLACK, 20);
		crearLabel(colorLabel, 700, 375, 430, 100, Color.BLACK, 20);

		this.add(talla);
		this.add(color);

		categorias.revalidate();
		categorias.repaint();
	}

	/**
	 * Muestra los campos específicos para la categoría Tecnología.
	 */
	public void mostrarTecnologia(String marca, String modelo) {
		mostrarCampos();
		marcaTec = new JTextField();
		modeloTec = new JTextField();

		marcaTec.setBounds(700, 350, 430, 50);
		marcaTec.setFont(new Font("Arial", Font.BOLD, 22));

		modeloTec.setBounds(700, 450, 430, 50);
		modeloTec.setFont(new Font("Arial", Font.BOLD, 22));

		crearLabel(marca, 700, 275, 430, 100, Color.BLACK, 20);
		crearLabel(modelo, 700, 375, 430, 100, Color.BLACK, 20);

		this.add(marcaTec);
		this.add(modeloTec);

		categorias.revalidate();
		categorias.repaint();
	}

	/**
	 * Muestra los campos específicos para la categoría Vehículos.
	 */
	public void mostrarVehiculos(String anoLabel, String modelo) {
		mostrarCampos();
		ano = new JTextField();
		modeloVE = new JTextField();

		ano.setBounds(700, 350, 430, 50);
		ano.setFont(new Font("Arial", Font.BOLD, 22));

		modeloVE.setBounds(700, 450, 430, 50);
		modeloVE.setFont(new Font("Arial", Font.BOLD, 22));

		crearLabel(anoLabel, 700, 275, 430, 100, Color.BLACK, 20);
		crearLabel(modelo, 700, 375, 430, 100, Color.BLACK, 20);

		this.add(ano);
		this.add(modeloVE);

		categorias.revalidate();
		categorias.repaint();
	}

	/**
	 * Limpia las etiquetas dinámicas que no coincidan con los textos pasados.
	 */
	public void limpiarLabels(String categoria, String precio, String nombre, String descripcion, String unidades,
			String rutaFoto, String id, String comprador, String registrarproducto, String examinar) {
		for (Component comp : this.getComponents()) {
			if (comp instanceof JLabel && !((JLabel) comp).getText().equals(categoria)
					&& !((JLabel) comp).getText().equals(precio) && !((JLabel) comp).getText().equals(nombre)
					&& !((JLabel) comp).getText().equals(descripcion) && !((JLabel) comp).getText().equals(unidades)
					&& !((JLabel) comp).getText().equals(rutaFoto) && !((JLabel) comp).getText().equals(id)) {
				this.remove(comp);
			}
		}
		this.revalidate();
		this.repaint();

	}

	/**
	 * Elimina los campos de texto dinámicos del panel.
	 */
	public void limpiarCampos() {
		for (Component comp : this.getComponents()) {
			if (comp instanceof JTextField) {
				this.remove(comp);
			}
		}
	}

	/**
	 * Inicializa los textos y acciones de las etiquetas y botones principales.
	 */
	public void iniciarLabels(String precio, String nombre, String descripcion, String unidades, String rutaFoto,
			String id, String categoria, String todo, String belleza, String deportes, String hogar, String juguetes,
			String libros, String mascotas, String musica, String ropa, String tecnologia, String vehiculos,
			String comprador, String registrarproducto, String examinar) {
		crearLabel(precio, 120, 75, 100, 100, Color.BLACK, 20);
		crearLabel(nombre, 120, 175, 100, 100, Color.BLACK, 20);
		crearLabel(descripcion, 120, 275, 200, 100, Color.BLACK, 20);
		crearLabel(unidades, 120, 375, 100, 100, Color.BLACK, 20);
		crearLabel(rutaFoto, 700, 75, 300, 100, Color.BLACK, 20);
		crearLabel(id, 700, 175, 100, 100, Color.BLACK, 20);
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

		cambiarModo.setText(comprador);
		registrarProducto.setText(registrarproducto);
		btnExaminar.setText(examinar);

		btnExaminar.addActionListener(e -> {
			JFileChooser fc = new JFileChooser();
			fc.setFileFilter(new FileNameExtensionFilter("Files (jpg,jpeg,png)", "jpg", "jpeg", "png"));

			if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				this.rutaFoto.setText(fc.getSelectedFile().getAbsolutePath());
			}
		});
		
		this.add(btnExaminar);
		
		categorias.revalidate();
		categorias.repaint();
		
		this.revalidate();
		this.repaint();
	}

	/**
	 * Crea y añade un JLabel al panel con el texto especificado.
	 */
	private void crearLabel(String texto, int x, int y, int ancho, int alto, Color color, int tamañoTexto) {
		JLabel label = new JLabel(texto);
		label.setBounds(x, y, ancho, alto);
		label.setForeground(color);
		label.setFont(new Font("Arial", Font.BOLD, tamañoTexto));
		this.add(label);
		this.setComponentZOrder(label, 0);
	}

	/** Devuelve el botón para cambiar modo. */
	public JButton getCambiarModo() {
		return cambiarModo;
	}

	/** Configura el botón de cambiar modo. */
	public void setCambiarModo(JButton cambiarModo) {
		this.cambiarModo = cambiarModo;
	}

	/** Devuelve el botón de cerrar sesión. */
	public JButton getCerrarSesion() {
		return cerrarSesion;
	}

	/** Configura el botón de cerrar sesión. */
	public void setCerrarSesion(JButton cerrarSesion) {
		this.cerrarSesion = cerrarSesion;
	}

	/** Devuelve el botón de registrar producto. */
	public JButton getRegistrarProducto() {
		return registrarProducto;
	}

	/** Configura el botón de registrar producto. */
	public void setRegistrarProducto(JButton registrarProducto) {
		this.registrarProducto = registrarProducto;
	}

	/** Devuelve el combo de categorías. */
	public JComboBox<String> getCategorias() {
		return categorias;
	}

	/** Configura el combo de categorías. */
	public void setCategorias(JComboBox<String> categorias) {
		this.categorias = categorias;
	}

	/** Devuelve el campo precio. */
	public JTextField getPrecio() {
		return precio;
	}

	/** Configura el campo precio. */
	public void setPrecio(JTextField precio) {
		this.precio = precio;
	}

	/** Devuelve el campo nombre. */
	public JTextField getNombre() {
		return nombre;
	}

	/** Configura el campo nombre. */
	public void setNombre(JTextField nombre) {
		this.nombre = nombre;
	}

	/** Devuelve la descripción. */
	public JTextField getDescripcion() {
		return descripcion;
	}

	/** Configura la descripción. */
	public void setDescripcion(JTextField descripcion) {
		this.descripcion = descripcion;
	}

	/** Devuelve el campo unidades. */
	public JTextField getUnidades() {
		return unidades;
	}

	/** Configura el campo unidades. */
	public void setUnidades(JTextField unidades) {
		this.unidades = unidades;
	}

	/** Devuelve el campo ruta foto. */
	public JTextField getRutaFoto() {
		return rutaFoto;
	}

	/** Configura el campo ruta foto. */
	public void setRutaFoto(JTextField rutaFoto) {
		this.rutaFoto = rutaFoto;
	}

	/** Devuelve el campo id. */
	public JTextField getId() {
		return id;
	}

	/** Configura el campo id. */
	public void setId(JTextField id) {
		this.id = id;
	}

	/** Devuelve el campo tipoProductoBe. */
	public JTextField getTipoProductoBe() {
		return tipoProductoBe;
	}

	/** Configura el campo tipoProductoBe. */
	public void setTipoProductoBe(JTextField tipoProductoBe) {
		this.tipoProductoBe = tipoProductoBe;
	}

	/** Devuelve el campo fechaExpiracion. */
	public JTextField getFechaExpiracion() {
		return fechaExpiracion;
	}

	/** Configura el campo fechaExpiracion. */
	public void setFechaExpiracion(JTextField fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	/** Devuelve el campo tipoDeporte. */
	public JTextField getTipoDeporte() {
		return tipoDeporte;
	}

	/** Configura el campo tipoDeporte. */
	public void setTipoDeporte(JTextField tipoDeporte) {
		this.tipoDeporte = tipoDeporte;
	}

	/** Devuelve la marcaDe. */
	public JTextField getMarcaDe() {
		return marcaDe;
	}

	/** Configura marcaDe. */
	public void setMaterialDe(JTextField marcaDe) {
		this.marcaDe = marcaDe;
	}

	/** Devuelve materialHo. */
	public JTextField getMaterialHo() {
		return materialHo;
	}

	/** Configura materialHo. */
	public void setMaterialHo(JTextField tipoMaterialHo) {
		this.materialHo = tipoMaterialHo;
	}

	/** Devuelve tipoProductoHo. */
	public JTextField getTipoProductoHo() {
		return tipoProductoHo;
	}

	/** Configura tipoProductoHo. */
	public void setTipoProductoHo(JTextField tipoProductoHo) {
		this.tipoProductoHo = tipoProductoHo;
	}

	/** Devuelve edadRecomendada. */
	public JTextField getEdadRecomendada() {
		return edadRecomendada;
	}

	/** Configura edadRecomendada. */
	public void setEdadRecomendada(JTextField edadRecomendada) {
		this.edadRecomendada = edadRecomendada;
	}

	/** Devuelve materialJu. */
	public JTextField getMaterialJu() {
		return materialJu;
	}

	/** Configura materialJu. */
	public void setMaterialJu(JTextField materialJu) {
		this.materialJu = materialJu;
	}

	/** Devuelve autor. */
	public JTextField getAutor() {
		return autor;
	}

	/** Configura autor. */
	public void setAutor(JTextField autor) {
		this.autor = autor;
	}

	/** Devuelve isbn. */
	public JTextField getIsbn() {
		return isbn;
	}

	/** Configura isbn. */
	public void setIsbn(JTextField isbn) {
		this.isbn = isbn;
	}

	/** Devuelve tipoAnimal. */
	public JTextField getTipoAnimal() {
		return tipoAnimal;
	}

	/** Configura tipoAnimal. */
	public void setTipoAnimal(JTextField tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

	/** Devuelve tamano. */
	public JTextField getTamano() {
		return tamano;
	}

	/** Configura tamano. */
	public void setTamano(JTextField tamano) {
		this.tamano = tamano;
	}

	/** Devuelve formato. */
	public JTextField getFormato() {
		return formato;
	}

	/** Configura formato. */
	public void setFormato(JTextField formato) {
		this.formato = formato;
	}

	/** Devuelve artista. */
	public JTextField getArtista() {
		return artista;
	}

	/** Configura artista. */
	public void setArtista(JTextField artista) {
		this.artista = artista;
	}

	/** Devuelve talla. */
	public JTextField getTalla() {
		return talla;
	}

	/** Configura talla. */
	public void setTalla(JTextField talla) {
		this.talla = talla;
	}

	/** Devuelve color. */
	public JTextField getColor() {
		return color;
	}

	/** Configura color. */
	public void setColor(JTextField color) {
		this.color = color;
	}

	/** Devuelve marcaTec. */
	public JTextField getMarcaTec() {
		return marcaTec;
	}

	/** Configura marcaTec. */
	public void setMarcaTec(JTextField marcaTec) {
		this.marcaTec = marcaTec;
	}

	/** Devuelve modeloTec. */
	public JTextField getModeloTec() {
		return modeloTec;
	}

	/** Configura modeloTec. */
	public void setModeloTec(JTextField modeloTec) {
		this.modeloTec = modeloTec;
	}

	/** Devuelve ano. */
	public JTextField getAno() {
		return ano;
	}

	/** Configura ano. */
	public void setAno(JTextField ano) {
		this.ano = ano;
	}

	/** Devuelve modeloVE. */
	public JTextField getModeloVE() {
		return modeloVE;
	}

	/** Configura modeloVE. */
	public void setModeloVE(JTextField modeloVE) {
		this.modeloVE = modeloVE;
	}

	/** Devuelve el botón examinar. */
	public JButton getBtnExaminar() {
		return btnExaminar;
	}
	
}
