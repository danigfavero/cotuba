package cotuba.cli;

import cotuba.application.Cotuba;

import java.nio.file.Path;

public class Main {

	public static void main(String[] args) {

		final boolean MODO_VERBOSO_DEFAULT = false;
		boolean modoVerboso = MODO_VERBOSO_DEFAULT;

		try {

			LeitorOpcoesCLI opcoesCLI = new LeitorOpcoesCLI(args);
			Path diretorioDosMD = opcoesCLI.getDiretorioDosMD();
			String formato = opcoesCLI.getFormato();
			Path arquivoDeSaida = opcoesCLI.getArquivoDeSaida();
			modoVerboso = opcoesCLI.isModoVerboso();

			Cotuba cotuba = new Cotuba();
			cotuba.executa(formato, diretorioDosMD, arquivoDeSaida);
			System.out.println("Arquivo gerado com sucesso: " + arquivoDeSaida);

		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			if (modoVerboso) {
				ex.printStackTrace();
			}
			System.exit(1);
		}
	}

}