package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.kbbaru.categorypanel", "/com.kbbaru.categorypanel"})
public final  class categorypanel extends GXWebObjectStub
{
   public categorypanel( )
   {
   }

   public categorypanel( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( categorypanel.class ));
   }

   public categorypanel( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   public static void main( String args[] )
   {
      ApplicationContext.getInstance().setCurrentLocation( "" );
      Application.init(com.kbbaru.GXcfg.class);
      com.kbbaru.categorypanel_impl pgm = new com.kbbaru.categorypanel_impl (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXStaticWebPanel.copyFiles();
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new categorypanel_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new categorypanel_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Category Panel";
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

