package com.nhlstenden.pixel;

public class Customer
{
    private String name;
    private ShoppingCart shoppingCart;

    public Customer(String name)
    {
        this.setName(name);
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        if (name == null || name.isBlank())
        {
            throw new IllegalArgumentException("name cannot be null or blank");
        }

        this.name = name;
    }

    public ShoppingCart getShoppingCart()
    {
        return this.shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart)
    {
        this.shoppingCart = shoppingCart;
    }

    public void addGame(Game game)
    {
        this.shoppingCart.addGame(game);
    }
}
