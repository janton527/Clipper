public class Date {
    private String month;
    private int day;

    public Date (){
        this.month = "January";
        this.day = 1;
    }

    public Date (int month, int day) {

        switch (month){
            case 1:
                this.month = "January";
                break;
            case 2:
                this.month = "February";
                break;
            case 3:
                this.month = "March";
                break;
            case 4:
                this.month = "April";
                break;
            case 5:
                this.month = "May";
                break;
            case 6:
                this.month = "June";
                break;
            case 7:
                this.month = "July";
                break;
            case 8:
                this.month = "August";
                break;
            case 9:
                this.month = "September";
                break;
            case 10:
                this.month = "October";
                break;
            case 11:
                this.month = "November";
                break;
            case 12:
                this.month = "December";
                break;
        }
        this.day = day;
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
        return "" + this.getMonth() + " " + (this.getDay()+4);
    }


}
