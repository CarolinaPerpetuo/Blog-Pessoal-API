package com.generation.blogpessoal.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class UsuarioControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("Cadastrar um usuário")
	public void deveCriarUmUsuario() throws Exception {

		String usuarioJson = """
			{
				"nome": "Carolina Perpetuo",
				"usuario": "carolina.teste@email.com",
				"senha": "12345678",
				"foto": "https://i.imgur.com/foto.png"
			}
			""";

		mockMvc.perform(post("/usuarios/cadastrar")
				.contentType(MediaType.APPLICATION_JSON)
				.content(usuarioJson))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.nome").value("Carolina Perpetuo"));
	}
}