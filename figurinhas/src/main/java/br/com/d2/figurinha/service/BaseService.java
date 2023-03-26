package br.com.d2.figurinha.service;

import java.util.List;

public interface BaseService<T> {
	
	List<T> buscarTodos();
	T buscarUm(String id);
	T criar(T obj);
	T editar(String id, T obj);
	void excluir(String id);
}
