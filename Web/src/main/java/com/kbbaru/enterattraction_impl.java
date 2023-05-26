package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class enterattraction_impl extends GXDataArea
{
   public enterattraction_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public enterattraction_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( enterattraction_impl.class ));
   }

   public enterattraction_impl( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynavCountryid = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetNextPar( ) ;
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vCOUNTRYID") == 0 )
         {
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdlvvcountryid1R2( ) ;
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
            gxfirstwebparm = httpContext.GetNextPar( ) ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetNextPar( ) ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Grid1") == 0 )
         {
            gxnrgrid1_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Grid1") == 0 )
         {
            gxgrgrid1_refresh_invoke( ) ;
            return  ;
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
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrgrid1_newrow_invoke( )
   {
      nRC_GXsfl_25 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_25"))) ;
      nGXsfl_25_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_25_idx"))) ;
      sGXsfl_25_idx = httpContext.GetPar( "sGXsfl_25_idx") ;
      AV11edit = httpContext.GetPar( "edit") ;
      AV12show = httpContext.GetPar( "show") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgrid1_newrow( ) ;
      /* End function gxnrGrid1_newrow_invoke */
   }

   public void gxgrgrid1_refresh_invoke( )
   {
      dynavCountryid.fromJSonString( httpContext.GetNextPar( ));
      AV7CountryId = (short)(GXutil.lval( httpContext.GetPar( "CountryId"))) ;
      AV5AttractionName = httpContext.GetPar( "AttractionName") ;
      AV6AttractionNameTo = httpContext.GetPar( "AttractionNameTo") ;
      AV11edit = httpContext.GetPar( "edit") ;
      AV12show = httpContext.GetPar( "show") ;
      AV9total = (short)(GXutil.lval( httpContext.GetPar( "total"))) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid1_refresh( AV7CountryId, AV5AttractionName, AV6AttractionNameTo, AV11edit, AV12show, AV9total) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrid1_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         MasterPageObj= createMasterPage(remoteHandle, "com.kbbaru.general.ui.masterunanimosidebar");
         MasterPageObj.setDataArea(this,false);
         validateSpaRequest();
         MasterPageObj.webExecute();
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
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
   }

   public byte executeStartEvent( )
   {
      pa1R2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start1R2( ) ;
      }
      return gxajaxcallmode ;
   }

   public void renderHtmlHeaders( )
   {
      com.kbbaru.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), true);
   }

   public void renderHtmlOpenForm( )
   {
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.writeText( "<title>") ;
      httpContext.writeValue( Form.getCaption()) ;
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
      if ( nGXWrapped != 1 )
      {
         MasterPageObj.master_styles();
      }
      httpContext.CloseStyles();
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
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"false\" data-Skiponenter=\"false\"" ;
      httpContext.writeText( "<body ") ;
      bodyStyle = "" + "background-color:" + WebUtils.getHTMLColor( Form.getIBackground()) + ";color:" + WebUtils.getHTMLColor( Form.getTextcolor()) + ";" ;
      if ( nGXWrapped == 0 )
      {
         bodyStyle += "-moz-opacity:0;opacity:0;" ;
      }
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.kbbaru.enterattraction", new String[] {}, new String[] {}) +"\">") ;
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<div style=\"height:0;overflow:hidden\"><input type=\"submit\" title=\"submit\"  disabled></div>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "GXH_vCOUNTRYID", GXutil.ltrim( localUtil.ntoc( AV7CountryId, (byte)(4), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "GXH_vATTRACTIONNAME", AV5AttractionName);
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "GXH_vATTRACTIONNAMETO", AV6AttractionNameTo);
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_25", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_25, (byte)(8), (byte)(0), ".", "")));
   }

   public void renderHtmlCloseForm( )
   {
      sendCloseFormHiddens( ) ;
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "GX_FocusControl", GX_FocusControl);
      httpContext.SendAjaxEncryptionKey();
      sendSecurityToken(sPrefix);
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
   }

   public void renderHtmlContent( )
   {
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         httpContext.writeText( "<div") ;
         com.kbbaru.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         we1R2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt1R2( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return false ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("com.kbbaru.enterattraction", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "EnterAttraction" ;
   }

   public String getPgmdesc( )
   {
      return "Enter Attraction" ;
   }

   public void wb1R0( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         if ( nGXWrapped == 1 )
         {
            renderHtmlHeaders( ) ;
            renderHtmlOpenForm( ) ;
         }
         com.kbbaru.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), "", "", "", "false");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"none\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, divMaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynavCountryid.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.kbbaru.GxWebStd.gx_label_element( httpContext, dynavCountryid.getInternalname(), "Country Id", "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 8,'',false,'" + sGXsfl_25_idx + "',0)\"" ;
         /* ComboBox */
         com.kbbaru.GxWebStd.gx_combobox_ctrl1( httpContext, dynavCountryid, dynavCountryid.getInternalname(), GXutil.trim( GXutil.str( AV7CountryId, 4, 0)), 1, dynavCountryid.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "oiiojiojoij", 1, dynavCountryid.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,8);\"", "", true, (byte)(0), "HLP_EnterAttraction.htm");
         dynavCountryid.setValue( GXutil.trim( GXutil.str( AV7CountryId, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavCountryid.getInternalname(), "Values", dynavCountryid.ToJavascriptSource(), true);
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Control Group */
         com.kbbaru.GxWebStd.gx_group_start( httpContext, grpGroup1_Internalname, "", 1, 0, "px", 0, "px", "Group", "", "HLP_EnterAttraction.htm");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, divGroup1table_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavAttractionname_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.kbbaru.GxWebStd.gx_label_element( httpContext, edtavAttractionname_Internalname, "Attraction Name", "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 17,'',false,'" + sGXsfl_25_idx + "',0)\"" ;
         com.kbbaru.GxWebStd.gx_single_line_edit( httpContext, edtavAttractionname_Internalname, AV5AttractionName, GXutil.rtrim( localUtil.format( AV5AttractionName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,17);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavAttractionname_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavAttractionname_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Name", "left", true, "", "HLP_EnterAttraction.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavAttractionnameto_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.kbbaru.GxWebStd.gx_label_element( httpContext, edtavAttractionnameto_Internalname, "Attraction Name To", "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'" + sGXsfl_25_idx + "',0)\"" ;
         com.kbbaru.GxWebStd.gx_single_line_edit( httpContext, edtavAttractionnameto_Internalname, AV6AttractionNameTo, GXutil.rtrim( localUtil.format( AV6AttractionNameTo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavAttractionnameto_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavAttractionnameto_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Name", "left", true, "", "HLP_EnterAttraction.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</fieldset>") ;
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         Grid1Container.SetWrapped(nGXWrapped);
         startgridcontrol25( ) ;
      }
      if ( wbEnd == 25 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_25 = (int)(nGXsfl_25_idx-1) ;
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"Grid1Container"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Grid1", Grid1Container, subGrid1_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "Grid1ContainerData", Grid1Container.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "Grid1ContainerData"+"V", Grid1Container.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Grid1ContainerData"+"V"+"\" value='"+Grid1Container.GridValuesHidden()+"'/>") ;
            }
         }
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavTotal_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.kbbaru.GxWebStd.gx_label_element( httpContext, edtavTotal_Internalname, "total", "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'" + sGXsfl_25_idx + "',0)\"" ;
         com.kbbaru.GxWebStd.gx_single_line_edit( httpContext, edtavTotal_Internalname, GXutil.ltrim( localUtil.ntoc( AV9total, (byte)(4), (byte)(0), ".", "")), GXutil.ltrim( ((edtavTotal_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV9total), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV9total), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,',');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,',');"+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTotal_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavTotal_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_EnterAttraction.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 25 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( Grid1Container.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"Grid1Container"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Grid1", Grid1Container, subGrid1_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "Grid1ContainerData", Grid1Container.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "Grid1ContainerData"+"V", Grid1Container.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Grid1ContainerData"+"V"+"\" value='"+Grid1Container.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start1R2( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 18_0_2-169539", (short)(0)) ;
         }
         Form.getMeta().addItem("description", "Enter Attraction", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup1R0( ) ;
   }

   public void ws1R2( )
   {
      start1R2( ) ;
      evt1R2( ) ;
   }

   public void evt1R2( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
            sEvt = httpContext.cgiGet( "_EventName") ;
            EvtGridId = httpContext.cgiGet( "_EventGridId") ;
            EvtRowId = httpContext.cgiGet( "_EventRowId") ;
            if ( GXutil.len( sEvt) > 0 )
            {
               sEvtType = GXutil.left( sEvt, 1) ;
               sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
               if ( GXutil.strcmp(sEvtType, "M") != 0 )
               {
                  if ( GXutil.strcmp(sEvtType, "E") == 0 )
                  {
                     sEvtType = GXutil.right( sEvt, 1) ;
                     if ( GXutil.strcmp(sEvtType, ".") == 0 )
                     {
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                        if ( GXutil.strcmp(sEvt, "RFR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 10), "GRID1.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 13), "GRID1.REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 11), "VSHOW.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 11), "VSHOW.CLICK") == 0 ) )
                        {
                           nGXsfl_25_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_25_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_25_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_252( ) ;
                           A9AttractionsId = (short)(localUtil.ctol( httpContext.cgiGet( edtAttractionsId_Internalname), ".", ",")) ;
                           A10AttractionsName = httpContext.cgiGet( edtAttractionsName_Internalname) ;
                           A16CountryCityName = httpContext.cgiGet( edtCountryCityName_Internalname) ;
                           A11AttractionsPhoto = httpContext.cgiGet( edtAttractionsPhoto_Internalname) ;
                           httpContext.ajax_rsp_assign_prop("", false, edtAttractionsPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A11AttractionsPhoto)==0) ? A40001AttractionsPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A11AttractionsPhoto))), !bGXsfl_25_Refreshing);
                           httpContext.ajax_rsp_assign_prop("", false, edtAttractionsPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A11AttractionsPhoto), true);
                           if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavTrips_Internalname), ".", ",") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavTrips_Internalname), ".", ",") > 9999 ) ) )
                           {
                              httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vTRIPS");
                              GX_FocusControl = edtavTrips_Internalname ;
                              httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                              wbErr = true ;
                              AV8trips = (short)(0) ;
                              httpContext.ajax_rsp_assign_attri("", false, edtavTrips_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8trips), 4, 0));
                           }
                           else
                           {
                              AV8trips = (short)(localUtil.ctol( httpContext.cgiGet( edtavTrips_Internalname), ".", ",")) ;
                              httpContext.ajax_rsp_assign_attri("", false, edtavTrips_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8trips), 4, 0));
                           }
                           AV11edit = httpContext.cgiGet( edtavEdit_Internalname) ;
                           httpContext.ajax_rsp_assign_prop("", false, edtavEdit_Internalname, "Bitmap", ((GXutil.strcmp("", AV11edit)==0) ? AV16Edit_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV11edit))), !bGXsfl_25_Refreshing);
                           httpContext.ajax_rsp_assign_prop("", false, edtavEdit_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV11edit), true);
                           AV12show = httpContext.cgiGet( edtavShow_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavShow_Internalname, AV12show);
                           AV13NameEdit = httpContext.cgiGet( edtavNameedit_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavNameedit_Internalname, AV13NameEdit);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e111R2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID1.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e121R2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID1.REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e131R2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "VSHOW.CLICK") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e141R2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 if ( ! wbErr )
                                 {
                                    Rfr0gs = false ;
                                    /* Set Refresh If Countryid Changed */
                                    if ( localUtil.ctol( httpContext.cgiGet( "GXH_vCOUNTRYID"), ".", ",") != AV7CountryId )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    /* Set Refresh If Attractionname Changed */
                                    if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vATTRACTIONNAME"), AV5AttractionName) != 0 )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    /* Set Refresh If Attractionnameto Changed */
                                    if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vATTRACTIONNAMETO"), AV6AttractionNameTo) != 0 )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    if ( ! Rfr0gs )
                                    {
                                    }
                                    dynload_actions( ) ;
                                 }
                                 /* No code required for Cancel button. It is implemented as the Reset button. */
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                              }
                           }
                           else
                           {
                           }
                        }
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we1R2( )
   {
      if ( ! com.kbbaru.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.kbbaru.GxWebStd.gx_redirect( httpContext) )
         {
            if ( nGXWrapped == 1 )
            {
               renderHtmlCloseForm( ) ;
            }
         }
      }
   }

   public void pa1R2( )
   {
      if ( nDonePA == 0 )
      {
         if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
         {
            gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
         }
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
         init_web_controls( ) ;
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
         if ( ! httpContext.isAjaxRequest( ) )
         {
            GX_FocusControl = dynavCountryid.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxdlvvcountryid1R2( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvcountryid_data1R2( ) ;
      gxdynajaxindex = 1 ;
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         addString( gxwrpcisep+"{\"c\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrlcodr.item(gxdynajaxindex))+"\",\"d\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrldescr.item(gxdynajaxindex))+"\"}") ;
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
         gxwrpcisep = "," ;
      }
      addString( "]") ;
      if ( gxdynajaxctrlcodr.getCount() == 0 )
      {
         addString( ",101") ;
      }
      addString( "]") ;
   }

   public void gxvvcountryid_html1R2( )
   {
      short gxdynajaxvalue;
      gxdlvvcountryid_data1R2( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavCountryid.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (short)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynavCountryid.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 4, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlvvcountryid_data1R2( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add("(None)");
      /* Using cursor H001R2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H001R2_A5CountryId[0], (byte)(4), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(H001R2_A6CountryName[0]);
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void gxnrgrid1_newrow( )
   {
      com.kbbaru.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_252( ) ;
      while ( nGXsfl_25_idx <= nRC_GXsfl_25 )
      {
         sendrow_252( ) ;
         nGXsfl_25_idx = ((subGrid1_Islastpage==1)&&(nGXsfl_25_idx+1>subgrid1_fnc_recordsperpage( )) ? 1 : nGXsfl_25_idx+1) ;
         sGXsfl_25_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_25_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_252( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Grid1Container)) ;
      /* End function gxnrGrid1_newrow */
   }

   public void gxgrgrid1_refresh( short AV7CountryId ,
                                  String AV5AttractionName ,
                                  String AV6AttractionNameTo ,
                                  String AV11edit ,
                                  String AV12show ,
                                  short AV9total )
   {
      initialize_formulas( ) ;
      com.kbbaru.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRID1_nCurrentRecord = 0 ;
      rf1R2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid1_refresh */
   }

   public void send_integrity_hashes( )
   {
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "gxhash_ATTRACTIONSID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A9AttractionsId), "ZZZ9")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "ATTRACTIONSID", GXutil.ltrim( localUtil.ntoc( A9AttractionsId, (byte)(4), (byte)(0), ".", "")));
   }

   public void clear_multi_value_controls( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         gxvvcountryid_html1R2( ) ;
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
      if ( dynavCountryid.getItemCount() > 0 )
      {
         AV7CountryId = (short)(GXutil.lval( dynavCountryid.getValidValue(GXutil.trim( GXutil.str( AV7CountryId, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CountryId), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavCountryid.setValue( GXutil.trim( GXutil.str( AV7CountryId, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavCountryid.getInternalname(), "Values", dynavCountryid.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf1R2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavTrips_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavTrips_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTrips_Enabled), 5, 0), !bGXsfl_25_Refreshing);
      edtavShow_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavShow_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavShow_Enabled), 5, 0), !bGXsfl_25_Refreshing);
   }

   public void rf1R2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         Grid1Container.ClearRows();
      }
      wbStart = (short)(25) ;
      e131R2 ();
      nGXsfl_25_idx = 1 ;
      sGXsfl_25_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_25_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_252( ) ;
      bGXsfl_25_Refreshing = true ;
      Grid1Container.AddObjectProperty("GridName", "Grid1");
      Grid1Container.AddObjectProperty("CmpContext", "");
      Grid1Container.AddObjectProperty("InMasterPage", "false");
      Grid1Container.AddObjectProperty("Class", "Grid");
      Grid1Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Grid1Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Grid1Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid1_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Grid1Container.setPageSize( subgrid1_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_252( ) ;
         pr_default.dynParam(1, new Object[]{ new Object[]{
                                              Short.valueOf(AV7CountryId) ,
                                              AV5AttractionName ,
                                              AV6AttractionNameTo ,
                                              Short.valueOf(A5CountryId) ,
                                              A10AttractionsName } ,
                                              new int[]{
                                              TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING
                                              }
         });
         /* Using cursor H001R4 */
         pr_default.execute(1, new Object[] {Short.valueOf(AV7CountryId), AV5AttractionName, AV6AttractionNameTo});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A12CountryCityId = H001R4_A12CountryCityId[0] ;
            A5CountryId = H001R4_A5CountryId[0] ;
            A11AttractionsPhoto = H001R4_A11AttractionsPhoto[0] ;
            httpContext.ajax_rsp_assign_prop("", false, edtAttractionsPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A11AttractionsPhoto)==0) ? A40001AttractionsPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A11AttractionsPhoto))), !bGXsfl_25_Refreshing);
            httpContext.ajax_rsp_assign_prop("", false, edtAttractionsPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A11AttractionsPhoto), true);
            A40001AttractionsPhoto_GXI = H001R4_A40001AttractionsPhoto_GXI[0] ;
            httpContext.ajax_rsp_assign_prop("", false, edtAttractionsPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A11AttractionsPhoto)==0) ? A40001AttractionsPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A11AttractionsPhoto))), !bGXsfl_25_Refreshing);
            httpContext.ajax_rsp_assign_prop("", false, edtAttractionsPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A11AttractionsPhoto), true);
            A16CountryCityName = H001R4_A16CountryCityName[0] ;
            A10AttractionsName = H001R4_A10AttractionsName[0] ;
            A9AttractionsId = H001R4_A9AttractionsId[0] ;
            A40000GXC1 = H001R4_A40000GXC1[0] ;
            n40000GXC1 = H001R4_n40000GXC1[0] ;
            A16CountryCityName = H001R4_A16CountryCityName[0] ;
            A40000GXC1 = H001R4_A40000GXC1[0] ;
            n40000GXC1 = H001R4_n40000GXC1[0] ;
            e121R2 ();
            pr_default.readNext(1);
         }
         pr_default.close(1);
         wbEnd = (short)(25) ;
         wb1R0( ) ;
      }
      bGXsfl_25_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes1R2( )
   {
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "gxhash_ATTRACTIONSID"+"_"+sGXsfl_25_idx, getSecureSignedToken( sGXsfl_25_idx, localUtil.format( DecimalUtil.doubleToDec(A9AttractionsId), "ZZZ9")));
   }

   public int subgrid1_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subgrid1_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subgrid1_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subgrid1_fnc_currentpage( )
   {
      return -1 ;
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      edtavTrips_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavTrips_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTrips_Enabled), 5, 0), !bGXsfl_25_Refreshing);
      edtavShow_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavShow_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavShow_Enabled), 5, 0), !bGXsfl_25_Refreshing);
      gxvvcountryid_html1R2( ) ;
      fix_multi_value_controls( ) ;
   }

   public void strup1R0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e111R2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         nRC_GXsfl_25 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_25"), ".", ",")) ;
         /* Read variables values. */
         dynavCountryid.setName( dynavCountryid.getInternalname() );
         dynavCountryid.setValue( httpContext.cgiGet( dynavCountryid.getInternalname()) );
         AV7CountryId = (short)(GXutil.lval( httpContext.cgiGet( dynavCountryid.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CountryId), 4, 0));
         AV5AttractionName = httpContext.cgiGet( edtavAttractionname_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5AttractionName", AV5AttractionName);
         AV6AttractionNameTo = httpContext.cgiGet( edtavAttractionnameto_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV6AttractionNameTo", AV6AttractionNameTo);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavTotal_Internalname), ".", ",") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavTotal_Internalname), ".", ",") > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vTOTAL");
            GX_FocusControl = edtavTotal_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV9total = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9total", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9total), 4, 0));
         }
         else
         {
            AV9total = (short)(localUtil.ctol( httpContext.cgiGet( edtavTotal_Internalname), ".", ",")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9total", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9total), 4, 0));
         }
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
      e111R2 ();
      if (returnInSub) return;
   }

   public void e111R2( )
   {
      /* Start Routine */
      returnInSub = false ;
      edtavEdit_gximage = "GeneXusUnanimo_edit" ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEdit_Internalname, "gximage", edtavEdit_gximage, !bGXsfl_25_Refreshing);
      AV11edit = context.getHttpContext().getImagePath( "0262a982-cd0b-446a-a8f5-d714e80dd0f0", "", context.getHttpContext().getTheme( )) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEdit_Internalname, "Bitmap", ((GXutil.strcmp("", AV11edit)==0) ? AV16Edit_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV11edit))), !bGXsfl_25_Refreshing);
      httpContext.ajax_rsp_assign_prop("", false, edtavEdit_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV11edit), true);
      AV16Edit_GXI = GXDbFile.pathToUrl( context.getHttpContext().getImagePath( "0262a982-cd0b-446a-a8f5-d714e80dd0f0", "", context.getHttpContext().getTheme( )), context.getHttpContext()) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEdit_Internalname, "Bitmap", ((GXutil.strcmp("", AV11edit)==0) ? AV16Edit_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV11edit))), !bGXsfl_25_Refreshing);
      httpContext.ajax_rsp_assign_prop("", false, edtavEdit_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV11edit), true);
      AV12show = "Add Trips" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavShow_Internalname, AV12show);
   }

   private void e121R2( )
   {
      /* Grid1_Load Routine */
      returnInSub = false ;
      AV13NameEdit = A10AttractionsName ;
      httpContext.ajax_rsp_assign_attri("", false, edtavNameedit_Internalname, AV13NameEdit);
      AV8trips = (short)(A40000GXC1) ;
      httpContext.ajax_rsp_assign_attri("", false, edtavTrips_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8trips), 4, 0));
      AV9total = (short)(AV9total+AV8trips) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9total", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9total), 4, 0));
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(25) ;
      }
      sendrow_252( ) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_25_Refreshing )
      {
         httpContext.doAjaxLoad(25, Grid1Row);
      }
      /*  Sending Event outputs  */
   }

   public void e131R2( )
   {
      /* Grid1_Refresh Routine */
      returnInSub = false ;
      AV9total = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9total", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9total), 4, 0));
      /*  Sending Event outputs  */
   }

   public void e141R2( )
   {
      /* Show_Click Routine */
      returnInSub = false ;
      GXt_int1 = AV8trips ;
      GXv_int2[0] = GXt_int1 ;
      new com.kbbaru.newtrip(remoteHandle, context).execute( A9AttractionsId, GXv_int2) ;
      enterattraction_impl.this.GXt_int1 = GXv_int2[0] ;
      AV8trips = (short)(GXt_int1) ;
      httpContext.ajax_rsp_assign_attri("", false, edtavTrips_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8trips), 4, 0));
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
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
      pa1R2( ) ;
      ws1R2( ) ;
      we1R2( ) ;
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
      httpContext.setWrapped(false);
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202352610235548", true, true);
         idxLst = (int)(idxLst+1) ;
      }
      if ( ! outputEnabled )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
      }
      /* End function define_styles */
   }

   public void include_jscripts( )
   {
      httpContext.AddJavascriptSource("messages.eng.js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      httpContext.AddJavascriptSource("enterattraction.js", "?202352610235549", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_252( )
   {
      edtAttractionsId_Internalname = "ATTRACTIONSID_"+sGXsfl_25_idx ;
      edtAttractionsName_Internalname = "ATTRACTIONSNAME_"+sGXsfl_25_idx ;
      edtCountryCityName_Internalname = "COUNTRYCITYNAME_"+sGXsfl_25_idx ;
      edtAttractionsPhoto_Internalname = "ATTRACTIONSPHOTO_"+sGXsfl_25_idx ;
      edtavTrips_Internalname = "vTRIPS_"+sGXsfl_25_idx ;
      edtavEdit_Internalname = "vEDIT_"+sGXsfl_25_idx ;
      edtavShow_Internalname = "vSHOW_"+sGXsfl_25_idx ;
      edtavNameedit_Internalname = "vNAMEEDIT_"+sGXsfl_25_idx ;
   }

   public void subsflControlProps_fel_252( )
   {
      edtAttractionsId_Internalname = "ATTRACTIONSID_"+sGXsfl_25_fel_idx ;
      edtAttractionsName_Internalname = "ATTRACTIONSNAME_"+sGXsfl_25_fel_idx ;
      edtCountryCityName_Internalname = "COUNTRYCITYNAME_"+sGXsfl_25_fel_idx ;
      edtAttractionsPhoto_Internalname = "ATTRACTIONSPHOTO_"+sGXsfl_25_fel_idx ;
      edtavTrips_Internalname = "vTRIPS_"+sGXsfl_25_fel_idx ;
      edtavEdit_Internalname = "vEDIT_"+sGXsfl_25_fel_idx ;
      edtavShow_Internalname = "vSHOW_"+sGXsfl_25_fel_idx ;
      edtavNameedit_Internalname = "vNAMEEDIT_"+sGXsfl_25_fel_idx ;
   }

   public void sendrow_252( )
   {
      subsflControlProps_252( ) ;
      wb1R0( ) ;
      Grid1Row = GXWebRow.GetNew(context,Grid1Container) ;
      if ( subGrid1_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGrid1_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGrid1_Class, "") != 0 )
         {
            subGrid1_Linesclass = subGrid1_Class+"Odd" ;
         }
      }
      else if ( subGrid1_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGrid1_Backstyle = (byte)(0) ;
         subGrid1_Backcolor = subGrid1_Allbackcolor ;
         if ( GXutil.strcmp(subGrid1_Class, "") != 0 )
         {
            subGrid1_Linesclass = subGrid1_Class+"Uniform" ;
         }
      }
      else if ( subGrid1_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGrid1_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGrid1_Class, "") != 0 )
         {
            subGrid1_Linesclass = subGrid1_Class+"Odd" ;
         }
         subGrid1_Backcolor = (int)(0x0) ;
      }
      else if ( subGrid1_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGrid1_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_25_idx) % (2))) == 0 )
         {
            subGrid1_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGrid1_Class, "") != 0 )
            {
               subGrid1_Linesclass = subGrid1_Class+"Even" ;
            }
         }
         else
         {
            subGrid1_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGrid1_Class, "") != 0 )
            {
               subGrid1_Linesclass = subGrid1_Class+"Odd" ;
            }
         }
      }
      if ( Grid1Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<tr ") ;
         httpContext.writeText( " class=\""+"Grid"+"\" style=\""+""+"\"") ;
         httpContext.writeText( " gxrow=\""+sGXsfl_25_idx+"\">") ;
      }
      /* Subfile cell */
      if ( Grid1Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
      }
      /* Single line edit */
      ROClassString = "Attribute" ;
      Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtAttractionsId_Internalname,GXutil.ltrim( localUtil.ntoc( A9AttractionsId, (byte)(4), (byte)(0), ".", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A9AttractionsId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtAttractionsId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(25),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      if ( Grid1Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
      }
      /* Single line edit */
      ROClassString = "Attribute" ;
      Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtAttractionsName_Internalname,A10AttractionsName,"","","'"+""+"'"+",false,"+"'"+"e151r2_client"+"'","","","","",edtAttractionsName_Jsonclick,Integer.valueOf(7),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(25),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"Name","left",Boolean.valueOf(true),""});
      /* Subfile cell */
      if ( Grid1Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
      }
      /* Single line edit */
      ROClassString = "Attribute" ;
      Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCountryCityName_Internalname,A16CountryCityName,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCountryCityName_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(25),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"Name","left",Boolean.valueOf(true),""});
      /* Subfile cell */
      if ( Grid1Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+""+"\">") ;
      }
      /* Static Bitmap Variable */
      ClassString = "ImageAttribute" ;
      StyleString = "" ;
      A11AttractionsPhoto_IsBlob = (boolean)(((GXutil.strcmp("", A11AttractionsPhoto)==0)&&(GXutil.strcmp("", A40001AttractionsPhoto_GXI)==0))||!(GXutil.strcmp("", A11AttractionsPhoto)==0)) ;
      sImgUrl = ((GXutil.strcmp("", A11AttractionsPhoto)==0) ? A40001AttractionsPhoto_GXI : httpContext.getResourceRelative(A11AttractionsPhoto)) ;
      Grid1Row.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtAttractionsPhoto_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"px",Integer.valueOf(0),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"","","","","","","",Integer.valueOf(1),Boolean.valueOf(A11AttractionsPhoto_IsBlob),Boolean.valueOf(true),context.getHttpContext().getImageSrcSet( sImgUrl)});
      /* Subfile cell */
      if ( Grid1Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
      }
      /* Single line edit */
      TempTags = " " + ((edtavTrips_Enabled!=0)&&(edtavTrips_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 30,'',false,'"+sGXsfl_25_idx+"',25)\"" : " ") ;
      ROClassString = "Attribute" ;
      Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavTrips_Internalname,GXutil.ltrim( localUtil.ntoc( AV8trips, (byte)(4), (byte)(0), ".", "")),GXutil.ltrim( ((edtavTrips_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV8trips), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV8trips), "ZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,',');"+";gx.evt.onchange(this, event)\" "+((edtavTrips_Enabled!=0)&&(edtavTrips_Visible!=0) ? " onblur=\""+"gx.num.valid_integer( this,',');"+";gx.evt.onblur(this,30);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavTrips_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtavTrips_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(25),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      if ( Grid1Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+""+"\">") ;
      }
      /* Active Bitmap Variable */
      TempTags = " " + ((edtavEdit_Enabled!=0)&&(edtavEdit_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 31,'',false,'',25)\"" : " ") ;
      ClassString = "Image" + " " + ((GXutil.strcmp(edtavEdit_gximage, "")==0) ? "" : "GX_Image_"+edtavEdit_gximage+"_Class") ;
      StyleString = "" ;
      AV11edit_IsBlob = (boolean)(((GXutil.strcmp("", AV11edit)==0)&&(GXutil.strcmp("", AV16Edit_GXI)==0))||!(GXutil.strcmp("", AV11edit)==0)) ;
      sImgUrl = ((GXutil.strcmp("", AV11edit)==0) ? AV16Edit_GXI : httpContext.getResourceRelative(AV11edit)) ;
      Grid1Row.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavEdit_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(-1),Integer.valueOf(1),"","",Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"px",Integer.valueOf(0),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(7),edtavEdit_Jsonclick,"'"+""+"'"+",false,"+"'"+"e161r2_client"+"'",StyleString,ClassString,"","","","",""+TempTags,"","",Integer.valueOf(1),Boolean.valueOf(AV11edit_IsBlob),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
      /* Subfile cell */
      if ( Grid1Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
      }
      /* Single line edit */
      TempTags = " " + ((edtavShow_Enabled!=0)&&(edtavShow_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 32,'',false,'"+sGXsfl_25_idx+"',25)\"" : " ") ;
      ROClassString = "Attribute" ;
      Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavShow_Internalname,GXutil.rtrim( AV12show),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavShow_Enabled!=0)&&(edtavShow_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,32);\"" : " "),"'"+""+"'"+",false,"+"'"+"EVSHOW.CLICK."+sGXsfl_25_idx+"'","","","","",edtavShow_Jsonclick,Integer.valueOf(5),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtavShow_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(25),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      /* Subfile cell */
      if ( Grid1Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
      }
      /* Single line edit */
      TempTags = " " + ((edtavNameedit_Enabled!=0)&&(edtavNameedit_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 33,'',false,'"+sGXsfl_25_idx+"',25)\"" : " ") ;
      ROClassString = "Attribute" ;
      Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavNameedit_Internalname,AV13NameEdit,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavNameedit_Enabled!=0)&&(edtavNameedit_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,33);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavNameedit_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(25),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"Name","left",Boolean.valueOf(true),""});
      send_integrity_lvl_hashes1R2( ) ;
      Grid1Container.AddRow(Grid1Row);
      nGXsfl_25_idx = ((subGrid1_Islastpage==1)&&(nGXsfl_25_idx+1>subgrid1_fnc_recordsperpage( )) ? 1 : nGXsfl_25_idx+1) ;
      sGXsfl_25_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_25_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_252( ) ;
      /* End function sendrow_252 */
   }

   public void startgridcontrol25( )
   {
      if ( Grid1Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"Grid1Container"+"DivS\" data-gxgridid=\"25\">") ;
         sStyleString = "" ;
         com.kbbaru.GxWebStd.gx_table_start( httpContext, subGrid1_Internalname, subGrid1_Internalname, "", "Grid", 0, "", "", 1, 2, sStyleString, "", "", 0);
         /* Subfile titles */
         httpContext.writeText( "<tr") ;
         httpContext.writeTextNL( ">") ;
         if ( subGrid1_Backcolorstyle == 0 )
         {
            subGrid1_Titlebackstyle = (byte)(0) ;
            if ( GXutil.len( subGrid1_Class) > 0 )
            {
               subGrid1_Linesclass = subGrid1_Class+"Title" ;
            }
         }
         else
         {
            subGrid1_Titlebackstyle = (byte)(1) ;
            if ( subGrid1_Backcolorstyle == 1 )
            {
               subGrid1_Titlebackcolor = subGrid1_Allbackcolor ;
               if ( GXutil.len( subGrid1_Class) > 0 )
               {
                  subGrid1_Linesclass = subGrid1_Class+"UniformTitle" ;
               }
            }
            else
            {
               if ( GXutil.len( subGrid1_Class) > 0 )
               {
                  subGrid1_Linesclass = subGrid1_Class+"Title" ;
               }
            }
         }
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "ID") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "Name") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "City") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"ImageAttribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "Photos") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "trip") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Image"+" "+((GXutil.strcmp(edtavEdit_gximage, "")==0) ? "" : "GX_Image_"+edtavEdit_gximage+"_Class")+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "Trip") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "Name") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
         Grid1Container.AddObjectProperty("GridName", "Grid1");
      }
      else
      {
         if ( isAjaxCallMode( ) )
         {
            Grid1Container = new com.genexus.webpanels.GXWebGrid(context);
         }
         else
         {
            Grid1Container.Clear();
         }
         Grid1Container.SetWrapped(nGXWrapped);
         Grid1Container.AddObjectProperty("GridName", "Grid1");
         Grid1Container.AddObjectProperty("Header", subGrid1_Header);
         Grid1Container.AddObjectProperty("Class", "Grid");
         Grid1Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid1_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("CmpContext", "");
         Grid1Container.AddObjectProperty("InMasterPage", "false");
         Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid1Column.AddObjectProperty("Value", WebUtils.htmlEncode( GXutil.ltrim( localUtil.ntoc( A9AttractionsId, (byte)(4), (byte)(0), ".", ""))));
         Grid1Container.AddColumnProperties(Grid1Column);
         Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid1Column.AddObjectProperty("Value", WebUtils.htmlEncode( A10AttractionsName));
         Grid1Container.AddColumnProperties(Grid1Column);
         Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid1Column.AddObjectProperty("Value", WebUtils.htmlEncode( A16CountryCityName));
         Grid1Container.AddColumnProperties(Grid1Column);
         Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid1Column.AddObjectProperty("Value", httpContext.convertURL( A11AttractionsPhoto));
         Grid1Container.AddColumnProperties(Grid1Column);
         Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid1Column.AddObjectProperty("Value", WebUtils.htmlEncode( GXutil.ltrim( localUtil.ntoc( AV8trips, (byte)(4), (byte)(0), ".", ""))));
         Grid1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavTrips_Enabled, (byte)(5), (byte)(0), ".", "")));
         Grid1Container.AddColumnProperties(Grid1Column);
         Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid1Column.AddObjectProperty("Value", httpContext.convertURL( AV11edit));
         Grid1Container.AddColumnProperties(Grid1Column);
         Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid1Column.AddObjectProperty("Value", WebUtils.htmlEncode( GXutil.rtrim( AV12show)));
         Grid1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavShow_Enabled, (byte)(5), (byte)(0), ".", "")));
         Grid1Container.AddColumnProperties(Grid1Column);
         Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid1Column.AddObjectProperty("Value", WebUtils.htmlEncode( AV13NameEdit));
         Grid1Container.AddColumnProperties(Grid1Column);
         Grid1Container.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGrid1_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGrid1_Allowselection, (byte)(1), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGrid1_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGrid1_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGrid1_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGrid1_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGrid1_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void init_default_properties( )
   {
      dynavCountryid.setInternalname( "vCOUNTRYID" );
      edtavAttractionname_Internalname = "vATTRACTIONNAME" ;
      edtavAttractionnameto_Internalname = "vATTRACTIONNAMETO" ;
      divGroup1table_Internalname = "GROUP1TABLE" ;
      grpGroup1_Internalname = "GROUP1" ;
      edtAttractionsId_Internalname = "ATTRACTIONSID" ;
      edtAttractionsName_Internalname = "ATTRACTIONSNAME" ;
      edtCountryCityName_Internalname = "COUNTRYCITYNAME" ;
      edtAttractionsPhoto_Internalname = "ATTRACTIONSPHOTO" ;
      edtavTrips_Internalname = "vTRIPS" ;
      edtavEdit_Internalname = "vEDIT" ;
      edtavShow_Internalname = "vSHOW" ;
      edtavNameedit_Internalname = "vNAMEEDIT" ;
      edtavTotal_Internalname = "vTOTAL" ;
      divMaintable_Internalname = "MAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGrid1_Internalname = "GRID1" ;
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      httpContext.setDefaultTheme("KBBaru", true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_default_properties( ) ;
      subGrid1_Allowcollapsing = (byte)(0) ;
      subGrid1_Allowselection = (byte)(0) ;
      subGrid1_Header = "" ;
      edtavNameedit_Jsonclick = "" ;
      edtavNameedit_Visible = -1 ;
      edtavNameedit_Enabled = 1 ;
      edtavShow_Jsonclick = "" ;
      edtavShow_Visible = -1 ;
      edtavShow_Enabled = 1 ;
      edtavEdit_Jsonclick = "" ;
      edtavEdit_Visible = -1 ;
      edtavEdit_Enabled = 1 ;
      edtavTrips_Jsonclick = "" ;
      edtavTrips_Visible = -1 ;
      edtavTrips_Enabled = 1 ;
      edtCountryCityName_Jsonclick = "" ;
      edtAttractionsName_Jsonclick = "" ;
      edtAttractionsId_Jsonclick = "" ;
      subGrid1_Class = "Grid" ;
      subGrid1_Backcolorstyle = (byte)(0) ;
      edtavEdit_gximage = "" ;
      edtavTotal_Jsonclick = "" ;
      edtavTotal_Enabled = 1 ;
      edtavAttractionnameto_Jsonclick = "" ;
      edtavAttractionnameto_Enabled = 1 ;
      edtavAttractionname_Jsonclick = "" ;
      edtavAttractionname_Enabled = 1 ;
      dynavCountryid.setJsonclick( "" );
      dynavCountryid.setEnabled( 1 );
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Enter Attraction" );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      dynavCountryid.setName( "vCOUNTRYID" );
      dynavCountryid.setWebtags( "" );
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'AV5AttractionName',fld:'vATTRACTIONNAME',pic:''},{av:'AV6AttractionNameTo',fld:'vATTRACTIONNAMETO',pic:''},{av:'AV11edit',fld:'vEDIT',pic:''},{av:'AV12show',fld:'vSHOW',pic:''},{av:'AV9total',fld:'vTOTAL',pic:'ZZZ9'},{av:'dynavCountryid'},{av:'AV7CountryId',fld:'vCOUNTRYID',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("VEDIT.CLICK","{handler:'e161R2',iparms:[{av:'A9AttractionsId',fld:'ATTRACTIONSID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("VEDIT.CLICK",",oparms:[]}");
      setEventMetadata("GRID1.LOAD","{handler:'e121R2',iparms:[{av:'A10AttractionsName',fld:'ATTRACTIONSNAME',pic:''},{av:'AV9total',fld:'vTOTAL',pic:'ZZZ9'}]");
      setEventMetadata("GRID1.LOAD",",oparms:[{av:'AV13NameEdit',fld:'vNAMEEDIT',pic:''},{av:'AV8trips',fld:'vTRIPS',pic:'ZZZ9'},{av:'A40000GXC1',fld:'GXC1',pic:'999999999'},{av:'AV9total',fld:'vTOTAL',pic:'ZZZ9'}]}");
      setEventMetadata("GRID1.REFRESH","{handler:'e131R2',iparms:[]");
      setEventMetadata("GRID1.REFRESH",",oparms:[{av:'AV9total',fld:'vTOTAL',pic:'ZZZ9'}]}");
      setEventMetadata("VSHOW.CLICK","{handler:'e141R2',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'dynavCountryid'},{av:'AV7CountryId',fld:'vCOUNTRYID',pic:'ZZZ9'},{av:'AV5AttractionName',fld:'vATTRACTIONNAME',pic:''},{av:'AV6AttractionNameTo',fld:'vATTRACTIONNAMETO',pic:''},{av:'AV11edit',fld:'vEDIT',pic:''},{av:'AV12show',fld:'vSHOW',pic:''},{av:'AV9total',fld:'vTOTAL',pic:'ZZZ9'},{av:'A9AttractionsId',fld:'ATTRACTIONSID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("VSHOW.CLICK",",oparms:[{av:'AV8trips',fld:'vTRIPS',pic:'ZZZ9'}]}");
      setEventMetadata("ATTRACTIONSNAME.CLICK","{handler:'e151R2',iparms:[{av:'A9AttractionsId',fld:'ATTRACTIONSID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("ATTRACTIONSNAME.CLICK",",oparms:[]}");
      setEventMetadata("VALID_ATTRACTIONSID","{handler:'valid_Attractionsid',iparms:[]");
      setEventMetadata("VALID_ATTRACTIONSID",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Nameedit',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
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
      AV11edit = "" ;
      AV12show = "" ;
      AV5AttractionName = "" ;
      AV6AttractionNameTo = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      TempTags = "" ;
      Grid1Container = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      A10AttractionsName = "" ;
      A16CountryCityName = "" ;
      A11AttractionsPhoto = "" ;
      A40001AttractionsPhoto_GXI = "" ;
      AV16Edit_GXI = "" ;
      AV13NameEdit = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      scmdbuf = "" ;
      H001R2_A5CountryId = new short[1] ;
      H001R2_A6CountryName = new String[] {""} ;
      H001R4_A12CountryCityId = new short[1] ;
      H001R4_A5CountryId = new short[1] ;
      H001R4_A11AttractionsPhoto = new String[] {""} ;
      H001R4_A40001AttractionsPhoto_GXI = new String[] {""} ;
      H001R4_A16CountryCityName = new String[] {""} ;
      H001R4_A10AttractionsName = new String[] {""} ;
      H001R4_A9AttractionsId = new short[1] ;
      H001R4_A40000GXC1 = new int[1] ;
      H001R4_n40000GXC1 = new boolean[] {false} ;
      Grid1Row = new com.genexus.webpanels.GXWebRow();
      GXv_int2 = new long[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGrid1_Linesclass = "" ;
      ROClassString = "" ;
      ClassString = "" ;
      StyleString = "" ;
      sImgUrl = "" ;
      Grid1Column = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.kbbaru.enterattraction__default(),
         new Object[] {
             new Object[] {
            H001R2_A5CountryId, H001R2_A6CountryName
            }
            , new Object[] {
            H001R4_A12CountryCityId, H001R4_A5CountryId, H001R4_A11AttractionsPhoto, H001R4_A40001AttractionsPhoto_GXI, H001R4_A16CountryCityName, H001R4_A10AttractionsName, H001R4_A9AttractionsId, H001R4_A40000GXC1, H001R4_n40000GXC1
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavTrips_Enabled = 0 ;
      edtavShow_Enabled = 0 ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte subGrid1_Backcolorstyle ;
   private byte GRID1_nEOF ;
   private byte nGXWrapped ;
   private byte subGrid1_Backstyle ;
   private byte subGrid1_Titlebackstyle ;
   private byte subGrid1_Allowselection ;
   private byte subGrid1_Allowhovering ;
   private byte subGrid1_Allowcollapsing ;
   private byte subGrid1_Collapsed ;
   private short AV7CountryId ;
   private short AV9total ;
   private short wbEnd ;
   private short wbStart ;
   private short A9AttractionsId ;
   private short AV8trips ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short A5CountryId ;
   private short A12CountryCityId ;
   private int nRC_GXsfl_25 ;
   private int nGXsfl_25_idx=1 ;
   private int edtavAttractionname_Enabled ;
   private int edtavAttractionnameto_Enabled ;
   private int edtavTotal_Enabled ;
   private int gxdynajaxindex ;
   private int subGrid1_Islastpage ;
   private int edtavTrips_Enabled ;
   private int edtavShow_Enabled ;
   private int A40000GXC1 ;
   private int idxLst ;
   private int subGrid1_Backcolor ;
   private int subGrid1_Allbackcolor ;
   private int edtavTrips_Visible ;
   private int edtavEdit_Enabled ;
   private int edtavEdit_Visible ;
   private int edtavShow_Visible ;
   private int edtavNameedit_Enabled ;
   private int edtavNameedit_Visible ;
   private int subGrid1_Titlebackcolor ;
   private int subGrid1_Selectedindex ;
   private int subGrid1_Selectioncolor ;
   private int subGrid1_Hoveringcolor ;
   private long GRID1_nCurrentRecord ;
   private long GRID1_nFirstRecordOnPage ;
   private long GXt_int1 ;
   private long GXv_int2[] ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_25_idx="0001" ;
   private String AV12show ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divMaintable_Internalname ;
   private String TempTags ;
   private String grpGroup1_Internalname ;
   private String divGroup1table_Internalname ;
   private String edtavAttractionname_Internalname ;
   private String edtavAttractionname_Jsonclick ;
   private String edtavAttractionnameto_Internalname ;
   private String edtavAttractionnameto_Jsonclick ;
   private String sStyleString ;
   private String subGrid1_Internalname ;
   private String edtavTotal_Internalname ;
   private String edtavTotal_Jsonclick ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtAttractionsId_Internalname ;
   private String edtAttractionsName_Internalname ;
   private String edtCountryCityName_Internalname ;
   private String edtAttractionsPhoto_Internalname ;
   private String edtavTrips_Internalname ;
   private String edtavEdit_Internalname ;
   private String edtavShow_Internalname ;
   private String edtavNameedit_Internalname ;
   private String gxwrpcisep ;
   private String scmdbuf ;
   private String edtavEdit_gximage ;
   private String sGXsfl_25_fel_idx="0001" ;
   private String subGrid1_Class ;
   private String subGrid1_Linesclass ;
   private String ROClassString ;
   private String edtAttractionsId_Jsonclick ;
   private String edtAttractionsName_Jsonclick ;
   private String edtCountryCityName_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String sImgUrl ;
   private String edtavTrips_Jsonclick ;
   private String edtavEdit_Jsonclick ;
   private String edtavShow_Jsonclick ;
   private String edtavNameedit_Jsonclick ;
   private String subGrid1_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_25_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n40000GXC1 ;
   private boolean returnInSub ;
   private boolean A11AttractionsPhoto_IsBlob ;
   private boolean AV11edit_IsBlob ;
   private String AV5AttractionName ;
   private String AV6AttractionNameTo ;
   private String A10AttractionsName ;
   private String A16CountryCityName ;
   private String A40001AttractionsPhoto_GXI ;
   private String AV16Edit_GXI ;
   private String AV13NameEdit ;
   private String AV11edit ;
   private String A11AttractionsPhoto ;
   private com.genexus.webpanels.GXWebGrid Grid1Container ;
   private com.genexus.webpanels.GXWebRow Grid1Row ;
   private com.genexus.webpanels.GXWebColumn Grid1Column ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private HTMLChoice dynavCountryid ;
   private IDataStoreProvider pr_default ;
   private short[] H001R2_A5CountryId ;
   private String[] H001R2_A6CountryName ;
   private short[] H001R4_A12CountryCityId ;
   private short[] H001R4_A5CountryId ;
   private String[] H001R4_A11AttractionsPhoto ;
   private String[] H001R4_A40001AttractionsPhoto_GXI ;
   private String[] H001R4_A16CountryCityName ;
   private String[] H001R4_A10AttractionsName ;
   private short[] H001R4_A9AttractionsId ;
   private int[] H001R4_A40000GXC1 ;
   private boolean[] H001R4_n40000GXC1 ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class enterattraction__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H001R4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short AV7CountryId ,
                                          String AV5AttractionName ,
                                          String AV6AttractionNameTo ,
                                          short A5CountryId ,
                                          String A10AttractionsName )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int3 = new byte[3];
      Object[] GXv_Object4 = new Object[2];
      scmdbuf = "SELECT T1.CountryCityId, T1.CountryId, T1.AttractionsPhoto, T1.AttractionsPhoto_GXI, T2.CountryCityName, T1.AttractionsName, T1.AttractionsId, COALESCE( T3.GXC1," ;
      scmdbuf += " 0) AS GXC1 FROM ((Attractions T1 INNER JOIN CountryCity T2 ON T2.CountryId = T1.CountryId AND T2.CountryCityId = T1.CountryCityId) LEFT JOIN LATERAL (SELECT COUNT(*)" ;
      scmdbuf += " AS GXC1, T4.AttractionsId FROM (TripsAttrations T4 INNER JOIN Trips T5 ON T5.TripsId = T4.TripsId) WHERE T1.AttractionsId = T4.AttractionsId GROUP BY T4.AttractionsId" ;
      scmdbuf += " ) T3 ON T3.AttractionsId = T1.AttractionsId)" ;
      if ( ! (0==AV7CountryId) )
      {
         addWhere(sWhereString, "(T1.CountryId = ?)");
      }
      else
      {
         GXv_int3[0] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV5AttractionName)==0) )
      {
         addWhere(sWhereString, "(T1.AttractionsName >= ( ?))");
      }
      else
      {
         GXv_int3[1] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV6AttractionNameTo)==0) )
      {
         addWhere(sWhereString, "(T1.AttractionsName <= ( ?))");
      }
      else
      {
         GXv_int3[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ! (0==AV7CountryId) )
      {
         scmdbuf += " ORDER BY T1.CountryId, T1.AttractionsName" ;
      }
      else if ( true )
      {
         scmdbuf += " ORDER BY T1.AttractionsId" ;
      }
      GXv_Object4[0] = scmdbuf ;
      GXv_Object4[1] = GXv_int3 ;
      return GXv_Object4 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 1 :
                  return conditional_H001R4(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , (String)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).shortValue() , (String)dynConstraints[4] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H001R2", "SELECT CountryId, CountryName FROM Country ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H001R4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getMultimediaFile(3, rslt.getVarchar(4));
               ((String[]) buf[3])[0] = rslt.getMultimediaUri(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[3]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[4], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[5], 40);
               }
               return;
      }
   }

}

