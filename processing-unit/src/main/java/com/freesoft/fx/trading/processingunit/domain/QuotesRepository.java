package com.freesoft.fx.trading.processingunit.domain;

import com.freesoft.fx.trading.marketclient.api.model.Quote;

import java.util.List;

public interface QuotesRepository {

    List<Quote> findAll();

    void addAll(List<Quote> quotes);

    void add(Quote quote);
}
