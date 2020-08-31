package com.freesoft.fx.trading.marketclient.api.model;

import java.io.Serializable;
import java.util.function.Function;

public abstract class PublishResult<T> implements Serializable {

    public abstract <B> PublishResult<B> map(Function<T, B> f);

    public abstract <B> PublishResult<B> flatMap(Function<T, PublishResult<B>> f);
}
