package com.nhlstenden.pixel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PixelPlayTest
{
    private PixelPlay pixelPlay;
    private Receipt recentReceipt;
    private Receipt oldReceipt;

    @BeforeEach
    void setup()
    {
        this.pixelPlay = new PixelPlay();
        Customer customer = new Customer("Bob");

        this.recentReceipt = new Receipt();
        this.recentReceipt.setPurchaseDate(LocalDate.now());
        this.recentReceipt.setPurchasedGames(List.of(
                new Game(10, "RPG", "PC"),
                new Game(10, "RPG", "PC")
        ));

        this.oldReceipt = new Receipt();
        this.oldReceipt.setPurchaseDate(LocalDate.now().minusWeeks(2));
        this.oldReceipt.setPurchasedGames(List.of(
                new Game(5, "Strategy", "PC"),
                new Game(5, "Strategy", "PC"),
                new Game(5, "Strategy", "PC")
        ));
    }

    @Test
    void getMostSellingGenreOfTheWeek_mixedDates_ignoreOldReceipts()
    {
        this.pixelPlay.setReceipts(List.of(recentReceipt, oldReceipt));

        String bestGenre = this.pixelPlay.getMostSellingGenreOfTheWeek();

        assertEquals("RPG", bestGenre);
    }

    @Test
    void getMostSellingGenreOfTheWeek_noRecentSales_returnNoSalesMessage()
    {
        this.pixelPlay.setReceipts(List.of(oldReceipt));

        String bestGenre = this.pixelPlay.getMostSellingGenreOfTheWeek();

        assertEquals("No Sales", bestGenre);
    }
}