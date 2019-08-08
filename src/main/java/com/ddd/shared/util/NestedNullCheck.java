package com.ddd.shared.util;

import java.util.Optional;
import java.util.function.Supplier;

import com.ddd.shared.ConstantsErrors;

public final class NestedNullCheck {

    private NestedNullCheck() {
	throw new AssertionError(ConstantsErrors.NOT_ALLOWED_INSTANTIATE);
    }

    public static final <T> Optional<T> resolve(Supplier<T> resolver) {
	try {
	    T result = resolver.get();
	    return Optional.ofNullable(result);
	} catch (NullPointerException e) {
	    return Optional.empty();
	}
    }

}
