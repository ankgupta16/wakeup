package edu.umich.gopalkri.wakeup.data;

public class Alarm implements java.io.Serializable
{
    public enum Units
    {
        KM, METERS, MILES, FEET
    }

    public Alarm()
    {
    }

    public Alarm(String name, double latitude, double longitude, double radius, Units unit)
    {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
        this.unit = unit;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getLatitude()
    {
        return latitude;
    }

    public void setLatitude(double latitude)
    {
        this.latitude = latitude;
    }

    public double getLongitude()
    {
        return longitude;
    }

    public void setLongitude(double longitude)
    {
        this.longitude = longitude;
    }

    public double getRadius()
    {
        return radius;
    }

    public void setRadius(double radius)
    {
        this.radius = radius;
    }

    public Units getUnit()
    {
        return unit;
    }

    public void setUnit(Units unit)
    {
        this.unit = unit;
    }

    private String name;

    private double latitude;

    private double longitude;

    private double radius;

    private Units unit;

    /**
     * Autogenerated.
     */
    private static final long serialVersionUID = -492202907798984554L;
}
