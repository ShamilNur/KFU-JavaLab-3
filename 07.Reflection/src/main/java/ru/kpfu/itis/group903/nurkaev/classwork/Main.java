package ru.kpfu.itis.group903.nurkaev.classwork;

import java.lang.reflect.*;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Classwork
 */

// Получить подробную информацию о полях класса
// Получить подробную информацию о методах класса
// Получить подробную информацию о конструкторах класса
// Вызвать конструктор, создать объект
// Вызвать метод над каким-либо объектом
// Задавать значения полей (в том числе приватных)
public class Main {

    public static void main(String[] args) throws Exception {
//        Class aClass0 = Component.class;
//        Class<?> aClass = Component.class;
//        Class<Component> aClass1 = Component.class;
        Class<?> aClass3 = Class.forName("ru.kpfu.itis.group903.nurkaev.classwork.Component");

        Field[] fields = aClass3.getDeclaredFields();
        for (Field field : fields) {
            StringBuilder modifiers = new StringBuilder();

            int modifiersCodes = field.getModifiers();
            if (Modifier.isFinal(modifiersCodes)) {
                modifiers.append("final");
                modifiers.append(" ");
            } else if (Modifier.isPublic(modifiersCodes)) {
                modifiers.append("public");
                modifiers.append(" ");
            } else if (Modifier.isPrivate(modifiersCodes)) {
                modifiers.append("private");
                modifiers.append(" ");
            } else if (Modifier.isStatic(modifiersCodes)) {
                modifiers.append("static");
                modifiers.append(" ");
            }

            System.out.println(modifiers.toString() + field.getType().getSimpleName() + " " + field.getName());
        }

        Method[] methods = aClass3.getDeclaredMethods();
        for (Method method : methods) {
            StringBuilder modifiers = new StringBuilder();

            int modifiersCodes = method.getModifiers();
            if (Modifier.isFinal(modifiersCodes)) {
                modifiers.append("final");
                modifiers.append(" ");
            } else if (Modifier.isPublic(modifiersCodes)) {
                modifiers.append("public");
                modifiers.append(" ");
            } else if (Modifier.isPrivate(modifiersCodes)) {
                modifiers.append("private");
                modifiers.append(" ");
            } else if (Modifier.isStatic(modifiersCodes)) {
                modifiers.append("static");
                modifiers.append(" ");
            }

            Parameter[] parameters = method.getParameters();
            StringBuilder parametersOfMethod = new StringBuilder();
            for (Parameter parameter : parameters) {
                parametersOfMethod.append(parameter.getType().getSimpleName())
                        .append(" ").append(parameter.getName()).append(",");
            }

            System.out.println(modifiers.toString() + method.getReturnType().getSimpleName() + ' ' + method.getName()
                    + '(' + parametersOfMethod.toString() + ')');
        }

//        Constructor constructors[] = aClass3.getConstructors();

        Object object = aClass3.newInstance();

        Constructor<Component> constructor = (Constructor<Component>) aClass3.getConstructor(int.class, int.class);
        Component component = constructor.newInstance(15, 20);
        System.out.println(component.getPublicField());

        Method method = aClass3.getMethod("getSumOfFields", int.class);
        Object result = method.invoke(component, 100);
        System.out.println(result);

        Field field = aClass3.getDeclaredField("privateField");
        field.setAccessible(true);
        field.setInt(component, 155);
        System.out.println(component.getPrivateField());
    }
}

