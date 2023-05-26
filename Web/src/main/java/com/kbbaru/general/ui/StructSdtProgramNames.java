package com.kbbaru.general.ui ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ProgramNames", namespace ="KBBaru")
public final  class StructSdtProgramNames implements Cloneable, java.io.Serializable
{
   public StructSdtProgramNames( )
   {
      this( -1, new ModelContext( StructSdtProgramNames.class ));
   }

   public StructSdtProgramNames( int remoteHandle ,
                                 ModelContext context )
   {
   }

   public  StructSdtProgramNames( java.util.Vector<StructSdtProgramNames_ProgramName> value )
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

   @javax.xml.bind.annotation.XmlElement(name="ProgramName",namespace="KBBaru")
   public java.util.Vector<StructSdtProgramNames_ProgramName> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtProgramNames_ProgramName> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtProgramNames_ProgramName> item = new java.util.Vector<>();
}

