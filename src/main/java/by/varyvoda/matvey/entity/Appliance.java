package by.varyvoda.matvey.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;

/**
 * @author Matvey Varyvoda
 * @since 09.10.2021
 * */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonSubTypes({
        @JsonSubTypes.Type(name = "Laptop", value = Laptop.class),
        @JsonSubTypes.Type(name = "Oven", value = Oven.class),
        @JsonSubTypes.Type(name = "VacuumCleaner", value = VacuumCleaner.class),
})
public abstract class Appliance implements Serializable {

    private Integer price;

    public Appliance() {

    }

    /**
     * @return returns price of appliance
     * */
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
