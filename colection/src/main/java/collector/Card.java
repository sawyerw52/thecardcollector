package collector;


/**
 * The card class stores all of the information of a single card
 * Has its own enum for setname which can convert back and fourth between the setname boolean and a string that is more descriptive
 */
public class Card {
    private String name;
    private int year;
    private int cardNumber;
    private SetName set;
    private Boolean signed;
    private int numbering;




    /**
     * 
     * Constructs a card
     * 
     * @param name
     * @param year
     * @param cardNumber
     * @param set
     * @param signed
     * @param numbering
     */
    public Card(String name,int year,int cardNumber,SetName set, Boolean signed,int numbering){
        this.name = name;
        this.year = year;
        this.cardNumber = cardNumber;
        this.set = set;
        this.signed = signed;
        this.numbering = numbering;
    }


    /**
     * 
     * Constructs a card
     * 
     * @param name
     * @param year
     * @param cardNumber
     * @param set
     * @param signed
     */
    public Card(String name,int year,int cardNumber,SetName set, Boolean signed){
        this.name = name;
        this.year = year;
        this.cardNumber = cardNumber;
        this.set = set;
        this.signed = signed;
        this.numbering = 0;
    }

    /**
     * 
     * Constructs a card
     * 
     * @param name
     * @param year
     * @param cardNumber
     */
    public Card(String name, int year,int cardNumber){
        this.name = name;
        this.year = year;
        this.cardNumber = cardNumber;
    }


    
    /** 
     * @return String
     */
    public String getName() {
        return name;
    }


    
    /** 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }


    
    /** 
     * @return int
     */
    public int getYear() {
        return year;
    }

    /** 
     * @param year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /** 
     * @return int
     */
    public int getCardNumber() {
        return cardNumber;
    }

    /** 
     * @param cardNumber
     */
    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    /** 
     * @return SetName
     */
    public SetName getSet() {
        return set;
    }

    /** 
     * @param set
     */
    public void setSet(SetName set) {
        this.set = set;
    }

    /** 
     * @return Boolean
     */
    public Boolean getSigned() {
        return signed;
    }

    /** 
     * @param signed
     */
    public void setSigned(Boolean signed) {
        this.signed = signed;
    }

    /** 
     * @return int
     */
    public int getNumbering() {
        return numbering;
    }

    /** 
     * @param numbering
     */
    public void setNumbering(int numbering) {
        this.numbering = numbering;
    }

    @Override
    public String toString(){
        return "<" + "Name = " + name + ", Year " + (year - 1) + "-" + year + ", Number #" +  cardNumber + ">";
    }    

    public static void main(String[] args) {
        Card card1 = new Card("Matthew Barzal",2017,458,SetName.UDS21617,false,0);
        System.out.println(card1);
    }

}
