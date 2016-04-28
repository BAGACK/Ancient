package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.UUID;
import org.apache.commons.io.TaggedIOException;

public class TaggedOutputStream
  extends ProxyOutputStream
{
  private final Serializable tag = UUID.randomUUID();
  
  public TaggedOutputStream(OutputStream proxy)
  {
    super(proxy);
  }
  
  public boolean isCauseOf(Exception exception)
  {
    return TaggedIOException.isTaggedWith(exception, this.tag);
  }
  
  public void throwIfCauseOf(Exception exception)
    throws IOException
  {
    TaggedIOException.throwCauseIfTaggedWith(exception, this.tag);
  }
  
  protected void handleIOException(IOException e)
    throws IOException
  {
    throw new TaggedIOException(e, this.tag);
  }
}


/* Location:              C:\Users\Jens\Desktop\Spigot Server\plugins\Ancient_v1.1.0 (1).jar!\org\apache\commons\io\output\TaggedOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */