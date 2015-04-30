package launch;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import BL.MatchBL;
import BL.MatchBL_Impl;

public class MatchBL_ImplTest {
	MatchBL m;

	@Before
	public void before() {
		m = new MatchBL_Impl();
	}

	@Test
	public void testGetMatchLogic() {
		assertTrue(m.getMatchByPlayer("Anthony Tolliver") != null);
	}

	@Test
	public void testGetMatchByTeam() {
		assertTrue(m.getMatchByTeam("CHA") != null);
	}

	@Test
	public void testGetRecentMatchByPlayer() {
		assertTrue(m.getRecentMatchByPlayer("Anthony Tolliver") != null);
	}

	@Test
	public void testGetRecentMatchByTeam() {
		assertTrue(m.getRecentMatchByTeam("CHA") != null);
	}

	@Test
	public void testGetRecentShortMatchByTeam() {
		assertTrue(m.getRecentShortMatchByTeam("CHA") != null);
	}

	@Test
	public void testGetRecentShortMatchByPlayer() {
		assertTrue(m.getRecentShortMatchByPlayer("Anthony Tolliver") != null);
	}

	@Test
	public void testGetAllMatch() {
		assertTrue(m.getAllMatch() != null);
	}
}
