package br.com.skyline.view;

import java.util.Scanner;

import br.com.skyline.dao.ContatoDAO;
import br.com.skyline.model.Contato;

public class ContatoView {
	private Scanner s;

	public void contatoMenu() {

		s = new Scanner(System.in);
		ContatoDAO contatoDao = new ContatoDAO(); 
		int menuContato = 0;
		int id;
		
		do {
			
			System.out.println("\n     ---- Contato ----     ");
			System.out.println("Selecione a opção desejada:");
			System.out.println("\n1- Registrar  2- Listar  3- Buscar por ID");
			System.out.println("4- Atualizar  5- Apagar  0- Voltar ao menu anterior\n");
			

			menuContato = s.nextInt();

			
			switch(menuContato) {
				
				case 1:
					Contato c = new Contato();
					System.out.print("Digite seu nome: ");
					c.setNome(new Scanner(System.in).nextLine());
					System.out.print("Digite seu Email: ");
					c.setEmail(new Scanner(System.in).nextLine());
					System.out.print("Digite seu telefone: ");
					c.setTelefone(new Scanner(System.in).nextLine());
					System.out.print("Digite sua mensagem: ");
					c.setMensagem(new Scanner(System.in).nextLine());
					
					contatoDao.createContato(c);
					break;
				case 2:
					
					for(Contato c1 : contatoDao.listar()) {
						System.out.println(c1.toString());
					}
					
					break;
				case 3:
					System.out.println("Digite o ID para buscar: ");
					id = s.nextInt();
					Contato c2 = new Contato();
					c2 = contatoDao.buscarPorId(id);
					System.out.println(c2.toString());
					break;
				case 4:
					Contato c3 = new Contato();
					System.out.print("Digite seu Id: ");
					c3.setId_contato(new Scanner(System.in).nextInt());
					System.out.print("Digite seu nome: ");
					c3.setNome(new Scanner(System.in).nextLine());
					System.out.print("Digite seu Email: ");
					c3.setEmail(new Scanner(System.in).nextLine());
					System.out.print("Digite seu telefone: ");
					c3.setTelefone(new Scanner(System.in).nextLine());
					System.out.print("Digite sua mensagem: ");
					c3.setMensagem(new Scanner(System.in).nextLine());
					System.out.print("Resolvido? ");
					c3.setResolvido(new Scanner(System.in).nextBoolean());
					
					
					contatoDao.atualizar(c3);
					break;
				case 5:
					System.out.println("Digite o ID do registro que deseja apagar: ");
					id = s.nextInt();
					contatoDao.apagar(id);					
					break;
				default:
					break;
			
			}
			
		}while(menuContato != 0);

	}
	
}
