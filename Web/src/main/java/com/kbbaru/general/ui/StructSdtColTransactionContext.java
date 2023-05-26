package com.kbbaru.general.ui ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColTransactionContext", namespace ="KBBaru")
public final  class StructSdtColTransactionContext implements Cloneable, java.io.Serializable
{
   public StructSdtColTransactionContext( )
   {
      this( -1, new ModelContext( StructSdtColTransactionContext.class ));
   }

   public StructSdtColTransactionContext( int remoteHandle ,
                                          ModelContext context )
   {
   }

   public  StructSdtColTransactionContext( java.util.Vector<StructSdtTransactionContext> value )
   {
      item = value;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   @javax.xml.bind.annotation.XmlElement(name="TransactionContext",namespace="KBBaru")
   public java.util.Vector<StructSdtTransactionContext> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtTransactionContext> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtTransactionContext> item = new java.util.Vector<>();
}

