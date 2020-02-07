package com.gerenciador.resource.exception;

import java.io.Serializable;

public class StandardError implements Serializable {

	private static final long serialVersionUID = 1L;

	private String mensagem;
	private Long quandoAconteceu;
	private Integer respostaHttp;

	public StandardError(Integer respostaHttp, String mensagem, Long quandoAconteceu) {
		this.respostaHttp = respostaHttp;
		this.mensagem = mensagem;
		this.quandoAconteceu = quandoAconteceu;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Long getQuandoAconteceu() {
		return quandoAconteceu;
	}

	public void setQuandoAconteceu(Long quandoAconteceu) {
		this.quandoAconteceu = quandoAconteceu;
	}

	public Integer getRespostaHTTP() {
		return respostaHttp;
	}

	public void setRespostaHTTP(Integer respostaHTTP) {
		this.respostaHttp = respostaHTTP;
	}

}
