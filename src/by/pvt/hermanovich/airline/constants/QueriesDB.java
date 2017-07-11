package by.pvt.hermanovich.airline.constants;

/**
 * Description:
 * Created by Yauheni Hermanovich on 11.07.2017.
 */
public class QueriesDB {
    public static final String CHECK_AUTHORIZATION = "SELECT login, password FROM users WHERE login = ? AND password = ?";
    public static final String GET_USER_BY_LOGIN = "SELECT * FROM users WHERE login = ?";
    public static final String GET_USER_BY_ID = "SELECT * FROM users WHERE id = ?";
    public static final String ADD_USER = "INSERT INTO users (firstname, surname, document_number, login, password, user_type)" +
            "VALUES (?, ?, ?, ?, ?, ?)";
    public static final String DELETE_USER_BY_ID = "DELETE FROM users WHERE id = ?";
    public static final String UPDATE_USER_BY_ID = "UPDATE users SET firstname = ?, surname = ?, document_number = ?," +
            "login = ?, password = ?, user_type = ?  WHERE id = ?";
}
