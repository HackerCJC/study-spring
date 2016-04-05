package org.cui.ssm.pojo;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;
import java.util.Date;

public class Items {
    private Integer id;
    // TODO 校验器测试失败
//    @Size(min = 1, max = 2, message = "${item.name.length.error}")
    private String name;

    private Float price;

    //    @NotEmpty(message = "{pic.is.null}")
    private String pic;

    private Date createtime;

    private String detail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                        ", name='" + name + '\'' +
                        ", price=" + price +
                        ", pic='" + pic + '\'' +
                        ", createtime=" + createtime +
                        ", detail='" + detail + '\''
                ;
    }


    public String toString2() {
        return "Items{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", pic='" + pic + '\'' +
                ", createtime=" + createtime +
                ", detail='" + detail + '\'' +
                '}';
    }
}