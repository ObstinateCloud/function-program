package com.lengedyun.ass;

import java.lang.reflect.Field;

/**
 * @title: AccessibleTest
 * @description: 反射赋值私有变量
 * @auther: 张健云
 * @date: 2021/4/21 19:42
 */
public class AccessibleTest {

    private int id;
    private String name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        //场景1 通new构造对象
        AccessibleTest accessibleTest2 = new AccessibleTest();
        accessibleTest2.id = 1;
        accessibleTest2.name = "name";

        Class<AccessibleTest> accessibleTest = (Class<AccessibleTest>) accessibleTest2.getClass();

        //场景2  通过类名创建对象
//        Class<AccessibleTest> accessibleTest = (Class<AccessibleTest>) Class.forName("com.lengedyun.ass.AccessibleTest");
//        AccessibleTest accessibleTest2 = accessibleTest.newInstance();


        String name = accessibleTest.getName();
        System.out.println(name);
        Field[] declaredFields = accessibleTest.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);//在其他类中访问私有变量时必须加
            Object o = declaredField.get(accessibleTest2);
            if (declaredField.getName().equals("id")) {
                declaredField.set(accessibleTest2, 100);
            }
            if(declaredField.getName().equals("name")){
                declaredField.set(accessibleTest2,"lenged");
            }
        }
        System.out.println(accessibleTest2.id+","+accessibleTest2.name);

    }

}
