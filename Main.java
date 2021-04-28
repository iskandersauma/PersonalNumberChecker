import java.util.Scanner;

public class Main {

    public static void main( String[] args ) {
        System.out.println("Giltiga personnummer");

        PersonnummerChecker vc = new PersonnummerChecker("201701102384");
        boolean test = vc.validation();
        assert test == true;

        PersonnummerChecker vc2 = new PersonnummerChecker("141206-2380");
        test = vc2.validation();
        assert test == true;

        PersonnummerChecker vc3 = new PersonnummerChecker("7101169295");
        test = vc3.validation();
        assert test == true;

        PersonnummerChecker vc4 = new PersonnummerChecker("198107249289");
        test = vc4.validation();
        assert test == true;

        PersonnummerChecker vc5 = new PersonnummerChecker("19021214-9819");
        test = vc5.validation();
        assert test == true;

        PersonnummerChecker vc6 = new PersonnummerChecker("190910199827");
        test = vc6.validation();
        assert test == true;

        PersonnummerChecker vc7 = new PersonnummerChecker("191006089807");
        test = vc7.validation();
        assert test == true;

        PersonnummerChecker vc8 = new PersonnummerChecker("192109099180");
        test = vc8.validation();
        assert test == true;

        PersonnummerChecker vc9 = new PersonnummerChecker("4607137454");
        test = vc9.validation();
        assert test == true;

        PersonnummerChecker vc10 = new PersonnummerChecker("194510168885");
        test = vc10.validation();
        assert test == true;

        PersonnummerChecker vc11 = new PersonnummerChecker("900118+9811");
        test = vc11.validation();
        assert test == true;

        PersonnummerChecker vc12 = new PersonnummerChecker("189102279800");
        test = vc12.validation();
        assert test == true;

        PersonnummerChecker vc13 = new PersonnummerChecker("189912299816");
        test = vc13.validation();
        assert test == true;


        System.out.println("Ogiltiga personnummer");
        PersonnummerChecker vc14 = new PersonnummerChecker("201701272394");
        test = vc14.validation();
        assert test == false;

        PersonnummerChecker vc15 = new PersonnummerChecker("190302299813");
        test = vc15.validation();
        assert test == false;

        System.out.println("Giltiga samordningsnummer");
        SamordningChecker sc = new SamordningChecker("190910799824");
        test = sc.validation();
        assert test == true;

        System.out.println("Giltiga organisationsnummer");
        OrganisationChecker oc = new OrganisationChecker("556614-3185");
        test = oc.validation();
        assert test == true;
        
        OrganisationChecker oc2 = new OrganisationChecker("16556601-6399");
        test = oc2.validation();
        assert test == true;

        OrganisationChecker oc3 = new OrganisationChecker("262000-1111");
        test = oc3.validation();
        assert test == true;

        OrganisationChecker oc4 = new OrganisationChecker("262000-1111");
        test = oc4.validation();
        assert test == true;

        System.out.println("\n");
        Scanner myObj = new Scanner(System.in);
        while(true){
            System.out.println("Enter 1 for personalnumber, 2 for samorningsnumber or 3 for organisationnumber");
            myObj = new Scanner(System.in);
            int opt = myObj.nextInt();
            System.out.println("Enter number (10 or 12 digits)");
            myObj = new Scanner(System.in);
            String numberString = myObj.nextLine();
            if(opt == 1){
                PersonnummerChecker pc = new PersonnummerChecker(numberString);
                pc.validation();
            }
            else if(opt == 2){
                SamordningChecker pc2 = new SamordningChecker(numberString);
                pc2.validation();
            }
            else if(opt == 3){
                OrganisationChecker pc3 = new OrganisationChecker(numberString);
                pc3.validation();
            }
            System.out.println("Enter 1 to exit or 0 to continue");
            myObj = new Scanner(System.in);
            int cont = myObj.nextInt();
            if(cont ==1){
                break;
            }
        }
    }
} 