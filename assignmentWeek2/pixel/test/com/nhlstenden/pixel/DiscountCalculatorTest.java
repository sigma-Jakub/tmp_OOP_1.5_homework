package com.nhlstenden.pixel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiscountCalculatorTest
{
    private DiscountCalculator calculator;
    private Game gameRpg1;
    private Game gameRpg2;
    private Game gameRpg3;
    private Game gameFps;

    @BeforeEach
    void setup()
    {
        this.calculator = new DiscountCalculator();
        this.gameRpg1 = new Game(60.0, "RPG", "PC");
        this.gameRpg2 = new Game(40.0, "RPG", "PS5");
        this.gameRpg3 = new Game(20.0, "RPG", "Switch");
        this.gameFps = new Game(50.0, "FPS", "PC");
    }

    @Test
    void getDiscountRate_twoSameGenres_returnZero()
    {
        List<Game> games = List.of(gameRpg1, gameRpg2, gameFps);

        double rate = this.calculator.getDiscountRate(games);

        assertEquals(0.0, rate);
    }

    @Test
    void getDiscountRate_threeSameGenres_returnTenPercent()
    {
        List<Game> games = List.of(gameRpg1, gameRpg2, gameRpg3);

        double rate = this.calculator.getDiscountRate(games);

        assertEquals(0.10, rate);
    }

    @Test
    void getPriceAfterDiscount_threeSameGenres_returnDiscountedTotal()
    {
        List<Game> games = List.of(gameRpg1, gameRpg2, gameRpg3);

        double total = this.calculator.getPriceAfterDiscount(games);

        assertEquals(108.0, total);
    }
}