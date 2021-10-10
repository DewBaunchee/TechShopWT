package by.varyvoda.matvey.entity;

public class VacuumCleaner extends Appliance {

    private Integer powerConsumption;

    private FilterType filterType;

    private BagType bagType;

    private WandType wandType;

    private Integer motorSpeedRegulation;

    private Integer cleaningWidth;

    public Integer getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(Integer powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public FilterType getFilterType() {
        return filterType;
    }

    public void setFilterType(FilterType filterType) {
        this.filterType = filterType;
    }

    public BagType getBagType() {
        return bagType;
    }

    public void setBagType(BagType bagType) {
        this.bagType = bagType;
    }

    public WandType getWandType() {
        return wandType;
    }

    public void setWandType(WandType wandType) {
        this.wandType = wandType;
    }

    public Integer getMotorSpeedRegulation() {
        return motorSpeedRegulation;
    }

    public void setMotorSpeedRegulation(Integer motorSpeedRegulation) {
        this.motorSpeedRegulation = motorSpeedRegulation;
    }

    public Integer getCleaningWidth() {
        return cleaningWidth;
    }

    public void setCleaningWidth(Integer cleaningWidth) {
        this.cleaningWidth = cleaningWidth;
    }

    public enum FilterType {
        A("A"), B("B"), C("C");

        private final String labelName;

        private String getLabelName() {
            return labelName;
        }

        FilterType(String labelName) {
            this.labelName = labelName;
        }
    }

    public enum BagType {
        A2("A2"), AA_89("AA-89"), XX00("XX00");

        private final String labelName;

        private String getLabelName() {
            return labelName;
        }

        BagType(String labelName) {
            this.labelName = labelName;
        }
    }

    public enum WandType {
        ALL_IN_ONE("all-in-one");

        private final String labelName;

        private String getLabelName() {
            return labelName;
        }

        WandType(String labelName) {
            this.labelName = labelName;
        }
    }

    public String toString () {
        return getClass().getSimpleName() + "("
                + "Price = " + getPrice() + ", "
                + "Power consumption = " + getPowerConsumption() + ", "
                + "Filter type = " + getFilterType().getLabelName() + ", "
                + "Bag type = " + getBagType().getLabelName() + ", "
                + "Wand type = " + getWandType().getLabelName() + ", "
                + "Motor speed regulation = " + getMotorSpeedRegulation() + ", "
                + "Cleaning width = " + getCleaningWidth() + ")";
    }

}
