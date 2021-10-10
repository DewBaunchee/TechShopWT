package by.varyvoda.matvey.entity.criteria;

import by.varyvoda.matvey.entity.Laptop;
import by.varyvoda.matvey.entity.Oven;
import by.varyvoda.matvey.entity.VacuumCleaner;

import java.util.Objects;

/**
 * @author Matvey Varyvoda
 * @since 09.10.2021
 * */
public final class SearchCriteria {

    public static abstract class Criteria<V> {

        private final IComparer comparer;
        private final IValueValidator<V> valueValidator;

        private Criteria(IComparer comparer, IValueValidator<V> valueValidator) {
            this.comparer = comparer;
            this.valueValidator = valueValidator;
        }

        public IComparer getComparer() {
            return comparer;
        }

        public IValueValidator<V> getValueValidator() {
            return valueValidator;
        }
    }

    public static class OvenCriteria<V> extends Criteria<V> {

        public static final OvenCriteria<Integer> POWER_CONSUMPTION = new OvenCriteria<>(
                (oven, value) -> Objects.equals(((Oven) oven).getPowerConsumption(), value),
                IValueValidator.INTEGER_ABOVE_ZERO
        );

        public static final OvenCriteria<Integer> WEIGHT = new OvenCriteria<>(
                (oven, value) -> Objects.equals(((Oven) oven).getWeight(), value),
                IValueValidator.INTEGER_ABOVE_ZERO
        );

        public static final OvenCriteria<Integer> CAPACITY = new OvenCriteria<>(
                (oven, value) -> Objects.equals(((Oven) oven).getCapacity(), value),
                IValueValidator.INTEGER_ABOVE_ZERO
        );

        public static final OvenCriteria<Integer> DEPTH = new OvenCriteria<>(
                (oven, value) -> Objects.equals(((Oven) oven).getDepth(), value),
                IValueValidator.INTEGER_ABOVE_ZERO
        );

        public static final OvenCriteria<Double> HEIGHT = new OvenCriteria<>(
                (oven, value) -> Objects.equals(((Oven) oven).getHeight(), value),
                IValueValidator.DOUBLE_ABOVE_ZERO
        );

        public static final OvenCriteria<Double> WIDTH = new OvenCriteria<>(
                (oven, value) -> Objects.equals(((Oven) oven).getWidth(), value),
                IValueValidator.DOUBLE_ABOVE_ZERO
        );

        private OvenCriteria(IComparer comparer, IValueValidator<V> valueValidator) {
            super(comparer, valueValidator);
        }
    }

    public static class LaptopCriteria<V> extends Criteria<V> {

        public static final LaptopCriteria<Double> BATTERY_CAPACITY = new LaptopCriteria<>(
                (laptop, value) -> Objects.equals(((Laptop) laptop).getBatteryCapacity(), value),
                IValueValidator.DOUBLE_ABOVE_ZERO
        );

        public static final LaptopCriteria<Laptop.OperatingSystem> OS = new LaptopCriteria<>(
                (laptop, value) -> ((Laptop) laptop).getOperatingSystem() == value,
                Objects::nonNull
        );

        public static final LaptopCriteria<Integer> MEMORY_ROM = new LaptopCriteria<>(
                (laptop, value) -> Objects.equals(((Laptop) laptop).getMemoryRom(), value),
                IValueValidator.INTEGER_ABOVE_ZERO
        );

        public static final LaptopCriteria<Integer> SYSTEM_MEMORY = new LaptopCriteria<>(
                (laptop, value) -> Objects.equals(((Laptop) laptop).getSystemMemory(), value),
                IValueValidator.INTEGER_ABOVE_ZERO
        );

        public static final LaptopCriteria<Double> CPU = new LaptopCriteria<>(
                (laptop, value) -> Objects.equals(((Laptop) laptop).getCpu(), value),
                IValueValidator.DOUBLE_ABOVE_ZERO
        );

        public static final LaptopCriteria<Integer> DISPLAY_INCHES = new LaptopCriteria<>(
                (laptop, value) -> Objects.equals(((Laptop) laptop).getDisplayInches(), value),
                IValueValidator.INTEGER_ABOVE_ZERO
        );

        private LaptopCriteria(IComparer comparer, IValueValidator<V> valueValidator) {
            super(comparer, valueValidator);
        }
    }

    public static class VacuumCleanerCriteria<V> extends Criteria<V> {

        public static final VacuumCleanerCriteria<Integer> POWER_CONSUMPTION = new VacuumCleanerCriteria<>(
                (vacuumCleaner, value) -> Objects.equals(((VacuumCleaner) vacuumCleaner).getPowerConsumption(), value),
                IValueValidator.INTEGER_ABOVE_ZERO
        );

        public static final VacuumCleanerCriteria<VacuumCleaner.FilterType> FILTER_TYPE = new VacuumCleanerCriteria<>(
                (vacuumCleaner, value) -> ((VacuumCleaner) vacuumCleaner).getFilterType() == value,
                Objects::nonNull
        );

        public static final VacuumCleanerCriteria<VacuumCleaner.BagType> BAG_TYPE = new VacuumCleanerCriteria<>(
                (vacuumCleaner, value) -> ((VacuumCleaner) vacuumCleaner).getBagType() == value,
                Objects::nonNull
        );

        public static final VacuumCleanerCriteria<VacuumCleaner.WandType> WAND_TYPE = new VacuumCleanerCriteria<>(
                (vacuumCleaner, value) -> ((VacuumCleaner) vacuumCleaner).getWandType() == value,
                Objects::nonNull
        );

        public static final VacuumCleanerCriteria<Integer> MOTOR_SPEED_REGULATION = new VacuumCleanerCriteria<>(
                (vacuumCleaner, value) -> Objects.equals(((VacuumCleaner) vacuumCleaner).getMotorSpeedRegulation(), value),
                IValueValidator.INTEGER_ABOVE_ZERO
        );

        public static final VacuumCleanerCriteria<Integer> CLEANING_WIDTH = new VacuumCleanerCriteria<>(
                (vacuumCleaner, value) -> Objects.equals(((VacuumCleaner) vacuumCleaner).getCleaningWidth(), value),
                IValueValidator.INTEGER_ABOVE_ZERO
        );

        private VacuumCleanerCriteria(IComparer comparer, IValueValidator<V> valueValidator) {
            super(comparer, valueValidator);
        }
    }

    private SearchCriteria() {
    }

    public interface IComparer {
        boolean isSuitable(Object entity, Object value);
    }

    public interface IValueValidator<V> {

        IValueValidator<Integer> INTEGER_ABOVE_ZERO = value -> Objects.nonNull(value) && value > 0;
        IValueValidator<Double> DOUBLE_ABOVE_ZERO = value -> Objects.nonNull(value) && !value.isNaN() && !value.isInfinite() && value > 0;

        boolean isCorrect(V value);
    }
}
