import java.time.LocalDateTime;
import java.time.Year;

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
        return "" + this.getMonth() + " " + this.getDay();
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
        } else if (monthNumber == 4 || monthNumber == 6 || monthNumber == 9 || monthNumber == 11){
            if ((this.getDay() + 4) >= 30){
                deadlineDay = (this.getDay() + 4) % 31;
                monthNumber++;
                deadlineDay++;
            }else {
                deadlineDay = this.getDay() + 4;
            }
        } else {
            if (isLeapYear){
                if ((this.getDay() + 4) >= 29){
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

        return ""  + (deadlineDay) + " " + getMonthString(monthNumber);
    }

    private boolean checkLeapYear (){

        return Year.of(year).isLeap();
    }

    private String getMonthString (int month){
        String monthString = "";

        switch (month){
            case 1:
                monthString = "January";
                break;
            case 2:
                monthString = "February";
                break;
            case 3:
                monthString = "March";
                break;
            case 4:
                monthString = "April";
                break;
            case 5:
                monthString = "May";
                break;
            case 6:
                monthString = "June";
                break;
            case 7:
                monthString = "July";
                break;
            case 8:
                monthString = "August";
                break;
            case 9:
                monthString = "September";
                break;
            case 10:
                monthString = "October";
                break;
            case 11:
                monthString = "November";
                break;
            case 12:
                monthString = "December";
                break;
        }
        return monthString;
    }
}
