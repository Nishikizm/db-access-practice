package io.github.nishikizm.dbaccesspractice.domain.model;

import java.math.BigDecimal;

public record Customer(String name, String email, BigDecimal balance) {}
