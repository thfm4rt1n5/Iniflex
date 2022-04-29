public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FuncionarioController controller = new FuncionarioController();

        controller.insereFuncionarios();
        controller.removeFuncionario("João");
        controller.imprimeTodosFuncionarios();
        controller.reajustaSalario();

        final var funcionariosAgrupadosPorFuncao = controller.agrupaPorFuncao();

        controller.imprimeFuncionariosPorFuncao(funcionariosAgrupadosPorFuncao);
        controller.imprimefuncionarioPorMesAniversario();
        controller.imprimeFuncionarioComMaiorIdade();
        controller.imprimeListaEmOrdemAlfabetica();
        controller.imprimeTotalSalarios();
        controller.imprimeQuantidadeSalarioMinimos();
    }
}
