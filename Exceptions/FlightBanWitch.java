package Exceptions;

public class FlightBanWitch extends RuntimeException {
    public FlightBanWitch(){
        super("Ошибка: ведьма не сможет взлететь из-за слишком большого веса");
    }
}