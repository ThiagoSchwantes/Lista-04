package br.edu.up.views;
import java.time.LocalDate;

import br.edu.up.Controllers.ControleSeguros;
import br.edu.up.modelos.Segurado;
import br.edu.up.modelos.SeguroVeiculo;
import br.edu.up.modelos.SeguroVida;
import br.edu.up.modelos.Segurado.Sexo;
import br.edu.up.utils.Prompt;

public class Menu {
    ControleSeguros cs = new ControleSeguros();

    public void menuPrincipal(){
        Prompt.clearConsole();
        Prompt.separador();
        Prompt.imprimir("MENU PRINCIPAL");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Incluir seguro");
        Prompt.imprimir("\t2 - Localizar seguro");
        Prompt.imprimir("\t3 - Excluir seguro");
        Prompt.imprimir("\t4 - Excluir todos os seguros");
        Prompt.imprimir("\t5 - Listar todos os seguros");
        Prompt.imprimir("\t6 - Ver quantidade de seguros");
        Prompt.imprimir("\t7 - Sair");

        int opcao1 = Prompt.lerInteiro("Digite aqui: ");
        Prompt.clearConsole();

        switch (opcao1) {
            case 1:
                incluirSeguro();
                break;
            case 2:
                localizarSeguro();
                break;
            case 3:
                excluirSeguro();
                break;
            case 4:
                excluirTodosSeguros();
                break;
            case 5:
                listarTodosSeguros();
                break;
            case 6:
                quantidadeDeSeguros();
                break;
            case 7:
                encerrarPrograma();
                break;
            default:
                Prompt.imprimir("Valor Inválido.");
                break;
        }

        Prompt.separador();
        Prompt.pressionarEnter();
        Prompt.clearConsole();
        menuPrincipal();
    }

    private void incluirSeguro() {
        Prompt.separador();
        Prompt.imprimir("INCLUIR SEGURO");
        Prompt.separador();
        int tipo = 0;

        do {
            tipo = Prompt.lerInteiro("Informe o tipo de seguro (1. Vida, 2. Veículo): ");
            if(tipo == 1 || tipo == 2){
                break;
            }else{
                Prompt.imprimir("Digite corretamente!");
                Prompt.pressionarEnter();

                Prompt.clearConsole();
                Prompt.separador();
                Prompt.imprimir("INCLUIR SEGURO");
                Prompt.separador();
            }
        } while (true);
        
        String apolice = Prompt.lerLinha("Número da apólice: ");
        String seguro = cs.localizarSeguro(apolice);
    
        if (seguro != null) {
            Prompt.imprimir("Já existe uma apólice com esse número.");
            return;
        } 
        
        Prompt.clearConsole();
        Segurado segurado = criarSegurado();

        Prompt.clearConsole();
        Prompt.separador();
        Prompt.imprimir("INCLUIR SEGURO");
        Prompt.separador();
        
        double valorApolice = Prompt.lerDecimal("Informe o valor da apolice: ");

        LocalDate dataInicio = pedirData("Data de Início (yyyy-mm-dd): ");
        LocalDate dataFim = pedirData("Data Fim (yyyy-mm-dd): ");

        if (tipo == 1) {
            boolean cobreDoenca = simOuNao("Cobre doença? (s/n):");
            boolean cobreAcidente = simOuNao("Cobre acidente? (s/n):");

            SeguroVida seguroVida = new SeguroVida(apolice, segurado, valorApolice, dataInicio, dataFim, cobreDoenca, cobreAcidente);
            if (cs.adicionarSeguro(seguroVida)) {
                Prompt.imprimir("Seguro vida incluído com sucesso.");
            } else {
                Prompt.imprimir("Número de apólice já existente.");
            }
        } else if (tipo == 2) {
            double vlrFranquia = Prompt.lerDecimal(" Informe o valor da franquia: ");
            boolean temCarroReserva = simOuNao("Tem carro reserva (s/n): ");
            boolean cobreVidros = simOuNao("Cobre vidros (s/n): ");
            
            SeguroVeiculo seguroVeiculo = new SeguroVeiculo(apolice, segurado, valorApolice, dataInicio, dataFim, vlrFranquia, temCarroReserva, cobreVidros);
            if (cs.adicionarSeguro(seguroVeiculo)) {
                Prompt.imprimir("Seguro de veículo incluído com sucesso.");
            } else {
                Prompt.imprimir("Número de apólice já existente.");
            }
        } else {
            Prompt.imprimir("Tipo de seguro inválido.");
        }
    }
    
    public boolean simOuNao(String frase){
        boolean verificacao = false;
        boolean digitouErrado = true;
        do {
            
            Prompt.imprimir(frase);
            char digitado = Prompt.lerCaractere();

                if(digitado == 's' || digitado == 'n'){
                    digitouErrado = false;
                    verificacao = digitado == 's'? true : false;
                }else{
                    Prompt.imprimir("Digitado incorretamente! Digite novamente!");
                    Prompt.pressionarEnter();
                    Prompt.linhaEmBranco();
                }
        } while (digitouErrado);

        return verificacao;
    }

    public LocalDate pedirData(String solicitacao){
        do {
            Prompt.imprimir(solicitacao);
            String dataString = Prompt.lerLinha();

            try {
                return LocalDate.parse(dataString);
            } catch (Exception e) {
                Prompt.imprimir("Data digitada no formato errado! Digite novamente!");
                Prompt.pressionarEnter();
                Prompt.linhaEmBranco();
            }
        
        } while (true);
    }

    public Segurado criarSegurado(){
        Prompt.separador();
        Prompt.imprimir("CRIAR SEGURO - INFORMAÇÕES SEGURADO");
        Prompt.separador();

        String nome = Prompt.lerLinha("Informe o nome do cliente: ");
        String rg = Prompt.lerLinha("Informe o RG do cliente: ");
        String cpf = Prompt.lerLinha("Informe o CPF do cliente: ");
        String telefone = Prompt.lerLinha("Informe o telefone do cliente: ");
        String endereco = Prompt.lerLinha("Informe o endereço do cliente: ");
        String cep = Prompt.lerLinha("Informe o CEP do cliente: ");
        String cidade = Prompt.lerLinha("Informe a cidade do cliente: ");

        Sexo sexoEnum = null;
        boolean repetir = true;

        do{
            char sexo = Character.toLowerCase(Prompt.lerCaractere("Informe o sexo do cliente: (f/m)"));

            if(sexo == 'f'){
                sexoEnum = Sexo.FEMININO;
                break;
            }else if (sexo == 'm') {
                sexoEnum = Sexo.MASCULINO;
                break;
            }else{
                Prompt.imprimir("Digitado incorretamente! digite novamente!");
                Prompt.pressionarEnter();
                Prompt.linhaEmBranco();
            }
        }while(repetir);

        Segurado segurado = new Segurado(nome, rg, cpf, sexoEnum, telefone, endereco, cep, cidade);
        return segurado;
    }
    
    private void localizarSeguro() {
        Prompt.separador();
        Prompt.imprimir("LOCALIZAR SEGURO");
        Prompt.separador();

        String apolice = Prompt.lerLinha("Informe o numero da apolice: ");
        String seguro = cs.localizarSeguro(apolice);

        if(seguro == null){
            
            Prompt.separador();
            Prompt.imprimir("Nenhum seguro encontrado!");
        }else{
            
            Prompt.separador();
            Prompt.imprimir(seguro);
        }
    }

    public void excluirSeguro(){
        Prompt.separador();
        Prompt.imprimir("EXCLUIR SEGURO");
        Prompt.separador();
        
        String apolice = Prompt.lerLinha("Informe o numero da apolice: ");

        String seguro = cs.localizarSeguro(apolice);
        if(seguro != null){
            cs.excluirSeguro(apolice);

            Prompt.separador();
            Prompt.imprimir("excluido com sucesso.");
        }else{
            Prompt.separador();
            Prompt.imprimir("Nenhum seguro encontrado com essa apolice.");
        }
    }

    public void excluirTodosSeguros(){
        cs.excluirTodosOsSeguros();

        Prompt.separador();
        Prompt.imprimir("EXCLUIDO TODOS OS SEGUROS CADASTRADOS!");
    }

    private void listarTodosSeguros() {
        Prompt.separador();
        Prompt.imprimir("LISTAR TODOS OS SEGUROS");
        Prompt.separador();

        if(cs.listarTodosSeguros().equals("")){
            Prompt.imprimir("Nenhum seguro cadastrado!");
        }else{
            Prompt.imprimir(cs.listarTodosSeguros());
        }
    }

    private void quantidadeDeSeguros(){
        Prompt.separador();
        Prompt.imprimir("QUANTIDADE DE SEGUROS");
        Prompt.separador();
        
        Prompt.imprimir("A quantidade de seguros é: " + cs.getQuantidadeSeguros());
    }

    public void encerrarPrograma(){
        Prompt.imprimir("Encerrando o programa...");
        System.exit(7);
    }
}
