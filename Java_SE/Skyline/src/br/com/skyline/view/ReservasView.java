package br.com.skyline.view;

import java.util.Scanner;

import br.com.skyline.dao.ReservasDAO;
import br.com.skyline.model.Clientes;
import br.com.skyline.model.Reservas;
import br.com.skyline.model.Voo;

public class ReservasView {
	private Scanner s;

	public void reservasMenu() {

		s = new Scanner(System.in);
		ReservasDAO resDao = new ReservasDAO(); 
		int menuRes = 0;
		int id;
		
		do {
			
			System.out.println("\n     ---- Reservas ----     ");
			System.out.println("Selecione a opção desejada:");
			System.out.println("\n1- Cadastrar  2- Listar  3- Buscar por ID");
			System.out.println("4- Atualizar  5- Apagar  0- Voltar ao menu anterior\n");
			

			menuRes = s.nextInt();
			//s.nextLine();
			
			switch(menuRes) {
				
				case 1://create
					Reservas res = new Reservas();
					Voo voo = new Voo();
					Clientes cli = new Clientes();
					
					System.out.print("Numero de pessoas da Reserva: ");
					res.setNum_pessoas(new Scanner(System.in).nextInt());
					
					System.out.println("Digite o CPF do Cliente: ");
					cli.setCpf(new Scanner(System.in).nextLine());
					
					System.out.println("Digite o ID do Voo: ");
					voo.setId_voo(new Scanner(System.in).nextInt());
					res.setCliente(cli);
					res.setVoo(voo);
										
					resDao.createReserva(res);
					break;
					
				case 2://listar
					
					for(Reservas r1 : resDao.listar()) {
						System.out.println(r1.toString());
					}
					break;
					
				case 3://buscar por ID
					System.out.println("Digite o ID para buscar: ");
					id = s.nextInt();
					Reservas r2 = new Reservas();
					r2 = resDao.buscarPorId(id);
					System.out.println(r2.toString());
					break;
					
				case 4://Atualizar
					Reservas r3 = new Reservas();
					Voo v1 = new Voo();
					
					
					System.out.print("Digite o ID para Atualizar: ");
					r3.setId_reserva(new Scanner(System.in).nextInt());
					
					System.out.print("Numero de pessas da reserva: ");
					r3.setNum_pessoas(new Scanner(System.in).nextInt());
					
					System.out.println("Cancelar reserva? \n "
									 + "true para SIM / false para NÃO ");
					r3.setCancelada(new Scanner(System.in).nextBoolean());
					
					
					System.out.println("Digite o ID do Voo: ");
					v1.setId_voo(new Scanner(System.in).nextInt());
					r3.setVoo(v1);
										
					resDao.atualizarDados(r3);
					break;
					
				case 5://Apagar
					System.out.println("Digite o ID do registro que deseja apagar: ");
					//id = s.nextInt();
					resDao.apagar(new Scanner(System.in).nextInt());					
					break;
				default:
					break;
			
			}
			
		}while(menuRes != 0);

	}
	
}