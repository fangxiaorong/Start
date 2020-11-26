package com.fscience.demo.backend.loader;

public class ExtendClassLoader extends ClassLoader {
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        System.out.println("Load Class, " + name);
        return super.loadClass(name);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("Find Class, " + name);
        return super.findClass(name);
    }

    @Override
    protected Class<?> findClass(String moduleName, String name) {
        System.out.println("Find Class, " + moduleName + "_" + name);
        return super.findClass(moduleName, name);
    }

    @Override
    protected String findLibrary(String libname) {
        System.out.println("Find Library, " + libname);
        return super.findLibrary(libname);
    }
}
