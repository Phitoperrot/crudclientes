package webspaclientes.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AgregarClientesTest.class, EliminarClientesTest.class, ListarClientesTest.class,
		ModificarClientesTest.class })
public class AllTests {

}
