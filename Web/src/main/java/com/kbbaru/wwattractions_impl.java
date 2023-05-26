package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwattractions_impl extends GXDataArea
{
   public wwattractions_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwattractions_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwattractions_impl.class ));
   }

   public wwattractions_impl( int remoteHandle ,
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Grid") == 0 )
         {
            gxnrgrid_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Grid") == 0 )
         {
            gxgrgrid_refresh_invoke( ) ;
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

   public void gxnrgrid_newrow_invoke( )
   {
      nRC_GXsfl_30 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_30"))) ;
      nGXsfl_30_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_30_idx"))) ;
      sGXsfl_30_idx = httpContext.GetPar( "sGXsfl_30_idx") ;
      AV12Update = httpContext.GetPar( "Update") ;
      AV13Delete = httpContext.GetPar( "Delete") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgrid_newrow( ) ;
      /* End function gxnrGrid_newrow_invoke */
   }

   public void gxgrgrid_refresh_invoke( )
   {
      subGrid_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGrid_Rows"))) ;
      AV11AttractionsName = httpContext.GetPar( "AttractionsName") ;
      AV12Update = httpContext.GetPar( "Update") ;
      AV13Delete = httpContext.GetPar( "Delete") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV11AttractionsName, AV12Update, AV13Delete) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrid_refresh_invoke */
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
      pa1L2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start1L2( ) ;
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
      FormProcess = ((nGXWrapped==0) ? " data-HasEnter=\"false\" data-Skiponenter=\"false\"" : "") ;
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
      if ( nGXWrapped != 1 )
      {
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.kbbaru.wwattractions", new String[] {}, new String[] {}) +"\">") ;
         com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
         com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
         com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
         httpContext.writeText( "<div style=\"height:0;overflow:hidden\"><input type=\"submit\" title=\"submit\"  disabled></div>") ;
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
      }
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
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "GXH_vATTRACTIONSNAME", AV11AttractionsName);
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_30", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_30, (byte)(8), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
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
      if ( nGXWrapped != 1 )
      {
         httpContext.writeTextNL( "</form>") ;
      }
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
         we1L2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt1L2( ) ;
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
      return formatLink("com.kbbaru.wwattractions", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "WWAttractions" ;
   }

   public String getPgmdesc( )
   {
      return "Work With Attractions" ;
   }

   public void wb1L0( )
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
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"none\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, divMaintable_Internalname, 1, 0, "px", 0, "px", "body-container", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, divGridcell_Internalname, 1, 0, "px", 0, "px", "col-xs-12 ww__grid-cell", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, divGridtable_Internalname, 1, 0, "px", 0, "px", "container-fluid container-advanced", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, divTabletop_Internalname, 1, 0, "px", 0, "px", "Flex ww__actions-container", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "ww__title-cell", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         com.kbbaru.GxWebStd.gx_label_ctrl( httpContext, lblTitletext_Internalname, "Attractions", "", "", lblTitletext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "heading-01", 0, "", 1, 1, 0, (short)(0), "HLP_WWAttractions.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "ww__actions-cell", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroup", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 15,'',false,'',0)\"" ;
         ClassString = "Button button-primary" ;
         StyleString = "" ;
         com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttBtninsert_Internalname, "gx.evt.setGridEvt("+GXutil.str( 30, 2, 0)+","+"null"+");", "Insert", bttBtninsert_Jsonclick, 5, "Insert", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOINSERT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWAttractions.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "ww__filter-cell", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.kbbaru.GxWebStd.gx_label_element( httpContext, edtavAttractionsname_Internalname, "Attractions Name", "gx-form-item attribute-searchLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 18,'',false,'" + sGXsfl_30_idx + "',0)\"" ;
         com.kbbaru.GxWebStd.gx_single_line_edit( httpContext, edtavAttractionsname_Internalname, AV11AttractionsName, GXutil.rtrim( localUtil.format( AV11AttractionsName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,18);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "Name", edtavAttractionsname_Jsonclick, 0, "attribute-search", "", "", "", "", 1, edtavAttractionsname_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWAttractions.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         com.kbbaru.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, divGridcontainer_Internalname, 1, 0, "px", 0, "px", "ww__grid-container", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttExport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 30, 2, 0)+","+"null"+");", "export", bttExport_Jsonclick, 5, "export", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'EXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWAttractions.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridContainer.SetWrapped(nGXWrapped);
         startgridcontrol30( ) ;
      }
      if ( wbEnd == 30 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_30 = (int)(nGXsfl_30_idx-1) ;
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            GridContainer.AddObjectProperty("GRID_nEOF", GRID_nEOF);
            GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"GridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Grid", GridContainer, subGrid_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "GridContainerData", GridContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "GridContainerData"+"V", GridContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridContainerData"+"V"+"\" value='"+GridContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
      if ( wbEnd == 30 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               GridContainer.AddObjectProperty("GRID_nEOF", GRID_nEOF);
               GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"GridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Grid", GridContainer, subGrid_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "GridContainerData", GridContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "GridContainerData"+"V", GridContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridContainerData"+"V"+"\" value='"+GridContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start1L2( )
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
         Form.getMeta().addItem("description", "Work With Attractions", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup1L0( ) ;
   }

   public void ws1L2( )
   {
      start1L2( ) ;
      evt1L2( ) ;
   }

   public void evt1L2( )
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
                        else if ( GXutil.strcmp(sEvt, "'DOINSERT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoInsert' */
                           e111L2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'EXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'Export' */
                           e121L2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGING") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           sEvt = httpContext.cgiGet( "GRIDPAGING") ;
                           if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                           {
                              subgrid_firstpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "PREV") == 0 )
                           {
                              subgrid_previouspage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                           {
                              subgrid_nextpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                           {
                              subgrid_lastpage( ) ;
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           nGXsfl_30_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_30_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_30_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_302( ) ;
                           A9AttractionsId = (short)(localUtil.ctol( httpContext.cgiGet( edtAttractionsId_Internalname), ".", ",")) ;
                           A10AttractionsName = httpContext.cgiGet( edtAttractionsName_Internalname) ;
                           A5CountryId = (short)(localUtil.ctol( httpContext.cgiGet( edtCountryId_Internalname), ".", ",")) ;
                           A6CountryName = httpContext.cgiGet( edtCountryName_Internalname) ;
                           A12CountryCityId = (short)(localUtil.ctol( httpContext.cgiGet( edtCountryCityId_Internalname), ".", ",")) ;
                           A16CountryCityName = httpContext.cgiGet( edtCountryCityName_Internalname) ;
                           A3CategoryId = (short)(localUtil.ctol( httpContext.cgiGet( edtCategoryId_Internalname), ".", ",")) ;
                           A4CategoryName = httpContext.cgiGet( edtCategoryName_Internalname) ;
                           A11AttractionsPhoto = httpContext.cgiGet( edtAttractionsPhoto_Internalname) ;
                           httpContext.ajax_rsp_assign_prop("", false, edtAttractionsPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A11AttractionsPhoto)==0) ? A40001AttractionsPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A11AttractionsPhoto))), !bGXsfl_30_Refreshing);
                           httpContext.ajax_rsp_assign_prop("", false, edtAttractionsPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A11AttractionsPhoto), true);
                           AV15Trips = localUtil.ctol( httpContext.cgiGet( edtavTrips_Internalname), ".", ",") ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavTrips_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15Trips), 10, 0));
                           AV12Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV12Update);
                           AV13Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV13Delete);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e131L2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e141L2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e151L2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 if ( ! wbErr )
                                 {
                                    Rfr0gs = false ;
                                    /* Set Refresh If Attractionsname Changed */
                                    if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vATTRACTIONSNAME"), AV11AttractionsName) != 0 )
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

   public void we1L2( )
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

   public void pa1L2( )
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
            GX_FocusControl = edtavAttractionsname_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxnrgrid_newrow( )
   {
      com.kbbaru.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_302( ) ;
      while ( nGXsfl_30_idx <= nRC_GXsfl_30 )
      {
         sendrow_302( ) ;
         nGXsfl_30_idx = ((subGrid_Islastpage==1)&&(nGXsfl_30_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_30_idx+1) ;
         sGXsfl_30_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_30_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_302( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 String AV11AttractionsName ,
                                 String AV12Update ,
                                 String AV13Delete )
   {
      initialize_formulas( ) ;
      com.kbbaru.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRID_nCurrentRecord = 0 ;
      rf1L2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
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
      rf1L2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV19Pgmname = "WWAttractions" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_30_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_30_Refreshing);
   }

   public void rf1L2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(30) ;
      /* Execute user event: Refresh */
      e141L2 ();
      nGXsfl_30_idx = 1 ;
      sGXsfl_30_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_30_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_302( ) ;
      bGXsfl_30_Refreshing = true ;
      GridContainer.AddObjectProperty("GridName", "Grid");
      GridContainer.AddObjectProperty("CmpContext", "");
      GridContainer.AddObjectProperty("InMasterPage", "false");
      GridContainer.AddObjectProperty("Class", "ww__grid");
      GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridContainer.setPageSize( subgrid_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_302( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV11AttractionsName ,
                                              A10AttractionsName } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV11AttractionsName = GXutil.concat( GXutil.rtrim( AV11AttractionsName), "%", "") ;
         /* Using cursor H001L3 */
         pr_default.execute(0, new Object[] {lV11AttractionsName, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_30_idx = 1 ;
         sGXsfl_30_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_30_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_302( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A11AttractionsPhoto = H001L3_A11AttractionsPhoto[0] ;
            httpContext.ajax_rsp_assign_prop("", false, edtAttractionsPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A11AttractionsPhoto)==0) ? A40001AttractionsPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A11AttractionsPhoto))), !bGXsfl_30_Refreshing);
            httpContext.ajax_rsp_assign_prop("", false, edtAttractionsPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A11AttractionsPhoto), true);
            A40001AttractionsPhoto_GXI = H001L3_A40001AttractionsPhoto_GXI[0] ;
            httpContext.ajax_rsp_assign_prop("", false, edtAttractionsPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A11AttractionsPhoto)==0) ? A40001AttractionsPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A11AttractionsPhoto))), !bGXsfl_30_Refreshing);
            httpContext.ajax_rsp_assign_prop("", false, edtAttractionsPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A11AttractionsPhoto), true);
            A4CategoryName = H001L3_A4CategoryName[0] ;
            A3CategoryId = H001L3_A3CategoryId[0] ;
            A16CountryCityName = H001L3_A16CountryCityName[0] ;
            A12CountryCityId = H001L3_A12CountryCityId[0] ;
            A6CountryName = H001L3_A6CountryName[0] ;
            A5CountryId = H001L3_A5CountryId[0] ;
            A10AttractionsName = H001L3_A10AttractionsName[0] ;
            A9AttractionsId = H001L3_A9AttractionsId[0] ;
            A40000GXC1 = H001L3_A40000GXC1[0] ;
            n40000GXC1 = H001L3_n40000GXC1[0] ;
            A4CategoryName = H001L3_A4CategoryName[0] ;
            A6CountryName = H001L3_A6CountryName[0] ;
            A16CountryCityName = H001L3_A16CountryCityName[0] ;
            A40000GXC1 = H001L3_A40000GXC1[0] ;
            n40000GXC1 = H001L3_n40000GXC1[0] ;
            e151L2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(30) ;
         wb1L0( ) ;
      }
      bGXsfl_30_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes1L2( )
   {
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "gxhash_ATTRACTIONSID"+"_"+sGXsfl_30_idx, getSecureSignedToken( sGXsfl_30_idx, localUtil.format( DecimalUtil.doubleToDec(A9AttractionsId), "ZZZ9")));
   }

   public int subgrid_fnc_pagecount( )
   {
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( ((int)((GRID_nRecordCount) % (subgrid_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( DecimalUtil.decToDouble(DecimalUtil.doubleToDec(GRID_nRecordCount).divide(DecimalUtil.doubleToDec(subgrid_fnc_recordsperpage( )), java.math.MathContext.DECIMAL128)))) ;
      }
      return (int)(GXutil.Int( DecimalUtil.decToDouble(DecimalUtil.doubleToDec(GRID_nRecordCount).divide(DecimalUtil.doubleToDec(subgrid_fnc_recordsperpage( )), java.math.MathContext.DECIMAL128)))+1) ;
   }

   public int subgrid_fnc_recordcount( )
   {
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           AV11AttractionsName ,
                                           A10AttractionsName } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV11AttractionsName = GXutil.concat( GXutil.rtrim( AV11AttractionsName), "%", "") ;
      /* Using cursor H001L5 */
      pr_default.execute(1, new Object[] {lV11AttractionsName});
      GRID_nRecordCount = H001L5_AGRID_nRecordCount[0] ;
      pr_default.close(1);
      return (int)(GRID_nRecordCount) ;
   }

   public int subgrid_fnc_recordsperpage( )
   {
      if ( subGrid_Rows > 0 )
      {
         return subGrid_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgrid_fnc_currentpage( )
   {
      return (int)(GXutil.Int( DecimalUtil.decToDouble(DecimalUtil.doubleToDec(GRID_nFirstRecordOnPage).divide(DecimalUtil.doubleToDec(subgrid_fnc_recordsperpage( )), java.math.MathContext.DECIMAL128)))+1) ;
   }

   public short subgrid_firstpage( )
   {
      GRID_nFirstRecordOnPage = 0 ;
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV11AttractionsName, AV12Update, AV13Delete) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( ( GRID_nRecordCount >= subgrid_fnc_recordsperpage( ) ) && ( GRID_nEOF == 0 ) )
      {
         GRID_nFirstRecordOnPage = (long)(GRID_nFirstRecordOnPage+subgrid_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV11AttractionsName, AV12Update, AV13Delete) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      if ( GRID_nFirstRecordOnPage >= subgrid_fnc_recordsperpage( ) )
      {
         GRID_nFirstRecordOnPage = (long)(GRID_nFirstRecordOnPage-subgrid_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV11AttractionsName, AV12Update, AV13Delete) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( GRID_nRecordCount > subgrid_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRID_nRecordCount) % (subgrid_fnc_recordsperpage( )))) == 0 )
         {
            GRID_nFirstRecordOnPage = (long)(GRID_nRecordCount-subgrid_fnc_recordsperpage( )) ;
         }
         else
         {
            GRID_nFirstRecordOnPage = (long)(GRID_nRecordCount-((int)((GRID_nRecordCount) % (subgrid_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRID_nFirstRecordOnPage = 0 ;
      }
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV11AttractionsName, AV12Update, AV13Delete) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRID_nFirstRecordOnPage = (long)(subgrid_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRID_nFirstRecordOnPage = 0 ;
      }
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV11AttractionsName, AV12Update, AV13Delete) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void subgrid_varsfromstate( )
   {
      if ( GridState.getFiltercount() >= 1 )
      {
         AV11AttractionsName = GridState.filterValues("Attractionsname") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11AttractionsName", AV11AttractionsName);
      }
      if ( GridState.getCurrentpage() > 0 )
      {
         GridPageCount = subgrid_fnc_pagecount( ) ;
         if ( ( GridPageCount > 0 ) && ( GridPageCount < GridState.getCurrentpage() ) )
         {
            subgrid_gotopage( GridPageCount) ;
         }
         else
         {
            subgrid_gotopage( ((GridPageCount<0) ? 0 : GridState.getCurrentpage())) ;
         }
      }
   }

   public void subgrid_varstostate( )
   {
      GridState.setCurrentpage( subgrid_fnc_currentpage( ) );
      GridState.clearFilterValues();
      GridState.addFilterValue("AttractionsName", AV11AttractionsName);
   }

   public void before_start_formulas( )
   {
      AV19Pgmname = "WWAttractions" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_30_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_30_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup1L0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e131L2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         nRC_GXsfl_30 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_30"), ".", ",")) ;
         GRID_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRID_nFirstRecordOnPage"), ".", ",") ;
         GRID_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRID_nEOF"), ".", ",")) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), ".", ",")) ;
         com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         /* Read variables values. */
         AV11AttractionsName = httpContext.cgiGet( edtavAttractionsname_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11AttractionsName", AV11AttractionsName);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         /* Check if conditions changed and reset current page numbers */
         if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vATTRACTIONSNAME"), AV11AttractionsName) != 0 )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e131L2 ();
      if (returnInSub) return;
   }

   public void e131L2( )
   {
      /* Start Routine */
      returnInSub = false ;
      if ( ! new com.kbbaru.general.security.isauthorized(remoteHandle, context).executeUdp( AV19Pgmname) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         callWebObject(formatLink("com.kbbaru.general.security.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV19Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      subGrid_Rows = 10 ;
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      AV12Update = "Update" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV12Update);
      AV13Delete = "Delete" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV13Delete);
      Form.setCaption( "Attractions" );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S112 ();
      if (returnInSub) return;
      GridState.loadGridState();
   }

   public void e141L2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GridState.saveGridState();
   }

   private void e151L2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      edtavUpdate_Link = formatLink("com.kbbaru.attractions", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A9AttractionsId,4,0))}, new String[] {"Mode","AttractionsId"})  ;
      edtavDelete_Link = formatLink("com.kbbaru.attractions", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.ltrimstr(A9AttractionsId,4,0))}, new String[] {"Mode","AttractionsId"})  ;
      edtAttractionsName_Link = formatLink("com.kbbaru.viewattractions", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A9AttractionsId,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"AttractionsId","TabCode"})  ;
      edtCountryName_Link = formatLink("com.kbbaru.viewcountry", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A5CountryId,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"CountryId","TabCode"})  ;
      edtCategoryName_Link = formatLink("com.kbbaru.viewcategory", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CategoryId,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"CategoryId","TabCode"})  ;
      AV15Trips = (long)((A40000GXC1)) ;
      httpContext.ajax_rsp_assign_attri("", false, edtavTrips_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15Trips), 10, 0));
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(30) ;
      }
      sendrow_302( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_30_Refreshing )
      {
         httpContext.doAjaxLoad(30, GridRow);
      }
      /*  Sending Event outputs  */
   }

   public void e111L2( )
   {
      /* 'DoInsert' Routine */
      returnInSub = false ;
      callWebObject(formatLink("com.kbbaru.attractions", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.ltrimstr(0,9,0))}, new String[] {"Mode","AttractionsId"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void S112( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV9TrnContext = (com.kbbaru.general.ui.SdtTransactionContext)new com.kbbaru.general.ui.SdtTransactionContext(remoteHandle, context);
      AV9TrnContext.setgxTv_SdtTransactionContext_Callerobject( AV19Pgmname );
      AV9TrnContext.setgxTv_SdtTransactionContext_Callerondelete( true );
      AV9TrnContext.setgxTv_SdtTransactionContext_Callerurl( AV7HTTPRequest.getScriptName()+"?"+AV7HTTPRequest.getQuerystring() );
      AV9TrnContext.setgxTv_SdtTransactionContext_Transactionname( "Attractions" );
      AV6Session.setValue("TrnContext", AV9TrnContext.toxml(false, true, "TransactionContext", "KBBaru"));
   }

   public void e121L2( )
   {
      /* 'Export' Routine */
      returnInSub = false ;
      callWebObject(formatLink("com.kbbaru.aattractionlist", new String[] {}, new String[] {}) );
      httpContext.wjLocDisableFrm = (byte)(2) ;
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
      pa1L2( ) ;
      ws1L2( ) ;
      we1L2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20235269592163", true, true);
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
      if ( nGXWrapped != 1 )
      {
         httpContext.AddJavascriptSource("messages.eng.js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
         httpContext.AddJavascriptSource("wwattractions.js", "?20235269592164", false, true);
      }
      /* End function include_jscripts */
   }

   public void subsflControlProps_302( )
   {
      edtAttractionsId_Internalname = "ATTRACTIONSID_"+sGXsfl_30_idx ;
      edtAttractionsName_Internalname = "ATTRACTIONSNAME_"+sGXsfl_30_idx ;
      edtCountryId_Internalname = "COUNTRYID_"+sGXsfl_30_idx ;
      edtCountryName_Internalname = "COUNTRYNAME_"+sGXsfl_30_idx ;
      edtCountryCityId_Internalname = "COUNTRYCITYID_"+sGXsfl_30_idx ;
      edtCountryCityName_Internalname = "COUNTRYCITYNAME_"+sGXsfl_30_idx ;
      edtCategoryId_Internalname = "CATEGORYID_"+sGXsfl_30_idx ;
      edtCategoryName_Internalname = "CATEGORYNAME_"+sGXsfl_30_idx ;
      edtAttractionsPhoto_Internalname = "ATTRACTIONSPHOTO_"+sGXsfl_30_idx ;
      edtavTrips_Internalname = "vTRIPS_"+sGXsfl_30_idx ;
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_30_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_30_idx ;
   }

   public void subsflControlProps_fel_302( )
   {
      edtAttractionsId_Internalname = "ATTRACTIONSID_"+sGXsfl_30_fel_idx ;
      edtAttractionsName_Internalname = "ATTRACTIONSNAME_"+sGXsfl_30_fel_idx ;
      edtCountryId_Internalname = "COUNTRYID_"+sGXsfl_30_fel_idx ;
      edtCountryName_Internalname = "COUNTRYNAME_"+sGXsfl_30_fel_idx ;
      edtCountryCityId_Internalname = "COUNTRYCITYID_"+sGXsfl_30_fel_idx ;
      edtCountryCityName_Internalname = "COUNTRYCITYNAME_"+sGXsfl_30_fel_idx ;
      edtCategoryId_Internalname = "CATEGORYID_"+sGXsfl_30_fel_idx ;
      edtCategoryName_Internalname = "CATEGORYNAME_"+sGXsfl_30_fel_idx ;
      edtAttractionsPhoto_Internalname = "ATTRACTIONSPHOTO_"+sGXsfl_30_fel_idx ;
      edtavTrips_Internalname = "vTRIPS_"+sGXsfl_30_fel_idx ;
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_30_fel_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_30_fel_idx ;
   }

   public void sendrow_302( )
   {
      subsflControlProps_302( ) ;
      wb1L0( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_30_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
      {
         GridRow = GXWebRow.GetNew(context,GridContainer) ;
         if ( subGrid_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGrid_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGrid_Class, "") != 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Odd" ;
            }
         }
         else if ( subGrid_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGrid_Backstyle = (byte)(0) ;
            subGrid_Backcolor = subGrid_Allbackcolor ;
            if ( GXutil.strcmp(subGrid_Class, "") != 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Uniform" ;
            }
         }
         else if ( subGrid_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGrid_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGrid_Class, "") != 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Odd" ;
            }
            subGrid_Backcolor = (int)(0x0) ;
         }
         else if ( subGrid_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGrid_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_30_idx) % (2))) == 0 )
            {
               subGrid_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrid_Class, "") != 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Even" ;
               }
            }
            else
            {
               subGrid_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrid_Class, "") != 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Odd" ;
               }
            }
         }
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"ww__grid"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_30_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtAttractionsId_Internalname,GXutil.ltrim( localUtil.ntoc( A9AttractionsId, (byte)(4), (byte)(0), ".", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A9AttractionsId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtAttractionsId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"column WWOptionalColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(30),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "attribute-description" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtAttractionsName_Internalname,A10AttractionsName,"","","'"+""+"'"+",false,"+"'"+""+"'",edtAttractionsName_Link,"","","",edtAttractionsName_Jsonclick,Integer.valueOf(0),"attribute-description","",ROClassString,"column","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(30),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"Name","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCountryId_Internalname,GXutil.ltrim( localUtil.ntoc( A5CountryId, (byte)(4), (byte)(0), ".", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A5CountryId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCountryId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"column WWOptionalColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(30),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCountryName_Internalname,A6CountryName,"","","'"+""+"'"+",false,"+"'"+""+"'",edtCountryName_Link,"","","",edtCountryName_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"column WWOptionalColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(30),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"Name","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCountryCityId_Internalname,GXutil.ltrim( localUtil.ntoc( A12CountryCityId, (byte)(4), (byte)(0), ".", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A12CountryCityId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCountryCityId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"column WWOptionalColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(30),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCountryCityName_Internalname,A16CountryCityName,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCountryCityName_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"column WWOptionalColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(30),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"Name","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCategoryId_Internalname,GXutil.ltrim( localUtil.ntoc( A3CategoryId, (byte)(4), (byte)(0), ".", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CategoryId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCategoryId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"column WWOptionalColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(30),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCategoryName_Internalname,A4CategoryName,"","","'"+""+"'"+",false,"+"'"+""+"'",edtCategoryName_Link,"","","",edtCategoryName_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"column WWOptionalColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(30),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"Name","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+""+"\">") ;
         }
         /* Static Bitmap Variable */
         ClassString = "ImageAttribute" ;
         StyleString = "" ;
         A11AttractionsPhoto_IsBlob = (boolean)(((GXutil.strcmp("", A11AttractionsPhoto)==0)&&(GXutil.strcmp("", A40001AttractionsPhoto_GXI)==0))||!(GXutil.strcmp("", A11AttractionsPhoto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", A11AttractionsPhoto)==0) ? A40001AttractionsPhoto_GXI : httpContext.getResourceRelative(A11AttractionsPhoto)) ;
         GridRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtAttractionsPhoto_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"px",Integer.valueOf(0),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"column WWOptionalColumn","","","","","","",Integer.valueOf(1),Boolean.valueOf(A11AttractionsPhoto_IsBlob),Boolean.valueOf(true),context.getHttpContext().getImageSrcSet( sImgUrl)});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavTrips_Internalname,GXutil.ltrim( localUtil.ntoc( AV15Trips, (byte)(10), (byte)(0), ".", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV15Trips), "ZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavTrips_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(30),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "TextActionAttribute TextLikeLink" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV12Update),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"","","",edtavUpdate_Jsonclick,Integer.valueOf(0),"TextActionAttribute TextLikeLink","",ROClassString,"WWTextActionColumn","",Integer.valueOf(-1),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(30),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "TextActionAttribute TextLikeLink" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV13Delete),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDelete_Link,"","","",edtavDelete_Jsonclick,Integer.valueOf(0),"TextActionAttribute TextLikeLink","",ROClassString,"WWTextActionColumn","",Integer.valueOf(-1),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(30),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes1L2( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_30_idx = ((subGrid_Islastpage==1)&&(nGXsfl_30_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_30_idx+1) ;
         sGXsfl_30_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_30_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_302( ) ;
      }
      /* End function sendrow_302 */
   }

   public void startgridcontrol30( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"GridContainer"+"DivS\" data-gxgridid=\"30\">") ;
         sStyleString = "" ;
         com.kbbaru.GxWebStd.gx_table_start( httpContext, subGrid_Internalname, subGrid_Internalname, "", "ww__grid", 0, "", "", 1, 2, sStyleString, "", "", 0);
         /* Subfile titles */
         httpContext.writeText( "<tr") ;
         httpContext.writeTextNL( ">") ;
         if ( subGrid_Backcolorstyle == 0 )
         {
            subGrid_Titlebackstyle = (byte)(0) ;
            if ( GXutil.len( subGrid_Class) > 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Title" ;
            }
         }
         else
         {
            subGrid_Titlebackstyle = (byte)(1) ;
            if ( subGrid_Backcolorstyle == 1 )
            {
               subGrid_Titlebackcolor = subGrid_Allbackcolor ;
               if ( GXutil.len( subGrid_Class) > 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"UniformTitle" ;
               }
            }
            else
            {
               if ( GXutil.len( subGrid_Class) > 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Title" ;
               }
            }
         }
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "Id") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"attribute-description"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "Name") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "Country Id") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "Country Name") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "Country City Id") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "Country City Name") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "Category Id") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "Category Name") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"ImageAttribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "Photo") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "Trips") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"TextActionAttribute TextLikeLink"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"TextActionAttribute TextLikeLink"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
         GridContainer.AddObjectProperty("GridName", "Grid");
      }
      else
      {
         if ( isAjaxCallMode( ) )
         {
            GridContainer = new com.genexus.webpanels.GXWebGrid(context);
         }
         else
         {
            GridContainer.Clear();
         }
         GridContainer.SetWrapped(nGXWrapped);
         GridContainer.AddObjectProperty("GridName", "Grid");
         GridContainer.AddObjectProperty("Header", subGrid_Header);
         GridContainer.AddObjectProperty("Class", "ww__grid");
         GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("CmpContext", "");
         GridContainer.AddObjectProperty("InMasterPage", "false");
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", WebUtils.htmlEncode( GXutil.ltrim( localUtil.ntoc( A9AttractionsId, (byte)(4), (byte)(0), ".", ""))));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", WebUtils.htmlEncode( A10AttractionsName));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtAttractionsName_Link));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", WebUtils.htmlEncode( GXutil.ltrim( localUtil.ntoc( A5CountryId, (byte)(4), (byte)(0), ".", ""))));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", WebUtils.htmlEncode( A6CountryName));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtCountryName_Link));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", WebUtils.htmlEncode( GXutil.ltrim( localUtil.ntoc( A12CountryCityId, (byte)(4), (byte)(0), ".", ""))));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", WebUtils.htmlEncode( A16CountryCityName));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", WebUtils.htmlEncode( GXutil.ltrim( localUtil.ntoc( A3CategoryId, (byte)(4), (byte)(0), ".", ""))));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", WebUtils.htmlEncode( A4CategoryName));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtCategoryName_Link));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", httpContext.convertURL( A11AttractionsPhoto));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", WebUtils.htmlEncode( GXutil.ltrim( localUtil.ntoc( AV15Trips, (byte)(10), (byte)(0), ".", ""))));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", WebUtils.htmlEncode( GXutil.rtrim( AV12Update)));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", WebUtils.htmlEncode( GXutil.rtrim( AV13Delete)));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDelete_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDelete_Link));
         GridContainer.AddColumnProperties(GridColumn);
         GridContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGrid_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGrid_Allowselection, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGrid_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGrid_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGrid_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGrid_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGrid_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void init_default_properties( )
   {
      lblTitletext_Internalname = "TITLETEXT" ;
      bttBtninsert_Internalname = "BTNINSERT" ;
      edtavAttractionsname_Internalname = "vATTRACTIONSNAME" ;
      divTabletop_Internalname = "TABLETOP" ;
      bttExport_Internalname = "EXPORT" ;
      edtAttractionsId_Internalname = "ATTRACTIONSID" ;
      edtAttractionsName_Internalname = "ATTRACTIONSNAME" ;
      edtCountryId_Internalname = "COUNTRYID" ;
      edtCountryName_Internalname = "COUNTRYNAME" ;
      edtCountryCityId_Internalname = "COUNTRYCITYID" ;
      edtCountryCityName_Internalname = "COUNTRYCITYNAME" ;
      edtCategoryId_Internalname = "CATEGORYID" ;
      edtCategoryName_Internalname = "CATEGORYNAME" ;
      edtAttractionsPhoto_Internalname = "ATTRACTIONSPHOTO" ;
      edtavTrips_Internalname = "vTRIPS" ;
      edtavUpdate_Internalname = "vUPDATE" ;
      edtavDelete_Internalname = "vDELETE" ;
      divGridcontainer_Internalname = "GRIDCONTAINER" ;
      divGridtable_Internalname = "GRIDTABLE" ;
      divGridcell_Internalname = "GRIDCELL" ;
      divMaintable_Internalname = "MAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGrid_Internalname = "GRID" ;
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
      subGrid_Allowcollapsing = (byte)(0) ;
      subGrid_Allowselection = (byte)(0) ;
      subGrid_Header = "" ;
      edtavDelete_Jsonclick = "" ;
      edtavDelete_Link = "" ;
      edtavDelete_Enabled = 0 ;
      edtavUpdate_Jsonclick = "" ;
      edtavUpdate_Link = "" ;
      edtavUpdate_Enabled = 0 ;
      edtavTrips_Jsonclick = "" ;
      edtCategoryName_Jsonclick = "" ;
      edtCategoryName_Link = "" ;
      edtCategoryId_Jsonclick = "" ;
      edtCountryCityName_Jsonclick = "" ;
      edtCountryCityId_Jsonclick = "" ;
      edtCountryName_Jsonclick = "" ;
      edtCountryName_Link = "" ;
      edtCountryId_Jsonclick = "" ;
      edtAttractionsName_Jsonclick = "" ;
      edtAttractionsName_Link = "" ;
      edtAttractionsId_Jsonclick = "" ;
      subGrid_Class = "ww__grid" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      edtavAttractionsname_Jsonclick = "" ;
      edtavAttractionsname_Enabled = 1 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Work With Attractions" );
      subGrid_Rows = 10 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV11AttractionsName',fld:'vATTRACTIONSNAME',pic:''},{av:'AV12Update',fld:'vUPDATE',pic:''},{av:'AV13Delete',fld:'vDELETE',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("GRID.LOAD","{handler:'e151L2',iparms:[{av:'A9AttractionsId',fld:'ATTRACTIONSID',pic:'ZZZ9',hsh:true},{av:'A5CountryId',fld:'COUNTRYID',pic:'ZZZ9'},{av:'A3CategoryId',fld:'CATEGORYID',pic:'ZZZ9'}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'edtAttractionsName_Link',ctrl:'ATTRACTIONSNAME',prop:'Link'},{av:'edtCountryName_Link',ctrl:'COUNTRYNAME',prop:'Link'},{av:'edtCategoryName_Link',ctrl:'CATEGORYNAME',prop:'Link'},{av:'AV15Trips',fld:'vTRIPS',pic:'ZZZZZZZZZ9'},{av:'A40000GXC1',fld:'GXC1',pic:'999999999'}]}");
      setEventMetadata("'DOINSERT'","{handler:'e111L2',iparms:[{av:'A9AttractionsId',fld:'ATTRACTIONSID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[]}");
      setEventMetadata("'EXPORT'","{handler:'e121L2',iparms:[]");
      setEventMetadata("'EXPORT'",",oparms:[]}");
      setEventMetadata("GRID_FIRSTPAGE","{handler:'subgrid_firstpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV11AttractionsName',fld:'vATTRACTIONSNAME',pic:''},{av:'AV12Update',fld:'vUPDATE',pic:''},{av:'AV13Delete',fld:'vDELETE',pic:''}]");
      setEventMetadata("GRID_FIRSTPAGE",",oparms:[]}");
      setEventMetadata("GRID_PREVPAGE","{handler:'subgrid_previouspage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV11AttractionsName',fld:'vATTRACTIONSNAME',pic:''},{av:'AV12Update',fld:'vUPDATE',pic:''},{av:'AV13Delete',fld:'vDELETE',pic:''}]");
      setEventMetadata("GRID_PREVPAGE",",oparms:[]}");
      setEventMetadata("GRID_NEXTPAGE","{handler:'subgrid_nextpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV11AttractionsName',fld:'vATTRACTIONSNAME',pic:''},{av:'AV12Update',fld:'vUPDATE',pic:''},{av:'AV13Delete',fld:'vDELETE',pic:''}]");
      setEventMetadata("GRID_NEXTPAGE",",oparms:[]}");
      setEventMetadata("GRID_LASTPAGE","{handler:'subgrid_lastpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV11AttractionsName',fld:'vATTRACTIONSNAME',pic:''},{av:'AV12Update',fld:'vUPDATE',pic:''},{av:'AV13Delete',fld:'vDELETE',pic:''}]");
      setEventMetadata("GRID_LASTPAGE",",oparms:[]}");
      setEventMetadata("VALID_ATTRACTIONSID","{handler:'valid_Attractionsid',iparms:[]");
      setEventMetadata("VALID_ATTRACTIONSID",",oparms:[]}");
      setEventMetadata("VALID_COUNTRYID","{handler:'valid_Countryid',iparms:[]");
      setEventMetadata("VALID_COUNTRYID",",oparms:[]}");
      setEventMetadata("VALID_COUNTRYCITYID","{handler:'valid_Countrycityid',iparms:[]");
      setEventMetadata("VALID_COUNTRYCITYID",",oparms:[]}");
      setEventMetadata("VALID_CATEGORYID","{handler:'valid_Categoryid',iparms:[]");
      setEventMetadata("VALID_CATEGORYID",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Delete',iparms:[]");
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
      AV12Update = "" ;
      AV13Delete = "" ;
      AV11AttractionsName = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      lblTitletext_Jsonclick = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtninsert_Jsonclick = "" ;
      bttExport_Jsonclick = "" ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      A10AttractionsName = "" ;
      A6CountryName = "" ;
      A16CountryCityName = "" ;
      A4CategoryName = "" ;
      A11AttractionsPhoto = "" ;
      A40001AttractionsPhoto_GXI = "" ;
      AV19Pgmname = "" ;
      GridState = new com.genexus.webpanels.gridstate.GXGridStateHandler(context,"Grid",getPgmname(),this,"subgrid_varsfromstate","subgrid_varstostate") ;
      scmdbuf = "" ;
      lV11AttractionsName = "" ;
      H001L3_A11AttractionsPhoto = new String[] {""} ;
      H001L3_A40001AttractionsPhoto_GXI = new String[] {""} ;
      H001L3_A4CategoryName = new String[] {""} ;
      H001L3_A3CategoryId = new short[1] ;
      H001L3_A16CountryCityName = new String[] {""} ;
      H001L3_A12CountryCityId = new short[1] ;
      H001L3_A6CountryName = new String[] {""} ;
      H001L3_A5CountryId = new short[1] ;
      H001L3_A10AttractionsName = new String[] {""} ;
      H001L3_A9AttractionsId = new short[1] ;
      H001L3_A40000GXC1 = new int[1] ;
      H001L3_n40000GXC1 = new boolean[] {false} ;
      H001L5_AGRID_nRecordCount = new long[1] ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV9TrnContext = new com.kbbaru.general.ui.SdtTransactionContext(remoteHandle, context);
      AV7HTTPRequest = httpContext.getHttpRequest();
      AV6Session = httpContext.getWebSession();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGrid_Linesclass = "" ;
      ROClassString = "" ;
      sImgUrl = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.kbbaru.wwattractions__default(),
         new Object[] {
             new Object[] {
            H001L3_A11AttractionsPhoto, H001L3_A40001AttractionsPhoto_GXI, H001L3_A4CategoryName, H001L3_A3CategoryId, H001L3_A16CountryCityName, H001L3_A12CountryCityId, H001L3_A6CountryName, H001L3_A5CountryId, H001L3_A10AttractionsName, H001L3_A9AttractionsId,
            H001L3_A40000GXC1, H001L3_n40000GXC1
            }
            , new Object[] {
            H001L5_AGRID_nRecordCount
            }
         }
      );
      AV19Pgmname = "WWAttractions" ;
      /* GeneXus formulas. */
      AV19Pgmname = "WWAttractions" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      edtavDelete_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nGXWrapped ;
   private byte nDonePA ;
   private byte subGrid_Backcolorstyle ;
   private byte subGrid_Backstyle ;
   private byte subGrid_Titlebackstyle ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private short wbEnd ;
   private short wbStart ;
   private short A9AttractionsId ;
   private short A5CountryId ;
   private short A12CountryCityId ;
   private short A3CategoryId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int nRC_GXsfl_30 ;
   private int subGrid_Rows ;
   private int nGXsfl_30_idx=1 ;
   private int edtavAttractionsname_Enabled ;
   private int subGrid_Islastpage ;
   private int edtavUpdate_Enabled ;
   private int edtavDelete_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int A40000GXC1 ;
   private int GridPageCount ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV15Trips ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_30_idx="0001" ;
   private String AV12Update ;
   private String AV13Delete ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divMaintable_Internalname ;
   private String divGridcell_Internalname ;
   private String divGridtable_Internalname ;
   private String divTabletop_Internalname ;
   private String lblTitletext_Internalname ;
   private String lblTitletext_Jsonclick ;
   private String TempTags ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtninsert_Internalname ;
   private String bttBtninsert_Jsonclick ;
   private String edtavAttractionsname_Internalname ;
   private String edtavAttractionsname_Jsonclick ;
   private String divGridcontainer_Internalname ;
   private String bttExport_Internalname ;
   private String bttExport_Jsonclick ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtAttractionsId_Internalname ;
   private String edtAttractionsName_Internalname ;
   private String edtCountryId_Internalname ;
   private String edtCountryName_Internalname ;
   private String edtCountryCityId_Internalname ;
   private String edtCountryCityName_Internalname ;
   private String edtCategoryId_Internalname ;
   private String edtCategoryName_Internalname ;
   private String edtAttractionsPhoto_Internalname ;
   private String edtavTrips_Internalname ;
   private String edtavUpdate_Internalname ;
   private String edtavDelete_Internalname ;
   private String AV19Pgmname ;
   private String scmdbuf ;
   private String edtavUpdate_Link ;
   private String edtavDelete_Link ;
   private String edtAttractionsName_Link ;
   private String edtCountryName_Link ;
   private String edtCategoryName_Link ;
   private String sGXsfl_30_fel_idx="0001" ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String ROClassString ;
   private String edtAttractionsId_Jsonclick ;
   private String edtAttractionsName_Jsonclick ;
   private String edtCountryId_Jsonclick ;
   private String edtCountryName_Jsonclick ;
   private String edtCountryCityId_Jsonclick ;
   private String edtCountryCityName_Jsonclick ;
   private String edtCategoryId_Jsonclick ;
   private String edtCategoryName_Jsonclick ;
   private String sImgUrl ;
   private String edtavTrips_Jsonclick ;
   private String edtavUpdate_Jsonclick ;
   private String edtavDelete_Jsonclick ;
   private String subGrid_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_30_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n40000GXC1 ;
   private boolean returnInSub ;
   private boolean Cond_result ;
   private boolean gx_refresh_fired ;
   private boolean A11AttractionsPhoto_IsBlob ;
   private String AV11AttractionsName ;
   private String A10AttractionsName ;
   private String A6CountryName ;
   private String A16CountryCityName ;
   private String A4CategoryName ;
   private String A40001AttractionsPhoto_GXI ;
   private String lV11AttractionsName ;
   private String A11AttractionsPhoto ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV7HTTPRequest ;
   private com.genexus.webpanels.gridstate.GXGridStateHandler GridState ;
   private IDataStoreProvider pr_default ;
   private String[] H001L3_A11AttractionsPhoto ;
   private String[] H001L3_A40001AttractionsPhoto_GXI ;
   private String[] H001L3_A4CategoryName ;
   private short[] H001L3_A3CategoryId ;
   private String[] H001L3_A16CountryCityName ;
   private short[] H001L3_A12CountryCityId ;
   private String[] H001L3_A6CountryName ;
   private short[] H001L3_A5CountryId ;
   private String[] H001L3_A10AttractionsName ;
   private short[] H001L3_A9AttractionsId ;
   private int[] H001L3_A40000GXC1 ;
   private boolean[] H001L3_n40000GXC1 ;
   private long[] H001L5_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.webpanels.WebSession AV6Session ;
   private com.kbbaru.general.ui.SdtTransactionContext AV9TrnContext ;
}

final  class wwattractions__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H001L3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV11AttractionsName ,
                                          String A10AttractionsName )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[4];
      Object[] GXv_Object2 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " T1.AttractionsPhoto, T1.AttractionsPhoto_GXI, T2.CategoryName, T1.CategoryId, T4.CountryCityName, T1.CountryCityId, T3.CountryName, T1.CountryId, T1.AttractionsName," ;
      sSelectString += " T1.AttractionsId, COALESCE( T5.GXC1, 0) AS GXC1" ;
      sFromString = " FROM ((((Attractions T1 INNER JOIN Category T2 ON T2.CategoryId = T1.CategoryId) INNER JOIN Country T3 ON T3.CountryId = T1.CountryId) INNER JOIN CountryCity T4" ;
      sFromString += " ON T4.CountryId = T1.CountryId AND T4.CountryCityId = T1.CountryCityId) LEFT JOIN LATERAL (SELECT COUNT(*) AS GXC1, T6.AttractionsId FROM (TripsAttrations T6 INNER" ;
      sFromString += " JOIN Trips T7 ON T7.TripsId = T6.TripsId) WHERE T1.AttractionsId = T6.AttractionsId GROUP BY T6.AttractionsId ) T5 ON T5.AttractionsId = T1.AttractionsId)" ;
      sOrderString = "" ;
      if ( ! (GXutil.strcmp("", AV11AttractionsName)==0) )
      {
         addWhere(sWhereString, "(T1.AttractionsName like ?)");
      }
      else
      {
         GXv_int1[0] = (byte)(1) ;
      }
      sOrderString += " ORDER BY T1.AttractionsName, T1.AttractionsId" ;
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object2[0] = scmdbuf ;
      GXv_Object2[1] = GXv_int1 ;
      return GXv_Object2 ;
   }

   protected Object[] conditional_H001L5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV11AttractionsName ,
                                          String A10AttractionsName )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int3 = new byte[1];
      Object[] GXv_Object4 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM ((((Attractions T1 INNER JOIN Category T2 ON T2.CategoryId = T1.CategoryId) INNER JOIN Country T3 ON T3.CountryId = T1.CountryId) INNER JOIN" ;
      scmdbuf += " CountryCity T4 ON T4.CountryId = T1.CountryId AND T4.CountryCityId = T1.CountryCityId) LEFT JOIN LATERAL (SELECT COUNT(*) AS GXC1, T6.AttractionsId FROM (TripsAttrations" ;
      scmdbuf += " T6 INNER JOIN Trips T7 ON T7.TripsId = T6.TripsId) WHERE T1.AttractionsId = T6.AttractionsId GROUP BY T6.AttractionsId ) T5 ON T5.AttractionsId = T1.AttractionsId)" ;
      if ( ! (GXutil.strcmp("", AV11AttractionsName)==0) )
      {
         addWhere(sWhereString, "(T1.AttractionsName like ?)");
      }
      else
      {
         GXv_int3[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
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
                  return conditional_H001L3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 1 :
                  return conditional_H001L5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H001L3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H001L5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getMultimediaFile(1, rslt.getVarchar(2));
               ((String[]) buf[1])[0] = rslt.getMultimediaUri(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
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
                  stmt.setVarchar(sIdx, (String)parms[4], 40);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[1], 40);
               }
               return;
      }
   }

}

