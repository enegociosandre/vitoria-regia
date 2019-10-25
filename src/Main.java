import javax.swing.JOptionPane;

public class Main {
	
	static Double diametroRecebido;
	
	static Double diametroPadrao = 2.60;
	static Double pesoPadrao = 40.0;
	static Double perimetroPadrao;
	
	public static void main(String[] args) {
		calculadoraParaVitoriaRegiaPadrao();
		calculadoraParaVitoriaRegia();	
	}
	
	private static void calculadoraParaVitoriaRegiaPadrao() {
		apresentaPesoMaximoSuportado(diametroPadrao, pesoPadrao);
		perimetroPadrao = calculaPerimetro(diametroPadrao);
		apresentaPerimetro(diametroPadrao, perimetroPadrao);	
	}
	
	
	private static void calculadoraParaVitoriaRegia() {
		Double pesoCalculado;
		Double perimetroCalculado;
		
		try {

			Double diametroInformado = recebeDiametroDoUsuario();
			pesoCalculado = calculaPesoSuportado(diametroPadrao, pesoPadrao, diametroInformado);
			
			apresentaPesoMaximoSuportado(diametroInformado,pesoCalculado);
			perimetroCalculado = calculaPerimetro(diametroInformado);
			apresentaPerimetro(diametroInformado, perimetroCalculado);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: Digite um numero no formato 0 ou 0.0 - Exemplo 3 ou 3.0 Exception: " + e.getMessage(), "Erro Sistema", JOptionPane.ERROR_MESSAGE);
			calculadoraParaVitoriaRegia();
		} finally {
			System.exit(0);
		}
	}

	private static Double calculaPesoSuportado(Double diametro, Double peso, Double diametroNovo) {
		return ((peso * diametroNovo) / diametro);
	}

	private static Double calculaPerimetro(Double diametro) {
		return diametro * Math.PI;
	}

	private static void apresentaPesoMaximoSuportado(Double diametro, Double peso) {
		JOptionPane.showMessageDialog(null, //
				"Para o diametro de: " + //
						String.format("%.4f", diametro) + //
						" O peso maximo que a Vitoria Regia suportarara e de: " + //
						String.format("%.4f", peso),
				"Peso", JOptionPane.INFORMATION_MESSAGE);
	}

	private static void apresentaPerimetro(Double diametro, Double perimetro) {
		JOptionPane.showMessageDialog(null, //
				"Para o diametro de: " + //
						String.format("%.4f", diametro) + //
						" O perimetro que a Vit�ria Regia possuira e de: " + //
						String.format("%.4f", perimetro),
				"Perimetro", JOptionPane.INFORMATION_MESSAGE);
	}

	private static Double recebeDiametroDoUsuario() {
		String input = JOptionPane.showInputDialog("Informe o Diametro Novo para ser calculado: ", 3);
		if(input == null){
    	   System.exit(0);
        }else{
        	diametroRecebido = Double.parseDouble(input);
        }
		if (diametroRecebido > 3) {
			JOptionPane.showMessageDialog(null, " O Diametro deve ser menor ou igual a 3 ", "Erro Sistema",
					JOptionPane.ERROR_MESSAGE);
			recebeDiametroDoUsuario();
		}
		return diametroRecebido;
	}
}
