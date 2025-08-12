public class App {
    public static void main(String[] args) throws Exception {

        List<Funcionario> pessoas = new ArrayList<>();
        pessoas.add(new Funcionario("Maria", LocalDate.of(2020, 10, 18), new BigDecimal("2009.44"), "Operador"));
        pessoas.add(new Funcionario("João", LocalDate.of(1990, 05, 12), new BigDecimal("2284.38"), "Operador"));
        pessoas.add(new Funcionario("Caio", LocalDate.of(1961, 05, 02), new BigDecimal("9836.14"), "Coordenador"));
        pessoas.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        pessoas.add(new Funcionario("Alice", LocalDate.of(1995, 01, 05), new BigDecimal("2234.68"), "Recepcionista"));
        pessoas.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        pessoas.add(new Funcionario("Arthur", LocalDate.of(1993, 03, 31), new BigDecimal("4071.84"), "Contador"));
        pessoas.add(new Funcionario("Laura", LocalDate.of(1994, 07, 08), new BigDecimal("3017.45"), "Gerente"));
        pessoas.add(new Funcionario("Heloísa", LocalDate.of(2003, 05, 24), new BigDecimal("1606.85"), "Eletricista"));
        pessoas.add(new Funcionario("Helena", LocalDate.of(1996, 09, 02), new BigDecimal("2799.93"), "Gerente"));

        pessoas.removeIf(funcionario -> funcionario.getNome().equals("João"));
        System.out.println("Hello, World!");
    }
}
