package com.minderest.api.shared.core;

import com.minderest.api.shared.ConstantsErrors;

public class InstantiateForbidden {
    public InstantiateForbidden() {
	throw new AssertionError(ConstantsErrors.NOT_ALLOWED_INSTANTIATE);
    }
}
