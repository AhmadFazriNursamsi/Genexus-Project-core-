package com.kbbaru ;
import com.genexus.*;

public final  class StructSdtTrips_Attrations implements Cloneable, java.io.Serializable
{
   public StructSdtTrips_Attrations( )
   {
      this( -1, new ModelContext( StructSdtTrips_Attrations.class ));
   }

   public StructSdtTrips_Attrations( int remoteHandle ,
                                     ModelContext context )
   {
      gxTv_SdtTrips_Attrations_Attractionsname = "" ;
      gxTv_SdtTrips_Attrations_Mode = "" ;
      gxTv_SdtTrips_Attrations_Attractionsname_Z = "" ;
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

   public short getAttractionsid( )
   {
      return gxTv_SdtTrips_Attrations_Attractionsid ;
   }

   public void setAttractionsid( short value )
   {
      gxTv_SdtTrips_Attrations_N = (byte)(0) ;
      gxTv_SdtTrips_Attrations_Attractionsid = value ;
   }

   public String getAttractionsname( )
   {
      return gxTv_SdtTrips_Attrations_Attractionsname ;
   }

   public void setAttractionsname( String value )
   {
      gxTv_SdtTrips_Attrations_N = (byte)(0) ;
      gxTv_SdtTrips_Attrations_Attractionsname = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtTrips_Attrations_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtTrips_Attrations_N = (byte)(0) ;
      gxTv_SdtTrips_Attrations_Mode = value ;
   }

   public short getModified( )
   {
      return gxTv_SdtTrips_Attrations_Modified ;
   }

   public void setModified( short value )
   {
      gxTv_SdtTrips_Attrations_N = (byte)(0) ;
      gxTv_SdtTrips_Attrations_Modified = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtTrips_Attrations_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtTrips_Attrations_N = (byte)(0) ;
      gxTv_SdtTrips_Attrations_Initialized = value ;
   }

   public short getAttractionsid_Z( )
   {
      return gxTv_SdtTrips_Attrations_Attractionsid_Z ;
   }

   public void setAttractionsid_Z( short value )
   {
      gxTv_SdtTrips_Attrations_N = (byte)(0) ;
      gxTv_SdtTrips_Attrations_Attractionsid_Z = value ;
   }

   public String getAttractionsname_Z( )
   {
      return gxTv_SdtTrips_Attrations_Attractionsname_Z ;
   }

   public void setAttractionsname_Z( String value )
   {
      gxTv_SdtTrips_Attrations_N = (byte)(0) ;
      gxTv_SdtTrips_Attrations_Attractionsname_Z = value ;
   }

   private byte gxTv_SdtTrips_Attrations_N ;
   protected short gxTv_SdtTrips_Attrations_Attractionsid ;
   protected short gxTv_SdtTrips_Attrations_Modified ;
   protected short gxTv_SdtTrips_Attrations_Initialized ;
   protected short gxTv_SdtTrips_Attrations_Attractionsid_Z ;
   protected String gxTv_SdtTrips_Attrations_Mode ;
   protected String gxTv_SdtTrips_Attrations_Attractionsname ;
   protected String gxTv_SdtTrips_Attrations_Attractionsname_Z ;
}

