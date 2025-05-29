public class City{
    String cName;
    int cPower;
    int cKnowledge;
    int cLegacy;
    int cFaith;
    boolean isChosen;

    City(String cName, int cPower, int cKnowledge, int cLegacy, int cFaith){
        this.cName = cName;
        this.cPower = cPower;
        this.cKnowledge = cKnowledge;
        this.cLegacy = cLegacy;
        this.cFaith = cFaith;
        this.isChosen = false;
    }
    void show(){
        System.out.print("\n" + cName + " | ");
        if(cPower == 0){
            System.out.print("Px |");
        }
        else if(cPower == 1){
            System.out.print("P+ |");
        }
        else if(cPower == 2){
            System.out.print("P++ |");
        }
        else if(cPower == -1){
            System.out.print("P- |");
        }
        else if(cPower == -2){
            System.out.print("P-- |");
        }

        if(cKnowledge == 0){
            System.out.print(" Kx |");
        }
        else if(cKnowledge == 1){
            System.out.print(" K+ |");
        }
        else if(cKnowledge == 2){
            System.out.print(" K++ |");
        }
        else if(cKnowledge == -1){
            System.out.print(" K- |");
        }
        else if(cKnowledge == -2){
            System.out.print(" K-- |");
        }

        if(cLegacy == 0){
            System.out.print(" Lx ");
        }
        else if(cLegacy == 1){
            System.out.print(" L+ ");
        }
        else if(cLegacy == 2){
            System.out.print(" L++ ");
        }
        else if(cLegacy == -1){
            System.out.print(" L- ");
        }
        else if(cLegacy == -2){
            System.out.print(" L-- ");
        }
        if (this.cFaith <= 99){
            System.out.print("| FEDE " +  cFaith + "/100");
        }
        if (this.cFaith >= 100){
            System.out.print("**CONVERTITA**");
        }
    }

    void chosen(){
        System.out.println();
        System.out.println(this.cName + " è stata scelta.");
        this.isChosen = true;
        System.out.println();
    }



    void addFaith (int rPower, int rKnowledge, int rLegacy, int era) {
        if (this.isChosen) {
            this.cFaith = (this.cFaith + (rPower * this.cPower) + (rKnowledge * this.cKnowledge) + (rLegacy * this.cLegacy) * (era+1));
            this.isChosen = false;
        } else {
            this.cFaith = (this.cFaith + (rPower * this.cPower) + (rKnowledge * this.cKnowledge) + (rLegacy * this.cLegacy));
        }
        if (this.cFaith <= 0){
            this.cFaith = 0;
        }
    }
}

