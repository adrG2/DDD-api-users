package com.minderest.api.shared.util;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

import com.minderest.api.shared.core.InstantiateForbidden;

public final class StringCheck extends InstantiateForbidden {

    public static final boolean isBlankAnyArgument(String... strings) {
	return Arrays.asList(strings).stream().anyMatch(StringUtils::isBlank);
    }

}
