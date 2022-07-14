package ru.michaelshell.http.service;

import ru.michaelshell.http.dao.TicketDao;
import ru.michaelshell.http.dto.TicketDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class TicketService {

    private static final TicketService INSTANCE = new TicketService();

    private final TicketDao ticketDao = TicketDao.getInstance();

    private TicketService() {}

    public static TicketService getInstance() {
        return INSTANCE;
    }

    public List<TicketDto> findAllByFlightId(Long flightId) {
        return ticketDao.findAllByFlightId(flightId).stream()
                .map(ticket -> TicketDto.builder()
                        .id(ticket.getId())
                        .flightId(ticket.getFlightId())
                        .seatNo(ticket.getSeatNo())
                        .build()
                )
                .collect(toList());
    }

}
