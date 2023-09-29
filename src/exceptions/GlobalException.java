package exceptions;

import enums.Exceptions;

import java.time.LocalDateTime;

public class GlobalException extends RuntimeException {
    private  int status;
    private String message;
    private LocalDateTime exceptionDate;

    public GlobalException(Exceptions exceptions){
        super(exceptions.getMessage());
        this.status=exceptions.getStatus();
        this.message=exceptions.getMessage();
        this.exceptionDate=exceptions.getLocalDateTime();
    }
}
