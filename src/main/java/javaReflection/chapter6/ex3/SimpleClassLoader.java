package javaReflection.chapter6.ex3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public  class SimpleClassLoader extends ClassLoader {
    private String dir;

    public SimpleClassLoader(String dir) {
        this.dir = dir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            File file = new File(dir + File.separator + name + ".class");
            byte[] bytes = new byte[(int) file.length()];
            new FileInputStream(file).read(bytes);
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException("Cannot load class: " + name, e);
        }
    }
}
