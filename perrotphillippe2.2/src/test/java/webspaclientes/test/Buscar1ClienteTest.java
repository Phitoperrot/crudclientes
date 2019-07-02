package webspaclientes.test;

import static org.junit.Assert.*;

import java.awt.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import webspaclientes.modelo.ClientesVO;
import webspaclientes.modelo.dao.IClientesDAO;

@RunWith(SpringRunner.class)
@DataJpaTest
public class Buscar1ClienteTest {
	
	@Autowired
	TestEntityManager entityManager;
	@Autowired
	IClientesDAO dao;

	@Before
	public void setUp() throws Exception {
		ClientesVO clientes = new ClientesVO("16777565", "aldo", "guatacase", "aldo@gmail.com", "98887876");
		this.entityManager.persist(clientes);
		clientes = new ClientesVO("15117565", "alda", "guata", "aldaita@gmail.com", "92882876");
		this.entityManager.persist(clientes);
		clientes = new ClientesVO("6777565", "aldecinda", "guatamal", "aldecinda@gmail.com", "84387876");
		this.entityManager.persist(clientes);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCuandoBusca1ClienteEntoncesEncuentra1() {
		
		ClientesVO clienteBuscar = this.dao.findById("16777565").get();
		assertNotNull(clienteBuscar);
		
	}

}
