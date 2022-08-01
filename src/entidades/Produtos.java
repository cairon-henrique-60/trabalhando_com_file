package entidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Excecoes.DominioExceptions;


public class Produtos {
	private String nome;
	private Double preco;
	private Integer quantidade;
	
	private List<Produtos> list = new ArrayList<>();
	
	public Produtos() {		
	}

	public Produtos(String nome, Double preco, int quantidade) {
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double valorTotal() {
		return preco * quantidade;
	}
	
	//metodo para criar uma pasta e um arquivo texto
	public void criandoArquivoDeTexto(String nomeDoArquivo) throws DominioExceptions {
		File caminho = new File(nomeDoArquivo);
		String caminho2 = caminho.getParent();
		boolean criaPasta = new File(caminho2 + "\\out").mkdir();
		String arqui = caminho2 + "\\out\\sumario.csv";
		
		if (caminho.exists()) {
			try (BufferedReader br = new BufferedReader(new FileReader(nomeDoArquivo))) {
				String itens = br.readLine();
				while (itens != null) {

					String[] pastas = itens.split(",");
					nome = pastas[0];
					preco = Double.parseDouble(pastas[1]);
					quantidade = Integer.parseInt(pastas[2].trim());

					list.add(new Produtos(itens, preco, quantidade));
					
					itens = br.readLine();

					try (BufferedWriter bw = new BufferedWriter(new FileWriter(arqui))) {
						for (Produtos lista : list) {
							bw.write(lista.getNome() + ", " + String.format("%.2f", lista.valorTotal()));
							bw.newLine();
						}
					} catch (IOException e) {
						System.out.println("Erro ao criar o arquivo: " + e.getMessage());
					}
				}
			} catch (IOException e) {
				System.out.println("ERROR: " + e.getMessage());
			}

		} else {
			throw new DominioExceptions("Erro ao passar o caminho do arquivo!");
		}

	}
}
