package aplicacao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Excecoes.DominioExceptions;
import entidades.Produtos;

public class Programa {

	public static void main(String[] args) throws DominioExceptions {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		List<Produtos> list = new ArrayList<>();

		try {
			System.out.print("Agora digite o nome do arquivo que deseja vc deseja criar: ");
			String nomeDoArquivo = sc.nextLine();

			Produtos produtos = new Produtos();

			list.add(produtos);
			produtos.criandoArquivoDeTexto(nomeDoArquivo);
			
			System.out.println("Programa executado com sucesso!");
			
		} catch (DominioExceptions e) {
			System.out.println("ERROR: " + e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("Erro inesperado: " + e.getMessage());
		} finally {
			sc.close();
		}

		sc.close();
	}

}
