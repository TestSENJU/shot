package NJUSENBA;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import logic.PlayerService;

import org.junit.Test;

import vo.PlayerAverageVO;
import vo.PlayerVO;

public class PlayerService_Test {
	PlayerService pbl;

	@Test
	public void test_playerAll() {

		assertTrue(pbl.playerAll() != null);

	}

	@Test
	public void test_playerAverage() {

		assertTrue(pbl.playerAverage() != null);

	}

	@Test
	public void test_filterAll() {

		assertTrue(pbl.filterAll(new String()) != null);

	}
	
	@Test
	public void test_filterAverage() {

		assertTrue(pbl.filterAverage(new String()) != null);

	}


	@Test
	public void test_playerPersonalInfo() {

		assertTrue(pbl.playerPersonalInfo() != null);

	}

	@Test
	public void test_selectedPlayerInfo() {

		assertTrue(pbl.selectedPlayerInfo(new String()) != null);

	}
}
