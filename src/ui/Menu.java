package ui;

import excecoes.EncerrarPrograma;
import opcoes.ServiceOpcoes;
import time.Time;
import opcoes.Opcoes;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Menu {
    private Scanner teclado;
    private ServiceOpcoes opcoes;

    public Menu() {

        System.out.println("Seja bem-vindo ao programa!");

        int opcao = -1;
        opcoes = new ServiceOpcoes();

        teclado = new Scanner(System.in);
        do {
            try {
                Opcoes.mostrarOpcoes();
                opcao = teclado.nextInt();
                System.out.println();

                if (opcao < 0 || opcao >= Opcoes.values().length) {
                    throw new InputMismatchException();
                }
                else if (Opcoes.values()[opcao] == Opcoes.MOSTRAR_TABELA) {
                    ServiceOpcoes.imprimirTabela();
                }
                else if (Opcoes.values()[opcao] == Opcoes.ADICIONAR_TIME) {
                    System.out.print("Digite o nome do time que deseja adicionar: ");
                    teclado.nextLine();
                    String nome = teclado.nextLine();

                    if(!ServiceOpcoes.timeExiste(nome)) {
                        ServiceOpcoes.adicionarTime(new Time(nome));
                        System.out.println("\nO time "+nome+" foi adicionado com sucesso!\n");
                    }else {
                        System.out.println("\nO time "+nome+" ja existe.\n");
                    }
                }
                else if(Opcoes.values()[opcao] == Opcoes.REMOVER_TIME) {
                    System.out.print("Digite o nome do time que deseja remover: ");
                    teclado.nextLine();
                    String nome = teclado.nextLine();

                    if(ServiceOpcoes.timeExiste(nome)) {
                        ServiceOpcoes.removerTime(ServiceOpcoes.getTime(nome));
                        System.out.println("\nO time "+nome+" foi removido com sucesso!\n");
                    }else {
                        System.out.print("\nO time "+nome+" nao existe.\n");
                    }
                }
                else if(Opcoes.values()[opcao] == Opcoes.REGISTRAR_PARTIDA) {

                    String[] nome = new String[2];

                    teclado.nextLine();

                    for(int i = 0; i < 2; i++) {
                        System.out.print("Digite o nome do time "+(i+1)+": ");
                        nome[i] = teclado.nextLine();

                        if (!ServiceOpcoes.timeExiste(nome[i])) {
                            do {
                                System.out.println("Este time nao existe, deseja criar um com este nome?");
                                System.out.print("0. Encerrar programa\n1. Sim\n2. Nao\nSelecione uma opcao: ");
                                if(teclado.hasNextInt())
                                    opcao = teclado.nextInt();
                                else
                                    opcao = -1;
                            }while(opcao < 0 || opcao > 2);

                            if (opcao == 0) {
                                throw new EncerrarPrograma();
                            } else if (opcao == 1) {
                                ServiceOpcoes.adicionarTime(new Time(nome[i]));
                            }
                        }
                    }

                    if(ServiceOpcoes.timeExiste(nome[0]) && ServiceOpcoes.timeExiste(nome[1])) {
                        int gols[] = new int[2];
                        for(int i = 0; i < 2; i++) {
                            do {
                                System.out.print("Gols do time " + nome[i] + ": ");
                                if(teclado.hasNextInt()) {
                                    gols[i] = teclado.nextInt();
                                }else{
                                    gols[i] = -1;
                                    teclado.next();
                                }
                            } while(gols[i] < 0);
                        }

                        ServiceOpcoes.registrarPartida(Objects.requireNonNull(ServiceOpcoes.getTime(nome[0])), Objects.requireNonNull(ServiceOpcoes.getTime(nome[1])), gols[0], gols[1]);
                    }

                }else if(Opcoes.values()[opcao] == Opcoes.SAIR) {
                    throw new EncerrarPrograma();
                }

            } catch (InputMismatchException e) {
                System.out.println("\nOpcao invalida.\n");
                teclado.nextLine();
            } catch(NullPointerException e) {
                System.out.println(e.toString());
            } catch (EncerrarPrograma e) {
                opcao = 0;
            }
        } while (opcao != 0);
        opcoes.salvarTabela();
        System.out.println("Programa encerrado!");
    }
}
