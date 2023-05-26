package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class categorypanel_impl extends GXDataArea
{
   public categorypanel_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public categorypanel_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( categorypanel_impl.class ));
   }

   public categorypanel_impl( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void executeCmdLine( String args[] )
   {
      nGotPars = 1 ;
      webExecute();
   }

   protected void createObjects( )
   {
      chkavCtlischeck = UIFactory.getCheckbox(this);
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
      nRC_GXsfl_14 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_14"))) ;
      nGXsfl_14_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_14_idx"))) ;
      sGXsfl_14_idx = httpContext.GetPar( "sGXsfl_14_idx") ;
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
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid1_refresh( ) ;
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
      pa262( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start262( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.kbbaru.categorypanel", new String[] {}, new String[] {}) +"\">") ;
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
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdtcategory", AV12SDTCategory);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdtcategory", AV12SDTCategory);
      }
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_14", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_14, (byte)(8), (byte)(0), ".", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTCATEGORYITEM", AV13SDTCategoryItem);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTCATEGORYITEM", AV13SDTCategoryItem);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTCATEGORY", AV12SDTCategory);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTCATEGORY", AV12SDTCategory);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCATEGORY", AV11Category);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCATEGORY", AV11Category);
      }
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "CATEGORYID", GXutil.ltrim( localUtil.ntoc( A40000CategoryId, (byte)(4), (byte)(0), ".", "")));
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
         we262( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt262( ) ;
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
      return formatLink("com.kbbaru.categorypanel", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "CategoryPanel" ;
   }

   public String getPgmdesc( )
   {
      return "Category Panel" ;
   }

   public void wb260( )
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
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavName_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.kbbaru.GxWebStd.gx_label_element( httpContext, edtavName_Internalname, "Name", "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 8,'',false,'" + sGXsfl_14_idx + "',0)\"" ;
         com.kbbaru.GxWebStd.gx_single_line_edit( httpContext, edtavName_Internalname, AV5Name, GXutil.rtrim( localUtil.format( AV5Name, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,8);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavName_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Name", "left", true, "", "HLP_CategoryPanel.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 11,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttAdd_Internalname, "gx.evt.setGridEvt("+GXutil.str( 14, 2, 0)+","+"null"+");", "Add", bttAdd_Jsonclick, 5, "Add", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'ADD\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_CategoryPanel.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         Grid1Container.SetWrapped(nGXWrapped);
         startgridcontrol14( ) ;
      }
      if ( wbEnd == 14 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_14 = (int)(nGXsfl_14_idx-1) ;
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV16GXV1 = nGXsfl_14_idx ;
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
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 20,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttUpdate_Internalname, "gx.evt.setGridEvt("+GXutil.str( 14, 2, 0)+","+"null"+");", "Update", bttUpdate_Jsonclick, 5, "Update", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'UPDATE\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_CategoryPanel.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttAddrow_Internalname, "gx.evt.setGridEvt("+GXutil.str( 14, 2, 0)+","+"null"+");", "Add Row", bttAddrow_Jsonclick, 5, "Add Row", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'ADDROW\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_CategoryPanel.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 14 )
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
               AV16GXV1 = nGXsfl_14_idx ;
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

   public void start262( )
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
         Form.getMeta().addItem("description", "Category Panel", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup260( ) ;
   }

   public void ws262( )
   {
      start262( ) ;
      evt262( ) ;
   }

   public void evt262( )
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
                        else if ( GXutil.strcmp(sEvt, "'ADDROW'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'AddRow' */
                           e11262 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'UPDATE'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'Update' */
                           e12262 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'ADD'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'Add' */
                           e13262 ();
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
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 13), "GRID1.REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 10), "GRID1.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           nGXsfl_14_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_14_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_14_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_142( ) ;
                           AV16GXV1 = nGXsfl_14_idx ;
                           if ( ( AV12SDTCategory.size() >= AV16GXV1 ) && ( AV16GXV1 > 0 ) )
                           {
                              AV12SDTCategory.currentItem( ((com.kbbaru.SdtSDTCategory_SDTCategoryItem)AV12SDTCategory.elementAt(-1+AV16GXV1)) );
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e14262 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID1.REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e15262 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID1.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e16262 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 if ( ! wbErr )
                                 {
                                    Rfr0gs = false ;
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

   public void we262( )
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

   public void pa262( )
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
            GX_FocusControl = edtavName_Internalname ;
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
      subsflControlProps_142( ) ;
      while ( nGXsfl_14_idx <= nRC_GXsfl_14 )
      {
         sendrow_142( ) ;
         nGXsfl_14_idx = ((subGrid1_Islastpage==1)&&(nGXsfl_14_idx+1>subgrid1_fnc_recordsperpage( )) ? 1 : nGXsfl_14_idx+1) ;
         sGXsfl_14_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_14_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_142( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Grid1Container)) ;
      /* End function gxnrGrid1_newrow */
   }

   public void gxgrgrid1_refresh( )
   {
      initialize_formulas( ) ;
      com.kbbaru.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRID1_nCurrentRecord = 0 ;
      rf262( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid1_refresh */
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
      rf262( ) ;
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
   }

   public void rf262( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         Grid1Container.ClearRows();
      }
      wbStart = (short)(14) ;
      e15262 ();
      nGXsfl_14_idx = 1 ;
      sGXsfl_14_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_14_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_142( ) ;
      bGXsfl_14_Refreshing = true ;
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
         subsflControlProps_142( ) ;
         e16262 ();
         wbEnd = (short)(14) ;
         wb260( ) ;
      }
      bGXsfl_14_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes262( )
   {
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
      /* Using cursor H00263 */
      pr_default.execute(0, new Object[] {Short.valueOf(((com.kbbaru.SdtSDTCategory_SDTCategoryItem)(AV12SDTCategory.currentItem())).getgxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryid())});
      if ( (pr_default.getStatus(0) != 101) )
      {
         A40000CategoryId = H00263_A40000CategoryId[0] ;
         n40000CategoryId = H00263_n40000CategoryId[0] ;
      }
      else
      {
         A40000CategoryId = (short)(0) ;
         n40000CategoryId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A40000CategoryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40000CategoryId), 4, 0));
      }
      pr_default.close(0);
      fix_multi_value_controls( ) ;
   }

   public void strup260( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e14262 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdtcategory"), AV12SDTCategory);
         /* Read saved values. */
         nRC_GXsfl_14 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_14"), ".", ",")) ;
         nRC_GXsfl_14 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_14"), ".", ",")) ;
         nGXsfl_14_fel_idx = 0 ;
         while ( nGXsfl_14_fel_idx < nRC_GXsfl_14 )
         {
            nGXsfl_14_fel_idx = ((subGrid1_Islastpage==1)&&(nGXsfl_14_fel_idx+1>subgrid1_fnc_recordsperpage( )) ? 1 : nGXsfl_14_fel_idx+1) ;
            sGXsfl_14_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_14_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_142( ) ;
            AV16GXV1 = nGXsfl_14_fel_idx ;
            if ( ( AV12SDTCategory.size() >= AV16GXV1 ) && ( AV16GXV1 > 0 ) )
            {
               AV12SDTCategory.currentItem( ((com.kbbaru.SdtSDTCategory_SDTCategoryItem)AV12SDTCategory.elementAt(-1+AV16GXV1)) );
            }
         }
         if ( nGXsfl_14_fel_idx == 0 )
         {
            nGXsfl_14_idx = 1 ;
            sGXsfl_14_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_14_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_142( ) ;
         }
         nGXsfl_14_fel_idx = 1 ;
         /* Read variables values. */
         AV5Name = httpContext.cgiGet( edtavName_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5Name", AV5Name);
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
      e14262 ();
      if ( returnInSub )
      {
         pr_default.close(0);
         returnInSub = true;
         if (true) return;
      }
   }

   public void e14262( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_objcol_SdtSDTCategory_SDTCategoryItem1 = AV12SDTCategory ;
      GXv_objcol_SdtSDTCategory_SDTCategoryItem2[0] = GXt_objcol_SdtSDTCategory_SDTCategoryItem1 ;
      new com.kbbaru.datacategory(remoteHandle, context).execute( GXv_objcol_SdtSDTCategory_SDTCategoryItem2) ;
      GXt_objcol_SdtSDTCategory_SDTCategoryItem1 = GXv_objcol_SdtSDTCategory_SDTCategoryItem2[0] ;
      AV12SDTCategory = GXt_objcol_SdtSDTCategory_SDTCategoryItem1 ;
      gx_BV14 = true ;
   }

   public void e11262( )
   {
      AV16GXV1 = nGXsfl_14_idx ;
      if ( ( AV16GXV1 > 0 ) && ( AV12SDTCategory.size() >= AV16GXV1 ) )
      {
         AV12SDTCategory.currentItem( ((com.kbbaru.SdtSDTCategory_SDTCategoryItem)AV12SDTCategory.elementAt(-1+AV16GXV1)) );
      }
      /* 'AddRow' Routine */
      returnInSub = false ;
      AV13SDTCategoryItem.setgxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryid( (short)(0) );
      AV13SDTCategoryItem.setgxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryname( "" );
      AV13SDTCategoryItem.setgxTv_SdtSDTCategory_SDTCategoryItem_Ischeck( true );
      AV12SDTCategory.add(AV13SDTCategoryItem, 0);
      gx_BV14 = true ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV13SDTCategoryItem", AV13SDTCategoryItem);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12SDTCategory", AV12SDTCategory);
      nGXsfl_14_bak_idx = nGXsfl_14_idx ;
      gxgrgrid1_refresh( ) ;
      nGXsfl_14_idx = nGXsfl_14_bak_idx ;
      sGXsfl_14_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_14_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_142( ) ;
   }

   public void e15262( )
   {
      AV16GXV1 = nGXsfl_14_idx ;
      if ( ( AV16GXV1 > 0 ) && ( AV12SDTCategory.size() >= AV16GXV1 ) )
      {
         AV12SDTCategory.currentItem( ((com.kbbaru.SdtSDTCategory_SDTCategoryItem)AV12SDTCategory.elementAt(-1+AV16GXV1)) );
      }
      /* Grid1_Refresh Routine */
      returnInSub = false ;
      GXt_objcol_SdtSDTCategory_SDTCategoryItem1 = AV12SDTCategory ;
      GXv_objcol_SdtSDTCategory_SDTCategoryItem2[0] = GXt_objcol_SdtSDTCategory_SDTCategoryItem1 ;
      new com.kbbaru.datacategory(remoteHandle, context).execute( GXv_objcol_SdtSDTCategory_SDTCategoryItem2) ;
      GXt_objcol_SdtSDTCategory_SDTCategoryItem1 = GXv_objcol_SdtSDTCategory_SDTCategoryItem2[0] ;
      AV12SDTCategory = GXt_objcol_SdtSDTCategory_SDTCategoryItem1 ;
      gx_BV14 = true ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12SDTCategory", AV12SDTCategory);
   }

   public void e12262( )
   {
      AV16GXV1 = nGXsfl_14_idx ;
      if ( ( AV16GXV1 > 0 ) && ( AV12SDTCategory.size() >= AV16GXV1 ) )
      {
         AV12SDTCategory.currentItem( ((com.kbbaru.SdtSDTCategory_SDTCategoryItem)AV12SDTCategory.elementAt(-1+AV16GXV1)) );
      }
      /* 'Update' Routine */
      returnInSub = false ;
      /* Using cursor H00265 */
      pr_default.execute(1, new Object[] {Short.valueOf(((com.kbbaru.SdtSDTCategory_SDTCategoryItem)(AV12SDTCategory.currentItem())).getgxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryid())});
      if ( (pr_default.getStatus(1) != 101) )
      {
         A40000CategoryId = H00265_A40000CategoryId[0] ;
         n40000CategoryId = H00265_n40000CategoryId[0] ;
      }
      else
      {
         A40000CategoryId = (short)(0) ;
         n40000CategoryId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A40000CategoryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40000CategoryId), 4, 0));
      }
      pr_default.close(1);
      if ( ((com.kbbaru.SdtSDTCategory_SDTCategoryItem)(AV12SDTCategory.currentItem())).getgxTv_SdtSDTCategory_SDTCategoryItem_Ischeck() )
      {
         AV11Category.setgxTv_SdtCategory_Categoryid( A40000CategoryId );
         AV11Category.setgxTv_SdtCategory_Categoryname( ((com.kbbaru.SdtSDTCategory_SDTCategoryItem)(AV12SDTCategory.currentItem())).getgxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryname() );
         AV11Category.Update();
         if ( AV11Category.Success() )
         {
            Application.commitDataStores(context, remoteHandle, pr_default, "categorypanel");
            httpContext.GX_msglist.addItem("Data dengan Id : "+((com.kbbaru.SdtSDTCategory_SDTCategoryItem)(AV12SDTCategory.currentItem())).getgxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryid()+" Berhasil Di update!");
            gxgrgrid1_refresh( ) ;
         }
      }
      if ( ! ((com.kbbaru.SdtSDTCategory_SDTCategoryItem)(AV12SDTCategory.currentItem())).getgxTv_SdtSDTCategory_SDTCategoryItem_Ischeck() )
      {
         httpContext.GX_msglist.addItem("Data dengan Id = "+((com.kbbaru.SdtSDTCategory_SDTCategoryItem)(AV12SDTCategory.currentItem())).getgxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryid()+" GAGAL Di update! Harap Ceklis Data Yang Mau Anda Update!");
         gxgrgrid1_refresh( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11Category", AV11Category);
   }

   public void e13262( )
   {
      /* 'Add' Routine */
      returnInSub = false ;
      AV11Category = (com.kbbaru.SdtCategory)new com.kbbaru.SdtCategory( remoteHandle, context);
      AV11Category.setgxTv_SdtCategory_Categoryname( AV5Name );
      AV11Category.Insert();
      if ( AV11Category.Success() )
      {
         httpContext.GX_msglist.addItem("Data Berhasil Ditambahkan!");
         Application.commitDataStores(context, remoteHandle, pr_default, "categorypanel");
         gxgrgrid1_refresh( ) ;
         AV5Name = "" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5Name", AV5Name);
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "categorypanel");
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11Category", AV11Category);
   }

   private void e16262( )
   {
      /* Grid1_Load Routine */
      returnInSub = false ;
      AV16GXV1 = 1 ;
      while ( AV16GXV1 <= AV12SDTCategory.size() )
      {
         AV12SDTCategory.currentItem( ((com.kbbaru.SdtSDTCategory_SDTCategoryItem)AV12SDTCategory.elementAt(-1+AV16GXV1)) );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(14) ;
         }
         sendrow_142( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_14_Refreshing )
         {
            httpContext.doAjaxLoad(14, Grid1Row);
         }
         AV16GXV1 = (int)(AV16GXV1+1) ;
      }
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
      pa262( ) ;
      ws262( ) ;
      we262( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202352614525831", true, true);
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
      httpContext.AddJavascriptSource("categorypanel.js", "?202352614525831", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_142( )
   {
      chkavCtlischeck.setInternalname( "CTLISCHECK_"+sGXsfl_14_idx );
      edtavCtlsdtcategoryid_Internalname = "CTLSDTCATEGORYID_"+sGXsfl_14_idx ;
      edtavCtlsdtcategoryname_Internalname = "CTLSDTCATEGORYNAME_"+sGXsfl_14_idx ;
   }

   public void subsflControlProps_fel_142( )
   {
      chkavCtlischeck.setInternalname( "CTLISCHECK_"+sGXsfl_14_fel_idx );
      edtavCtlsdtcategoryid_Internalname = "CTLSDTCATEGORYID_"+sGXsfl_14_fel_idx ;
      edtavCtlsdtcategoryname_Internalname = "CTLSDTCATEGORYNAME_"+sGXsfl_14_fel_idx ;
   }

   public void sendrow_142( )
   {
      subsflControlProps_142( ) ;
      wb260( ) ;
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
         if ( ((int)((nGXsfl_14_idx) % (2))) == 0 )
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
         httpContext.writeText( " gxrow=\""+sGXsfl_14_idx+"\">") ;
      }
      /* Subfile cell */
      if ( Grid1Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+""+"\">") ;
      }
      /* Check box */
      TempTags = " " + ((chkavCtlischeck.getEnabled()!=0)&&(chkavCtlischeck.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 15,'',false,'"+sGXsfl_14_idx+"',14)\"" : " ") ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      GXCCtl = "CTLISCHECK_" + sGXsfl_14_idx ;
      chkavCtlischeck.setName( GXCCtl );
      chkavCtlischeck.setWebtags( "" );
      chkavCtlischeck.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavCtlischeck.getInternalname(), "TitleCaption", chkavCtlischeck.getCaption(), !bGXsfl_14_Refreshing);
      chkavCtlischeck.setCheckedValue( "false" );
      Grid1Row.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkavCtlischeck.getInternalname(),GXutil.booltostr( ((com.kbbaru.SdtSDTCategory_SDTCategoryItem)AV12SDTCategory.elementAt(-1+AV16GXV1)).getgxTv_SdtSDTCategory_SDTCategoryItem_Ischeck()),"","",Integer.valueOf(-1),Integer.valueOf(1),"true","",StyleString,ClassString,"","",TempTags+((chkavCtlischeck.getEnabled()!=0)&&(chkavCtlischeck.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,15);\"" : " ")});
      /* Subfile cell */
      if ( Grid1Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
      }
      /* Single line edit */
      TempTags = " " + ((edtavCtlsdtcategoryid_Enabled!=0)&&(edtavCtlsdtcategoryid_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 16,'',false,'"+sGXsfl_14_idx+"',14)\"" : " ") ;
      ROClassString = "Attribute" ;
      Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtcategoryid_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.kbbaru.SdtSDTCategory_SDTCategoryItem)AV12SDTCategory.elementAt(-1+AV16GXV1)).getgxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryid(), (byte)(4), (byte)(0), ".", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(((com.kbbaru.SdtSDTCategory_SDTCategoryItem)AV12SDTCategory.elementAt(-1+AV16GXV1)).getgxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryid()), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,',');"+";gx.evt.onchange(this, event)\" "+((edtavCtlsdtcategoryid_Enabled!=0)&&(edtavCtlsdtcategoryid_Visible!=0) ? " onblur=\""+"gx.num.valid_integer( this,',');"+";gx.evt.onblur(this,16);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtcategoryid_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(1),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(14),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      if ( Grid1Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
      }
      /* Single line edit */
      TempTags = " " + ((edtavCtlsdtcategoryname_Enabled!=0)&&(edtavCtlsdtcategoryname_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 17,'',false,'"+sGXsfl_14_idx+"',14)\"" : " ") ;
      ROClassString = "Attribute" ;
      Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtcategoryname_Internalname,((com.kbbaru.SdtSDTCategory_SDTCategoryItem)AV12SDTCategory.elementAt(-1+AV16GXV1)).getgxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryname(),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavCtlsdtcategoryname_Enabled!=0)&&(edtavCtlsdtcategoryname_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,17);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtcategoryname_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(14),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      send_integrity_lvl_hashes262( ) ;
      Grid1Container.AddRow(Grid1Row);
      nGXsfl_14_idx = ((subGrid1_Islastpage==1)&&(nGXsfl_14_idx+1>subgrid1_fnc_recordsperpage( )) ? 1 : nGXsfl_14_idx+1) ;
      sGXsfl_14_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_14_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_142( ) ;
      /* End function sendrow_142 */
   }

   public void startgridcontrol14( )
   {
      if ( Grid1Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"Grid1Container"+"DivS\" data-gxgridid=\"14\">") ;
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
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "is Check") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "Category Id") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "Category Name") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
         Grid1Container.AddObjectProperty("GridName", "Grid1");
      }
      else
      {
         Grid1Container.AddObjectProperty("GridName", "Grid1");
         Grid1Container.AddObjectProperty("Header", subGrid1_Header);
         Grid1Container.AddObjectProperty("Class", "Grid");
         Grid1Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid1_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("CmpContext", "");
         Grid1Container.AddObjectProperty("InMasterPage", "false");
         Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid1Container.AddColumnProperties(Grid1Column);
         Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid1Container.AddColumnProperties(Grid1Column);
         Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
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
      edtavName_Internalname = "vNAME" ;
      bttAdd_Internalname = "ADD" ;
      chkavCtlischeck.setInternalname( "CTLISCHECK" );
      edtavCtlsdtcategoryid_Internalname = "CTLSDTCATEGORYID" ;
      edtavCtlsdtcategoryname_Internalname = "CTLSDTCATEGORYNAME" ;
      bttUpdate_Internalname = "UPDATE" ;
      bttAddrow_Internalname = "ADDROW" ;
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
      edtavCtlsdtcategoryname_Jsonclick = "" ;
      edtavCtlsdtcategoryname_Visible = -1 ;
      edtavCtlsdtcategoryname_Enabled = 1 ;
      edtavCtlsdtcategoryid_Jsonclick = "" ;
      edtavCtlsdtcategoryid_Visible = -1 ;
      edtavCtlsdtcategoryid_Enabled = 1 ;
      chkavCtlischeck.setCaption( "" );
      chkavCtlischeck.setVisible( -1 );
      chkavCtlischeck.setEnabled( 1 );
      subGrid1_Class = "Grid" ;
      subGrid1_Backcolorstyle = (byte)(0) ;
      edtavName_Jsonclick = "" ;
      edtavName_Enabled = 1 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Category Panel" );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      GXCCtl = "CTLISCHECK_" + sGXsfl_14_idx ;
      chkavCtlischeck.setName( GXCCtl );
      chkavCtlischeck.setWebtags( "" );
      chkavCtlischeck.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavCtlischeck.getInternalname(), "TitleCaption", chkavCtlischeck.getCaption(), !bGXsfl_14_Refreshing);
      chkavCtlischeck.setCheckedValue( "false" );
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'AV12SDTCategory',fld:'vSDTCATEGORY',grid:14,pic:''},{av:'nGXsfl_14_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:14},{av:'nRC_GXsfl_14',ctrl:'GRID1',prop:'GridRC',grid:14}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'ADDROW'","{handler:'e11262',iparms:[{av:'AV13SDTCategoryItem',fld:'vSDTCATEGORYITEM',pic:''},{av:'AV12SDTCategory',fld:'vSDTCATEGORY',grid:14,pic:''},{av:'nGXsfl_14_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:14},{av:'GRID1_nFirstRecordOnPage'},{av:'nRC_GXsfl_14',ctrl:'GRID1',prop:'GridRC',grid:14},{av:'GRID1_nEOF'}]");
      setEventMetadata("'ADDROW'",",oparms:[{av:'AV13SDTCategoryItem',fld:'vSDTCATEGORYITEM',pic:''},{av:'AV12SDTCategory',fld:'vSDTCATEGORY',grid:14,pic:''},{av:'nGXsfl_14_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:14},{av:'GRID1_nFirstRecordOnPage'},{av:'nRC_GXsfl_14',ctrl:'GRID1',prop:'GridRC',grid:14}]}");
      setEventMetadata("GRID1.REFRESH","{handler:'e15262',iparms:[{av:'AV12SDTCategory',fld:'vSDTCATEGORY',grid:14,pic:''},{av:'nGXsfl_14_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:14},{av:'GRID1_nFirstRecordOnPage'},{av:'nRC_GXsfl_14',ctrl:'GRID1',prop:'GridRC',grid:14},{av:'GRID1_nEOF'}]");
      setEventMetadata("GRID1.REFRESH",",oparms:[{av:'AV12SDTCategory',fld:'vSDTCATEGORY',grid:14,pic:''},{av:'nGXsfl_14_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:14},{av:'GRID1_nFirstRecordOnPage'},{av:'nRC_GXsfl_14',ctrl:'GRID1',prop:'GridRC',grid:14}]}");
      setEventMetadata("'UPDATE'","{handler:'e12262',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'AV12SDTCategory',fld:'vSDTCATEGORY',grid:14,pic:''},{av:'nGXsfl_14_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:14},{av:'nRC_GXsfl_14',ctrl:'GRID1',prop:'GridRC',grid:14},{av:'AV11Category',fld:'vCATEGORY',pic:''}]");
      setEventMetadata("'UPDATE'",",oparms:[{av:'AV11Category',fld:'vCATEGORY',pic:''},{av:'A40000CategoryId',fld:'CATEGORYID',pic:'9999'}]}");
      setEventMetadata("'ADD'","{handler:'e13262',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'AV12SDTCategory',fld:'vSDTCATEGORY',grid:14,pic:''},{av:'nGXsfl_14_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:14},{av:'nRC_GXsfl_14',ctrl:'GRID1',prop:'GridRC',grid:14},{av:'AV5Name',fld:'vNAME',pic:''}]");
      setEventMetadata("'ADD'",",oparms:[{av:'AV11Category',fld:'vCATEGORY',pic:''},{av:'AV5Name',fld:'vNAME',pic:''}]}");
      setEventMetadata("NULL","{handler:'validv_Gxv4',iparms:[]");
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
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV12SDTCategory = new GXBaseCollection<com.kbbaru.SdtSDTCategory_SDTCategoryItem>(com.kbbaru.SdtSDTCategory_SDTCategoryItem.class, "SDTCategoryItem", "KBBaru", remoteHandle);
      AV13SDTCategoryItem = new com.kbbaru.SdtSDTCategory_SDTCategoryItem(remoteHandle, context);
      AV11Category = new com.kbbaru.SdtCategory(remoteHandle);
      GX_FocusControl = "" ;
      sPrefix = "" ;
      TempTags = "" ;
      AV5Name = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttAdd_Jsonclick = "" ;
      Grid1Container = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      bttUpdate_Jsonclick = "" ;
      bttAddrow_Jsonclick = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      scmdbuf = "" ;
      H00263_A40000CategoryId = new short[1] ;
      H00263_n40000CategoryId = new boolean[] {false} ;
      GXt_objcol_SdtSDTCategory_SDTCategoryItem1 = new GXBaseCollection<com.kbbaru.SdtSDTCategory_SDTCategoryItem>(com.kbbaru.SdtSDTCategory_SDTCategoryItem.class, "SDTCategoryItem", "KBBaru", remoteHandle);
      H00265_A40000CategoryId = new short[1] ;
      H00265_n40000CategoryId = new boolean[] {false} ;
      Grid1Row = new com.genexus.webpanels.GXWebRow();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGrid1_Linesclass = "" ;
      GXCCtl = "" ;
      ROClassString = "" ;
      Grid1Column = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.kbbaru.categorypanel__default(),
         new Object[] {
             new Object[] {
            H00263_A40000CategoryId, H00263_n40000CategoryId
            }
            , new Object[] {
            H00265_A40000CategoryId, H00265_n40000CategoryId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      initializeGenerics();
   }

   @SuppressWarnings("unchecked")
   private void initializeGenerics( )
   {
      GXv_objcol_SdtSDTCategory_SDTCategoryItem2 = new GXBaseCollection[1] ;
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
   private short A40000CategoryId ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int nRC_GXsfl_14 ;
   private int nGXsfl_14_idx=1 ;
   private int edtavName_Enabled ;
   private int AV16GXV1 ;
   private int subGrid1_Islastpage ;
   private int nGXsfl_14_fel_idx=1 ;
   private int nGXsfl_14_bak_idx=1 ;
   private int idxLst ;
   private int subGrid1_Backcolor ;
   private int subGrid1_Allbackcolor ;
   private int edtavCtlsdtcategoryid_Enabled ;
   private int edtavCtlsdtcategoryid_Visible ;
   private int edtavCtlsdtcategoryname_Enabled ;
   private int edtavCtlsdtcategoryname_Visible ;
   private int subGrid1_Titlebackcolor ;
   private int subGrid1_Selectedindex ;
   private int subGrid1_Selectioncolor ;
   private int subGrid1_Hoveringcolor ;
   private long GRID1_nCurrentRecord ;
   private long GRID1_nFirstRecordOnPage ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_14_idx="0001" ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divMaintable_Internalname ;
   private String edtavName_Internalname ;
   private String TempTags ;
   private String edtavName_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String bttAdd_Internalname ;
   private String bttAdd_Jsonclick ;
   private String sStyleString ;
   private String subGrid1_Internalname ;
   private String bttUpdate_Internalname ;
   private String bttUpdate_Jsonclick ;
   private String bttAddrow_Internalname ;
   private String bttAddrow_Jsonclick ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String scmdbuf ;
   private String sGXsfl_14_fel_idx="0001" ;
   private String edtavCtlsdtcategoryid_Internalname ;
   private String edtavCtlsdtcategoryname_Internalname ;
   private String subGrid1_Class ;
   private String subGrid1_Linesclass ;
   private String GXCCtl ;
   private String ROClassString ;
   private String edtavCtlsdtcategoryid_Jsonclick ;
   private String edtavCtlsdtcategoryname_Jsonclick ;
   private String subGrid1_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_14_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n40000CategoryId ;
   private boolean returnInSub ;
   private boolean gx_BV14 ;
   private String AV5Name ;
   private com.genexus.webpanels.GXWebGrid Grid1Container ;
   private com.genexus.webpanels.GXWebRow Grid1Row ;
   private com.genexus.webpanels.GXWebColumn Grid1Column ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private ICheckbox chkavCtlischeck ;
   private IDataStoreProvider pr_default ;
   private short[] H00263_A40000CategoryId ;
   private boolean[] H00263_n40000CategoryId ;
   private short[] H00265_A40000CategoryId ;
   private boolean[] H00265_n40000CategoryId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.kbbaru.SdtSDTCategory_SDTCategoryItem> AV12SDTCategory ;
   private GXBaseCollection<com.kbbaru.SdtSDTCategory_SDTCategoryItem> GXt_objcol_SdtSDTCategory_SDTCategoryItem1 ;
   private GXBaseCollection<com.kbbaru.SdtSDTCategory_SDTCategoryItem> GXv_objcol_SdtSDTCategory_SDTCategoryItem2[] ;
   private com.kbbaru.SdtCategory AV11Category ;
   private com.kbbaru.SdtSDTCategory_SDTCategoryItem AV13SDTCategoryItem ;
}

final  class categorypanel__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00263", "SELECT COALESCE( T1.CategoryId, 0) AS CategoryId FROM (SELECT MIN(CategoryId) AS CategoryId FROM Category WHERE CategoryId = ? ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00265", "SELECT COALESCE( T1.CategoryId, 0) AS CategoryId FROM (SELECT MIN(CategoryId) AS CategoryId FROM Category WHERE CategoryId = ? ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
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

