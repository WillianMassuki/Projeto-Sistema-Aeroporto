package br.com.project.airport.seguranca.service;

import org.springframework.stereotype.Service;

@Service
public class UsuarioService{

    // «passageiro», «funcionário», «visitante»
    public String tipo()
    {

        return "";
    }
/*
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), new ArrayList<>());
    }

 */

}
