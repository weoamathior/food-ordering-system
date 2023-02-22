package com.food.ordering.system.domain.valueobject;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    void isGreaterThanZero() {
        assertTrue(new Money(BigDecimal.valueOf(1)).isGreaterThanZero());
        assertFalse(new Money(BigDecimal.ZERO).isGreaterThanZero());
        assertFalse(new Money(BigDecimal.valueOf(-1)).isGreaterThanZero());

    }

    @Test
    void isGreaterThanMoney() {
        assertTrue(new Money(BigDecimal.TEN).isGreaterThan(new Money(BigDecimal.ONE)));
        assertFalse(new Money(BigDecimal.ONE).isGreaterThan(new Money(BigDecimal.ONE)));
        assertFalse(new Money(BigDecimal.ZERO).isGreaterThan(new Money(BigDecimal.ONE)));
    }

    @Test
    void shouldAdd() {
        Money result = new Money(BigDecimal.ZERO).add(new Money(BigDecimal.ONE));
        assertNotNull(result);
        assertEquals(BigDecimal.valueOf(1).setScale(2, RoundingMode.HALF_EVEN), result.getAmount());
    }

    @Test
    void shouldSubtract() {
        Money result = new Money(BigDecimal.ZERO).subtract(new Money(BigDecimal.ONE));
        assertNotNull(result);
        assertEquals(BigDecimal.valueOf(-1).setScale(2, RoundingMode.HALF_EVEN), result.getAmount());
    }

    @Test
    void shouldMultiply() {
        Money result = new Money(BigDecimal.ONE).multiply(3);
        assertNotNull(result);
        assertEquals(BigDecimal.valueOf(3).setScale(2, RoundingMode.HALF_EVEN), result.getAmount());
    }
}