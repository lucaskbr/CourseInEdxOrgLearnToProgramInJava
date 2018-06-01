import java.util.Scanner;

public class Crypto {

	public static void main(String[] args) {

		/* ****Lucas Klasa 30/05/2018
		 * ****Codigo destinado apenas ao estudo. Atividade do curso: Learn to Program in Java -  Project Crypto - Edx.org */

		Scanner input = new Scanner(System.in);
		int laco = 1;

		System.out.println("Bem vindo ao programa de criptografia!!!!");

		do{
			System.out.println("Digite o que você deseja criptografar");
			String frase = input.nextLine();
			System.out.println("Digite um numero aleatório!!! ");
			int numero_aleatorio = input.nextInt();
			System.out.println("Digite um numero para quebrar a frase e agrupar!!! ");
			int numero_agrupamento = input.nextInt();
			System.out.println("Aguarde um instante....\nCryptografando frase....");
			System.out.println(encryptString(frase, numero_aleatorio, numero_agrupamento));
			System.out.println("Para descriptografar já é outro esquema e outro programa. Deseja continuar?");
			laco = input.nextInt();
			input.nextLine();

			if(laco == 0) {
				System.out.println("Programa encerrado com sucesso!");
			}

		}while(laco != 0);


	}


	//*****Metodo que troca caracteres inapropriados por '';
	public static String replaceText(String texto){
		String novo_texto;
		novo_texto = texto.replace(" ", "");
		novo_texto = novo_texto.replace(",", "");
		novo_texto = novo_texto.replace(".", "");
		novo_texto = novo_texto.replace(":", "");
		novo_texto = novo_texto.replace(";", "");
		novo_texto = novo_texto.replace("\'", "");
		novo_texto = novo_texto.replace("\"", "");
		novo_texto = novo_texto.replace("!", "");
		novo_texto = novo_texto.replace("?", "");
		novo_texto = novo_texto.replace("(", "");
		novo_texto = novo_texto.replace(")", "");
		return novo_texto;
	}

	//*****Metodo que deixa a String em caixa ALTA;
	public static String replaceCase(String texto) {
		String novo_texto = texto.toUpperCase();
		return novo_texto;
	}


	//*****Metodo que coloca BA na frente de vogais;
	public static String Obish(String texto) {

		String novo_texto = "";
		novo_texto = texto.replace("A", "ABA");
		novo_texto += novo_texto.replace("E", "EBA");
		novo_texto += novo_texto.replace("I", "IBA");
		novo_texto += novo_texto.replace("O", "OBA");
		novo_texto += novo_texto.replace("U", "UBA");
		novo_texto += novo_texto.replace("Y", "YBA");
		return novo_texto;
	}

	//*****Metodo que junta o metodo replaceText() e replaceCase();
	public static String normalizeText(String texto) {

		String novo_texto;
		novo_texto = replaceText(texto);
		novo_texto = replaceCase(novo_texto);
		return novo_texto;
	}


	//*****Metodo que chama o metodo shiftAlphabet();
	public static String caesarify(String texto, int chave) {

		String resultado = shiftAlphabet(chave);
		return resultado;
	}


	//***** Metodo criado pelo exercício;
	public static String shiftAlphabet(int shift) {

		int start = 0;

		if (shift < 0) {
			start = (int) 'Z' + shift + 1;
			System.out.println(start);
		}else {
			start = 'A' + shift;
		}
		String result = "";
		char currChar = (char) start;
		for(; currChar <= 'Z'; ++currChar) {
			result = result + currChar;
		}
		if(result.length() < 26) {
			for(currChar = 'A'; result.length() < 26; ++currChar) {
				result = result + currChar;
			}
		}
		return result;	
	}

	//***** Metodo que separa o texto por grupo;
	public static String groupify(String texto, int letras_grupo) {

		String resultado = "";
		int contador = 0;

		for (int i = 0; i < texto.length(); i++) {

			if(contador == letras_grupo) {

				resultado += " ";
				contador = 0;
			}
			resultado += texto.charAt(i);
			contador++;
		}	
		return resultado;
	}


	//***** Metodo que agrupa todos os outros e realiza o processamento final;
	public static String encryptString(String texto, int shift, int quantidade_letras) {

		String texto_normalizado = "";
		String texto_obish = "";
		String texto_encriptado = "";
		String texto_desagrupado = "";

		texto_normalizado = normalizeText(texto);
		texto_obish = Obish(texto_normalizado);
		texto_encriptado = caesarify(texto_obish, shift);
		texto_desagrupado = groupify(texto_encriptado, quantidade_letras);

		String resultado = texto_desagrupado;

		return texto_desagrupado;

	}
}
