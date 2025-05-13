package org.example;


public class LuxuryVehicle extends VehicleAbstract {
    private static final double BASE_PRICE   = 100.0;
    private static final double GPS_FEE      = 20.0;
    private static final double LEATHER_FEE  = 30.0;

    private boolean gps;
    private boolean leatherSeats;

    /**
     * Constructs a LuxuryVehicle.
     *
     * @param brand         the vehicle brand (non-null, non-empty)
     * @param model         the vehicle model (non-null, non-empty)
     * @param licensePlate  the vehicle license plate (non-null, non-empty)
     * @param gps           whether GPS is included
     * @param leatherSeats  whether leather seats are included
     * @requires           brand, model, and licensePlate non-null, non-blank
     * @effects            initializes luxury vehicle with the given options
     * @throws NullPointerException if any String parameter is null
     * @throws IllegalArgumentException if any String parameter is blank
     */
    public LuxuryVehicle(String brand, String model, String licensePlate,
                         boolean gps, boolean leatherSeats) {
        super(brand, model, licensePlate);
        this.gps = gps;
        this.leatherSeats = leatherSeats;
    }

    /**
     *
     * @requires           object fully constructed
     * @effects            returns BASE_PRICE plus GPS_FEE if gps, plus LEATHER_FEE if leatherSeats
     * @return             total daily rental price (BASE_PRICE + optional fees)
     */
    @Override
    public double calculateDailyPrice() {
        double total = BASE_PRICE;
        if (gps)           total += GPS_FEE;
        if (leatherSeats)  total += LEATHER_FEE;
        return total;
    }
}
