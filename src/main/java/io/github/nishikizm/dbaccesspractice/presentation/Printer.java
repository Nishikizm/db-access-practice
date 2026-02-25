package io.github.nishikizm.dbaccesspractice.presentation;

import io.github.nishikizm.dbaccesspractice.domain.model.Customer;

public class Printer {
    public void print(Customer customer) {
        StringBuilder result = new StringBuilder();
        result.append("customer_name: ").append(customer.name()).append("\n")
                .append("email: ").append(customer.email()).append("\n")
                .append("balance: ").append(customer.balance()).append("\n");
        System.out.print(result);
    }
}
