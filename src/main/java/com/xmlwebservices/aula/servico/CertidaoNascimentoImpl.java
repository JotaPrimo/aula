package com.xmlwebservices.aula.servico;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import jakarta.jws.WebService;



//SERVICE IMPLEMENTATION BEAN  SIB
@WebService(endpointInterface = "com.xmlwebservices.aula.servico.CertidaoNascimento")
public class CertidaoNascimentoImpl implements CertidaoNascimento {

	@Override
	public int calcularIdade(String idade) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		int idadeCalculada = 0;
		
		try {
			Calendar dataNascimento = Calendar.getInstance();
			Date idadeDate = sdf.parse(idade);
			dataNascimento.setTime(idadeDate);
			
			Calendar hoje = Calendar.getInstance();
			idadeCalculada = hoje.get(Calendar.YEAR) -  dataNascimento.get(Calendar.YEAR);
			
			if(hoje.get(Calendar.MONTH) < dataNascimento.get(Calendar.MONTH)) {
				idadeCalculada--;
			}else {
				if(hoje.get(Calendar.MONTH) == dataNascimento.get(Calendar.MONTH)
						&& hoje.get(Calendar.DAY_OF_MONTH) < dataNascimento.get(Calendar.DAY_OF_MONTH)) {
					idadeCalculada--;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return idadeCalculada;
	}

	@Override
	public String diaSemanaNascimento(String idade) {
		// TODO Auto-generated method stub
		String dias[] = { "Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado" };
		int dia = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Calendar dataNascimento = Calendar.getInstance();
			Date idadeDate = sdf.parse(idade);
			dataNascimento.setTime(idadeDate);
			dia = dataNascimento.get(Calendar.DAY_OF_WEEK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dias[dia-1];
	}


}
