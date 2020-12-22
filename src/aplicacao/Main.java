package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Produto;
import entidades.ProdutoImportado;
import entidades.ProdutoUsado;

public class Main {

	public static void main(String[] args) throws ParseException {

		

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		// Date y1 = sdf1.parse("25/06/2018")

		List<Produto> lista = new ArrayList<>();

		System.out.print("INSIRA O NUMEROS DE PRODUTOS: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("DADOS DO PRODUTO #" + i + ":");
			System.out.print("NOVO, USADO OU IMPORTADO (n/u/i)?");
			char resp = sc.next().charAt(0);

			if (resp == 'n') {
				System.out.print("NOME: ");
				sc.nextLine();
				String nome = sc.nextLine();
				System.out.print("PREÇO: ");
				double preco = sc.nextDouble();
				Produto produto = new Produto(nome, preco);
				lista.add(produto);
			}
			if (resp == 'u') {
				System.out.print("NOME: ");
				sc.nextLine();
				String nome = sc.nextLine();
				System.out.print("PREÇO: ");
				double preco = sc.nextDouble();
				System.out.print("DATA DE FABRICAÇAO: ");
				Date dataFabricacao = sdf.parse(sc.next());
				Produto produto = new ProdutoUsado(nome, preco, dataFabricacao);
				lista.add(produto);
			}
			if (resp == 'i') {
				System.out.print("NOME: ");
				sc.nextLine();
				String nome = sc.nextLine();
				System.out.print("PREÇO: ");
				double preco = sc.nextDouble();
				System.out.print("TAXA ALFANDEGA: ");
				double taxaAlfandega = sc.nextDouble();
				Produto produto = new ProdutoImportado(nome, preco, taxaAlfandega);
				lista.add(produto);
			}

		}
		
		System.out.println();
		System.out.println("ETIQUETA DE PREÇOS:");
		for (Produto x:lista) {
			System.out.println(x);
		}

		sc.close();

	}

}
