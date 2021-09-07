package com.procamp.spacestation.SuppliesRepoImpl;

import com.procamp.spacestation.FunctionalInterfaces.MessageGenerator;
import com.procamp.spacestation.Repoes.SuppliesRepo;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import static com.procamp.spacestation.MessageUtils.MessageUtils.*;

public class SuppliesRepoImpl implements SuppliesRepo {
    private final Map<String, Integer> supplies = new HashMap<>();
    private final MessageGenerator logger = System.out::println;
    private final BiFunction<String, Integer, Integer> check = supplies::put;
    private final Predicate<String> contains = supplies::containsKey;

    @Override
    public void loadSupplies(String type, int quantity) {
        logger.print(SUPPLY_ACTION);
        logger.print(String.format(LOADING_SUPPLY, quantity, type));

        final Integer integer = contains.test(type)
                ? check.apply(type, supplies.get(type) + quantity)
                : check.apply(type, quantity);
    }

    @Override
    public void useSupplies(String type, int quantity) {
        logger.print(SUPPLY_ACTION);
        if(supplies.containsKey(type) && supplies.get(type)>quantity){
            logger.print(String.format(USE_SUPPLY, quantity, type));
            supplies.put(type, supplies.get(type) - quantity);
        } else {
            System.out.printf(SUPPLY_ERROR, type);
        }
    }

    @Override
    public void reportSupplies() {
        logger.print(SUPPLY_REPORT);
        if(supplies.keySet().toArray().length!=0){
            for (String type : supplies.keySet() ) {
                logger.print(String.format(AVAILABLE_SUPPLY, type, supplies.get(type)));
            }
        } else {
            System.out.println(NO_SUPPLY);
        }
    }
}
