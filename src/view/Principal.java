package view;
import java.util.Scanner;
import javax.swing.JOptionPane;
import controller.Metodos;

public class Principal {

	public static void main(String[] args) {
		
				// Instancia de classe Scanner
				Scanner sc = new Scanner(System.in);

				// Instancia da classe REdesController
				Metodos metodos = new Metodos();

				int opc = 0;
				String sO;

				// Início de laço de repetição com switch case, alternativas para o usuário.
				while (opc != 9) {

					opc = Integer.parseInt(JOptionPane.showInputDialog("Escolha a opção desejada: \n\n 1 - Lista de Processos: \n 2 - Eliminar processo pelo PID: " + "\n 3 - Eliminar processo pelo Nome: \n"
									+ " 9 - Finalizar Programa. \n\n"));
					
					switch (opc) {

					case 1:
						metodos.listaProcessos();
					break;

					case 2:
						int pid = Integer.parseInt(JOptionPane.showInputDialog("Insira o número do PID para eliminação: "));
						metodos.KillProcessPorPid(pid);
					break;
					
					case 3:
						String processo = (JOptionPane.showInputDialog("Insira o nome do processo para eliminação: "));
						metodos.KillProcessPorNome(processo);
					break;

					case 9:
						System.out.println("\nProcesso Finalizado!");
						break;
						

					default:
						System.out.println("Opção Inválida!");
						break;

					}
				}
				sc.close();
			}
	}

