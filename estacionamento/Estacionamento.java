import java.time.LocalDateTime;
import java.util.*;

public class Estacionamento {
    private final List<Vaga> vagas = new ArrayList<>();
    private final Map<String, Veiculo> veiculosCadastrados = new HashMap<>(); 
    private final Map<String, Registro> estacionados = new LinkedHashMap<>();
    private final List<Registro> historico = new ArrayList<>();

    public Estacionamento(int quantidadeVagas) {
        for (int i = 1; i <= quantidadeVagas; i++) vagas.add(new Vaga(i));
    }

  
    public Veiculo buscarCadastrado(String placa) {
        return veiculosCadastrados.get(normalizar(placa));
    }

    public Veiculo cadastrarVeiculo(Veiculo v) {
        if (veiculosCadastrados.containsKey(v.getPlaca()))
            throw new IllegalArgumentException("Já existe veículo cadastrado com a placa " + v.getPlaca() + ".");
        veiculosCadastrados.put(v.getPlaca(), v);
        return v;
    }

 
    public Registro registrarEntrada(Veiculo v) {
        if (estacionados.containsKey(v.getPlaca()))
            throw new IllegalStateException("O veículo " + v.getPlaca() + " já está estacionado.");
        Vaga vaga = vagas.stream().filter(x -> !x.isOcupada()).findFirst()
                .orElseThrow(() -> new IllegalStateException("Estacionamento lotado: não há vagas disponíveis."));
        vaga.ocupar(v);
        Registro r = new Registro(v, vaga, LocalDateTime.now());
        estacionados.put(v.getPlaca(), r);
        historico.add(r);
        return r;
    }

    
    public Registro registrarSaida(String placa) {
        return registrarSaida(placa, LocalDateTime.now());
    }

 
    public Registro registrarSaida(String placa, LocalDateTime horaSaida) {
        Registro r = estacionados.get(normalizar(placa));
        if (r == null)
            throw new IllegalStateException("Não há veículo estacionado com a placa " + normalizar(placa) + ".");
        r.finalizar(horaSaida);
        r.getVaga().liberar();
        estacionados.remove(normalizar(placa));
        return r;
    }

  
    public List<Vaga> getVagas() { return Collections.unmodifiableList(vagas); }

    public long contarLivres() { return vagas.stream().filter(v -> !v.isOcupada()).count(); }

    public Collection<Registro> getEstacionados() {
        return Collections.unmodifiableCollection(estacionados.values());
    }

    public Registro consultarEstacionado(String placa) { return estacionados.get(normalizar(placa)); }

    public List<Registro> getHistorico() { return Collections.unmodifiableList(historico); }

    private String normalizar(String placa) { return placa.trim().toUpperCase(); }
}
