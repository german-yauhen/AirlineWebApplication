package by.pvt.hermanovich.airline.commands.factory;

import by.pvt.hermanovich.airline.commands.BasicCommand;
import by.pvt.hermanovich.airline.commands.implementations.*;
import by.pvt.hermanovich.airline.commands.implementations.aircraft.CreateAircraftCommand;
import by.pvt.hermanovich.airline.commands.implementations.airport.CreateAirportCommand;
import by.pvt.hermanovich.airline.commands.implementations.luggage.CreateLuggageCommand;
import by.pvt.hermanovich.airline.commands.implementations.luggage.DeleteLuggageCommand;
import by.pvt.hermanovich.airline.commands.implementations.luggage.UpdateLuggageCommand;
import by.pvt.hermanovich.airline.commands.implementations.user.*;

/**
 * Description: This class describea all type of using commands.
 *
 * Created by Yauheni Hermanovich on 14.07.2017.
 */
public enum CommandType {

    /*user commands*/
    LOGIN, LOGOUT, REGISTRATION, GOTOREGISTRATION, UPDATECLIENT, BACK, DEFAULT,

    /*luggage commands*/
    CREATELUGGAGE, UPDATELUGGAGE, DELETELUGGAGE,

    /*airport commands*/
    CREATEAIRPORT,

    /*aircraft commands*/
    CREATEAIRCRAFT;

    public BasicCommand getCurrentCommand() {
        switch (this) {
            case LOGIN:
                return new LoginCommand();
            case LOGOUT:
                return new LogoutCommand();
            case REGISTRATION:
                return new RegistrationCommand();
            case GOTOREGISTRATION:
                return new GotoRegistrationCommand();
            case UPDATECLIENT:
                return new UpdateClientCommand();
            case BACK:
                return new BackCommand();
            case CREATELUGGAGE:
                return new CreateLuggageCommand();
            case DELETELUGGAGE:
                return new DeleteLuggageCommand();
            case UPDATELUGGAGE:
                return new UpdateLuggageCommand();
            case CREATEAIRPORT:
                return new CreateAirportCommand();
            case CREATEAIRCRAFT:
                return new CreateAircraftCommand();

            case DEFAULT:
                return new DefaultCommand();
            default:
                return new DefaultCommand();
        }
    }
}
