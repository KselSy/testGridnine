package com.gridnine.testing;

import java.util.List;

//Класс для фильтрации списка полётов
public class FlightListFilter {
    private FlightFilter flightFilter;

    public FlightListFilter(FlightFilter flightFilter) {
        this.flightFilter = flightFilter;
    }

    public FlightListFilter() {
    }

    public List<Flight> filter(List<Flight> flights){
        return flights.stream().filter(x-> flightFilter.filter(x)).toList();
    }

    public void setFlightFilter(FlightFilter flightFilter) {
        this.flightFilter = flightFilter;
    }
}
