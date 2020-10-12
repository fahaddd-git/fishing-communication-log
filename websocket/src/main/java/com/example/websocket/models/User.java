package com.example.websocket.models;
import javax.validation.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


public class User {

        @NotBlank
        private String username;

        @NotBlank
        private String name;

        @NotBlank
        @Email(message = "Invalid email. Try again.")
        private String email;

    public User(@NotBlank String username, @NotBlank String name, @NotBlank @Email(message = "Invalid email. Try again.") String email) {
        this.username = username;
        this.name = name;
        this.email = email;
    }

    public User(){};

    public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;

    }
}
