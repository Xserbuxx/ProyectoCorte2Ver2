package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.InputMismatchException;

import co.edu.unbosque.model.*;
import co.edu.unbosque.util.persistence.*;
import co.edu.unbosque.view.VentanaPrincipal;

public class Controlador implements ActionListener {

	private VentanaPrincipal vp;
	private ModelFacade mf;
	private Usuario usuarioActual;
	private Producto productoTemp;
	private ArrayList<Integer> idsExistentes;

	public Controlador() {
		mf = new ModelFacade();
		vp = new VentanaPrincipal();
	}

	public void runGUI() {
		agregarOyentes();
	}

	private void agregarOyentes() {
		vp.getMp().getVis().getBotonRegistrarse().addActionListener(this);
		vp.getMp().getVis().getBotonRegistrarse().setActionCommand("Boton Registrarse");

		vp.getMp().getReg().getBotonInicioSesion().addActionListener(this);
		vp.getMp().getReg().getBotonInicioSesion().setActionCommand("Boton Iniciar Sesion");

		vp.getMp().getVis().getBotonInicio().addActionListener(this);
		vp.getMp().getVis().getBotonInicio().setActionCommand("Boton Inicio De Sesion");

		vp.getMp().getReg().getBotonRegistro().addActionListener(this);
		vp.getMp().getReg().getBotonRegistro().setActionCommand("Boton Registro");

		vp.getMp().getCom().getCambiarModo().addActionListener(this);
		vp.getMp().getCom().getCambiarModo().setActionCommand("Boton Cambiar A Modo Venta");

		vp.getMp().getVen().getCambiarModo().addActionListener(this);
		vp.getMp().getVen().getCambiarModo().setActionCommand("Boton Cambiar A Modo Compra");

		vp.getMp().getVen().getCerrarSesion().addActionListener(this);
		vp.getMp().getVen().getCerrarSesion().setActionCommand("Boton Cerrar Sesion");

		vp.getMp().getCom().getCerrarSesion().addActionListener(this);
		vp.getMp().getCom().getCerrarSesion().setActionCommand("Boton Cerrar Sesion");

		vp.getMp().getVen().getCategorias().addActionListener(this);
		vp.getMp().getVen().getCategorias().setActionCommand("ComboBox Ventana Vender");

		vp.getMp().getCom().getCategorias().addActionListener(this);
		vp.getMp().getCom().getCategorias().setActionCommand("ComboBox Ventana Comprar");

		vp.getMp().getVen().getRegistrarProducto().addActionListener(this);
		vp.getMp().getVen().getRegistrarProducto().setActionCommand("Boton Registrar Producto");

		vp.getMp().getPip().getVolver().addActionListener(this);
		vp.getMp().getPip().getVolver().setActionCommand("Boton Cambiar Modo Compra");

		vp.getMp().getPip().getAgregarCarrito().addActionListener(this);
		vp.getMp().getPip().getAgregarCarrito().setActionCommand("Boton Agregar Producto A Carrito");

		vp.getMp().getCar().getVolver().addActionListener(this);
		vp.getMp().getCar().getVolver().setActionCommand("Boton Cambiar Modo Compra");

		vp.getMp().getCom().getCarritos().addActionListener(this);
		vp.getMp().getCom().getCarritos().setActionCommand("Boton Carritos");

		vp.getMp().getCar().getCrearCarrito().addActionListener(this);
		vp.getMp().getCar().getCrearCarrito().setActionCommand("Boton Crear Carrito");

		vp.getMp().getCrc().getVolver().addActionListener(this);
		vp.getMp().getCrc().getVolver().setActionCommand("Boton Volver Ventana CRC");

		vp.getMp().getCrc().getCrearCarrito().addActionListener(this);
		vp.getMp().getCrc().getCrearCarrito().setActionCommand("Boton Crear Carrito Ventana CRC");

		vp.getMp().getAca().getVolver().addActionListener(this);
		vp.getMp().getAca().getVolver().setActionCommand("Boton Volver Ventana ACA");

		vp.getMp().getCar().getFiltrar().addActionListener(this);
		vp.getMp().getCar().getFiltrar().setActionCommand("Boton Filtrar");

		vp.getMp().getFac().getVolver().addActionListener(this);
		vp.getMp().getFac().getVolver().setActionCommand("Boton Volver Ventana FAC");

		vp.getMp().getCe().getVolver().addActionListener(this);
		vp.getMp().getCe().getVolver().setActionCommand("Boton Volver Ventana CE");

		vp.getMp().getFac().getComprar().addActionListener(this);
		vp.getMp().getFac().getComprar().setActionCommand("Boton Comprar Ventana FAC");

		vp.getMp().getCc().getVolver().addActionListener(this);
		vp.getMp().getCc().getVolver().setActionCommand("Boton Volver Ventana CC");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String boton = e.getActionCommand();

		if (boton.contains("Producto_")) {
			vp.mostrarMensaje(boton);
		}

		switch (boton) {
		case "Boton Registrarse":
			vp.getMp().mostrarPanel("reg");
			vp.actualizar();
			break;
		case "Boton Iniciar Sesion":
			vp.getMp().mostrarPanel("vis");
			vp.actualizar();
			break;
		case "Boton Inicio De Sesion":
			try {

				boolean encontrado = false;
				boolean romper = false;

				String usuario = vp.getMp().getVis().getUsuario().getText();
				String contrasena = new String(vp.getMp().getVis().getContrasena().getText());

				LanzadorExcepciones.verificarNombre(usuario);
				LanzadorExcepciones.verificarContrasena(contrasena);

				for (Usuario usu : mf.getUsDAO().getLista()) {
					if (usu.getNombre().equals(usuario) && usu.getContrasena().equals(contrasena)) {
						usuarioActual = usu;
						vp.mostrarMensaje("Inicio de sesion exitoso");
						vp.getMp().getCom().getCategorias().setSelectedIndex(0);
						agregarProductosVentanaComprar();
						vp.getMp().mostrarPanel("com");
						encontrado = true;
						break;
					}
				}

				if (encontrado) {
					break;
				}

				for (Usuario usu : mf.getUsDAO().getLista()) {
					if (usu.getNombre().equals(usuario)) {
						usuarioActual = usu;
						vp.mostrarError("La contrasena es incorrecta");
						romper = true;
						break;
					}
				}

				if (romper) {
					break;
				}

				vp.mostrarError("El usuario no existe");

			} catch (NombreException ne) {
				vp.mostrarError(ne.getMessage());
				break;
			} catch (ContrasenaException ce) {
				vp.mostrarError(ce.getMessage());
				break;
			}

			break;

		case "Boton Registro":
			try {

				boolean existe = false;

				String usuario = vp.getMp().getReg().getUsuario().getText();
				String contrasena = new String(vp.getMp().getReg().getContrasena().getText());

				LanzadorExcepciones.verificarNombre(usuario);
				LanzadorExcepciones.verificarContrasena(contrasena);

				for (Usuario usu : mf.getUsDAO().getLista()) {
					if (usu.getNombre().equals(usuario)) {
						vp.mostrarError("El usuario ya existe");
						existe = true;
						return;
					}
				}

				if (existe) {
					break;
				}

				Usuario nuevoUsuario = new Usuario(usuario, contrasena);

				mf.getUsDAO().crear(nuevoUsuario);
				usuarioActual = nuevoUsuario;

				vp.getMp().getCom().getCategorias().setSelectedIndex(0);
				agregarProductosVentanaComprar();

				vp.getMp().mostrarPanel("com");

			} catch (NombreException ne) {
				vp.mostrarError(ne.getMessage());
				break;
			} catch (ContrasenaException ce) {
				vp.mostrarError(ce.getMessage());
				break;
			}
			break;
		case "Boton Cambiar A Modo Compra":
			agregarProductosVentanaComprar();
			vp.getMp().mostrarPanel("com");
			vp.actualizar();
			break;
		case "Boton Cambiar A Modo Venta":
			vp.getMp().mostrarPanel("ven");
			vp.actualizar();
			break;
		case "Boton Cerrar Sesion":
			usuarioActual = null;
			vp.getMp().mostrarPanel("vis");
			vp.getMp().getVis().limpiarCampos();
			vp.getMp().getReg().limpiarCampos();
			break;

		case "ComboBox Ventana Vender":

			//////////////////////////////////////////////
			String selec = vp.getMp().getVen().getCategorias().getSelectedItem().toString();

			switch (selec) {

			case "Seleccione":
				vp.getMp().getVen().limpiarLabels();
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().mostrarCampos();
				break;

			case "Belleza":
				vp.getMp().getVen().limpiarLabels();
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().mostrarBelleza();
				break;

			case "Deportes":
				vp.getMp().getVen().limpiarLabels();
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().mostrarDeportes();
				break;

			case "Hogar":
				vp.getMp().getVen().limpiarLabels();
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().mostrarHogar();
				break;

			case "Juguetes":
				vp.getMp().getVen().limpiarLabels();
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().mostrarJuguetes();
				break;

			case "Libros":
				vp.getMp().getVen().limpiarLabels();
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().mostrarLibros();
				break;

			case "Mascotas":
				vp.getMp().getVen().limpiarLabels();
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().mostrarMascotas();
				break;

			case "Musica":
				vp.getMp().getVen().limpiarLabels();
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().mostrarMusica();
				break;

			case "Ropa":
				vp.getMp().getVen().limpiarLabels();
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().mostrarRopa();
				break;

			case "Tecnologia":
				vp.getMp().getVen().limpiarLabels();
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().mostrarTecnologia();
				break;

			case "Vehiculos":
				vp.getMp().getVen().limpiarLabels();
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().mostrarVehiculos();
				break;
			default:
				break;
			}
			//////////////////////////////////////////////
			break;
		case "ComboBox Ventana Comprar":
			agregarProductosVentanaComprar();
			break;
		case "Boton Registrar Producto":

			//////////////////////////////////////////////

			leerIDSExistentes();
			String seleccion = vp.getMp().getVen().getCategorias().getSelectedItem().toString();

			switch (seleccion) {
			case "Seleccione":
				vp.mostrarError("Seleccione una categoria valida");
				break;
			case "Belleza":
				Belleza belleza = leerDatosBelleza();
				if (belleza != null) {
					mf.getBeDAO().crear(belleza);
					vp.mostrarMensaje("Producto registrado exitosamente");
				}
				break;
			case "Deportes":
				Deporte deporte = leerDatosDeportes();
				if (deporte != null) {
					mf.getDeDAO().crear(deporte);
					vp.mostrarMensaje("Producto registrado exitosamente");
				}
				break;
			case "Hogar":
				Hogar hogar = leerDatosHogar();
				if (hogar != null) {
					mf.getHoDAO().crear(hogar);
					vp.mostrarMensaje("Producto registrado exitosamente");
				}
				break;
			case "Juguetes":
				Juguete juguete = leerDatosJuguetes();
				if (juguete != null) {
					mf.getJuDAO().crear(juguete);
					vp.mostrarMensaje("Producto registrado exitosamente");
				}
				break;
			case "Libros":
				Libro libro = leerDatosLibros();
				if (libro != null) {
					mf.getLiDAO().crear(libro);
					vp.mostrarMensaje("Producto registrado exitosamente");
				}
				break;
			case "Mascotas":
				Mascotas mascotas = leerDatosMascotas();
				if (mascotas != null) {
					mf.getMaDAO().crear(mascotas);
					vp.mostrarMensaje("Producto registrado exitosamente");
				}
				break;
			case "Musica":
				Musica musica = leerDatosMusica();
				if (musica != null) {
					mf.getMuDAO().crear(musica);
					vp.mostrarMensaje("Producto registrado exitosamente");
				}
				break;
			case "Ropa":
				Ropa ropa = leerDatosRopa();
				if (ropa != null) {
					mf.getRoDAO().crear(ropa);
					vp.mostrarMensaje("Producto registrado exitosamente");
				}
				break;
			case "Tecnologia":
				Tecnologia tecnologia = leerDatosTecnologia();
				if (tecnologia != null) {
					mf.getTeDAO().crear(tecnologia);
					vp.mostrarMensaje("Producto registrado exitosamente");
				}
				break;
			case "Vehiculos":
				Vehiculos vehiculo = leerDatosVehiculos();
				if (vehiculo != null) {
					mf.getVeDAO().crear(vehiculo);
					vp.mostrarMensaje("Producto registrado exitosamente");
				}
				break;
			default:
				break;
			}

			//////////////////////////////////////////////

			break;
		default:
			break;
		}

	}

	public void agregarProductosVentanaComprar() {
		vp.getMp().getCom().limpiarProductos();

		if (vp.getMp().getCom().getCategorias().getSelectedItem().toString().equals("Todo")) {
			mf.agregarProductos();
			mf.getProductos().forEach((producto) -> {
				vp.getMp().getCom().mostrarProductos(producto.getNombre(), producto.getPrecio(), producto.getRutaFoto(),
						producto.getId(), this);
			});
		} else if (vp.getMp().getCom().getCategorias().getSelectedItem().toString().equals("Belleza")) {
			mf.getBeDAO().getLista().forEach((producto) -> {
				vp.getMp().getCom().mostrarProductos(producto.getNombre(), producto.getPrecio(), producto.getRutaFoto(),
						producto.getId(), this);
			});
		} else if (vp.getMp().getCom().getCategorias().getSelectedItem().toString().equals("Deportes")) {
			mf.getDeDAO().getLista().forEach((producto) -> {
				vp.getMp().getCom().mostrarProductos(producto.getNombre(), producto.getPrecio(), producto.getRutaFoto(),
						producto.getId(), this);
			});
		} else if (vp.getMp().getCom().getCategorias().getSelectedItem().toString().equals("Hogar")) {
			mf.getHoDAO().getLista().forEach((producto) -> {
				vp.getMp().getCom().mostrarProductos(producto.getNombre(), producto.getPrecio(), producto.getRutaFoto(),
						producto.getId(), this);
			});
		} else if (vp.getMp().getCom().getCategorias().getSelectedItem().toString().equals("Juguetes")) {
			mf.getJuDAO().getLista().forEach((producto) -> {
				vp.getMp().getCom().mostrarProductos(producto.getNombre(), producto.getPrecio(), producto.getRutaFoto(),
						producto.getId(), this);
			});
		} else if (vp.getMp().getCom().getCategorias().getSelectedItem().toString().equals("Libros")) {
			mf.getLiDAO().getLista().forEach((producto) -> {
				vp.getMp().getCom().mostrarProductos(producto.getNombre(), producto.getPrecio(), producto.getRutaFoto(),
						producto.getId(), this);
			});
		} else if (vp.getMp().getCom().getCategorias().getSelectedItem().toString().equals("Belleza")) {
			mf.getBeDAO().getLista().forEach((producto) -> {
				vp.getMp().getCom().mostrarProductos(producto.getNombre(), producto.getPrecio(), producto.getRutaFoto(),
						producto.getId(), this);
			});
		} else if (vp.getMp().getCom().getCategorias().getSelectedItem().toString().equals("Mascotas")) {
			mf.getMaDAO().getLista().forEach((producto) -> {
				vp.getMp().getCom().mostrarProductos(producto.getNombre(), producto.getPrecio(), producto.getRutaFoto(),
						producto.getId(), this);
			});
		} else if (vp.getMp().getCom().getCategorias().getSelectedItem().toString().equals("Musica")) {
			mf.getMuDAO().getLista().forEach((producto) -> {
				vp.getMp().getCom().mostrarProductos(producto.getNombre(), producto.getPrecio(), producto.getRutaFoto(),
						producto.getId(), this);
			});
		} else if (vp.getMp().getCom().getCategorias().getSelectedItem().toString().equals("Ropa")) {
			mf.getRoDAO().getLista().forEach((producto) -> {
				vp.getMp().getCom().mostrarProductos(producto.getNombre(), producto.getPrecio(), producto.getRutaFoto(),
						producto.getId(), this);
			});
		} else if (vp.getMp().getCom().getCategorias().getSelectedItem().toString().equals("Tecnologia")) {
			mf.getTeDAO().getLista().forEach((producto) -> {
				vp.getMp().getCom().mostrarProductos(producto.getNombre(), producto.getPrecio(), producto.getRutaFoto(),
						producto.getId(), this);
			});
		} else if (vp.getMp().getCom().getCategorias().getSelectedItem().toString().equals("Vehiculos")) {
			mf.getVeDAO().getLista().forEach((producto) -> {
				vp.getMp().getCom().mostrarProductos(producto.getNombre(), producto.getPrecio(), producto.getRutaFoto(),
						producto.getId(), this);
			});
		}
		vp.actualizar();
	}

	private void leerIDSExistentes() {
		mf.agregarProductos();
		idsExistentes = new ArrayList<Integer>();
		mf.getProductos().forEach((producto) -> {
			idsExistentes.add(producto.getId());
		});
	}

	private Belleza leerDatosBelleza() {
		try {
			String nombre = vp.getMp().getVen().getNombre().getText();
			String descripcion = vp.getMp().getVen().getDescripcion().getText();
			String rutaFoto = vp.getMp().getVen().getRutaFoto().getText();
			int id = Integer.parseInt(vp.getMp().getVen().getId().getText());
			LanzadorExcepciones.verificarIDExistente(id, idsExistentes);
			LanzadorExcepciones.verificarNumeroNegativo(id);
			int unidades = Integer.parseInt(vp.getMp().getVen().getUnidades().getText());
			LanzadorExcepciones.verificarNumeroNegativo(unidades);
			double precio = Double.parseDouble(vp.getMp().getVen().getPrecio().getText());
			LanzadorExcepciones.verificarNumeroNegativo(precio);
			String tipoProducto = vp.getMp().getVen().getTipoProductoBe().getText();
			String fechaExpiracion = vp.getMp().getVen().getFechaExpiracion().getText();

			return new Belleza(nombre, descripcion, rutaFoto, id, unidades, precio, tipoProducto, fechaExpiracion);

		} catch (InputMismatchException ime) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (NumberFormatException nfe) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (IDExistenteException idee) {
			vp.mostrarError(idee.getMessage());
		} catch (NumeroNegativoException nne) {
			vp.mostrarError(nne.getMessage());
		}

		return null;
	}

	private Deporte leerDatosDeportes() {
		try {
			String nombre = vp.getMp().getVen().getNombre().getText();
			String descripcion = vp.getMp().getVen().getDescripcion().getText();
			String rutaFoto = vp.getMp().getVen().getRutaFoto().getText();
			int id = Integer.parseInt(vp.getMp().getVen().getId().getText());
			LanzadorExcepciones.verificarIDExistente(id, idsExistentes);
			LanzadorExcepciones.verificarNumeroNegativo(id);
			int unidades = Integer.parseInt(vp.getMp().getVen().getUnidades().getText());
			LanzadorExcepciones.verificarNumeroNegativo(unidades);
			double precio = Double.parseDouble(vp.getMp().getVen().getPrecio().getText());
			LanzadorExcepciones.verificarNumeroNegativo(precio);
			String tipoDeporte = vp.getMp().getVen().getTipoDeporte().getText();
			String marca = vp.getMp().getVen().getMarcaDe().getText();

			return new Deporte(nombre, descripcion, rutaFoto, id, unidades, precio, tipoDeporte, marca);

		} catch (InputMismatchException ime) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (NumberFormatException nfe) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (IDExistenteException idee) {
			vp.mostrarError(idee.getMessage());
		} catch (NumeroNegativoException nne) {
			vp.mostrarError(nne.getMessage());
		}

		return null;
	}

	private Hogar leerDatosHogar() {
		try {
			String nombre = vp.getMp().getVen().getNombre().getText();
			String descripcion = vp.getMp().getVen().getDescripcion().getText();
			String rutaFoto = vp.getMp().getVen().getRutaFoto().getText();
			int id = Integer.parseInt(vp.getMp().getVen().getId().getText());
			LanzadorExcepciones.verificarIDExistente(id, idsExistentes);
			LanzadorExcepciones.verificarNumeroNegativo(id);
			int unidades = Integer.parseInt(vp.getMp().getVen().getUnidades().getText());
			LanzadorExcepciones.verificarNumeroNegativo(unidades);
			double precio = Double.parseDouble(vp.getMp().getVen().getPrecio().getText());
			LanzadorExcepciones.verificarNumeroNegativo(precio);
			String material = vp.getMp().getVen().getMaterialHo().getText();
			String tipoProducto = vp.getMp().getVen().getTipoProductoHo().getText();

			return new Hogar(nombre, descripcion, rutaFoto, id, unidades, precio, material, tipoProducto);

		} catch (InputMismatchException ime) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (NumberFormatException nfe) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (IDExistenteException idee) {
			vp.mostrarError(idee.getMessage());
		} catch (NumeroNegativoException nne) {
			vp.mostrarError(nne.getMessage());
		}

		return null;
	}

	private Juguete leerDatosJuguetes() {
		try {
			String nombre = vp.getMp().getVen().getNombre().getText();
			String descripcion = vp.getMp().getVen().getDescripcion().getText();
			String rutaFoto = vp.getMp().getVen().getRutaFoto().getText();
			int id = Integer.parseInt(vp.getMp().getVen().getId().getText());
			LanzadorExcepciones.verificarIDExistente(id, idsExistentes);
			LanzadorExcepciones.verificarNumeroNegativo(id);
			int unidades = Integer.parseInt(vp.getMp().getVen().getUnidades().getText());
			LanzadorExcepciones.verificarNumeroNegativo(unidades);
			double precio = Double.parseDouble(vp.getMp().getVen().getPrecio().getText());
			LanzadorExcepciones.verificarNumeroNegativo(precio);
			int edadRecomendada = Integer.parseInt(vp.getMp().getVen().getEdadRecomendada().getText());
			LanzadorExcepciones.verificarNumeroNegativo(edadRecomendada);
			String material = vp.getMp().getVen().getMaterialJu().getText();

			return new Juguete(nombre, descripcion, rutaFoto, id, unidades, precio, edadRecomendada, material);

		} catch (InputMismatchException ime) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (NumberFormatException nfe) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (IDExistenteException idee) {
			vp.mostrarError(idee.getMessage());
		} catch (NumeroNegativoException nne) {
			vp.mostrarError(nne.getMessage());
		}

		return null;
	}

	private Libro leerDatosLibros() {
		try {
			String nombre = vp.getMp().getVen().getNombre().getText();
			String descripcion = vp.getMp().getVen().getDescripcion().getText();
			String rutaFoto = vp.getMp().getVen().getRutaFoto().getText();
			int id = Integer.parseInt(vp.getMp().getVen().getId().getText());
			LanzadorExcepciones.verificarIDExistente(id, idsExistentes);
			LanzadorExcepciones.verificarNumeroNegativo(id);
			int unidades = Integer.parseInt(vp.getMp().getVen().getUnidades().getText());
			LanzadorExcepciones.verificarNumeroNegativo(unidades);
			double precio = Double.parseDouble(vp.getMp().getVen().getPrecio().getText());
			LanzadorExcepciones.verificarNumeroNegativo(precio);
			String autor = vp.getMp().getVen().getAutor().getText();
			LanzadorExcepciones.verificarNombre(autor);
			long isbn = Long.parseLong(vp.getMp().getVen().getIsbn().getText());
			LanzadorExcepciones.verificarNumeroNegativo(isbn);

			return new Libro(nombre, descripcion, rutaFoto, id, unidades, precio, autor, isbn);

		} catch (InputMismatchException e) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (NumberFormatException e) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (IDExistenteException e) {
			vp.mostrarError(e.getMessage());
		} catch (NumeroNegativoException e) {
			vp.mostrarError(e.getMessage());
		} catch (NombreException e) {
			vp.mostrarError(e.getMessage());
		}

		return null;
	}

	private Mascotas leerDatosMascotas() {
		try {
			String nombre = vp.getMp().getVen().getNombre().getText();
			String descripcion = vp.getMp().getVen().getDescripcion().getText();
			String rutaFoto = vp.getMp().getVen().getRutaFoto().getText();
			int id = Integer.parseInt(vp.getMp().getVen().getId().getText());
			LanzadorExcepciones.verificarIDExistente(id, idsExistentes);
			LanzadorExcepciones.verificarNumeroNegativo(id);
			int unidades = Integer.parseInt(vp.getMp().getVen().getUnidades().getText());
			LanzadorExcepciones.verificarNumeroNegativo(unidades);
			double precio = Double.parseDouble(vp.getMp().getVen().getPrecio().getText());
			LanzadorExcepciones.verificarNumeroNegativo(precio);
			String tipoAnimal = vp.getMp().getVen().getTipoAnimal().getText();
			String tamano = vp.getMp().getVen().getTamano().getText();

			return new Mascotas(nombre, descripcion, rutaFoto, id, unidades, precio, tipoAnimal, tamano);

		} catch (InputMismatchException ime) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (NumberFormatException nfe) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (IDExistenteException idee) {
			vp.mostrarError(idee.getMessage());
		} catch (NumeroNegativoException nne) {
			vp.mostrarError(nne.getMessage());
		}

		return null;
	}

	private Musica leerDatosMusica() {
		try {
			String nombre = vp.getMp().getVen().getNombre().getText();
			String descripcion = vp.getMp().getVen().getDescripcion().getText();
			String rutaFoto = vp.getMp().getVen().getRutaFoto().getText();
			int id = Integer.parseInt(vp.getMp().getVen().getId().getText());
			LanzadorExcepciones.verificarIDExistente(id, idsExistentes);
			LanzadorExcepciones.verificarNumeroNegativo(id);
			int unidades = Integer.parseInt(vp.getMp().getVen().getUnidades().getText());
			LanzadorExcepciones.verificarNumeroNegativo(unidades);
			double precio = Double.parseDouble(vp.getMp().getVen().getPrecio().getText());
			LanzadorExcepciones.verificarNumeroNegativo(precio);
			String formato = vp.getMp().getVen().getFormato().getText();
			String artista = vp.getMp().getVen().getArtista().getText();
			LanzadorExcepciones.verificarNombre(artista);

			return new Musica(nombre, descripcion, rutaFoto, id, unidades, precio, formato, artista);

		} catch (InputMismatchException ime) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (NumberFormatException nfe) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (IDExistenteException idee) {
			vp.mostrarError(idee.getMessage());
		} catch (NumeroNegativoException nne) {
			vp.mostrarError(nne.getMessage());
		} catch (NombreException ne) {
			vp.mostrarError(ne.getMessage());
		}

		return null;
	}

	private Ropa leerDatosRopa() {
		try {
			String nombre = vp.getMp().getVen().getNombre().getText();
			String descripcion = vp.getMp().getVen().getDescripcion().getText();
			String rutaFoto = vp.getMp().getVen().getRutaFoto().getText();
			int id = Integer.parseInt(vp.getMp().getVen().getId().getText());
			LanzadorExcepciones.verificarIDExistente(id, idsExistentes);
			LanzadorExcepciones.verificarNumeroNegativo(id);
			int unidades = Integer.parseInt(vp.getMp().getVen().getUnidades().getText());
			LanzadorExcepciones.verificarNumeroNegativo(unidades);
			double precio = Double.parseDouble(vp.getMp().getVen().getPrecio().getText());
			LanzadorExcepciones.verificarNumeroNegativo(precio);
			String talla = vp.getMp().getVen().getTalla().getText();
			String color = vp.getMp().getVen().getColor().getText();

			return new Ropa(nombre, descripcion, rutaFoto, id, unidades, precio, talla, color);

		} catch (InputMismatchException ime) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (NumberFormatException nfe) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (IDExistenteException idee) {
			vp.mostrarError(idee.getMessage());
		} catch (NumeroNegativoException nne) {
			vp.mostrarError(nne.getMessage());
		}

		return null;
	}

	private Tecnologia leerDatosTecnologia() {
		try {
			String nombre = vp.getMp().getVen().getNombre().getText();
			String descripcion = vp.getMp().getVen().getDescripcion().getText();
			String rutaFoto = vp.getMp().getVen().getRutaFoto().getText();
			int id = Integer.parseInt(vp.getMp().getVen().getId().getText());
			LanzadorExcepciones.verificarIDExistente(id, idsExistentes);
			LanzadorExcepciones.verificarNumeroNegativo(id);
			int unidades = Integer.parseInt(vp.getMp().getVen().getUnidades().getText());
			LanzadorExcepciones.verificarNumeroNegativo(unidades);
			double precio = Double.parseDouble(vp.getMp().getVen().getPrecio().getText());
			LanzadorExcepciones.verificarNumeroNegativo(precio);
			String marca = vp.getMp().getVen().getMarcaTec().getText();
			String modelo = vp.getMp().getVen().getModeloTec().getText();

			return new Tecnologia(nombre, descripcion, rutaFoto, id, unidades, precio, marca, modelo);

		} catch (InputMismatchException ime) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (NumberFormatException nfe) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (IDExistenteException idee) {
			vp.mostrarError(idee.getMessage());
		} catch (NumeroNegativoException nne) {
			vp.mostrarError(nne.getMessage());
		}

		return null;
	}

	private Vehiculos leerDatosVehiculos() {
		try {
			String nombre = vp.getMp().getVen().getNombre().getText();
			String descripcion = vp.getMp().getVen().getDescripcion().getText();
			String rutaFoto = vp.getMp().getVen().getRutaFoto().getText();
			int id = Integer.parseInt(vp.getMp().getVen().getId().getText());
			LanzadorExcepciones.verificarIDExistente(id, idsExistentes);
			LanzadorExcepciones.verificarNumeroNegativo(id);
			int unidades = Integer.parseInt(vp.getMp().getVen().getUnidades().getText());
			LanzadorExcepciones.verificarNumeroNegativo(unidades);
			double precio = Double.parseDouble(vp.getMp().getVen().getPrecio().getText());
			LanzadorExcepciones.verificarNumeroNegativo(precio);
			int anio = Integer.parseInt(vp.getMp().getVen().getAno().getText());
			LanzadorExcepciones.verificarNumeroNegativo(anio);
			String modelo = vp.getMp().getVen().getModeloVE().getText();

			return new Vehiculos(nombre, descripcion, rutaFoto, id, unidades, precio, anio, modelo);

		} catch (InputMismatchException ime) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (NumberFormatException nfe) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (IDExistenteException idee) {
			vp.mostrarError(idee.getMessage());
		} catch (NumeroNegativoException nne) {
			vp.mostrarError(nne.getMessage());
		}

		return null;
	}
}
