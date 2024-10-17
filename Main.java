import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public static void main(String[] args) {
    boolean exit = false;
    int option;
    int type;
    int energy = randomNumero(), fatigue = randomNumero(), sleep = randomNumero(), hygiene = randomNumero(), weight = randomNumero();
    int[] arrayPet = {energy, fatigue, sleep, hygiene, weight};
    type = choiceType();
    String petName = askName();
    do {
        option = menu(petName, arrayPet, type);
        switch (option) {
            case 1:
                arrayPet = sleep(arrayPet, petName, type);
                break;
            case 2:
                arrayPet = play(arrayPet, petName, type);
                break;
            case 3:
                arrayPet = eat(arrayPet, petName, type);
                break;
            case 4:
                arrayPet = shower(arrayPet, petName, type);
                break;
            case 0:
                exit = true;
                System.out.println("Bye!");
                break;
        }
        if (isAlive(arrayPet, petName)){
            exit = true;
        }
    }while (!exit);
}

private static int randomNumero() {
    Random rand = new Random();
    return 40 + rand.nextInt(21);
}

private static int choiceType() {
    boolean exit = false;
    System.out.println("Welcome to Virtual pet!\nChoose a pet: \n1.Dog🐶\n2.Cat😺");
    Scanner sc = new Scanner(System.in);
    int option = 0;
    do {
        try {
            option = sc.nextInt();
            if (option == 1 || option == 2) {
                exit = true;
            } else {
                System.out.println("Invalid option");
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid option number");
            sc.next();
        }
    } while (!exit);
    return option;
}

private static String askName() {
    System.out.println("What's your pet name?");
    Scanner sc = new Scanner(System.in);
    return sc.next();
}

private static int menu(String petName, int[] arrayPet, int type) {
    Scanner sc = new Scanner(System.in);
    if (type == 1) {
        System.out.println("\nVirtual Dog🐶\n");
    } else {
        System.out.println("\nVirtual Cat😺\n");
    }
    status(petName, arrayPet);
    System.out.println("\n------------------------------------------------------------------");
    if (type == 1) {
        System.out.println("1.Sleep💤\n2.Play🪁\n3.Eat🍕\n4.Shower🚿\n0.Exit application👋");
    } else {
        System.out.println("1.Sleep💤\n2.Play🪁\n3.Eat🍕\n4.Self-cleaning🚿\n0.Exit application👋");
    }
    System.out.println("------------------------------------------------------------------");
    int option = 0;
    boolean exit = false;
    do {
        try {
            option = sc.nextInt();
            if (option > 4 || option < 0) {
                System.out.println("Invalid option");
            } else {
                exit = true;
                return option;
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid option number");
            sc.next();
        }
    } while (!exit);
    return option;
}

private static int[] sleep(int[] arrayPet, String petName, int type) {
    if (type == 1) {
        arrayPet[2] = arrayPet[2] - 25;
    } else{
        arrayPet[2] = arrayPet[2] - 20;
    }
    arrayPet[1] = arrayPet[1] - 15;
    arrayPet[0] = arrayPet[0] + 15;
    System.out.println(petName + " is sleeping!");
    System.out.println("--------------");
    if (type == 1) {
        System.out.printf("|%-9s%-3s|\n", "Sleep", "-25⬇");
    }else{
        System.out.printf("|%-9s%-3s|\n", "Sleep", "-20⬇");
    }
    System.out.printf("|%-9s%-3s|\n", "Fatigue", "-15⬇");
    System.out.printf("|%-9s%-3s|\n", "Energy", "+15⬆");
    System.out.println("--------------");
    return arrayPet;
}

private static int[] play(int[] arrayPet, String petName, int type) {
    if (type == 1) {
        arrayPet[2] = arrayPet[2] + 25;
    } else{
        arrayPet[2] = arrayPet[2] + 20;
    }
    arrayPet[1] = arrayPet[1] + 15;
    arrayPet[0] = arrayPet[0] - 15;
    System.out.println(petName + " is playing!");
    System.out.println("--------------");
    if (type == 1) {
        System.out.printf("|%-9s%-3s|\n", "Sleep", "+25⬆");
    }
    if (type == 2) {
        System.out.printf("|%-9s%-3s|\n", "Sleep", "+20⬆");
    }
    System.out.printf("|%-9s%-3s|\n", "Fatigue", "+15⬆");
    System.out.printf("|%-9s%-3s|\n", "Energy", "-15⬇");
    System.out.println("--------------");
    return arrayPet;
}

private static int[] eat(int[] arrayPet, String petName, int type) {
    arrayPet[4] = arrayPet[4] + 10;
    arrayPet[3] = arrayPet[3] - 10;
    if (type == 1) {
        arrayPet[2] = arrayPet[2] + 15;
    } else {
        arrayPet[2] = arrayPet[2] + 10;
    }
    arrayPet[0] = arrayPet[0] + 10;
    System.out.println(petName + " is eating!");
    System.out.println("--------------");
    if (type == 1) {
        System.out.printf("|%-9s%-3s|\n", "Sleep", "+15⬆");
    }
    if (type == 2) {
        System.out.printf("|%-9s%-3s|\n", "Sleep", "+10⬆");
    }
    System.out.printf("|%-9s%-3s|\n", "Energy", "+10⬆");
    System.out.printf("|%-9s%-3s|\n", "Hygiene", "-10⬇");
    System.out.printf("|%-9s%-3s|\n", "Weight", "+10⬆");
    System.out.println("--------------");
    return arrayPet;
}

private static int[] shower(int[] arrayPet, String petName, int type) {
    if (type == 1) {
        arrayPet[4] = arrayPet[4] + 20;
        arrayPet[2] = arrayPet[2] - 15;
        System.out.println(petName + " is having shower!");
        System.out.println("--------------");
        System.out.printf("|%-9s%-3s|\n", "Sleep", "-15⬇");
        System.out.printf("|%-9s%-3s|\n", "Hygiene", "+20⬆");
    }else {
        System.out.println(petName + " is self-cleaning!");
        System.out.println("--------------");
        arrayPet[4] = arrayPet[4] - 20;
        arrayPet[2] = arrayPet[2] - 10;
        System.out.printf("|%-9s%-3s|\n", "Sleep", "-10⬇");
        System.out.printf("|%-9s%-3s|\n", "Hygiene", "-20⬇");
    }
    System.out.println("--------------");
    return arrayPet;
}

private static void status(String petName, int[] arrayPet) {
    System.out.printf("%s's status: | Energy: %d | Fatigue: %d | Sleep: %d | Hygiene: %d | Weight: %d |", petName, arrayPet[0], arrayPet[1], arrayPet[2], arrayPet[3], arrayPet[4]);
}

private static boolean isAlive(int[] arrayPet, String petName) {
    for (int i = 0; i < arrayPet.length; i++) {
        if (arrayPet[i] >= 100 || arrayPet[i] <= 0) {
            System.out.println("-----------------------------");
            System.out.println(petName + " is dead!!!🪦");
            status(petName, arrayPet);
            return true;
        }
    }
    return false;
}