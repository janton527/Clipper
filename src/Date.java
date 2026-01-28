import java.time.LocalDateTime;

public class Date {
    private String month;
    private int monthNumber;
    private int day;
    private int year;

    public Date (){
        this(LocalDateTime.now().getMonthValue(), LocalDateTime.now().getDayOfMonth(), LocalDateTime.now().getYear());
    }

    public Date (int month, int day, int year) {

        this.month = getMonthString(month);
        this.monthNumber = month;
        this.day = day;
        this.year = year;
    }

    public String getMonth(){
        return month;
    }

    public int getDay(){
        return day;
    }

    public String toString (){
        return this.getMonth() + " " + this.getDay();
    }

    public String getDeadline (){
        int monthNumber = this.monthNumber;
        int deadlineDay;
        boolean isLeapYear = checkLeapYear();

        if (monthNumber == 1 || monthNumber == 3 || monthNumber == 5 || monthNumber == 7 || monthNumber == 8 ||
                monthNumber == 10 || monthNumber == 12){
            if ((this.getDay() + 4) >= 31){
                deadlineDay = (this.getDay() + 4) % 32;
                monthNumber++;
                deadlineDay++;
            }else{
                deadlineDay = this.getDay() + 4;
            }
        } else if (monthNumber == 2 || monthNumber == 4 || monthNumber == 6 || monthNumber == 9 || monthNumber == 11){
            if ((this.getDay() + 4) >= 30){
                deadlineDay = (this.getDay() + 4) % 31;
                monthNumber++;
                deadlineDay++;
            }else {
                deadlineDay = this.getDay() + 4;
            }
        } else {
            if (isLeapYear){
                if ((this.getDay() +4) >= 29){
                    deadlineDay = (this.getDay() +4)  % 30;
                    monthNumber++;
                    deadlineDay++;
                } else {
                    deadlineDay = this.getDay() + 4;
                }
            } else {
                if ((this.getDay() +4) >= 28){
                    deadlineDay = (this.getDay() +4) % 29;
                    monthNumber++;
                    deadlineDay++;
                }else {
                    deadlineDay = this.getDay() + 4;
                }
            }
        }

        return (deadlineDay) + " " + getMonthString(monthNumber);
    }

    private boolean checkLeapYear (){
        boolean isLeapYear;

        if (year % 4 == 0){
            if (year % 100 == 0){
                if (year % 400 == 0){
                    isLeapYear = true;
                } else {
                    isLeapYear = false;
                }
            } else {
                isLeapYear = true;
            }
        } else {
            isLeapYear = false;
        }

        return isLeapYear;
    }

    private String getMonthString (int month){

        return switch (month) {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> "";
        };
    }
}
