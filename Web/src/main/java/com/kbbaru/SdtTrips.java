package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtTrips extends GxSilentTrnSdt
{
   public SdtTrips( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtTrips.class));
   }

   public SdtTrips( int remoteHandle ,
                    ModelContext context )
   {
      super( remoteHandle, context, "SdtTrips");
      initialize( remoteHandle) ;
   }

   public SdtTrips( int remoteHandle ,
                    StructSdtTrips struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public void Load( short AV25TripsId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Short.valueOf(AV25TripsId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"TripsId", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Trips");
      metadata.set("BT", "Trips");
      metadata.set("PK", "[ \"TripsId\" ]");
      metadata.set("PKAssigned", "[ \"TripsId\" ]");
      metadata.set("Levels", "[ \"Attrations\" ]");
      metadata.set("AllowInsert", "True");
      metadata.set("AllowUpdate", "True");
      metadata.set("AllowDelete", "True");
      return metadata ;
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "TripsId") )
            {
               gxTv_SdtTrips_Tripsid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TripsDate") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtTrips_Tripsdate = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtTrips_Tripsdate = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TripsDescription") )
            {
               gxTv_SdtTrips_Tripsdescription = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Attrations") )
            {
               if ( gxTv_SdtTrips_Attrations == null )
               {
                  gxTv_SdtTrips_Attrations = new GXBCLevelCollection<com.kbbaru.SdtTrips_Attrations>(com.kbbaru.SdtTrips_Attrations.class, "Trips.Attrations", "KBBaru", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtTrips_Attrations.readxml(oReader, "Attrations") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Attrations") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtTrips_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtTrips_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TripsId_Z") )
            {
               gxTv_SdtTrips_Tripsid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TripsDate_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtTrips_Tripsdate_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtTrips_Tripsdate_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TripsDescription_Z") )
            {
               gxTv_SdtTrips_Tripsdescription_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "Trips" ;
      }
      if ( (GXutil.strcmp("", sNameSpace)==0) )
      {
         sNameSpace = "KBBaru" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeElement("TripsId", GXutil.trim( GXutil.str( gxTv_SdtTrips_Tripsid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "KBBaru") != 0 )
      {
         oWriter.writeAttribute("xmlns", "KBBaru");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtTrips_Tripsdate), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtTrips_Tripsdate), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtTrips_Tripsdate), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("TripsDate", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "KBBaru") != 0 )
      {
         oWriter.writeAttribute("xmlns", "KBBaru");
      }
      oWriter.writeElement("TripsDescription", gxTv_SdtTrips_Tripsdescription);
      if ( GXutil.strcmp(sNameSpace, "KBBaru") != 0 )
      {
         oWriter.writeAttribute("xmlns", "KBBaru");
      }
      if ( gxTv_SdtTrips_Attrations != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "KBBaru") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "KBBaru" ;
         }
         else
         {
            sNameSpace1 = "KBBaru" ;
         }
         gxTv_SdtTrips_Attrations.writexml(oWriter, "Attrations", sNameSpace1, sIncludeState);
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtTrips_Mode);
         if ( GXutil.strcmp(sNameSpace, "KBBaru") != 0 )
         {
            oWriter.writeAttribute("xmlns", "KBBaru");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtTrips_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "KBBaru") != 0 )
         {
            oWriter.writeAttribute("xmlns", "KBBaru");
         }
         oWriter.writeElement("TripsId_Z", GXutil.trim( GXutil.str( gxTv_SdtTrips_Tripsid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "KBBaru") != 0 )
         {
            oWriter.writeAttribute("xmlns", "KBBaru");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtTrips_Tripsdate_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtTrips_Tripsdate_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtTrips_Tripsdate_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("TripsDate_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "KBBaru") != 0 )
         {
            oWriter.writeAttribute("xmlns", "KBBaru");
         }
         oWriter.writeElement("TripsDescription_Z", gxTv_SdtTrips_Tripsdescription_Z);
         if ( GXutil.strcmp(sNameSpace, "KBBaru") != 0 )
         {
            oWriter.writeAttribute("xmlns", "KBBaru");
         }
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("TripsId", gxTv_SdtTrips_Tripsid, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtTrips_Tripsdate), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtTrips_Tripsdate), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtTrips_Tripsdate), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("TripsDate", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("TripsDescription", gxTv_SdtTrips_Tripsdescription, false, includeNonInitialized);
      if ( gxTv_SdtTrips_Attrations != null )
      {
         AddObjectProperty("Attrations", gxTv_SdtTrips_Attrations, includeState, includeNonInitialized);
      }
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtTrips_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtTrips_Initialized, false, includeNonInitialized);
         AddObjectProperty("TripsId_Z", gxTv_SdtTrips_Tripsid_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtTrips_Tripsdate_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtTrips_Tripsdate_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtTrips_Tripsdate_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("TripsDate_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("TripsDescription_Z", gxTv_SdtTrips_Tripsdescription_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.kbbaru.SdtTrips sdt )
   {
      if ( sdt.IsDirty("TripsId") )
      {
         gxTv_SdtTrips_N = (byte)(0) ;
         gxTv_SdtTrips_Tripsid = sdt.getgxTv_SdtTrips_Tripsid() ;
      }
      if ( sdt.IsDirty("TripsDate") )
      {
         gxTv_SdtTrips_N = (byte)(0) ;
         gxTv_SdtTrips_Tripsdate = sdt.getgxTv_SdtTrips_Tripsdate() ;
      }
      if ( sdt.IsDirty("TripsDescription") )
      {
         gxTv_SdtTrips_N = (byte)(0) ;
         gxTv_SdtTrips_Tripsdescription = sdt.getgxTv_SdtTrips_Tripsdescription() ;
      }
      if ( gxTv_SdtTrips_Attrations != null )
      {
         GXBCLevelCollection<com.kbbaru.SdtTrips_Attrations> newCollectionAttrations = sdt.getgxTv_SdtTrips_Attrations();
         com.kbbaru.SdtTrips_Attrations currItemAttrations;
         com.kbbaru.SdtTrips_Attrations newItemAttrations;
         short idx = 1;
         while ( idx <= newCollectionAttrations.size() )
         {
            newItemAttrations = (com.kbbaru.SdtTrips_Attrations)((com.kbbaru.SdtTrips_Attrations)newCollectionAttrations.elementAt(-1+idx));
            currItemAttrations = (com.kbbaru.SdtTrips_Attrations)gxTv_SdtTrips_Attrations.getByKey(newItemAttrations.getgxTv_SdtTrips_Attrations_Attractionsid());
            if ( GXutil.strcmp(currItemAttrations.getgxTv_SdtTrips_Attrations_Mode(), "UPD") == 0 )
            {
               currItemAttrations.updateDirties(newItemAttrations);
               if ( GXutil.strcmp(newItemAttrations.getgxTv_SdtTrips_Attrations_Mode(), "DLT") == 0 )
               {
                  currItemAttrations.setgxTv_SdtTrips_Attrations_Mode( "DLT" );
               }
               currItemAttrations.setgxTv_SdtTrips_Attrations_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtTrips_Attrations.add(newItemAttrations, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
   }

   public short getgxTv_SdtTrips_Tripsid( )
   {
      return gxTv_SdtTrips_Tripsid ;
   }

   public void setgxTv_SdtTrips_Tripsid( short value )
   {
      gxTv_SdtTrips_N = (byte)(0) ;
      if ( gxTv_SdtTrips_Tripsid != value )
      {
         gxTv_SdtTrips_Mode = "INS" ;
         this.setgxTv_SdtTrips_Tripsid_Z_SetNull( );
         this.setgxTv_SdtTrips_Tripsdate_Z_SetNull( );
         this.setgxTv_SdtTrips_Tripsdescription_Z_SetNull( );
         if ( gxTv_SdtTrips_Attrations != null )
         {
            GXBCLevelCollection<com.kbbaru.SdtTrips_Attrations> collectionAttrations = gxTv_SdtTrips_Attrations;
            com.kbbaru.SdtTrips_Attrations currItemAttrations;
            short idx = 1;
            while ( idx <= collectionAttrations.size() )
            {
               currItemAttrations = (com.kbbaru.SdtTrips_Attrations)((com.kbbaru.SdtTrips_Attrations)collectionAttrations.elementAt(-1+idx));
               currItemAttrations.setgxTv_SdtTrips_Attrations_Mode( "INS" );
               currItemAttrations.setgxTv_SdtTrips_Attrations_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Tripsid");
      gxTv_SdtTrips_Tripsid = value ;
   }

   public java.util.Date getgxTv_SdtTrips_Tripsdate( )
   {
      return gxTv_SdtTrips_Tripsdate ;
   }

   public void setgxTv_SdtTrips_Tripsdate( java.util.Date value )
   {
      gxTv_SdtTrips_N = (byte)(0) ;
      SetDirty("Tripsdate");
      gxTv_SdtTrips_Tripsdate = value ;
   }

   public String getgxTv_SdtTrips_Tripsdescription( )
   {
      return gxTv_SdtTrips_Tripsdescription ;
   }

   public void setgxTv_SdtTrips_Tripsdescription( String value )
   {
      gxTv_SdtTrips_N = (byte)(0) ;
      SetDirty("Tripsdescription");
      gxTv_SdtTrips_Tripsdescription = value ;
   }

   public GXBCLevelCollection<com.kbbaru.SdtTrips_Attrations> getgxTv_SdtTrips_Attrations( )
   {
      if ( gxTv_SdtTrips_Attrations == null )
      {
         gxTv_SdtTrips_Attrations = new GXBCLevelCollection<com.kbbaru.SdtTrips_Attrations>(com.kbbaru.SdtTrips_Attrations.class, "Trips.Attrations", "KBBaru", remoteHandle);
      }
      gxTv_SdtTrips_N = (byte)(0) ;
      return gxTv_SdtTrips_Attrations ;
   }

   public void setgxTv_SdtTrips_Attrations( GXBCLevelCollection<com.kbbaru.SdtTrips_Attrations> value )
   {
      gxTv_SdtTrips_N = (byte)(0) ;
      SetDirty("Attrations");
      gxTv_SdtTrips_Attrations = value ;
   }

   public void setgxTv_SdtTrips_Attrations_SetNull( )
   {
      gxTv_SdtTrips_Attrations = null ;
      SetDirty("Attrations");
   }

   public boolean getgxTv_SdtTrips_Attrations_IsNull( )
   {
      if ( gxTv_SdtTrips_Attrations == null )
      {
         return true ;
      }
      return false ;
   }

   public String getgxTv_SdtTrips_Mode( )
   {
      return gxTv_SdtTrips_Mode ;
   }

   public void setgxTv_SdtTrips_Mode( String value )
   {
      gxTv_SdtTrips_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtTrips_Mode = value ;
   }

   public void setgxTv_SdtTrips_Mode_SetNull( )
   {
      gxTv_SdtTrips_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtTrips_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtTrips_Initialized( )
   {
      return gxTv_SdtTrips_Initialized ;
   }

   public void setgxTv_SdtTrips_Initialized( short value )
   {
      gxTv_SdtTrips_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtTrips_Initialized = value ;
   }

   public void setgxTv_SdtTrips_Initialized_SetNull( )
   {
      gxTv_SdtTrips_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtTrips_Initialized_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtTrips_Tripsid_Z( )
   {
      return gxTv_SdtTrips_Tripsid_Z ;
   }

   public void setgxTv_SdtTrips_Tripsid_Z( short value )
   {
      gxTv_SdtTrips_N = (byte)(0) ;
      SetDirty("Tripsid_Z");
      gxTv_SdtTrips_Tripsid_Z = value ;
   }

   public void setgxTv_SdtTrips_Tripsid_Z_SetNull( )
   {
      gxTv_SdtTrips_Tripsid_Z = (short)(0) ;
      SetDirty("Tripsid_Z");
   }

   public boolean getgxTv_SdtTrips_Tripsid_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtTrips_Tripsdate_Z( )
   {
      return gxTv_SdtTrips_Tripsdate_Z ;
   }

   public void setgxTv_SdtTrips_Tripsdate_Z( java.util.Date value )
   {
      gxTv_SdtTrips_N = (byte)(0) ;
      SetDirty("Tripsdate_Z");
      gxTv_SdtTrips_Tripsdate_Z = value ;
   }

   public void setgxTv_SdtTrips_Tripsdate_Z_SetNull( )
   {
      gxTv_SdtTrips_Tripsdate_Z = GXutil.nullDate() ;
      SetDirty("Tripsdate_Z");
   }

   public boolean getgxTv_SdtTrips_Tripsdate_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtTrips_Tripsdescription_Z( )
   {
      return gxTv_SdtTrips_Tripsdescription_Z ;
   }

   public void setgxTv_SdtTrips_Tripsdescription_Z( String value )
   {
      gxTv_SdtTrips_N = (byte)(0) ;
      SetDirty("Tripsdescription_Z");
      gxTv_SdtTrips_Tripsdescription_Z = value ;
   }

   public void setgxTv_SdtTrips_Tripsdescription_Z_SetNull( )
   {
      gxTv_SdtTrips_Tripsdescription_Z = "" ;
      SetDirty("Tripsdescription_Z");
   }

   public boolean getgxTv_SdtTrips_Tripsdescription_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.kbbaru.trips_bc obj;
      obj = new com.kbbaru.trips_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtTrips_N = (byte)(1) ;
      gxTv_SdtTrips_Tripsdate = GXutil.nullDate() ;
      gxTv_SdtTrips_Tripsdescription = "" ;
      gxTv_SdtTrips_Mode = "" ;
      gxTv_SdtTrips_Tripsdate_Z = GXutil.nullDate() ;
      gxTv_SdtTrips_Tripsdescription_Z = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtTrips_N ;
   }

   public com.kbbaru.SdtTrips Clone( )
   {
      com.kbbaru.SdtTrips sdt;
      com.kbbaru.trips_bc obj;
      sdt = (com.kbbaru.SdtTrips)(clone()) ;
      obj = (com.kbbaru.trips_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.kbbaru.StructSdtTrips struct )
   {
      if ( struct != null )
      {
         setgxTv_SdtTrips_Tripsid(struct.getTripsid());
         setgxTv_SdtTrips_Tripsdate(struct.getTripsdate());
         setgxTv_SdtTrips_Tripsdescription(struct.getTripsdescription());
         GXBCLevelCollection<com.kbbaru.SdtTrips_Attrations> gxTv_SdtTrips_Attrations_aux = new GXBCLevelCollection<com.kbbaru.SdtTrips_Attrations>(com.kbbaru.SdtTrips_Attrations.class, "Trips.Attrations", "KBBaru", remoteHandle);
         Vector<com.kbbaru.StructSdtTrips_Attrations> gxTv_SdtTrips_Attrations_aux1 = struct.getAttrations();
         if (gxTv_SdtTrips_Attrations_aux1 != null)
         {
            for (int i = 0; i < gxTv_SdtTrips_Attrations_aux1.size(); i++)
            {
               gxTv_SdtTrips_Attrations_aux.add(new com.kbbaru.SdtTrips_Attrations(remoteHandle, gxTv_SdtTrips_Attrations_aux1.elementAt(i)));
            }
         }
         setgxTv_SdtTrips_Attrations(gxTv_SdtTrips_Attrations_aux);
         setgxTv_SdtTrips_Mode(struct.getMode());
         setgxTv_SdtTrips_Initialized(struct.getInitialized());
         setgxTv_SdtTrips_Tripsid_Z(struct.getTripsid_Z());
         setgxTv_SdtTrips_Tripsdate_Z(struct.getTripsdate_Z());
         setgxTv_SdtTrips_Tripsdescription_Z(struct.getTripsdescription_Z());
      }
   }

   @SuppressWarnings("unchecked")
   public com.kbbaru.StructSdtTrips getStruct( )
   {
      com.kbbaru.StructSdtTrips struct = new com.kbbaru.StructSdtTrips ();
      struct.setTripsid(getgxTv_SdtTrips_Tripsid());
      struct.setTripsdate(getgxTv_SdtTrips_Tripsdate());
      struct.setTripsdescription(getgxTv_SdtTrips_Tripsdescription());
      struct.setAttrations(getgxTv_SdtTrips_Attrations().getStruct());
      struct.setMode(getgxTv_SdtTrips_Mode());
      struct.setInitialized(getgxTv_SdtTrips_Initialized());
      struct.setTripsid_Z(getgxTv_SdtTrips_Tripsid_Z());
      struct.setTripsdate_Z(getgxTv_SdtTrips_Tripsdate_Z());
      struct.setTripsdescription_Z(getgxTv_SdtTrips_Tripsdescription_Z());
      return struct ;
   }

   private byte gxTv_SdtTrips_N ;
   private short gxTv_SdtTrips_Tripsid ;
   private short gxTv_SdtTrips_Initialized ;
   private short gxTv_SdtTrips_Tripsid_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtTrips_Mode ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_SdtTrips_Tripsdate ;
   private java.util.Date gxTv_SdtTrips_Tripsdate_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtTrips_Tripsdescription ;
   private String gxTv_SdtTrips_Tripsdescription_Z ;
   private GXBCLevelCollection<com.kbbaru.SdtTrips_Attrations> gxTv_SdtTrips_Attrations_aux ;
   private GXBCLevelCollection<com.kbbaru.SdtTrips_Attrations> gxTv_SdtTrips_Attrations=null ;
}

