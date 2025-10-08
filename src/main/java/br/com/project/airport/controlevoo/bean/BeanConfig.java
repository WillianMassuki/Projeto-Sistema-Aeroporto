package br.com.project.airport.controlevoo.bean;

import br.com.project.airport.controlevoo.port.ControleDeVooRepositoryPort;
import br.com.project.airport.controlevoo.port.ControleDeVooServicePort;
import br.com.project.airport.controlevoo.service.ControleDeVooService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public ControleDeVooServicePort controleDeVooService(ControleDeVooRepositoryPort repositoryPort) {
        return new ControleDeVooService(repositoryPort);
    }
}