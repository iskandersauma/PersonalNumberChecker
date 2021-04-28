public class ValidityChecker {
    private String id;
    private int amount=0;

    ValidityChecker(String id){
        this.id = id;
        this.amount = this.numDigits();
    }

    public String getId(){
        return this.id;
    }

    public int getAmount(){
        return this.amount;
    }

    protected int numDigits(){
        int sum = 0;
        for(int i = 0; i < this.id.length(); i++){
            if(Character.isDigit(this.id.charAt(i))){
                sum++;
            }
        }
        return sum;
    }

    protected boolean luhn(){
        int i;
        int n = 0;
        if(this.amount == 10){
            i = 0;
        } 
        else{
            i = 2;
        }

        int sum = 0;
        int x;
        for(; i < this.id.length()-1; i++){
            if(Character.isDigit(this.id.charAt(i))){
                if(n % 2 == 0){
                    x = Character.getNumericValue(this.id.charAt(i)) * 2;
                    if(x > 9){
                        sum += (int) x%10 + x/10;
                    }
                    else{
                        sum += x;
                    }   
                }
                else{
                    x = Character.getNumericValue(this.id.charAt(i));
                    sum += x;
                }
                n++;
            }
        }
        int val = (10 - (sum % 10))%10;
        if(val == Character.getNumericValue(this.id.charAt(this.id.length()-1))){
            return true;
        }
        else{
            return false;
        }
    }
}
