package entidades;

public class ProdutoImportado extends Produto {

	private Double taxaAlfandega;

	public ProdutoImportado(String nome, Double preco, Double taxaAlfandega) {
		super(nome, preco);
		this.taxaAlfandega = taxaAlfandega;
	}

	public Double getTaxaAlfandega() {
		return taxaAlfandega;
	}

	public void setTaxaAlfandega(Double taxaAlfandega) {
		this.taxaAlfandega = taxaAlfandega;
	}

	public double totalPreco() {
		return getPreco() + taxaAlfandega;
	}

	@Override
	public String etiquetaPreco() {
		return getNome()
				+ " $ " 
		        + String.format("%.2f", totalPreco()) 
		        + "(" + "taxa alfandegária: $ "
			    + String.format("%.2f", taxaAlfandega)
			    + ")";
	} 

}
