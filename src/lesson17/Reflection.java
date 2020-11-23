package lesson17;

import lesson16.hw.Customer;
import lesson7.hw1.Director;
import lesson7.hw1.Teacher;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Reflection {
    public static void main(String[] args) {
        Object o = new Object();
        Director newDirector = new Director();
        Teacher newTeacher = new Teacher();
        Customer newCustomer = new Customer("dsgsg", "fdsd", 2);
        System.out.println(ClassInfo.getClassInfo(newCustomer));
    }
}

class ClassInfo {
    public static String getClassInfo(Object object) {
        StringBuilder sb = new StringBuilder();
        if (object.getClass().isPrimitive()
                || object.getClass().getSimpleName().equals("String")
                || object.getClass().getSimpleName().equals("Integer")
                || object.getClass().getSimpleName().equals("Long")
                || object.getClass().getSimpleName().equals("Float")
                || object.getClass().getSimpleName().equals("Double")
                || object.getClass().getSimpleName().equals("Short")
                || object.getClass().getSimpleName().equals("Character")
                || object.getClass().isArray()
                || object.getClass().getSimpleName().equals("Character")) {
            sb.append(object.toString() + " !");
        } else if (object.getClass().getSimpleName().equals("Object")) {
            sb.append("Класс Object");
        } else {
            Class<?> objectClass = object.getClass();
            sb.append("Class: " + objectClass.getSimpleName() + "\n");
            sb.append(getFieldsInfo(object))
                    .append(getConstructorsInfo(object))
                    .append(getMethodsInfo(object))
                    .append(getSuperClass(object));
        }
        return sb.toString();
    }

    private static String getFieldsInfo(Object object) {
        StringBuilder sb = new StringBuilder();
        Class<?> objectClass = object.getClass();
        Field[] fields = objectClass.getFields();
        sb.append("Fields: {");
        for (Field field : fields) {
            sb.append(" " + field.getName() + ": " + field.getType().getSimpleName());
        }
        sb.append("}\n" + "DeclaredFields: {");
        Field[] declaredFields = objectClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            sb.append(" " + declaredField.getName() + ": " + declaredField.getType().getSimpleName() + ";");
        }
        sb.append("\n");
        return sb.toString();
    }

    private static String getSuperClass(Object object) {
        StringBuilder sb = new StringBuilder();
        Class<?> superClass = object.getClass().getSuperclass();
        sb.append("SuperClass: " + superClass.getSimpleName());
        //sb.append(getClassInfo(superClass));
        return sb.toString();
    }

    private static String getMethodsInfo(Object object) {
        Class<?> objectClass = object.getClass();
        StringBuilder sb = new StringBuilder();
        Method[] methods = objectClass.getMethods();
        sb.append("\n" + "Methods: \n");
        for (Method method : methods) {
            sb.append(method.getName() + ": [");
            Parameter[] methodArgs = method.getParameters();
            for (Parameter methodArg : methodArgs) {
                sb.append(methodArg.getType().getSimpleName() + ";");
            }
            sb.append("]\n");
        }
        sb.append("\n");
        return sb.toString();
    }

    private static String getConstructorsInfo(Object object) {
        Class<?> objectClass = object.getClass();
        StringBuilder sb = new StringBuilder();
        Constructor[] constructors = objectClass.getConstructors();
        sb.append("\nConstructors: \n");
        int i = 0;
        for (Constructor constructor : constructors) {
            sb.append("Constructor " + ++i + ": ");
            Parameter[] parameters = constructor.getParameters();
            sb.append("Parameters: [");
            for (Parameter parameter : parameters) {
                sb.append(parameter.getType().getSimpleName() + ";");
            }
            sb.append("]");
        }
        sb.append("\n");
        return sb.toString();
    }
}
