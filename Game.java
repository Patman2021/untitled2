package Practicums.Practicums6;

import javax.swing.table.TableRowSorter;
import java.time.LocalDate;
import java.util.Objects;

public class Game {
    private String naam;
    private int releasJaar;
    private double nieuwprijs;

    public Game(String nm, int rJ, double nwpr) {
        this.naam = nm;
        this.releasJaar = rJ;
        this.nieuwprijs = nwpr;
    }


    public String getNaam() {
        return naam;
    }

    public double huidigeWaarde() {
        int aantalJaar = LocalDate.now().getYear() - releasJaar;
        double prijs = nieuwprijs;
        while (aantalJaar != 0) {
            prijs = prijs * 0.70;
            aantalJaar-=1;
        }
        return prijs;
    }
    @Override
    public boolean equals(Object andereObject) {
        if ((andereObject instanceof Game)) {
            Game temp= (Game) andereObject;
            if ( temp.getNaam()== this.naam && temp.releasJaar== this.releasJaar ) {
                return true;}
    }return false;}

    public  String toString(){
        String s= naam +", uitgegeven in "+ releasJaar+ "; nieuwprijs: €"+ String.format("%.2f", nieuwprijs) +" nu voor: €"+  String.format("%.2f", huidigeWaarde());
        return s;

    }
}

