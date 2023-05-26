package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.kbbaru.mainpanel", "/com.kbbaru.mainpanel"})
public final  class mainpanel extends GXWebObjectStub
{
   public mainpanel( )
   {
   }

   public mainpanel( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( mainpanel.class ));
   }

   public mainpanel( int remoteHandle ,
                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   public static void main( String args[] )
   {
      ApplicationContext.getInstance().setCurrentLocation( "" );
      Application.init(com.kbbaru.GXcfg.class);
      com.kbbaru.mainpanel_impl pgm = new com.kbbaru.mainpanel_impl (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXStaticWebPanel.copyFiles();
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new mainpanel_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new mainpanel_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Main Panel";
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

}

