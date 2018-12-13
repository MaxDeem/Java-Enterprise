package services;

import forms.LogInForm;
import forms.SignUpForm;

public interface AuthService {
    void signUp(SignUpForm signUpForm);
    void logIn(LogInForm logInForm);
}
