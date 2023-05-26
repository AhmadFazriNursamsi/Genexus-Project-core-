package com.kbbaru ;
import com.genexus.*;

public final  class StructSdtCountry implements Cloneable, java.io.Serializable
{
   public StructSdtCountry( )
   {
      this( -1, new ModelContext( StructSdtCountry.class ));
   }

   public StructSdtCountry( int remoteHandle ,
                            ModelContext context )
   {
      gxTv_SdtCountry_Countryname = "" ;
      gxTv_SdtCountry_Mode = "" ;
      gxTv_SdtCountry_Countryname_Z = "" ;
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

   public short getCountryid( )
   {
      return gxTv_SdtCountry_Countryid ;
   }

   public void setCountryid( short value )
   {
      gxTv_SdtCountry_N = (byte)(0) ;
      gxTv_SdtCountry_Countryid = value ;
   }

   public String getCountryname( )
   {
      return gxTv_SdtCountry_Countryname ;
   }

   public void setCountryname( String value )
   {
      gxTv_SdtCountry_N = (byte)(0) ;
      gxTv_SdtCountry_Countryname = value ;
   }

   public java.util.Vector<com.kbbaru.StructSdtCountry_City> getCity( )
   {
      return gxTv_SdtCountry_City ;
   }

   public void setCity( java.util.Vector<com.kbbaru.StructSdtCountry_City> value )
   {
      gxTv_SdtCountry_N = (byte)(0) ;
      gxTv_SdtCountry_City = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtCountry_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtCountry_N = (byte)(0) ;
      gxTv_SdtCountry_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtCountry_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtCountry_N = (byte)(0) ;
      gxTv_SdtCountry_Initialized = value ;
   }

   public short getCountryid_Z( )
   {
      return gxTv_SdtCountry_Countryid_Z ;
   }

   public void setCountryid_Z( short value )
   {
      gxTv_SdtCountry_N = (byte)(0) ;
      gxTv_SdtCountry_Countryid_Z = value ;
   }

   public String getCountryname_Z( )
   {
      return gxTv_SdtCountry_Countryname_Z ;
   }

   public void setCountryname_Z( String value )
   {
      gxTv_SdtCountry_N = (byte)(0) ;
      gxTv_SdtCountry_Countryname_Z = value ;
   }

   private byte gxTv_SdtCountry_N ;
   protected short gxTv_SdtCountry_Countryid ;
   protected short gxTv_SdtCountry_Initialized ;
   protected short gxTv_SdtCountry_Countryid_Z ;
   protected String gxTv_SdtCountry_Mode ;
   protected String gxTv_SdtCountry_Countryname ;
   protected String gxTv_SdtCountry_Countryname_Z ;
   protected java.util.Vector<com.kbbaru.StructSdtCountry_City> gxTv_SdtCountry_City=null ;
}

