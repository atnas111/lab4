package Exceptions;

public class FailMarriage extends Exception {
    public FailMarriage(){
        super("Ошибка: Дядя недостаточно счастлив, чтобы жениться");
    }
}
