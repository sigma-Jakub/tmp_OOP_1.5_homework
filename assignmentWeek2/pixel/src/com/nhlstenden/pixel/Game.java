package com.nhlstenden.pixel;

public class Game
{
    private double priceInEuros;
    private String genre;
    private String platform;

    public Game(double priceInEuros, String genre, String platform)
    {
        this.setPriceInEuros(priceInEuros);
        this.setGenre(genre);
        this.setPlatform(platform);
    }

    public double getPriceInEuros()
    {
        return this.priceInEuros;
    }

    public void setPriceInEuros(double priceInEuros)
    {
        if (priceInEuros < 0)
        {
            throw new IllegalArgumentException("priceInEuros cannot be lower than zero");
        }

        this.priceInEuros = priceInEuros;
    }

    public String getGenre()
    {
        return this.genre;
    }

    public void setGenre(String genre)
    {
        if (genre == null || genre.isBlank())
        {
            throw new IllegalArgumentException("genre cannot be null or blank");
        }

        this.genre = genre;
    }

    public String getPlatform()
    {
        return this.platform;
    }

    public void setPlatform(String platform)
    {
        if (platform == null || platform.isBlank())
        {
            throw new IllegalArgumentException("platform cannot be null or blank");
        }

        this.platform = platform;
    }
}
