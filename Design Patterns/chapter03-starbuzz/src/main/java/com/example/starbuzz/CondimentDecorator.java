package com.example.starbuzz;

public abstract class CondimentDecorator extends Beverage {

    protected Beverage beverage;  // beverage bị bọc bên trong

    /**
     chúng ta muốn size của condiment phải theo beverage nhưng vì nó kế thừa từ beverge nên 
     nó có size riêng và mặt định là tall, đó là điều không mong muốn, nên chúng ta phải nó thêm hàm getSize
     đề nó truy dần từ condiment tới beverage gốc
     */
    
    @Override
    public Size getSize() {
        return beverage.getSize();
    }

    public abstract String getDescription();
}
