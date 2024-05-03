package com.grupo3.fisiowave.config;

public class SecurityExpressions {

    private SecurityExpressions() {}

    public static final String ADMIN_SCOPE = "hasAuthority('SCOPE_ADMIN')";
    public static final String CHECK_ID_OR_ADMIN_SCOPE = "#id.toString() == authentication.name or hasAuthority('SCOPE_ADMIN')";
}
