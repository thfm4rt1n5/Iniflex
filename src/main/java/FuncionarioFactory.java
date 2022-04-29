import java.util.ArrayList;
import java.util.List;

public class FuncionarioFactory {
    private static List<Funcionario> funcionarios;

    /**
     * Cria instância única da lista
     *
     * @return
     */
    public List<Funcionario> getFuncionarios() {
        if (funcionarios == null) {
            funcionarios = new ArrayList<>();
        }

        return funcionarios;
    }
}
