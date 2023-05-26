package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTCategory_SDTCategoryItem extends GxUserType
{
   public SdtSDTCategory_SDTCategoryItem( )
   {
      this(  new ModelContext(SdtSDTCategory_SDTCategoryItem.class));
   }

   public SdtSDTCategory_SDTCategoryItem( ModelContext context )
   {
      super( context, "SdtSDTCategory_SDTCategoryItem");
   }

   public SdtSDTCategory_SDTCategoryItem( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTCategory_SDTCategoryItem");
   }

   public SdtSDTCategory_SDTCategoryItem( StructSdtSDTCategory_SDTCategoryItem struct )
   {
      this();
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTCategoryId") )
            {
               gxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SDTCategoryName") )
            {
               gxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryname = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "isCheck") )
            {
               gxTv_SdtSDTCategory_SDTCategoryItem_Ischeck = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
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
         sName = "SDTCategory.SDTCategoryItem" ;
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
      oWriter.writeElement("SDTCategoryId", GXutil.trim( GXutil.str( gxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "KBBaru") != 0 )
      {
         oWriter.writeAttribute("xmlns", "KBBaru");
      }
      oWriter.writeElement("SDTCategoryName", gxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryname);
      if ( GXutil.strcmp(sNameSpace, "KBBaru") != 0 )
      {
         oWriter.writeAttribute("xmlns", "KBBaru");
      }
      oWriter.writeElement("isCheck", GXutil.booltostr( gxTv_SdtSDTCategory_SDTCategoryItem_Ischeck));
      if ( GXutil.strcmp(sNameSpace, "KBBaru") != 0 )
      {
         oWriter.writeAttribute("xmlns", "KBBaru");
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
      AddObjectProperty("SDTCategoryId", gxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryid, false, false);
      AddObjectProperty("SDTCategoryName", gxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryname, false, false);
      AddObjectProperty("isCheck", gxTv_SdtSDTCategory_SDTCategoryItem_Ischeck, false, false);
   }

   public short getgxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryid( )
   {
      return gxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryid ;
   }

   public void setgxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryid( short value )
   {
      gxTv_SdtSDTCategory_SDTCategoryItem_N = (byte)(0) ;
      gxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryid = value ;
   }

   public String getgxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryname( )
   {
      return gxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryname ;
   }

   public void setgxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryname( String value )
   {
      gxTv_SdtSDTCategory_SDTCategoryItem_N = (byte)(0) ;
      gxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryname = value ;
   }

   public boolean getgxTv_SdtSDTCategory_SDTCategoryItem_Ischeck( )
   {
      return gxTv_SdtSDTCategory_SDTCategoryItem_Ischeck ;
   }

   public void setgxTv_SdtSDTCategory_SDTCategoryItem_Ischeck( boolean value )
   {
      gxTv_SdtSDTCategory_SDTCategoryItem_N = (byte)(0) ;
      gxTv_SdtSDTCategory_SDTCategoryItem_Ischeck = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTCategory_SDTCategoryItem_N = (byte)(1) ;
      gxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryname = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTCategory_SDTCategoryItem_N ;
   }

   public com.kbbaru.SdtSDTCategory_SDTCategoryItem Clone( )
   {
      return (com.kbbaru.SdtSDTCategory_SDTCategoryItem)(clone()) ;
   }

   public void setStruct( com.kbbaru.StructSdtSDTCategory_SDTCategoryItem struct )
   {
      if ( struct != null )
      {
         setgxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryid(struct.getSdtcategoryid());
         setgxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryname(struct.getSdtcategoryname());
         setgxTv_SdtSDTCategory_SDTCategoryItem_Ischeck(struct.getIscheck());
      }
   }

   @SuppressWarnings("unchecked")
   public com.kbbaru.StructSdtSDTCategory_SDTCategoryItem getStruct( )
   {
      com.kbbaru.StructSdtSDTCategory_SDTCategoryItem struct = new com.kbbaru.StructSdtSDTCategory_SDTCategoryItem ();
      struct.setSdtcategoryid(getgxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryid());
      struct.setSdtcategoryname(getgxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryname());
      struct.setIscheck(getgxTv_SdtSDTCategory_SDTCategoryItem_Ischeck());
      return struct ;
   }

   protected byte gxTv_SdtSDTCategory_SDTCategoryItem_N ;
   protected short gxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryid ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean gxTv_SdtSDTCategory_SDTCategoryItem_Ischeck ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryname ;
}

