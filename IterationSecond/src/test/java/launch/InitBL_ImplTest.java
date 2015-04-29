package launch;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import BL.BaseBL;

public class InitBL_ImplTest {
	BaseBL i;

	@Before
	public void before() {
		i = new BaseBL();
	}

	@Test
	public void testGetMatchLogic1() {
		assertTrue(i.getMatchLogic(1) != null);

	}

	@Test
	public void testGetMatchLogic2() {
		assertTrue(i.getMatchLogic(2) == null);

	}

}
