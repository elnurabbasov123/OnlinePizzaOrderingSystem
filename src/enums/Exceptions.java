package enums;

import java.time.LocalDateTime;

public enum Exceptions {
    NOT_REGISTERED_EXCEPTION(404,"Your Login and Password is Wrong !",LocalDateTime.now()),
    INSUFFICIENT_FUNDS_EXCEPTION(403,"Insufficient funds",LocalDateTime.now()),
    INVALID_FUNCTION(407,"We choose Invalid Function !",LocalDateTime.now());

    private final int status;
    private final String message;
    private final LocalDateTime localDateTime;

    Exceptions(int status, String message, LocalDateTime localDateTime) {
        this.status = status;
        this.message = message;
        this.localDateTime = localDateTime;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
}
