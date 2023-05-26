package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class attractionsgeneral_impl extends GXWebComponent
{
   public attractionsgeneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public attractionsgeneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( attractionsgeneral_impl.class ));
   }

   public attractionsgeneral_impl( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void setPrefix( String sPPrefix )
   {
      sPrefix = sPPrefix;
   }

   protected void createObjects( )
   {
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( nGotPars == 0 )
         {
            entryPointCalled = false ;
            gxfirstwebparm = httpContext.GetFirstPar( "AttractionsId") ;
            gxfirstwebparm_bkp = gxfirstwebparm ;
            gxfirstwebparm = httpContext.DecryptAjaxCall( gxfirstwebparm) ;
            toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableJsOutput();
            }
            if ( GXutil.strcmp(gxfirstwebparm, "dyncall") == 0 )
            {
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               dyncall( httpContext.GetNextPar( )) ;
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "dyncomponent") == 0 )
            {
               httpContext.setAjaxEventMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               nDynComponent = (byte)(1) ;
               sCompPrefix = httpContext.GetPar( "sCompPrefix") ;
               sSFPrefix = httpContext.GetPar( "sSFPrefix") ;
               A9AttractionsId = (short)(GXutil.lval( httpContext.GetPar( "AttractionsId"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A9AttractionsId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9AttractionsId), 4, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Short.valueOf(A9AttractionsId)});
               componentstart();
               httpContext.ajax_rspStartCmp(sPrefix);
               componentdraw();
               httpContext.ajax_rspEndCmp();
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxEvt") == 0 )
            {
               httpContext.setAjaxEventMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "AttractionsId") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "AttractionsId") ;
            }
            else
            {
               if ( ! httpContext.IsValidAjaxCall( false) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = gxfirstwebparm_bkp ;
            }
            if ( toggleJsOutput )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableJsOutput();
               }
            }
         }
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isLocalStorageSupported( ) )
         {
            httpContext.pushCurrentUrl();
         }
      }
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa1M2( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            validateSpaRequest();
         }
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( ! isAjaxCallMode( ) )
            {
               if ( nDynComponent == 0 )
               {
                  httpContext.sendError( 404 );
                  GXutil.writeLog("send_http_error_code 404");
                  GxWebError = (byte)(1) ;
               }
            }
         }
         if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
         {
            if ( nDynComponent == 0 )
            {
               throw new RuntimeException("WebComponent is not allowed to run");
            }
         }
         if ( ( GxWebError == 0 ) && httpContext.isAjaxRequest( ) )
         {
            httpContext.enableOutput();
            if ( ! httpContext.isAjaxRequest( ) )
            {
               httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
            }
            if ( ! httpContext.willRedirect( ) )
            {
               addString( httpContext.getJSONResponse( )) ;
            }
            else
            {
               if ( httpContext.isAjaxRequest( ) )
               {
                  httpContext.disableOutput();
               }
               renderHtmlHeaders( ) ;
               httpContext.redirect( httpContext.wjLoc );
               httpContext.dispatchAjaxCommands();
            }
         }
      }
      cleanup();
   }

   public void renderHtmlHeaders( )
   {
      com.kbbaru.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), true);
   }

   public void renderHtmlOpenForm( )
   {
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
         httpContext.writeText( "<title>") ;
         httpContext.writeValue( "Attractions General") ;
         httpContext.writeTextNL( "</title>") ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         if ( GXutil.len( sDynURL) > 0 )
         {
            httpContext.writeText( "<BASE href=\""+sDynURL+"\" />") ;
         }
         define_styles( ) ;
      }
      if ( ( ( httpContext.getBrowserType( ) == 1 ) || ( httpContext.getBrowserType( ) == 5 ) ) && ( GXutil.strcmp(httpContext.getBrowserVersion( ), "7.0") == 0 ) )
      {
         httpContext.AddJavascriptSource("json2.js", "?"+httpContext.getBuildNumber( 2054360), false, true);
      }
      httpContext.AddJavascriptSource("jquery.js", "?"+httpContext.getBuildNumber( 2054360), false, true);
      httpContext.AddJavascriptSource("gxgral.js", "?"+httpContext.getBuildNumber( 2054360), false, true);
      httpContext.AddJavascriptSource("gxcfg.js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.closeHtmlHeader();
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         FormProcess = " data-HasEnter=\"false\" data-Skiponenter=\"false\"" ;
         httpContext.writeText( "<body ") ;
         bodyStyle = "" ;
         if ( nGXWrapped == 0 )
         {
            bodyStyle += "-moz-opacity:0;opacity:0;" ;
         }
         httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
         httpContext.writeText( FormProcess+">") ;
         httpContext.skipLines( 1 );
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.kbbaru.attractionsgeneral", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A9AttractionsId,4,0))}, new String[] {"AttractionsId"}) +"\">") ;
         com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
         com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
         com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
         httpContext.writeText( "<div style=\"height:0;overflow:hidden\"><input type=\"submit\" title=\"submit\"  disabled></div>") ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, "FORM", "Class", "form-horizontal Form", true);
      }
      else
      {
         boolean toggleHtmlOutput = httpContext.isOutputEnabled( );
         if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableOutput();
            }
         }
         httpContext.writeText( "<div") ;
         com.kbbaru.GxWebStd.classAttribute( httpContext, "gxwebcomponent-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         if ( toggleHtmlOutput )
         {
            if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableOutput();
               }
            }
         }
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
      }
      if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
      }
   }

   public void send_integrity_footer_hashes( )
   {
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA9AttractionsId", GXutil.ltrim( localUtil.ntoc( wcpOA9AttractionsId, (byte)(4), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, sPrefix+"ATTRACTIONSID", GXutil.ltrim( localUtil.ntoc( A9AttractionsId, (byte)(4), (byte)(0), ".", "")));
   }

   public void renderHtmlCloseForm1M2( )
   {
      sendCloseFormHiddens( ) ;
      if ( ( GXutil.len( sPrefix) != 0 ) && ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) ) )
      {
         componentjscripts();
      }
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GX_FocusControl", GX_FocusControl);
      define_styles( ) ;
      sendSecurityToken(sPrefix);
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.SendAjaxEncryptionKey();
         httpContext.SendComponentObjects();
         httpContext.SendServerCommands();
         httpContext.SendState();
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         httpContext.writeTextNL( "</form>") ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
         include_jscripts( ) ;
         httpContext.writeTextNL( "</body>") ;
         httpContext.writeTextNL( "</html>") ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
      }
      else
      {
         httpContext.SendWebComponentState();
         httpContext.writeText( "</div>") ;
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
   }

   public String getPgmname( )
   {
      return "AttractionsGeneral" ;
   }

   public String getPgmdesc( )
   {
      return "Attractions General" ;
   }

   public void wb1M0( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         if ( GXutil.len( sPrefix) == 0 )
         {
            renderHtmlHeaders( ) ;
         }
         renderHtmlOpenForm( ) ;
         if ( GXutil.len( sPrefix) != 0 )
         {
            com.kbbaru.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.kbbaru.attractionsgeneral");
         }
         com.kbbaru.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), "", "", sPrefix, "false");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"none\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, divMaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 ww__view__actions-cell", "Right", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ww__view__actions", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 8,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "Button button-primary" ;
         StyleString = "" ;
         com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", "Update", bttBtnupdate_Jsonclick, 7, "Update", "", StyleString, ClassString, 1, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e111m1_client"+"'", TempTags, "", 2, "HLP_AttractionsGeneral.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 10,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "Button button-tertiary" ;
         StyleString = "" ;
         com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", "Delete", bttBtndelete_Jsonclick, 7, "Delete", "", StyleString, ClassString, 1, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e121m1_client"+"'", TempTags, "", 2, "HLP_AttractionsGeneral.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "Right", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, divAttributestable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 form__cell", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtAttractionsName_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.kbbaru.GxWebStd.gx_label_element( httpContext, edtAttractionsName_Internalname, "Name", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.kbbaru.GxWebStd.gx_single_line_edit( httpContext, edtAttractionsName_Internalname, A10AttractionsName, GXutil.rtrim( localUtil.format( A10AttractionsName, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtAttractionsName_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtAttractionsName_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Name", "left", true, "", "HLP_AttractionsGeneral.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 form__cell", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCountryName_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.kbbaru.GxWebStd.gx_label_element( httpContext, edtCountryName_Internalname, "Country Name", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.kbbaru.GxWebStd.gx_single_line_edit( httpContext, edtCountryName_Internalname, A6CountryName, GXutil.rtrim( localUtil.format( A6CountryName, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", edtCountryName_Link, "", "", "", edtCountryName_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtCountryName_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Name", "left", true, "", "HLP_AttractionsGeneral.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 form__cell", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCountryCityName_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.kbbaru.GxWebStd.gx_label_element( httpContext, edtCountryCityName_Internalname, "Country City Name", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.kbbaru.GxWebStd.gx_single_line_edit( httpContext, edtCountryCityName_Internalname, A16CountryCityName, GXutil.rtrim( localUtil.format( A16CountryCityName, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCountryCityName_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtCountryCityName_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Name", "left", true, "", "HLP_AttractionsGeneral.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 form__cell", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCategoryName_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.kbbaru.GxWebStd.gx_label_element( httpContext, edtCategoryName_Internalname, "Category Name", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.kbbaru.GxWebStd.gx_single_line_edit( httpContext, edtCategoryName_Internalname, A4CategoryName, GXutil.rtrim( localUtil.format( A4CategoryName, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", edtCategoryName_Link, "", "", "", edtCategoryName_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtCategoryName_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Name", "left", true, "", "HLP_AttractionsGeneral.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 form__cell", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavTrips_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.kbbaru.GxWebStd.gx_label_element( httpContext, edtavTrips_Internalname, "Trips", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'" + sPrefix + "',false,'',0)\"" ;
         com.kbbaru.GxWebStd.gx_single_line_edit( httpContext, edtavTrips_Internalname, GXutil.ltrim( localUtil.ntoc( AV11Trips, (byte)(4), (byte)(0), ".", "")), GXutil.ltrim( ((edtavTrips_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV11Trips), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV11Trips), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,',');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,',');"+";gx.evt.onblur(this,38);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTrips_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtavTrips_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "TripsAmount", "right", false, "", "HLP_AttractionsGeneral.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, divImagestable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 form__cell", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.kbbaru.GxWebStd.gx_label_element( httpContext, "", "Photo", "col-sm-3 ReadonlyAttributeLabel ReadonlyResponsiveImageAttributeLabel", 0, true, "");
         /* Static Bitmap Variable */
         ClassString = "ReadonlyAttribute ReadonlyResponsiveImageAttribute" ;
         StyleString = "" ;
         A11AttractionsPhoto_IsBlob = (boolean)(((GXutil.strcmp("", A11AttractionsPhoto)==0)&&(GXutil.strcmp("", A40001AttractionsPhoto_GXI)==0))||!(GXutil.strcmp("", A11AttractionsPhoto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", A11AttractionsPhoto)==0) ? A40001AttractionsPhoto_GXI : httpContext.getResourceRelative(A11AttractionsPhoto)) ;
         com.kbbaru.GxWebStd.gx_bitmap( httpContext, imgAttractionsPhoto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, A11AttractionsPhoto_IsBlob, true, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_AttractionsGeneral.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start1M2( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isSpaRequest( ) )
         {
            if ( httpContext.exposeMetadata( ) )
            {
               Form.getMeta().addItem("generator", "GeneXus Java 18_0_2-169539", (short)(0)) ;
            }
            Form.getMeta().addItem("description", "Attractions General", (short)(0)) ;
         }
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
         httpContext.wbHandled = (byte)(0) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            sXEvt = httpContext.cgiGet( "_EventName") ;
            if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
            {
            }
         }
      }
      wbErr = false ;
      if ( ( GXutil.len( sPrefix) == 0 ) || ( nDraw == 1 ) )
      {
         if ( nDoneStart == 0 )
         {
            strup1M0( ) ;
         }
      }
   }

   public void ws1M2( )
   {
      start1M2( ) ;
      evt1M2( ) ;
   }

   public void evt1M2( )
   {
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ( ( ( GXutil.len( sPrefix) == 0 ) ) || ( GXutil.strSearch( sXEvt, sPrefix, 1) > 0 ) ) && ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
            if ( httpContext.wbHandled == 0 )
            {
               if ( GXutil.len( sPrefix) == 0 )
               {
                  sEvt = httpContext.cgiGet( "_EventName") ;
                  EvtGridId = httpContext.cgiGet( "_EventGridId") ;
                  EvtRowId = httpContext.cgiGet( "_EventRowId") ;
               }
               if ( GXutil.len( sEvt) > 0 )
               {
                  sEvtType = GXutil.left( sEvt, 1) ;
                  sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
                  if ( GXutil.strcmp(sEvtType, "E") == 0 )
                  {
                     sEvtType = GXutil.right( sEvt, 1) ;
                     if ( GXutil.strcmp(sEvtType, ".") == 0 )
                     {
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                        if ( GXutil.strcmp(sEvt, "RFR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup1M0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup1M0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e131M2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup1M0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e141M2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup1M0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 if ( ! wbErr )
                                 {
                                    Rfr0gs = false ;
                                    if ( ! Rfr0gs )
                                    {
                                    }
                                    dynload_actions( ) ;
                                 }
                              }
                           }
                           /* No code required for Cancel button. It is implemented as the Reset button. */
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup1M0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = edtavTrips_Internalname ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                              }
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we1M2( )
   {
      if ( ! com.kbbaru.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.kbbaru.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm1M2( ) ;
         }
      }
   }

   public void pa1M2( )
   {
      if ( nDonePA == 0 )
      {
         if ( GXutil.len( sPrefix) != 0 )
         {
            initialize_properties( ) ;
         }
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
            {
               gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
            }
         }
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableJsOutput();
            }
         }
         init_web_controls( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( toggleJsOutput )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableJsOutput();
               }
            }
         }
         if ( ! httpContext.isAjaxRequest( ) )
         {
            GX_FocusControl = edtavTrips_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void send_integrity_hashes( )
   {
   }

   public void clear_multi_value_controls( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf1M2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV14Pgmname = "AttractionsGeneral" ;
      Gx_err = (short)(0) ;
      edtavTrips_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavTrips_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTrips_Enabled), 5, 0), true);
   }

   public void rf1M2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H001M3 */
         pr_default.execute(0, new Object[] {Short.valueOf(A9AttractionsId)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A12CountryCityId = H001M3_A12CountryCityId[0] ;
            A5CountryId = H001M3_A5CountryId[0] ;
            A3CategoryId = H001M3_A3CategoryId[0] ;
            A11AttractionsPhoto = H001M3_A11AttractionsPhoto[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A11AttractionsPhoto", A11AttractionsPhoto);
            httpContext.ajax_rsp_assign_prop(sPrefix, false, imgAttractionsPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A11AttractionsPhoto)==0) ? A40001AttractionsPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A11AttractionsPhoto))), true);
            httpContext.ajax_rsp_assign_prop(sPrefix, false, imgAttractionsPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A11AttractionsPhoto), true);
            A40001AttractionsPhoto_GXI = H001M3_A40001AttractionsPhoto_GXI[0] ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, imgAttractionsPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A11AttractionsPhoto)==0) ? A40001AttractionsPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A11AttractionsPhoto))), true);
            httpContext.ajax_rsp_assign_prop(sPrefix, false, imgAttractionsPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A11AttractionsPhoto), true);
            A4CategoryName = H001M3_A4CategoryName[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A4CategoryName", A4CategoryName);
            A16CountryCityName = H001M3_A16CountryCityName[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A16CountryCityName", A16CountryCityName);
            A6CountryName = H001M3_A6CountryName[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A6CountryName", A6CountryName);
            A10AttractionsName = H001M3_A10AttractionsName[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A10AttractionsName", A10AttractionsName);
            A40000GXC1 = H001M3_A40000GXC1[0] ;
            n40000GXC1 = H001M3_n40000GXC1[0] ;
            A6CountryName = H001M3_A6CountryName[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A6CountryName", A6CountryName);
            A16CountryCityName = H001M3_A16CountryCityName[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A16CountryCityName", A16CountryCityName);
            A4CategoryName = H001M3_A4CategoryName[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A4CategoryName", A4CategoryName);
            A40000GXC1 = H001M3_A40000GXC1[0] ;
            n40000GXC1 = H001M3_n40000GXC1[0] ;
            /* Execute user event: Load */
            e141M2 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         wb1M0( ) ;
      }
   }

   public void send_integrity_lvl_hashes1M2( )
   {
   }

   public void before_start_formulas( )
   {
      AV14Pgmname = "AttractionsGeneral" ;
      Gx_err = (short)(0) ;
      edtavTrips_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavTrips_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTrips_Enabled), 5, 0), true);
      /* Using cursor H001M5 */
      pr_default.execute(1, new Object[] {Short.valueOf(A9AttractionsId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         A40000GXC1 = H001M5_A40000GXC1[0] ;
         n40000GXC1 = H001M5_n40000GXC1[0] ;
      }
      else
      {
         A40000GXC1 = 0 ;
         n40000GXC1 = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A40000GXC1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40000GXC1), 9, 0));
      }
      pr_default.close(1);
      pr_default.close(1);
      fix_multi_value_controls( ) ;
   }

   public void strup1M0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e131M2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOA9AttractionsId = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA9AttractionsId"), ".", ",")) ;
         A9AttractionsId = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"ATTRACTIONSID"), ".", ",")) ;
         /* Read variables values. */
         A10AttractionsName = httpContext.cgiGet( edtAttractionsName_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A10AttractionsName", A10AttractionsName);
         A6CountryName = httpContext.cgiGet( edtCountryName_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A6CountryName", A6CountryName);
         A16CountryCityName = httpContext.cgiGet( edtCountryCityName_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A16CountryCityName", A16CountryCityName);
         A4CategoryName = httpContext.cgiGet( edtCategoryName_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A4CategoryName", A4CategoryName);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavTrips_Internalname), ".", ",") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavTrips_Internalname), ".", ",") > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vTRIPS");
            GX_FocusControl = edtavTrips_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV11Trips = (short)(0) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11Trips", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11Trips), 4, 0));
         }
         else
         {
            AV11Trips = (short)(localUtil.ctol( httpContext.cgiGet( edtavTrips_Internalname), ".", ",")) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11Trips", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11Trips), 4, 0));
         }
         A11AttractionsPhoto = httpContext.cgiGet( imgAttractionsPhoto_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A11AttractionsPhoto", A11AttractionsPhoto);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e131M2 ();
      if (returnInSub) return;
   }

   public void e131M2( )
   {
      /* Start Routine */
      returnInSub = false ;
      if ( ! new com.kbbaru.general.security.isauthorized(remoteHandle, context).executeUdp( AV14Pgmname) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         callWebObject(formatLink("com.kbbaru.general.security.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV14Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S112 ();
      if (returnInSub) return;
   }

   protected void nextLoad( )
   {
   }

   protected void e141M2( )
   {
      /* Load Routine */
      returnInSub = false ;
      edtCountryName_Link = formatLink("com.kbbaru.viewcountry", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A5CountryId,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"CountryId","TabCode"})  ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCountryName_Internalname, "Link", edtCountryName_Link, true);
      edtCategoryName_Link = formatLink("com.kbbaru.viewcategory", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CategoryId,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"CategoryId","TabCode"})  ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCategoryName_Internalname, "Link", edtCategoryName_Link, true);
      AV11Trips = (short)((A40000GXC1)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11Trips", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11Trips), 4, 0));
   }

   public void S112( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV7TrnContext = (com.kbbaru.general.ui.SdtTransactionContext)new com.kbbaru.general.ui.SdtTransactionContext(remoteHandle, context);
      AV7TrnContext.setgxTv_SdtTransactionContext_Callerobject( AV14Pgmname );
      AV7TrnContext.setgxTv_SdtTransactionContext_Callerondelete( false );
      AV7TrnContext.setgxTv_SdtTransactionContext_Callerurl( AV10HTTPRequest.getScriptName()+"?"+AV10HTTPRequest.getQuerystring() );
      AV7TrnContext.setgxTv_SdtTransactionContext_Transactionname( "Attractions" );
      AV8TrnContextAtt = (com.kbbaru.general.ui.SdtTransactionContext_Attribute)new com.kbbaru.general.ui.SdtTransactionContext_Attribute(remoteHandle, context);
      AV8TrnContextAtt.setgxTv_SdtTransactionContext_Attribute_Attributename( "AttractionsId" );
      AV8TrnContextAtt.setgxTv_SdtTransactionContext_Attribute_Attributevalue( GXutil.str( AV6AttractionsId, 4, 0) );
      AV7TrnContext.getgxTv_SdtTransactionContext_Attributes().add(AV8TrnContextAtt, 0);
      AV9Session.setValue("TrnContext", AV7TrnContext.toxml(false, true, "TransactionContext", "KBBaru"));
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A9AttractionsId = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A9AttractionsId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9AttractionsId), 4, 0));
   }

   public String getresponse( String sGXDynURL )
   {
      initialize_properties( ) ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      sDynURL = sGXDynURL ;
      nGotPars = 1 ;
      nGXWrapped = 1 ;
      httpContext.setWrapped(true);
      pa1M2( ) ;
      ws1M2( ) ;
      we1M2( ) ;
      httpContext.setWrapped(false);
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
      String response = "";
      try
      {
         response = ((java.io.ByteArrayOutputStream) httpContext.getOutputStream()).toString("UTF8");
      }
      catch (java.io.UnsupportedEncodingException e)
      {
         Application.printWarning(e.getMessage(), e);
      }
      finally
      {
         httpContext.closeOutputStream();
      }
      return response;
   }

   public void responsestatic( String sGXDynURL )
   {
   }

   public void componentbind( Object[] obj )
   {
      if ( IsUrlCreated( ) )
      {
         return  ;
      }
      sCtrlA9AttractionsId = (String)getParm(obj,0,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa1M2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "attractionsgeneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa1M2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         A9AttractionsId = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A9AttractionsId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9AttractionsId), 4, 0));
      }
      wcpOA9AttractionsId = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA9AttractionsId"), ".", ",")) ;
      if ( ! GetJustCreated( ) && ( ( A9AttractionsId != wcpOA9AttractionsId ) ) )
      {
         setjustcreated();
      }
      wcpOA9AttractionsId = A9AttractionsId ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlA9AttractionsId = httpContext.cgiGet( sPrefix+"A9AttractionsId_CTRL") ;
      if ( GXutil.len( sCtrlA9AttractionsId) > 0 )
      {
         A9AttractionsId = (short)(localUtil.ctol( httpContext.cgiGet( sCtrlA9AttractionsId), ".", ",")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A9AttractionsId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9AttractionsId), 4, 0));
      }
      else
      {
         A9AttractionsId = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"A9AttractionsId_PARM"), ".", ",")) ;
      }
   }

   public void componentprocess( String sPPrefix ,
                                 String sPSFPrefix ,
                                 String sCompEvt )
   {
      sCompPrefix = sPPrefix ;
      sSFPrefix = sPSFPrefix ;
      sPrefix = sCompPrefix + sSFPrefix ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      initweb( ) ;
      nDraw = (byte)(0) ;
      pa1M2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws1M2( ) ;
      if ( isFullAjaxMode( ) )
      {
         componentdraw();
      }
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void componentstart( )
   {
      if ( nDoneStart == 0 )
      {
         wcstart( ) ;
      }
   }

   public void wcstart( )
   {
      nDraw = (byte)(1) ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      ws1M2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A9AttractionsId_PARM", GXutil.ltrim( localUtil.ntoc( A9AttractionsId, (byte)(4), (byte)(0), ".", "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA9AttractionsId)) > 0 )
      {
         com.kbbaru.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A9AttractionsId_CTRL", GXutil.rtrim( sCtrlA9AttractionsId));
      }
   }

   public void componentdraw( )
   {
      if ( nDoneStart == 0 )
      {
         wcstart( ) ;
      }
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      wcparametersset( ) ;
      we1M2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public String componentgetstring( String sGXControl )
   {
      String sCtrlName;
      if ( GXutil.strcmp(GXutil.substring( sGXControl, 1, 1), "&") == 0 )
      {
         sCtrlName = GXutil.substring( sGXControl, 2, GXutil.len( sGXControl)-1) ;
      }
      else
      {
         sCtrlName = sGXControl ;
      }
      return httpContext.cgiGet( sPrefix+"v"+GXutil.upper( sCtrlName)) ;
   }

   public void componentjscripts( )
   {
      include_jscripts( ) ;
   }

   public void componentthemes( )
   {
      define_styles( ) ;
   }

   public void define_styles( )
   {
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20235269591845", true, true);
         idxLst = (int)(idxLst+1) ;
      }
      if ( ! outputEnabled )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
      }
      httpContext.CloseStyles();
      /* End function define_styles */
   }

   public void include_jscripts( )
   {
      httpContext.AddJavascriptSource("attractionsgeneral.js", "?20235269591846", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      bttBtnupdate_Internalname = sPrefix+"BTNUPDATE" ;
      bttBtndelete_Internalname = sPrefix+"BTNDELETE" ;
      edtAttractionsName_Internalname = sPrefix+"ATTRACTIONSNAME" ;
      edtCountryName_Internalname = sPrefix+"COUNTRYNAME" ;
      edtCountryCityName_Internalname = sPrefix+"COUNTRYCITYNAME" ;
      edtCategoryName_Internalname = sPrefix+"CATEGORYNAME" ;
      edtavTrips_Internalname = sPrefix+"vTRIPS" ;
      divAttributestable_Internalname = sPrefix+"ATTRIBUTESTABLE" ;
      imgAttractionsPhoto_Internalname = sPrefix+"ATTRACTIONSPHOTO" ;
      divImagestable_Internalname = sPrefix+"IMAGESTABLE" ;
      divMaintable_Internalname = sPrefix+"MAINTABLE" ;
      Form.setInternalname( sPrefix+"FORM" );
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.setDefaultTheme("KBBaru", true);
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
      }
      init_default_properties( ) ;
      edtavTrips_Jsonclick = "" ;
      edtavTrips_Enabled = 1 ;
      edtCategoryName_Jsonclick = "" ;
      edtCategoryName_Link = "" ;
      edtCategoryName_Enabled = 0 ;
      edtCountryCityName_Jsonclick = "" ;
      edtCountryCityName_Enabled = 0 ;
      edtCountryName_Jsonclick = "" ;
      edtCountryName_Link = "" ;
      edtCountryName_Enabled = 0 ;
      edtAttractionsName_Jsonclick = "" ;
      edtAttractionsName_Enabled = 0 ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
   }

   public void init_web_controls( )
   {
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A9AttractionsId',fld:'ATTRACTIONSID',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e111M1',iparms:[{av:'A9AttractionsId',fld:'ATTRACTIONSID',pic:'ZZZ9'}]");
      setEventMetadata("'DOUPDATE'",",oparms:[]}");
      setEventMetadata("'DODELETE'","{handler:'e121M1',iparms:[{av:'A9AttractionsId',fld:'ATTRACTIONSID',pic:'ZZZ9'}]");
      setEventMetadata("'DODELETE'",",oparms:[]}");
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
      super.cleanup();
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtnupdate_Jsonclick = "" ;
      bttBtndelete_Jsonclick = "" ;
      A10AttractionsName = "" ;
      A6CountryName = "" ;
      A16CountryCityName = "" ;
      A4CategoryName = "" ;
      A11AttractionsPhoto = "" ;
      A40001AttractionsPhoto_GXI = "" ;
      sImgUrl = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV14Pgmname = "" ;
      scmdbuf = "" ;
      H001M3_A12CountryCityId = new short[1] ;
      H001M3_A9AttractionsId = new short[1] ;
      H001M3_A5CountryId = new short[1] ;
      H001M3_A3CategoryId = new short[1] ;
      H001M3_A11AttractionsPhoto = new String[] {""} ;
      H001M3_A40001AttractionsPhoto_GXI = new String[] {""} ;
      H001M3_A4CategoryName = new String[] {""} ;
      H001M3_A16CountryCityName = new String[] {""} ;
      H001M3_A6CountryName = new String[] {""} ;
      H001M3_A10AttractionsName = new String[] {""} ;
      H001M3_A40000GXC1 = new int[1] ;
      H001M3_n40000GXC1 = new boolean[] {false} ;
      H001M5_A40000GXC1 = new int[1] ;
      H001M5_n40000GXC1 = new boolean[] {false} ;
      AV7TrnContext = new com.kbbaru.general.ui.SdtTransactionContext(remoteHandle, context);
      AV10HTTPRequest = httpContext.getHttpRequest();
      AV8TrnContextAtt = new com.kbbaru.general.ui.SdtTransactionContext_Attribute(remoteHandle, context);
      AV9Session = httpContext.getWebSession();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlA9AttractionsId = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.kbbaru.attractionsgeneral__default(),
         new Object[] {
             new Object[] {
            H001M3_A12CountryCityId, H001M3_A9AttractionsId, H001M3_A5CountryId, H001M3_A3CategoryId, H001M3_A11AttractionsPhoto, H001M3_A40001AttractionsPhoto_GXI, H001M3_A4CategoryName, H001M3_A16CountryCityName, H001M3_A6CountryName, H001M3_A10AttractionsName,
            H001M3_A40000GXC1, H001M3_n40000GXC1
            }
            , new Object[] {
            H001M5_A40000GXC1, H001M5_n40000GXC1
            }
         }
      );
      AV14Pgmname = "AttractionsGeneral" ;
      /* GeneXus formulas. */
      AV14Pgmname = "AttractionsGeneral" ;
      Gx_err = (short)(0) ;
      edtavTrips_Enabled = 0 ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wcpOA9AttractionsId ;
   private short A9AttractionsId ;
   private short wbEnd ;
   private short wbStart ;
   private short AV11Trips ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short A12CountryCityId ;
   private short A5CountryId ;
   private short A3CategoryId ;
   private short AV6AttractionsId ;
   private int edtAttractionsName_Enabled ;
   private int edtCountryName_Enabled ;
   private int edtCountryCityName_Enabled ;
   private int edtCategoryName_Enabled ;
   private int edtavTrips_Enabled ;
   private int A40000GXC1 ;
   private int idxLst ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String divMaintable_Internalname ;
   private String TempTags ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtnupdate_Internalname ;
   private String bttBtnupdate_Jsonclick ;
   private String bttBtndelete_Internalname ;
   private String bttBtndelete_Jsonclick ;
   private String divAttributestable_Internalname ;
   private String edtAttractionsName_Internalname ;
   private String edtAttractionsName_Jsonclick ;
   private String edtCountryName_Internalname ;
   private String edtCountryName_Link ;
   private String edtCountryName_Jsonclick ;
   private String edtCountryCityName_Internalname ;
   private String edtCountryCityName_Jsonclick ;
   private String edtCategoryName_Internalname ;
   private String edtCategoryName_Link ;
   private String edtCategoryName_Jsonclick ;
   private String edtavTrips_Internalname ;
   private String edtavTrips_Jsonclick ;
   private String divImagestable_Internalname ;
   private String sImgUrl ;
   private String imgAttractionsPhoto_Internalname ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV14Pgmname ;
   private String scmdbuf ;
   private String sCtrlA9AttractionsId ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean A11AttractionsPhoto_IsBlob ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n40000GXC1 ;
   private boolean returnInSub ;
   private boolean Cond_result ;
   private String A10AttractionsName ;
   private String A6CountryName ;
   private String A16CountryCityName ;
   private String A4CategoryName ;
   private String A40001AttractionsPhoto_GXI ;
   private String A11AttractionsPhoto ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV10HTTPRequest ;
   private IDataStoreProvider pr_default ;
   private short[] H001M3_A12CountryCityId ;
   private short[] H001M3_A9AttractionsId ;
   private short[] H001M3_A5CountryId ;
   private short[] H001M3_A3CategoryId ;
   private String[] H001M3_A11AttractionsPhoto ;
   private String[] H001M3_A40001AttractionsPhoto_GXI ;
   private String[] H001M3_A4CategoryName ;
   private String[] H001M3_A16CountryCityName ;
   private String[] H001M3_A6CountryName ;
   private String[] H001M3_A10AttractionsName ;
   private int[] H001M3_A40000GXC1 ;
   private boolean[] H001M3_n40000GXC1 ;
   private int[] H001M5_A40000GXC1 ;
   private boolean[] H001M5_n40000GXC1 ;
   private com.genexus.webpanels.WebSession AV9Session ;
   private com.kbbaru.general.ui.SdtTransactionContext AV7TrnContext ;
   private com.kbbaru.general.ui.SdtTransactionContext_Attribute AV8TrnContextAtt ;
}

final  class attractionsgeneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H001M3", "SELECT T1.CountryCityId, T1.AttractionsId, T1.CountryId, T1.CategoryId, T1.AttractionsPhoto, T1.AttractionsPhoto_GXI, T4.CategoryName, T3.CountryCityName, T2.CountryName, T1.AttractionsName, COALESCE( T5.GXC1, 0) AS GXC1 FROM ((((Attractions T1 INNER JOIN Country T2 ON T2.CountryId = T1.CountryId) INNER JOIN CountryCity T3 ON T3.CountryId = T1.CountryId AND T3.CountryCityId = T1.CountryCityId) INNER JOIN Category T4 ON T4.CategoryId = T1.CategoryId) LEFT JOIN LATERAL (SELECT COUNT(*) AS GXC1, T6.AttractionsId FROM (TripsAttrations T6 INNER JOIN Trips T7 ON T7.TripsId = T6.TripsId) WHERE T1.AttractionsId = T6.AttractionsId GROUP BY T6.AttractionsId ) T5 ON T5.AttractionsId = T1.AttractionsId) WHERE T1.AttractionsId = ? ORDER BY T1.AttractionsId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H001M5", "SELECT COALESCE( T1.GXC1, 0) AS GXC1 FROM (SELECT COUNT(*) AS GXC1, T2.AttractionsId FROM (TripsAttrations T2 INNER JOIN Trips T3 ON T3.TripsId = T2.TripsId) GROUP BY T2.AttractionsId ) T1 WHERE T1.AttractionsId = ? ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getMultimediaFile(5, rslt.getVarchar(6));
               ((String[]) buf[5])[0] = rslt.getMultimediaUri(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               return;
            case 1 :
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

