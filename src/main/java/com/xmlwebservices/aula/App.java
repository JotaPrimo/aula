package com.xmlwebservices.aula;

import com.xmlwebservices.aula.servico.CertidaoNascimentoImpl;

import jakarta.xml.ws.Endpoint;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	CertidaoNascimentoImpl certidaoNascimentoImpl = new CertidaoNascimentoImpl();
    	Endpoint.publish("http://localhost:8085/servico/certidao", certidaoNascimentoImpl);
        System.out.println( "Serviço publicado com sucesso!" );
    }
}
