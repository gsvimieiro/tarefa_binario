package com.cast.tarefabinario.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cast.tarefabinario.model.Arquivo;
import com.cast.tarefabinario.model.ObjetoJSON;
import com.cast.tarefabinario.repository.ArquivoRepository;

@RestController
@RequestMapping("/v1/diff/{id}")
public class ArquivoController {
	
	@Autowired
	private ArquivoRepository dao;
	
	
	@PostMapping(value="/right")
	public ResponseEntity<?> salvaDireita(@PathVariable Long id, @RequestBody ObjetoJSON dados){
		Arquivo arq = salvaArquivo(id, "right", dados);
		return new ResponseEntity<>(dao.save(arq), HttpStatus.OK);
	}

	@PostMapping(value="/left")
	public ResponseEntity<?> salvaEsquerda(@PathVariable Long id, @RequestBody ObjetoJSON dados){
		Arquivo arq = salvaArquivo(id, "left", dados);
		return new ResponseEntity<>(dao.save(arq), HttpStatus.OK);
	}

	
	private Arquivo salvaArquivo(Long id, String lado, ObjetoJSON dados) {
		Arquivo arq = dao.findById(id);
		if ("right".equals(lado)) {
			arq.setDireito(dados.getDados());
		}else {
			arq.setEsquerdo(dados.getDados());
		}
		return arq;
	}

	@GetMapping(value="/diff")
	private String diffArquivo(@PathVariable Long id) {
		Arquivo arq = dao.findById(id);		
		return diffBase64(arq);		
	}

	private String diffBase64(Arquivo arq) {
		byte[] bytesEsquerdo = arq.getEsquerdo().getBytes();
		byte[] bytesDireito = arq.getDireito().getBytes();

		boolean dif = Arrays.equals(bytesEsquerdo, bytesDireito);

		String caracteres = "";

		if (dif) {
			return "True";
		} else if (bytesEsquerdo.length != bytesDireito.length) {
			return "Arquivos não possuem o mesmo tamanho.";
		} else {
			byte diferenca = 0;
			for (int index = 0; index < bytesEsquerdo.length; index++) {
				diferenca = (byte) (bytesEsquerdo[index] ^ bytesDireito[index]);
				if (diferenca != 0) {
					caracteres = caracteres + " " + index;
				}
			}
		}
		return "Foram encontrados os seguintes caracteres diferentes entre os dois arquivos --> " + caracteres;
	}

	
}
