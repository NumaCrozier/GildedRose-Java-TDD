package fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GildedRoseTest
{
	private Item itemTest;
	
	@Before
	public void creationItem()
	{
		itemTest = new Item("Test", 0, 0);
	}
	
	@Test
	public void sellInAndQualityWhenAnItemIsUpdated()
	{
		int initialQuality = 10;
		int initialSellIn = 8;
		itemTest.setQuality(initialQuality);
		itemTest.setSellIn(initialSellIn);
		
		GildedRose.updateItem(itemTest);
		assertEquals(itemTest.getQuality(), initialQuality - 1);
		assertEquals(itemTest.getSellIn(), initialSellIn - 1);
	}

	@Test
	public void qualityWithSellInBelowZeroWhenAnItemIsUpdated()
	{
		int initialQuality = 10;
		int initialSellIn = 0;
		itemTest.setQuality(initialQuality);
		itemTest.setSellIn(initialSellIn);
		
		GildedRose.updateItem(itemTest);
		assertEquals(itemTest.getQuality(), initialQuality - 2);
		assertEquals(itemTest.getSellIn(), initialSellIn - 1);
	}
	
	@Test
	public void qualityNotNegativeWhenAnItemIsUpdated()
	{
		int initialQuality = 0;
		int initialSellIn = 8;
		itemTest.setQuality(initialQuality);
		itemTest.setSellIn(initialSellIn);
		
		GildedRose.updateItem(itemTest);
		assertEquals(itemTest.getQuality(), 0);
	}
	
	@Test
	public void qualityOfTheAgedBrieWhenItIsUpdated()
	{
		int initialQuality = 10;
		int initialSellIn = 2;
		itemTest.setName("Aged Brie");
		itemTest.setQuality(initialQuality);
		itemTest.setSellIn(initialSellIn);
		
		GildedRose.updateItem(itemTest);
		assertEquals(itemTest.getQuality(), initialQuality + 1);
	}
	
	@Test
	public void qualityNeverOverFiftyWhenItIsUpdated()
	{
		int initialQuality = 50;
		int initialSellIn = 8;
		itemTest.setName("Aged Brie");
		itemTest.setQuality(initialQuality);
		itemTest.setSellIn(initialSellIn);
		
		GildedRose.updateItem(itemTest);
		assertEquals(itemTest.getQuality(), 50);
	}
	
	@Test
	public void sellInAndQualityofSulfurasHandOfRagnarosWhenItIsUpdated()
	{
		int initialQuality = 80;
		int initialSellIn = 0;
		itemTest.setName("Sulfuras, Hand of Ragnaros");
		itemTest.setQuality(initialQuality);
		itemTest.setSellIn(initialSellIn);
		
		GildedRose.updateItem(itemTest);
		assertEquals(itemTest.getQuality(), initialQuality);
		assertEquals(itemTest.getSellIn(), initialSellIn);
	}
}