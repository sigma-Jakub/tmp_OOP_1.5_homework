package com.nhlstenden.pixel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PixelPlay
{
    private List<Customer> customers;
    private List<Receipt> receipts;

    public PixelPlay()
    {
        this.customers = new ArrayList<>();
        this.receipts = new ArrayList<>();
    }

    public List<Customer> getCustomers()
    {
        return this.customers;
    }

    public void setCustomers(List<Customer> customers)
    {
        if (customers == null || customers.isEmpty())
        {
            throw new IllegalArgumentException("customers cannot be null or empty");
        }

        for (Customer customersItem : customers)
        {
            if (customersItem == null)
            {
                throw new IllegalArgumentException("customers cannot be null");
            }
        }

        this.customers = new java.util.ArrayList<>(customers);
    }

    public List<Receipt> getReceipts()
    {
        return this.receipts;
    }

    public void setReceipts(List<Receipt> receipts)
    {
        if (receipts == null || receipts.isEmpty())
        {
            throw new IllegalArgumentException("receipts cannot be null or empty");
        }

        for (Receipt receiptsItem : receipts)
        {
            if (receiptsItem == null)
            {
                throw new IllegalArgumentException("receipts cannot be null");
            }
        }

        this.receipts = new java.util.ArrayList<>(receipts);
    }

    public String getMostSellingGenreOfTheWeek()
    {
        LocalDate oneWeekAgo = LocalDate.now().minusWeeks(1);
        List<String> allGenresFound = new ArrayList<>();

        for (Receipt receipt : receipts)
        {
            if (receipt.getPurchaseDate().isAfter(oneWeekAgo))
            {
                for (Game game : receipt.getPurchasedGames())
                {
                    allGenresFound.add(game.getGenre());
                }
            }
        }

        String bestGenre = "No Sales";
        int maxCount = 0;

        for (int i = 0; i < allGenresFound.size(); i++)
        {
            String target = allGenresFound.get(i);
            int currentCount = 0;

            for (int j = 0; j < allGenresFound.size(); j++)
            {
                if (allGenresFound.get(j).equals(target))
                {
                    currentCount++;
                }
            }

            if (currentCount > maxCount)
            {
                maxCount = currentCount;
                bestGenre = target;
            }
        }

        return bestGenre;
    }
}
