package Enums;

public enum Day {
    TODAY("сегодня"),
    YESTERDAY("вчера");

    private String message;
    Day (String message){
        this.message = message;
    }

    public String getDescription() {
        return message;
    }

}
