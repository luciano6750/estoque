package com.example.demo;

import java.util.Arrays;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.Candidato;
import com.example.demo.domain.Cargo;
import com.example.demo.domain.Eleicao;
import com.example.demo.domain.Usuario;
import com.example.demo.domain.Votos;
import com.example.demo.domain.enums.TipoUsuario;
import com.example.demo.repositories.CandidatoRepository;
import com.example.demo.repositories.CargoRepository;
import com.example.demo.repositories.EleicaoRepository;
import com.example.demo.repositories.UsuarioRepository;
import com.example.demo.repositories.VotosRepository;

@SpringBootApplication
public class EleicaoApplication implements CommandLineRunner {

	@Autowired
	private CargoRepository cargoRepository;

	@Autowired
	private CandidatoRepository candidatoRepository;

	@Autowired
	private EleicaoRepository eleicaoRepository;

	@Autowired
	private VotosRepository votosRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(EleicaoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Calendar calendarioIni = Calendar.getInstance();
		Calendar calendarioFim = Calendar.getInstance();
		calendarioFim.add(Calendar.DATE, 30);
		Eleicao eleicao1 = new Eleicao(null, "Eleições Janeiro 2022", calendarioIni.getTime(), calendarioFim.getTime());

		Cargo cargo1 = new Cargo(null, "Gerente de TI", eleicao1);
		Cargo cargo2 = new Cargo(null, "Gerente de RH", eleicao1);
		Cargo cargo3 = new Cargo(null, "Diretor", eleicao1);

		Candidato c1 = new Candidato(null, "Luciano Fernandes", null, cargo1);
		Candidato c2 = new Candidato(null, "Sebastião Ribeiro", null, cargo1);
		Candidato c3 = new Candidato(null, "Nilda", null, cargo2);

		eleicao1.getCargos().addAll(Arrays.asList(cargo1, cargo2, cargo3));

		cargo1.getCandidatos().addAll(Arrays.asList(c1, c2));
		cargo2.getCandidatos().addAll(Arrays.asList(c3));

		eleicaoRepository.saveAll(Arrays.asList(eleicao1));
		cargoRepository.saveAll(Arrays.asList(cargo1, cargo2, cargo3));
		candidatoRepository.saveAll(Arrays.asList(c1, c2, c3));

		Usuario user1 = new Usuario(null, "Luciano", "06753391622", "123", TipoUsuario.ADMINISTRADOR);
		Usuario user2 = new Usuario(null, "Luciano2", "06753392342", "1237", TipoUsuario.ADMINISTRADOR);
		Usuario user3 = new Usuario(null, "Eliane", "06753391632", "1ew23", TipoUsuario.ELEITOR);
		Usuario user4 = new Usuario(null, "Claudio", "5553391632", "d1ew23", TipoUsuario.ELEITOR);

		Votos vt1 = new Votos(c3, user1, "asdgdfgdg2131asd");
		Votos vt2 = new Votos(c1, user2, "ffggdfgdg21hghjd");
		Votos vt3 = new Votos(c1, user3, "55ggdfgdg2ffffff");
		Votos vt4 = new Votos(c1, user4, "ttyyyfgdg2f54563");

		usuarioRepository.saveAll(Arrays.asList(user1, user2, user3,user4));
		votosRepository.saveAll(Arrays.asList(vt1, vt2, vt3,vt4));
	}

}
