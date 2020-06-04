

class Price{// super class


    int regularPrice ;
    int discountPrice;
    int markDownPrice;


    public Price(int regularPrice){
        this.regularPrice = regularPrice;
    }

    public Price(int discountPrice,int regularPrice){
        this.regularPrice = regularPrice;
        this.discountPrice = discountPrice;

    }
    public Price(int discountPrice,int regularPrice, int markDownPrice){
        this.regularPrice = regularPrice;
        this.discountPrice = discountPrice;
        this.markDownPrice = markDownPrice;
    }
    public int getRegularPrice(){
        return regularPrice;
    }

    public int getdiscountPrice(){
        return discountPrice;
    }

    public int getMarkdownPrice(){
        return markDownPrice;
    }
    public void display(){
        System.out.println(this.getRegularPrice() +  this.getdiscountPrice() + this.getMarkdownPrice()
                );
    }

}




public class ContrcutorOverLoading {

    public static void main(String[] args){

    Price regularPrice = new Price(100);
    regularPrice.display();

    Price randDPrice = new Price(100,200);
    randDPrice.display();

    Price randDandMPrice = new Price(100,200,400);
    randDandMPrice.display();


    }

}
