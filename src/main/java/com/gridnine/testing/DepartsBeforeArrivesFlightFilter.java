package com.gridnine.testing;

import com.gridnine.testing.exception.SegmentException;

import java.util.List;

//Класс для фильтрации полётов, у которых
//имеются сегменты с датой прилёта раньше даты вылета
public class DepartsBeforeArrivesFlightFilter implements FlightFilter {
    @Override
    public boolean filter(Flight flight) {
        List<Segment> segments = flight.getSegments();
        if(segments.isEmpty())
            throw new SegmentException("Flight does not have any segment");
        return !(segments.stream().anyMatch(segment -> segment.getDepartureDate().compareTo(segment.getArrivalDate())>0));
    }
}
