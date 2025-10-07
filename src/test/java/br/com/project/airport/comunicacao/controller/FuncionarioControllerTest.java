package br.com.project.airport.comunicacao.controller;

import br.com.project.airport.comunicacao.model.Funcionario;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.isA;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
class FuncionarioControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deveCriarEBuscarFuncionario() throws Exception {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("João Silva");
        funcionario.setCargo("Piloto");

        // POST - cria funcionário
        String response = mockMvc.perform(post("/api/funcionarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(funcionario)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.nome").value("João Silva"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        Funcionario criado = objectMapper.readValue(response, Funcionario.class);

        // GET - busca pelo ID
        mockMvc.perform(get("/api/funcionarios/{id}", criado.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("João Silva"))
                .andExpect(jsonPath("$.cargo").value("Piloto"));
    }

    @Test
    void deveListarFuncionarios() throws Exception {
        mockMvc.perform(get("/api/funcionarios"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", isA(JSONArray.class)));
    }

    @Test
    void deveAtualizarFuncionario() throws Exception {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Maria Souza");
        funcionario.setCargo("Comissária");

        String response = mockMvc.perform(post("/api/funcionarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(funcionario)))
                .andReturn()
                .getResponse()
                .getContentAsString();

        Funcionario criado = objectMapper.readValue(response, Funcionario.class);
        criado.setCargo("Supervisora");

        mockMvc.perform(put("/api/funcionarios/{id}", criado.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(criado)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cargo").value("Supervisora"));
    }

    @Test
    void deveDeletarFuncionario() throws Exception {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Carlos Lima");
        funcionario.setCargo("Mecânico");

        String response = mockMvc.perform(post("/api/funcionarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(funcionario)))
                .andReturn()
                .getResponse()
                .getContentAsString();

        Funcionario criado = objectMapper.readValue(response, Funcionario.class);

        mockMvc.perform(delete("/api/funcionarios/{id}", criado.getId()))
                .andExpect(status().isNoContent());

        // Verifica se realmente foi removido
        mockMvc.perform(get("/api/funcionarios/{id}", criado.getId()))
                .andExpect(status().isNotFound());
    }
}