package org.example;

/**
 * An economy-class vehicle with an optional hybrid engine.
 * Extends the abstract base class VehicleAbstract.
 */
public class EconomyVehicle extends VehicleAbstract {
    private static final double BASE_PRICE   = 50.0;
    private static final double HYBRID_FEE   = 10.0;

    private boolean hybrid;

    /**
     * Constructs an EconomyVehicle.
     *
     * @param brand         the vehicle brand (non-null, non-empty)
     * @param model         the vehicle model (non-null, non-empty)
     * @param licensePlate  the vehicle license plate (non-null, non-empty)
     * @param hybrid        whether the vehicle is a hybrid
     * @requires           brand, model, and licensePlate non-null, non-blank
     * @effects            initializes economy vehicle with hybrid flag
     * @throws NullPointerException if any String parameter is null
     * @throws IllegalArgumentException if any String parameter is blank
     */
    public EconomyVehicle(String brand, String model, String licensePlate,
                          boolean hybrid) {
        super(brand, model, licensePlate);
        this.hybrid = hybrid;
    }

    /**
     * {@inheritDoc}
     *
     * @requires           object fully constructed
     * @effects            returns BASE_PRICE plus HYBRID_FEE if hybrid
     * @return             total daily rental price (BASE_PRICE + optional hybrid fee)
     */
    @Override
    public double calculateDailyPrice() {
        return BASE_PRICE + (hybrid ? HYBRID_FEE : 0);
    }
}
