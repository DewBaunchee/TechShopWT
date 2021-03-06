package by.varyvoda.matvey;

import by.varyvoda.matvey.entity.Appliance;
import by.varyvoda.matvey.entity.Laptop;
import by.varyvoda.matvey.entity.Oven;
import by.varyvoda.matvey.entity.VacuumCleaner;
import by.varyvoda.matvey.entity.criteria.Query;
import by.varyvoda.matvey.entity.criteria.SearchCriteria;
import by.varyvoda.matvey.main.PrintApplianceInfo;
import by.varyvoda.matvey.service.ServiceFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class AppTest {

    /**
     * Filling XML-file with appliances:
     * 3 laptops,
     * 3 ovens,
     * 3 vacuum cleaners.
     */
    @BeforeClass
    public static void beforeAll() {
        try {
            System.out.println("Filling source: ");
            Files.write(Path.of("appliances.xml"), new byte[0]);
            fillLaptops();
            fillOvens();
            fillVacuumCleaners();
            List<Appliance> appliances = ServiceFactory
                    .getInstance()
                    .getApplianceService()
                    .get(new Query<>(Appliance.class));
            appliances.forEach(PrintApplianceInfo::print);
            assertEquals(9, appliances.size());
        } catch (IOException ignored) {

        }
    }

    /**
     * Searching ovens which power consumption equals to 1000
     */
    @Test
    public void testGetOvensByPowerConsumption() {
        System.out.println("Ovens with power consumption = 1000:");
        List<Appliance> appliances = ServiceFactory.getInstance().getApplianceService().get(
                new Query<Appliance>(Oven.class)
                        .add(SearchCriteria.OvenCriteria.POWER_CONSUMPTION, 1000)
        );
        appliances.forEach(PrintApplianceInfo::print);
        assertEquals(Integer.valueOf(1000), ((Oven) appliances.get(0)).getPowerConsumption());
    }

    /**
     * Getting all ovens in source
     */
    @Test
    public void testAllOvens() {
        System.out.println("Test all ovens:");
        List<Appliance> appliances = ServiceFactory
                .getInstance()
                .getApplianceService()
                .get(new Query<>(Oven.class));
        appliances.forEach(PrintApplianceInfo::print);
        assertEquals(3, appliances.size());
    }

    /**
     * Getting the cheapest appliance
     */
    @Test
    public void testCheapest() {
        System.out.println("Test cheapest:");
        Appliance appliance = ServiceFactory
                .getInstance()
                .getApplianceService()
                .getCheapest();
        PrintApplianceInfo.print(appliance);
        assertEquals(Integer.valueOf(1), appliance.getPrice());
    }

    private static void fillLaptops() {
        Laptop laptop1 = new Laptop();
        laptop1.setPrice(6);
        laptop1.setBatteryCapacity(1.0);
        laptop1.setOperatingSystem(Laptop.OperatingSystem.WINDOWS);
        laptop1.setMemoryRom(4000);
        laptop1.setSystemMemory(1000);
        laptop1.setCpu(1.2);
        laptop1.setDisplayInches(18);
        ServiceFactory.getInstance().getApplianceService().save(laptop1);
        Laptop laptop2 = new Laptop();
        laptop2.setPrice(1);
        laptop2.setBatteryCapacity(1.5);
        laptop2.setOperatingSystem(Laptop.OperatingSystem.LINUX);
        laptop2.setMemoryRom(8000);
        laptop2.setSystemMemory(1000);
        laptop2.setCpu(2.2);
        laptop2.setDisplayInches(19);
        ServiceFactory.getInstance().getApplianceService().save(laptop2);
        Laptop laptop3 = new Laptop();
        laptop3.setPrice(11);
        laptop3.setBatteryCapacity(3.0);
        laptop3.setOperatingSystem(Laptop.OperatingSystem.WINDOWS);
        laptop3.setMemoryRom(8000);
        laptop3.setSystemMemory(1500);
        laptop3.setCpu(3.2);
        laptop3.setDisplayInches(22);
        ServiceFactory.getInstance().getApplianceService().save(laptop3);
    }

    private static void fillOvens() {
        Oven oven1 = new Oven();
        oven1.setPrice(61);
        oven1.setPowerConsumption(1000);
        oven1.setWeight(10);
        oven1.setCapacity(32);
        oven1.setDepth(60);
        oven1.setHeight(45.5);
        oven1.setWidth(59.5);
        ServiceFactory.getInstance().getApplianceService().save(oven1);
        Oven oven2 = new Oven();
        oven2.setPrice(12);
        oven2.setPowerConsumption(1500);
        oven2.setWeight(12);
        oven2.setCapacity(33);
        oven2.setDepth(60);
        oven2.setHeight(45.0);
        oven2.setWidth(68.0);
        ServiceFactory.getInstance().getApplianceService().save(oven2);
        Oven oven3 = new Oven();
        oven3.setPrice(13);
        oven3.setPowerConsumption(2000);
        oven3.setWeight(11);
        oven3.setCapacity(33);
        oven3.setDepth(60);
        oven3.setHeight(40.0);
        oven3.setWidth(70.0);
        ServiceFactory.getInstance().getApplianceService().save(oven3);
    }

    private static void fillVacuumCleaners() {
        VacuumCleaner vacuumCleaner1 = new VacuumCleaner();
        vacuumCleaner1.setPrice(14);
        vacuumCleaner1.setPowerConsumption(100);
        vacuumCleaner1.setFilterType(VacuumCleaner.FilterType.A);
        vacuumCleaner1.setBagType(VacuumCleaner.BagType.A2);
        vacuumCleaner1.setWandType(VacuumCleaner.WandType.ALL_IN_ONE);
        vacuumCleaner1.setMotorSpeedRegulation(3000);
        vacuumCleaner1.setCleaningWidth(20);
        ServiceFactory.getInstance().getApplianceService().save(vacuumCleaner1);
        VacuumCleaner vacuumCleaner2 = new VacuumCleaner();
        vacuumCleaner2.setPrice(15);
        vacuumCleaner2.setPowerConsumption(110);
        vacuumCleaner2.setFilterType(VacuumCleaner.FilterType.B);
        vacuumCleaner2.setBagType(VacuumCleaner.BagType.AA_89);
        vacuumCleaner2.setWandType(VacuumCleaner.WandType.ALL_IN_ONE);
        vacuumCleaner2.setMotorSpeedRegulation(2900);
        vacuumCleaner2.setCleaningWidth(25);
        ServiceFactory.getInstance().getApplianceService().save(vacuumCleaner2);
        VacuumCleaner vacuumCleaner3 = new VacuumCleaner();
        vacuumCleaner3.setPrice(18);
        vacuumCleaner3.setPowerConsumption(90);
        vacuumCleaner3.setFilterType(VacuumCleaner.FilterType.C);
        vacuumCleaner3.setBagType(VacuumCleaner.BagType.XX00);
        vacuumCleaner3.setWandType(VacuumCleaner.WandType.ALL_IN_ONE);
        vacuumCleaner3.setMotorSpeedRegulation(2950);
        vacuumCleaner3.setCleaningWidth(30);
        ServiceFactory.getInstance().getApplianceService().save(vacuumCleaner3);
    }
}
