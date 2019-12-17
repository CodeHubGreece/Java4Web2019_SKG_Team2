package org.regeneration.efkajpa;

public class UserInfo {
    private String id;
    private char type;

    public UserInfo(String id, char type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }
}
