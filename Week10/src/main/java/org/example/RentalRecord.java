package org.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;


public class RentalRecord {
    private VehicleAbstract vehicle;
    private String customerId;
    private LocalDate startDate;
    private LocalDate endDate;

    /**
     * Constructs a RentalRecord.
     *
     * @param vehicle     the rented vehicle (non-null)
     * @param customerId  the unique ID of the customer (non-null, non-empty)
     * @param startDate   rental start date (non-null)
     * @param endDate     rental end date (non-null, ≥ startDate)
     * @requires          vehicle and dates non-null; customerId non-blank; endDate ≥ startDate
     * @effects           initializes a rental record for the given period
     * @throws NullPointerException      if vehicle, customerId, startDate, or endDate is null
     * @throws IllegalArgumentException  if customerId is blank or endDate is before startDate
     */
    public RentalRecord(VehicleAbstract vehicle,
                        String customerId,
                        LocalDate startDate,
                        LocalDate endDate) {
        this.vehicle    = Objects.requireNonNull(vehicle, "vehicle must not be null");
        this.customerId = Objects.requireNonNull(customerId, "customerId must not be null");
        this.startDate  = Objects.requireNonNull(startDate, "startDate must not be null");
        this.endDate    = Objects.requireNonNull(endDate, "endDate must not be null");
        if (customerId.isBlank()) {
            throw new IllegalArgumentException("customerId must not be blank");
        }
        if (endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("endDate must be on or after startDate");
        }
    }

    /**
     * Calculates the number of rental days, inclusive of both start and end dates.
     *
     * @requires           startDate and endDate non-null and startDate ≤ endDate
     * @effects            computes the total days of rental
     * @return             total rental period in days (≥ 1)
     */
    public long getRentalDays() {
        return ChronoUnit.DAYS.between(startDate, endDate) + 1;
    }

    /**
     * Calculates the total price for the entire rental period.
     *
     * @requires           vehicle non-null; startDate and endDate set correctly
     * @effects            multiplies daily price by number of days
     * @return             total rental price in USD (≥ 0)
     */
    public double calculateTotalPrice() {
        return vehicle.calculateDailyPrice() * getRentalDays();
    }

    // getters/setters can be added here, each with @requires/@effects as needed
}
