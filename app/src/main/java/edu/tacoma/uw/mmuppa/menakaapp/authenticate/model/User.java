package edu.tacoma.uw.mmuppa.menakaapp.authenticate.model;

public class User {
    private String mEmail;
    private boolean mRemember;

    public User(String email, boolean remember) {
        setEmail(email);
        this.mRemember = remember;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        if (email == null
                || email.length() < 6
                || !email.contains("@")) {
            throw new IllegalArgumentException("Email is invalid");
        }
        this.mEmail = email;
    }

    public boolean isRemember() {
        return mRemember;
    }

    public void setRemember(boolean remember) {
        this.mRemember = remember;
    }
}
