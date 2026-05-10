package com.nhlstenden.pixel;

import java.time.LocalDate;
import java.util.List;

public class Receipt
{
    private Customer customer;
    private LocalDate purchaseDate;
    private List<Game> purchasedGames;

    public Customer getCustomer()
    {
        return this.customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    public LocalDate getPurchaseDate()
    {
        return this.purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate)
    {
        if (purchaseDate == null)
        {
            throw new IllegalArgumentException("purchaseDate cannot be null");
        }

        this.purchaseDate = purchaseDate;
    }

    public List<Game> getPurchasedGames()
    {
        return this.purchasedGames;
    }

    public void setPurchasedGames(List<Game> purchasedGames)
    {
        if (purchasedGames == null || purchasedGames.isEmpty())
        {
            throw new IllegalArgumentException("purchasedGames cannot be null or empty");
        }

        for (Game purchasedGamesItem : purchasedGames)
        {
            if (purchasedGamesItem == null)
            {
                throw new IllegalArgumentException("purchasedGames cannot be null");
            }
        }

        this.purchasedGames = new java.util.ArrayList<>(purchasedGames);
    }

    public String generateReceipt()
    {
        DiscountCalculator discountCalculator = new DiscountCalculator();
        double rate = discountCalculator.getDiscountRate(getPurchasedGames());
        double total = 0;

        StringBuilder stringBuilder = new StringBuilder("PIXELPLAY\n");

        for (Game game : getPurchasedGames())
        {
            double price = game.getPriceInEuros();
            double savings = price * rate;
            double finalPrice = price - savings;
            total += finalPrice;

            stringBuilder.append(String.format("%s (%s): %.2f€",
                    game.getGenre(), game.getPlatform(), price));

            if (savings > 0)
            {
                stringBuilder.append(String.format(" [Discount: -%.2f€]", savings));
            }
            stringBuilder.append("\n");
        }
        stringBuilder.append(String.format("TOTAL: %.2f€", total));

        return stringBuilder.toString();
    }
}
