package webspaclientes.modelo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import webspaclientes.modelo.ClientesVO;

@Repository
public interface IClientesDAO extends JpaRepository<ClientesVO, String> {
	
	public ClientesVO findByNombres(String nombres);

	
}
