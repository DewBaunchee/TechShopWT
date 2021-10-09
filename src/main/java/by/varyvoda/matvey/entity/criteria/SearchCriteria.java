package by.varyvoda.matvey.entity.criteria;

import by.varyvoda.matvey.entity.Laptop;
import by.varyvoda.matvey.entity.Oven;
import by.varyvoda.matvey.entity.VacuumCleaner;

import java.util.Objects;

public final class SearchCriteria {

    private static abstract class Criteria<T, V> {

        private final IComparer<T, V> comparer;

        private Criteria(IComparer<T, V> comparer) {
            this.comparer = comparer;
        }

        public IComparer<T, V> getComparer() {
            return comparer;
        }
    }

    public static class OvenCriteria<V> extends Criteria<Oven, V> {

        public static final OvenCriteria<Integer> POWER_CONSUMPTION = new OvenCriteria<>(
                (oven, value) -> Objects.equals(oven.getPowerConsumption(), value)
        );

        public static final OvenCriteria<Integer> WEIGHT = new OvenCriteria<>(
                (oven, value) -> Objects.equals(oven.getWeight(), value)
        );

        public static final OvenCriteria<Integer> CAPACITY = new OvenCriteria<>(
                (oven, value) -> Objects.equals(oven.getCapacity(), value)
        );

        public static final OvenCriteria<Integer> DEPTH = new OvenCriteria<>(
                (oven, value) -> Objects.equals(oven.getDepth(), value)
        );

        public static final OvenCriteria<Double> HEIGHT = new OvenCriteria<>(
                (oven, value) -> Objects.equals(oven.getHeight(), value)
        );

        public static final OvenCriteria<Double> WIDTH = new OvenCriteria<>(
                (oven, value) -> Objects.equals(oven.getWidth(), value)
        );

        private OvenCriteria(IComparer<Oven, V> comparer) {
            super(comparer);
        }
    }

    public static class LaptopCriteria<V> extends Criteria<Laptop, V> {

        public static final LaptopCriteria<Double> BATTERY_CAPACITY = new LaptopCriteria<>(
                (laptop, value) -> Objects.equals(laptop.getBatteryCapacity(), value)
        );

        public static final LaptopCriteria<Laptop.OperatingSystem> OS = new LaptopCriteria<>(
                (laptop, value) -> laptop.getOperatingSystem() == value
        );

        public static final LaptopCriteria<Integer> MEMORY_ROM = new LaptopCriteria<>(
                (laptop, value) -> Objects.equals(laptop.getMemoryRom(), value)
        );

        public static final LaptopCriteria<Integer> SYSTEM_MEMORY = new LaptopCriteria<>(
                (laptop, value) -> Objects.equals(laptop.getSystemMemory(), value)
        );

        public static final LaptopCriteria<Double> CPU = new LaptopCriteria<>(
                (laptop, value) -> Objects.equals(laptop.getCpu(), value)
        );

        public static final LaptopCriteria<Integer> DISPLAY_INCHES = new LaptopCriteria<>(
                (laptop, value) -> Objects.equals(laptop.getDisplayInches(), value)
        );

        private LaptopCriteria(IComparer<Laptop, V> comparer) {
            super(comparer);
        }
    }

    public static class VacuumCleanerCriteria<V> extends Criteria<VacuumCleaner, V> {

        public static final VacuumCleanerCriteria<Integer> POWER_CONSUMPTION = new VacuumCleanerCriteria<>(
                (vacuumCleaner, value) -> Objects.equals(vacuumCleaner.getPowerConsumption(), value)
        );

        public static final VacuumCleanerCriteria<VacuumCleaner.FilterType> FILTER_TYPE = new VacuumCleanerCriteria<>(
                (vacuumCleaner, value) -> vacuumCleaner.getFilterType() == value
        );

        public static final VacuumCleanerCriteria<VacuumCleaner.BagType> BAG_TYPE = new VacuumCleanerCriteria<>(
                (vacuumCleaner, value) -> vacuumCleaner.getBagType() == value
        );

        public static final VacuumCleanerCriteria<VacuumCleaner.WandType> WAND_TYPE = new VacuumCleanerCriteria<>(
                (vacuumCleaner, value) -> vacuumCleaner.getWandType() == value
        );

        public static final VacuumCleanerCriteria<Integer> MOTOR_SPEED_REGULATION = new VacuumCleanerCriteria<>(
                (vacuumCleaner, value) -> Objects.equals(vacuumCleaner.getMotorSpeedRegulation(), value)
        );

        public static final VacuumCleanerCriteria<Integer> CLEANING_WIDTH = new VacuumCleanerCriteria<>(
                (vacuumCleaner, value) -> Objects.equals(vacuumCleaner.getCleaningWidth(), value)
        );

        private VacuumCleanerCriteria(IComparer<VacuumCleaner, V> comparer) {
            super(comparer);
        }
    }

    private SearchCriteria() {
    }

    private interface IComparer<E, V> {
        boolean isSuitable(E entity, V value);
    }
}
