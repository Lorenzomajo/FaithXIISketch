import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int turno = 1;
        int era = 0;
        int sceltaEra1 = 0;
        String start = null;

        Religion religion = new Religion(null, 1, 1, 1);
        String rName = religion.rName;
        int rPower = religion.rPower;
        int rKnowledge = religion.rKnowledge;
        int rLegacy = religion.rLegacy;

        City cityA = new City("Alicarnasso", 1, 1, 1, 0);
        City cityB = new City("Bisanzio", 2, -2, 1, 0);
        City cityC = new City("Cnosso", 1, 2, -2, 0);
        City cityD = new City("Delo", -2, 1, 2, 0);
        City cityE = new City("Efeso", -1, 1, 0, 0);
        City cityF = new City("Farsalo", 1, -1, 0, 0);
        City cityG = new City("Gallipoli", 0, 1, -1, 0);

        try {
            //WELCOME
            while (start == null) {
                System.out.println("*****FAITH XII*****");
                System.out.println("Crea la tua divinità e converti il maggior numero di città possibili!");
                System.out.println();
                System.out.println("Premi INVIO per giocare");
                start = scanner.nextLine();
            }

            Thread.sleep(250);
            while (era == 0) {
                //RELIGIONE
                System.out.println("**********************************");
                System.out.print("Scegli il nome della tua divinità: ");
                rName = scanner.nextLine();
                if (rName.isEmpty()) {
                    System.out.println();
                    continue;
                } else {
                    break;
                }
            }

            while (era == 0) {
                System.out.println();
                System.out.println(rName.toUpperCase() + ", divinità de...");
                System.out.println("1. delle arti");
                System.out.println("2. della caccia");
                System.out.println("3. del commercio");
                System.out.println("4. della forgia");
                System.out.println("5. della guerra");
                System.out.println("6. del mare");
                sceltaEra1 = scanner.nextInt();

                if (sceltaEra1 == 1) {
                    rLegacy += 2;
                    rKnowledge += 1;
                    showName(rName);
                    showPKL(rPower, rKnowledge, rLegacy);
                    era = 1;
                } else if (sceltaEra1 == 2) {
                    rPower += 2;
                    rKnowledge += 1;
                    showName(rName);
                    showPKL(rPower, rKnowledge, rLegacy);
                    era = 1;
                } else if (sceltaEra1 == 3) {
                    rLegacy += 2;
                    rPower += 1;
                    showName(rName);
                    showPKL(rPower, rKnowledge, rLegacy);
                    era = 1;
                } else if (sceltaEra1 == 4) {
                    rKnowledge += 2;
                    rPower += 1;
                    showName(rName);
                    showPKL(rPower, rKnowledge, rLegacy);
                    era = 1;
                } else if (sceltaEra1 == 5) {
                    rPower += 2;
                    rKnowledge += 1;
                    showName(rName);
                    showPKL(rPower, rKnowledge, rLegacy);
                    era = 1;
                } else if (sceltaEra1 == 6) {
                    rLegacy += 2;
                    rKnowledge += 1;
                    showName(rName);
                    showPKL(rPower, rKnowledge, rLegacy);
                    era = 1;
                } else {
                    System.out.println(sceltaEra1 + " non è nella lista.");
                    continue;
                }
            }

            //CONTINUA
                System.out.println();
                System.out.println("Premi INVIO per continuare...");
                scanner.nextLine();
                String continua = scanner.nextLine();
                for(int i = 1; i <= 3; i++){
                    System.out.print("* ");
                    Thread.sleep(500);
                }

            for (int i = 1; i <= 11; i++) {
                if (turno == 5){
                    era = 2;
                    System.out.println("ERA II");
                    while(era == 2){
                        System.out.println("Proclama una festività:");
                        System.out.println("1. " + rName.toUpperCase() + "limpiadi (+P)");
                        System.out.println("2. " + rName.toUpperCase() + "ione (+K)");
                        System.out.println("3. " +rName.toUpperCase() + "analia (+L)");
                        int sceltaEra2 = scanner.nextInt();
                        if(sceltaEra2 == 1){
                            rPower += 2;
                            break;
                        }
                        else if(sceltaEra2 == 2){
                            rKnowledge += 2;
                            break;
                        }
                        else if(sceltaEra2 == 3){
                            rLegacy += 2;
                            break;
                        }
                        else{
                            System.out.println(sceltaEra2 + " non è nella lista.");
                            continue;
                        }
                    }
                }

                if (turno == 9){
                    era = 3;
                    System.out.println("ERA III");
                    while(era == 3){
                        System.out.println("Erigi un monumento in tuo onore:");
                        System.out.println("1. Colosso (+P)");
                        System.out.println("2. Biblioteca (+K)");
                        System.out.println("3. Obelisco (+L)");
                        int sceltaEra3 = scanner.nextInt();
                        if(sceltaEra3 == 1){
                            rPower += 3;
                            break;
                        }
                        else if(sceltaEra3 == 2){
                            rKnowledge += 3;
                            break;
                        }
                        else if(sceltaEra3 == 3){
                            rLegacy += 3;
                            break;
                        }
                        else{
                            System.out.println(sceltaEra3 + " non è nella lista.");
                            continue;
                        }
                    }
                }

                System.out.println();
                showName(rName);
                showPKL(rPower, rKnowledge, rLegacy);
                showState(era, turno);

                //SCELTA CITTA
                char cChoice = '0';
                System.out.println();
                System.out.println("*****--nome del posto--*****");
                showCities(cityA, cityB, cityC, cityD, cityE, cityF, cityG);
                System.out.println();
                while(cChoice != '1'){
                    System.out.print("\nscegli la tua città (indica la lettera iniziale): ");
                    cChoice = scanner.next().toUpperCase().charAt(0);
                    if(cChoice == 'A'){
                        cityA.chosen();
                        rPower += cityA.cPower;
                        rKnowledge += cityA.cKnowledge;
                        rLegacy += cityA.cLegacy;
                        Thread.sleep(500);
                        break;
                    }
                    else if(cChoice == 'B'){
                        cityB.chosen();
                        rPower += cityB.cPower;
                        rKnowledge += cityB.cKnowledge;
                        rLegacy += cityB.cLegacy;
                        Thread.sleep(500);
                        break;
                    }
                    else if(cChoice == 'C'){
                        cityC.chosen();
                        rPower += cityC.cPower;
                        rKnowledge += cityC.cKnowledge;
                        rLegacy += cityC.cLegacy;
                        Thread.sleep(500);
                        break;
                    }
                    else if(cChoice == 'D'){
                        cityD.chosen();
                        rPower += cityD.cPower;
                        rKnowledge += cityD.cKnowledge;
                        rLegacy += cityD.cLegacy;
                        Thread.sleep(500);
                        break;
                    }
                    else if(cChoice == 'E'){
                        cityE.chosen();
                        rPower += cityE.cPower;
                        rKnowledge += cityE.cKnowledge;
                        rLegacy += cityE.cLegacy;
                        Thread.sleep(500);
                        break;
                    }
                    else if(cChoice == 'F'){
                        cityF.chosen();
                        rPower += cityF.cPower;
                        rKnowledge += cityF.cKnowledge;
                        rLegacy += cityF.cLegacy;
                        Thread.sleep(500);
                        break;
                    }
                    else if(cChoice == 'G'){
                        cityG.chosen();
                        rPower += cityG.cPower;
                        rKnowledge += cityG.cKnowledge;
                        rLegacy += cityG.cLegacy;
                        Thread.sleep(500);
                        break;
                    }
                    else{
                        System.out.println("scelta invalida");
                        Thread.sleep(500);
                        continue;
                    }
                }

                //FINE TURNO
                cityA.addFaith(rPower, rKnowledge, rLegacy, era);
                cityB.addFaith(rPower, rKnowledge, rLegacy, era);
                cityC.addFaith(rPower, rKnowledge, rLegacy, era);
                cityD.addFaith(rPower, rKnowledge, rLegacy, era);
                cityE.addFaith(rPower, rKnowledge, rLegacy, era);
                cityF.addFaith(rPower, rKnowledge, rLegacy, era);
                cityG.addFaith(rPower, rKnowledge, rLegacy, era);
                turno++;
                Thread.sleep(250);

            }

            System.out.println();
            System.out.println("*****FINE DEI GIOCHI*****");
            showName(rName);
            showPKL(rPower, rKnowledge, rLegacy);
            showState(era, turno);
            showCities(cityA, cityB, cityC, cityD, cityE, cityF, cityG);
            //WIN CONDITION

        }
        catch (InterruptedException e) {
            System.out.println("thread interrotto (InterruptedException)");
        }

    }

    static void showState(int era, int turno){
        System.out.println("[ERA " + era + " TURNO " + turno + "]");
    }

    static void showName(String nome) {
        System.out.println("*****" + nome.toUpperCase() + "*****");
    }

    static void showPKL(int rPower, int rKnowledge, int rLegacy) {
        System.out.println("POWER " + rPower);
        System.out.println("KNOWLEDGE " + rKnowledge);
        System.out.println("LEGACY " + rLegacy);

    }

    static void showCities(City cityA, City cityB, City cityC, City cityD, City cityE, City cityF, City cityG) {
        cityA.show();
        cityB.show();
        cityC.show();
        cityD.show();
        cityE.show();
        cityF.show();
        cityG.show();
    }

}
