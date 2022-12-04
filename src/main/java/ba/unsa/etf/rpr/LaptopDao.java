package ba.unsa.etf.rpr;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface LaptopDao {

    public void dodajLaptopUListu(Laptop laptop);
    public void napuniListu(ArrayList<Laptop> laptopi);
    public Laptop getLaptop(String procesor);

    public void dodajLaptopUFile(Laptop laptop);
    public void vratiPodatkeIzDatoteke() throws IOException;
}
