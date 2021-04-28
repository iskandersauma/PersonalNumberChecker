public class SamordningChecker extends ValidityChecker{
    private boolean leapYear = false;
    private boolean plussign = false;

    SamordningChecker(String id){
        super(id);;
        this.leapYear = this.isLeapYear();
        this.plussign = this.hasPlusSign();
    }

    public boolean getLeapYear(){
        return this.leapYear;
    }

    public boolean getPlusSign(){
        return this.plussign;
    }

    public boolean hasPlusSign(){
        if(this.getAmount() == 10 && this.getId().charAt(6) == '+'){
            return true;
        }
        return false;
    }

    public boolean isLeapYear(){
        if(this.getAmount() == 12){
            int year = Integer.parseInt(this.getId().substring(0,4));
            if(((year % 4 == 0) && (year % 100!= 0)) || (year%400 == 0)){
                return true;
            }
        }
        else{
            int year = Integer.parseInt(this.getId().substring(0,2));
            if(this.getPlusSign() && (year%4 == 0) && year != 0){
                return true;
            }
            else if(year % 4 == 0){
                return true;
            }
        }
        return false;
    }
    public boolean checkFormat(){
        int len = this.getId().length();
        int check = -1;
        if(len == 13){
            check = 8;
        }
        else if(len == 11){
            check = 6;
        }
        else if(len > 13 || len < 10){
            return false;
        }

        for(int i = 0; i < len; i++){
            if(len == 13 && i == check){
                if (this.getId().charAt(i) != '-' ) {
                    return false; 
                }
                else{
                    continue;
                }
            }
            else if(len == 11 && i == check){
                if (!(this.getId().charAt(i) == '-' || this.getId().charAt(i) == '+')) {
                    return false;
                }
                else{
                    continue;
                }
            }
            else if(!Character.isDigit(this.getId().charAt(i))){
                return false;
            }
        }
        return true;
    }

    public boolean validation(){
        if(!(this.getAmount() == 10 || this.getAmount() == 12) || !this.luhn() || !this.checkFormat() ){
            System.out.println("Ogiltig samordningsnummer: " + this.getId());
            return false;
        }
        int month = 0;
        int day = 0;
        if(this.getAmount() == 12){
            String millenium = this.getId().substring(0,2);
            if(!(millenium.equals("18") || millenium.equals("19") || millenium.equals("20"))){ 
                System.out.println("Ogiltig samordningsnummer: " + this.getId());
                return false;
            }
            month = Integer.parseInt(this.getId().substring(4,6));
            day = Integer.parseInt(this.getId().substring(6,8));
        }
        else{
            month = Integer.parseInt(this.getId().substring(2,4));
            day = Integer.parseInt(this.getId().substring(4,6));
        }

        if(month > 12 || month == 0){
            System.out.println("Ogiltig samordningsnummer: " + this.getId());
            return false;
        }
        else if(this.getLeapYear() && month == 2 && (day > 89 || day < 61)){
            System.out.println("Ogiltig samordningsnummer: " + this.getId());
            return false;
        }
        else if(month == 2 && (day > 88 || day < 61)){
            System.out.println("Ogiltig samordningsnummer: " + this.getId());
            return false;
        }
        else if((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && (day > 91 || day < 61)){
            System.out.println("Ogiltig samordningsnummer: " + this.getId());
            return false;
        }
        else if((month == 4 || month == 6 || month == 9 || month == 11) && (day > 90 || day < 61)){
            System.out.println("Ogiltig samordningsnummer: " + this.getId());
            return false;
        }
        System.out.println("Giltig samordningsnummer: " + this.getId());
        return true;
    }
} 