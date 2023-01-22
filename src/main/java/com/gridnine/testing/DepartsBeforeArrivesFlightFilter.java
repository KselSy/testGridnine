package com.gridnine.testing;

import java.util.List;

//Класс для фильтрации полётов, у которых
//имеются сегменты с датой прилёта раньше даты вылета
public class DepartsBeforeArrivesFlightFilter implements FlightFilter {
    @Override
    public boolean flightFilter(Flight flight) {
        List<Segment> segments = flight.getSegments();
        if(segments.isEmpty())
            return false;
        return segments.stream().anyMatch(segment -> segment.getDepartureDate().compareTo(segment.getArrivalDate())>0);
    }
}
