package com.kbbaru ;
import com.genexus.*;

public final  class StructSdtTrips implements Cloneable, java.io.Serializable
{
   public StructSdtTrips( )
   {
      this( -1, new ModelContext( StructSdtTrips.class ));
   }

   public StructSdtTrips( int remoteHandle ,
                          ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtTrips_Tripsdate = cal.getTime() ;
      gxTv_SdtTrips_Tripsdescription = "" ;
      gxTv_SdtTrips_Mode = "" ;
      gxTv_SdtTrips_Tripsdate_Z = cal.getTime() ;
      gxTv_SdtTrips_Tripsdescription_Z = "" ;
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

   public short getTripsid( )
   {
      return gxTv_SdtTrips_Tripsid ;
   }

   public void setTripsid( short value )
   {
      gxTv_SdtTrips_N = (byte)(0) ;
      gxTv_SdtTrips_Tripsid = value ;
   }

   public java.util.Date getTripsdate( )
   {
      return gxTv_SdtTrips_Tripsdate ;
   }

   public void setTripsdate( java.util.Date value )
   {
      gxTv_SdtTrips_N = (byte)(0) ;
      gxTv_SdtTrips_Tripsdate = value ;
   }

   public String getTripsdescription( )
   {
      return gxTv_SdtTrips_Tripsdescription ;
   }

   public void setTripsdescription( String value )
   {
      gxTv_SdtTrips_N = (byte)(0) ;
      gxTv_SdtTrips_Tripsdescription = value ;
   }

   public java.util.Vector<com.kbbaru.StructSdtTrips_Attrations> getAttrations( )
   {
      return gxTv_SdtTrips_Attrations ;
   }

   public void setAttrations( java.util.Vector<com.kbbaru.StructSdtTrips_Attrations> value )
   {
      gxTv_SdtTrips_N = (byte)(0) ;
      gxTv_SdtTrips_Attrations = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtTrips_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtTrips_N = (byte)(0) ;
      gxTv_SdtTrips_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtTrips_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtTrips_N = (byte)(0) ;
      gxTv_SdtTrips_Initialized = value ;
   }

   public short getTripsid_Z( )
   {
      return gxTv_SdtTrips_Tripsid_Z ;
   }

   public void setTripsid_Z( short value )
   {
      gxTv_SdtTrips_N = (byte)(0) ;
      gxTv_SdtTrips_Tripsid_Z = value ;
   }

   public java.util.Date getTripsdate_Z( )
   {
      return gxTv_SdtTrips_Tripsdate_Z ;
   }

   public void setTripsdate_Z( java.util.Date value )
   {
      gxTv_SdtTrips_N = (byte)(0) ;
      gxTv_SdtTrips_Tripsdate_Z = value ;
   }

   public String getTripsdescription_Z( )
   {
      return gxTv_SdtTrips_Tripsdescription_Z ;
   }

   public void setTripsdescription_Z( String value )
   {
      gxTv_SdtTrips_N = (byte)(0) ;
      gxTv_SdtTrips_Tripsdescription_Z = value ;
   }

   private byte gxTv_SdtTrips_N ;
   protected short gxTv_SdtTrips_Tripsid ;
   protected short gxTv_SdtTrips_Initialized ;
   protected short gxTv_SdtTrips_Tripsid_Z ;
   protected String gxTv_SdtTrips_Mode ;
   protected String gxTv_SdtTrips_Tripsdescription ;
   protected String gxTv_SdtTrips_Tripsdescription_Z ;
   protected java.util.Date gxTv_SdtTrips_Tripsdate ;
   protected java.util.Date gxTv_SdtTrips_Tripsdate_Z ;
   protected java.util.Vector<com.kbbaru.StructSdtTrips_Attrations> gxTv_SdtTrips_Attrations=null ;
}

