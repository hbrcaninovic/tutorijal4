package ba.unsa.etf.rpr;

import java.io.File;
import java.util.ArrayList;;

public abstract class LaptopDaoFile implements LaptopDao {

    /**
     * Datoteka je tipa File i u nju se smjestaju slogovi
     * lista je lista laptopa
     */
    protected File datoteka;
    protected ArrayList<Laptop> laptopi;

    public void napuniListu(ArrayList<Laptop> laptopi)
    {
        this.laptopi=laptopi; // Uz pretpostavku da je u klasi ArrayList implmentiran kopirajuci konstruktor
    }

    public void dodajLaptopUListu(Laptop laptop)
    {
        //if(laptop==null) throw new NullPointerException("Nevalidan laptop"); Da li je potrebno
        this.laptopi.add(laptop);
    }

    public Laptop getLaptop(String procesor)
    {
        if(laptopi.isEmpty()) throw new NeodgovarajuciProcesorException("Neodgovarajuci procesor!");

        for(Laptop l:laptopi)
        {
            if(l.getProcesor().equals(procesor)) return l;
        }
        throw new NeodgovarajuciProcesorException("Neodgovarajuci procesor!");
    }

   // public void dodajLaptopUFile(Laptop laptop){}
   // public void vratiPodatkeIzDatoteke(){}




}
