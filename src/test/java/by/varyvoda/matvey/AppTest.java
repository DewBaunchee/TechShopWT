package by.varyvoda.matvey;

import by.varyvoda.matvey.dao.DaoFactory;
import by.varyvoda.matvey.entity.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }

    public void testFillSource() {
        fillLaptops();
        fillOvens();
        fillRefrigerator();
        fillSpeakers();
        fillTabletsPC();
        fillVacuumCleaners();
    }

    private void fillLaptops() {
        Laptop laptop1 = new Laptop();
        laptop1.setPrice(1);
        laptop1.setBatteryCapacity(1.0);
        laptop1.setOperatingSystem(Laptop.OperatingSystem.WINDOWS);
        laptop1.setMemoryRom(4000);
        laptop1.setSystemMemory(1000);
        laptop1.setCpu(1.2);
        laptop1.setDisplayInches(18);
        DaoFactory.getInstance().getApplianceDao().save(laptop1);
        Laptop laptop2 = new Laptop();
        laptop2.setPrice(1);
        laptop2.setBatteryCapacity(1.5);
        laptop2.setOperatingSystem(Laptop.OperatingSystem.LINUX);
        laptop2.setMemoryRom(8000);
        laptop2.setSystemMemory(1000);
        laptop2.setCpu(2.2);
        laptop2.setDisplayInches(19);
        DaoFactory.getInstance().getApplianceDao().save(laptop2);
        Laptop laptop3 = new Laptop();
        laptop3.setPrice(1);
        laptop3.setBatteryCapacity(3.0);
        laptop3.setOperatingSystem(Laptop.OperatingSystem.WINDOWS);
        laptop3.setMemoryRom(8000);
        laptop3.setSystemMemory(1500);
        laptop3.setCpu(3.2);
        laptop3.setDisplayInches(22);
        DaoFactory.getInstance().getApplianceDao().save(laptop3);
    }

    private void fillOvens() {
        Oven oven1 = new Oven();
        oven1.setPrice(1);
        oven1.setPowerConsumption(1000);
        oven1.setWeight(10);
        oven1.setCapacity(32);
        oven1.setDepth(60);
        oven1.setHeight(45.5);
        oven1.setWidth(59.5);
        DaoFactory.getInstance().getApplianceDao().save(oven1);
        Oven oven2 = new Oven();
        oven2.setPrice(1);
        oven2.setPowerConsumption(1500);
        oven2.setWeight(12);
        oven2.setCapacity(33);
        oven2.setDepth(60);
        oven2.setHeight(45.0);
        oven2.setWidth(68.0);
        DaoFactory.getInstance().getApplianceDao().save(oven2);
        Oven oven3 = new Oven();
        oven3.setPrice(1);
        oven3.setPowerConsumption(2000);
        oven3.setWeight(11);
        oven3.setCapacity(33);
        oven3.setDepth(60);
        oven3.setHeight(40.0);
        oven3.setWidth(70.0);
        DaoFactory.getInstance().getApplianceDao().save(oven3);
    }

    private void fillRefrigerator() {
        Refrigerator refrigerator1 = new Refrigerator();
        refrigerator1.setPrice(1);
        refrigerator1.setPowerConsumption(100);
        refrigerator1.setWeight(20);
        refrigerator1.setFreezerCapacity(10);
        refrigerator1.setOverallCapacity(300.0);
        refrigerator1.setHeight(200);
        refrigerator1.setWidth(70);
        DaoFactory.getInstance().getApplianceDao().save(refrigerator1);
        Refrigerator refrigerator2 = new Refrigerator();
        refrigerator2.setPrice(1);
        refrigerator2.setPowerConsumption(200);
        refrigerator2.setWeight(30);
        refrigerator2.setFreezerCapacity(15);
        refrigerator2.setOverallCapacity(300.0);
        refrigerator2.setHeight(180);
        refrigerator2.setWidth(80);
        DaoFactory.getInstance().getApplianceDao().save(refrigerator2);
        Refrigerator refrigerator3 = new Refrigerator();
        refrigerator3.setPrice(1);
        refrigerator3.setPowerConsumption(150);
        refrigerator3.setWeight(35);
        refrigerator3.setFreezerCapacity(20);
        refrigerator3.setOverallCapacity(350.5);
        refrigerator3.setHeight(250);
        refrigerator3.setWidth(75);
        DaoFactory.getInstance().getApplianceDao().save(refrigerator3);
    }

    private void fillSpeakers () {
        Speakers speakers1 = new Speakers();
        speakers1.setPrice(1);
        speakers1.setPowerConsumption(15);
        speakers1.setNumberOfSpeakers(2);
        speakers1.setFrequencyFrom(2.0);
        speakers1.setFrequencyTo(4.0);
        speakers1.setCordLength(2);
        DaoFactory.getInstance().getApplianceDao().save(speakers1);
        Speakers speakers2 = new Speakers();
        speakers2.setPrice(1);
        speakers2.setPowerConsumption(20);
        speakers2.setNumberOfSpeakers(3);
        speakers2.setFrequencyFrom(3.0);
        speakers2.setFrequencyTo(4.0);
        speakers2.setCordLength(3);
        DaoFactory.getInstance().getApplianceDao().save(speakers2);
        Speakers speakers3 = new Speakers();
        speakers3.setPrice(1);
        speakers3.setPowerConsumption(17);
        speakers3.setNumberOfSpeakers(4);
        speakers3.setFrequencyFrom(2.0);
        speakers3.setFrequencyTo(3.5);
        speakers3.setCordLength(4);
        DaoFactory.getInstance().getApplianceDao().save(speakers3);
    }

    private void fillTabletsPC() {
        TabletPC tabletPC1 = new TabletPC();
        tabletPC1.setPrice(1);
        tabletPC1.setBatteryCapacity(3);
        tabletPC1.setDisplayInches(14);
        tabletPC1.setMemoryRom(8000);
        tabletPC1.setFlashMemoryCapacity(2);
        tabletPC1.setColor(TabletPC.Color.BLUE);
        DaoFactory.getInstance().getApplianceDao().save(tabletPC1);
        TabletPC tabletPC2 = new TabletPC();
        tabletPC2.setPrice(1);
        tabletPC2.setBatteryCapacity(4);
        tabletPC2.setDisplayInches(15);
        tabletPC2.setMemoryRom(8000);
        tabletPC2.setFlashMemoryCapacity(6);
        tabletPC2.setColor(TabletPC.Color.RED);
        DaoFactory.getInstance().getApplianceDao().save(tabletPC2);
        TabletPC tabletPC3 = new TabletPC();
        tabletPC3.setPrice(1);
        tabletPC3.setBatteryCapacity(5);
        tabletPC3.setDisplayInches(16);
        tabletPC3.setMemoryRom(16000);
        tabletPC3.setFlashMemoryCapacity(8);
        tabletPC3.setColor(TabletPC.Color.GREEN);
        DaoFactory.getInstance().getApplianceDao().save(tabletPC3);
    }

    private void fillVacuumCleaners() {
        VacuumCleaner vacuumCleaner1 = new VacuumCleaner();
        vacuumCleaner1.setPrice(1);
        vacuumCleaner1.setPowerConsumption(100);
        vacuumCleaner1.setFilterType(VacuumCleaner.FilterType.A);
        vacuumCleaner1.setBagType(VacuumCleaner.BagType.A2);
        vacuumCleaner1.setWandType(VacuumCleaner.WandType.ALL_IN_ONE);
        vacuumCleaner1.setMotorSpeedRegulation(3000);
        vacuumCleaner1.setCleaningWidth(20);
        DaoFactory.getInstance().getApplianceDao().save(vacuumCleaner1);
        VacuumCleaner vacuumCleaner2 = new VacuumCleaner();
        vacuumCleaner2.setPrice(1);
        vacuumCleaner2.setPowerConsumption(110);
        vacuumCleaner2.setFilterType(VacuumCleaner.FilterType.B);
        vacuumCleaner2.setBagType(VacuumCleaner.BagType.AA_89);
        vacuumCleaner2.setWandType(VacuumCleaner.WandType.ALL_IN_ONE);
        vacuumCleaner2.setMotorSpeedRegulation(2900);
        vacuumCleaner2.setCleaningWidth(25);
        DaoFactory.getInstance().getApplianceDao().save(vacuumCleaner2);
        VacuumCleaner vacuumCleaner3 = new VacuumCleaner();
        vacuumCleaner3.setPrice(1);
        vacuumCleaner3.setPowerConsumption(90);
        vacuumCleaner3.setFilterType(VacuumCleaner.FilterType.C);
        vacuumCleaner3.setBagType(VacuumCleaner.BagType.XX00);
        vacuumCleaner3.setWandType(VacuumCleaner.WandType.ALL_IN_ONE);
        vacuumCleaner3.setMotorSpeedRegulation(2950);
        vacuumCleaner3.setCleaningWidth(30);
        DaoFactory.getInstance().getApplianceDao().save(vacuumCleaner3);
    }
}
