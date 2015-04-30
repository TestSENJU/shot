package launch;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import BL.InitBL;
import BL.InitBL_Impl;

public class InitBL_ImplTest {
	InitBL i;

	@Before
	public void before() {
		i = new InitBL_Impl("D://newData");
	}

	@Test
	public void testGetMatchLogic() {
		assertTrue(i.getMatchLogic() != null);
	}

	@Test
	public void testGetPlayerLogic() {
		assertTrue(i.getPlayerLogic() != null);
	}
	
	@Test
	public void testGetTeamLogic() {
		assertTrue(i.getTeamLogic() != null);
	}

}
