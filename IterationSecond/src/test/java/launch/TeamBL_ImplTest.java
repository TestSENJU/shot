package launch;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import BL.TeamBL;
import BL.TeamBL_Impl;

public class TeamBL_ImplTest {
	TeamBL t;

	@Before
	public void before() {
		t = new TeamBL_Impl();
	}

	@Test
	public void testGetTeamAll() {
		assertTrue(t.getTeamAll() != null);
	}

	@Test
	public void testGetTeamAverage() {
		assertTrue(t.getTeamAverage() != null);
	}

	@Test
	public void testGetTeamBasic() {
		assertTrue(t.getTeamBasic() != null);
	}

	@Test
	public void testGetTeamBasicByName() {
		assertTrue(t.getTeamBasicByName("Atlanta") != null);
	}

	@Test
	public void testGetTeamAverageByName() {
		assertTrue(t.getTeamAverageByName("Atlanta") != null);
	}

	@Test
	public void testGetTeamAllByName() {
		assertTrue(t.getTeamAllByName("Atlanta") != null);
	}

	@Test
	public void testGetTeamAllRankingByNumRaising() {
		assertTrue(t.getTeamAllRankingByNumRaising(1) != null);
	}

	@Test
	public void testGetTeamAverageRankingByNum() {
		assertTrue(t.getTeamAverageRankingByNum(1) != null);
	}

	@Test
	public void testGetHotTeamByNum() {
		assertTrue(t.getHotTeamByNum(0) != null);
		assertTrue(t.getHotTeamByNum(1) != null);
		assertTrue(t.getHotTeamByNum(2) != null);
		assertTrue(t.getHotTeamByNum(3) != null);
		assertTrue(t.getHotTeamByNum(4) != null);
		assertTrue(t.getHotTeamByNum(5) != null);
		assertTrue(t.getHotTeamByNum(6) != null);
		assertTrue(t.getHotTeamByNum(7) != null);
	}

	@Test
	public void testGetLongTeamNames() {
		assertTrue(t.getLongTeamNames() != null);
	}

	@Test
	public void testGetTeamNames() {
		assertTrue(t.getTeamNames() != null);
	}

	@Test
	public void testGetTeamAverageRankingByNumDeclining() {
		assertTrue(t.getTeamAverageRankingByNumDeclining(1) != null);
	}

	@Test
	public void testGetTeamAllRankingByNumDeclining() {
		assertTrue(t.getTeamAverageRankingByNum(1) != null);
	}

}
