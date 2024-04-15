package com.alexaitken.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

import com.alexaitken.gildedrose.Inventory;
import com.alexaitken.gildedrose.Item;


public class InventoryTest {

    private Inventory createInventory(Item... items) {
        return new Inventory(items);
    }

    /**
     * Prueba p3 comprobando el quality */
    @Test
    public void should_never_changes_quailty_of_Sulfuras() {
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        Inventory inventory = createInventory(sulfuras);
        inventory.updateQuality();
        assertEquals(80, sulfuras.getQuality());
    }
    /**
     * Prueba p3 comprobando el sellIn */
    @Test
    public void should_never_changes_sellIn_of_Sulfuras() {
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        Inventory inventory = createInventory(sulfuras);
        inventory.updateQuality();
        assertEquals(0, sulfuras.getSellIn());
    }

    /**
     * Prueba p9 comprobando el sellIn */
    @Test
    public void should_lower_the_sellIn_by_one_for_normal_items() {
        Item normalItem = new Item("+5 Dexterity Vest", 10, 20);
        Inventory inventory = createInventory(normalItem);
        inventory.updateQuality();
        assertEquals(9, normalItem.getSellIn());
    }

    /**
     * Prueba p9 comprobando el quality */
    @Test
    public void should_lower_the_quality_by_one_for_normal_items() {
        Item normalItem = new Item("+5 Dexterity Vest", 10, 20);
        Inventory inventory = createInventory(normalItem);
        inventory.updateQuality();
        assertEquals(19, normalItem.getQuality());
    }
    /**
     * Prueba p9 comprobando el quality */
    @Test
    public void should_lower_the_quality_by_one_for_normal_items10b() {
        Item normalItem = new Item("+5 Dexterity Vest", -8, 1);
        Inventory inventory = createInventory(normalItem);
        inventory.updateQuality();
        assertEquals(0, normalItem.getQuality());
    }
    /**
     * Prueba p9 comprobando el quality */
    @Test
    public void should_lower_the_quality_by_one_for_normal_items10c() {
        Item normalItem = new Item("+5 Dexterity Vest", -8, 0);
        Inventory inventory = createInventory(normalItem);
        inventory.updateQuality();
        assertEquals(0, normalItem.getQuality());
    }
    /**
     * Prueba p9 comprobando el quality */
    @Test
    public void should_lower_the_quality_by_one_for_normal_items10d() {
        Item normalItem = new Item("+5 Dexterity Vest", 0, 25);
        Inventory inventory = createInventory(normalItem);
        inventory.updateQuality();
        assertEquals(23, normalItem.getQuality());
    }

    /**
     * Prueba p9b y p10c comprobando el quality */
    @Test
    public void should_not_lower_the_quality_below_zero() {
        Item normalItem = new Item("+5 Dexterity Vest", 10, 0);
        Inventory inventory = createInventory(normalItem);
        inventory.updateQuality();
        assertEquals(0, normalItem.getQuality());
    }

    /**
     * Prueba p10 comprobando el quality */
    @Test
    public void should_lower_the_quality_twice_as_fast_once_the_sell_in_date_has_passed() {
        Item normalItem = new Item("+5 Dexterity Vest", -1, 25);
        Inventory inventory = createInventory(normalItem);
        inventory.updateQuality();
        assertEquals(23, normalItem.getQuality());
    }

    /**
     * Prueba p1 mirando el quality */
    @Test
    public void should_increase_the_quality_of_aged_brie_as_it_gets_older2() {
        Item agedBrie = new Item("Aged Brie", -8, 25);
        Inventory inventory = createInventory(agedBrie);
        inventory.updateQuality();
        assertEquals(27, agedBrie.getQuality());
    }
    /**
     * Prueba p1 mirando el quality */
    @Test
    public void should_increase_the_quality_of_aged_brie_as_it_gets_older2b() {
        Item agedBrie = new Item("Aged Brie", -8, 50);
        Inventory inventory = createInventory(agedBrie);
        inventory.updateQuality();
        assertEquals(50, agedBrie.getQuality());
    }
    /**
     * Prueba p1 mirando el quality */
    @Test
    public void should_increase_the_quality_of_aged_brie_as_it_gets_older2c() {
        Item agedBrie = new Item("Aged Brie", -8, 49);
        Inventory inventory = createInventory(agedBrie);
        inventory.updateQuality();
        assertEquals(50, agedBrie.getQuality());
    }
    /**
     * Prueba p1 mirando el quality */
    @Test
    public void should_increase_the_quality_of_aged_brie_as_it_gets_older2d() {
        Item agedBrie = new Item("Aged Brie", 0, 25);
        Inventory inventory = createInventory(agedBrie);
        inventory.updateQuality();
        assertEquals(27, agedBrie.getQuality());
    }/**


    /**
     * Prueba p1b  mirando el quality */
    @Test
    public void should_not_increase_the_quality_of_aged_brie_over_50() {
        Item agedBrie = new Item("Aged Brie", 10, 50);
        Inventory inventory = createInventory(agedBrie);
        inventory.updateQuality();
        assertEquals(50, agedBrie.getQuality());
    }

    /**
     * Prueba p8 mirando el quality */
    @Test
    public void should_lower_backstage_passes_to_zero_quality_once_concert_has_happened() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 20);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(0, backStagePass.getQuality());
    }

    /**
     * Prueba p7 mirando el quality */
    @Test
    public void should_lower_backstage_passes_to_zero_quality_once_concert_has_happened7() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 25);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(0, backStagePass.getQuality());
    }

    /**
     * Prueba p4 mirando el quality */
    @Test
    public void should_increase_backstage_passes_quality_by_1_when_the_concert_is_more_than_10_days_away() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(21, backStagePass.getQuality());
    }

    /**
     * Prueba p5 mirando el quality */
    @Test
    public void should_increase_backstage_passes_quality_by_2_when_the_concert_is_10_days_or_less_away() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 27);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(29, backStagePass.getQuality());
    }

    /**
     * Prueba p6 mirando el quality */
    @Test
    public void should_increase_backstage_passes_quality_by_3_when_the_concert_is_5_days_or_less_away() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 44);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(47, backStagePass.getQuality());
    }
    /**
     * Prueba p6 mirando el quality */
    @Test
    public void should_increase_backstage_passes_quality_by_3_when_the_concert_is_5_days_or_less_away5b() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(50, backStagePass.getQuality());
    }
    /**
     * Prueba p6 mirando el quality */
    @Test
    public void should_increase_backstage_passes_quality_by_3_when_the_concert_is_5_days_or_less_away5d() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 25);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(27, backStagePass.getQuality());
    }
    /**
     * Prueba p6 mirando el quality */
    @Test
    public void should_increase_backstage_passes_quality_by_3_when_the_concert_is_5_days_or_less_away5e() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 50);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(50, backStagePass.getQuality());
    }/**
     * Prueba p6 mirando el quality */
    @Test
    public void should_increase_backstage_passes_quality_by_3_when_the_concert_is_5_days_or_less_away5f() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 49);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(50, backStagePass.getQuality());
    }

    @Test
    public void should_increase_backstage_passes_quality_by_3_when_the_concert_is_5_days_or_less_away6b() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(50, backStagePass.getQuality());
    }

    @Test
    public void should_increase_backstage_passes_quality_by_3_when_the_concert_is_5_days_or_less_away6c() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(50, backStagePass.getQuality());
    }

    @Test
    public void should_increase_backstage_passes_quality_by_3_when_the_concert_is_5_days_or_less_away6e() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 25);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(28, backStagePass.getQuality());
    }

    @Test
    public void should_increase_backstage_passes_quality_by_3_when_the_concert_is_5_days_or_less_away6f() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 50);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(50, backStagePass.getQuality());
    }
    @Test
    public void should_increase_backstage_passes_quality_by_3_when_the_concert_is_5_days_or_less_away6g() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 49);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(50, backStagePass.getQuality());
    }
    @Test
    public void should_increase_backstage_passes_quality_by_3_when_the_concert_is_5_days_or_less_away6h() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 48);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(50, backStagePass.getQuality());
    }


    /**
     * Prueba p4b, p5c y p6d mirando el quality */
    @Test
    public void should_not_increase_backstage_passes_above_a_quality_of_50() {
        Item backStagePassMoreThan10DaysAway = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 50);
        Item backStagePass10DaysAway = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49);
        Item backStagePass5DaysAway = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 48);
        Inventory inventory = createInventory(backStagePassMoreThan10DaysAway, backStagePass10DaysAway, backStagePass5DaysAway);
        inventory.updateQuality();
        assertEquals(50, backStagePassMoreThan10DaysAway.getQuality());
        assertEquals(50, backStagePass10DaysAway.getQuality());
        assertEquals(50, backStagePass5DaysAway.getQuality());
    }

    @Test
    public void testExtra1() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 48);
        backStagePass.setName("prueba");
        assertEquals("prueba", backStagePass.getName());
    }

    @Test
    public void testExtra2() {
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", -1, 80);
        Inventory inventory = createInventory(sulfuras);
        inventory.updateQuality();
        assertEquals(80, sulfuras.getQuality());
    }
}
