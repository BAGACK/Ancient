package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;

public class BrokenOutputStream
  extends OutputStream
{
  private final IOException exception;
  
  public BrokenOutputStream(IOException exception)
  {
    this.exception = exception;
  }
  
  public BrokenOutputStream()
  {
    this(new IOException("Broken output stream"));
  }
  
  public void write(int b)
    throws IOException
  {
    throw this.exception;
  }
  
  public void flush()
    throws IOException
  {
    throw this.exception;
  }
  
  public void close()
    throws IOException
  {
    throw this.exception;
  }
}


/* Location:              C:\Users\Jens\Desktop\Spigot Server\plugins\Ancient_v1.1.0 (1).jar!\org\apache\commons\io\output\BrokenOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */