package services;

import forms.LogInForm;
import forms.SignUpForm;
import models.Customer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import repositories.CustomerRepo;

import java.util.Optional;

public class AuthServiceImpl implements AuthService {
    private CustomerRepo customerRepo;
    private PasswordEncoder passwordEncoder;

    public AuthServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public void signUp(SignUpForm signUpForm) {
        Customer customer = Customer.builder()
                .firstName(signUpForm.getFirstName())
                .lastName(signUpForm.getLastName())
                .email(signUpForm.getEmail())
                .hashPassword(passwordEncoder.encode(signUpForm.getPassword()))
                .build();
        customerRepo.save(customer);
    }

    @Override
    public void logIn(LogInForm logInForm) {
        Optional<Customer> optionalCustomer = customerRepo.findOneByEmail(logInForm.getEmail());
        if(optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            if (!passwordEncoder.matches(logInForm.getPassword(), customer.getHashPassword())) {
                throw new IllegalArgumentException("Password or Email is not correct!");
            }
        } else {
            throw new IllegalArgumentException("Password or Email is not correct!");
        }
    }
}
