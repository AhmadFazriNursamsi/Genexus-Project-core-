package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.kbbaru.viewcountry", "/com.kbbaru.viewcountry"})
public final  class viewcountry extends GXWebObjectStub
{
   public viewcountry( )
   {
   }

   public viewcountry( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( viewcountry.class ));
   }

   public viewcountry( int remoteHandle ,
                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   public static void main( String args[] )
   {
      ApplicationContext.getInstance().setCurrentLocation( "" );
      Application.init(com.kbbaru.GXcfg.class);
      com.kbbaru.viewcountry_impl pgm = new com.kbbaru.viewcountry_impl (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXStaticWebPanel.copyFiles();
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new viewcountry_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new viewcountry_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "View Country";
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

