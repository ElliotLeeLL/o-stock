package com.elliotlee.license.utils;

/**
 * @ClassName UserContextHolder
 * @Description Class created by Elliot Lee
 * @Author Elliot Lee
 * @Date 1/21/2025 8:49 PM
 */
public class UserContextHolder {
    private static final ThreadLocal<UserContext> userContext = new ThreadLocal<>();

    public static UserContext getUserContext() {
        UserContext result = userContext.get();

        if(result == null) {
            result = createEmptyUserContext();
            setUserContext(result);
        }

        return userContext.get();
    }

    public static void setUserContext(UserContext newUserContext) {
        userContext.set(newUserContext);
    }

    public static UserContext createEmptyUserContext() {
        return new UserContext();
    }
}
