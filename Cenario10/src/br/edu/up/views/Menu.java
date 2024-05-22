package br.edu.up.views;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import br.edu.up.Controllers.ControleSeguros;
import br.edu.up.modelos.Segurado;
import br.edu.up.modelos.Seguro;
import br.edu.up.modelos.SeguroVeiculo;
import br.edu.up.modelos.SeguroVida;
import br.edu.up.utils.*;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    ControleSeguros cs = new ControleSeguros();

    public Segurado criarSegurado(){
        String nome = Prompt.lerLinha("Informe o nome do cliente: ");
        String rg = Prompt.lerLinha("Informe o RG do cliente: ");
        String cpf = Prompt.lerLinha("Informe o CPF do cliente: ");
        String sexo = Prompt.lerLinha("Informe o sexo do cliente: ");
        String telefone = Prompt.lerLinha("Informe o telefone do cliente: ");
        String endereco = Prompt.lerLinha("Informe o endereço do cliente: ");
        String cep = Prompt.lerLinha("Informe o CEP do cliente: ");
        String cidade = Prompt.lerLinha("Informe a cidade do cliente: ");

        Segurado segurado = new Segurado(nome, rg, cpf, sexo, telefone, endereco, cep, cidade);
        return segurado;
    }

    // ---------------------------------------------------------------------------------------
    
    private void incluirSeguro() {
        int tipo = Prompt.lerInteiro("Informe o tipo de seguro (1. Vida, 2. Veículo): ");
        
        String apolice = Prompt.lerLinha("Número da apólice: ");
        List<Seguro> seguros = cs.getSeguros();
        boolean apoliceExistente = seguros.stream().anyMatch(seguro -> seguro.getApolice().equals(apolice));
    
        if (apoliceExistente) {
            Prompt.imprimir("Já existe uma apólice com esse número.");
            return;
        } 
        Segurado segurado = criarSegurado();
        double valorApolice = Prompt.lerDecimal("Informe o valor da apolice: ");
        
        System.out.print("Data de Início (yyyy-mm-dd): ");
        String dataInicioStr = scanner.next();
        LocalDate dataInicio = LocalDate.parse(dataInicioStr);
       
        System.out.print("Data Fim (yyyy-mm-dd): ");
        String dataFimStr = scanner.next();
        LocalDate dataFim = LocalDate.parse(dataFimStr);
        

        if (tipo == 1) {            
            System.out.println("Cobre doença? (true/false):");
            boolean cobreDoenca = scanner.nextBoolean();
            System.out.println("Cobre acidente? (true/false):");
            boolean cobreAcidente = scanner.nextBoolean();

            SeguroVida seguroVida = new SeguroVida(apolice, segurado, valorApolice, dataInicio, dataFim, cobreDoenca, cobreAcidente);
            if (cs.adicionarSeguro(seguroVida)) {
                System.out.println("Seguro vida incluído com sucesso.");
            } else {
                System.out.println("Número de apólice já existente.");
            }
        } else if (tipo == 2) {
            double vlrFranquia = Prompt.lerDecimal(" Informe o valor da franquia: ");
            
            System.out.print("Tem carro reserva (true/false): ");
            boolean temCarroReserva = scanner.nextBoolean();
            
            System.out.print("Cobre vidros (true/false): ");
            boolean cobreVidros = scanner.nextBoolean();
            
            SeguroVeiculo seguroVeiculo = new SeguroVeiculo(apolice, segurado, valorApolice, dataInicio, dataFim, vlrFranquia, temCarroReserva, cobreVidros);
            if (cs.adicionarSeguro(seguroVeiculo)) {
                System.out.println("Seguro de veículo incluído com sucesso.");
            } else {
                System.out.println("Número de apólice já existente.");
            }
        } else {
            System.out.println("Tipo de seguro inválido.");
        }
    }

    public String pegarApolice(){
        String apolice = Prompt.lerLinha("Informe o numero da apolice: ");
        return apolice;
    }
    
    public void menuPrincipal(){

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

        switch (opcao1) {
            case 1:
                incluirSeguro();
                continuar();
                break;
            case 2:
                Seguro seguro = cs.localizarSeguro(this);
                Prompt.imprimir(seguro);
                continuar();
                break;
            case 3:
                boolean ret = cs.excluirSeguro(this);
                if(ret == true){
                    Prompt.imprimir("excluido com sucesso.");
                }else{
                    Prompt.imprimir("erro ao excluir.");
                }
                continuar();
                break;
            case 4:
                cs.excluirTodosOsSeguros();
                continuar();
                break;
            case 5:
                List<Seguro> seguros = cs.getSeguros();
                for (Seguro seguro2 : seguros) {
                    Prompt.imprimir(seguro2);
                }
                continuar();
                break;
            case 6:
                int contador = cs.getSeguros().size();
                Prompt.imprimir("A quantidade de seguros é: " + contador);
                continuar();
                break;
            case 7:
                encerrarPrograma();
                break;
            default:
                Prompt.imprimir("Valor Inválido.");
                menuPrincipal();
                break;
        }
    }

    public void encerrarPrograma(){
        Prompt.imprimir("Encerrando o programa...");
        System.exit(7);
    }
    public void continuar(){
        Prompt.imprimir("Pressione qualquer tecla para continuar...");
        scanner.nextLine();
        menuPrincipal();
    }
}
