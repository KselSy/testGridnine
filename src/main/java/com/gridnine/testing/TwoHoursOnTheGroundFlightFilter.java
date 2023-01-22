package com.gridnine.testing;

import com.gridnine.testing.exception.SegmentException;

import java.time.temporal.ChronoUnit;
import java.util.List;

//Класс для фильтрации полётов,
//общее время которых, проведённое на земле
//превышает два часа (время на земле — это
//интервал между прилётом одного сегмента и вылетом следующего за ним)
public class TwoHoursOnTheGroundFlightFilter implements FlightFilter {
    @Override
    public boolean filter(Flight flight){
        List<Segment> segments = flight.getSegments();
        long minutes = 0;
        if(segments.isEmpty())
            throw new SegmentException("Flight does not have any segment");
        for (int i = 0; i<segments.size()-1; i++){
            minutes += segments.get(i).getArrivalDate().until(segments.get(i+1).getDepartureDate(), ChronoUnit.MINUTES);
        }
        return !(minutes/60 >2);
    }
}
