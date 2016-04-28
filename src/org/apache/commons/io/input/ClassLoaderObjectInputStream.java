package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.StreamCorruptedException;
import java.lang.reflect.Proxy;

public class ClassLoaderObjectInputStream
  extends ObjectInputStream
{
  private final ClassLoader classLoader;
  
  public ClassLoaderObjectInputStream(ClassLoader classLoader, InputStream inputStream)
    throws IOException, StreamCorruptedException
  {
    super(inputStream);
    this.classLoader = classLoader;
  }
  
  protected Class<?> resolveClass(ObjectStreamClass objectStreamClass)
    throws IOException, ClassNotFoundException
  {
    Class<?> clazz = Class.forName(objectStreamClass.getName(), false, this.classLoader);
    if (clazz != null) {
      return clazz;
    }
    return super.resolveClass(objectStreamClass);
  }
  
  protected Class<?> resolveProxyClass(String[] interfaces)
    throws IOException, ClassNotFoundException
  {
    Class<?>[] interfaceClasses = new Class[interfaces.length];
    for (int i = 0; i < interfaces.length; i++) {
      interfaceClasses[i] = Class.forName(interfaces[i], false, this.classLoader);
    }
    try
    {
      return Proxy.getProxyClass(this.classLoader, interfaceClasses);
    }
    catch (IllegalArgumentException e) {}
    return super.resolveProxyClass(interfaces);
  }
}


/* Location:              C:\Users\Jens\Desktop\Spigot Server\plugins\Ancient_v1.1.0 (1).jar!\org\apache\commons\io\input\ClassLoaderObjectInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */