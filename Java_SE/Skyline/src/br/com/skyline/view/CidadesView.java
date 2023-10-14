package br.com.skyline.view;

import java.util.Scanner;

import br.com.skyline.dao.CidadesDAO;
import br.com.skyline.model.Cidades;

public class CidadesView {
	private Scanner s;

	public void cidadeMenu() {

		s = new Scanner(System.in);
		CidadesDAO cidadeDao = new CidadesDAO(); 
		int menuCidade = 0;
		int id;
		
		do {
			
			System.out.println("\n     ---- Cidades ----     ");
			System.out.println("Selecione a opção desejada:");
			System.out.println("\n1- Cadastrar  2- Listar  3- Buscar por ID");
			System.out.println("4- Atualizar  5- Apagar  0- Voltar ao menu anterior\n");
			

			menuCidade = s.nextInt();
			//s.nextLine();
			
			switch(menuCidade) {
				
				case 1://create
					Cidades c = new Cidades();
					System.out.print("Digite a Cidade: ");
					c.setCidade(new Scanner(System.in).nextLine());
					System.out.print("Digite o Estado: ");
					c.setEstado(new Scanner(System.in).nextLine());
					System.out.print("Digite Pais: ");
					c.setPais(new Scanner(System.in).nextLine());
					System.out.print("Digite Aeroporto: ");
					c.setAeroporto(new Scanner(System.in).nextLine());
					
					cidadeDao.createCidade(c);
					break;
					
				case 2://listar
					
					for(Cidades c1 : cidadeDao.listar()) {
						System.out.println(c1.toString());
					}
					break;
					
				case 3://buscar por ID
					System.out.println("Digite o ID para buscar: ");
					id = s.nextInt();
					Cidades c2 = new Cidades();
					c2 = cidadeDao.buscarPorId(id);
					System.out.println(c2.toString());
					break;
					
				case 4://Atusalizar
					Cidades c3 = new Cidades();
					System.out.print("Digite o Id: ");
					c3.setId_cidade(new Scanner(System.in).nextInt());
					
					System.out.print("Digite o nome da Cidade: ");
					c3.setCidade(new Scanner(System.in).nextLine());
					
					System.out.print("Digite o Estado: ");
					c3.setEstado(new Scanner(System.in).nextLine());
					
					System.out.print("Digite o País: ");
					c3.setPais(new Scanner(System.in).nextLine());
					
					System.out.print("Digite nome do Aeroporto: ");
					c3.setAeroporto(new Scanner(System.in).nextLine());
										
					
					cidadeDao.atualizarDados(c3);
					break;
					
				case 5://Apagar
					System.out.println("Digite o ID do registro que deseja apagar: ");
					//id = s.nextInt();
					cidadeDao.apagar(new Scanner(System.in).nextInt());					
					break;
				default:
					break;
			
			}
			
		}while(menuCidade != 0);

	}
	
}
