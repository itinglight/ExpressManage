package com.example.mavenspringboot7.entity;
import javax.persistence.*;

@Entity
@Table(name="`express_information`")
public class express_information {
    //快递单号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer express_number;
    //寄件人信息
    private String to_send_name;
    private String to_send_phone;
    private String to_send_address;
    private String to_send_detailed_address;
    //收件人信息
    private String to_receive_name;
    private String to_receive_phone;
    private String to_receive_address;
    private String to_receive_detailed_address;

    //物流状态
    private String express_static;

    //快递价格
    @Column(name="price")
    private Integer price;
    //备注
    private String express_desc;

    public express_information() {
    }

    public express_information(Integer express_number, String to_send_name, String to_send_phone, String to_send_address, String to_send_detailed_address, String to_receive_name, String to_receive_phone, String to_receive_address, String to_receive_detailed_address, String express_static, Integer price, String express_desc) {
        this.express_number = express_number;
        this.to_send_name = to_send_name;
        this.to_send_phone = to_send_phone;
        this.to_send_address = to_send_address;
        this.to_send_detailed_address = to_send_detailed_address;
        this.to_receive_name = to_receive_name;
        this.to_receive_phone = to_receive_phone;
        this.to_receive_address = to_receive_address;
        this.to_receive_detailed_address = to_receive_detailed_address;
        this.express_static = express_static;
        this.price = price;
        this.express_desc = express_desc;
    }

    public Integer getExpress_number() {
        return express_number;
    }

    public void setExpress_number(Integer express_number) {
        this.express_number = express_number;
    }

    public String getTo_send_name() {
        return to_send_name;
    }

    public void setTo_send_name(String to_send_name) {
        this.to_send_name = to_send_name;
    }

    public String getTo_send_phone() {
        return to_send_phone;
    }

    public void setTo_send_phone(String to_send_phone) {
        this.to_send_phone = to_send_phone;
    }

    public String getTo_send_address() {
        return to_send_address;
    }

    public void setTo_send_address(String to_send_address) {
        this.to_send_address = to_send_address;
    }

    public String getTo_send_detailed_address() {
        return to_send_detailed_address;
    }

    public void setTo_send_detailed_address(String to_send_detailed_address) {
        this.to_send_detailed_address = to_send_detailed_address;
    }

    public String getTo_receive_name() {
        return to_receive_name;
    }

    public void setTo_receive_name(String to_receive_name) {
        this.to_receive_name = to_receive_name;
    }

    public String getTo_receive_phone() {
        return to_receive_phone;
    }

    public void setTo_receive_phone(String to_receive_phone) {
        this.to_receive_phone = to_receive_phone;
    }

    public String getTo_receive_address() {
        return to_receive_address;
    }

    public void setTo_receive_address(String to_receive_address) {
        this.to_receive_address = to_receive_address;
    }

    public String getTo_receive_detailed_address() {
        return to_receive_detailed_address;
    }

    public void setTo_receive_detailed_address(String to_receive_detailed_address) {
        this.to_receive_detailed_address = to_receive_detailed_address;
    }

    public String getExpress_static() {
        return express_static;
    }

    public void setExpress_static(String express_static) {
        this.express_static = express_static;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getExpress_desc() {
        return express_desc;
    }

    public void setExpress_desc(String express_desc) {
        this.express_desc = express_desc;
    }

    @Override
    public String toString() {
        return "express_information{" +
                "express_number=" + express_number +
                ", to_send_name='" + to_send_name + '\'' +
                ", to_send_phone='" + to_send_phone + '\'' +
                ", to_send_address='" + to_send_address + '\'' +
                ", to_send_detailed_address='" + to_send_detailed_address + '\'' +
                ", to_receive_name='" + to_receive_name + '\'' +
                ", to_receive_phone='" + to_receive_phone + '\'' +
                ", to_receive_address='" + to_receive_address + '\'' +
                ", to_receive_detailed_address='" + to_receive_detailed_address + '\'' +
                ", express_static='" + express_static + '\'' +
                ", price=" + price +
                ", express_desc='" + express_desc + '\'' +
                '}';
    }
}