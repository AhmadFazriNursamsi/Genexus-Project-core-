package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.kbbaru.attractionsattrationswc", "/com.kbbaru.attractionsattrationswc"})
public final  class attractionsattrationswc extends GXWebObjectStub
{
   public attractionsattrationswc( )
   {
   }

   public attractionsattrationswc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( attractionsattrationswc.class ));
   }

   public attractionsattrationswc( int remoteHandle ,
                                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new attractionsattrationswc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new attractionsattrationswc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Attractions Attrations WC";
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

