package webspaclientes.test;

import static org.junit.Assert.*;

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
public class ModificarClientesTest {
	
	@Autowired
	TestEntityManager entityManager;
	@Autowired
	IClientesDAO dao;

	@Before
	public void setUp() throws Exception {
		ClientesVO clientes = new ClientesVO("19577565", "aldo", "guatacase", "aldo@gmail.com", "98887876");
		this.entityManager.persist(clientes);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCuandoEncuentraIdEntoncesModificaNombreTrue() {
		this.dao.save(new ClientesVO("19577565", "TuPapu", "guatacase", "aldo@gmail.com", "98887876"));
		ClientesVO clientes = this.dao.findById("19577565").get();
		assertNotNull(clientes);
		assertTrue("ES " + clientes.getNombres() + " PERO DEBERÍA SER TuPapu", clientes.getNombres().equals("TuPapu"));
	}

}
