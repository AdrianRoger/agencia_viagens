package br.com.skyline.view;

import java.util.Scanner;

import br.com.skyline.dao.VooDAO;
import br.com.skyline.model.Cidades;
import br.com.skyline.model.Voo;

public class VooView {
	private Scanner s;

	public void vooMenu() {

		s = new Scanner(System.in);
		VooDAO vooDao = new VooDAO(); 
		int menuVoo = 0;
		int id;
		
		do {
			
			System.out.println("\n     ---- Voo ----     ");
			System.out.println("Selecione a opção desejada:");
			System.out.println("\n1- Cadastrar  2- Listar  3- Buscar por ID");
			System.out.println("4- Atualizar  5- Apagar  0- Voltar ao menu anterior\n");
			

			menuVoo = s.nextInt();
			//s.nextLine();
			
			switch(menuVoo) {
				
				case 1://create
					Voo v = new Voo();
					Cidades cOrigem = new Cidades();
					Cidades cDestino = new Cidades();
					
					System.out.print("Numero do Voo: ");
					v.setNum_voo(new Scanner(System.in).nextInt());
					System.out.print("Companhia Aérea: ");
					v.setComp_aerea(new Scanner(System.in).nextLine());
					System.out.print("Numero de Assentos: ");
					v.setAssentos(new Scanner(System.in).nextInt());
					System.out.print("Preco Unitário: ");
					v.setPreco_unit(new Scanner(System.in).nextDouble());
					//new Scanner(System.in).nextLine();//correção de bug da Scanner
					System.out.println("Data de partida: (Dia/Mês/Ano) ");
					v.setData_partida(new Scanner(System.in).nextLine());
					
					System.out.println("Digite o ID da cidade de origem");
					cOrigem.setId_cidade(new Scanner(System.in).nextInt());
					System.out.println("Digite o ID da cidade de destino");
					cDestino.setId_cidade(new Scanner(System.in).nextInt());
					v.setOrigem(cOrigem);
					v.setDestino(cDestino);
					
					vooDao.createVoo(v);
					break;
					
				case 2://listar
					
					for(Voo v1 : vooDao.listar()) {
						System.out.println(v1.toString());
					}
					break;
					
				case 3://buscar por ID
					System.out.println("Digite o ID para buscar: ");
					id = s.nextInt();
					Voo v2 = new Voo();
					v2 = vooDao.buscarPorId(id);
					System.out.println(v2.toString());
					break;
					
				case 4://Atualizar
					Voo v3 = new Voo();
					Cidades cOrigem1 = new Cidades();
					Cidades cDestino1 = new Cidades();
					
					System.out.print("Digite o ID para Atualizar: ");
					v3.setId_voo(new Scanner(System.in).nextInt());
					
					System.out.print("Numero do Voo: ");
					v3.setNum_voo(new Scanner(System.in).nextInt());
					System.out.print("Companhia Aérea: ");
					v3.setComp_aerea(new Scanner(System.in).nextLine());
					System.out.print("Numero de Assentos: ");
					v3.setAssentos(new Scanner(System.in).nextInt());
					System.out.print("Preco Unitário: ");
					v3.setPreco_unit(new Scanner(System.in).nextDouble());
					//new Scanner(System.in).nextLine();//correção de bug da Scanner
					System.out.println("Data de partida: (Dia/Mês/Ano) ");
					v3.setData_partida(new Scanner(System.in).nextLine());
					
					System.out.println("Digite o ID da cidade de origem");
					cOrigem1.setId_cidade(new Scanner(System.in).nextInt());
					System.out.println("Digite o ID da cidade de destino");
					cDestino1.setId_cidade(new Scanner(System.in).nextInt());
					v3.setOrigem(cOrigem1);
					v3.setDestino(cDestino1);
										
					
					vooDao.atualizarDados(v3);
					break;
					
				case 5://Apagar
					System.out.println("Digite o ID do registro que deseja apagar: ");
					//id = s.nextInt();
					vooDao.apagar(new Scanner(System.in).nextInt());					
					break;
				default:
					break;
			
			}
			
		}while(menuVoo != 0);

	}
}
