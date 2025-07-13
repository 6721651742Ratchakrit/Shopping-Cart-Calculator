import java.util.ArrayList;

public class ShoppingCartCalculator {

    /*
     * คำนวณราคาสุทธิของสินค้าในตะกร้า โดยใน 1 ตะกร้ามีได้หลายสินค้า และ 1 สิ้นค้า
     * จะประกอบไปด้วยรหัสการซื้อ ชื่อสินค้า ราคาต่อชิ้น จำนวนที่ซื้อ
     * ถ้ารายการสินค้าที่เข้ามาเป็น null หรือ Empty จะ return ค่าออกเป็น 0.0
     * โดยมีส่วนลดดังนี้ ถ้าใส่ Code : BOGO : ซื้อ 1 แถม 1  ถ้าใส่ Code : BULK : หากมีสินค้าเกิน 6 ชิ้น จะได้รับส่วนลด 10%
     * ถ้าของราคาของและจำนวนของเป็นติดลบ จะข้ามสิ้นค้าชิ้นนั้นไป
     */
    public static double calculateTotalPrice(ArrayList<CartItem> items) {
    double sum =0;
        if (items == null||items.isEmpty()) {
            return 0.0;
        }
       for (CartItem cart : items) {
            if (cart.sku()=="BOGO"&&cart.quantity()>=2){
                sum += cart.price() * Math.round(cart.quantity()/2.0);
            }else if(cart.sku()=="BULK"&&cart.quantity()>= 6){
                sum += (cart.price()*cart.quantity())-(cart.price()*cart.quantity())/(100/10);
            }else{
                sum += cart.price() * cart.quantity();
            }
       }
        return sum;
    }
}