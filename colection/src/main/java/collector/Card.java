package collector;

public class Card {
    private String name;
    private int year;
    private int cardNumber;
    private String set;
    private Boolean signed;
    private int numbering;





    public Card(String name,int year,int cardNumber,String set, Boolean signed,int numbering){
        this.name = name;
        this.year = year;
        this.cardNumber = cardNumber;
        this.set = set;
        this.signed = signed;
        this.numbering = numbering;
    }


    public Card(String name,int year,int cardNumber,String set, Boolean signed){
        this.name = name;
        this.year = year;
        this.cardNumber = cardNumber;
        this.set = set;
        this.signed = signed;
        this.numbering = 0;
    }

    public Card(String name, int year,int cardNumber){
        this.name = name;
        this.year = year;
        this.cardNumber = cardNumber;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getYear() {
        return year;
    }


    public void setYear(int year) {
        this.year = year;
    }


    public int getCardNumber() {
        return cardNumber;
    }


    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }


    public String getSet() {
        return set;
    }


    public void setSet(String set) {
        this.set = set;
    }


    public Boolean getSigned() {
        return signed;
    }


    public void setSigned(Boolean signed) {
        this.signed = signed;
    }


    public int getNumbering() {
        return numbering;
    }


    public void setNumbering(int numbering) {
        this.numbering = numbering;
    }

    @Override
    public String toString(){
        return "<" + "Name = " + name + ", Year" + (year - 1) + "-" + year + ", Number #" +  cardNumber + ">";
    }    

    public static void main(String[] args) {
        Card card1 = new Card("Matthew Barzal",2017,458,"Upper Deck 2016-2017 Series  Two",false,0);
        System.out.println(card1);
    }

}
