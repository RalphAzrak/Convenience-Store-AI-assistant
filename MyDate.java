package assignment1.items;

public class MyDate {
    public static int[] SUMMER_MONTHS = {6, 7, 8};
    public static int[] WINTER_MONTHS = {12, 1, 2};
    private int day;
    private int month;
    private int year;

    public MyDate(int day, int month, int year) {
        if (year < 0) {
            throw new IllegalArgumentException("Year must be a positive integer");
        }

        this.year = year;

        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must be between 1 and 12");
        }

        this.month = month;

        if (month == 2) {
            if (day < 1 || day > 28) {
                throw new IllegalArgumentException("Day must be between 1 and 28");
            }
        }

        else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            if (day <1 || day > 31) {
                throw new IllegalArgumentException("Day must be between 1 and 31");
            }
        }

        else {
            if (day <1 || day > 30) {
                throw new IllegalArgumentException("Day must be between 1 and 30");
            }
        }

        this.day = day;

    }


    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (this == o) {
            return true;
        }

        if (!(o instanceof MyDate)) {
            return false;
        }

        if (this.getDay() == ((MyDate) o).getDay()) {


            if (this.getMonth() == ((MyDate) o).getMonth()) {


                if (this.getYear() == ((MyDate) o).getYear()) {
                    return true;
                }
            }
        }
        return false;
    }


    public static MyDate today() {
        MyDate todayDate = new MyDate(java.time.LocalDate.now().getDayOfMonth(), java.time.LocalDate.now().getMonthValue(),java.time.LocalDate.now().getYear());
        return todayDate;

    }

    public String toString() {
        return this.year + "-" + this.month + "-" + this.day;
    }


}



//        if (year < 0) {
//            throw new IllegalArgumentException("Year must be a positive integer");
//        } else {
//            this.year = year;
//        }
//
//        if (month < 1 || month > 12) {
//            throw new IllegalArgumentException("Month must be between 1 and 12");
//        }
//
//        else {
//            this.month = month;
//        }
//
//       if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
//
//           if (!(day < 0 || day > 31)) {
//               this.day = day;
//           }
//
//           else {
//               throw new IllegalArgumentException("Day must be between 1 and 31");
//           }
//
//       }
//
//       else if (month == 4 || month == 6 || month == 9 || month == 11) {
//
//           if (!(day < 1 || day > 30)) {
//               this.day = day;
//           }
//
//           else {
//               throw new IllegalArgumentException("Day must be between 1 and 30");
//           }
//
//       }
//
//       else {
//           if (!(day < 1 || day > 28)) {
//               this.day = day;
//           }
//
//           else {
//               throw new IllegalArgumentException("Day must be between 1 and 29");
//           }
//       }
//
//    }