package com.nhlstenden.pixel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptTest
{
    private Receipt receipt;
    private Customer customer;
    private Game game1;
    private Game game2;
    private Game game3;

    @BeforeEach
    void setup()
    {
        this.customer = new Customer("John Doe");
        this.game1 = new Game(60.0, "RPG", "PC");
        this.game2 = new Game(40.0, "RPG", "PS5");
        this.game3 = new Game(20.0, "RPG", "Switch");

        this.receipt = new Receipt();
        this.receipt.setCustomer(customer);
        this.receipt.setPurchaseDate(LocalDate.now());
    }

    @Test
    void generateReceipt_threeSameGenres_containsDiscountText()
    {
        this.receipt.setPurchasedGames(List.of(game1, game2, game3));

        String output = this.receipt.generateReceipt();

        assertTrue(output.contains("[Discount: -6.00€]"));
        assertTrue(output.contains("[Discount: -4.00€]"));
        assertTrue(output.contains("[Discount: -2.00€]"));
    }

    @Test
    void generateReceipt_noDiscountTriggered_doesNotContainDiscountText()
    {
        Game gameDifferent = new Game(50.0, "Action", "PC");
        this.receipt.setPurchasedGames(List.of(game1, game2, gameDifferent));

        String output = this.receipt.generateReceipt();

        assertFalse(output.contains("Discount:"));
    }

    @Test
    void generateReceipt_validGames_calculatesCorrectTotal()
    {
        this.receipt.setPurchasedGames(List.of(game1, game2, game3));

        String output = this.receipt.generateReceipt();

        assertTrue(output.contains("TOTAL: 108.00€"));
    }

    @Test
    void setPurchaseDate_nullDate_throwsException()
    {
        assertThrows(IllegalArgumentException.class, () -> {
            this.receipt.setPurchaseDate(null);
        });
    }
}