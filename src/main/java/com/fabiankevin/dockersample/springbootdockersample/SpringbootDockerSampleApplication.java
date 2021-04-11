package com.fabiankevin.dockersample.springbootdockersample;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class SpringbootDockerSampleApplication implements CommandLineRunner{
    private final UserRepository userRepository;
    @Value("${message:Unable to fetch the properties}")
    private String message;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDockerSampleApplication.class, args);
    }

    @GetMapping
    public List<UserEntity> getAll(){


        System.out.println("Message -> " + message);
        return userRepository.findAll();
    }

    @PostMapping
    public UserEntity save(@RequestBody UserEntity userEntity){
        return userRepository.save(userEntity);
    }

    @GetMapping("/{countryCode}/{name}")
    public String greetByCountry(@PathVariable Map<String, String> pathVariables){
        String countryCode = pathVariables.get("countryCode");
        String name = pathVariables.get("name");
        if( countryCode.equalsIgnoreCase("PH") ) {
            return String.format("Kamusta %s", name);
        } else if(countryCode.equalsIgnoreCase("US")){
            return String.format("How are you %s", name);
        } else if(countryCode.equalsIgnoreCase("JP")){
            return String.format("Konichiwa %s", name);
        } else {
            return String.format("Putangina mo %s", name);
        }
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
