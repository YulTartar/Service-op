package com.example.springdatabasicdemo.models;

public enum TicketStatus {
    WAITING(1, "В ожидании"),
    SERVED(2, "Обслужен"),
    CANCELED(3, "Отменен");

    private final int code;
    private final String description;

    TicketStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static TicketStatus fromCode(int code) {
        for (TicketStatus status : TicketStatus.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown code: " + code);
    }
}