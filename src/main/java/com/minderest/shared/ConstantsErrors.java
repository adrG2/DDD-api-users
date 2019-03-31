package com.minderest.shared;

public final class ConstantsErrors {

    public static final String NOT_ALLOWED_INSTANTIATE = "No se permite instanciar esta clase";
    public static final String USER_NOT_FOUND = "El usuario especificado no existe";
    public static final String USER_ALREADY_EXISTS = "EL usuario especificado ya existe";
    public static final String USER_NOT_VALIDATE = "Usuario no valido";
    public static final String USER_NULL = "El usuario es null";
    public static final String FORBIDDEN_LOGGED = "No se ha podido verificar la identidad del usuario";

    private ConstantsErrors() {
	throw new AssertionError(ConstantsErrors.NOT_ALLOWED_INSTANTIATE);
    }

}
