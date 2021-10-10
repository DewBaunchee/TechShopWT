package by.varyvoda.matvey.entity;

/**
 * @author Matvey Varyvoda
 * @since 09.10.2021
 */
public class Oven extends Appliance {

    private Integer powerConsumption;

    private Integer weight;

    private Integer capacity;

    private Integer depth;

    private Double height;

    private Double width;

    /**
     * @return returns power consumption of oven
     * */
    public Integer getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(Integer powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    /**
     * @return returns weight of oven
     * */
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * @return returns capacity of oven
     * */
    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    /**
     * @return returns depth of oven
     * */
    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    /**
     * @return returns height of oven
     * */
    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    /**
     * @return returns width of oven
     * */
    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public String toString () {
        return getClass().getSimpleName() + "("
                + "Price = " + getPrice() + ", "
                + "Power consumption = " + getPowerConsumption() + ", "
                + "Weight = " + getWeight() + ", "
                + "Capacity = " + getCapacity() + ", "
                + "Depth = " + getDepth() + ", "
                + "Height = " + getHeight() + ", "
                + "Width = " + getWidth() + ")";
    }
}
