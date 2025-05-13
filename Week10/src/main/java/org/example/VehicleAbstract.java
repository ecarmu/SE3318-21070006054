package org.example;


import java.util.Objects;


public abstract class VehicleAbstract {
    /** Brand of the vehicle (non-null, non-empty). */
    protected String brand;
    /** Model of the vehicle (non-null, non-empty). */
    protected String model;
    /** License plate of the vehicle (non-null, non-empty). */
    protected String licensePlate;

    /**
     * Constructs a VehicleAbstract instance.
     *
     * @param brand         the vehicle brand
     * @param model         the vehicle model
     * @param licensePlate  the vehicle license plate
     * @requires           brand, model, and licensePlate are non-null and not blank
     * @effects            initializes this.vehicle with the given brand, model, and licensePlate
     * @throws NullPointerException if any parameter is null
     * @throws IllegalArgumentException if any parameter is blank
     */
    public VehicleAbstract(String brand, String model, String licensePlate) {
        this.brand = Objects.requireNonNull(brand, "brand must not be null");
        this.model = Objects.requireNonNull(model, "model must not be null");
        this.licensePlate = Objects.requireNonNull(licensePlate, "licensePlate must not be null");
        if (brand.isBlank() || model.isBlank() || licensePlate.isBlank()) {
            throw new IllegalArgumentException("brand, model, and licensePlate must not be blank");
        }
    }

    /**
     * Calculates the daily rental price based on the vehicle type and features.
     *
     * @requires           subclass state fully initialized
     * @effects            computes and returns the daily rental price
     * @return             the daily rental price in USD (≥ 0)
     */
    public abstract double calculateDailyPrice();

    // getters omitted for brevity; you can add similar @requires/@effects if needed
}