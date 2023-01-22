package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        FlightListFilter flightListFilter = new FlightListFilter();
        List<Flight> filteredFlight;

        List<Flight> flights = FlightBuilder.createFlights();
        System.out.println("Тестовый набор:");
        flights.stream().forEach(System.out::println);

        System.out.println("---------------------------------------------------------------");
        System.out.println("Фильтр самолётов вылетевших в прошлом:");
        flightListFilter.setFlightFilter(new DepartingInThePastFlightFilter());
        filteredFlight = flightListFilter.filter(flights);
        for (Flight f:filteredFlight) {
            System.out.println(f);
        }

        System.out.println("---------------------------------------------------------------");
        System.out.println("Фильтр самолётов, у которых есть сегмент, в котором прилёт раньше вылета");
        flightListFilter.setFlightFilter(new DepartsBeforeArrivesFlightFilter());
        filteredFlight = flightListFilter.filter(flights);
        for (Flight f:filteredFlight) {
            System.out.println(f);
        }

        System.out.println("---------------------------------------------------------------");
        System.out.println("Фильтр самолётов, которые пробыли на земле больше двух часов");
        flightListFilter.setFlightFilter(new TwoHoursOnTheGroundFlightFilter());
        filteredFlight = flightListFilter.filter(flights);
        for (Flight f:filteredFlight) {
            System.out.println(f);
        }
        System.out.println("---------------------------------------------------------------");
    }
}
