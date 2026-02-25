package io.github.nishikizm.dbaccesspractice.presentation;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Objects;

import io.github.nishikizm.dbaccesspractice.domain.error.ExitCode;
import io.github.nishikizm.dbaccesspractice.domain.model.Customer;
import io.github.nishikizm.dbaccesspractice.service.CreateCustomerData;
import io.github.nishikizm.dbaccesspractice.service.DeleteCustomerData;
import io.github.nishikizm.dbaccesspractice.service.ReadCustomerData;

public class Dispatcher {
    
    public ExitCode dispatch(String[] args) {
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
        CreateCustomerData create = new CreateCustomerData();

        try {
            create.CreateData(new Customer(args[1], args[2], parseBigDecimal(args[3])));
        } catch(NumberFormatException e) {
            return ExitCode.INVALID_ARG_ERROR;
        } catch(SQLException e) {
            return ExitCode.SQL_ERROR;
        }
        
        return ExitCode.SUCCESS;
    }

    private ExitCode handleRead(String[] args) {
        if(checkLength(2, args) == false) { return ExitCode.INVALID_ARG_ERROR; }
        ReadCustomerData read = new ReadCustomerData();
        Customer customer;
        try {
            customer = read.ReadData(parseInteger(args[1]));
        } catch(NumberFormatException e) {
            return ExitCode.INVALID_ARG_ERROR;
        } catch(SQLException e) {
            return ExitCode.SQL_ERROR;
        }
        if(Objects.isNull(customer)) { return ExitCode.NOT_FOUND_ERROR; }

        Printer printer = new Printer();
        printer.print(customer);
        return ExitCode.SUCCESS;
    }

    private ExitCode handleUpdate(String[] args) {
        return null;
    }

    private ExitCode handleDelete(String[] args) {
        if(checkLength(2, args) == false) { return ExitCode.INVALID_ARG_ERROR; }
        DeleteCustomerData delete = new DeleteCustomerData();
        try {
            delete.DeleteData(parseInteger(args[1]));
        } catch(NumberFormatException e) {
            return ExitCode.INVALID_ARG_ERROR;
        } catch(SQLException e) {
            return ExitCode.SQL_ERROR;
        }

        return ExitCode.SUCCESS;
    }

    private boolean checkLength(int num, String[] args) {
        if(args.length == num) { return true; }
        else { return false; }
    }

    private BigDecimal parseBigDecimal(String number) {
        return new BigDecimal(number);
    }

    private int parseInteger(String number) {
        return Integer.parseInt(number);
    }

}
