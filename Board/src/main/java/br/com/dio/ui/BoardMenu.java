package br.com.dio.ui;

import java.util.Scanner;

import br.com.dio.persistence.entity.BoardEntity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardMenu {

    private final Scanner scanner = new Scanner(System.in);

    private final BoardEntity entity;

    public void execute(){
        System.out.println("Bem vindo ao board %s, selecione a operação desejada", entity.getId());
        var option = -1;
        while(true){
            System.out.println("1 - criar um card");
            System.out.println("2 - mover um card");
            System.out.println("3 - bloquear um card");
            System.out.println("4 - desbloquear um card");
            System.out.println("5 - cancelar um card");
            System.out.println("6 - ver colunas");
            System.out.println("7 - ver colunas com cards");
            System.out.println("8 - ver card");
            System.out.println("9 - voltar para o menu anterior");
            System.out.println("10 - sair");
            option = scanner.nextInt();
            switch (option){
                case 1 -> createCard();
                case 2 -> moveCardToNextColumn();
                case 3 -> blockCard();
                case 4 -> unblockCard();
                case 5 -> cancelCard();
                case 6 -> showColumns();
                case 7 -> showColumn();
                case 8 -> showCard();
                case 9 -> System.out.println("Voltando para o menu anterior");
                case 10 -> System.exit(0);
                default -> System.out.println("opção inválida. Informe uma opção do menu anterior");
            }
        }
        
        private void createCard(){

        }
        private void moveCardToNextColumn(){
            
        }
        private void blockCard(){
        
        }
        private void unblockCard(){
            
        }
        private void cancelCard(){
            
        }
        private void showColumns(){
            
        }
        private void showColumn(){
            
        }
        private void showCard(){

        }
}
