package by.varyvoda.matvey.entity.criteria;

import by.varyvoda.matvey.entity.Laptop;
import by.varyvoda.matvey.entity.Oven;
import by.varyvoda.matvey.entity.VacuumCleaner;

import java.util.Objects;

public final class SearchCriteria {

    public static abstract class Criteria<T, V> {

        private final IComparer<T, V> comparer;
        private final IValueValidator<V> valueValidator;

        private Criteria(IComparer<T, V> comparer, IValueValidator<V> valueValidator) {
            this.comparer = comparer;
            this.valueValidator = valueValidator;
        }

        public IComparer<T, V> getComparer() {
            return comparer;
        }

        public IValueValidator<V> getValueValidator() {
            return valueValidator;
        }
    }

    public static class OvenCriteria<V> extends Criteria<Oven, V> {

        public static final OvenCriteria<Integer> POWER_CONSUMPTION = new OvenCriteria<>(
                (oven, value) -> Objects.equals(oven.getPowerConsumption(), value),
                IValueValidator.INTEGER_ABOVE_ZERO
        );

        public static final OvenCriteria<Integer> WEIGHT = new OvenCriteria<>(
                (oven, value) -> Objects.equals(oven.getWeight(), value),
                IValueValidator.INTEGER_ABOVE_ZERO
        );

        public static final OvenCriteria<Integer> CAPACITY = new OvenCriteria<>(
                (oven, value) -> Objects.equals(oven.getCapacity(), value),
                IValueValidator.INTEGER_ABOVE_ZERO
        );

        public static final OvenCriteria<Integer> DEPTH = new OvenCriteria<>(
                (oven, value) -> Objects.equals(oven.getDepth(), value),
                IValueValidator.INTEGER_ABOVE_ZERO
        );

        public static final OvenCriteria<Double> HEIGHT = new OvenCriteria<>(
                (oven, value) -> Objects.equals(oven.getHeight(), value),
                IValueValidator.DOUBLE_ABOVE_ZERO
        );

        public static final OvenCriteria<Double> WIDTH = new OvenCriteria<>(
                (oven, value) -> Objects.equals(oven.getWidth(), value),
                IValueValidator.DOUBLE_ABOVE_ZERO
        );

        private OvenCriteria(IComparer<Oven, V> comparer, IValueValidator<V> valueValidator) {
            super(comparer, valueValidator);
        }
    }

    public static class LaptopCriteria<V> extends Criteria<Laptop, V> {

        public static final LaptopCriteria<Double> BATTERY_CAPACITY = new LaptopCriteria<>(
                (laptop, value) -> Objects.equals(laptop.getBatteryCapacity(), value),
                IValueValidator.DOUBLE_ABOVE_ZERO
        );

        public static final LaptopCriteria<Laptop.OperatingSystem> OS = new LaptopCriteria<>(
                (laptop, value) -> laptop.getOperatingSystem() == value,
                Objects::nonNull
        );

        public static final LaptopCriteria<Integer> MEMORY_ROM = new LaptopCriteria<>(
                (laptop, value) -> Objects.equals(laptop.getMemoryRom(), value),
                IValueValidator.INTEGER_ABOVE_ZERO
        );

        public static final LaptopCriteria<Integer> SYSTEM_MEMORY = new LaptopCriteria<>(
                (laptop, value) -> Objects.equals(laptop.getSystemMemory(), value),
                IValueValidator.INTEGER_ABOVE_ZERO
        );

        public static final LaptopCriteria<Double> CPU = new LaptopCriteria<>(
                (laptop, value) -> Objects.equals(laptop.getCpu(), value),
                IValueValidator.DOUBLE_ABOVE_ZERO
        );

        public static final LaptopCriteria<Integer> DISPLAY_INCHES = new LaptopCriteria<>(
                (laptop, value) -> Objects.equals(laptop.getDisplayInches(), value),
                IValueValidator.INTEGER_ABOVE_ZERO
        );

        private LaptopCriteria(IComparer<Laptop, V> comparer, IValueValidator<V> valueValidator) {
            super(comparer, valueValidator);
        }
    }

    public static class VacuumCleanerCriteria<V> extends Criteria<VacuumCleaner, V> {

        public static final VacuumCleanerCriteria<Integer> POWER_CONSUMPTION = new VacuumCleanerCriteria<>(
                (vacuumCleaner, value) -> Objects.equals(vacuumCleaner.getPowerConsumption(), value),
                IValueValidator.INTEGER_ABOVE_ZERO
        );

        public static final VacuumCleanerCriteria<VacuumCleaner.FilterType> FILTER_TYPE = new VacuumCleanerCriteria<>(
                (vacuumCleaner, value) -> vacuumCleaner.getFilterType() == value,
                Objects::nonNull
        );

        public static final VacuumCleanerCriteria<VacuumCleaner.BagType> BAG_TYPE = new VacuumCleanerCriteria<>(
                (vacuumCleaner, value) -> vacuumCleaner.getBagType() == value,
                Objects::nonNull
        );

        public static final VacuumCleanerCriteria<VacuumCleaner.WandType> WAND_TYPE = new VacuumCleanerCriteria<>(
                (vacuumCleaner, value) -> vacuumCleaner.getWandType() == value,
                Objects::nonNull
        );

        public static final VacuumCleanerCriteria<Integer> MOTOR_SPEED_REGULATION = new VacuumCleanerCriteria<>(
                (vacuumCleaner, value) -> Objects.equals(vacuumCleaner.getMotorSpeedRegulation(), value),
                IValueValidator.INTEGER_ABOVE_ZERO
        );

        public static final VacuumCleanerCriteria<Integer> CLEANING_WIDTH = new VacuumCleanerCriteria<>(
                (vacuumCleaner, value) -> Objects.equals(vacuumCleaner.getCleaningWidth(), value),
                IValueValidator.INTEGER_ABOVE_ZERO
        );

        private VacuumCleanerCriteria(IComparer<VacuumCleaner, V> comparer, IValueValidator<V> valueValidator) {
            super(comparer, valueValidator);
        }
    }

    private SearchCriteria() {
    }

    public interface IComparer<E, V> {
        boolean isSuitable(E entity, V value);
    }

    public interface IValueValidator<V> {

        IValueValidator<Integer> INTEGER_ABOVE_ZERO = value -> Objects.nonNull(value) && value > 0;
        IValueValidator<Double> DOUBLE_ABOVE_ZERO = value -> Objects.nonNull(value) && !value.isNaN() && !value.isInfinite() && value > 0;

        boolean isCorrect(V value);
    }
}
