package webspaclientes.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import webspaclientes.modelo.ClientesVO;
import webspaclientes.modelo.dao.IClientesDAO;

@RestController
public class RESTControladorClientes {

	@Autowired
	IClientesDAO dao;
	private String rut2;

	// obtener todos los clientes
	@GetMapping("/clientes")
	public List<ClientesVO> getClientes() {
		return dao.findAll();
	}

	// Obtener ckiente especifico con rut(ID), desde BDD
	@GetMapping("/clientes/{rut}")
	public ClientesVO getCliente(@PathVariable String rut) {
		return dao.findById(rut).get();
	}
	
	// Obtener cliente especifico con nombre, desde BDD
		@GetMapping("/clientes/buscar/{nombres}")
		public ClientesVO getClienteNombres(@PathVariable String nombres) {
			System.out.println("encontrando...");
			return dao.findByNombres(nombres);
		}
	

	// agrego nuevo cliente
	@PostMapping("/clientes")
	public boolean addCliente(@RequestBody ClientesVO nuevo) {
		if (!this.dao.existsById(nuevo.getRut())) {
			System.out.println(nuevo);
			this.dao.save(nuevo);
			return true;
		}
		return false;
	}

	// modifico cliente existente por rut
	@PutMapping("/clientes")
	public boolean modifyCliente(@RequestBody ClientesVO cliente) {

		if (this.dao.existsById(cliente.getRut())) {

			this.dao.save(cliente);

			return true;
		}

		return false;
	}

	// elimina con rut y a todos con 99999999-9 si es que esta en BDD
	@DeleteMapping("/clientes/{rut}")
	public boolean borrarCliente(@PathVariable String rut) {
		

		if (dao.existsById(rut)) {
			ClientesVO clienteEliminar = dao.findById(rut).get();
			

			dao.deleteById(rut);
		}
		
		if (rut.equalsIgnoreCase("99999999-9")) {
			
			dao.deleteAll();
		}

		boolean existe = dao.existsById(rut);
		boolean loBorro = !existe;
		return loBorro;
	}

	

}
