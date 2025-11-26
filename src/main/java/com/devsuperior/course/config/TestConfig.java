package com.devsuperior.course.config;

import com.devsuperior.course.entities.User;
import com.devsuperior.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration//para o springboot identificar se é classe de configuração
@Profile("test")//para dizer que é uma configuração especifica para o perfil de teste(mesmo nome que esta no properties)
public class TestConfig implements CommandLineRunner { //CommandLineRunner executa quando o programa for iniciado

    //injeção de dependencia
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        //tudo dentro desse metodo vai ser executado quando a aplicação for iniciada
        User u1 = new User(null, "Carlos", "carlos@gmail.com", "98888888", "123456");
        User u2 = new User(null, "Erica", "erica@gmail.com", "97777777", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2));//passa uma lista de objetos e ele salva no banco de dados
    }
}
