package com.gridnine.testing;

import com.gridnine.testing.exception.SegmentException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class FlightFilterTest {
    private List<Flight> flights;
    private FlightListFilter flightFilter;
    List<Flight> actualFlightList;
    List<Flight> expectedFlightList;
    List<Flight> emptyFlight;

    @Before
    public void setUp(){
        emptyFlight = FlightBuilder.createEmptyFlight();
        flights = FlightBuilder.createFlights();
    }


    @Test
    public void shouldFilterDepartBeforeArrives(){
        flightFilter = new FlightListFilter(new DepartsBeforeArrivesFlightFilter());
        actualFlightList = flightFilter.filter(flights);
        expectedFlightList = FlightBuilder.createFlightsWithOutFlightThatDepartsBeforeItArrives();

        Assert.assertEquals(expectedFlightList.toString(), actualFlightList.toString());

    }

    @Test
    public void shouldFilterTwoHoursOnTheGround(){
        flightFilter = new FlightListFilter(new TwoHoursOnTheGroundFlightFilter());
        actualFlightList = flightFilter.filter(flights);
        expectedFlightList = FlightBuilder.createFlightsWithOutFlightWithMoreThanTwoHoursGroundTime();

        Assert.assertEquals(expectedFlightList.toString(), actualFlightList.toString());
    }

    @Test
    public void shouldFilterDepartingInThePastFlightFilter(){
        flightFilter = new FlightListFilter(new DepartingInThePastFlightFilter());
        actualFlightList = flightFilter.filter(flights);
        expectedFlightList = FlightBuilder.createFlightsWithOutFlightDepartingInThePast();

        Assert.assertEquals(expectedFlightList.toString(), actualFlightList.toString());
    }

    @Test(expected = SegmentException.class)
    public void shouldThrowExceptionDepartingInThePastFlightFilter(){
        flightFilter = new FlightListFilter(new DepartingInThePastFlightFilter());
        flightFilter.filter(emptyFlight);
    }

    @Test(expected = SegmentException.class)
    public void shouldThrowExceptionTwoHoursOnTheGroundFlightFilter(){
        flightFilter = new FlightListFilter(new TwoHoursOnTheGroundFlightFilter());
        flightFilter.filter(emptyFlight);
    }

    @Test(expected = SegmentException.class)
    public void shouldThrowExceptionDepartsBeforeArrivesFlightFilter(){
        flightFilter = new FlightListFilter(new DepartsBeforeArrivesFlightFilter());
        flightFilter.filter(emptyFlight);
    }


}
