package com.nhlstenden.pixel;

import java.util.List;

public class DiscountCalculator
{
    private static final int DISCOUNT_PERCENTAGE = 10;

    public boolean hasThreeSameGenres(List<Game> games)
    {
        for (int i = 0; i < games.size(); i++)
        {
            String currentGenre = games.get(i).getGenre();
            int count = 0;

            for (int j = 0; j < games.size(); j++)
            {
                if (games.get(j).getGenre().equalsIgnoreCase(currentGenre))
                {
                    count++;
                }
            }

            if (count >= 3)
            {
                return true;
            }
        }
        return false;
    }

    public double getDiscountRate(List<Game> games)
    {
        if (hasThreeSameGenres(games))
        {
            return DISCOUNT_PERCENTAGE / 100.0;
        }
        else
        {
            return 0.0;
        }
    }

    public double getPriceAfterDiscount(List<Game> games)
    {
        double total = 0;
        for (Game game : games)
        {
            total += game.getPriceInEuros();
        }
        double rate = getDiscountRate(games);
        return total - (total * rate);
    }
}
