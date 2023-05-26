package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class trips_impl extends GXDataArea
{
   public void initenv( )
   {
      if ( GxWebError != 0 )
      {
         return  ;
      }
   }

   public void inittrn( )
   {
      initialize_properties( ) ;
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_3") == 0 )
      {
         A9AttractionsId = (short)(GXutil.lval( httpContext.GetPar( "AttractionsId"))) ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_3( A9AttractionsId) ;
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridtrips_attrations") == 0 )
      {
         gxnrgridtrips_attrations_newrow_invoke( ) ;
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
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 18_0_2-169539", (short)(0)) ;
         }
         Form.getMeta().addItem("description", "Trips", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtTripsId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("KBBaru", true);
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrgridtrips_attrations_newrow_invoke( )
   {
      nRC_GXsfl_53 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_53"))) ;
      nGXsfl_53_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_53_idx"))) ;
      sGXsfl_53_idx = httpContext.GetPar( "sGXsfl_53_idx") ;
      Gx_mode = httpContext.GetPar( "Mode") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridtrips_attrations_newrow( ) ;
      /* End function gxnrGridtrips_attrations_newrow_invoke */
   }

   public trips_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public trips_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( trips_impl.class ));
   }

   public trips_impl( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
   }

   public void webExecute( )
   {
      initenv( ) ;
      inittrn( ) ;
      if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
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

   public void fix_multi_value_controls( )
   {
   }

   public void draw( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! com.kbbaru.GxWebStd.gx_redirect( httpContext) )
      {
         disable_std_buttons( ) ;
         enableDisable( ) ;
         set_caption( ) ;
         /* Form start */
         drawControls( ) ;
         fix_multi_value_controls( ) ;
      }
      /* Execute Exit event if defined. */
   }

   public void drawControls( )
   {
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"none\""+" "+"data-abstract-form"+" ", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, divMaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, divTitlecontainer_Internalname, 1, 0, "px", 0, "px", "title-container", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Text block */
      com.kbbaru.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, "Trips", "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "heading-01", 0, "", 1, 1, 0, (short)(0), "HLP_Trips.htm");
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
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, divFormcontainer_Internalname, 1, 0, "px", 0, "px", "form-container", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, divToolbarcell_Internalname, 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 col-sm-offset-3 form__toolbar-cell", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroup", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "btn-group", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 21,'',false,'',0)\"" ;
      ClassString = "Button button-auxiliary ico__arrow-first" ;
      StyleString = "" ;
      com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "", bttBtn_first_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_first_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Trips.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
      ClassString = "Button button-auxiliary ico__arrow-prev" ;
      StyleString = "" ;
      com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "", bttBtn_previous_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_previous_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Trips.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      ClassString = "Button button-auxiliary ico__arrow-next" ;
      StyleString = "" ;
      com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", "", bttBtn_next_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_next_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Trips.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "Button button-auxiliary ico__arrow-last" ;
      StyleString = "" ;
      com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", "", bttBtn_last_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_last_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Trips.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      ClassString = "Button button-secondary" ;
      StyleString = "" ;
      com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", "Select", bttBtn_select_Jsonclick, 4, "Select", "", StyleString, ClassString, bttBtn_select_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "gx.popup.openPrompt('"+"com.kbbaru.gx00f0"+"',["+"{Ctrl:gx.dom.el('"+"TRIPSID"+"'), id:'"+"TRIPSID"+"'"+",IOType:'out',isKey:true,isLastKey:true}"+"],"+"null"+","+"'', false"+","+"true"+");"+"return false;", 2, "HLP_Trips.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 form__cell-advanced", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTripsId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.kbbaru.GxWebStd.gx_label_element( httpContext, edtTripsId_Internalname, "Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'',0)\"" ;
      com.kbbaru.GxWebStd.gx_single_line_edit( httpContext, edtTripsId_Internalname, GXutil.ltrim( localUtil.ntoc( A25TripsId, (byte)(4), (byte)(0), ".", "")), GXutil.ltrim( ((edtTripsId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A25TripsId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A25TripsId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,',');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,',');"+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTripsId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtTripsId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_Trips.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 form__cell", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTripsDate_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.kbbaru.GxWebStd.gx_label_element( httpContext, edtTripsDate_Internalname, "Date", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtTripsDate_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.kbbaru.GxWebStd.gx_single_line_edit( httpContext, edtTripsDate_Internalname, localUtil.format(A26TripsDate, "99/99/99"), localUtil.format( A26TripsDate, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'MDY',0,12,'eng',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'MDY',0,12,'eng',false,0);"+";gx.evt.onblur(this,39);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTripsDate_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtTripsDate_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Trips.htm");
      com.kbbaru.GxWebStd.gx_bitmap( httpContext, edtTripsDate_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtTripsDate_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Trips.htm");
      httpContext.writeTextNL( "</div>") ;
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 form__cell", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTripsDescription_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.kbbaru.GxWebStd.gx_label_element( httpContext, edtTripsDescription_Internalname, "Description", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.kbbaru.GxWebStd.gx_html_textarea( httpContext, edtTripsDescription_Internalname, A27TripsDescription, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,44);\"", (short)(0), 1, edtTripsDescription_Enabled, 0, 80, "chr", 3, "row", (byte)(0), StyleString, ClassString, "", "", "200", -1, 0, "", "", (byte)(-1), true, "GeneXusUnanimo\\Description", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Trips.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, divAttrationstable_Internalname, 1, 0, "px", 0, "px", "form__table-level", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 form__cell", "left", "top", "", "", "div");
      /* Text block */
      com.kbbaru.GxWebStd.gx_label_ctrl( httpContext, lblTitleattrations_Internalname, "Attrations", "", "", lblTitleattrations_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "heading-04", 0, "", 1, 1, 0, (short)(0), "HLP_Trips.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      gxdraw_gridtrips_attrations( ) ;
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 form__actions--fixed", "Right", "Middle", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroup", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 60,'',false,'',0)\"" ;
      ClassString = "Button button-primary" ;
      StyleString = "" ;
      com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", "Confirm", bttBtn_enter_Jsonclick, 5, "Confirm", "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Trips.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'',false,'',0)\"" ;
      ClassString = "Button button-tertiary" ;
      StyleString = "" ;
      com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", "Cancel", bttBtn_cancel_Jsonclick, 1, "Cancel", "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Trips.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      ClassString = "Button button-tertiary" ;
      StyleString = "" ;
      com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", "Delete", bttBtn_delete_Jsonclick, 5, "Delete", "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Trips.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "Right", "Middle", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
   }

   public void gxdraw_gridtrips_attrations( )
   {
      /*  Grid Control  */
      startgridcontrol53( ) ;
      nGXsfl_53_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount16 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_16 = (short)(1) ;
            scanStart0816( ) ;
            while ( RcdFound16 != 0 )
            {
               init_level_properties16( ) ;
               getByPrimaryKey0816( ) ;
               addRow0816( ) ;
               scanNext0816( ) ;
            }
            scanEnd0816( ) ;
            nBlankRcdCount16 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         standaloneNotModal0816( ) ;
         standaloneModal0816( ) ;
         sMode16 = Gx_mode ;
         while ( nGXsfl_53_idx < nRC_GXsfl_53 )
         {
            bGXsfl_53_Refreshing = true ;
            readRow0816( ) ;
            edtAttractionsId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ATTRACTIONSID_"+sGXsfl_53_idx+"Enabled"), ".", ",")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtAttractionsId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAttractionsId_Enabled), 5, 0), !bGXsfl_53_Refreshing);
            edtAttractionsName_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ATTRACTIONSNAME_"+sGXsfl_53_idx+"Enabled"), ".", ",")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtAttractionsName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAttractionsName_Enabled), 5, 0), !bGXsfl_53_Refreshing);
            imgprompt_9_Link = httpContext.cgiGet( "PROMPT_9_"+sGXsfl_53_idx+"Link") ;
            if ( ( nRcdExists_16 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal0816( ) ;
            }
            sendRow0816( ) ;
            bGXsfl_53_Refreshing = false ;
         }
         Gx_mode = sMode16 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount16 = (short)(5) ;
         nRcdExists_16 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart0816( ) ;
            while ( RcdFound16 != 0 )
            {
               sGXsfl_53_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_53_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_5316( ) ;
               init_level_properties16( ) ;
               standaloneNotModal0816( ) ;
               getByPrimaryKey0816( ) ;
               standaloneModal0816( ) ;
               addRow0816( ) ;
               scanNext0816( ) ;
            }
            scanEnd0816( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      sMode16 = Gx_mode ;
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      sGXsfl_53_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_53_idx+1), 4, 0), (short)(4), "0") ;
      subsflControlProps_5316( ) ;
      initAll0816( ) ;
      init_level_properties16( ) ;
      nRcdExists_16 = (short)(0) ;
      nIsMod_16 = (short)(0) ;
      nRcdDeleted_16 = (short)(0) ;
      nBlankRcdCount16 = (short)(nBlankRcdUsr16+nBlankRcdCount16) ;
      fRowAdded = 0 ;
      while ( nBlankRcdCount16 > 0 )
      {
         standaloneNotModal0816( ) ;
         standaloneModal0816( ) ;
         addRow0816( ) ;
         if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
         {
            fRowAdded = 1 ;
            GX_FocusControl = edtAttractionsId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nBlankRcdCount16 = (short)(nBlankRcdCount16-1) ;
      }
      Gx_mode = sMode16 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridtrips_attrationsContainer"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridtrips_attrations", Gridtrips_attrationsContainer, subGridtrips_attrations_Internalname);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "Gridtrips_attrationsContainerData", Gridtrips_attrationsContainer.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "Gridtrips_attrationsContainerData"+"V", Gridtrips_attrationsContainer.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridtrips_attrationsContainerData"+"V"+"\" value='"+Gridtrips_attrationsContainer.GridValuesHidden()+"'/>") ;
      }
   }

   public void userMain( )
   {
      standaloneStartup( ) ;
   }

   public void userMainFullajax( )
   {
      initenv( ) ;
      inittrn( ) ;
      userMain( ) ;
      draw( ) ;
      sendCloseFormHiddens( ) ;
   }

   public void standaloneStartup( )
   {
      standaloneStartupServer( ) ;
      disable_std_buttons( ) ;
      enableDisable( ) ;
      process( ) ;
   }

   public void standaloneStartupServer( )
   {
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         Z25TripsId = (short)(localUtil.ctol( httpContext.cgiGet( "Z25TripsId"), ".", ",")) ;
         Z26TripsDate = localUtil.ctod( httpContext.cgiGet( "Z26TripsDate"), 0) ;
         Z27TripsDescription = httpContext.cgiGet( "Z27TripsDescription") ;
         IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ".", ",")) ;
         IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ".", ",")) ;
         Gx_mode = httpContext.cgiGet( "Mode") ;
         nRC_GXsfl_53 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_53"), ".", ",")) ;
         /* Read variables values. */
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtTripsId_Internalname), ".", ",") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtTripsId_Internalname), ".", ",") > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "TRIPSID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtTripsId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A25TripsId = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A25TripsId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25TripsId), 4, 0));
         }
         else
         {
            A25TripsId = (short)(localUtil.ctol( httpContext.cgiGet( edtTripsId_Internalname), ".", ",")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A25TripsId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25TripsId), 4, 0));
         }
         if ( localUtil.vcdate( httpContext.cgiGet( edtTripsDate_Internalname), (byte)(2)) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "TRIPSDATE");
            AnyError = (short)(1) ;
            GX_FocusControl = edtTripsDate_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A26TripsDate = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "A26TripsDate", localUtil.format(A26TripsDate, "99/99/99"));
         }
         else
         {
            A26TripsDate = localUtil.ctod( httpContext.cgiGet( edtTripsDate_Internalname), 2) ;
            httpContext.ajax_rsp_assign_attri("", false, "A26TripsDate", localUtil.format(A26TripsDate, "99/99/99"));
         }
         A27TripsDescription = httpContext.cgiGet( edtTripsDescription_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A27TripsDescription", A27TripsDescription);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         /* Check if conditions changed and reset current page numbers */
         standaloneNotModal( ) ;
      }
      else
      {
         standaloneNotModal( ) ;
         if ( GXutil.strcmp(gxfirstwebparm, "viewer") == 0 )
         {
            Gx_mode = "DSP" ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            A25TripsId = (short)(GXutil.lval( httpContext.GetPar( "TripsId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A25TripsId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25TripsId), 4, 0));
            getEqualNoModal( ) ;
            Gx_mode = "DSP" ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            disable_std_buttons_dsp( ) ;
            standaloneModal( ) ;
         }
         else
         {
            Gx_mode = "INS" ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            standaloneModal( ) ;
         }
      }
   }

   public void process( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read Transaction buttons. */
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
                     if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_enter( ) ;
                        /* No code required for Cancel button. It is implemented as the Reset button. */
                     }
                     else if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_first( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "PREVIOUS") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_previous( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_next( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_last( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "SELECT") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_select( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "DELETE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_delete( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        afterkeyloadscreen( ) ;
                     }
                  }
                  else
                  {
                     sEvtType = GXutil.right( sEvt, 4) ;
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                  }
               }
               httpContext.wbHandled = (byte)(1) ;
            }
         }
      }
   }

   public void afterTrn( )
   {
      if ( trnEnded == 1 )
      {
         if ( ! (GXutil.strcmp("", endTrnMsgTxt)==0) )
         {
            httpContext.GX_msglist.addItem(endTrnMsgTxt, endTrnMsgCod, 0, "", true);
         }
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll0815( ) ;
            standaloneNotModal( ) ;
            standaloneModal( ) ;
         }
      }
      endTrnMsgTxt = "" ;
   }

   public String toString( )
   {
      return "" ;
   }

   public GXContentInfo getContentInfo( )
   {
      return (GXContentInfo)(null) ;
   }

   public void disable_std_buttons( )
   {
      if ( isIns( ) )
      {
         bttBtn_delete_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      }
   }

   public void disable_std_buttons_dsp( )
   {
      bttBtn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Visible), 5, 0), true);
      bttBtn_first_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_first_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_first_Visible), 5, 0), true);
      bttBtn_previous_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_previous_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_previous_Visible), 5, 0), true);
      bttBtn_next_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_next_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_next_Visible), 5, 0), true);
      bttBtn_last_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_last_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_last_Visible), 5, 0), true);
      bttBtn_select_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_select_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_select_Visible), 5, 0), true);
      bttBtn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Visible), 5, 0), true);
      if ( isDsp( ) )
      {
         bttBtn_enter_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Visible), 5, 0), true);
      }
      disableAttributes0815( ) ;
   }

   public void set_caption( )
   {
      if ( ( IsConfirmed == 1 ) && ( AnyError == 0 ) )
      {
         if ( isDlt( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_confdelete"), 0, "", true);
         }
         else
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_mustconfirm"), 0, "", true);
         }
      }
   }

   public void confirm_0816( )
   {
      nGXsfl_53_idx = 0 ;
      while ( nGXsfl_53_idx < nRC_GXsfl_53 )
      {
         readRow0816( ) ;
         if ( ( nRcdExists_16 != 0 ) || ( nIsMod_16 != 0 ) )
         {
            getKey0816( ) ;
            if ( ( nRcdExists_16 == 0 ) && ( nRcdDeleted_16 == 0 ) )
            {
               if ( RcdFound16 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate0816( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0816( ) ;
                     closeExtendedTableCursors0816( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "ATTRACTIONSID_" + sGXsfl_53_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtAttractionsId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound16 != 0 )
               {
                  if ( nRcdDeleted_16 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey0816( ) ;
                     load0816( ) ;
                     beforeValidate0816( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0816( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_16 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate0816( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0816( ) ;
                           closeExtendedTableCursors0816( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                              httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                           }
                        }
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_16 == 0 )
                  {
                     GXCCtl = "ATTRACTIONSID_" + sGXsfl_53_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtAttractionsId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtAttractionsId_Internalname, GXutil.ltrim( localUtil.ntoc( A9AttractionsId, (byte)(4), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( edtAttractionsName_Internalname, A10AttractionsName) ;
         httpContext.changePostValue( "ZT_"+"Z9AttractionsId_"+sGXsfl_53_idx, GXutil.ltrim( localUtil.ntoc( Z9AttractionsId, (byte)(4), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( "nRcdDeleted_16_"+sGXsfl_53_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_16, (byte)(4), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( "nRcdExists_16_"+sGXsfl_53_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_16, (byte)(4), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( "nIsMod_16_"+sGXsfl_53_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_16, (byte)(4), (byte)(0), ".", ""))) ;
         if ( nIsMod_16 != 0 )
         {
            httpContext.changePostValue( "ATTRACTIONSID_"+sGXsfl_53_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtAttractionsId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ATTRACTIONSNAME_"+sGXsfl_53_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtAttractionsName_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void resetCaption080( )
   {
   }

   public void zm0815( int GX_JID )
   {
      if ( ( GX_JID == 1 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z26TripsDate = T00086_A26TripsDate[0] ;
            Z27TripsDescription = T00086_A27TripsDescription[0] ;
         }
         else
         {
            Z26TripsDate = A26TripsDate ;
            Z27TripsDescription = A27TripsDescription ;
         }
      }
      if ( GX_JID == -1 )
      {
         Z25TripsId = A25TripsId ;
         Z26TripsDate = A26TripsDate ;
         Z27TripsDescription = A27TripsDescription ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         bttBtn_delete_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      }
      else
      {
         bttBtn_delete_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      }
      if ( GXutil.strcmp(Gx_mode, "DSP") == 0 )
      {
         bttBtn_enter_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      }
      else
      {
         bttBtn_enter_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      }
   }

   public void load0815( )
   {
      /* Using cursor T00087 */
      pr_default.execute(5, new Object[] {Short.valueOf(A25TripsId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound15 = (short)(1) ;
         A26TripsDate = T00087_A26TripsDate[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A26TripsDate", localUtil.format(A26TripsDate, "99/99/99"));
         A27TripsDescription = T00087_A27TripsDescription[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A27TripsDescription", A27TripsDescription);
         zm0815( -1) ;
      }
      pr_default.close(5);
      onLoadActions0815( ) ;
   }

   public void onLoadActions0815( )
   {
   }

   public void checkExtendedTable0815( )
   {
      nIsDirty_15 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
   }

   public void closeExtendedTableCursors0815( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey0815( )
   {
      /* Using cursor T00088 */
      pr_default.execute(6, new Object[] {Short.valueOf(A25TripsId)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         RcdFound15 = (short)(1) ;
      }
      else
      {
         RcdFound15 = (short)(0) ;
      }
      pr_default.close(6);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00086 */
      pr_default.execute(4, new Object[] {Short.valueOf(A25TripsId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         zm0815( 1) ;
         RcdFound15 = (short)(1) ;
         A25TripsId = T00086_A25TripsId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A25TripsId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25TripsId), 4, 0));
         A26TripsDate = T00086_A26TripsDate[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A26TripsDate", localUtil.format(A26TripsDate, "99/99/99"));
         A27TripsDescription = T00086_A27TripsDescription[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A27TripsDescription", A27TripsDescription);
         Z25TripsId = A25TripsId ;
         sMode15 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load0815( ) ;
         if ( AnyError == 1 )
         {
            RcdFound15 = (short)(0) ;
            initializeNonKey0815( ) ;
         }
         Gx_mode = sMode15 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound15 = (short)(0) ;
         initializeNonKey0815( ) ;
         sMode15 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode15 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(4);
   }

   public void getEqualNoModal( )
   {
      getKey0815( ) ;
      if ( RcdFound15 == 0 )
      {
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound15 = (short)(0) ;
      /* Using cursor T00089 */
      pr_default.execute(7, new Object[] {Short.valueOf(A25TripsId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T00089_A25TripsId[0] < A25TripsId ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T00089_A25TripsId[0] > A25TripsId ) ) )
         {
            A25TripsId = T00089_A25TripsId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A25TripsId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25TripsId), 4, 0));
            RcdFound15 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void move_previous( )
   {
      RcdFound15 = (short)(0) ;
      /* Using cursor T000810 */
      pr_default.execute(8, new Object[] {Short.valueOf(A25TripsId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T000810_A25TripsId[0] > A25TripsId ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T000810_A25TripsId[0] < A25TripsId ) ) )
         {
            A25TripsId = T000810_A25TripsId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A25TripsId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25TripsId), 4, 0));
            RcdFound15 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0815( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtTripsId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0815( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound15 == 1 )
         {
            if ( A25TripsId != Z25TripsId )
            {
               A25TripsId = Z25TripsId ;
               httpContext.ajax_rsp_assign_attri("", false, "A25TripsId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25TripsId), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "TRIPSID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtTripsId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtTripsId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               Gx_mode = "UPD" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Update record */
               update0815( ) ;
               GX_FocusControl = edtTripsId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A25TripsId != Z25TripsId )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Insert record */
               GX_FocusControl = edtTripsId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0815( ) ;
               if ( AnyError == 1 )
               {
                  GX_FocusControl = "" ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "TRIPSID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtTripsId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  /* Insert record */
                  GX_FocusControl = edtTripsId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0815( ) ;
                  if ( AnyError == 1 )
                  {
                     GX_FocusControl = "" ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
      afterTrn( ) ;
   }

   public void btn_delete( )
   {
      if ( A25TripsId != Z25TripsId )
      {
         A25TripsId = Z25TripsId ;
         httpContext.ajax_rsp_assign_attri("", false, "A25TripsId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25TripsId), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "TRIPSID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTripsId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtTripsId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         getByPrimaryKey( ) ;
      }
      CloseOpenCursors();
   }

   public void btn_get( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      if ( RcdFound15 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "TRIPSID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTripsId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GX_FocusControl = edtTripsDate_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_first( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart0815( ) ;
      if ( RcdFound15 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtTripsDate_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd0815( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_previous( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      move_previous( ) ;
      if ( RcdFound15 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtTripsDate_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_next( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      move_next( ) ;
      if ( RcdFound15 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtTripsDate_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_last( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart0815( ) ;
      if ( RcdFound15 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound15 != 0 )
         {
            scanNext0815( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtTripsDate_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd0815( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency0815( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00085 */
         pr_default.execute(3, new Object[] {Short.valueOf(A25TripsId)});
         if ( (pr_default.getStatus(3) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Trips"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(3) == 101) || !( GXutil.dateCompare(GXutil.resetTime(Z26TripsDate), GXutil.resetTime(T00085_A26TripsDate[0])) ) || ( GXutil.strcmp(Z27TripsDescription, T00085_A27TripsDescription[0]) != 0 ) )
         {
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z26TripsDate), GXutil.resetTime(T00085_A26TripsDate[0])) ) )
            {
               GXutil.writeLogln("trips:[seudo value changed for attri]"+"TripsDate");
               GXutil.writeLogRaw("Old: ",Z26TripsDate);
               GXutil.writeLogRaw("Current: ",T00085_A26TripsDate[0]);
            }
            if ( GXutil.strcmp(Z27TripsDescription, T00085_A27TripsDescription[0]) != 0 )
            {
               GXutil.writeLogln("trips:[seudo value changed for attri]"+"TripsDescription");
               GXutil.writeLogRaw("Old: ",Z27TripsDescription);
               GXutil.writeLogRaw("Current: ",T00085_A27TripsDescription[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Trips"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0815( )
   {
      beforeValidate0815( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0815( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0815( 0) ;
         checkOptimisticConcurrency0815( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0815( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0815( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000811 */
                  pr_default.execute(9, new Object[] {A26TripsDate, A27TripsDescription});
                  /* Retrieving last key number assigned */
                  /* Using cursor T000812 */
                  pr_default.execute(10);
                  A25TripsId = T000812_A25TripsId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A25TripsId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25TripsId), 4, 0));
                  pr_default.close(10);
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Trips");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel0815( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                           resetCaption080( ) ;
                        }
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load0815( ) ;
         }
         endLevel0815( ) ;
      }
      closeExtendedTableCursors0815( ) ;
   }

   public void update0815( )
   {
      beforeValidate0815( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0815( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0815( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0815( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0815( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000813 */
                  pr_default.execute(11, new Object[] {A26TripsDate, A27TripsDescription, Short.valueOf(A25TripsId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Trips");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Trips"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0815( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel0815( ) ;
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey( ) ;
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                           endTrnMsgCod = "SuccessfullyUpdated" ;
                           resetCaption080( ) ;
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel0815( ) ;
      }
      closeExtendedTableCursors0815( ) ;
   }

   public void deferredUpdate0815( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate0815( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0815( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0815( ) ;
         afterConfirm0815( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0815( ) ;
            if ( AnyError == 0 )
            {
               scanStart0816( ) ;
               while ( RcdFound16 != 0 )
               {
                  getByPrimaryKey0816( ) ;
                  delete0816( ) ;
                  scanNext0816( ) ;
               }
               scanEnd0816( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000814 */
                  pr_default.execute(12, new Object[] {Short.valueOf(A25TripsId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Trips");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( delete) rules */
                     /* End of After( delete) rules */
                     if ( AnyError == 0 )
                     {
                        move_next( ) ;
                        if ( RcdFound15 == 0 )
                        {
                           initAll0815( ) ;
                           Gx_mode = "INS" ;
                           httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        }
                        else
                        {
                           getByPrimaryKey( ) ;
                           Gx_mode = "UPD" ;
                           httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        }
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucdeleted") ;
                        endTrnMsgCod = "SuccessfullyDeleted" ;
                        resetCaption080( ) ;
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
      }
      sMode15 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0815( ) ;
      Gx_mode = sMode15 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0815( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void processNestedLevel0816( )
   {
      nGXsfl_53_idx = 0 ;
      while ( nGXsfl_53_idx < nRC_GXsfl_53 )
      {
         readRow0816( ) ;
         if ( ( nRcdExists_16 != 0 ) || ( nIsMod_16 != 0 ) )
         {
            standaloneNotModal0816( ) ;
            getKey0816( ) ;
            if ( ( nRcdExists_16 == 0 ) && ( nRcdDeleted_16 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert0816( ) ;
            }
            else
            {
               if ( RcdFound16 != 0 )
               {
                  if ( ( nRcdDeleted_16 != 0 ) && ( nRcdExists_16 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete0816( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_16 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update0816( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_16 == 0 )
                  {
                     GXCCtl = "ATTRACTIONSID_" + sGXsfl_53_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtAttractionsId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtAttractionsId_Internalname, GXutil.ltrim( localUtil.ntoc( A9AttractionsId, (byte)(4), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( edtAttractionsName_Internalname, A10AttractionsName) ;
         httpContext.changePostValue( "ZT_"+"Z9AttractionsId_"+sGXsfl_53_idx, GXutil.ltrim( localUtil.ntoc( Z9AttractionsId, (byte)(4), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( "nRcdDeleted_16_"+sGXsfl_53_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_16, (byte)(4), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( "nRcdExists_16_"+sGXsfl_53_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_16, (byte)(4), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( "nIsMod_16_"+sGXsfl_53_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_16, (byte)(4), (byte)(0), ".", ""))) ;
         if ( nIsMod_16 != 0 )
         {
            httpContext.changePostValue( "ATTRACTIONSID_"+sGXsfl_53_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtAttractionsId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ATTRACTIONSNAME_"+sGXsfl_53_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtAttractionsName_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0816( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_16 = (short)(0) ;
      nIsMod_16 = (short)(0) ;
      nRcdDeleted_16 = (short)(0) ;
   }

   public void processLevel0815( )
   {
      /* Save parent mode. */
      sMode15 = Gx_mode ;
      processNestedLevel0816( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode15 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
   }

   public void endLevel0815( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(3);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0815( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "trips");
         if ( AnyError == 0 )
         {
            confirmValues080( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "trips");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0815( )
   {
      /* Using cursor T000815 */
      pr_default.execute(13);
      RcdFound15 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound15 = (short)(1) ;
         A25TripsId = T000815_A25TripsId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A25TripsId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25TripsId), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0815( )
   {
      /* Scan next routine */
      pr_default.readNext(13);
      RcdFound15 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound15 = (short)(1) ;
         A25TripsId = T000815_A25TripsId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A25TripsId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25TripsId), 4, 0));
      }
   }

   public void scanEnd0815( )
   {
      pr_default.close(13);
   }

   public void afterConfirm0815( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0815( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0815( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0815( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0815( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0815( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0815( )
   {
      edtTripsId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTripsId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTripsId_Enabled), 5, 0), true);
      edtTripsDate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTripsDate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTripsDate_Enabled), 5, 0), true);
      edtTripsDescription_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTripsDescription_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTripsDescription_Enabled), 5, 0), true);
   }

   public void zm0816( int GX_JID )
   {
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
         }
         else
         {
         }
      }
      if ( GX_JID == -2 )
      {
         Z25TripsId = A25TripsId ;
         Z9AttractionsId = A9AttractionsId ;
         Z10AttractionsName = A10AttractionsName ;
      }
   }

   public void standaloneNotModal0816( )
   {
   }

   public void standaloneModal0816( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtAttractionsId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtAttractionsId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAttractionsId_Enabled), 5, 0), !bGXsfl_53_Refreshing);
      }
      else
      {
         edtAttractionsId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtAttractionsId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAttractionsId_Enabled), 5, 0), !bGXsfl_53_Refreshing);
      }
   }

   public void load0816( )
   {
      /* Using cursor T000816 */
      pr_default.execute(14, new Object[] {Short.valueOf(A25TripsId), Short.valueOf(A9AttractionsId)});
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound16 = (short)(1) ;
         A10AttractionsName = T000816_A10AttractionsName[0] ;
         zm0816( -2) ;
      }
      pr_default.close(14);
      onLoadActions0816( ) ;
   }

   public void onLoadActions0816( )
   {
   }

   public void checkExtendedTable0816( )
   {
      nIsDirty_16 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal0816( ) ;
      /* Using cursor T00084 */
      pr_default.execute(2, new Object[] {Short.valueOf(A9AttractionsId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         GXCCtl = "ATTRACTIONSID_" + sGXsfl_53_idx ;
         httpContext.GX_msglist.addItem("No matching 'Attractions'.", "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtAttractionsId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A10AttractionsName = T00084_A10AttractionsName[0] ;
      pr_default.close(2);
   }

   public void closeExtendedTableCursors0816( )
   {
      pr_default.close(2);
   }

   public void enableDisable0816( )
   {
   }

   public void gxload_3( short A9AttractionsId )
   {
      /* Using cursor T000817 */
      pr_default.execute(15, new Object[] {Short.valueOf(A9AttractionsId)});
      if ( (pr_default.getStatus(15) == 101) )
      {
         GXCCtl = "ATTRACTIONSID_" + sGXsfl_53_idx ;
         httpContext.GX_msglist.addItem("No matching 'Attractions'.", "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtAttractionsId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A10AttractionsName = T000817_A10AttractionsName[0] ;
      com.kbbaru.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A10AttractionsName)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(15) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(15);
   }

   public void getKey0816( )
   {
      /* Using cursor T000818 */
      pr_default.execute(16, new Object[] {Short.valueOf(A25TripsId), Short.valueOf(A9AttractionsId)});
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound16 = (short)(1) ;
      }
      else
      {
         RcdFound16 = (short)(0) ;
      }
      pr_default.close(16);
   }

   public void getByPrimaryKey0816( )
   {
      /* Using cursor T00083 */
      pr_default.execute(1, new Object[] {Short.valueOf(A25TripsId), Short.valueOf(A9AttractionsId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0816( 2) ;
         RcdFound16 = (short)(1) ;
         initializeNonKey0816( ) ;
         A9AttractionsId = T00083_A9AttractionsId[0] ;
         Z25TripsId = A25TripsId ;
         Z9AttractionsId = A9AttractionsId ;
         sMode16 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal0816( ) ;
         load0816( ) ;
         Gx_mode = sMode16 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound16 = (short)(0) ;
         initializeNonKey0816( ) ;
         sMode16 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal0816( ) ;
         Gx_mode = sMode16 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0816( ) ;
      }
      pr_default.close(1);
   }

   public void checkOptimisticConcurrency0816( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00082 */
         pr_default.execute(0, new Object[] {Short.valueOf(A25TripsId), Short.valueOf(A9AttractionsId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"TripsAttrations"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"TripsAttrations"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0816( )
   {
      beforeValidate0816( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0816( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0816( 0) ;
         checkOptimisticConcurrency0816( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0816( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0816( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000819 */
                  pr_default.execute(17, new Object[] {Short.valueOf(A25TripsId), Short.valueOf(A9AttractionsId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("TripsAttrations");
                  if ( (pr_default.getStatus(17) == 1) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load0816( ) ;
         }
         endLevel0816( ) ;
      }
      closeExtendedTableCursors0816( ) ;
   }

   public void update0816( )
   {
      beforeValidate0816( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0816( ) ;
      }
      if ( ( nIsMod_16 != 0 ) || ( nIsDirty_16 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency0816( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm0816( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate0816( ) ;
                  if ( AnyError == 0 )
                  {
                     /* No attributes to update on table TripsAttrations */
                     deferredUpdate0816( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey0816( ) ;
                        }
                     }
                     else
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                        AnyError = (short)(1) ;
                     }
                  }
               }
            }
            endLevel0816( ) ;
         }
      }
      closeExtendedTableCursors0816( ) ;
   }

   public void deferredUpdate0816( )
   {
   }

   public void delete0816( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate0816( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0816( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0816( ) ;
         afterConfirm0816( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0816( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000820 */
               pr_default.execute(18, new Object[] {Short.valueOf(A25TripsId), Short.valueOf(A9AttractionsId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("TripsAttrations");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode16 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0816( ) ;
      Gx_mode = sMode16 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0816( )
   {
      standaloneModal0816( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T000821 */
         pr_default.execute(19, new Object[] {Short.valueOf(A9AttractionsId)});
         A10AttractionsName = T000821_A10AttractionsName[0] ;
         pr_default.close(19);
      }
   }

   public void endLevel0816( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0816( )
   {
      /* Scan By routine */
      /* Using cursor T000822 */
      pr_default.execute(20, new Object[] {Short.valueOf(A25TripsId)});
      RcdFound16 = (short)(0) ;
      if ( (pr_default.getStatus(20) != 101) )
      {
         RcdFound16 = (short)(1) ;
         A9AttractionsId = T000822_A9AttractionsId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0816( )
   {
      /* Scan next routine */
      pr_default.readNext(20);
      RcdFound16 = (short)(0) ;
      if ( (pr_default.getStatus(20) != 101) )
      {
         RcdFound16 = (short)(1) ;
         A9AttractionsId = T000822_A9AttractionsId[0] ;
      }
   }

   public void scanEnd0816( )
   {
      pr_default.close(20);
   }

   public void afterConfirm0816( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0816( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0816( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0816( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0816( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0816( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0816( )
   {
      edtAttractionsId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAttractionsId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAttractionsId_Enabled), 5, 0), !bGXsfl_53_Refreshing);
      edtAttractionsName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAttractionsName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAttractionsName_Enabled), 5, 0), !bGXsfl_53_Refreshing);
   }

   public void send_integrity_lvl_hashes0816( )
   {
   }

   public void send_integrity_lvl_hashes0815( )
   {
   }

   public void subsflControlProps_5316( )
   {
      edtAttractionsId_Internalname = "ATTRACTIONSID_"+sGXsfl_53_idx ;
      imgprompt_9_Internalname = "PROMPT_9_"+sGXsfl_53_idx ;
      edtAttractionsName_Internalname = "ATTRACTIONSNAME_"+sGXsfl_53_idx ;
   }

   public void subsflControlProps_fel_5316( )
   {
      edtAttractionsId_Internalname = "ATTRACTIONSID_"+sGXsfl_53_fel_idx ;
      imgprompt_9_Internalname = "PROMPT_9_"+sGXsfl_53_fel_idx ;
      edtAttractionsName_Internalname = "ATTRACTIONSNAME_"+sGXsfl_53_fel_idx ;
   }

   public void addRow0816( )
   {
      nGXsfl_53_idx = (int)(nGXsfl_53_idx+1) ;
      sGXsfl_53_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_53_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_5316( ) ;
      sendRow0816( ) ;
   }

   public void sendRow0816( )
   {
      Gridtrips_attrationsRow = GXWebRow.GetNew(context) ;
      if ( subGridtrips_attrations_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridtrips_attrations_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridtrips_attrations_Class, "") != 0 )
         {
            subGridtrips_attrations_Linesclass = subGridtrips_attrations_Class+"Odd" ;
         }
      }
      else if ( subGridtrips_attrations_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridtrips_attrations_Backstyle = (byte)(0) ;
         subGridtrips_attrations_Backcolor = subGridtrips_attrations_Allbackcolor ;
         if ( GXutil.strcmp(subGridtrips_attrations_Class, "") != 0 )
         {
            subGridtrips_attrations_Linesclass = subGridtrips_attrations_Class+"Uniform" ;
         }
      }
      else if ( subGridtrips_attrations_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridtrips_attrations_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridtrips_attrations_Class, "") != 0 )
         {
            subGridtrips_attrations_Linesclass = subGridtrips_attrations_Class+"Odd" ;
         }
         subGridtrips_attrations_Backcolor = (int)(0x0) ;
      }
      else if ( subGridtrips_attrations_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridtrips_attrations_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_53_idx) % (2))) == 0 )
         {
            subGridtrips_attrations_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridtrips_attrations_Class, "") != 0 )
            {
               subGridtrips_attrations_Linesclass = subGridtrips_attrations_Class+"Even" ;
            }
         }
         else
         {
            subGridtrips_attrations_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridtrips_attrations_Class, "") != 0 )
            {
               subGridtrips_attrations_Linesclass = subGridtrips_attrations_Class+"Odd" ;
            }
         }
      }
      imgprompt_9_Link = ((GXutil.strcmp(Gx_mode, "DSP")==0)||(GXutil.strcmp(Gx_mode, "UPD")==0) ? "" : "javascript:"+"gx.popup.openPrompt('"+"com.kbbaru.gx0050"+"',["+"{Ctrl:gx.dom.el('"+"ATTRACTIONSID_"+sGXsfl_53_idx+"'), id:'"+"ATTRACTIONSID_"+sGXsfl_53_idx+"'"+",IOType:'out'}"+"],"+"gx.dom.form()."+"nIsMod_16_"+sGXsfl_53_idx+","+"'', false"+","+"false"+");") ;
      /* * Property Link not supported in */
      /* * Property Link not supported in */
      /* * Property Link not supported in */
      /* * Property Link not supported in */
      /*
         Assignment error:
         ================
         Expression: [ t('iif(',1),t('Gx_mode',23),t(=,10),t('''DSP''',3),t('OR',9),t('Gx_mode',23),t(=,10),t('''UPD''',3),t(',',7),t('""',3),t(',',7),t('"javascript:"',3),t(+,5),t('"gx.popup.openPrompt(''"',3),t(+,5),t('"com.kbbaru.gx00g1"',3),t(+,5),t('"'',["',3),t(+,5),t('"{Ctrl:gx.dom.el(''"',3),t(+,5),t('"TRIPSID"',3),t(+,5),t('"''), id:''"',3),t(+,5),t('"TRIPSID"',3),t(+,5),t('"''"',3),t(+,5),t('",IOType:''in'',isKey:true,isLastKey:true}"',3),t(+,5),t('","',3),t(+,5),t('"{Ctrl:gx.dom.el(''"',3),t(+,5),t('"ATTRACTIONSID_"',3),t(+,5),t(sGXsfl_53_idx,23),t(+,5),t('"''), id:''"',3),t(+,5),t('"ATTRACTIONSID_"',3),t(+,5),t(sGXsfl_53_idx,23),t(+,5),t('"''"',3),t(+,5),t('",IOType:''out''}"',3),t(+,5),t('"],"',3),t(+,5),t('"gx.dom.form()."',3),t(+,5),t('"nIsMod_16_"',3),t(+,5),t(sGXsfl_53_idx,23),t(+,5),t('","',3),t(+,5),t('"'''', false"',3),t(+,5),t('","',3),t(+,5),t('"false"',3),t(+,5),t('");"',3),t(')',4) ]
         Target    : [ t(prompt_25,3),t('Link',3) ]
         ForType   : 29
         Type      : []
      */
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_16_" + sGXsfl_53_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 54,'',false,'" + sGXsfl_53_idx + "',53)\"" ;
      ROClassString = "Attribute" ;
      Gridtrips_attrationsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtAttractionsId_Internalname,GXutil.ltrim( localUtil.ntoc( A9AttractionsId, (byte)(4), (byte)(0), ".", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A9AttractionsId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,',');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,',');"+";gx.evt.onblur(this,54);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtAttractionsId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtAttractionsId_Enabled),Integer.valueOf(1),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(53),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Static images/pictures */
      ClassString = "gx-prompt Image" + " " + ((GXutil.strcmp(imgprompt_9_gximage, "")==0) ? "" : "GX_Image_"+imgprompt_9_gximage+"_Class") ;
      StyleString = "" ;
      sImgUrl = context.getHttpContext().getImagePath( "prompt.gif", "", context.getHttpContext().getTheme( )) ;
      Gridtrips_attrationsRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {imgprompt_9_Internalname,sImgUrl,imgprompt_9_Link,"","",context.getHttpContext().getTheme( ),Integer.valueOf(imgprompt_9_Visible),Integer.valueOf(1),"","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"",Integer.valueOf(0),"",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"","","","","","","",Integer.valueOf(1),Boolean.valueOf(false),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "Attribute" ;
      Gridtrips_attrationsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtAttractionsName_Internalname,A10AttractionsName,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtAttractionsName_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtAttractionsName_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(53),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"Name","left",Boolean.valueOf(true),""});
      httpContext.ajax_sending_grid_row(Gridtrips_attrationsRow);
      send_integrity_lvl_hashes0816( ) ;
      GXCCtl = "Z9AttractionsId_" + sGXsfl_53_idx ;
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z9AttractionsId, (byte)(4), (byte)(0), ".", "")));
      GXCCtl = "nRcdDeleted_16_" + sGXsfl_53_idx ;
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_16, (byte)(4), (byte)(0), ".", "")));
      GXCCtl = "nRcdExists_16_" + sGXsfl_53_idx ;
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_16, (byte)(4), (byte)(0), ".", "")));
      GXCCtl = "nIsMod_16_" + sGXsfl_53_idx ;
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_16, (byte)(4), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "ATTRACTIONSID_"+sGXsfl_53_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtAttractionsId_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "ATTRACTIONSNAME_"+sGXsfl_53_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtAttractionsName_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "PROMPT_9_"+sGXsfl_53_idx+"Link", GXutil.rtrim( imgprompt_9_Link));
      httpContext.ajax_sending_grid_row(null);
      Gridtrips_attrationsContainer.AddRow(Gridtrips_attrationsRow);
   }

   public void readRow0816( )
   {
      nGXsfl_53_idx = (int)(nGXsfl_53_idx+1) ;
      sGXsfl_53_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_53_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_5316( ) ;
      edtAttractionsId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ATTRACTIONSID_"+sGXsfl_53_idx+"Enabled"), ".", ",")) ;
      edtAttractionsName_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ATTRACTIONSNAME_"+sGXsfl_53_idx+"Enabled"), ".", ",")) ;
      imgprompt_9_Link = httpContext.cgiGet( "PROMPT_9_"+sGXsfl_53_idx+"Link") ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtAttractionsId_Internalname), ".", ",") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtAttractionsId_Internalname), ".", ",") > 9999 ) ) )
      {
         GXCCtl = "ATTRACTIONSID_" + sGXsfl_53_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtAttractionsId_Internalname ;
         wbErr = true ;
         A9AttractionsId = (short)(0) ;
      }
      else
      {
         A9AttractionsId = (short)(localUtil.ctol( httpContext.cgiGet( edtAttractionsId_Internalname), ".", ",")) ;
      }
      A10AttractionsName = httpContext.cgiGet( edtAttractionsName_Internalname) ;
      GXCCtl = "Z9AttractionsId_" + sGXsfl_53_idx ;
      Z9AttractionsId = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ".", ",")) ;
      GXCCtl = "nRcdDeleted_16_" + sGXsfl_53_idx ;
      nRcdDeleted_16 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ".", ",")) ;
      GXCCtl = "nRcdExists_16_" + sGXsfl_53_idx ;
      nRcdExists_16 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ".", ",")) ;
      GXCCtl = "nIsMod_16_" + sGXsfl_53_idx ;
      nIsMod_16 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ".", ",")) ;
   }

   public void assign_properties_default( )
   {
      defedtAttractionsId_Enabled = edtAttractionsId_Enabled ;
   }

   public void confirmValues080( )
   {
      nGXsfl_53_idx = 0 ;
      sGXsfl_53_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_53_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_5316( ) ;
      while ( nGXsfl_53_idx < nRC_GXsfl_53 )
      {
         nGXsfl_53_idx = (int)(nGXsfl_53_idx+1) ;
         sGXsfl_53_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_53_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_5316( ) ;
         httpContext.changePostValue( "Z9AttractionsId_"+sGXsfl_53_idx, httpContext.cgiGet( "ZT_"+"Z9AttractionsId_"+sGXsfl_53_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z9AttractionsId_"+sGXsfl_53_idx) ;
      }
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
      MasterPageObj.master_styles();
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
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 2054360), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 2054360), false, true);
      httpContext.AddJavascriptSource("calendar-en.js", "?"+httpContext.getBuildNumber( 2054360), false, true);
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
      httpContext.writeText( "<body ") ;
      bodyStyle = "" + "background-color:" + WebUtils.getHTMLColor( Form.getIBackground()) + ";color:" + WebUtils.getHTMLColor( Form.getTextcolor()) + ";" ;
      bodyStyle += "-moz-opacity:0;opacity:0;" ;
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.kbbaru.trips", new String[] {}, new String[] {}) +"\">") ;
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
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "Z25TripsId", GXutil.ltrim( localUtil.ntoc( Z25TripsId, (byte)(4), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "Z26TripsDate", localUtil.dtoc( Z26TripsDate, 0, "/"));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "Z27TripsDescription", Z27TripsDescription);
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_53", GXutil.ltrim( localUtil.ntoc( nGXsfl_53_idx, (byte)(8), (byte)(0), ".", "")));
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

   public byte executeStartEvent( )
   {
      standaloneStartup( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      return gxajaxcallmode ;
   }

   public void renderHtmlContent( )
   {
      httpContext.writeText( "<div") ;
      com.kbbaru.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
      httpContext.writeText( ">") ;
      draw( ) ;
      httpContext.writeText( "</div>") ;
   }

   public void dispatchEvents( )
   {
      process( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return true ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("com.kbbaru.trips", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "Trips" ;
   }

   public String getPgmdesc( )
   {
      return "Trips" ;
   }

   public void initializeNonKey0815( )
   {
      A26TripsDate = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A26TripsDate", localUtil.format(A26TripsDate, "99/99/99"));
      A27TripsDescription = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A27TripsDescription", A27TripsDescription);
      Z26TripsDate = GXutil.nullDate() ;
      Z27TripsDescription = "" ;
   }

   public void initAll0815( )
   {
      A25TripsId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A25TripsId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25TripsId), 4, 0));
      initializeNonKey0815( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void initializeNonKey0816( )
   {
      A10AttractionsName = "" ;
   }

   public void initAll0816( )
   {
      A9AttractionsId = (short)(0) ;
      initializeNonKey0816( ) ;
   }

   public void standaloneModalInsert0816( )
   {
   }

   public void define_styles( )
   {
      httpContext.AddStyleSheetFile("calendar-system.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2023523155213", true, true);
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
      httpContext.AddJavascriptSource("trips.js", "?2023523155214", false, true);
      /* End function include_jscripts */
   }

   public void init_level_properties16( )
   {
      edtAttractionsId_Enabled = defedtAttractionsId_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtAttractionsId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAttractionsId_Enabled), 5, 0), !bGXsfl_53_Refreshing);
   }

   public void startgridcontrol53( )
   {
      Gridtrips_attrationsContainer.AddObjectProperty("GridName", "Gridtrips_attrations");
      Gridtrips_attrationsContainer.AddObjectProperty("Header", subGridtrips_attrations_Header);
      Gridtrips_attrationsContainer.AddObjectProperty("Class", "Grid");
      Gridtrips_attrationsContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridtrips_attrationsContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridtrips_attrationsContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridtrips_attrations_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridtrips_attrationsContainer.AddObjectProperty("CmpContext", "");
      Gridtrips_attrationsContainer.AddObjectProperty("InMasterPage", "false");
      Gridtrips_attrationsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridtrips_attrationsColumn.AddObjectProperty("Value", WebUtils.htmlEncode( GXutil.ltrim( localUtil.ntoc( A9AttractionsId, (byte)(4), (byte)(0), ".", ""))));
      Gridtrips_attrationsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtAttractionsId_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridtrips_attrationsContainer.AddColumnProperties(Gridtrips_attrationsColumn);
      Gridtrips_attrationsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridtrips_attrationsContainer.AddColumnProperties(Gridtrips_attrationsColumn);
      Gridtrips_attrationsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridtrips_attrationsColumn.AddObjectProperty("Value", WebUtils.htmlEncode( A10AttractionsName));
      Gridtrips_attrationsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtAttractionsName_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridtrips_attrationsContainer.AddColumnProperties(Gridtrips_attrationsColumn);
      Gridtrips_attrationsContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridtrips_attrations_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridtrips_attrationsContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridtrips_attrations_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridtrips_attrationsContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridtrips_attrations_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridtrips_attrationsContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridtrips_attrations_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridtrips_attrationsContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridtrips_attrations_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridtrips_attrationsContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridtrips_attrations_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridtrips_attrationsContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridtrips_attrations_Collapsed, (byte)(1), (byte)(0), ".", "")));
   }

   public void init_default_properties( )
   {
      lblTitle_Internalname = "TITLE" ;
      divTitlecontainer_Internalname = "TITLECONTAINER" ;
      bttBtn_first_Internalname = "BTN_FIRST" ;
      bttBtn_previous_Internalname = "BTN_PREVIOUS" ;
      bttBtn_next_Internalname = "BTN_NEXT" ;
      bttBtn_last_Internalname = "BTN_LAST" ;
      bttBtn_select_Internalname = "BTN_SELECT" ;
      divToolbarcell_Internalname = "TOOLBARCELL" ;
      edtTripsId_Internalname = "TRIPSID" ;
      edtTripsDate_Internalname = "TRIPSDATE" ;
      edtTripsDescription_Internalname = "TRIPSDESCRIPTION" ;
      lblTitleattrations_Internalname = "TITLEATTRATIONS" ;
      edtAttractionsId_Internalname = "ATTRACTIONSID" ;
      edtAttractionsName_Internalname = "ATTRACTIONSNAME" ;
      divAttrationstable_Internalname = "ATTRATIONSTABLE" ;
      divFormcontainer_Internalname = "FORMCONTAINER" ;
      bttBtn_enter_Internalname = "BTN_ENTER" ;
      bttBtn_cancel_Internalname = "BTN_CANCEL" ;
      bttBtn_delete_Internalname = "BTN_DELETE" ;
      divMaintable_Internalname = "MAINTABLE" ;
      Form.setInternalname( "FORM" );
      imgprompt_9_Internalname = "PROMPT_9" ;
      subGridtrips_attrations_Internalname = "GRIDTRIPS_ATTRATIONS" ;
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
      subGridtrips_attrations_Allowcollapsing = (byte)(0) ;
      subGridtrips_attrations_Allowselection = (byte)(0) ;
      subGridtrips_attrations_Header = "" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Trips" );
      edtAttractionsName_Jsonclick = "" ;
      imgprompt_9_Visible = 1 ;
      imgprompt_9_Link = "" ;
      imgprompt_9_Visible = 1 ;
      edtAttractionsId_Jsonclick = "" ;
      subGridtrips_attrations_Class = "Grid" ;
      subGridtrips_attrations_Backcolorstyle = (byte)(0) ;
      edtAttractionsName_Enabled = 0 ;
      edtAttractionsId_Enabled = 1 ;
      bttBtn_delete_Enabled = 1 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      edtTripsDescription_Enabled = 1 ;
      edtTripsDate_Jsonclick = "" ;
      edtTripsDate_Enabled = 1 ;
      edtTripsId_Jsonclick = "" ;
      edtTripsId_Enabled = 1 ;
      bttBtn_select_Visible = 1 ;
      bttBtn_last_Visible = 1 ;
      bttBtn_next_Visible = 1 ;
      bttBtn_previous_Visible = 1 ;
      bttBtn_first_Visible = 1 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxnrgridtrips_attrations_newrow( )
   {
      com.kbbaru.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_5316( ) ;
      while ( nGXsfl_53_idx <= nRC_GXsfl_53 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal0816( ) ;
         standaloneModal0816( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow0816( ) ;
         nGXsfl_53_idx = (int)(nGXsfl_53_idx+1) ;
         sGXsfl_53_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_53_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_5316( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridtrips_attrationsContainer)) ;
      /* End function gxnrGridtrips_attrations_newrow */
   }

   public void init_web_controls( )
   {
      /* End function init_web_controls */
   }

   public void afterkeyloadscreen( )
   {
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      GX_FocusControl = edtTripsDate_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
      /* End function AfterKeyLoadScreen */
   }

   public boolean isIns( )
   {
      return ((GXutil.strcmp(Gx_mode, "INS")==0) ? true : false) ;
   }

   public boolean isDlt( )
   {
      return ((GXutil.strcmp(Gx_mode, "DLT")==0) ? true : false) ;
   }

   public boolean isUpd( )
   {
      return ((GXutil.strcmp(Gx_mode, "UPD")==0) ? true : false) ;
   }

   public boolean isDsp( )
   {
      return ((GXutil.strcmp(Gx_mode, "DSP")==0) ? true : false) ;
   }

   public void valid_Tripsid( )
   {
      httpContext.wbHandled = (byte)(1) ;
      afterkeyloadscreen( ) ;
      draw( ) ;
      send_integrity_footer_hashes( ) ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A26TripsDate", localUtil.format(A26TripsDate, "99/99/99"));
      httpContext.ajax_rsp_assign_attri("", false, "A27TripsDescription", A27TripsDescription);
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", GXutil.rtrim( Gx_mode));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "Z25TripsId", GXutil.ltrim( localUtil.ntoc( Z25TripsId, (byte)(4), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "Z26TripsDate", localUtil.format(Z26TripsDate, "99/99/99"));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "Z27TripsDescription", Z27TripsDescription);
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      sendCloseFormHiddens( ) ;
   }

   public void valid_Attractionsid( )
   {
      /* Using cursor T000821 */
      pr_default.execute(19, new Object[] {Short.valueOf(A9AttractionsId)});
      if ( (pr_default.getStatus(19) == 101) )
      {
         httpContext.GX_msglist.addItem("No matching 'Attractions'.", "ForeignKeyNotFound", 1, "ATTRACTIONSID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtAttractionsId_Internalname ;
      }
      A10AttractionsName = T000821_A10AttractionsName[0] ;
      pr_default.close(19);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A10AttractionsName", A10AttractionsName);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("VALID_TRIPSID","{handler:'valid_Tripsid',iparms:[{av:'A25TripsId',fld:'TRIPSID',pic:'ZZZ9'},{av:'Gx_mode',fld:'vMODE',pic:'@!'}]");
      setEventMetadata("VALID_TRIPSID",",oparms:[{av:'A26TripsDate',fld:'TRIPSDATE',pic:''},{av:'A27TripsDescription',fld:'TRIPSDESCRIPTION',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'Z25TripsId'},{av:'Z26TripsDate'},{av:'Z27TripsDescription'},{ctrl:'BTN_DELETE',prop:'Enabled'},{ctrl:'BTN_ENTER',prop:'Enabled'}]}");
      setEventMetadata("VALID_ATTRACTIONSID","{handler:'valid_Attractionsid',iparms:[{av:'A9AttractionsId',fld:'ATTRACTIONSID',pic:'ZZZ9'},{av:'A10AttractionsName',fld:'ATTRACTIONSNAME',pic:''}]");
      setEventMetadata("VALID_ATTRACTIONSID",",oparms:[{av:'A10AttractionsName',fld:'ATTRACTIONSNAME',pic:''}]}");
      setEventMetadata("NULL","{handler:'valid_Attractionsname',iparms:[]");
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
      pr_default.close(19);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      Z26TripsDate = GXutil.nullDate() ;
      Z27TripsDescription = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      Gx_mode = "" ;
      lblTitle_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      TempTags = "" ;
      bttBtn_first_Jsonclick = "" ;
      bttBtn_previous_Jsonclick = "" ;
      bttBtn_next_Jsonclick = "" ;
      bttBtn_last_Jsonclick = "" ;
      bttBtn_select_Jsonclick = "" ;
      A26TripsDate = GXutil.nullDate() ;
      A27TripsDescription = "" ;
      lblTitleattrations_Jsonclick = "" ;
      bttBtn_enter_Jsonclick = "" ;
      bttBtn_cancel_Jsonclick = "" ;
      bttBtn_delete_Jsonclick = "" ;
      Gridtrips_attrationsContainer = new com.genexus.webpanels.GXWebGrid(context);
      sMode16 = "" ;
      sStyleString = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      GXCCtl = "" ;
      A10AttractionsName = "" ;
      T00087_A25TripsId = new short[1] ;
      T00087_A26TripsDate = new java.util.Date[] {GXutil.nullDate()} ;
      T00087_A27TripsDescription = new String[] {""} ;
      T00088_A25TripsId = new short[1] ;
      T00086_A25TripsId = new short[1] ;
      T00086_A26TripsDate = new java.util.Date[] {GXutil.nullDate()} ;
      T00086_A27TripsDescription = new String[] {""} ;
      sMode15 = "" ;
      T00089_A25TripsId = new short[1] ;
      T000810_A25TripsId = new short[1] ;
      T00085_A25TripsId = new short[1] ;
      T00085_A26TripsDate = new java.util.Date[] {GXutil.nullDate()} ;
      T00085_A27TripsDescription = new String[] {""} ;
      T000812_A25TripsId = new short[1] ;
      T000815_A25TripsId = new short[1] ;
      Z10AttractionsName = "" ;
      T000816_A25TripsId = new short[1] ;
      T000816_A10AttractionsName = new String[] {""} ;
      T000816_A9AttractionsId = new short[1] ;
      T00084_A10AttractionsName = new String[] {""} ;
      T000817_A10AttractionsName = new String[] {""} ;
      T000818_A25TripsId = new short[1] ;
      T000818_A9AttractionsId = new short[1] ;
      T00083_A25TripsId = new short[1] ;
      T00083_A9AttractionsId = new short[1] ;
      T00082_A25TripsId = new short[1] ;
      T00082_A9AttractionsId = new short[1] ;
      T000821_A10AttractionsName = new String[] {""} ;
      T000822_A25TripsId = new short[1] ;
      T000822_A9AttractionsId = new short[1] ;
      Gridtrips_attrationsRow = new com.genexus.webpanels.GXWebRow();
      subGridtrips_attrations_Linesclass = "" ;
      ROClassString = "" ;
      imgprompt_9_gximage = "" ;
      sImgUrl = "" ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      Gridtrips_attrationsColumn = new com.genexus.webpanels.GXWebColumn();
      ZZ26TripsDate = GXutil.nullDate() ;
      ZZ27TripsDescription = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.kbbaru.trips__default(),
         new Object[] {
             new Object[] {
            T00082_A25TripsId, T00082_A9AttractionsId
            }
            , new Object[] {
            T00083_A25TripsId, T00083_A9AttractionsId
            }
            , new Object[] {
            T00084_A10AttractionsName
            }
            , new Object[] {
            T00085_A25TripsId, T00085_A26TripsDate, T00085_A27TripsDescription
            }
            , new Object[] {
            T00086_A25TripsId, T00086_A26TripsDate, T00086_A27TripsDescription
            }
            , new Object[] {
            T00087_A25TripsId, T00087_A26TripsDate, T00087_A27TripsDescription
            }
            , new Object[] {
            T00088_A25TripsId
            }
            , new Object[] {
            T00089_A25TripsId
            }
            , new Object[] {
            T000810_A25TripsId
            }
            , new Object[] {
            }
            , new Object[] {
            T000812_A25TripsId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000815_A25TripsId
            }
            , new Object[] {
            T000816_A25TripsId, T000816_A10AttractionsName, T000816_A9AttractionsId
            }
            , new Object[] {
            T000817_A10AttractionsName
            }
            , new Object[] {
            T000818_A25TripsId, T000818_A9AttractionsId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000821_A10AttractionsName
            }
            , new Object[] {
            T000822_A25TripsId, T000822_A9AttractionsId
            }
         }
      );
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte subGridtrips_attrations_Backcolorstyle ;
   private byte subGridtrips_attrations_Backstyle ;
   private byte gxajaxcallmode ;
   private byte subGridtrips_attrations_Allowselection ;
   private byte subGridtrips_attrations_Allowhovering ;
   private byte subGridtrips_attrations_Allowcollapsing ;
   private byte subGridtrips_attrations_Collapsed ;
   private short nIsMod_16 ;
   private short Z25TripsId ;
   private short Z9AttractionsId ;
   private short nRcdDeleted_16 ;
   private short nRcdExists_16 ;
   private short A9AttractionsId ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A25TripsId ;
   private short nBlankRcdCount16 ;
   private short RcdFound16 ;
   private short nBlankRcdUsr16 ;
   private short RcdFound15 ;
   private short nIsDirty_15 ;
   private short nIsDirty_16 ;
   private short ZZ25TripsId ;
   private int nRC_GXsfl_53 ;
   private int nGXsfl_53_idx=1 ;
   private int trnEnded ;
   private int bttBtn_first_Visible ;
   private int bttBtn_previous_Visible ;
   private int bttBtn_next_Visible ;
   private int bttBtn_last_Visible ;
   private int bttBtn_select_Visible ;
   private int edtTripsId_Enabled ;
   private int edtTripsDate_Enabled ;
   private int edtTripsDescription_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int edtAttractionsId_Enabled ;
   private int edtAttractionsName_Enabled ;
   private int fRowAdded ;
   private int GX_JID ;
   private int subGridtrips_attrations_Backcolor ;
   private int subGridtrips_attrations_Allbackcolor ;
   private int imgprompt_9_Visible ;
   private int defedtAttractionsId_Enabled ;
   private int idxLst ;
   private int subGridtrips_attrations_Selectedindex ;
   private int subGridtrips_attrations_Selectioncolor ;
   private int subGridtrips_attrations_Hoveringcolor ;
   private long GRIDTRIPS_ATTRATIONS_nFirstRecordOnPage ;
   private String sPrefix ;
   private String sGXsfl_53_idx="0001" ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtTripsId_Internalname ;
   private String Gx_mode ;
   private String divMaintable_Internalname ;
   private String divTitlecontainer_Internalname ;
   private String lblTitle_Internalname ;
   private String lblTitle_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String divFormcontainer_Internalname ;
   private String divToolbarcell_Internalname ;
   private String TempTags ;
   private String bttBtn_first_Internalname ;
   private String bttBtn_first_Jsonclick ;
   private String bttBtn_previous_Internalname ;
   private String bttBtn_previous_Jsonclick ;
   private String bttBtn_next_Internalname ;
   private String bttBtn_next_Jsonclick ;
   private String bttBtn_last_Internalname ;
   private String bttBtn_last_Jsonclick ;
   private String bttBtn_select_Internalname ;
   private String bttBtn_select_Jsonclick ;
   private String edtTripsId_Jsonclick ;
   private String edtTripsDate_Internalname ;
   private String edtTripsDate_Jsonclick ;
   private String edtTripsDescription_Internalname ;
   private String divAttrationstable_Internalname ;
   private String lblTitleattrations_Internalname ;
   private String lblTitleattrations_Jsonclick ;
   private String bttBtn_enter_Internalname ;
   private String bttBtn_enter_Jsonclick ;
   private String bttBtn_cancel_Internalname ;
   private String bttBtn_cancel_Jsonclick ;
   private String bttBtn_delete_Internalname ;
   private String bttBtn_delete_Jsonclick ;
   private String sMode16 ;
   private String edtAttractionsId_Internalname ;
   private String edtAttractionsName_Internalname ;
   private String imgprompt_9_Link ;
   private String sStyleString ;
   private String subGridtrips_attrations_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXCCtl ;
   private String sMode15 ;
   private String imgprompt_9_Internalname ;
   private String sGXsfl_53_fel_idx="0001" ;
   private String subGridtrips_attrations_Class ;
   private String subGridtrips_attrations_Linesclass ;
   private String ROClassString ;
   private String edtAttractionsId_Jsonclick ;
   private String imgprompt_9_gximage ;
   private String sImgUrl ;
   private String edtAttractionsName_Jsonclick ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String subGridtrips_attrations_Header ;
   private java.util.Date Z26TripsDate ;
   private java.util.Date A26TripsDate ;
   private java.util.Date ZZ26TripsDate ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean bGXsfl_53_Refreshing=false ;
   private String Z27TripsDescription ;
   private String A27TripsDescription ;
   private String A10AttractionsName ;
   private String Z10AttractionsName ;
   private String ZZ27TripsDescription ;
   private com.genexus.webpanels.GXWebGrid Gridtrips_attrationsContainer ;
   private com.genexus.webpanels.GXWebRow Gridtrips_attrationsRow ;
   private com.genexus.webpanels.GXWebColumn Gridtrips_attrationsColumn ;
   private IDataStoreProvider pr_default ;
   private short[] T00087_A25TripsId ;
   private java.util.Date[] T00087_A26TripsDate ;
   private String[] T00087_A27TripsDescription ;
   private short[] T00088_A25TripsId ;
   private short[] T00086_A25TripsId ;
   private java.util.Date[] T00086_A26TripsDate ;
   private String[] T00086_A27TripsDescription ;
   private short[] T00089_A25TripsId ;
   private short[] T000810_A25TripsId ;
   private short[] T00085_A25TripsId ;
   private java.util.Date[] T00085_A26TripsDate ;
   private String[] T00085_A27TripsDescription ;
   private short[] T000812_A25TripsId ;
   private short[] T000815_A25TripsId ;
   private short[] T000816_A25TripsId ;
   private String[] T000816_A10AttractionsName ;
   private short[] T000816_A9AttractionsId ;
   private String[] T00084_A10AttractionsName ;
   private String[] T000817_A10AttractionsName ;
   private short[] T000818_A25TripsId ;
   private short[] T000818_A9AttractionsId ;
   private short[] T00083_A25TripsId ;
   private short[] T00083_A9AttractionsId ;
   private short[] T00082_A25TripsId ;
   private short[] T00082_A9AttractionsId ;
   private String[] T000821_A10AttractionsName ;
   private short[] T000822_A25TripsId ;
   private short[] T000822_A9AttractionsId ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class trips__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00082", "SELECT TripsId, AttractionsId FROM TripsAttrations WHERE TripsId = ? AND AttractionsId = ?  FOR UPDATE OF TripsAttrations NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00083", "SELECT TripsId, AttractionsId FROM TripsAttrations WHERE TripsId = ? AND AttractionsId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00084", "SELECT AttractionsName FROM Attractions WHERE AttractionsId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00085", "SELECT TripsId, TripsDate, TripsDescription FROM Trips WHERE TripsId = ?  FOR UPDATE OF Trips NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00086", "SELECT TripsId, TripsDate, TripsDescription FROM Trips WHERE TripsId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00087", "SELECT TM1.TripsId, TM1.TripsDate, TM1.TripsDescription FROM Trips TM1 WHERE TM1.TripsId = ? ORDER BY TM1.TripsId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00088", "SELECT TripsId FROM Trips WHERE TripsId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00089", "SELECT TripsId FROM Trips WHERE ( TripsId > ?) ORDER BY TripsId  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000810", "SELECT TripsId FROM Trips WHERE ( TripsId < ?) ORDER BY TripsId DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000811", "SAVEPOINT gxupdate;INSERT INTO Trips(TripsDate, TripsDescription) VALUES(?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T000812", "SELECT currval('TripsId') ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000813", "SAVEPOINT gxupdate;UPDATE Trips SET TripsDate=?, TripsDescription=?  WHERE TripsId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000814", "SAVEPOINT gxupdate;DELETE FROM Trips  WHERE TripsId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T000815", "SELECT TripsId FROM Trips ORDER BY TripsId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000816", "SELECT T1.TripsId, T2.AttractionsName, T1.AttractionsId FROM (TripsAttrations T1 INNER JOIN Attractions T2 ON T2.AttractionsId = T1.AttractionsId) WHERE T1.TripsId = ? and T1.AttractionsId = ? ORDER BY T1.TripsId, T1.AttractionsId ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000817", "SELECT AttractionsName FROM Attractions WHERE AttractionsId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000818", "SELECT TripsId, AttractionsId FROM TripsAttrations WHERE TripsId = ? AND AttractionsId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000819", "SAVEPOINT gxupdate;INSERT INTO TripsAttrations(TripsId, AttractionsId) VALUES(?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000820", "SAVEPOINT gxupdate;DELETE FROM TripsAttrations  WHERE TripsId = ? AND AttractionsId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T000821", "SELECT AttractionsName FROM Attractions WHERE AttractionsId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000822", "SELECT TripsId, AttractionsId FROM TripsAttrations WHERE TripsId = ? ORDER BY TripsId, AttractionsId ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
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
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 8 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 10 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 13 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 14 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 15 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 16 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 19 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 20 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 9 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setVarchar(2, (String)parms[1], 200, false);
               return;
            case 11 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setVarchar(2, (String)parms[1], 200, false);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 12 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 14 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 16 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 17 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 18 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 19 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 20 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

