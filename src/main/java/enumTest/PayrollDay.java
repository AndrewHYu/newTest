package enumTest;

/**
 * Created by Andrew  on 2017/5/6.
 */
public enum PayrollDay {
    MONDAY,TUESDAY,WEDNEDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY;
    private static final int HOURS_FIR_SHIFT = 8;
    double pay(double hoursWorked,double payRate){
        double basePay = hoursWorked * payRate;
        double overtimePay;
        switch (this){
            case SATURDAY:
                System.out.println("SATURDAY");
            case SUNDAY:System.out.println("SUNDAY");
                overtimePay = hoursWorked * payRate / 2;
            default:
                    System.out.println("default");
                    overtimePay = hoursWorked <= HOURS_FIR_SHIFT?
                            0:(hoursWorked=HOURS_FIR_SHIFT) * payRate /2;
                    break;
        }
        return basePay + overtimePay;
    }
}
