package com.gridnine.testing;

import com.gridnine.testing.exception.SegmentException;

import java.time.LocalDateTime;
import java.util.List;

//Класс для фильтрации полётов, у которых
//вылет до текущего момента времени
public class DepartingInThePastFlightFilter implements FlightFilter {
    @Override
    public boolean filter(Flight flight) {
        List<Segment> segments = flight.getSegments();
        if(segments.isEmpty())
            throw new SegmentException("Flight does not have any segment");
        return !(segments.get(0).getDepartureDate().compareTo(LocalDateTime.now())<0);
    }
}
