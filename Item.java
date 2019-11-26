import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Item {
    private SimpleStringProperty itemCode;
    private SimpleStringProperty itemName;
    private SimpleStringProperty itemType;
    private SimpleStringProperty brand;
    private SimpleIntegerProperty quantity;
    private SimpleDoubleProperty price;
    private SimpleDoubleProperty discount;
    private SimpleDoubleProperty tax;

    public Item(String ic, String name, String iType, String br, int quant, double p, double saving, double t){
        itemCode = new SimpleStringProperty(ic);
        itemName = new SimpleStringProperty(name);
        itemType = new SimpleStringProperty(iType);
        brand = new SimpleStringProperty(br);
        quantity = new SimpleIntegerProperty(quant);
        price = new SimpleDoubleProperty(p);
        discount = new SimpleDoubleProperty(saving);
        tax = new SimpleDoubleProperty(t);
    }
/*
    public double computeDiscount(){
        SimpleDoubleProperty savings = (price * quantity) * (discount/100);

        return savings.get();
    }

    public double computeTax(){
        double taxAmt = (price.multiply(quantity)).multiply((tax.divide(100)));
        return taxAmt;
    }

    public double computeTotalPrice(){
        double total = ( (price*units) - computeDiscount()) + computeTax();
        return total;
    }
*/
    public String getItemCode(){
        return itemCode.get();
    }

    public String getItemName(){
        return itemName.get();
    }

    public String getItemType(){
        return itemType.get();
    }

    public String getBrand(){
        return brand.get();
    }

    public int getQuantity(){
        return quantity.get();
    }

    public double getPrice(){
        return price.get();
    }

    public double getDiscount(){
        return discount.get();
    }

    public double getTax(){
        return tax.get();
    }

    public void setItemCode(String ic){
        itemCode.set(ic);
    }

    public void setItemName(String n){
        itemName.set(n);
    }

    public void setItemType(String it){
        itemType.set(it);
    }

    public void setBrand(String b){
        brand.set(b);
    }

    public void setQuantity(int q){
        quantity.set(q);
    }

    public void setPrice(double p){
        price.set(p);
    }

    public void setDiscount(double d){
        discount.set(d);
    }

    public void setTax(double t){
        tax.set(t);
    }
}

