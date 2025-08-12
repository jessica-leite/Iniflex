import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {

        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2020, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        funcionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));

        // Formatação de data e moeda e impressão de funcionários
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        System.out.println("Funcionários:");
        System.out.println();
        funcionarios.forEach(funcionario -> System.out.println(funcionario.getNome() + ", " + funcionario.getDataNascimento().format(formatter) + ", "
                + currencyFormatter.format(funcionario.getSalario()) + ", " + funcionario.getFuncao()));

        funcionarios.forEach(funcionario -> {
            BigDecimal aumento = funcionario.getSalario().multiply(new BigDecimal("0.10"));
            funcionario.setSalario(funcionario.getSalario().add(aumento));
        });

        // Agrupando funcionários por cargo
        Map<String, List<Funcionario>> funcionariosPorCargo = funcionarios.stream().collect(Collectors.groupingBy(f -> f.getFuncao()));
        System.out.println();
        System.out.println("Funcionários por cargo:");
        System.out.println();
        funcionariosPorCargo.forEach((cargo, listaFuncionarios) -> {
            System.out.println(cargo);
            System.out.println();
            listaFuncionarios.forEach(funcionario -> System.out.println(funcionario.getNome()));
            System.out.println("-------------------");
        });

        // Imprimindo funcionários com aniversário nos meses 10 e 12
        System.out.println();
        System.out.println("Funcionários com aniversário em outubro e dezembro:");
        System.out.println();
        funcionarios.stream()
                .filter(funcionario -> funcionario.getDataNascimento().getMonthValue() == 10 ||
                        funcionario.getDataNascimento().getMonthValue() == 12)
                .forEach(funcionario -> System.out.println(funcionario.getNome()));

        // Funcionario com maior idade
        Funcionario funcionarioMaisVelho = funcionarios.stream()
                .min((f1, f2) -> f1.getDataNascimento().compareTo(f2.getDataNascimento()))
                .orElse(null);
        if (funcionarioMaisVelho != null) {
            System.out.println();
            System.out.println("Funcionário mais velho:");
            System.out.println(funcionarioMaisVelho.getNome() + ", " + (LocalDate.now().getYear() - funcionarioMaisVelho.getDataNascimento().getYear()) + " anos");
        }

        // Funcionários por ordem alfabética
        System.out.println();
        System.out.println("Funcionários por ordem alfabética:");
        System.out.println();
        funcionarios.stream()
                .sorted(Comparator.comparing(f -> f.getNome()))
                .forEach(funcionario -> System.out.println(funcionario.getNome()));

        // Total dos salários dos funcionários
        BigDecimal totalSalarios = BigDecimal.ZERO;
        for (Funcionario funcionario : funcionarios) {
            totalSalarios = totalSalarios.add(funcionario.getSalario());
        }
        System.out.println();
        System.out.println("Total dos salários dos funcionários:");
        System.out.println(currencyFormatter.format(totalSalarios));
    }
}
