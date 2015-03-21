package NJUSENBA;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import logic.PlayerService;

import org.junit.Test;

import vo.PlayerVO;

public class PlayerService_Test {
	PlayerService pbl;

	@Test
	public void test_allPlayerSeasonData() {

		assertTrue(pbl.allPlayerSeasonData() != null);

	}

	@Test
	public void test_allPlayerAverageData() {

		assertTrue(pbl.allPlayerAverageData() != null);

	}

	@Test
	public void test_sort_Ascend() {

		assertTrue(pbl.sort_Ascend(0, new ArrayList<PlayerVO>()) != null);

	}

	@Test
	public void test_sort_Descend() {

		assertTrue(pbl.sort_Descend(0, new ArrayList<PlayerVO>()) != null);

	}

	@Test
	public void test_filter() {

		assertTrue(pbl.filter(new String()) != null);

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
