/*
 * UCF COP3330 SUMMER 2021 ASSIGNMENT 1 SOLUTION
 * COPYRIGHT 2021 ALEXANDER DE CORTE
 */

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        TaxCalc taxCalc;
        Scanner in = new Scanner(System.in);
        String state, county;
        double subT;

        System.out.print("What is the order amount? ");
        subT = Double.parseDouble(in.nextLine());
        System.out.print("What state do you live in? ");
        state = in.nextLine();
        System.out.print("What county do you live in? ");
        county = in.nextLine();

        taxCalc = new TaxCalc(state, county);
        System.out.printf("\nThe total is $%.2f", taxCalc.applyTax(subT));
    }
}

class TaxCalc {
    private final double tax;

    public TaxCalc(String stateId, String countyId) {
        tax = (new State(stateId, countyId)).getTotalTax();
    }

    public double applyTax(double subT) {
        return subT + subT * tax;
    }
}

class State {
    private final double totalTax;

    public State(String stateId, String countyId) {
        if(stateId.equalsIgnoreCase("wi") || stateId.equalsIgnoreCase("wisconsin")) {
            double stateTax = .05;
            totalTax = stateTax + (new County(countyId).getTax());
        } else if(stateId.equalsIgnoreCase("il") ||stateId.equalsIgnoreCase("illinois")) {
            totalTax = .08;
        } else {
            totalTax = 0;
        }
    }

    public double getTotalTax() {
        return totalTax;
    }
}

class County {
    private final double countyTax;

    public County(String identifier) {
        if(identifier.equalsIgnoreCase("eau claire"))
            this.countyTax = 0.005;
        else if(identifier.equalsIgnoreCase("dunn"))
            this.countyTax = 0.004;
        else
            countyTax = 0;
    }

    public double getTax() {
        return countyTax;
    }
}
