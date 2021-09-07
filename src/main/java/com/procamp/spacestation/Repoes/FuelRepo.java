package com.procamp.spacestation.Repoes;

public interface FuelRepo {
    void loadFuel(int quantity);

    void reportFuel();

    void activateThrusters();
}
