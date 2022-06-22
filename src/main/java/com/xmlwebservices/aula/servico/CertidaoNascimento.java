package com.xmlwebservices.aula.servico;

//SERVICE ENDPOINT INTERFAC SEI
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.Style;


@WebService
@SOAPBinding(style = Style.RPC)// diz que estou mexendo com tipos primitivos
public interface CertidaoNascimento {
	
	@WebMethod // significa que s�o opera��es de servi�os
	public int calcularIdade(String idade);
	
	@WebMethod // significa que s�o opera��es de servi�os
	public String diaSemanaNascimento(String idade);

}