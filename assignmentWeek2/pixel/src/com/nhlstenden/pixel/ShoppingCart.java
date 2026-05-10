package com.nhlstenden.pixel;

import java.util.List;

public class ShoppingCart
{
    private List<Game> games;
    private Customer customer;

    public ShoppingCart(List<Game> games, Customer customer)
    {
        this.setGames(games);
        this.setCustomer(customer);
    }

    public List<Game> getGames()
    {
        return this.games;
    }

    public void setGames(List<Game> games)
    {
        if (games == null || games.isEmpty())
        {
            throw new IllegalArgumentException("games cannot be null or empty");
        }

        for (Game gamesItem : games)
        {
            if (gamesItem == null)
            {
                throw new IllegalArgumentException("games cannot be null");
            }
        }

        this.games = new java.util.ArrayList<>(games);
    }

    public Customer getCustomer()
    {
        return this.customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    public void addGame(Game game)
    {
        this.games.add(game);
    }

    public void removeGame(Game game)
    {
        this.games.remove(game);
    }

    public void changeGame(Game gameToBeChanged, Game newGame)
    {
        for (int i = 0; i < this.games.size(); i++)
        {
            if (this.games.get(i) == gameToBeChanged)
            {
                this.games.set(i, newGame);
                return;
            }
        }
    }
}
