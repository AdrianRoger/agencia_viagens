package br.com.skyline.view;

import java.util.Scanner;

import br.com.skyline.dao.ClientesDAO;
import br.com.skyline.model.Clientes;

public class ClientesView {
	private Scanner s;

	public void clienteMenu() {

		s = new Scanner(System.in);
		ClientesDAO clienteDao = new ClientesDAO(); 
		int menuCliente = 0;
		String cpf;
		
		do {
			
			System.out.println("\n    ---- Clientes ----     ");
			System.out.println("Selecione a opção desejada:");
			System.out.println("\n1- Cadastrar  2- Listar  3- Buscar por CPF");
			System.out.println("4- Atualizar  5- Apagar  0- Voltar ao menu anterior\n");
			

			menuCliente = s.nextInt();
			//s.nextLine();
			
			switch(menuCliente) {
				
				case 1://create
					Clientes c = new Clientes();
					System.out.print("CPF: ");
					c.setCpf(new Scanner(System.in).nextLine());
					System.out.print("Nome: ");
					c.setNome(new Scanner(System.in).nextLine());
					System.out.print("Email: ");
					c.setEmail(new Scanner(System.in).nextLine());
					System.out.print("Telefone: ");
					c.setTelefone(new Scanner(System.in).nextLine());
					System.out.println("Cep: ");
					c.setCep(new Scanner(System.in).nextLine());
					System.out.println("Rua: ");
					c.setRua(new Scanner(System.in).nextLine());
					System.out.println("Numero: ");
					c.setNumero(new Scanner(System.in).nextInt());
					System.out.println("Complemento: ");
					c.setComplemento(new Scanner(System.in).nextLine());
					
					clienteDao.createCliente(c);
					break;
					
				case 2://listar
					
					for(Clientes c1 : clienteDao.listar()) {
						System.out.println(c1.toString());
					}
					break;
					
				case 3://buscar por cpf
					System.out.println("Digite o CPF para buscar: ");
					cpf = new Scanner(System.in).nextLine();
					Clientes c2 = new Clientes();
					c2 = clienteDao.buscarPorCpf(cpf);
					System.out.println(c2.toString());
					break;
					
				case 4://Atusalizar
					Clientes c3 = new Clientes();
					
					System.out.print("Digite o CPF: ");
					c3.setCpf(new Scanner(System.in).nextLine());
					
					System.out.print("Nome: ");
					c3.setNome(new Scanner(System.in).nextLine());
					
					System.out.print("Email: ");
					c3.setEmail(new Scanner(System.in).nextLine());
					
					System.out.print("Telefone: ");
					c3.setTelefone(new Scanner(System.in).nextLine());
					
					System.out.print("cep: ");
					c3.setCep(new Scanner(System.in).nextLine());
										
					System.out.print("Rua: ");
					c3.setRua(new Scanner(System.in).nextLine());
					
					System.out.print("Numero: ");
					c3.setNumero(new Scanner(System.in).nextInt());
					
					System.out.print("Complemento: ");
					c3.setComplemento(new Scanner(System.in).nextLine());
					
					System.out.print("Ativo?: ");
					c3.setAtivo(new Scanner(System.in).nextBoolean());
					
					clienteDao.atualizarDados(c3);
					break;
					
				case 5://Apagar
					System.out.println("Digite o CPF do registro que deseja apagar: ");
					clienteDao.apagar(new Scanner(System.in).nextLine());					
					break;
				default:
					break;
			
			}
			
		}while(menuCliente != 0);

	}
	
}
