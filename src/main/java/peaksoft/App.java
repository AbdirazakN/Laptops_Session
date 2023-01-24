package peaksoft;

import peaksoft.dao.LaptopDao;
import peaksoft.dao.LaptopDaoImpl;
import peaksoft.enums.OperationSystem;
import peaksoft.model.Laptop;
import peaksoft.services.LaptopService;
import peaksoft.services.LaptopServiceImpl;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Laptop laptops = new Laptop("Apple", OperationSystem.MACOS, 512,
                1300, LocalDate.of(2022, 12, 12));

        LaptopService laptop = new LaptopServiceImpl();
        while (true) {
            System.out.println("""
                             <<<<<<<<<<<<<<<<  COMMANDS  >>>>>>>>>>>>>>>>
                                    ||~ 1 ~||  ---  Save Laptop
                                    ||~ 2 ~||  ---  Delete By ID
                                    ||~ 3 ~||  ---  Delete All
                                    ||~ 4 ~||  ---  Find All
                                    ||~ 5 ~||  ---  Update
                                    ||~ 6 ~||  ---  Group By
                                    ||~ 7 ~||  ---  Sort By Different Column
                                    ||~ 0 ~||  ---  End the program
                                    """);
            int cmd = new Scanner(System.in).nextInt();
            if (cmd == 0) break;
            if (cmd == 1) System.out.println(laptop.saveLaptop(laptops));
            if (cmd == 2) System.out.println(laptop.deleteById(deleteById()));
            if (cmd == 3) laptop.deleteAll();
            if (cmd == 4) System.out.println(laptop.findAll());
            if (cmd == 5) System.out.println(laptop.update(update(), laptops));
            if (cmd == 6) System.out.println(laptop.groupBy());
            if (cmd == 7) System.out.println(laptop.sortByDifferentColumn(column(), ascOrDesc()));

        }
    }

    public static Long deleteById() {
        System.out.print("Enter ID to delete Laptop: ");
        return new Scanner(System.in).nextLong();
    }

    public static Long update() {
        System.out.print("Enter ID to update Laptop: ");
        return new Scanner(System.in).nextLong();
    }

    public static String column() {
        System.out.print("Enter column to sort Laptop: ");
        return new Scanner(System.in).nextLine();
    }

    public static String ascOrDesc() {
        System.out.print("Enter asc or desc to sort Laptop: ");
        return new Scanner(System.in).nextLine();
    }
}
