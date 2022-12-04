package ba.unsa.etf.rpr;

import java.io.*;
import java.util.ArrayList;

public class LaptopDaoSerializableFile implements LaptopDao {

    /**
     * Datoteka je tipa File i u nju se smjestaju slogovi
     * lista je lista laptopa
     */
    protected File datoteka;
    protected ArrayList<Laptop> laptopi;

    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        //if(laptop==null) throw new NullPointerException("Nevalidan laptop"); Da li je potrebno
        this.laptopi.add(laptop);
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {
        this.laptopi=laptopi; // Uz pretpostavku da je u klasi ArrayList implmentiran kopirajuci konstruktor ili clone ?
    }

    @Override
    public Laptop getLaptop(String procesor) {
        if(laptopi.isEmpty()) throw new NeodgovarajuciProcesorException("Neodgovarajuci procesor!");

        for(Laptop l:laptopi)
        {
            if(l.getProcesor().equals(procesor)) return l;
        }
        throw new NeodgovarajuciProcesorException("Neodgovarajuci procesor!");
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) {
        this.datoteka = new File("Laptopi.txt");
        try
        {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.datoteka));
            ArrayList<Laptop> o = (ArrayList<Laptop>) in.readObject();
        }
        catch (Exception e)
        {
            this.laptopi = new ArrayList<Laptop>();
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void vratiPodatkeIzDatoteke() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(this.datoteka));
        out.writeObject(this.laptopi);
        out.close();

    }
}
