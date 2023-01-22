package com.gridnine.testing;

import java.util.List;

//Класс для фильтрации списка полётов
public class FlightListFilter {
    public static List<Flight> flightFilter(List<Flight> flights, FlightFilter filter){
        return flights.stream().filter(x-> filter.flightFilter(x)).toList();
    }
}
