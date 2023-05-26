package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.kbbaru.countrycitywc", "/com.kbbaru.countrycitywc"})
public final  class countrycitywc extends GXWebObjectStub
{
   public countrycitywc( )
   {
   }

   public countrycitywc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( countrycitywc.class ));
   }

   public countrycitywc( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new countrycitywc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new countrycitywc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Country City WC";
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

