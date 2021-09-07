package com.procamp.spacestation;

import com.procamp.spacestation.FuelRepoImpl.FuelRepoImpl;
import com.procamp.spacestation.FunctionalInterfaces.SensorsActivation;
import com.procamp.spacestation.MessageUtils.MessageUtils;
import com.procamp.spacestation.Repoes.FuelRepo;
import com.procamp.spacestation.Repoes.SuppliesRepo;
import com.procamp.spacestation.SuppliesRepoImpl.SuppliesRepoImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpaceStationApplication {
    private static final FuelRepo fuel = new FuelRepoImpl();
    private static final SuppliesRepo supplies = new SuppliesRepoImpl();
    private static final SensorsActivation activation = () -> System.out.println(MessageUtils.ACTIVATION);

    public static void main(String[] args) {
        SpringApplication.run(SpaceStationApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void demoRunner() {
        supplies.loadSupplies("Coffee", 1);
        fuel.loadFuel(15);
        activation.runSensors();
        fuel.reportFuel();
        supplies.reportSupplies();
        fuel.activateThrusters();
    }
}
