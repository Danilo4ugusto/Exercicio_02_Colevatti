package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Metodos {

	//Definindo o construtor da classe
	public Metodos() {
		super();
	}
	
	//Retorno do Sistema Operacional
	public String os() {
		String os = System.getProperty("os.name");
		return os;
	}

	
	//Metodo que lista os processos
	public void listaProcessos() {
		
		String SistemaOp = os();
		
		// Linux
		if(SistemaOp.contains("Linux")) {
			try {
				String lista = "ps -ef";
				Process tasklist = Runtime.getRuntime().exec(lista);
				InputStream fluxo = tasklist.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha;
				linha = buffer.readLine();
				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
			
			
		// Windows
		} else {
			try {
				String lista = "TASKLIST /FO TABLE";
				Process tasklist = Runtime.getRuntime().exec(lista);
				InputStream fluxo = tasklist.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha;
				linha = buffer.readLine();
				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//Elimina os processos pelo PID
	public void KillProcessPorPid(int pid) {
		
		String sistemaOp = os();
		
		if(sistemaOp.contains("Linux")) {
			String kill = "kill -9";
			try {
				Runtime.getRuntime().exec(kill + pid);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		else{
			String kill = "TASKKILL /PID ";
			try {
				Runtime.getRuntime().exec(kill + pid);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//Elimina os processos pelo nome
	public void KillProcessPorNome(String nome) {
		
		String sistemaOp = os();
		
		if(sistemaOp.contains("Linux")) {
			String kill = "pkill -f";
			try {
				Runtime.getRuntime().exec(kill + nome);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		else{
			String kill = "TASKKILL /IM ";
			try {
				Runtime.getRuntime().exec(kill + nome);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}

