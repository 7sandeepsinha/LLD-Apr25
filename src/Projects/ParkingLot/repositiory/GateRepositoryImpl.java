package Projects.ParkingLot.repositiory;

import Projects.ParkingLot.exception.ParkingLotNotFoundException;
import Projects.ParkingLot.model.Gate;
import Projects.ParkingLot.model.ParkingFloor;

import java.util.HashMap;
import java.util.Map;

public class GateRepositoryImpl implements GateRepository{
    private Map<Integer, Gate> gateMap;
    private static int idCounter = 1;

    public GateRepositoryImpl() {
        this.gateMap = new HashMap<>();
    }

    @Override
    public Gate get(int id) {
        Gate gate = gateMap.get(id);
        if(gate == null) {
            throw new ParkingLotNotFoundException("gate does not exist");
        }
        return gate;
    }

    @Override
    public void put(Gate gate) {
        gate.setId(idCounter++);
        gateMap.put(gate.getId(), gate);
        System.out.println("gate has been added successfully");
    }
}

//break -> 10:26 PM