package com.ada.album.transacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AlbumTransacaoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlbumTransacaoApiApplication.class, args);
	}

}
