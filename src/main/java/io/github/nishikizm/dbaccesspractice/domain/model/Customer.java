package io.github.nishikizm.dbaccesspractice.model;

import java.math.BigDecimal;

public record Customer(String name, String email, BigDecimal balance) {}
