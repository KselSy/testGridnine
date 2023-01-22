package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;

//Класс для фильтрации полётов, у которых
//вылет до текущего момента времени
public class DepartingInThePastFlightFilter implements FlightFilter {
    @Override
    public boolean flightFilter(Flight flight) {
        List<Segment> segments = flight.getSegments();
        if(segments.isEmpty())
            return false;
        if(segments.get(0).getDepartureDate().compareTo(LocalDateTime.now())<0)
            return true;
        return false;
    }
}
