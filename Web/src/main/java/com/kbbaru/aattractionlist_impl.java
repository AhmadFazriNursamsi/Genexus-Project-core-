package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class aattractionlist_impl extends GXWebReport
{
   public aattractionlist_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public void webExecute( )
   {
      if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
      {
         gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
      }
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      entryPointCalled = false ;
      gxfirstwebparm = httpContext.GetNextPar( ) ;
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( toggleJsOutput )
      {
      }
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      httpContext.setDefaultTheme("KBBaru", true);
      M_top = 0 ;
      M_bot = 6 ;
      P_lines = (int)(66-M_bot) ;
      getPrinter().GxClearAttris() ;
      add_metrics( ) ;
      lineHeight = 15 ;
      PrtOffset = 0 ;
      gxXPage = 100 ;
      gxYPage = 100 ;
      getPrinter().GxSetDocName("") ;
      try
      {
         Gx_out = "FIL" ;
         if (!initPrinter (Gx_out, gxXPage, gxYPage, "GXPRN.INI", "", "", 2, 1, 256, 16834, 11909, 0, 1, 1, 0, 1, 1) )
         {
            cleanup();
            return;
         }
         getPrinter().setModal(true) ;
         P_lines = (int)(gxYPage-(lineHeight*6)) ;
         Gx_line = (int)(P_lines+1) ;
         getPrinter().setPageLines(P_lines);
         getPrinter().setLineHeight(lineHeight);
         getPrinter().setM_top(M_top);
         getPrinter().setM_bot(M_bot);
         h0F0( false, 36) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 12, true, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("List Attraction", 333, Gx_line+0, 452, Gx_line+21, 0+256, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+36) ;
         h0F0( false, 41) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 10, true, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText("Id", 250, Gx_line+17, 265, Gx_line+34, 0+256, 0, 0, 0) ;
         getPrinter().GxDrawText("Name", 308, Gx_line+17, 352, Gx_line+34, 0+256, 0, 0, 0) ;
         getPrinter().GxDrawText("Country", 450, Gx_line+17, 500, Gx_line+34, 0, 0, 0, 0) ;
         getPrinter().GxDrawText("Photo", 567, Gx_line+17, 610, Gx_line+34, 0+256, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+41) ;
         Gxlinenro = "3" ;
         Gxcmdkey = "121" ;
         /* Execute user subroutine: 'GXDEBUG' */
         S111 ();
         if ( returnInSub )
         {
         }
         /* Using cursor P000F2 */
         pr_default.execute(0);
         while ( (pr_default.getStatus(0) != 101) )
         {
            A5CountryId = P000F2_A5CountryId[0] ;
            A40000AttractionsPhoto_GXI = P000F2_A40000AttractionsPhoto_GXI[0] ;
            A11AttractionsPhoto = P000F2_A11AttractionsPhoto[0] ;
            A6CountryName = P000F2_A6CountryName[0] ;
            A10AttractionsName = P000F2_A10AttractionsName[0] ;
            A9AttractionsId = P000F2_A9AttractionsId[0] ;
            A6CountryName = P000F2_A6CountryName[0] ;
            h0F0( false, 77) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A9AttractionsId), "ZZZ9")), 242, Gx_line+22, 275, Gx_line+37, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A10AttractionsName, "")), 308, Gx_line+22, 416, Gx_line+37, 0, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A6CountryName, "")), 442, Gx_line+22, 534, Gx_line+37, 0, 0, 0, 0) ;
            sImgUrl = ((GXutil.strcmp("", A11AttractionsPhoto)==0) ? A40000AttractionsPhoto_GXI : A11AttractionsPhoto) ;
            getPrinter().GxDrawBitMap(sImgUrl, 558, Gx_line+0, 625, Gx_line+50) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+77) ;
            Gxlinenro = "5" ;
            Gxcmdkey = "128" ;
            /* Execute user subroutine: 'GXDEBUG' */
            S111 ();
            if ( returnInSub )
            {
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
         /* Print footer for last page */
         ToSkip = (int)(P_lines+1) ;
         h0F0( true, 0) ;
         /* Close printer file */
         getPrinter().GxEndDocument() ;
         endPrinter();
      }
      catch ( ProcessInterruptedException e )
      {
      }
      if ( httpContext.willRedirect( ) )
      {
         httpContext.redirect( httpContext.wjLoc );
         httpContext.wjLoc = "" ;
      }
      cleanup();
   }

   public void S111( ) throws ProcessInterruptedException
   {
      /* 'GXDEBUG' Routine */
      returnInSub = false ;
      Gxpgmname = "84a12160-f59b-4ad7-a683-ea4481ac23e9-15" ;
      Gxspcver = "638204258915689742" ;
      if ( AV15GXDID.doubleValue() == 0 )
      {
         AV15GXDID = DecimalUtil.doubleToDec(GXutil.rseed(GXutil.Int( DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.time( ), "."))))) ;
         AV15GXDID = DecimalUtil.doubleToDec(GXutil.random( )) ;
      }
      if ( Gxnodebug == 0 )
      {
         AV17DGXRespString = "" ;
         while ( ( ( Gxnodebug == 0 ) ) && ( ( GXutil.strcmp(AV17DGXRespString, "1") != 0 ) ) )
         {
            Gxmessage = "|" + Gxpgmname + "&" ;
            Gxmessage += "|GXLINENRO&" + Gxlinenro + "|/GXLINENRO&" ;
            Gxmessage += "|GXDID&" + GXutil.str( AV15GXDID, 12, 10) + "|/GXDID&" ;
            Gxmessage += "|GXCMDKEY&" + Gxcmdkey + "|/GXCMDKEY&" ;
            Gxmessage += "|DGXRULE&" + AV28DGXRULE + "|/DGXRULE&" ;
            if ( Gxpbspcver == 0 )
            {
               Gxmessage += "|DGXSPCVER&" + Gxspcver + "|/DGXSPCVER&" ;
               Gxpbspcver = (short)(1) ;
            }
            Gxmessage += "|Countryname&" + AV12CountryName + "|/Countryname&" ;
            Gxmessage += "|Countryid&" + GXutil.str( AV13CountryId, 4, 0) + "|/Countryid&" ;
            Gxmessage += "|Attaractionsname&" + AV14AttaractionsName + "|/Attaractionsname&" ;
            Gxmessage += "|GXD_40000&" + A40000AttractionsPhoto_GXI + "|/GXD_40000&" ;
            Gxmessage += "|GXD_6&" + A6CountryName + "|/GXD_6&" ;
            Gxmessage += "|GXD_10&" + A10AttractionsName + "|/GXD_10&" ;
            Gxmessage += "|GXD_9&" + GXutil.str( A9AttractionsId, 4, 0) + "|/GXD_9&" ;
            Gxmessage += "|GXD_5&" + GXutil.str( A5CountryId, 4, 0) + "|/GXD_5&" ;
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
               httpContext.GX_msglist.addItem("Warning: AttractionList debuggable program. No debugger found at: DESKTOP-4K11GIM");
               httpContext.GX_msglist.addItem("Description: "+Gxdebug.getErrDescription());
            }
            else
            {
               AV17DGXRespString = GXutil.trim( Gxdebug.getString()) ;
               if ( GXutil.strcmp(AV17DGXRespString, "1") != 0 )
               {
                  if ( GXutil.strcmp(AV17DGXRespString, "STOP") == 0 )
                  {
                     /* User Code */
                     throw new RuntimeException("User Stopped");
                  }
                  AV18xmlreader.openFromString(AV17DGXRespString);
                  AV18xmlreader.setDocEncoding("UTF-8");
                  AV18xmlreader.read();
                  AV18xmlreader.close();
               }
            }
         }
      }
      AV28DGXRULE = "0" ;
   }

   public void h0F0( boolean bFoot ,
                     int Inc )
   {
      /* Skip the required number of lines */
      while ( ( ToSkip > 0 ) || ( Gx_line + Inc > P_lines ) )
      {
         if ( Gx_line + Inc >= P_lines )
         {
            if ( Gx_page > 0 )
            {
               /* Print footers */
               Gx_line = P_lines ;
               getPrinter().GxEndPage() ;
               if ( bFoot )
               {
                  return  ;
               }
            }
            ToSkip = 0 ;
            Gx_line = 0 ;
            Gx_page = (int)(Gx_page+1) ;
            /* Skip Margin Top Lines */
            Gx_line = (int)(Gx_line+(M_top*lineHeight)) ;
            /* Print headers */
            getPrinter().GxStartPage() ;
            getPrinter().setPage(Gx_page);
            if (true) break;
         }
         else
         {
            PrtOffset = 0 ;
            Gx_line = (int)(Gx_line+1) ;
         }
         ToSkip = (int)(ToSkip-1) ;
      }
      getPrinter().setPage(Gx_page);
   }

   public void add_metrics( )
   {
      add_metrics0( ) ;
      add_metrics1( ) ;
   }

   public void add_metrics0( )
   {
      getPrinter().setMetrics("Microsoft Sans Serif", true, false, 57, 15, 72, 163,  new int[] {47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 17, 19, 29, 34, 34, 55, 45, 15, 21, 21, 24, 36, 17, 21, 17, 17, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 21, 21, 36, 36, 36, 38, 60, 43, 45, 45, 45, 41, 38, 48, 45, 17, 34, 45, 38, 53, 45, 48, 41, 48, 45, 41, 38, 45, 41, 57, 41, 41, 38, 21, 17, 21, 36, 34, 21, 34, 38, 34, 38, 34, 21, 38, 38, 17, 17, 34, 17, 55, 38, 38, 38, 38, 24, 34, 21, 38, 33, 49, 34, 34, 31, 24, 17, 24, 36, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 17, 21, 34, 34, 34, 34, 17, 34, 21, 46, 23, 34, 36, 21, 46, 34, 25, 34, 21, 21, 21, 36, 34, 21, 20, 21, 23, 34, 52, 52, 52, 38, 45, 45, 45, 45, 45, 45, 62, 45, 41, 41, 41, 41, 17, 17, 17, 17, 45, 45, 48, 48, 48, 48, 48, 36, 48, 45, 45, 45, 45, 41, 41, 38, 34, 34, 34, 34, 34, 34, 55, 34, 34, 34, 34, 34, 17, 17, 17, 17, 38, 38, 38, 38, 38, 38, 38, 34, 38, 38, 38, 38, 38, 34, 38, 34}) ;
   }

   public void add_metrics1( )
   {
      getPrinter().setMetrics("Microsoft Sans Serif", false, false, 58, 14, 72, 171,  new int[] {48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 18, 20, 23, 36, 36, 57, 43, 12, 21, 21, 25, 37, 18, 21, 18, 18, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 18, 18, 37, 37, 37, 36, 65, 43, 43, 46, 46, 43, 39, 50, 46, 18, 32, 43, 36, 53, 46, 50, 43, 50, 46, 43, 40, 46, 43, 64, 41, 42, 39, 18, 18, 18, 27, 36, 21, 36, 36, 32, 36, 36, 18, 36, 36, 14, 15, 33, 14, 55, 36, 36, 36, 36, 21, 32, 18, 36, 33, 47, 31, 31, 31, 21, 17, 21, 37, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 18, 20, 36, 36, 36, 36, 17, 36, 21, 47, 24, 36, 37, 21, 47, 35, 26, 35, 21, 21, 21, 37, 34, 21, 21, 21, 23, 36, 53, 53, 53, 39, 43, 43, 43, 43, 43, 43, 64, 46, 43, 43, 43, 43, 18, 18, 18, 18, 46, 46, 50, 50, 50, 50, 50, 37, 50, 46, 46, 46, 46, 43, 43, 39, 36, 36, 36, 36, 36, 36, 57, 32, 36, 36, 36, 36, 18, 18, 18, 18, 36, 36, 36, 36, 36, 36, 36, 35, 39, 36, 36, 36, 36, 32, 36, 32}) ;
   }

   protected int getOutputType( )
   {
      return OUTPUT_PDF;
   }

   protected java.io.OutputStream getOutputStream( )
   {
      return httpContext.getOutputStream();
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      super.cleanup();
      Gxdebug.cleanup();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXKey = "" ;
      gxfirstwebparm = "" ;
      Gxlinenro = "" ;
      Gxcmdkey = "" ;
      scmdbuf = "" ;
      P000F2_A5CountryId = new short[1] ;
      P000F2_A40000AttractionsPhoto_GXI = new String[] {""} ;
      P000F2_A11AttractionsPhoto = new String[] {""} ;
      P000F2_A6CountryName = new String[] {""} ;
      P000F2_A10AttractionsName = new String[] {""} ;
      P000F2_A9AttractionsId = new short[1] ;
      A40000AttractionsPhoto_GXI = "" ;
      A11AttractionsPhoto = "" ;
      A6CountryName = "" ;
      A10AttractionsName = "" ;
      sImgUrl = "" ;
      Gxpgmname = "" ;
      Gxspcver = "" ;
      AV15GXDID = DecimalUtil.ZERO ;
      AV17DGXRespString = "" ;
      Gxmessage = "" ;
      AV28DGXRULE = "" ;
      AV12CountryName = "" ;
      AV14AttaractionsName = "" ;
      Gxdebug = new com.genexus.internet.HttpClient();
      AV18xmlreader = new com.genexus.xml.XMLReader();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.kbbaru.aattractionlist__default(),
         new Object[] {
             new Object[] {
            P000F2_A5CountryId, P000F2_A40000AttractionsPhoto_GXI, P000F2_A11AttractionsPhoto, P000F2_A6CountryName, P000F2_A10AttractionsName, P000F2_A9AttractionsId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_line = 0 ;
      Gx_err = (short)(0) ;
   }

   private byte Gxnodebug ;
   private short gxcookieaux ;
   private short A5CountryId ;
   private short A9AttractionsId ;
   private short Gxpbspcver ;
   private short AV13CountryId ;
   private short Gx_err ;
   private int M_top ;
   private int M_bot ;
   private int Line ;
   private int ToSkip ;
   private int PrtOffset ;
   private int Gx_OldLine ;
   private java.math.BigDecimal AV15GXDID ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String Gxlinenro ;
   private String Gxcmdkey ;
   private String scmdbuf ;
   private String sImgUrl ;
   private String Gxpgmname ;
   private String Gxspcver ;
   private String AV17DGXRespString ;
   private String Gxmessage ;
   private String AV28DGXRULE ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean returnInSub ;
   private String A40000AttractionsPhoto_GXI ;
   private String A6CountryName ;
   private String A10AttractionsName ;
   private String AV12CountryName ;
   private String AV14AttaractionsName ;
   private String A11AttractionsPhoto ;
   private IDataStoreProvider pr_default ;
   private short[] P000F2_A5CountryId ;
   private String[] P000F2_A40000AttractionsPhoto_GXI ;
   private String[] P000F2_A11AttractionsPhoto ;
   private String[] P000F2_A6CountryName ;
   private String[] P000F2_A10AttractionsName ;
   private short[] P000F2_A9AttractionsId ;
   private com.genexus.xml.XMLReader AV18xmlreader ;
   private com.genexus.internet.HttpClient Gxdebug ;
}

final  class aattractionlist__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P000F2", "SELECT T1.CountryId, T1.AttractionsPhoto_GXI, T1.AttractionsPhoto, T2.CountryName, T1.AttractionsName, T1.AttractionsId FROM (Attractions T1 INNER JOIN Country T2 ON T2.CountryId = T1.CountryId) ORDER BY T1.AttractionsId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getMultimediaUri(2);
               ((String[]) buf[2])[0] = rslt.getMultimediaFile(3, rslt.getVarchar(2));
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
      }
   }

}

