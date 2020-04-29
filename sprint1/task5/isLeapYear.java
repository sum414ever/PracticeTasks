public static boolean isLeapYear(int year) {

    boolean isLeapYear;
    
    if(year%100 == 0){
        if(year%400 == 0){
            isLeapYear = true;
        }else isLeapYear = false;
    }else if(year%4==0){
        isLeapYear = true;
    }else isLeapYear = false;
    
    return isLeapYear;

}
