package Entidades;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Funcionario extends Pessoa {

	private BigDecimal salario;

	private String funcao;

	public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
		super(nome, dataNascimento);
		this.salario = salario;
		this.funcao = funcao;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public void remover(List<Funcionario> funcionarios, String nome) {
		for (int i = 0; i < funcionarios.size(); i++) {
			if (funcionarios.get(i).getNome() == nome) {
				funcionarios.remove(i);
			}
		}
	}

	public void reajustarSalarios(List<Funcionario> funcionarios, Double percentual) {
		for (int i = 0; i < funcionarios.size(); i++) {
			Funcionario f = funcionarios.get(i);
			funcionarios.get(i)
					.setSalario(f.getSalario().add(f.getSalario().multiply(BigDecimal.valueOf(percentual / 100))));
		}
		System.out.println("Lista dos funcionários com o sarlário atualizado: ");
		System.out.println(funcionarios.toString());
	}

	public void agruparPorFuncao(List<Funcionario> funcionarios) {
		System.out.println("Funcionários agrupados por Função: ");
		Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
				.collect(Collectors.groupingBy(Funcionario::getFuncao));
		funcionariosPorFuncao.forEach((funcao, lista) -> {
			System.out.println(funcao + ": " + lista);
		});
	}

	public void imprimirMesAniversario(List<Funcionario> funcionarios, Integer mes) {
		List<Funcionario> f = new ArrayList<>();
		System.out.println("Funcionários que fazem aniversário no mês " + mes + ":");
		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getDataNascimento().getMonthValue() == mes) {
				f.add(funcionario);
			}
		}
		if (f != null) {
			System.out.println(f.toString());
		}
		if (f.isEmpty()) {
			System.out.println("Nenhum funcionário encontrado!");
		}
	}

	private int getIdade() {
		return Period.between(getDataNascimento(), LocalDate.now()).getYears();
	}

	public void imprimirMaiorIdade(List<Funcionario> funcionarios) {
		Funcionario f = funcionarios.stream().max(Comparator.comparingInt(Funcionario::getIdade)).orElse(null);
		if (f == null) {
			System.out.println("Nenhum funcionário encontrado!");
		} else {
			System.out.println("Funcionário mais velho: Nome: " + f.getNome() + " idade: " + f.getIdade());
		}
	}

	public void ordenarLista(List<Funcionario> funcionarios) {
		System.out.println("Funcionários em ordem alfabetica: ");
		funcionarios.sort(Comparator.comparing(Funcionario::getNome));
		System.out.println(funcionarios.toString());
	}

	public void imprimirTotalSalarios(List<Funcionario> funcionarios) {
		DecimalFormat decimalFormat = new DecimalFormat("'R$ '#,###,##0.00");
		BigDecimal totalSalarios = new BigDecimal(0.0);
		for (Funcionario funcionario : funcionarios) {
			BigDecimal salario = funcionario.getSalario();
			totalSalarios = totalSalarios.add(salario);
		}
		System.out.println("O total dos Salários é: " + decimalFormat.format(totalSalarios));
	}

	public void imprimirSalarioMinimo(List<Funcionario> funcionarios, Double salarioMinimo) {
		DecimalFormat df = new DecimalFormat("#,###.00");
		Double quantidadeSalarios = 0D;
		for (Funcionario funcionario : funcionarios) {
			quantidadeSalarios = funcionario.getSalario().doubleValue() / (salarioMinimo);
			System.out.println("O Funcionário " + funcionario.getNome() + " ganha " + df.format(quantidadeSalarios)
					+ " salário(s) minímo(s)!");
		}
	}

	@Override
	public String toString() {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DecimalFormat decimalFormat = new DecimalFormat("'R$ '#,###,##0.00");
		return " \n Nome: " + getNome() + " - " + " Data Nascimento: " + getDataNascimento().format(dateFormat) + " - "
				+ " Salário: " + decimalFormat.format(salario) + " - " + " Função: " + funcao;
	}

}
