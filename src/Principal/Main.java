package Principal;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Entidades.Funcao;
import Entidades.Funcionario;

public class Main {

	public static void main(String[] args) {
		
		
		List<Funcionario> funcionarios = new ArrayList<>();
		Funcionario p = new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal(2009.44), Funcao.OPERADOR.getDescricao());
		funcionarios.add(p);
		funcionarios.add(new Funcionario("João", LocalDate.of(1990, 05, 12), new BigDecimal(2284.38), Funcao.OPERADOR.getDescricao()));
		funcionarios.add(new Funcionario("Caio", LocalDate.of(1961,05,02), new BigDecimal(9836.14), Funcao.COORDENADOR.getDescricao()));
		funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988,10,14), new BigDecimal(19119.88), Funcao.DIRETOR.getDescricao()));
		funcionarios.add(new Funcionario("Alice", LocalDate.of(1995,01,05), new BigDecimal(2234.68), Funcao.RECEPCIONISTA.getDescricao()));
		funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999,11,19), new BigDecimal(1582.72), Funcao.OPERADOR.getDescricao()));
		funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993,03,31), new BigDecimal(4071.84), Funcao.CONTADOR.getDescricao()));
		funcionarios.add(new Funcionario("Laura", LocalDate.of(1994,07,8), new BigDecimal(3017.45), Funcao.GERENTE.getDescricao()));
		funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003,5,24), new BigDecimal(1606.85), Funcao.ELETRICISTA.getDescricao()));
		funcionarios.add(new Funcionario("Helena", LocalDate.of(1996,9,2), new BigDecimal(2799.93), Funcao.GERENTE.getDescricao()));
		
		//REMOVE FUNCIONÁRIO, PASSANDO O NOME COMO PARÂMETRO
		p.remover(funcionarios, "João");
		
		
		//IMPRIME TODOS OS FUNCIONÁRIOS
		System.out.println(funcionarios.toString());
	
		//REAJUSTA SALÁRIO DE TODOS FUNCIONÁRIOS
		p.reajustarSalarios(funcionarios, 10.0);
		
		 
		//AGRUPA FUNCIONÁRIOS POR FUNÇÃO E IMPRIME
		p.agruparPorFuncao(funcionarios);
		
		//IMPRIME FUNCIONÁRIOS QUE FAZEM ANIVERSÁRIO NO MES 10 E 12
		p.imprimirMesAniversario(funcionarios, 10);
		p.imprimirMesAniversario(funcionarios, 12);
		
		//IMPRIME FUNCIONÁRIO COM A MAIOR IDADE
		p.imprimirMaiorIdade(funcionarios);
		
		//IMPRME FUNCIONÁRIOS POR ORDEM ALFABETICA
		p.ordenarLista(funcionarios);
		
		//IMPRIME O TOTAL DOS SALÁRIOS
		p.imprimirTotalSalarios(funcionarios);
		
		//IMPRIME QUANTOS SALARIOS MINIMO GANHA CADA FUNCIONÁRIO
		p.imprimirSalarioMinimo(funcionarios, 1212.00);
		
	}

}
