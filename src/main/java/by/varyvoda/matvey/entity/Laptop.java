package by.varyvoda.matvey.entity;

public class Laptop extends Appliance {

    private Double batteryCapacity;

    private OperatingSystem operatingSystem;

    private Integer memoryRom;

    private Integer systemMemory;

    private Double cpu;

    private Integer displayInches;

    public Double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(Double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public OperatingSystem getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(OperatingSystem operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public Integer getMemoryRom() {
        return memoryRom;
    }

    public void setMemoryRom(Integer memoryRom) {
        this.memoryRom = memoryRom;
    }

    public Integer getSystemMemory() {
        return systemMemory;
    }

    public void setSystemMemory(Integer systemMemory) {
        this.systemMemory = systemMemory;
    }

    public Double getCpu() {
        return cpu;
    }

    public void setCpu(Double cpu) {
        this.cpu = cpu;
    }

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

    public String toString () {
        return getClass().getSimpleName() + "("
                + "Battery capacity = " + getBatteryCapacity() + ", "
                + "Operating system = " + getOperatingSystem().getLabelName() + ", "
                + "Memory ROM = " + getMemoryRom() + ", "
                + "System memory = " + getSystemMemory() + ", "
                + "CPU = " + getCpu() + ", "
                + "Display inches = " + getDisplayInches() + ")";
    }

}
