package ru.michaelshell.http.dao;

import ru.michaelshell.http.entity.Flight;
import ru.michaelshell.http.entity.FlightStatus;
import ru.michaelshell.http.util.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlightDao implements Dao<Long, Flight> {

    private static final FlightDao INSTANCE = new FlightDao();

    private static final String FIND_ALL_SQL = """
            SELECT id,
            flight_no,
            departure_date,
            departure_airport_code,
            arrival_date,
            arrival_airport_code,
            aircraft_id,
            status
            FROM flight
            """;

    private FlightDao() {
    }

    public static FlightDao getInstance() {
        return INSTANCE;
    }

    @Override
    public List<Flight> findAll() {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_ALL_SQL)) {
            List<Flight> flights = new ArrayList<>();
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                flights.add(buildFlight(resultSet));
            }
            return flights;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Optional<Flight> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Flight save(Flight entity) {
        return null;
    }

    @Override
    public void update(Flight entity) {

    }



    private Flight buildFlight(ResultSet resultSet) throws SQLException {
        return new Flight(
                resultSet.getObject("id", Long.class),
                resultSet.getObject("flight_no", String.class),
                resultSet.getObject("departure_date", Timestamp.class).toLocalDateTime(),
                resultSet.getObject("departure_airport_code", String.class),
                resultSet.getObject("arrival_date", Timestamp.class).toLocalDateTime(),
                resultSet.getObject("arrival_airport_code", String.class),
                resultSet.getObject("aircraft_id", Integer.class),
                FlightStatus.valueOf(resultSet.getObject("status", String.class))
        );
    }
}
