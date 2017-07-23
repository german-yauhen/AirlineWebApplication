package by.pvt.hermanovich.airline.constants;

/**
 * Description:
 * Created by Yauheni Hermanovich on 11.07.2017.
 */
public class QueriesDB {
    /*Queries to work with users database table.*/
    public static final String CHECK_AUTHORIZATION = "SELECT login, password FROM users WHERE login = ? AND password = ?";
    public static final String GET_USER_BY_LOGIN = "SELECT * FROM users WHERE login = ?";
    public static final String GET_USER_BY_ID = "SELECT * FROM users WHERE id = ?";
//    public static final String ADD_USER = "INSERT INTO users (firstname, surname, document_number, login, password, user_type)" +
//            "VALUES (?, ?, ?, ?, ?, ?)";
    public static final String ADD_USER_WITHOUT_USERTYPE = "INSERT INTO users (firstname, surname, document_number, login, password)" +
                                                            "VALUES (?, ?, ?, ?, ?)";
    public static final String DELETE_USER_BY_ID = "DELETE FROM users WHERE id = ?";
    public static final String UPDATE_USER_BY_ID = "UPDATE users SET firstname = ?, surname = ?, document_number = ?," +
                                                    "login = ?, password = ?, user_type = ?  WHERE id = ?";
    public static final String GET_ALL_USERS = "SELECT * FROM users";
    /*Queries to work with airports database table.*/
    public static final String ADD_AIRPORT = "INSERT INTO airports (airport_code, airport_name, city) VALUES (?, ?, ?)";
    public static final String UPDATE_AIRPORT = "UPDATE airports SET airport_name = ?, city = ? WHERE airport_code = ?";
    public static final String DELETE_AIRPORT_BY_CODE = "DELETE FROM airports WHERE airport_code = ?";
    public static final String GET_AIRPORT_BY_CODE = "SELECT * FROM airports WHERE airport_code = ?";
    public static final String GET_ALL_AIRPORTS = "SELECT * FROM airports";
    /*Queries to work with luggage database table.*/
    public static final String GET_LUGGAGE_BY_ID = "SELECT * FROM luggage WHERE id = ?";
    public static final String ADD_LUGGAGE = "INSERT INTO luggage (luggage_type, price) VALUES (?, ?)";
    public static final String UPDATE_LUGGAGE = "UPDATE luggage SET luggage_type = ?, price = ? WHERE id = ?";
    public static final String GET_LUGGAGE_BY_TYPE = "SELECT * FROM luggage WHERE luggage_type = ?";
    public static final String GET_ALL_LUGGAGE_TYPES = "SELECT * FROM luggage";
    public static final String DELETE_LUGGAGE_BY_ID = "DELETE FROM luggage WHERE id = ?";
    /*Queries to work with aircraft database table.*/
    public static final String ADD_AIRCRAFT = "INSERT INTO aircrafts (aircraft_code, model) VALUES (?, ?)";
    public static final String UPDATE_AIRCRAFT = "UPDATE aircrafts SET model = ? WHERE aircraft_code = ?";
    public static final String GET_ALL_AIRCRAFTS = "SELECT * FROM aircrafts";
    public static final String GET_AIRCRAFT_BY_CODE = "SELECT * FROM aircrafts WHERE aircraft_code = ?";
    public static final String DELETE_AIRCRAFT_BY_CODE = "DELETE FROM aircrafts WHERE aircraft_code = ?";
    /*Queries to work with flight database table.*/
    public static final String GET_FLIGHT_BY_ID = "SELECT * FROM flights WHERE id = ?";
    public static final String ADD_FLIGHT = "INSERT INTO flights (aircrafts_aircraft_code, flight_number, departure_airport" +
                                            ", arrival_airport, sheduled_departure_date, sheduled_arrival_date, price_per_seat)" +
                                            "VALUES(?, ?, ?, ?, ?, ?, ?)";
    public static final String GET_FLIGHTS_BY_DEP_ARR_DATE = "SELECT * FROM flights WHERE departure_airport = ? AND arrival_airport = ? AND sheduled_departure_date = ?";
    public static final String GET_FLIGHTS_BY_DEP_ARR = "SELECT * FROM flights WHERE departure_airport = ? AND arrival_airport = ?";
    public static final String GET_FLIGHTS_BY_DEP_DATE = "SELECT * FROM flights WHERE departure_airport = ? AND sheduled_departure_date = ?";


    /*Queries to work with tickets database table.*/
//    public static final String ADD_TICKET = "INSERT INTO tickets (ticket_number, users_id, flights_id, luggage_id, total_price)" +
//            "VALUES(?, ?, ?, ?, SELECT airline.flights.price_per_seat + airline.luggage.price AS total_price" +
//            "FROM airline.flights, airline.luggage WHERE airline.flights.id=? AND airline.luggage.id=?)";
    public static final String ADD_TICKET = "INSERT INTO tickets (ticket_number, users_id, flights_id, luggage_id, total_price)" +
        "VALUES(?, ?, ?, ?, ?)";

    public static final String GET_ALL_TICKETS = "";
}
