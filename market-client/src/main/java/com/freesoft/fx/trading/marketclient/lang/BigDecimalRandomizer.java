package com.freesoft.fx.trading.marketclient.lang;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigDecimalRandomizer {

    public static BigDecimal random(String range) {
        var max = new BigDecimal(range);
        var randomFromDouble = BigDecimal.valueOf(Math.random());
        var actualRandomDouble = randomFromDouble.divide(max, RoundingMode.DOWN);
        return actualRandomDouble.round(new MathContext(4, RoundingMode.DOWN));
    }
}
