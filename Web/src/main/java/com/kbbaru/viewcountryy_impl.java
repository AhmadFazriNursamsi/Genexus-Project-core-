package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class viewcountryy_impl extends GXDataArea
{
   public viewcountryy_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public viewcountryy_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( viewcountryy_impl.class ));
   }

   public viewcountryy_impl( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "CountryId") ;
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxEvt") == 0 )
         {
            httpContext.setAjaxEventMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "CountryId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "CountryId") ;
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
         if ( ! entryPointCalled && ! ( isAjaxCallMode( ) || isFullAjaxMode( ) ) )
         {
            A5CountryId = (short)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A5CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A5CountryId), 4, 0));
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
      nRC_GXsfl_24 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_24"))) ;
      nGXsfl_24_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_24_idx"))) ;
      sGXsfl_24_idx = httpContext.GetPar( "sGXsfl_24_idx") ;
      AV9edit = httpContext.GetPar( "edit") ;
      AV10add = httpContext.GetPar( "add") ;
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
      AV5attractionName = httpContext.GetPar( "attractionName") ;
      AV6attractionNameto = httpContext.GetPar( "attractionNameto") ;
      A5CountryId = (short)(GXutil.lval( httpContext.GetPar( "CountryId"))) ;
      AV9edit = httpContext.GetPar( "edit") ;
      AV10add = httpContext.GetPar( "add") ;
      AV11total = (short)(GXutil.lval( httpContext.GetPar( "total"))) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid1_refresh( AV5attractionName, AV6attractionNameto, A5CountryId, AV9edit, AV10add, AV11total) ;
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
      pa252( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start252( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.kbbaru.viewcountryy", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A5CountryId,4,0))}, new String[] {"CountryId"}) +"\">") ;
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
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "GXH_vATTRACTIONNAME", AV5attractionName);
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "GXH_vATTRACTIONNAMETO", AV6attractionNameto);
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_24", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_24, (byte)(8), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "COUNTRYID", GXutil.ltrim( localUtil.ntoc( A5CountryId, (byte)(4), (byte)(0), ".", "")));
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
         we252( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt252( ) ;
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
      return formatLink("com.kbbaru.viewcountryy", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A5CountryId,4,0))}, new String[] {"CountryId"})  ;
   }

   public String getPgmname( )
   {
      return "ViewCountryy" ;
   }

   public String getPgmdesc( )
   {
      return "View Countryy" ;
   }

   public void wb250( )
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
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCountryName_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.kbbaru.GxWebStd.gx_label_element( httpContext, edtCountryName_Internalname, "Country Name", "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         ROClassString = "Attribute" ;
         com.kbbaru.GxWebStd.gx_single_line_edit( httpContext, edtCountryName_Internalname, A6CountryName, GXutil.rtrim( localUtil.format( A6CountryName, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCountryName_Jsonclick, 0, "Attribute", "", ROClassString, "", "", 1, edtCountryName_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Name", "left", true, "", "HLP_ViewCountryy.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, divTable1_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavAttractionname_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.kbbaru.GxWebStd.gx_label_element( httpContext, edtavAttractionname_Internalname, "attraction Name", "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 16,'',false,'" + sGXsfl_24_idx + "',0)\"" ;
         com.kbbaru.GxWebStd.gx_single_line_edit( httpContext, edtavAttractionname_Internalname, AV5attractionName, GXutil.rtrim( localUtil.format( AV5attractionName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,16);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavAttractionname_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavAttractionname_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Name", "left", true, "", "HLP_ViewCountryy.htm");
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
         com.kbbaru.GxWebStd.gx_label_element( httpContext, edtavAttractionnameto_Internalname, "attraction Nameto", "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 21,'',false,'" + sGXsfl_24_idx + "',0)\"" ;
         com.kbbaru.GxWebStd.gx_single_line_edit( httpContext, edtavAttractionnameto_Internalname, AV6attractionNameto, GXutil.rtrim( localUtil.format( AV6attractionNameto, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,21);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavAttractionnameto_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavAttractionnameto_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Name", "left", true, "", "HLP_ViewCountryy.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         Grid1Container.SetWrapped(nGXWrapped);
         startgridcontrol24( ) ;
      }
      if ( wbEnd == 24 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_24 = (int)(nGXsfl_24_idx-1) ;
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 36,'',false,'" + sGXsfl_24_idx + "',0)\"" ;
         com.kbbaru.GxWebStd.gx_single_line_edit( httpContext, edtavTotal_Internalname, GXutil.ltrim( localUtil.ntoc( AV11total, (byte)(4), (byte)(0), ".", "")), GXutil.ltrim( ((edtavTotal_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV11total), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV11total), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,',');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,',');"+";gx.evt.onblur(this,36);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTotal_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavTotal_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ViewCountryy.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 24 )
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

   public void start252( )
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
         Form.getMeta().addItem("description", "View Countryy", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup250( ) ;
   }

   public void ws252( )
   {
      start252( ) ;
      evt252( ) ;
   }

   public void evt252( )
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
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 10), "GRID1.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 13), "GRID1.REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 10), "VADD.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 10), "VADD.CLICK") == 0 ) )
                        {
                           nGXsfl_24_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_24_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_24_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_242( ) ;
                           A9AttractionsId = (short)(localUtil.ctol( httpContext.cgiGet( edtAttractionsId_Internalname), ".", ",")) ;
                           A10AttractionsName = httpContext.cgiGet( edtAttractionsName_Internalname) ;
                           A6CountryName = httpContext.cgiGet( edtCountryName_Internalname) ;
                           A11AttractionsPhoto = httpContext.cgiGet( edtAttractionsPhoto_Internalname) ;
                           httpContext.ajax_rsp_assign_prop("", false, edtAttractionsPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A11AttractionsPhoto)==0) ? A40001AttractionsPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A11AttractionsPhoto))), !bGXsfl_24_Refreshing);
                           httpContext.ajax_rsp_assign_prop("", false, edtAttractionsPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A11AttractionsPhoto), true);
                           if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavTrips_Internalname), ".", ",") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavTrips_Internalname), ".", ",") > 9999 ) ) )
                           {
                              httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vTRIPS");
                              GX_FocusControl = edtavTrips_Internalname ;
                              httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                              wbErr = true ;
                              AV7Trips = (short)(0) ;
                              httpContext.ajax_rsp_assign_attri("", false, edtavTrips_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7Trips), 4, 0));
                           }
                           else
                           {
                              AV7Trips = (short)(localUtil.ctol( httpContext.cgiGet( edtavTrips_Internalname), ".", ",")) ;
                              httpContext.ajax_rsp_assign_attri("", false, edtavTrips_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7Trips), 4, 0));
                           }
                           AV9edit = httpContext.cgiGet( edtavEdit_Internalname) ;
                           httpContext.ajax_rsp_assign_prop("", false, edtavEdit_Internalname, "Bitmap", ((GXutil.strcmp("", AV9edit)==0) ? AV14Edit_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV9edit))), !bGXsfl_24_Refreshing);
                           httpContext.ajax_rsp_assign_prop("", false, edtavEdit_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV9edit), true);
                           AV10add = httpContext.cgiGet( edtavAdd_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavAdd_Internalname, AV10add);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e11252 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID1.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e12252 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID1.REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e13252 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "VADD.CLICK") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e14252 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 if ( ! wbErr )
                                 {
                                    Rfr0gs = false ;
                                    /* Set Refresh If Attractionname Changed */
                                    if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vATTRACTIONNAME"), AV5attractionName) != 0 )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    /* Set Refresh If Attractionnameto Changed */
                                    if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vATTRACTIONNAMETO"), AV6attractionNameto) != 0 )
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

   public void we252( )
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

   public void pa252( )
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
            GX_FocusControl = edtavAttractionname_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxnrgrid1_newrow( )
   {
      com.kbbaru.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_242( ) ;
      while ( nGXsfl_24_idx <= nRC_GXsfl_24 )
      {
         sendrow_242( ) ;
         nGXsfl_24_idx = ((subGrid1_Islastpage==1)&&(nGXsfl_24_idx+1>subgrid1_fnc_recordsperpage( )) ? 1 : nGXsfl_24_idx+1) ;
         sGXsfl_24_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_24_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_242( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Grid1Container)) ;
      /* End function gxnrGrid1_newrow */
   }

   public void gxgrgrid1_refresh( String AV5attractionName ,
                                  String AV6attractionNameto ,
                                  short A5CountryId ,
                                  String AV9edit ,
                                  String AV10add ,
                                  short AV11total )
   {
      initialize_formulas( ) ;
      com.kbbaru.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRID1_nCurrentRecord = 0 ;
      rf252( ) ;
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
      rf252( ) ;
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
      httpContext.ajax_rsp_assign_prop("", false, edtavTrips_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTrips_Enabled), 5, 0), !bGXsfl_24_Refreshing);
      edtavAdd_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavAdd_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAdd_Enabled), 5, 0), !bGXsfl_24_Refreshing);
   }

   public void rf252( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         Grid1Container.ClearRows();
      }
      wbStart = (short)(24) ;
      e13252 ();
      nGXsfl_24_idx = 1 ;
      sGXsfl_24_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_24_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_242( ) ;
      bGXsfl_24_Refreshing = true ;
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
         subsflControlProps_242( ) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV5attractionName ,
                                              AV6attractionNameto ,
                                              A10AttractionsName ,
                                              Short.valueOf(A5CountryId) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT
                                              }
         });
         /* Using cursor H00253 */
         pr_default.execute(0, new Object[] {Short.valueOf(A5CountryId), AV5attractionName, AV6attractionNameto});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A11AttractionsPhoto = H00253_A11AttractionsPhoto[0] ;
            httpContext.ajax_rsp_assign_prop("", false, edtAttractionsPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A11AttractionsPhoto)==0) ? A40001AttractionsPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A11AttractionsPhoto))), !bGXsfl_24_Refreshing);
            httpContext.ajax_rsp_assign_prop("", false, edtAttractionsPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A11AttractionsPhoto), true);
            A40001AttractionsPhoto_GXI = H00253_A40001AttractionsPhoto_GXI[0] ;
            httpContext.ajax_rsp_assign_prop("", false, edtAttractionsPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A11AttractionsPhoto)==0) ? A40001AttractionsPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A11AttractionsPhoto))), !bGXsfl_24_Refreshing);
            httpContext.ajax_rsp_assign_prop("", false, edtAttractionsPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A11AttractionsPhoto), true);
            A10AttractionsName = H00253_A10AttractionsName[0] ;
            A9AttractionsId = H00253_A9AttractionsId[0] ;
            A40000GXC1 = H00253_A40000GXC1[0] ;
            n40000GXC1 = H00253_n40000GXC1[0] ;
            A40000GXC1 = H00253_A40000GXC1[0] ;
            n40000GXC1 = H00253_n40000GXC1[0] ;
            e12252 ();
            pr_default.readNext(0);
         }
         pr_default.close(0);
         wbEnd = (short)(24) ;
         wb250( ) ;
      }
      bGXsfl_24_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes252( )
   {
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "gxhash_ATTRACTIONSID"+"_"+sGXsfl_24_idx, getSecureSignedToken( sGXsfl_24_idx, localUtil.format( DecimalUtil.doubleToDec(A9AttractionsId), "ZZZ9")));
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
      httpContext.ajax_rsp_assign_prop("", false, edtavTrips_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTrips_Enabled), 5, 0), !bGXsfl_24_Refreshing);
      edtavAdd_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavAdd_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAdd_Enabled), 5, 0), !bGXsfl_24_Refreshing);
      /* Using cursor H00254 */
      pr_default.execute(1, new Object[] {Short.valueOf(A5CountryId)});
      A6CountryName = H00254_A6CountryName[0] ;
      pr_default.close(1);
      pr_default.close(1);
      fix_multi_value_controls( ) ;
   }

   public void strup250( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e11252 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         nRC_GXsfl_24 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_24"), ".", ",")) ;
         /* Read variables values. */
         A6CountryName = httpContext.cgiGet( edtCountryName_Internalname) ;
         AV5attractionName = httpContext.cgiGet( edtavAttractionname_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5attractionName", AV5attractionName);
         AV6attractionNameto = httpContext.cgiGet( edtavAttractionnameto_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV6attractionNameto", AV6attractionNameto);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavTotal_Internalname), ".", ",") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavTotal_Internalname), ".", ",") > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vTOTAL");
            GX_FocusControl = edtavTotal_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV11total = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11total", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11total), 4, 0));
         }
         else
         {
            AV11total = (short)(localUtil.ctol( httpContext.cgiGet( edtavTotal_Internalname), ".", ",")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11total", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11total), 4, 0));
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
      e11252 ();
      if (returnInSub) return;
   }

   public void e11252( )
   {
      /* Start Routine */
      returnInSub = false ;
      edtavEdit_gximage = "GeneXusUnanimo_edit" ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEdit_Internalname, "gximage", edtavEdit_gximage, !bGXsfl_24_Refreshing);
      AV9edit = context.getHttpContext().getImagePath( "0262a982-cd0b-446a-a8f5-d714e80dd0f0", "", context.getHttpContext().getTheme( )) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEdit_Internalname, "Bitmap", ((GXutil.strcmp("", AV9edit)==0) ? AV14Edit_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV9edit))), !bGXsfl_24_Refreshing);
      httpContext.ajax_rsp_assign_prop("", false, edtavEdit_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV9edit), true);
      AV14Edit_GXI = GXDbFile.pathToUrl( context.getHttpContext().getImagePath( "0262a982-cd0b-446a-a8f5-d714e80dd0f0", "", context.getHttpContext().getTheme( )), context.getHttpContext()) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEdit_Internalname, "Bitmap", ((GXutil.strcmp("", AV9edit)==0) ? AV14Edit_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV9edit))), !bGXsfl_24_Refreshing);
      httpContext.ajax_rsp_assign_prop("", false, edtavEdit_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV9edit), true);
      AV10add = "Add Trips" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavAdd_Internalname, AV10add);
   }

   private void e12252( )
   {
      /* Grid1_Load Routine */
      returnInSub = false ;
      AV7Trips = (short)(A40000GXC1) ;
      httpContext.ajax_rsp_assign_attri("", false, edtavTrips_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7Trips), 4, 0));
      AV11total = (short)(AV11total+AV7Trips) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11total", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11total), 4, 0));
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(24) ;
      }
      sendrow_242( ) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_24_Refreshing )
      {
         httpContext.doAjaxLoad(24, Grid1Row);
      }
      /*  Sending Event outputs  */
   }

   public void e13252( )
   {
      /* Grid1_Refresh Routine */
      returnInSub = false ;
      AV11total = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11total", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11total), 4, 0));
      /*  Sending Event outputs  */
   }

   public void e14252( )
   {
      /* Add_Click Routine */
      returnInSub = false ;
      GXt_int1 = AV7Trips ;
      GXv_int2[0] = GXt_int1 ;
      new com.kbbaru.newtrip(remoteHandle, context).execute( A9AttractionsId, GXv_int2) ;
      viewcountryy_impl.this.GXt_int1 = GXv_int2[0] ;
      AV7Trips = (short)(GXt_int1) ;
      httpContext.ajax_rsp_assign_attri("", false, edtavTrips_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7Trips), 4, 0));
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A5CountryId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "A5CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A5CountryId), 4, 0));
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
      pa252( ) ;
      ws252( ) ;
      we252( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20235231553083", true, true);
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
      httpContext.AddJavascriptSource("viewcountryy.js", "?20235231553083", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_242( )
   {
      edtAttractionsId_Internalname = "ATTRACTIONSID_"+sGXsfl_24_idx ;
      edtAttractionsName_Internalname = "ATTRACTIONSNAME_"+sGXsfl_24_idx ;
      edtCountryName_Internalname = "COUNTRYNAME_"+sGXsfl_24_idx ;
      edtAttractionsPhoto_Internalname = "ATTRACTIONSPHOTO_"+sGXsfl_24_idx ;
      edtavTrips_Internalname = "vTRIPS_"+sGXsfl_24_idx ;
      edtavEdit_Internalname = "vEDIT_"+sGXsfl_24_idx ;
      edtavAdd_Internalname = "vADD_"+sGXsfl_24_idx ;
   }

   public void subsflControlProps_fel_242( )
   {
      edtAttractionsId_Internalname = "ATTRACTIONSID_"+sGXsfl_24_fel_idx ;
      edtAttractionsName_Internalname = "ATTRACTIONSNAME_"+sGXsfl_24_fel_idx ;
      edtCountryName_Internalname = "COUNTRYNAME_"+sGXsfl_24_fel_idx ;
      edtAttractionsPhoto_Internalname = "ATTRACTIONSPHOTO_"+sGXsfl_24_fel_idx ;
      edtavTrips_Internalname = "vTRIPS_"+sGXsfl_24_fel_idx ;
      edtavEdit_Internalname = "vEDIT_"+sGXsfl_24_fel_idx ;
      edtavAdd_Internalname = "vADD_"+sGXsfl_24_fel_idx ;
   }

   public void sendrow_242( )
   {
      subsflControlProps_242( ) ;
      wb250( ) ;
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
         if ( ((int)((nGXsfl_24_idx) % (2))) == 0 )
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
         httpContext.writeText( " gxrow=\""+sGXsfl_24_idx+"\">") ;
      }
      /* Subfile cell */
      if ( Grid1Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
      }
      /* Single line edit */
      ROClassString = "Attribute" ;
      Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtAttractionsId_Internalname,GXutil.ltrim( localUtil.ntoc( A9AttractionsId, (byte)(4), (byte)(0), ".", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A9AttractionsId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtAttractionsId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      if ( Grid1Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
      }
      /* Single line edit */
      ROClassString = "Attribute" ;
      Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtAttractionsName_Internalname,A10AttractionsName,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtAttractionsName_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"Name","left",Boolean.valueOf(true),""});
      /* Subfile cell */
      if ( Grid1Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
      }
      /* Single line edit */
      ROClassString = "Attribute" ;
      Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCountryName_Internalname,A6CountryName,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCountryName_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtCountryName_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"Name","left",Boolean.valueOf(true),""});
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
      TempTags = " " + ((edtavTrips_Enabled!=0)&&(edtavTrips_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 29,'',false,'"+sGXsfl_24_idx+"',24)\"" : " ") ;
      ROClassString = "Attribute" ;
      Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavTrips_Internalname,GXutil.ltrim( localUtil.ntoc( AV7Trips, (byte)(4), (byte)(0), ".", "")),GXutil.ltrim( ((edtavTrips_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV7Trips), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV7Trips), "ZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,',');"+";gx.evt.onchange(this, event)\" "+((edtavTrips_Enabled!=0)&&(edtavTrips_Visible!=0) ? " onblur=\""+"gx.num.valid_integer( this,',');"+";gx.evt.onblur(this,29);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavTrips_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtavTrips_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      if ( Grid1Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+""+"\">") ;
      }
      /* Active Bitmap Variable */
      TempTags = " " + ((edtavEdit_Enabled!=0)&&(edtavEdit_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 30,'',false,'',24)\"" : " ") ;
      ClassString = "Image" + " " + ((GXutil.strcmp(edtavEdit_gximage, "")==0) ? "" : "GX_Image_"+edtavEdit_gximage+"_Class") ;
      StyleString = "" ;
      AV9edit_IsBlob = (boolean)(((GXutil.strcmp("", AV9edit)==0)&&(GXutil.strcmp("", AV14Edit_GXI)==0))||!(GXutil.strcmp("", AV9edit)==0)) ;
      sImgUrl = ((GXutil.strcmp("", AV9edit)==0) ? AV14Edit_GXI : httpContext.getResourceRelative(AV9edit)) ;
      Grid1Row.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavEdit_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(-1),Integer.valueOf(1),"","",Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"px",Integer.valueOf(0),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(7),edtavEdit_Jsonclick,"'"+""+"'"+",false,"+"'"+"e15252_client"+"'",StyleString,ClassString,"","","","",""+TempTags,"","",Integer.valueOf(1),Boolean.valueOf(AV9edit_IsBlob),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
      /* Subfile cell */
      if ( Grid1Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
      }
      /* Single line edit */
      TempTags = " " + ((edtavAdd_Enabled!=0)&&(edtavAdd_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 31,'',false,'"+sGXsfl_24_idx+"',24)\"" : " ") ;
      ROClassString = "Attribute" ;
      Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavAdd_Internalname,GXutil.rtrim( AV10add),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavAdd_Enabled!=0)&&(edtavAdd_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,31);\"" : " "),"'"+""+"'"+",false,"+"'"+"EVADD.CLICK."+sGXsfl_24_idx+"'","","","","",edtavAdd_Jsonclick,Integer.valueOf(5),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtavAdd_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      send_integrity_lvl_hashes252( ) ;
      Grid1Container.AddRow(Grid1Row);
      nGXsfl_24_idx = ((subGrid1_Islastpage==1)&&(nGXsfl_24_idx+1>subgrid1_fnc_recordsperpage( )) ? 1 : nGXsfl_24_idx+1) ;
      sGXsfl_24_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_24_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_242( ) ;
      /* End function sendrow_242 */
   }

   public void startgridcontrol24( )
   {
      if ( Grid1Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"Grid1Container"+"DivS\" data-gxgridid=\"24\">") ;
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
         httpContext.writeValue( "Attractions Id") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "Attractions Name") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "Country Name") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"ImageAttribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "Attractions Photo") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "Trips") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Image"+" "+((GXutil.strcmp(edtavEdit_gximage, "")==0) ? "" : "GX_Image_"+edtavEdit_gximage+"_Class")+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "add") ;
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
         Grid1Column.AddObjectProperty("Value", WebUtils.htmlEncode( A6CountryName));
         Grid1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtCountryName_Enabled, (byte)(5), (byte)(0), ".", "")));
         Grid1Container.AddColumnProperties(Grid1Column);
         Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid1Column.AddObjectProperty("Value", httpContext.convertURL( A11AttractionsPhoto));
         Grid1Container.AddColumnProperties(Grid1Column);
         Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid1Column.AddObjectProperty("Value", WebUtils.htmlEncode( GXutil.ltrim( localUtil.ntoc( AV7Trips, (byte)(4), (byte)(0), ".", ""))));
         Grid1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavTrips_Enabled, (byte)(5), (byte)(0), ".", "")));
         Grid1Container.AddColumnProperties(Grid1Column);
         Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid1Column.AddObjectProperty("Value", httpContext.convertURL( AV9edit));
         Grid1Container.AddColumnProperties(Grid1Column);
         Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid1Column.AddObjectProperty("Value", WebUtils.htmlEncode( GXutil.rtrim( AV10add)));
         Grid1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavAdd_Enabled, (byte)(5), (byte)(0), ".", "")));
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
      edtCountryName_Internalname = "COUNTRYNAME" ;
      edtavAttractionname_Internalname = "vATTRACTIONNAME" ;
      edtavAttractionnameto_Internalname = "vATTRACTIONNAMETO" ;
      edtAttractionsId_Internalname = "ATTRACTIONSID" ;
      edtAttractionsName_Internalname = "ATTRACTIONSNAME" ;
      edtCountryName_Internalname = "COUNTRYNAME" ;
      edtAttractionsPhoto_Internalname = "ATTRACTIONSPHOTO" ;
      edtavTrips_Internalname = "vTRIPS" ;
      edtavEdit_Internalname = "vEDIT" ;
      edtavAdd_Internalname = "vADD" ;
      edtavTotal_Internalname = "vTOTAL" ;
      divTable1_Internalname = "TABLE1" ;
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
      edtavAdd_Jsonclick = "" ;
      edtavAdd_Visible = -1 ;
      edtavAdd_Enabled = 1 ;
      edtavEdit_Jsonclick = "" ;
      edtavEdit_Visible = -1 ;
      edtavEdit_Enabled = 1 ;
      edtavTrips_Jsonclick = "" ;
      edtavTrips_Visible = -1 ;
      edtavTrips_Enabled = 1 ;
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
      edtCountryName_Jsonclick = "" ;
      edtCountryName_Enabled = 0 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "View Countryy" );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'AV5attractionName',fld:'vATTRACTIONNAME',pic:''},{av:'AV6attractionNameto',fld:'vATTRACTIONNAMETO',pic:''},{av:'A5CountryId',fld:'COUNTRYID',pic:'ZZZ9'},{av:'AV9edit',fld:'vEDIT',pic:''},{av:'AV10add',fld:'vADD',pic:''},{av:'AV11total',fld:'vTOTAL',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("VEDIT.CLICK","{handler:'e15252',iparms:[{av:'A9AttractionsId',fld:'ATTRACTIONSID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("VEDIT.CLICK",",oparms:[]}");
      setEventMetadata("GRID1.LOAD","{handler:'e12252',iparms:[{av:'AV11total',fld:'vTOTAL',pic:'ZZZ9'}]");
      setEventMetadata("GRID1.LOAD",",oparms:[{av:'AV7Trips',fld:'vTRIPS',pic:'ZZZ9'},{av:'A40000GXC1',fld:'GXC1',pic:'999999999'},{av:'AV11total',fld:'vTOTAL',pic:'ZZZ9'}]}");
      setEventMetadata("GRID1.REFRESH","{handler:'e13252',iparms:[]");
      setEventMetadata("GRID1.REFRESH",",oparms:[{av:'AV11total',fld:'vTOTAL',pic:'ZZZ9'}]}");
      setEventMetadata("VADD.CLICK","{handler:'e14252',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'AV5attractionName',fld:'vATTRACTIONNAME',pic:''},{av:'AV6attractionNameto',fld:'vATTRACTIONNAMETO',pic:''},{av:'A5CountryId',fld:'COUNTRYID',pic:'ZZZ9'},{av:'AV9edit',fld:'vEDIT',pic:''},{av:'AV10add',fld:'vADD',pic:''},{av:'AV11total',fld:'vTOTAL',pic:'ZZZ9'},{av:'A9AttractionsId',fld:'ATTRACTIONSID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("VADD.CLICK",",oparms:[{av:'AV7Trips',fld:'vTRIPS',pic:'ZZZ9'}]}");
      setEventMetadata("VALID_ATTRACTIONSID","{handler:'valid_Attractionsid',iparms:[]");
      setEventMetadata("VALID_ATTRACTIONSID",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Add',iparms:[]");
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
      AV9edit = "" ;
      AV10add = "" ;
      AV5attractionName = "" ;
      AV6attractionNameto = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ROClassString = "" ;
      A6CountryName = "" ;
      TempTags = "" ;
      Grid1Container = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      A10AttractionsName = "" ;
      A11AttractionsPhoto = "" ;
      A40001AttractionsPhoto_GXI = "" ;
      AV14Edit_GXI = "" ;
      scmdbuf = "" ;
      H00253_A5CountryId = new short[1] ;
      H00253_A11AttractionsPhoto = new String[] {""} ;
      H00253_A40001AttractionsPhoto_GXI = new String[] {""} ;
      H00253_A6CountryName = new String[] {""} ;
      H00253_A10AttractionsName = new String[] {""} ;
      H00253_A9AttractionsId = new short[1] ;
      H00253_A40000GXC1 = new int[1] ;
      H00253_n40000GXC1 = new boolean[] {false} ;
      H00254_A6CountryName = new String[] {""} ;
      Grid1Row = new com.genexus.webpanels.GXWebRow();
      GXv_int2 = new long[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGrid1_Linesclass = "" ;
      ClassString = "" ;
      StyleString = "" ;
      sImgUrl = "" ;
      Grid1Column = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.kbbaru.viewcountryy__default(),
         new Object[] {
             new Object[] {
            H00253_A5CountryId, H00253_A11AttractionsPhoto, H00253_A40001AttractionsPhoto_GXI, H00253_A6CountryName, H00253_A10AttractionsName, H00253_A9AttractionsId, H00253_A40000GXC1, H00253_n40000GXC1
            }
            , new Object[] {
            H00254_A6CountryName
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavTrips_Enabled = 0 ;
      edtavAdd_Enabled = 0 ;
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
   private short wcpOA5CountryId ;
   private short A5CountryId ;
   private short AV11total ;
   private short wbEnd ;
   private short wbStart ;
   private short A9AttractionsId ;
   private short AV7Trips ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int nRC_GXsfl_24 ;
   private int nGXsfl_24_idx=1 ;
   private int edtCountryName_Enabled ;
   private int edtavAttractionname_Enabled ;
   private int edtavAttractionnameto_Enabled ;
   private int edtavTotal_Enabled ;
   private int subGrid1_Islastpage ;
   private int edtavTrips_Enabled ;
   private int edtavAdd_Enabled ;
   private int A40000GXC1 ;
   private int idxLst ;
   private int subGrid1_Backcolor ;
   private int subGrid1_Allbackcolor ;
   private int edtavTrips_Visible ;
   private int edtavEdit_Enabled ;
   private int edtavEdit_Visible ;
   private int edtavAdd_Visible ;
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
   private String sGXsfl_24_idx="0001" ;
   private String AV10add ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divMaintable_Internalname ;
   private String edtCountryName_Internalname ;
   private String ROClassString ;
   private String edtCountryName_Jsonclick ;
   private String divTable1_Internalname ;
   private String edtavAttractionname_Internalname ;
   private String TempTags ;
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
   private String edtAttractionsPhoto_Internalname ;
   private String edtavTrips_Internalname ;
   private String edtavEdit_Internalname ;
   private String edtavAdd_Internalname ;
   private String scmdbuf ;
   private String edtavEdit_gximage ;
   private String sGXsfl_24_fel_idx="0001" ;
   private String subGrid1_Class ;
   private String subGrid1_Linesclass ;
   private String edtAttractionsId_Jsonclick ;
   private String edtAttractionsName_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String sImgUrl ;
   private String edtavTrips_Jsonclick ;
   private String edtavEdit_Jsonclick ;
   private String edtavAdd_Jsonclick ;
   private String subGrid1_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_24_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n40000GXC1 ;
   private boolean returnInSub ;
   private boolean A11AttractionsPhoto_IsBlob ;
   private boolean AV9edit_IsBlob ;
   private String AV5attractionName ;
   private String AV6attractionNameto ;
   private String A6CountryName ;
   private String A10AttractionsName ;
   private String A40001AttractionsPhoto_GXI ;
   private String AV14Edit_GXI ;
   private String AV9edit ;
   private String A11AttractionsPhoto ;
   private com.genexus.webpanels.GXWebGrid Grid1Container ;
   private com.genexus.webpanels.GXWebRow Grid1Row ;
   private com.genexus.webpanels.GXWebColumn Grid1Column ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private IDataStoreProvider pr_default ;
   private short[] H00253_A5CountryId ;
   private String[] H00253_A11AttractionsPhoto ;
   private String[] H00253_A40001AttractionsPhoto_GXI ;
   private String[] H00253_A6CountryName ;
   private String[] H00253_A10AttractionsName ;
   private short[] H00253_A9AttractionsId ;
   private int[] H00253_A40000GXC1 ;
   private boolean[] H00253_n40000GXC1 ;
   private String[] H00254_A6CountryName ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class viewcountryy__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00253( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV5attractionName ,
                                          String AV6attractionNameto ,
                                          String A10AttractionsName ,
                                          short A5CountryId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int3 = new byte[3];
      Object[] GXv_Object4 = new Object[2];
      scmdbuf = "SELECT T1.CountryId, T1.AttractionsPhoto, T1.AttractionsPhoto_GXI, T3.CountryName, T1.AttractionsName, T1.AttractionsId, COALESCE( T2.GXC1, 0) AS GXC1 FROM ((Attractions" ;
      scmdbuf += " T1 LEFT JOIN LATERAL (SELECT COUNT(*) AS GXC1, T4.AttractionsId FROM (TripsAttrations T4 INNER JOIN Trips T5 ON T5.TripsId = T4.TripsId) WHERE T1.AttractionsId" ;
      scmdbuf += " = T4.AttractionsId GROUP BY T4.AttractionsId ) T2 ON T2.AttractionsId = T1.AttractionsId) INNER JOIN Country T3 ON T3.CountryId = T1.CountryId)" ;
      addWhere(sWhereString, "(T1.CountryId = ?)");
      if ( ! (GXutil.strcmp("", AV5attractionName)==0) )
      {
         addWhere(sWhereString, "(T1.AttractionsName >= ( ?))");
      }
      else
      {
         GXv_int3[1] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV6attractionNameto)==0) )
      {
         addWhere(sWhereString, "(T1.AttractionsName <= ( ?))");
      }
      else
      {
         GXv_int3[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CountryId, T1.AttractionsName" ;
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
            case 0 :
                  return conditional_H00253(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00253", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00254", "SELECT CountryName FROM Country WHERE CountryId = ? ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getMultimediaFile(2, rslt.getVarchar(3));
               ((String[]) buf[2])[0] = rslt.getMultimediaUri(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
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
            case 0 :
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
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

