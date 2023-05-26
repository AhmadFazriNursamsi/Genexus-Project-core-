package com.kbbaru ;
import com.genexus.*;

public final  class StructSdtCountry_City implements Cloneable, java.io.Serializable
{
   public StructSdtCountry_City( )
   {
      this( -1, new ModelContext( StructSdtCountry_City.class ));
   }

   public StructSdtCountry_City( int remoteHandle ,
                                 ModelContext context )
   {
      gxTv_SdtCountry_City_Countrycityname = "" ;
      gxTv_SdtCountry_City_Mode = "" ;
      gxTv_SdtCountry_City_Countrycityname_Z = "" ;
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

   public short getCountrycityid( )
   {
      return gxTv_SdtCountry_City_Countrycityid ;
   }

   public void setCountrycityid( short value )
   {
      gxTv_SdtCountry_City_N = (byte)(0) ;
      gxTv_SdtCountry_City_Countrycityid = value ;
   }

   public String getCountrycityname( )
   {
      return gxTv_SdtCountry_City_Countrycityname ;
   }

   public void setCountrycityname( String value )
   {
      gxTv_SdtCountry_City_N = (byte)(0) ;
      gxTv_SdtCountry_City_Countrycityname = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtCountry_City_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtCountry_City_N = (byte)(0) ;
      gxTv_SdtCountry_City_Mode = value ;
   }

   public short getModified( )
   {
      return gxTv_SdtCountry_City_Modified ;
   }

   public void setModified( short value )
   {
      gxTv_SdtCountry_City_N = (byte)(0) ;
      gxTv_SdtCountry_City_Modified = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtCountry_City_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtCountry_City_N = (byte)(0) ;
      gxTv_SdtCountry_City_Initialized = value ;
   }

   public short getCountrycityid_Z( )
   {
      return gxTv_SdtCountry_City_Countrycityid_Z ;
   }

   public void setCountrycityid_Z( short value )
   {
      gxTv_SdtCountry_City_N = (byte)(0) ;
      gxTv_SdtCountry_City_Countrycityid_Z = value ;
   }

   public String getCountrycityname_Z( )
   {
      return gxTv_SdtCountry_City_Countrycityname_Z ;
   }

   public void setCountrycityname_Z( String value )
   {
      gxTv_SdtCountry_City_N = (byte)(0) ;
      gxTv_SdtCountry_City_Countrycityname_Z = value ;
   }

   private byte gxTv_SdtCountry_City_N ;
   protected short gxTv_SdtCountry_City_Countrycityid ;
   protected short gxTv_SdtCountry_City_Modified ;
   protected short gxTv_SdtCountry_City_Initialized ;
   protected short gxTv_SdtCountry_City_Countrycityid_Z ;
   protected String gxTv_SdtCountry_City_Mode ;
   protected String gxTv_SdtCountry_City_Countrycityname ;
   protected String gxTv_SdtCountry_City_Countrycityname_Z ;
}

