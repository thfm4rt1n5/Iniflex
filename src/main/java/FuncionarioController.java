import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

public class FuncionarioController {
    private final List<Funcionario> funcionarios;

    public FuncionarioController() {
        this.funcionarios = new FuncionarioFactory().getFuncionarios();
    }

    /**
     * Insere funcionários na lista
     */
    public void insereFuncionarios() {
        funcionarios.addAll(Arrays.asList(
                new Funcionario("Maria", "18/10/2000", new BigDecimal("2009.44"), "Operador"),
                new Funcionario("João", "12/05/1990", new BigDecimal("2284.38"), "Operador"),
                new Funcionario("Caio", "02/05/1961", new BigDecimal("9836.14"), "Coordenador"),
                new Funcionario("Miguel", "14/10/1988", new BigDecimal("19119.88"), "Diretor"),
                new Funcionario("Alice", "05/01/1995", new BigDecimal("2234.68"), "Recepcionista"),
                new Funcionario("Heitor", "19/11/1999", new BigDecimal("1582.72"), "Operador"),
                new Funcionario("Arthur", "31/03/1993", new BigDecimal("4071.84"), "Contador"),
                new Funcionario("Laura", "08/07/1994", new BigDecimal("3017.45"), "Gerente"),
                new Funcionario("Heloísa", "24/05/2003", new BigDecimal("1606.85"), "Eletricista"),
                new Funcionario("Helena", "02/09/1996", new BigDecimal("2799.93"), "Gerente")
        ));
    }

    /**
     * Remove funcionário da lista
     *
     * @param funcionarioNome
     */
    public void removeFuncionario(String funcionarioNome) {
        funcionarios.removeIf(f -> f.getNome().equals(funcionarioNome));
    }

    /**
     * Imprime todos os funcionários
     */
    public void imprimeTodosFuncionarios() {
        System.out.println("Imprimir todos os funcionários");

        for (Funcionario funcionario : funcionarios) {
            System.out.println("Nome: " + funcionario.getNome()
                    + "; Data de Nascimento: " + funcionario.getDataNascimentoFormatada()
                    + "; Salário: " + funcionario.getSalarioFormatado()
                    + "; Função: " + funcionario.getFuncao()
            );
        }

        System.out.println("");
    }

    /**
     * Reajusta salários dos funcionários
     */
    public void reajustaSalario() {
        funcionarios.forEach(f -> f.setReajusteSalarial(new BigDecimal(10)));
    }

    /**
     * Agrupa funcionários por função
     *
     * @return
     */
    public Map<String, List<Funcionario>> agrupaPorFuncao() {
        Map<String, List<Funcionario>> map = new HashMap<>();

        for (Funcionario funcionario : funcionarios) {
            if (!map.containsKey(funcionario.getFuncao())) {
                List<Funcionario> list = new ArrayList<>();

                list.add(funcionario);

                map.put(funcionario.getFuncao(), list);
            } else {
                map.get(funcionario.getFuncao()).add(funcionario);
            }

        }

        return map;
    }

    /**
     * Imprime funcionário por função
     *
     * @param map
     */
    public void imprimeFuncionariosPorFuncao(Map<String, List<Funcionario>> map) {
        System.out.println("Imprimir os funcionários, agrupados por função.");

        for (Map.Entry<String, List<Funcionario>> entry : map.entrySet()) {
            System.out.println("Função: " + entry.getKey() + " {");

            for (Funcionario funcionario : entry.getValue()) {
                System.out.println("\tNome: " + funcionario.getNome()
                        + "; Data de Nascimento: " + funcionario.getDataNascimentoFormatada()
                        + "; Salário: " + funcionario.getSalarioFormatado()
                        + "; Função: " + funcionario.getFuncao()
                );
            }
        }

        System.out.println("}\n");
    }

    /**
     * Imprime funcionários por mês de aniversário
     */
    public void imprimefuncionarioPorMesAniversario() {
        List<Funcionario> collect = funcionarios.stream()
                .filter(f -> f.getDataNascimento().getMonthValue() == 10 || f.getDataNascimento().getMonthValue() == 12)
                .collect(Collectors.toList());

        System.out.println("Imprimir os funcionários que fazem aniversário no mês 10 e 12.");

        for (Funcionario funcionario : collect) {
            System.out.println("Nome: " + funcionario.getNome()
                    + "; Data de Nascimento: " + funcionario.getDataNascimentoFormatada()
                    + "; Salário: " + funcionario.getSalarioFormatado()
                    + "; Função: " + funcionario.getFuncao()
            );
        }

        System.out.println("");
    }

    /**
     * Imprime funcionário com maior idade
     */
    public void imprimeFuncionarioComMaiorIdade() {
        Funcionario funcionario = funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getDataNascimento))
                .findFirst().get();

        System.out.println("Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.");

        System.out.println("Nome: " + funcionario.getNome() + "; "
                + "Idade: " + funcionario.getIdade()
        );

        System.out.println("");
    }

    /**
     * Imprime lista de funcionário em ordem alfabética
     */
    public void imprimeListaEmOrdemAlfabetica() {
        List<Funcionario> collect = funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .collect(Collectors.toList());

        System.out.println("Imprimir a lista de funcionários por ordem alfabética.");

        for (Funcionario funcionario : collect) {
            System.out.println("Nome: " + funcionario.getNome()
                    + "; Data de Nascimento: " + funcionario.getDataNascimentoFormatada()
                    + "; Salário: " + funcionario.getSalarioFormatado()
                    + "; Função: " + funcionario.getFuncao()
            );
        }

        System.out.println("");
    }

    /**
     * Imprime total dos salários
     */
    public void imprimeTotalSalarios() {
        BigDecimal total = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("Imprimir o total dos salários dos funcionários.");
        System.out.println("Total de salario: " + NumberFormat.getNumberInstance().format(total) + "\n");
    }

    /**
     * Imprime a quantidade de salários mínimos
     */
    public void imprimeQuantidadeSalarioMinimos() {
        System.out.println("Imprimir quantos salários mínimos ganha cada funcionário");

        for (Funcionario funcionario : funcionarios) {
            System.out.println("Nome: " + funcionario.getNome() +
                    "; Quantidade de Salários Mínimos: " + funcionario.getQuatidadeSalarioMinimo());
        }
    }
}
