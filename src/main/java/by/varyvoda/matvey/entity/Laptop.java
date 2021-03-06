package by.varyvoda.matvey.entity;

/**
 * @author Matvey Varyvoda
 * @since 09.10.2021
 */
public class Laptop extends Appliance {

    private Double batteryCapacity;

    private OperatingSystem operatingSystem;

    private Integer memoryRom;

    private Integer systemMemory;

    private Double cpu;

    private Integer displayInches;

    /**
     * @return returns battery capacity of laptop
     */
    public Double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(Double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    /**
     * @return returns OS of laptop
     */
    public OperatingSystem getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(OperatingSystem operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    /**
     * @return returns memory rom of laptop
     */
    public Integer getMemoryRom() {
        return memoryRom;
    }

    public void setMemoryRom(Integer memoryRom) {
        this.memoryRom = memoryRom;
    }

    /**
     * @return returns system memory of laptop
     */
    public Integer getSystemMemory() {
        return systemMemory;
    }

    public void setSystemMemory(Integer systemMemory) {
        this.systemMemory = systemMemory;
    }

    /**
     * @return returns cpu of laptop
     */
    public Double getCpu() {
        return cpu;
    }

    public void setCpu(Double cpu) {
        this.cpu = cpu;
    }

    /**
     * @return returns display inches of laptop
     */
    public Integer getDisplayInches() {
        return displayInches;
    }

    public void setDisplayInches(Integer displayInches) {
        this.displayInches = displayInches;
    }

    public enum OperatingSystem {
        WINDOWS("Windows"), LINUX("Linux");

        private final String labelName;

        private String getLabelName() {
            return labelName;
        }

        OperatingSystem(String labelName) {
            this.labelName = labelName;
        }
    }

    public String toString() {
        return getClass().getSimpleName() + "("
                + "Price = " + getPrice() + ", "
                + "Battery capacity = " + getBatteryCapacity() + ", "
                + "Operating system = " + getOperatingSystem().getLabelName() + ", "
                + "Memory ROM = " + getMemoryRom() + ", "
                + "System memory = " + getSystemMemory() + ", "
                + "CPU = " + getCpu() + ", "
                + "Display inches = " + getDisplayInches() + ")";
    }

}
