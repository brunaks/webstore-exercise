package webstore.usecases;

/**
 * Created by I848075 on 09/07/2015.
 */
public class Product extends Entity
{
    private String name;
    private String description;
    private double price;
    private int units;

    public Product()
    {
        super();
        this.name = "";
        this.description = "";
        this.units = 0;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return this.description;
    }


    public void setDescription(String description)
    {
        this.description = description;
    }


    public double getPrice()
    {
        return this.price;
    }

    public void setPrice(double price)
    {
        if (price >= 0.0) {
            this.price = price;
        } else {
            throw new priceMustNotBeANegativeNumber();
        }
    }

    public boolean hasInStock(int units)
    {
        if (this.units >= units)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void addUnits(int units)
    {
        this.units += units;
    }

    public int getStock()
    {
        return this.units;
    }

    public void removeUnits(int units)
    {
        if ( (this.units - units) >= 0)
        {
            this.units -= units;
        }
    }

    public class priceMustNotBeANegativeNumber extends RuntimeException{

    }
}
