package launch;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import BL.PlayerBL;
import BL.PlayerBL_Impl;

public class PlayerBL_ImplTest {
	PlayerBL p;

	@Before
	public void before() {
		p = new PlayerBL_Impl();
	}

	@Test
	public void testGetImprovedPlayerByNum() {
		assertTrue(p.getImprovedPlayerByNum(0) != null);
		assertTrue(p.getImprovedPlayerByNum(1) != null);
		assertTrue(p.getImprovedPlayerByNum(2) != null);
	}

	@Test
	public void testGetTodayHotPlayerByNum() {
		assertTrue(p.getTodayHotPlayerByNum(1) != null);
	}

	@Test
	public void testGetHotPlayerByNum() {
		assertTrue(p.getHotPlayerByNum(2) != null);
	}

	@Test
	public void testGetPlayerNames() {
		assertTrue(p.getPlayerNames() != null);
	}

	@Test
	public void testGetPlayerAll() {
		assertTrue(p.getPlayerAll() != null);
	}

	@Test
	public void testGetPlayerAverage() {
		assertTrue(p.getPlayerAverage() != null);
	}

	@Test
	public void testGetPlayerBasic() {
		assertTrue(p.getPlayerBasic() != null);
	}

	@Test
	public void testGetPlayerBasicByName() {
		assertTrue(p.getPlayerBasicByName("Anthony Tolliver") != null);
	}

	@Test
	public void testGetPlayerAllByName() {
		assertTrue(p.getPlayerAllByName("Anthony Tolliver") != null);
	}

	@Test
	public void testGetPlayerAverageByName() {
		assertTrue(p.getPlayerAverageByName("Anthony Tolliver") != null);
	}

	@Test
	public void testGetPlayerAllRankingByNumRaising() {
		assertTrue(p.getPlayerAllRankingByNumRaising(0) != null);
		assertTrue(p.getPlayerAllRankingByNumRaising(1) != null);
		assertTrue(p.getPlayerAllRankingByNumRaising(23) != null);
		assertTrue(p.getPlayerAllRankingByNumRaising(24) != null);
		assertTrue(p.getPlayerAllRankingByNumRaising(25) != null);
		assertTrue(p.getPlayerAllRankingByNumRaising(26) != null);
		assertTrue(p.getPlayerAllRankingByNumRaising(27) != null);
	}

	@Test
	public void testGetPlayerAvergaeRankingByNumRaising() {
		assertTrue(p.getPlayerAvergaeRankingByNumRaising(0) != null);
		assertTrue(p.getPlayerAvergaeRankingByNumRaising(1) != null);
		assertTrue(p.getPlayerAvergaeRankingByNumRaising(23) != null);
		assertTrue(p.getPlayerAvergaeRankingByNumRaising(24) != null);
		assertTrue(p.getPlayerAvergaeRankingByNumRaising(25) != null);
		assertTrue(p.getPlayerAvergaeRankingByNumRaising(26) != null);
		assertTrue(p.getPlayerAvergaeRankingByNumRaising(27) != null);
	}

	@Test
	public void testGetPlayerAllRankingByNumDeclining() {
		assertTrue(p.getPlayerAllRankingByNumDeclining(1) != null);
	}

	@Test
	public void testGetPlayerNamesByBasic() {
		assertTrue(p.getPlayerNamesByBasic() != null);
	}
}
