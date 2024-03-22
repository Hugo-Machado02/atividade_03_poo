import java.util.Scanner;
import java.util.ArrayList;
public class Banco {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Conta> contas = new ArrayList<Conta>();

        int op = 0;
        do{
            System.out.println("\n\n========================== Menu ==========================");
            System.out.println("1  ->  Criar uma nova conta");
            System.out.println("2  ->  Exibir Saldo");
            System.out.println("3  ->  Saque");
            System.out.println("4  ->  Deposito");
            System.out.println("5  ->  Transferência");
            System.out.println("-1 ->  Sair");
            System.out.println("----------------------------------------------------------");
            System.out.print("Selecione uma Opção: ");
            op = scan.nextInt();
            System.out.println("==========================================================");
            scan.nextLine();

            if(op == 1){
                System.out.println("\n\n================= 1 - Cadastro de Contas =================");
                System.out.print("Digite o nome do Cliente: ");
                String nome = scan.nextLine();
                System.out.print("Digite o CPF do Cliente: ");
                String cpf = scan.nextLine();
                System.out.print("Digite o Endereço: ");
                String endereco = scan.nextLine();
                System.out.print("Digite o telefone: ");
                String telefone = scan.nextLine();

                System.out.print("Digite o numero da conta: ");
                String numero = scan.nextLine();
                System.out.print("Digite a agencia: ");
                String agencia = scan.nextLine();
                System.out.print("Digite o código do banco: ");
                int codBanco = scan.nextInt();
                System.out.println("==========================================================");
                
                if(nome.equals("") || cpf.equals("") || endereco.equals("") || telefone.equals("") || numero.equals("") || agencia.equals("") || codBanco == 0){
                    System.out.println("---> Conta não cadastrada! Valores Faltando!");
                }
                else{
                    Pessoa Pessoa = new Pessoa(nome, cpf, endereco, telefone);
                    Conta Conta = new Conta(Pessoa, numero, agencia, codBanco);
                    contas.add(Conta);
                    
                    System.out.println("---> Status: Conta cadastrada");
                    System.out.println("==========================================================");
                }
            }


            //Vai buscar o resultado do Saldo
            else if(op == 2){
                System.out.println("\n\n======================= 2 - Saldo ========================");
                System.out.print("Digite o numero de sua Conta: ");
                String numConta = scan.nextLine();
                System.out.println("\n\n----------------------------------------------------------");
                boolean validacaoConta = false;

                for(int i = 0; i<contas.size(); i++){
                    Conta contaValidada = contas.get(i);
                    if(contaValidada.getNro().equals(numConta)){
                        System.out.println("---> Titular: R$ "+contaValidada.getTitular().getNome());
                        System.out.println("---> Numero da Conta: R$ "+contaValidada.getNro());
                        System.out.println("----------------------------------------------------------");
                        System.out.println("---> Saldo da Conta: R$ "+contaValidada.getSaldo());
                        validacaoConta = true;
                    }
                }
                if(validacaoConta == false){
                    System.out.println("---> Conta Não encontrada");
                }
                System.out.println("==========================================================");
            }


            //realiza o saque de um valor
            else if(op == 3){
                System.out.println("\n\n======================= 3 - Saque ========================");
                System.out.print("Digite o numero de sua Conta: ");
                String numConta = scan.nextLine();
                System.out.println("----------------------------------------------------------");
                boolean validacaoConta = false;

                for(int i = 0; i<contas.size(); i++){
                    Conta contaValidada = contas.get(i);

                    if(contaValidada.getNro().equals(numConta)){
                        System.out.print("Digite o valor do Saque: ");
                        double valorSaque = scan.nextDouble();
                        System.out.println("----------------------------------------------------------");
                        boolean validaSaque = contaValidada.sacar(valorSaque);

                        if(validaSaque == true){
                            System.out.println("---> Titular: R$ "+contaValidada.getTitular().getNome());
                            System.out.println("---> Numero da Conta: R$ "+contaValidada.getNro());
                            System.out.println("----------------------------------------------------------");

                            System.out.println("---> Saque no valor de R$ "+ valorSaque +" realizado com sucesso!");
                        }
                        else{
                            System.out.println("---> Erro ao realizar o Saque: Saldo Insuficiente!");
                        }
                        validacaoConta = true;
                    }
                }
                if(validacaoConta == false){
                    System.out.println("---> Conta Não encontrada");
                }
                System.out.println("==========================================================");
            }


            //Realiza um depósito
            else if(op == 4){
                System.out.println("\n\n====================== 4 - Deposito ======================");
                System.out.print("Digite o numero de sua Conta: ");
                String numConta = scan.nextLine();
                System.out.println("----------------------------------------------------------");
                boolean validacaoConta = false;

                for(int i = 0; i<contas.size(); i++){
                    Conta contaValidada = contas.get(i);

                    if(contaValidada.getNro().equals(numConta)){
                        System.out.print("Digite o valor do depósito: ");
                        double valorDeposito = scan.nextDouble();
                        System.out.println("----------------------------------------------------------");
                        boolean validaDeposito = contaValidada.depositar(valorDeposito);
                        validacaoConta = true;
                        
                        if(validaDeposito == true){
                            System.out.println("---> Titular: R$ "+contaValidada.getTitular().getNome());
                            System.out.println("---> Numero da Conta: R$ "+contaValidada.getNro());
                            System.out.println("----------------------------------------------------------");
                            System.out.println("---> Depósito no valor de R$ "+ valorDeposito +" realizado com sucesso!");
                        }
                        else{
                            System.out.println("---> Erro ao Realizar o Depósito!");
                        }
                        validacaoConta = true;
                    }
                }
                if(validacaoConta == false){
                    System.out.println("--->  Conta Não encontrada");
                }
                System.out.println("==========================================================");
            }

            //Realiza a transferência entre contas
            else if(op == 5){
                System.out.println("\n\n=================== 5 - Trasnferencia ====================");
                System.out.print("Digite o numero de sua Conta: ");
                String numConta = scan.nextLine();
                System.out.println("----------------------------------------------------------");
                boolean validacaoConta = false;

                for(int i = 0; i<contas.size(); i++){
                    Conta contaValidada = contas.get(i);

                    if(contaValidada.getNro().equals(numConta)){
                        boolean transferencia = false;
                        while(transferencia != true){
                            System.out.print("Digite o numero da conta que receberá a transferencia: ");
                            String numtransferencia = scan.nextLine();
                            System.out.println("----------------------------------------------------------");
                            boolean ContaVerificada = false;

                            for(int x = 0; x<contas.size(); x++){
                                Conta contaTransferencia = contas.get(x);

                                if(contaTransferencia.getNro().equals(numtransferencia)){
                                    System.out.print("Digite o Valor a ser transferido: ");
                                    Double valTransferencia = scan.nextDouble();
                                    System.out.println("----------------------------------------------------------");
                                    boolean resultTransferencia = contaValidada.transferir(valTransferencia, contaTransferencia);
                                    if(resultTransferencia == true){
                                        System.out.println("---> Transferencia no valor de R$ "+valTransferencia+" realizada com Sucesso");
                                        transferencia = true;
                                    }
                                    ContaVerificada = true;
                                }
                                
                            }
                            if(ContaVerificada == false){
                                System.out.println("Conta nao encontrada! Digite novamente!");
                                System.out.println("----------------------------------------------------------");
                            }
                        }
                        validacaoConta = true;
                    }
                }
                if(validacaoConta == false){
                    System.out.println("    --> Conta Não encontrada");
                }
                System.out.println("==========================================================");
            }
            
            //saída da aplicação
            else if(op == -1){
                System.out.println("Você saiu da Aplicação!");
            }

            //Número digitado não encontrado
            else{
                System.out.println("\n\n    --> Opcao nao reconhecida! Por favor, digite novamente!");
            }
    
        }
        while(op != -1);
    }
}