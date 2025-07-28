package Projects.ParkingLot.model;

import Projects.ParkingLot.model.constants.ParkingLotStatus;
import Projects.ParkingLot.model.constants.VehicleType;

import java.util.List;

public class ParkingLot extends BaseModel{
    private String name;
    private String address;
    private List<ParkingFloor> parkingFloors;
    private ParkingLotStatus parkingLotStatus;
    private List<VehicleType> vehicleTypesSupported;
    private int capacity;

    public ParkingLot() {
    }

    public ParkingLot(String name, String address, List<ParkingFloor> parkingFloors, ParkingLotStatus parkingLotStatus, List<VehicleType> vehicleTypesSupported, int capacity) {
        this.name = name;
        this.address = address;
        this.parkingFloors = parkingFloors;
        this.parkingLotStatus = parkingLotStatus;
        this.vehicleTypesSupported = vehicleTypesSupported;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public List<VehicleType> getVehicleTypesSupported() {
        return vehicleTypesSupported;
    }

    public void setVehicleTypesSupported(List<VehicleType> vehicleTypesSupported) {
        this.vehicleTypesSupported = vehicleTypesSupported;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}

