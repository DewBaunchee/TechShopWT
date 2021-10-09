package by.varyvoda.matvey.entity;

public class Oven extends Appliance {

    private Integer powerConsumption;

    private Integer weight;

    private Integer capacity;

    private Integer depth;

    private Double height;

    private Double width;

    public Integer getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(Integer powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public String toString () {
        return getClass().getSimpleName() + "("
                + "Power consumption = " + getPowerConsumption() + ", "
                + "Weight = " + getWeight() + ", "
                + "Capacity = " + getCapacity() + ", "
                + "Depth = " + getDepth() + ", "
                + "Height = " + getHeight() + ", "
                + "Width = " + getWidth() + ")";
    }
}
