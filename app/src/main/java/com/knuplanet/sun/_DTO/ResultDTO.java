package com.knuplanet.sun._DTO;

/**
 * Created by ladmusician on 15. 12. 5..
 */
public class ResultDTO {
    private boolean Result;
    private String Username;
    private String Password;

    public boolean getResult() {
        return Result;
    }

    public void setResult(boolean result) {
        Result = result;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }
}
