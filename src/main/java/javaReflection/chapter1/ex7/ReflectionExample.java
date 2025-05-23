package javaReflection.chapter1.ex7;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Dog {
    private String name = "Fido";
    private int age = 3;

    public void bark() {
        System.out.println(name + " says: Woof!");
    }

    private void secret() {
        System.out.println("🤫 This is a secret method!");
    }
}

public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        // 🟢 base object
        Dog dog = new Dog();

        // 🔵 metaobject: يمثل الكلاس نفسه
        Class<?> meta = dog.getClass();

        // 🧠 Introspection: معلومات عن الكلاس
        System.out.println("📦 Class Name: " + meta.getName());

        // 🧠 Introspection: استعراض الحقول
        System.out.println("\n🔍 Fields:");
        for (Field field : meta.getDeclaredFields()) {
            field.setAccessible(true); // للوصول للحقول الخاصة
            System.out.println("- " + field.getName() + " = " + field.get(dog));
        }

        // 🧠 Introspection: استعراض الميثودز
        System.out.println("\n🔍 Methods:");
        for (Method method : meta.getDeclaredMethods()) {
            System.out.println("- " + method.getName());
        }

        // 🚀 Dynamic Invocation: تنفيذ ميثود bark
        System.out.println("\n🚀 Calling bark() method dynamically:");
        Method barkMethod = meta.getMethod("bark");
        barkMethod.invoke(dog);

        // 🔐 استدعاء ميثود خاصة
        System.out.println("\n🔓 Calling private method secret() dynamically:");
        Method secretMethod = meta.getDeclaredMethod("secret");
        secretMethod.setAccessible(true);  // تجاوز القيود
        secretMethod.invoke(dog);

        // ✏️ تعديل قيمة private field
        System.out.println("\n✏️ Modifying private field 'name':");
        Field nameField = meta.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(dog, "Rex");

        // 🚀 استدعاء bark مجددًا بعد التعديل
        System.out.println("📢 Calling bark() again after modifying name:");
        barkMethod.invoke(dog);
    }
}