package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistence.BellezaDAO;
import co.edu.unbosque.model.persistence.CarritoDAO;
import co.edu.unbosque.model.persistence.DeporteDAO;
import co.edu.unbosque.model.persistence.HogarDAO;
import co.edu.unbosque.model.persistence.JugueteDAO;
import co.edu.unbosque.model.persistence.LibroDAO;
import co.edu.unbosque.model.persistence.MascotaDAO;
import co.edu.unbosque.model.persistence.MusicaDAO;
import co.edu.unbosque.model.persistence.RopaDAO;
import co.edu.unbosque.model.persistence.TecnologiaDAO;
import co.edu.unbosque.model.persistence.UsuarioDAO;
import co.edu.unbosque.model.persistence.VehiculoDAO;

public class ModelFacade {
	
	private ArrayList<Producto> productos;
	
	private UsuarioDAO usDAO;
	private BellezaDAO beDAO;
	private DeporteDAO deDAO;
	private HogarDAO hoDAO;
	private JugueteDAO juDAO;
	private LibroDAO liDAO;
	private MascotaDAO maDAO;
	private MusicaDAO muDAO;
	private RopaDAO roDAO;
	private TecnologiaDAO teDAO;
	private VehiculoDAO veDAO;
	private CarritoDAO caDAO;
	
	public ModelFacade() {
		usDAO = new UsuarioDAO();
		beDAO = new BellezaDAO();
		deDAO = new DeporteDAO();
		hoDAO = new HogarDAO();
		juDAO = new JugueteDAO();
		liDAO = new LibroDAO();
		maDAO = new MascotaDAO();
		muDAO = new MusicaDAO();
		roDAO = new RopaDAO();
		teDAO = new TecnologiaDAO();
		veDAO = new VehiculoDAO();
		caDAO = new CarritoDAO();
		productos = new ArrayList<>();
	}
	
	public void agregarProductos() {
		productos.removeAll(productos);
		beDAO.getLista().forEach((producto) -> {
			productos.add(producto);
		});
		deDAO.getLista().forEach((producto) -> {
			productos.add(producto);
		});
		hoDAO.getLista().forEach((producto) -> {
			productos.add(producto);
		});
		juDAO.getLista().forEach((producto) -> {
			productos.add(producto);
		});
		liDAO.getLista().forEach((producto) -> {
			productos.add(producto);
		});
		maDAO.getLista().forEach((producto) -> {
			productos.add(producto);
		});
		muDAO.getLista().forEach((producto) -> {
			productos.add(producto);
		});
		roDAO.getLista().forEach((producto) -> {
			productos.add(producto);
		});
		teDAO.getLista().forEach((producto) -> {
			productos.add(producto);
		});
		veDAO.getLista().forEach((producto) -> {
			productos.add(producto);
		});
		
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public UsuarioDAO getUsDAO() {
		return usDAO;
	}

	public void setUsDAO(UsuarioDAO usDAO) {
		this.usDAO = usDAO;
	}

	public BellezaDAO getBeDAO() {
		return beDAO;
	}

	public void setBeDAO(BellezaDAO beDAO) {
		this.beDAO = beDAO;
	}

	public DeporteDAO getDeDAO() {
		return deDAO;
	}

	public void setDeDAO(DeporteDAO deDAO) {
		this.deDAO = deDAO;
	}

	public HogarDAO getHoDAO() {
		return hoDAO;
	}

	public void setHoDAO(HogarDAO hoDAO) {
		this.hoDAO = hoDAO;
	}

	public JugueteDAO getJuDAO() {
		return juDAO;
	}

	public void setJuDAO(JugueteDAO juDAO) {
		this.juDAO = juDAO;
	}

	public LibroDAO getLiDAO() {
		return liDAO;
	}

	public void setLiDAO(LibroDAO liDAO) {
		this.liDAO = liDAO;
	}

	public MascotaDAO getMaDAO() {
		return maDAO;
	}

	public void setMaDAO(MascotaDAO maDAO) {
		this.maDAO = maDAO;
	}

	public MusicaDAO getMuDAO() {
		return muDAO;
	}

	public void setMuDAO(MusicaDAO muDAO) {
		this.muDAO = muDAO;
	}

	public RopaDAO getRoDAO() {
		return roDAO;
	}

	public void setRoDAO(RopaDAO roDAO) {
		this.roDAO = roDAO;
	}

	public TecnologiaDAO getTeDAO() {
		return teDAO;
	}

	public void setTeDAO(TecnologiaDAO teDAO) {
		this.teDAO = teDAO;
	}

	public VehiculoDAO getVeDAO() {
		return veDAO;
	}

	public void setVeDAO(VehiculoDAO veDAO) {
		this.veDAO = veDAO;
	}

	public CarritoDAO getCaDAO() {
		return caDAO;
	}

	public void setCaDAO(CarritoDAO caDAO) {
		this.caDAO = caDAO;
	}
	
	
}
