package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FlightFilter filter1 = new DepartingInThePastFlightFilter();
        FlightFilter filter2 = new DepartsBeforeArrivesFlightFilter();
        FlightFilter filter3 = new TwoHoursOnTheGroundFlightFilter();

        List<Flight> flights = FlightBuilder.createFlights();
        System.out.println("Тестовый набор:");
        flights.stream().forEach(System.out::println);
        System.out.println("---------------------------------------------------------------");
        System.out.println("Самолёты вылетевшие в прошлом:");
        flights.stream().filter(x-> filter1.flightFilter(x)).forEach(System.out::println);
        System.out.println("---------------------------------------------------------------");
        System.out.println("Самолёты, у которых есть сегмент, в котором прилёт раньше вылета");
        flights.stream().filter(x-> filter2.flightFilter(x)).forEach(System.out::println);
        System.out.println("---------------------------------------------------------------");
        System.out.println("Самолёты, которые пробыли на земле больше двух часов");
        flights.stream().filter(x-> filter3.flightFilter(x)).forEach(System.out::println);
        System.out.println("---------------------------------------------------------------");
        System.out.println("Полностью отфильтрованный тестовый набор");
        flights.stream().filter(x-> !filter1.flightFilter(x) && !filter2.flightFilter(x) && !filter3.flightFilter(x)).forEach(System.out::println);
    }
}
