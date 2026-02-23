package io.github.nishikizm.dbaccesspractice.presentation;

import java.math.BigDecimal;
import io.github.nishikizm.dbaccesspractice.domain.error.ExitCode;

public class Dispatcher {
    
    public ExitCode Dispatch(String[] args) {
        return switch(args[0].toUpperCase()) {
            case "CREATE" -> handleCreate(args);
            case "READ" -> handleRead(args);
            case "UPDATE" -> handleUpdate(args);
            case "DELETE" -> handleDelete(args);
            default -> ExitCode.INVALID_ARG_ERROR;
        };
    }

    private ExitCode handleCreate(String[] args) {
        if(checkLength(4, args) == false) { return ExitCode.INVALID_ARG_ERROR; }
        try {
            parseBigDecimal(args[3]);
        } catch(NumberFormatException e) {
            return ExitCode.INVALID_ARG_ERROR;
        }
        return null;
    }

    private ExitCode handleRead(String[] args) {
        return null;
    }

    private ExitCode handleUpdate(String[] args) {
        return null;
    }

    private ExitCode handleDelete(String[] args) {
        return null;
    }

    private boolean checkLength(int num, String[] args) {
        if(args.length == num) { return true; }
        else { return false; }
    }

    private BigDecimal parseBigDecimal(String number) {
        return new BigDecimal(number);
    }

}
