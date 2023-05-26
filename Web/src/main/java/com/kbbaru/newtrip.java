package com.kbbaru ;
import com.kbbaru.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newtrip extends GXProcedure
{
   public newtrip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newtrip.class ), "" );
   }

   public newtrip( int remoteHandle ,
                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public long executeUdp( short aP0 )
   {
      newtrip.this.aP1 = new long[] {0};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( short aP0 ,
                        long[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( short aP0 ,
                             long[] aP1 )
   {
      newtrip.this.AV12attractionsId = aP0;
      newtrip.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE Trips

      */
      Gxlinenro = "1" ;
      Gxcmdkey = "117" ;
      /* Execute user subroutine: 'GXDEBUG' */
      S111 ();
      if ( returnInSub )
      {
      }
      Gxlinenro = "2" ;
      Gxcmdkey = "107" ;
      /* Execute user subroutine: 'GXDEBUG' */
      S111 ();
      if ( returnInSub )
      {
      }
      A25TripsId = (short)(18) ;
      Gxlinenro = "3" ;
      Gxcmdkey = "107" ;
      /* Execute user subroutine: 'GXDEBUG' */
      S111 ();
      if ( returnInSub )
      {
      }
      A26TripsDate = GXutil.today( ) ;
      Gxlinenro = "4" ;
      Gxcmdkey = "107" ;
      /* Execute user subroutine: 'GXDEBUG' */
      S111 ();
      if ( returnInSub )
      {
      }
      A27TripsDescription = "Successfully" ;
      Gxlinenro = "5" ;
      Gxcmdkey = "127" ;
      /* Execute user subroutine: 'GXDEBUG' */
      S111 ();
      if ( returnInSub )
      {
      }
      /* Using cursor P000J2 */
      pr_default.execute(0, new Object[] {A26TripsDate, A27TripsDescription});
      /* Retrieving last key number assigned */
      /* Using cursor P000J3 */
      pr_default.execute(1);
      A25TripsId = P000J3_A25TripsId[0] ;
      pr_default.close(1);
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Trips");
      if ( (pr_default.getStatus(0) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      Gxlinenro = "6" ;
      Gxcmdkey = "107" ;
      /* Execute user subroutine: 'GXDEBUG' */
      S111 ();
      if ( returnInSub )
      {
      }
      AV11TripId = A25TripsId ;
      /*
         INSERT RECORD ON TABLE TripsAttrations

      */
      Gxlinenro = "7" ;
      Gxcmdkey = "117" ;
      /* Execute user subroutine: 'GXDEBUG' */
      S111 ();
      if ( returnInSub )
      {
      }
      Gxlinenro = "8" ;
      Gxcmdkey = "107" ;
      /* Execute user subroutine: 'GXDEBUG' */
      S111 ();
      if ( returnInSub )
      {
      }
      A25TripsId = AV11TripId ;
      Gxlinenro = "9" ;
      Gxcmdkey = "107" ;
      /* Execute user subroutine: 'GXDEBUG' */
      S111 ();
      if ( returnInSub )
      {
      }
      A9AttractionsId = AV12attractionsId ;
      Gxlinenro = "10" ;
      Gxcmdkey = "127" ;
      /* Execute user subroutine: 'GXDEBUG' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      /* Using cursor P000J4 */
      pr_default.execute(2, new Object[] {Short.valueOf(A25TripsId), Short.valueOf(A9AttractionsId)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TripsAttrations");
      if ( (pr_default.getStatus(2) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      /* Using cursor P000J6 */
      pr_default.execute(3, new Object[] {Short.valueOf(AV12attractionsId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         A40000GXC1 = P000J6_A40000GXC1[0] ;
         n40000GXC1 = P000J6_n40000GXC1[0] ;
      }
      else
      {
         A40000GXC1 = 0 ;
         n40000GXC1 = false ;
      }
      pr_default.close(3);
      Gxlinenro = "12" ;
      Gxcmdkey = "107" ;
      /* Execute user subroutine: 'GXDEBUG' */
      S111 ();
      if ( returnInSub )
      {
      }
      AV10Trips = A40000GXC1 ;
      cleanup();
   }

   public void S111( )
   {
      /* 'GXDEBUG' Routine */
      returnInSub = false ;
      Gxpgmname = "84a12160-f59b-4ad7-a683-ea4481ac23e9-19" ;
      Gxspcver = "638204259114516776" ;
      if ( AV14GXDID.doubleValue() == 0 )
      {
         AV14GXDID = DecimalUtil.doubleToDec(GXutil.rseed(GXutil.Int( DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.time( ), "."))))) ;
         AV14GXDID = DecimalUtil.doubleToDec(GXutil.random( )) ;
      }
      if ( Gxnodebug == 0 )
      {
         AV16DGXRespString = "" ;
         while ( ( ( Gxnodebug == 0 ) ) && ( ( GXutil.strcmp(AV16DGXRespString, "1") != 0 ) ) )
         {
            Gxmessage = "|" + Gxpgmname + "&" ;
            Gxmessage += "|GXLINENRO&" + Gxlinenro + "|/GXLINENRO&" ;
            Gxmessage += "|GXDID&" + GXutil.str( AV14GXDID, 12, 10) + "|/GXDID&" ;
            Gxmessage += "|GXCMDKEY&" + Gxcmdkey + "|/GXCMDKEY&" ;
            Gxmessage += "|DGXRULE&" + AV27DGXRULE + "|/DGXRULE&" ;
            if ( Gxpbspcver == 0 )
            {
               Gxmessage += "|DGXSPCVER&" + Gxspcver + "|/DGXSPCVER&" ;
               Gxpbspcver = (short)(1) ;
            }
            Gxmessage += "|Trips&" + GXutil.str( AV10Trips, 10, 0) + "|/Trips&" ;
            Gxmessage += "|Tripid&" + GXutil.str( AV11TripId, 4, 0) + "|/Tripid&" ;
            Gxmessage += "|Attractionsid&" + GXutil.str( AV12attractionsId, 4, 0) + "|/Attractionsid&" ;
            Gxmessage += "|Attractions&" + AV13Attractions.toxml(false, true, "SDTrip", "KBBaru") + "|/Attractions&" ;
            Gxmessage += "|GXD_9&" + GXutil.str( A9AttractionsId, 4, 0) + "|/GXD_9&" ;
            Gxmessage += "|GXD_25&" + GXutil.str( A25TripsId, 4, 0) + "|/GXD_25&" ;
            Gxmessage += "|GXD_27&" + A27TripsDescription + "|/GXD_27&" ;
            Gxmessage += "|GXD_26&" + GXutil.padl( GXutil.trim( GXutil.str( GXutil.day( A26TripsDate), 2, 0)), (short)(2), "0") + "/" + GXutil.padl( GXutil.trim( GXutil.str( GXutil.month( A26TripsDate), 2, 0)), (short)(2), "0") + "/" + GXutil.str( GXutil.year( A26TripsDate), 4, 0) + "|/GXD_26&" ;
            Gxmessage += "|/" + Gxpgmname + "&88&" ;
            Gxdebug.setHost( "DESKTOP-4K11GIM" );
            Gxdebug.setPort( 30123 );
            Gxdebug.setTimeout( (short)(0) );
            Gxmessage = GXutil.strReplace( Gxmessage, "<", "%27") ;
            Gxmessage = GXutil.strReplace( Gxmessage, ">", "%26") ;
            Gxmessage = GXutil.strReplace( Gxmessage, GXutil.chr( (short)(10)), "") ;
            Gxmessage = GXutil.strReplace( Gxmessage, GXutil.chr( (short)(13)), "%97") ;
            Gxmessage = PrivateUtilities.toBase64( Gxmessage) ;
            Gxmessage += "&" ;
            Gxdebug.addHeader("$$8CDATA8", Gxmessage);
            Gxdebug.execute("GET", "DebuGX");
            Gxnodebug = (byte)(Gxdebug.getErrCode()) ;
            if ( Gxnodebug != 0 )
            {
               httpContext.GX_msglist.addItem("Warning: NewTrip debuggable program. No debugger found at: DESKTOP-4K11GIM");
               httpContext.GX_msglist.addItem("Description: "+Gxdebug.getErrDescription());
            }
            else
            {
               AV16DGXRespString = GXutil.trim( Gxdebug.getString()) ;
               if ( GXutil.strcmp(AV16DGXRespString, "1") != 0 )
               {
                  if ( GXutil.strcmp(AV16DGXRespString, "STOP") == 0 )
                  {
                     /* User Code */
                     throw new RuntimeException("User Stopped");
                  }
                  AV17xmlreader.openFromString(AV16DGXRespString);
                  AV17xmlreader.setDocEncoding("UTF-8");
                  AV17xmlreader.read();
                  AV17xmlreader.close();
               }
            }
         }
      }
      AV27DGXRULE = "0" ;
   }

   protected void cleanup( )
   {
      this.aP1[0] = newtrip.this.AV10Trips;
      Application.commitDataStores(context, remoteHandle, pr_default, "newtrip");
      CloseOpenCursors();
      Gxdebug.cleanup();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxlinenro = "" ;
      Gxcmdkey = "" ;
      A26TripsDate = GXutil.nullDate() ;
      A27TripsDescription = "" ;
      scmdbuf = "" ;
      P000J3_A25TripsId = new short[1] ;
      Gx_emsg = "" ;
      P000J6_A40000GXC1 = new int[1] ;
      P000J6_n40000GXC1 = new boolean[] {false} ;
      Gxpgmname = "" ;
      Gxspcver = "" ;
      AV14GXDID = DecimalUtil.ZERO ;
      AV16DGXRespString = "" ;
      Gxmessage = "" ;
      AV27DGXRULE = "" ;
      AV13Attractions = new com.kbbaru.SdtSDTrip(remoteHandle, context);
      Gxdebug = new com.genexus.internet.HttpClient();
      AV17xmlreader = new com.genexus.xml.XMLReader();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.kbbaru.newtrip__default(),
         new Object[] {
             new Object[] {
            }
            , new Object[] {
            P000J3_A25TripsId
            }
            , new Object[] {
            }
            , new Object[] {
            P000J6_A40000GXC1, P000J6_n40000GXC1
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte Gxnodebug ;
   private short AV12attractionsId ;
   private short A25TripsId ;
   private short Gx_err ;
   private short AV11TripId ;
   private short A9AttractionsId ;
   private short Gxpbspcver ;
   private int GX_INS15 ;
   private int GX_INS16 ;
   private int A40000GXC1 ;
   private long AV10Trips ;
   private java.math.BigDecimal AV14GXDID ;
   private String Gxlinenro ;
   private String Gxcmdkey ;
   private String scmdbuf ;
   private String Gx_emsg ;
   private String Gxpgmname ;
   private String Gxspcver ;
   private String AV16DGXRespString ;
   private String Gxmessage ;
   private String AV27DGXRULE ;
   private java.util.Date A26TripsDate ;
   private boolean returnInSub ;
   private boolean n40000GXC1 ;
   private String A27TripsDescription ;
   private com.kbbaru.SdtSDTrip AV13Attractions ;
   private long[] aP1 ;
   private IDataStoreProvider pr_default ;
   private short[] P000J3_A25TripsId ;
   private int[] P000J6_A40000GXC1 ;
   private boolean[] P000J6_n40000GXC1 ;
   private com.genexus.xml.XMLReader AV17xmlreader ;
   private com.genexus.internet.HttpClient Gxdebug ;
}

final  class newtrip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P000J2", "SAVEPOINT gxupdate;INSERT INTO Trips(TripsDate, TripsDescription) VALUES(?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P000J3", "SELECT currval('TripsId') ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P000J4", "SAVEPOINT gxupdate;INSERT INTO TripsAttrations(TripsId, AttractionsId) VALUES(?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P000J6", "SELECT COALESCE( T1.GXC1, 0) AS GXC1 FROM (SELECT COUNT(*) AS GXC1 FROM (TripsAttrations T2 INNER JOIN Trips T3 ON T3.TripsId = T2.TripsId) WHERE T2.AttractionsId = ? ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setVarchar(2, (String)parms[1], 200, false);
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

