package com.minderest.shared.core;

import com.minderest.shared.ConstantsErrors;

public class InstantiateForbidden {
    public InstantiateForbidden() {
	throw new AssertionError(ConstantsErrors.NOT_ALLOWED_INSTANTIATE);
    }
}
