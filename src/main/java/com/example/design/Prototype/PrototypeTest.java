package com.example.design.Prototype;

import lombok.Data;

import java.io.*;

/**
 * 原型模式
 */
public class PrototypeTest {
    public static void main(String[] args) {
        Porduct porduct = new Porduct("productName", "partA", "partB", "partC",new BaseInfo("companyName"));
        try {
            Porduct clone = porduct.clone();
            System.out.println(porduct);
            System.out.println(clone);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

@Data
class BaseInfo implements Cloneable,Serializable{
    private static final long serialVersionUID = 63L;
    private String companyName;
    public BaseInfo(String companyName) {
        this.companyName = companyName;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    protected BaseInfo clone() throws CloneNotSupportedException {
        return (BaseInfo) super.clone();
    }

    @Override
    public String toString() {
        return "BaseInfo{" +
                "hashCode='" + this.hashCode() + '\'' +
                "companyName='" + companyName + '\'' +
                '}';
    }
}

class Porduct implements Cloneable , Serializable   {
    private static final long serialVersionUID = 32L;
    private String name;
    private String partA;
    private String partB;
    private String partC;

    private BaseInfo baseInfo;

    public Porduct(String name , String partA, String partB, String partC,BaseInfo baseInfo) {
        this.name = name;
        this.partA = partA;
        this.partB = partB;
        this.partC = partC;
        this.baseInfo = baseInfo;
    }

    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    @Override
    public String toString() {
        return  "Porduct{" +
                "hashCode='" + this.hashCode() + '\'' +
                "name='" + name + '\'' +
                ", partA='" + partA + '\'' +
                ", partB='" + partB + '\'' +
                ", partC='" + partC + '\'' +
                ", baseInfo=" + baseInfo +
                '}';
    }

    @Override
    protected Porduct clone() throws CloneNotSupportedException {
//        Porduct clone = (Porduct) super.clone();
//        BaseInfo clone1 = baseInfo.clone();
//        clone.setBaseInfo(clone1);
        //v2 序列化不推荐
        //速度慢 性能差 会产生大量的临时变量
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream)) {
            oos.writeObject(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        try (ObjectInputStream ois = new ObjectInputStream(byteArrayInputStream)) {
            return (Porduct) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
