package ru.michaelshell.http.service;

import ru.michaelshell.http.dao.FlightDao;
import ru.michaelshell.http.dto.FlightDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class FlightService {

    private static final FlightService INSTANCE = new FlightService();

    private final FlightDao flightDao = FlightDao.getInstance();

    private FlightService() {
    }

    public static FlightService getInstance() {
        return INSTANCE;
    }


    public List<FlightDto> findAll() {
        return flightDao.findAll().stream()
                .map(flight -> FlightDto.builder().id(flight.getId()).description(
                                "From: %s To: %s Status: %s\n".formatted(
                                        flight.getDepartureAirportCode(),
                                        flight.getArrivalAirportCode(),
                                        flight.getStatus()))
                        .build()
                )
                .collect(toList());
    }

}
