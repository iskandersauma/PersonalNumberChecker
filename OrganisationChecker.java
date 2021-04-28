public class OrganisationChecker extends ValidityChecker{

    OrganisationChecker(String id){
        super(id);
    }

    public int numDigits(){
        int sum = 0;
        for(int i = 0; i < this.getId().length(); i++){
            if(Character.isDigit(this.getId().charAt(i))){
                sum++;
            }
        }
        return sum;
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
            if((len == 13 || len == 11) && i == check){
                if (this.getId().charAt(i) != '-' ) {
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
        if(!(this.getAmount() == 10 || this.getAmount() == 12) || !this.luhn() || !this.checkFormat()){
            System.out.println("Ogiltig organisationsnummer: " + this.getId());
            return false;
        }

        if(this.getAmount() == 12 && (!(this.getId().substring(0,2).equals("16") || Integer.parseInt(this.getId().substring(4,6)) >= 20))){
            System.out.println("Ogiltig organisationsnummer: " + this.getId());
            return false;
        }
        else if(this.getAmount() == 10 && !(Integer.parseInt(this.getId().substring(2,4)) >= 20)){
            System.out.println("Ogiltig organisationsnummer: " + this.getId());
            return false;
        }
        System.out.println("Giltig organisationsnummer: " + this.getId());
        return true;
    }
} 