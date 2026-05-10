package com.nhlstenden.pixel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest
{
    private ShoppingCart cart;
    private Game game1;
    private Game game2;
    private Customer customer;

    @BeforeEach
    void setup()
    {
        this.game1 = new Game(50.0, "Action", "PC");
        this.game2 = new Game(30.0, "Indie", "Switch");
        this.customer = new Customer("Alice");
        List<Game> initialGames = new ArrayList<>();
        initialGames.add(game1);
        this.cart = new ShoppingCart(initialGames, customer);
    }

    @Test
    void addGame_validGame_listSizeIncreases()
    {
        this.cart.addGame(game2);

        assertEquals(2, this.cart.getGames().size());
    }

    @Test
    void changeGame_existingGame_gameIsSwapped()
    {
        this.cart.changeGame(game1, game2);

        assertEquals(game2, this.cart.getGames().getFirst());
        assertNotEquals(game1, this.cart.getGames().getFirst());
    }
}